package com.company;

import java.util.Scanner;

public class Task5
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int num = 1;
        do {
            System.out.println(" Input array size(even number):");
            System.out.println(" Strings and columns:");
            n = in.nextInt();
            if (n % 2 != 0) {
                System.out.println(" Error!!! Strings and columns odd number!!! Try again and input even number!!!");
            }
        } while (n % 2 != 0);
        int[][] array = new int[n][n];
        System.out.println("\t\t Array: \n");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if ( j <= array[i].length - num)
                {
                    array[i][j] = num;
                    System.out.print( "\t" + array[i][j]);
                }
                else
                {
                    array[i][j] = 0;
                    System.out.print( "\t" + array[i][j]);
                }
            }
            System.out.println(" \n ");
            num++;
        }
    }
}
