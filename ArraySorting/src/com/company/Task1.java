package com.company;

import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input size first array: ");
        int n1 = in.nextInt();
        System.out.println( " Input size second array: ");
        int n2 = in.nextInt();
        System.out.println( " Input natural number < " + n1);
        int k = in.nextInt();
        int [] array1 = new int[n1];
        int [] array2 = new int[n2];
        int [] array = new int[array1.length + array2.length];
        System.out.print( " First array:  ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int)(Math.random() * 100) - 50;
            System.out.print( array1[i] + "  ");
        }
        System.out.print( "\n Second array:  ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int)(Math.random() * 100) - 50;
            System.out.print( array2[i] + "  ");
        }
        System.out.print( " \n Natural number: " + k);
        System.out.print( "\n New array:  ");
        for (int i = 0; i <= k; i++) {
            array[i] = array1[i];
            System.out.print( array[i] + "  ");
        }
        for (int i = k + 1, j = 0; j < array2.length; j++, i++) {
            array[i] = array2[j];
            System.out.print( array[i] + "  ");
        }
        for (int i = k + 1 + array2.length, j = k + 1; i < array.length; i++, j++) {
            array[i] = array1[j];
            System.out.print( array[i] + "  ");
        }
    }
}
