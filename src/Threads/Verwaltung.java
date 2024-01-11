package Threads;

import java.util.ArrayList;

public class Verwaltung {

    public static void main(String[] args) {

        Thread tA = new Thread(new DataThread());

        Thread tB = new Thread(new DataThread());

        tA.start();
        tB.start();

        // Start greift automatisch auf die run() zu (siehe Datathread.java)

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            threads.add(new Thread(new DataThread()));

        }
        for (Thread thread : threads) {
            thread.start();
        }

    }

}
