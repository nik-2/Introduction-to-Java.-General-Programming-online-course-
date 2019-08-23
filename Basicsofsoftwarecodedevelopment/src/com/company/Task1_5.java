package com.company;

import java.util.Scanner;

public class Task1_5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " If x <= 3 we have, that F(x) = x^2 - 3x + 9; else F(x) = 1 / (x^3 + 6) \n Input x: ");
        double x = in.nextDouble();
        if ( x <= 3)
        {
            double rez = Math.pow(x,2) - 3 * x + 9;
            System.out.println( " F(x) = x^2 - 3x + 9 = " + rez);
        }
        else
        {
            double rez = 1 / ( Math.pow(x,3) + 6 );
            System.out.println( " F(x) = 1 / (x^3 + 6) = " + rez);
        }
    }
}
