package com.company;

import java.util.Scanner;

public class Task1_1_1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner((System.in));
        System.out.println( " Input N: ");
        int n = in.nextInt();
        int rez = 0;
        for ( int x = 1; x <= n ; x++)
        {
            rez = rez + x;
        }
        System.out.println( " The sum of all numbers = " + rez);
    }
}
