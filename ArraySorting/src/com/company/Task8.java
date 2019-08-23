package com.company;


import java.util.Scanner;

public class Task8 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the number of fractions: ");
        int n = in.nextInt();
        int [] numerator = new int[n];
        int [] denominator = new int[n];
        System.out.print( " Fractional:  ");
        for (int i = 0; i < numerator.length; i++) {
            numerator[i] = (int)(Math.random() * 9) + 1;
            denominator[i] = (int)(Math.random() * 9) + 1;
            System.out.print( numerator[i] + "/" + denominator[i] + "  ");
        }
        int min_ind = 0;
        for (int i = 0; i < denominator.length; i++) {
            if(denominator[i] < denominator[min_ind])
            {
                min_ind = i;
            }
        }
        int HOK = denominator[min_ind];
        for (int i = 0; i < denominator.length; i++) {
            if(HOK % denominator[i] != 0)
            {
                HOK = HOK + denominator[min_ind];
                i = - 1;
            }
        }
        System.out.print( "\n HOK: " + HOK);
        for (int i = 0; i < numerator.length; i++) {
            numerator[i] = numerator[i] * (HOK / denominator[i]);
            denominator[i] = HOK;
        }
        System.out.print( "\n Unsorted fractions:  ");
        for (int i = 0; i < numerator.length; i++) {
            System.out.print( numerator[i] + "/" + denominator[i] + "  ");
        }
        for (int i = 0; i < numerator.length - 1; i++) {
            if(numerator[i] > numerator[ i + 1 ])
            {
                int temp = numerator[ i + 1 ];
                numerator[ i + 1 ] = numerator [i];
                numerator[i] = temp;
                if( i != 0)
                {
                    i = i - 2;
                }
            }
        }
        System.out.print( "\n Sorted fractions:  ");
        for (int i = 0; i < numerator.length; i++) {
            System.out.print( numerator[i] + "/" + denominator[i] + "  ");
        }
    }
}
