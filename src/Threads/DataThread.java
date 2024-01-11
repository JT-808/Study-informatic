package Threads;

import java.util.Date;

public class DataThread implements Runnable {

    public void run() {
        machWas();

    }

    private void machWas() {
        for (int m = 0; m < 20; m++) {
            System.out.println(Thread.currentThread().getName() + " - " + new Date());
            try {
                Thread.sleep((long) (Math.random() * 10000));
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
