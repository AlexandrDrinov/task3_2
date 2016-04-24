package task3_2;

import java.util.Arrays;
import java.util.Random;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        final int ARRAY_SIZE = 50000;
        final int RANDOM_RANGE = 1000;
        final int THREAD_NUNMER = 4;

        int[] mainArray = randomGenerate(ARRAY_SIZE, RANDOM_RANGE);       

        SortClass sortClass = new SortClass(mainArray, THREAD_NUNMER);
        long start1 = System.nanoTime();
        sortClass.sort();
        long end1 = System.nanoTime();   
        System.out.println("My sort variant " + Util.msTime(end1 - start1));
        
        System.out.println();
        
        long start2 = System.nanoTime();
        Arrays.parallelSort(mainArray);
        long end2 = System.nanoTime();        
        System.out.println("Default parallel sort " + Util.msTime(end2 - start2));
        
        System.out.println();
        
        long start3 = System.nanoTime();
        Arrays.sort(mainArray);
        long end3 = System.nanoTime();       
        System.out.println("Default sort " + Util.msTime(end3 - start3));
    }

    private static int[] randomGenerate(int size, int range) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

}
