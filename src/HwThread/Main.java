package HwThread;

import Thread.RaceCondition.RaceCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(4);

        ArrayList<Integer> arrayList=new ArrayList<>();



        for (int i = 1; i <=10000 ; i++) {
            arrayList.add(i);
        }
        RaceCondition raceCondition=new RaceCondition(arrayList);
        executorService.execute(raceCondition);



    }
}
