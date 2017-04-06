package com.company;

import sun.misc.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    // Common time
    public static int pastTime = 0;

    // 1 second in milliseconds.
    private static final int SECOND_IN_MS = 1000;



    private static final Object resources = new Object();


    public static void main(String[] args) {



        OneSecondIndicator oneSecondIndicator = new OneSecondIndicator(resources);
        oneSecondIndicator.start();




        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {

                pastTime += SECOND_IN_MS;




                OneSecondIndicator.timePast = pastTime / 1000;
                oneSecondIndicator.wakeUp();

//                if ((pastTime % MULTIPLE_OF_5_SECONDS) == 0)
//                {
//                    FiveSecondsIndicator.timePast = pastTime / 1000;
//                    fiveSecondsIndicator.weakUp();
//                }


//                OneSecondIndicator.timePast = pastTime / 1000;
//                new OneSecondIndicator().start();
//
//                if ((pastTime % MULTIPLE_OF_5_SECONDS) == 0)
//                {
//                    FiveSecondsIndicator.timePast = pastTime / 1000;
//                    new FiveSecondsIndicator().start();
//                }
            }
        };

        Timer timer = new Timer("MyTimer");//create a new Timer

        // Run every second.
        timer.scheduleAtFixedRate(timerTask, 0, 1000);



    }
}
