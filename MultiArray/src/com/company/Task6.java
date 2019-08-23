package com.company;

import java.util.Scanner;

public class Task6
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int kol = 0;
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
                if (  j >=  kol && j < array[i].length - kol)
                {
                    array[i][j] = 1;
                    System.out.print( "\t" + array[i][j]);
                }
                else
                {
                    array[i][j] = 0;
                    System.out.print( "\t" + array[i][j]);
                }
            }
            if(i < array.length/2 - 1)
            {
                kol++;
            }
            if(i >= array.length / 2)
            {
                kol--;
            }
            System.out.println(" \n ");
        }
    }
}
