package task3_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortClass {

    private static int[] resultArray;
    private final int[] mainArray;
    private final int partSize;

    public SortClass(int[] mainArray, int threadNumber) {
        this.mainArray = mainArray;
        this.partSize = mainArray.length/threadNumber;
    }

    public void sort() {
        List<int[]> massList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < mainArray.length) {
            j = i + partSize;

            int[] massTemp;
            if (mainArray.length >= j) {
                massTemp = Arrays.copyOfRange(mainArray, i, j);
            } else {
                massTemp = Arrays.copyOfRange(mainArray, i, j - 1);
            }
            massList.add(massTemp);
            Thread thread = new SortThread(massTemp);
            threads.add(thread);
            thread.start();            
            i = j;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

        for (int n = 0; n < massList.size(); n++) {
            merge(massList.get(n), n);
        }
    }

    public int[] getResultArray() {
        return resultArray;
    }

    private void merge(int[] mas, int n) {

        if (n == 0) {
            resultArray = mas;
        } else {
            int[] arrayA = resultArray;
            int[] arrayB = mas;

            int sizeA = arrayA.length;
            int sizeB = arrayB.length;
            int[] arrayC = new int[sizeA + sizeB];

            int aDex = 0, bDex = 0, cDex = 0;

            while (aDex < sizeA && bDex < sizeB) {
                if (arrayA[aDex] < arrayB[bDex]) {
                    arrayC[cDex++] = arrayA[aDex++];
                } else {
                    arrayC[cDex++] = arrayB[bDex++];
                }
            }
            while (aDex < sizeA) {
                arrayC[cDex++] = arrayA[aDex++];
            }
            while (bDex < sizeB) {
                arrayC[cDex++] = arrayB[bDex++];
            }
            resultArray = arrayC;
        }
    }

}
