//Task6
package com.company;

import java.util.Scanner;

public class Time
{
    private int hour;
    private int minute;
    private int seconds;

    private Time(int hour,int minute, int seconds)
    {
        checkHour(hour);
        checkMinute(minute);
        checkSeconds(seconds);
    }

    private void checkHour(int hour)
    {
        if (hour < 24 && hour >= 0)
        {
            this.hour = hour;
        }
        else
        {
           this.hour = 0;
        }
    }

    private void checkMinute(int minute)
    {
        if (minute < 60 && minute >= 0)
        {
            this.minute = minute;
        }
        else
        {
            this.hour = 0;
        }
    }

    private void checkSeconds(int seconds)
    {
        if (seconds < 60 && seconds >= 0)
        {
            this.seconds = seconds;
        }
        else
        {
            this.seconds = 0;
        }
    }

    private int getHour()
    {
        return hour;
    }

    private int getMinute()
    {
        return minute;
    }

    private int getSeconds()
    {
        return seconds;
    }

    private void newHour(int hour)
    {
        checkHour(hour);
    }

    private void newMinute(int minute)
    {
        checkMinute(minute);
    }

    private void newSeconds(int seconds)
    {
        checkSeconds(seconds);
    }

    private void changeSeconds(int seconds)
    {
        this.seconds = this.seconds + seconds;
        while (getHour() >= 24 || getMinute() >= 60 || getSeconds() >= 60)
        {
            if(getSeconds() >= 60)
            {
                this.seconds = this.seconds - 60;
                minute = minute + 1;
            }
            if( getMinute() >= 60)
            {
                this.minute = this.minute - 60;
                hour = hour + 1;
            }
            if( hour >= 24)
            {
                hour = hour - 24;
            }
        }
    }

    private void changeMinute(int minute)
    {
        this.minute = this.minute + minute;
        while(getHour() >= 24 || getMinute() >= 60)
        {
            if( getMinute() >= 60)
            {
                this.minute = this.minute - 60;
                hour = hour + 1;
            }
            if( hour >= 24)
            {
                hour = hour - 24;
            }
        }
    }

    private void changeHour(int hour)
    {
        this.hour = this.hour + hour;
        while(getHour() >= 24)
        {
            this.hour = this.hour - 24;
        }
    }

    private void show()
    {
        System.out.println( " Time:  " + getHour()/10 + (getHour() - getHour()/10*10) + ":" + getMinute()/10 + (getMinute() - getMinute()/10*10) + ":" + getSeconds()/10 + (getSeconds() - getSeconds()/10*10));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Time time;
        System.out.print( " Input HOURS: ");
        int h = in.nextInt();
        System.out.print( " Input MINUTES: ");
        int m = in.nextInt();
        System.out.print( " Input SECONDS: ");
        int s = in.nextInt();
        time = new Time(h, m ,s);
        time.show();
        int kod;
        do {
            System.out.println(" Input '1' - to input new HOURS\n" +
                    " Input '2' - to input new MINUTES\n" +
                    " Input '3' - to input new SECONDS\n" +
                    " Input '4' - to CHANGE the time by a specified number of HOURS\n" +
                    " Input '5' - to CHANGE the time by a specified number of MINUTES\n" +
                    " Input '6' - to CHANGE the time by a specified number of SECONDS\n" +
                    " Input any other value - to PRINT time");
            kod = in.nextInt();
            switch (kod) {
                case 1:
                    System.out.print(" Input new HOURS: ");
                    time.newHour(in.nextInt());
                    break;
                case 2:
                    System.out.print(" Input new MINUTES: ");
                    time.newMinute(in.nextInt());
                    break;
                case 3:
                    System.out.print(" Input new SECONDS: ");
                    time.newSeconds(in.nextInt());
                    break;
                case 4:
                    System.out.print(" Input the hours to CHANGE the time by a specified number of HOURS: ");
                    time.changeHour(in.nextInt());
                    break;
                case 5:
                    System.out.print(" Input the minutes to CHANGE time by a specified number of MINUTES: ");
                    time.changeMinute(in.nextInt());
                    break;
                case 6:
                    System.out.print(" Input the seconds to CHANGE time by a specified number of SECONDS: ");
                    time.changeSeconds(in.nextInt());
                    break;
                default:
                    time.show();
                    break;
            }
            System.out.println( "\nPress '1' for REPEAT...\n" +
                    "Press any other number - for PRINT the time and EXIT...");
            kod = in.nextInt();
        }while (kod == 1);
        time.show();
    }
}
