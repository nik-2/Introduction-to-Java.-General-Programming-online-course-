//Task5
package com.company;

import java.util.Scanner;

public class Counter
{
    private int upLimit;
    private int dnLimit;
    private int counter;

    private Counter()
    {
        dnLimit = 10;
        upLimit = 20;
        counter = dnLimit;
    }

    private Counter(int upLimit, int dnLimit, int counter)
    {
        this.upLimit = upLimit;
        this.dnLimit = dnLimit;
        this.counter = counter;
    }

    private int getCounter()
    {
        return counter;
    }

    private void counterUp()
    {
        counter++;
        check();
    }

    private void counterDn()
    {
        counter--;
        check();
    }

    private void check()
    {
        if(counter < dnLimit)
        {
            counter = upLimit;
        }
        if (counter > upLimit)
        {
            counter = dnLimit;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Counter counter = new Counter();
        int dnLimit;
        int upLimit;
        int value;
        int kod;
        do {
            System.out.println(" Input '1' - to use default values\n Input '2' - to enter values");
            kod = in.nextInt();
            if (kod != 1 && kod != 2)
            {
                System.out.println(" ERROR! WRONG VALUE! TRY AGAIN!");
            }
        }while( kod != 1 && kod != 2);
        switch (kod)
        {
            case 1:
                break;
            case 2:
                System.out.print( " Input DownLimit: ");
                dnLimit = in.nextInt();
                do{
                    System.out.print(" Input UpLimit(UpLimit > DownLimit): ");
                    upLimit = in.nextInt();
                    if( upLimit <= dnLimit)
                    {
                        System.out.println(" ERROR! WRONG VALUE! TRY AGAIN!");
                    }
                }while (upLimit <= dnLimit);
                do{
                    System.out.print(" Input CounterValue(DownLimit <= CounterValue <= UpLimit): ");
                    value = in.nextInt();
                    if( value > upLimit || value < dnLimit)
                    {
                        System.out.println(" ERROR! WRONG VALUE!");
                    }
                }while (value > upLimit || value < dnLimit);
                counter = new Counter(upLimit, dnLimit, value);
                break;
        }
        do {
            System.out.println(" Input '1' - to use '-' method\n" +
                    " Input '2' - to use '+' method\n" +
                    " Input any other number - to PRINT value");
            kod = in.nextInt();
            switch (kod) {
                case 1:
                    counter.counterDn();
                    break;
                case 2:
                    counter.counterUp();
                    break;
                default:
                    System.out.println(" Value right now = " + counter.getCounter());
                    break;

            }
            System.out.println( "\nPress '1' for REPEAT...\n" +
                    "Press any other number - for PRINT value and EXIT...");
            kod = in.nextInt();
        }while ( kod == 1);
        System.out.println(" Value right now = " + counter.getCounter());
    }
}
