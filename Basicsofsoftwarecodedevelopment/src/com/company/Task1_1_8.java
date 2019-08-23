package com.company;

import java.util.Scanner;

public class Task1_1_8
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int kol = 0;
        System.out.println( " Input A: ");
        float a = in.nextFloat();
        System.out.println(" Input B: ");
        float b = in.nextFloat();
        while ( a % 1 != 0)
        {
            a = a * 10;
        }
        while ( b % 1 != 0)
        {
            b = b * 10;
        }
        System.out.println( " Kind of numbers after getting rid of the fractional part - A: " + a + "; B: " + b );
        System.out.print( " Digits included in the first and second numbers: ");
        while ( a > 1 )
        {
            int c = (int) a % 10;
            a = (int)(a / 10);
            float bDop = b;
            while ( bDop > 1)
            {
                int d = (int) bDop % 10;
                bDop = (int) (bDop / 10);
                if ( c == d)
                {
                        kol++;
                        System.out.print(c + "; ");
                }
            }
        }
        if(kol == 0)
        {
            System.out.println(" There are no such numbers.");
        }
    }
}
