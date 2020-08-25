package utils;

import java.io.*;

public class FileOpenUtils {

    private FileOpenUtils() {
        //
    }

//    public static String readFile(String pathName) {
//        StringBuilder data = new StringBuilder();
//        ObjectInputStream objectInputStream = null;
//        BufferedReader reader = null;
//
//        try {
//            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pathName)));
//            Object object = objectInputStream.readObject();
//
//            reader = new BufferedReader(new FileReader(pathName));
//            String temp;
//            while ((temp = reader.readLine()) != null) {
//                data.append(temp);
//            }
//        } catch (Exception e) {
//            System.err.println("FileOpenUtils readFile Exception:" + e);
//        } finally {
//            ClosableUtils.close(reader);
//        }
//        return data.toString();
//    }
//
//    public static void writeFile(String pathName, String object) {
//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathName, true)));
//            writer.write(object);
//        } catch (Exception e) {
//            System.err.println("FileOpenUtils writeFile Exception:" + e);
//        } finally {
//            ClosableUtils.close(writer);
//        }
//    }


    public static String readFile(String pathName) {
        StringBuilder data = new StringBuilder();
        BufferedReader reader = null;

        File file = new File(pathName);
        if (file.exists()) {
            try {
                reader = new BufferedReader(new FileReader(pathName));
                String temp;
                while ((temp = reader.readLine()) != null) {
                    data.append(temp);
                }
            } catch (Exception e) {
                System.err.println("FileOpenUtils readFile Exception:" + e);
            } finally {
                ClosableUtils.close(reader);
            }
        }
        return data.toString();
    }

    public static void writeFile(String pathName, String object) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathName, false)));
            writer.write(object);
        } catch (Exception e) {
            System.err.println("FileOpenUtils writeFile Exception:" + e);
        } finally {
            ClosableUtils.close(writer);
        }
    }

}
