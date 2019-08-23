package com.company;

import java.util.Scanner;

public class Task1_1_7
{
    public  static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the gap of natural numbers [m,n]... \n Input m: ");
        int m = in.nextInt();
        System.out.println( " Input n: ");
        int n = in.nextInt();
        for (int x = m; x <= n; x++)
        {
            int kol = 0;
            System.out.print( "\n The number " + x + " - its dividers: ");
            for ( int del = 2; del < x; del++)
            {
                if (x % del == 0)
                {
                    kol++;
                    System.out.print( del + "; ");
                }
            }
            if( kol == 0)
            {
                System.out.print( "This number is simple. ");
            }
        }
    }
}
