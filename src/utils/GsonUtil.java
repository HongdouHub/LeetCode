package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class GsonUtil {

    private GsonUtil() {

    }

    private static final Gson mGson = new GsonBuilder().create();

    public static <T> T json2Bean(String result, Class<T> clazz) {
        try {
            T t = mGson.fromJson(result, clazz);
            return t;
        } catch (Exception e) {
            System.err.println("json2Bean exception =" + e);
            return null;
        }
    }

    public static String bean2Json(Object obj) {
        return mGson.toJson(obj);
    }

    public static <T> T obj2Bean(Object obj, Class<T> clazz) {
        String str;
        try {
            if (obj instanceof String) {
                str = obj.toString();
            } else {
                str = mGson.toJson(obj);
            }
            return mGson.fromJson(str, clazz);
        } catch (Exception e) {
            System.err.println("obj2Bean exception: " + e);
            return null;
        }
    }

    public static <T> String array2Json(List<T> lists) {
        Type listType = new TypeToken<List<T>>() {
        }.getType();
        return mGson.toJson(lists, listType);
    }

    public static <T> List<T> json2Array(String result, TypeToken<List<T>> typeToken) {
        List<T> listResult;
        try {
            listResult = mGson.fromJson(result, typeToken.getType());
        } catch (JsonSyntaxException e) {
            System.err.println("json2Array exception: " + e);
            listResult = null;
        }
        return listResult;
    }

    public static <T> List<T> obj2Array(Object result, TypeToken<List<T>> typeToken) {
        String str = mGson.toJson(result);
        List<T> list;
        try {
            list = mGson.fromJson(str, typeToken.getType());
        } catch (JsonSyntaxException e) {
            System.err.println("obj2Array exception: " + e);
            list = null;
        }
        return list;
    }

    public static Map<String, Object> json2Map(String result) {
        Map<String, Object> mapResult;
        try {
            mapResult = mGson.fromJson(result, Map.class);
        } catch (JsonSyntaxException e) {
            System.err.println("json2Map exception: " + e);
            mapResult = null;
        }
        return mapResult;
    }

    public static String map2Json(Map<String, Object> result) {
        return mGson.toJson(result);
    }

}
