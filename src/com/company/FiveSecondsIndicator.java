package com.company;

/**
 * Created by admin on 06.04.2017.
 */
public class FiveSecondsIndicator extends Thread {

    public static int timePast = 0;





    @Override
    public void run() {
        System.out.println("5 seconds thread, overall time remain: " + timePast);
    }
}
