package leetcode.t201_250.t204_CountPrimes;

import utils.GsonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<MyBean> list = new ArrayList<MyBean>();
        MyBean b = new MyBean(50);
        list.add(new MyBean(50));
        list.add(new MyBean(50));
        list.add(new MyBean(50));
        list.add(new MyBean(50));

        System.out.println(GsonUtil.array2Json(list));
        System.out.println("-----");

        Collections.fill(list, new MyBean(10));
        System.out.println(GsonUtil.array2Json(list));
        System.out.println("-----");

        MyBean myBean = list.get(0);
        myBean.value = 20;
        System.out.println(GsonUtil.array2Json(list));
    }

    private static class MyBean {
        int value;

        MyBean(int value) {
            this.value = value;
        }
    }
    
}
