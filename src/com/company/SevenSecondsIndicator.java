package com.company;

/**
 * Created by admin on 06.04.2017.
 */
public class SevenSecondsIndicator extends Thread  {

    public static int timePast = 0;


    private static Object resources;


    public SevenSecondsIndicator(Object res)
    {
        resources = res;
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

                System.out.println("7 seconds thread, overall time remain: " + timePast);
            }
        }




    }


    public static void wakeUp()
    {
        synchronized (resources)
        {
            resources.notifyAll();
        }
    }
}
