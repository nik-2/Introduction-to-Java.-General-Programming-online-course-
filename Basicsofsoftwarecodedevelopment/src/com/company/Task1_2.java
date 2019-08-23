package com.company;

import java.util.Scanner;

public class Task1_2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( "Input a: ");
        double a = in.nextDouble();
        System.out.println( "Input b: ");
        double b = in.nextDouble();
        System.out.println( "Input c: ");
        double c = in.nextDouble();
        System.out.println( "Input d: ");
        double d = in.nextDouble();
        double min1 = (a < b) ? a : b;
        double min2 = (c < d) ? c : d;
        double max = (min1 > min2) ? min1 : min2;
        System.out.println(" The expression - max{min(a,b),min(c,d)} has the result: " + max);
    }
}
