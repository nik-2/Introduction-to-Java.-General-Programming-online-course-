package com.company;

import java.util.Scanner;

public class Task1_1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input first angle - ");
        double first = in.nextDouble();
        System.out.println(" Input second angle - ");
        double second = in.nextDouble();
        if ( (first + second) >= 180)
        {
            System.out.println( " Triangle doesn't exist. ");
        }
        else
        {
            if (((180 - first - second) == 90) || (first == 90) || (second == 90))
            {
                System.out.println( " The triangle exists - it is rectangular.");
            }
            else
            {
                System.out.println( " The triangle exists.");
            }
        }
    }
}

