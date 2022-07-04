package Thread.RaceCondition;

import java.util.ArrayList;

public class RaceCondition implements Runnable {

    ArrayList<Integer> even=new ArrayList<>();
    ArrayList<Integer> odd=new ArrayList<>();
    ArrayList<Integer> common=new ArrayList<>();

    public RaceCondition(ArrayList<Integer> common) {
        this.common = common;
    }

    @Override
    public void run() {
        for (int i = 0; i < common.size(); i++) {
            if(i%2==0)
                even.add(i);
            else
                odd.add(i);
        }
        printArray(even);
        printArray(odd);
    }



    public synchronized void printArray(ArrayList<Integer> numbers){
        System.out.println(numbers.toString());
    }
}
