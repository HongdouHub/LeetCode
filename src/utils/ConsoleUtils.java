package utils;

import java.util.List;

public class ConsoleUtils {
    
    private ConsoleUtils() {
        //
    }

    public static void print(boolean b) {
        System.out.print(b);
    }
    public static void print(char b) {
        System.out.print(b);
    }
    public static void print(int b) {
        System.out.print(b);
    }
    public static void print(long b) {
        System.out.print(b);
    }
    public static void print(float b) {
        System.out.print(b);
    }
    public static void print(double b) {
        System.out.print(b);
    }
    public static void print(char[] s) {
        System.out.print(s);
    }
    public static void print(String s) {
        System.out.print(s);
    }
    public static <T> void print(List<T> list) {
        System.out.print(GsonUtil.array2Json(list));
    }
    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println() {
        System.out.println();
    }
    public static void println(boolean b) {
        System.out.println(b);
    }
    public static void println(char b) {
        System.out.println(b);
    }
    public static void println(int b) {
        System.out.println(b);
    }
    public static void println(long b) {
        System.out.println(b);
    }
    public static void println(float b) {
        System.out.println(b);
    }
    public static void println(double b) {
        System.out.println(b);
    }
    public static void println(char[] s) {
        System.out.println(s);
    }
    public static void println(String s) {
        System.out.println(s);
    }
    public static <T> void println(List<T> list) {
        System.out.println(GsonUtil.array2Json(list));
    }
    public static void println(Object x) {
        System.out.println(x);
    }
}
