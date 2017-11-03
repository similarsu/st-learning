package cn.st.learning.thread.stat;

import cn.st.learning.thread.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by coolearth on 17-11-3.
 */
public class ThreadStat {
    public static void main(String[] args) {
        new Thread(new TimeWait(),"TimeWait thread").start();
        new Thread(new Wait(),"Wait thread").start();
        new Thread(new Blocked(),"Blocked-1 thread").start();
        new Thread(new Blocked(),"Blocked-2 thread").start();
    }

    static class TimeWait implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.sleep(10);
            }
        }
    }

    static class Wait implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (Wait.class){
                    try {
                        Wait.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class Blocked implements Runnable{

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true){
                    SleepUtils.sleep(100);
                }
            }
        }
    }

}


