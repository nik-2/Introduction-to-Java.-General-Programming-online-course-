package com.company;

import java.util.Scanner;

public class Task2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input size first array: ");
        int n1 = in.nextInt();
        System.out.println( " Input size second array: ");
        int n2 = in.nextInt();
        int [] array1 = new int[n1];
        int [] array2 = new int[n2];
        int [] array = new int[array1.length + array2.length];
        System.out.print( " First array:  ");
        for (int i = 0; i < array1.length; i++) {
            if( i != 0) {
                do {
                    array1[i] = (int) (Math.random() * 100) - 50;
                }while (array1[i] < array1[i - 1]);
            }
            if( i == 0 )
            {
                array1[i] = (int) (Math.random() * 100) - 50;
            }
            System.out.print( array1[i] + "  ");
        }
        System.out.print( "\n Second array:  ");
        for (int i = 0; i < array2.length; i++) {
            if( i != 0) {
                do {
                    array2[i] = (int) (Math.random() * 100) - 50;
                }while (array2[i] < array2[i - 1]);
            }
            if( i == 0 )
            {
                array2[i] = (int) (Math.random() * 100) - 50;
            }
            System.out.print( array2[i] + "  ");
        }
        System.out.print( "\n New array:  ");
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i];
            System.out.print( array[i] + "  ");
        }
        for (int i = array1.length, j = 0; i < array.length; i++, j++) {
            array[i] = array2[j];
            System.out.print( array[i] + "  ");
        }
        int temp;
        int i_min = 0;
        int i_start = 0;
        System.out.print( "\n New sorted array:  ");
        do {
            for (int i = i_start; i < array.length; i++) {
                if (array[i] < array[i_min])
                {
                    i_min = i;
                }
            }
            temp = array[i_start];
            array[i_start] = array[i_min];
            array[i_min] = temp;
            System.out.print( array[i_start] + "  ");
            i_start++;
            i_min = i_start;
        }while(i_start < array.length);
    }
}
