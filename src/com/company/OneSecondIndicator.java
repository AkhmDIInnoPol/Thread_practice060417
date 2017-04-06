package com.company;

/**
 * Created by admin on 06.04.2017.
 */
public class OneSecondIndicator extends Thread {



    public static int timePast;





    @Override
    public void run() {
        System.out.println("1 second thread, overall time remain: " + timePast);
    }




}
