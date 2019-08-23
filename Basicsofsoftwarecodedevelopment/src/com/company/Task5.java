package com.company;

import java.util.Scanner;

public class Task5
{
    public static void main(String[] args)
    {
    System.out.println(" Input seconds: ");
    Scanner in = new Scanner(System.in);
    int Sec = in.nextInt();
    System.out.println(" We have " + Sec + " sec ");
    int Hours = 0;
    int Min = 0;
    while(Sec >= 60 )
    {
        if( Sec >= 60 )
        {
        Sec = Sec - 60;
        Min++;
        }
        if( Min >= 60 )
        {
            Min = Min - 60;
            Hours++;
        }
    }
    System.out.println(" It is " + Hours + "h." + Min + "min." + Sec + "sec.");
    }
}
