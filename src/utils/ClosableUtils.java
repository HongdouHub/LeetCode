package utils;

import java.io.Closeable;
import java.io.IOException;

public class ClosableUtils {

    private ClosableUtils() {
        //
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                System.err.println("ClosableUtils close Exception:" + e);
            }
        }
    }

}
