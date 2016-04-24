package task3_2;

public class Util {

    public static String msTime(long time) {
        return (double) time / 1000000 + " ms";
    }

    public static void print(int[] array) {
        int i = 0;
        for (int numeric : array) {
            System.out.println(i++ + " : " + numeric);
        }
        System.out.println();
    }
}
