package com.company;

import java.util.Scanner;

public class Task7
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
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if( j == 0 && array2[i] <= array1[j]) {
                    System.out.print("\n We need to insert element " + array2[i] + " in the first position ");
                }
                if( j == array1.length - 1 && array2[i] >= array1[j])
                {
                    System.out.print("\n We need to insert element " + array2[i] + " at the last position ");
                    break;
                }
                if( array2[i] >= array1[j] && array2[i] <= array1[ j + 1])
                {
                    System.out.print("\n We need to insert element " + array2[i] + " between elements with index - " + j + " and " + (j + 1));
                }
            }
        }
    }
}
