package leetcode.t201_250.t242_ValidAnagram;

/**
 * 有效的字母异位词
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String begin = "anagram";
        String end = "nagaram";

        System.out.println(isAnagram(begin, end));
    }

    private static boolean isAnagram(String begin, String end) {
        int length;
        if ((length = begin.length()) != end.length()) {
            return false;
        }

        int[] alpha = new int[58];
        for (int i = 0; i < length; i++) {
            alpha[begin.charAt(i) - 'a']++;
            alpha[end.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 58; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
