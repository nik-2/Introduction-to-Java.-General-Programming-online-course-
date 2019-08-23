package com.company;

import java.util.Scanner;

public class Task1_1_2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input section values [a,b]... \n a: ");
        double a = in.nextDouble();
        System.out.println( " b: ");
        double b = in.nextDouble();
        System.out.println( " Input one step values: ");
        double h = in.nextDouble();
        for ( double x = a; x <= b; x = x + h)
        {
            if ( x <= 2)
            {
                double y = -x;
                System.out.println( " x = " + x + "   y(x) = " + y);
            }
            else
            {
                double y = x;
                System.out.println( " x = " + x + "   y(x) = " + y);
            }
        }
    }
}
