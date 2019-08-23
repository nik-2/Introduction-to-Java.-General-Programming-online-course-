package com.company;

import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int n = in.nextInt();
        int [] array = new int[n];
        System.out.print( " Array:  ");
        for (int i = 0; i < array.length; i++) {
            if( i != 0) {
                do {
                    array[i] = (int) (Math.random() * 100) - 50;
                }while (array[i] < array[i - 1]);
            }
            if( i == 0 )
            {
                array[i] = (int) (Math.random() * 100) - 50;
            }
            System.out.print( array[i] + "  ");
        }
        int temp;
        int i_max = 0;
        int i_start = 0;
        System.out.print( "\n New sorted array:  ");
        do {
            for (int i = i_start; i < array.length; i++) {
                if (array[i] > array[i_max])
                {
                    i_max = i;
                }
            }
            temp = array[i_start];
            array[i_start] = array[i_max];
            array[i_max] = temp;
            System.out.print( array[i_start] + "  ");
            i_start++;
            i_max = i_start;
        }while(i_start < array.length);
    }
}
