package cn.st.learning.thread.daemon;

import cn.st.learning.thread.utils.SleepUtils;

/**
 * Created by coolearth on 17-11-3.
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        Thread thread=new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                SleepUtils.sleep(1);
            }finally {
                System.out.println("DaemonThread finally run.");
            }

        }
    }
}
