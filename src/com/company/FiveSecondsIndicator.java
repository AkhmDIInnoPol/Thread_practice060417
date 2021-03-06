package com.company;

/**
 * Created by admin on 06.04.2017.
 */
public class FiveSecondsIndicator extends Thread  {

    public static int timePast = 0;


    private static Object resources;


    public FiveSecondsIndicator(Object res)
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

                System.out.println("5 seconds thread, overall time remain: " + timePast);
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
