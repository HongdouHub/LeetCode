package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class StringUtil {
    private StringUtil(){

    }

    public static boolean isBlank(String text) {
        return !isNotBlank(text);
    }

    public static boolean isNotBlank(String text) {
        return text != null && !"".equalsIgnoreCase(text.trim()) && !"null".equalsIgnoreCase(text.trim());
    }

    public static String convertByteArrayToHexString(byte[] b, int size) {
        String ret = " ";
        for (int i = 0; i < size; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    /**
     * 过滤数字
     */
    public static String filterDigital(String str) {
        if (isBlank(str)) {
            return "";
        }
        return str.replaceAll("[1-9]", "");
    }

    /**
     * 是否为纯数字
     */
    public static boolean isDigital(String str) {
        if (isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 是否为纯英文字母
     */
    public static boolean isLetters(String str) {
        if (isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        return pattern.matcher(str).matches();
    }

    public static byte[] string2Bytes(String content, String charsetName) {
        if (content == null || "".equals(content)) {
            return new byte[]{};
        } else {
            try {
                return content.getBytes(charsetName);
            } catch (Exception var3) {
                System.err.println("string2Bytes" + var3);
                return new byte[]{};
            }
        }
    }

    public static Map<String, String> string2Map(String mapString) {
        Map map = new HashMap();
        StringTokenizer entrys = new StringTokenizer(mapString, "^");

        while (entrys.hasMoreTokens()) {
            StringTokenizer items = new StringTokenizer(entrys.nextToken(), "'");
            map.put(items.nextToken(), items.hasMoreTokens() ? items.nextToken() : null);
        }
        return map;
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] aChar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(aChar[pos]) << 4 | toByte(aChar[pos + 1]));
        }
        return result;
    }

    private static int toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static byte getXOR(byte[] bytes) {
        byte xor = 0;
        for (int i = 0; i < bytes.length; i++) {
            xor ^= bytes[i];
        }
        return xor;
    }

    /**
     * byte数组转int
     */
    public static int byteArrayToInt(byte[] bytes) {
        if (bytes == null) {
            return 0;
        }
        if (bytes.length > 4) {
            return 0;
        }
        byte[] temp = new byte[4];
        System.arraycopy(bytes, 0, temp, 4 - bytes.length, bytes.length);
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (temp[i] & 0x000000FF) << shift;
        }
        return value;
    }
}
