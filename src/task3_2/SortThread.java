package task3_2;

import java.util.Arrays;

public class SortThread extends Thread {

    int[] mass;    

    public SortThread(int[] mass) {
        this.mass = mass;
    }

    @Override
    public void run() {        
        Arrays.sort(mass);
    }


}
