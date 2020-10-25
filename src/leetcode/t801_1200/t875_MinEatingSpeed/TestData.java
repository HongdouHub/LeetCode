package leetcode.t801_1200.t875_MinEatingSpeed;

import com.google.gson.reflect.TypeToken;
import utils.FileOpenUtils;
import utils.GsonUtil;

import java.util.List;

public class TestData {

    static int[] TEST_DATA = TestDataHolder.getTestData();

    private static class TestDataHolder {

        private static String getFileData(String path) {
            return FileOpenUtils.readFile(path);
        }

        private static int[] getTestData() {
            String path = "D:\\IntelliJ IDEA\\Work_Java_Study\\unit\\Test2019\\src\\leetcode\\t875_MinEatingSpeed\\TEST_DATA";
            String data = getFileData(path);
            List<Integer> list = GsonUtil.json2Array(data, new TypeToken<List<Integer>>() {
            });
            return list.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

}
