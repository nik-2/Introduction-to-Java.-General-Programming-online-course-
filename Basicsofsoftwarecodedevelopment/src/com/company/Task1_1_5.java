package com.company;

import java.util.Scanner;

public class Task1_1_5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input e: ");
        double e = in.nextDouble();
        System.out.println( " Input the length of the number series a(n) = 1/2^n + 1/3^n: ");
        int n = in.nextInt();
        double rez = 0;
        System.out.println( " The members of the series whose module > e:");
        for (double x = 1; x <= n; x++)
        {
            double a = Math.abs(1/Math.pow(2,x) + 1/Math.pow(3,x));
            if ( a >= e)
            {
            System.out.print( " a" + (int)x + " = " + a + ";");
            rez = rez + a;
            }
        }
        if(rez == 0)
        {
            System.out.println( " Module of all a(n) < e... rez = 0.");
        }
        else
        {
            System.out.println( "\n Sum = " + rez);
        }
    }
}
