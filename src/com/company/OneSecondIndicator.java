package com.company;

/**
 * Created by admin on 06.04.2017.
 */
public class OneSecondIndicator extends Thread {



    public static int timePast;

    private static final int MULTIPLE_OF_5_SECONDS = 5;

    private static final int MULTIPLE_OF_7_SECONDS = 7;


    private Object resources;

    private Object _5SecRes;
    private Object _7SecRes;


    public OneSecondIndicator(Object res)
    {
        resources = res;

        _5SecRes = new Object();
        FiveSecondsIndicator fiveSecondsIndicator = new FiveSecondsIndicator(_5SecRes);
        fiveSecondsIndicator.start();

        _7SecRes = new Object();
        SevenSecondsIndicator sevenSecondsIndicator = new SevenSecondsIndicator(_7SecRes);
        sevenSecondsIndicator.start();
    }


    @Override
    public void run() {
        synchronized (resources)
        {
            while (true)
            {
                try {
                    resources.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                System.out.println("1 second thread, overall time remain: " + timePast);

                if ((timePast % MULTIPLE_OF_5_SECONDS) == 0)
                {
                    FiveSecondsIndicator.wakeUp();
                    FiveSecondsIndicator.timePast = timePast;
                }

                if ((timePast % MULTIPLE_OF_7_SECONDS) == 0)
                {
                    SevenSecondsIndicator.wakeUp();
                    SevenSecondsIndicator.timePast = timePast;
                }
            }
        }

    }





    public void wakeUp()
    {
        synchronized (resources)
        {
            resources.notifyAll();
        }

    }


}
