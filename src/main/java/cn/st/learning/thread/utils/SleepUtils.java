package cn.st.learning.thread.utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils{
    public final static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}