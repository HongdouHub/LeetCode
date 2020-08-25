package utils;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.*;

public class ThreadPoolManager {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;//核心线程数
    private static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1;//最大线程数

    private ThreadPoolExecutor threadPool;
    private static ThreadPoolManager instance;
    private Map<String, List<WeakReference<Future<?>>>> taskMap;

    public ThreadPoolManager() {
        threadPool = (ThreadPoolExecutor) Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        taskMap = new WeakHashMap<>();
    }

    public static ThreadPoolManager getInstance() {
        if (instance == null) {
            synchronized (ThreadPoolManager.class) {
                if (instance == null) {
                    instance = new ThreadPoolManager();
                }
            }
        }
        return instance;
    }

    public void shutdownNow() {
        cancelAllTasks();
        threadPool.shutdownNow();
        instance = null;
    }

    /**
     * 立马执行任务
     *
     * @param runnable
     * @param tag      线程tag，可用于取消该任务
     */
    public ScheduledFuture schedule(Runnable runnable, String tag) {
        return scheduleDelay(runnable, tag, 0, TimeUnit.SECONDS);
    }

    /**
     * 延时执行任务
     *
     * @param runnable
     * @param tag      线程tag，可用于取消该任务
     * @param delay
     * @param unit
     */
    public ScheduledFuture scheduleDelay(Runnable runnable, String tag, long delay, TimeUnit unit) {
        ExRunnable exRunnable = new ExRunnable(runnable, tag);
        ScheduledFuture<?> request = ((ScheduledExecutorService) threadPool).schedule(exRunnable, delay, unit);
        WeakReference<Future<?>> futureWeakRef = addTask(request, tag);
        exRunnable.setRequestFuture(futureWeakRef);
        return request;
    }


    private class ExRunnable implements Runnable {
        private Runnable mRunable;
        private String mTag;
        private WeakReference<Future<?>> mFutureWeakRef;

        public ExRunnable(Runnable run, String tag) {
            mRunable = run;
            mTag = tag;
        }

        public void run() {
            if (mRunable != null) {
                mRunable.run();
            }

            removeFuture(mTag, mFutureWeakRef);
        }

        private synchronized void removeFuture(String tag, WeakReference<Future<?>> futureWeakRef) {
            List<WeakReference<Future<?>>> requestList = taskMap.get(tag);
            if (requestList != null && futureWeakRef != null) {
                requestList.remove(futureWeakRef);
            }
        }

        public void setRequestFuture(WeakReference<Future<?>> futureWeakRef) {
            mFutureWeakRef = futureWeakRef;
        }
    }

    /**
     * 延时开始周期执行任务
     *
     * @param runnable
     * @param tag      线程tag，可用于取消该任务
     * @param delay
     * @param period
     * @param unit
     */
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, String tag,
                                    long delay, long period, TimeUnit unit) {
        ScheduledFuture<?> request = ((ScheduledExecutorService) threadPool).scheduleAtFixedRate(
                runnable, delay, period, unit);
        addTask(request, tag);
        return request;
    }

    /**
     * 添加任务
     *
     * @param request
     * @param tag     线程tag，可用于取消该任务
     */
    private WeakReference<Future<?>> addTask(Future<?> request, String tag) {
        WeakReference<Future<?>> requestFutureRef = null;
        synchronized (ThreadPoolManager.class) {
            if (tag != null) {
                List<WeakReference<Future<?>>> requestList = taskMap.get(tag);
                if (requestList == null) {
                    requestList = new LinkedList<>();
                    taskMap.put(tag, requestList);
                }
                requestFutureRef = new WeakReference<Future<?>>(request);
                requestList.add(requestFutureRef);
            }
        }
        return requestFutureRef;
    }

    /**
     * 取消任务
     *
     * @param tag                   线程tag，可用于取消该任务
     * @param mayInterruptIfRunning 是否允许终止该任务
     */
    public void cancelTask(String tag, boolean mayInterruptIfRunning) {
        synchronized (ThreadPoolManager.class) {
            List<WeakReference<Future<?>>> requestList = taskMap.get(tag);
            if (requestList != null) {
                for (WeakReference<Future<?>> requestRef : requestList) {
                    Future<?> request = requestRef.get();
                    if (request != null) {
                        request.cancel(mayInterruptIfRunning);
                    }
                }
            }
            taskMap.remove(tag);
        }
    }

    /**
     * 取消所有任务
     */
    public void cancelAllTasks() {
        for (Map.Entry<String, List<WeakReference<Future<?>>>> entry : taskMap.entrySet()) {
            List<WeakReference<Future<?>>> requestList = entry.getValue();
            if (requestList != null) {
                for (WeakReference<Future<?>> requestRef : requestList) {
                    Future<?> request = requestRef.get();
                    if (request != null) {
                        request.cancel(true);
                    }
                }
            }
        }
        taskMap.clear();
    }
}
