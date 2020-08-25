package leetcode.preparation.array;

import static leetcode.preparation.array.ConsoleColors.RESET;
import static leetcode.preparation.array.ConsoleColors.YELLOW_BACKGROUND_BRIGHT;

public class PrepareArray {

    public static void print(int[] array) {
        if (array == null) {
            return;
        }

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("\n---------------------\n");
    }

    public static void main(String[] args) {
        print(new int[][]{new int[]{12,222,3}, new int[]{4,5,6}, new int[]{7,8,9}});
    }

    public static void print(int[][] array) {
        if (array == null) {
            return;
        }

        int length = array.length;
        int childLength = array[0].length;

        for (int i = 0; i < length + 1; i++) {
            if (i == 0) {
                System.out.print(YELLOW_BACKGROUND_BRIGHT + "   　　|" + RESET);
            }

            for (int j = 0; j < childLength + 1; j++) {
                if (i == 0) {
                    if (j != childLength) {
                        System.out.print(YELLOW_BACKGROUND_BRIGHT + String.format(" %3s |", "【" + j + "】") + RESET);
                    }
                } else {
                    if (j == 0) {
                        System.out.print(YELLOW_BACKGROUND_BRIGHT + String.format(" %3s |", "【" + (i - 1) + "】") + RESET);
                    } else {
                        System.out.print(String.format("　%3d　|", array[i - 1][j - 1]));
                    }
                }

                if (j == childLength) {
                    System.out.println();
                }
            }
        }
        System.out.println("\n---------------------\n");
    }

    public static void print(char[][] array) {
        if (array == null) {
            return;
        }

        int length = array.length;
        int childLength = array[0].length;

        for (int i = 0; i < length + 1; i++) {
            if (i == 0) {
                System.out.print(YELLOW_BACKGROUND_BRIGHT + "   　　|" + RESET);
            }

            for (int j = 0; j < childLength + 1; j++) {
                if (i == 0) {
                    if (j != childLength) {
                        System.out.print(YELLOW_BACKGROUND_BRIGHT + String.format(" %3s |", "【" + j + "】") + RESET);
                    }
                } else {
                    if (j == 0) {
                        System.out.print(YELLOW_BACKGROUND_BRIGHT + String.format(" %3s |", "【" + (i - 1) + "】") + RESET);
                    } else {
                        System.out.print(String.format("　%3c　|", array[i - 1][j - 1]));
                    }
                }

                if (j == childLength) {
                    System.out.println();
                }
            }
        }
        System.out.println("\n---------------------\n");
    }

    public static void print(boolean[][] array) {
        if (array == null) {
            return;
        }

        int length = array.length;
        int childLength = array[0].length;

        for (int i = 0; i < length + 1; i++) {
            if (i == 0) {
                System.out.print(YELLOW_BACKGROUND_BRIGHT + "   　　|" + RESET);
            }

            for (int j = 0; j < childLength + 1; j++) {
                if (i == 0) {
                    if (j != childLength) {
                        System.out.print(YELLOW_BACKGROUND_BRIGHT + String.format(" %3s |", "【" + j + "】") + RESET);
                    }
                } else {
                    if (j == 0) {
                        System.out.print(YELLOW_BACKGROUND_BRIGHT + String.format(" %3s |", "【" + (i - 1) + "】") + RESET);
                    } else {
                        System.out.print(String.format("　%3s　|", array[i - 1][j - 1] ? "√":"×"));
                    }
                }

                if (j == childLength) {
                    System.out.println();
                }
            }
        }
        System.out.println("\n---------------------\n");
    }
}
