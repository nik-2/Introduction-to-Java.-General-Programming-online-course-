package com.company;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int n = in.nextInt();
        int [] array = new int[n];
        System.out.print( " Array:  ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) - 50;
            System.out.print( array[i] + "  ");
        }
        for (int i = 0; i < array.length - 1; i++) {
            if( array[i] > array[i + 1])
            {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                if(i != 0)
                {
                    i = i - 2;
                }
            }
        }
        System.out.print( "\n New sorted array:  ");
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[i] + "  ");
        }
    }
}
