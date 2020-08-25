package leetcode.t11_t20.t14_LongestCommonPrefix;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        int length;
        if (strs == null || (length = strs.length) == 0) {
            return "";
        }

        String ans = strs[0];
        if (ans == null || ans.length() == 0) {
            return "";
        }


        for (int i = 0; i < length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }

            ans = ans.substring(0, j);

            if (j == 0) {
                return "";
            }
        }
        return ans;
    }

}
