package leetcode.preparation;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class MethodBuilder {

    private Class clazz;

    private Object object;

    private String methodName;

    private Class<?>[] parameterTypes;

    public Object invoke(Object... parameters) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);

            if (object != null) {
                return method.invoke(object, parameters);
            }
            return method.invoke(clazz, parameters);
        } catch (Exception e) {
            return e;
        }
    }

    public MethodBuilder(Builder builder) {
        this.clazz = builder.clazz;
        this.object = builder.object;
        this.methodName = builder.methodName;
        this.parameterTypes = builder.parameterTypes;
    }

    public static final class Builder {
        private Class clazz;
        private Object object;
        private String methodName;
        private Class<?>[] parameterTypes;

        public Builder setClazz(Class clazz) {
            this.clazz = clazz;
            return this;
        }

        public Builder setObject(Object object) {
            this.object = object;
            return this;
        }

        public Builder setMethodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder setParameterTypes(Class... parameterTypes) {
            this.parameterTypes = parameterTypes;
            return this;
        }

        public MethodBuilder build() {
            return new MethodBuilder(this);
        }
    }
}
