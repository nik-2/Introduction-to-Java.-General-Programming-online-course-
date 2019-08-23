package com.company;

public class Task1_1_3
{
    public static void main(String[] args)
    {
        int rez = 0;
        for ( int x = 1; x <= 100; x++)
        {
            rez = rez + x*x;
        }
        System.out.println( " Sum of squares of the first hundred numbers: " + rez);
    }
}
