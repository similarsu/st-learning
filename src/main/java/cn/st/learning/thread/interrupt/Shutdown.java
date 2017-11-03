package cn.st.learning.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by coolearth on 17-11-3.
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one=new Runner();
        Thread thread=new Thread(one,"countThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        Runner two=new Runner();
        thread=new Thread(two,"countThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    static class Runner implements Runnable {
        private long i;
        private volatile boolean on=true;
        @Override
        public void run() {
            while (on &&! Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i="+i);
        }

        public void cancel() {
            on=false;
        }
    }
}
