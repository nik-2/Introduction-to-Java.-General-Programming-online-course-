package com.company;

import java.util.Scanner;

public class Task7
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
        double[][] array = new double[n][n];
        System.out.println("\t\t Array: \n");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = Math.round((Math.sin(( i*i - j*j ) / n)) * 100.0) / 100.0;
                System.out.print( "     " + array[i][j]);
                if(array[i][j] > 0)
                {
                    kol++;
                }
            }
            System.out.println(" \n ");
        }
        System.out.println( " The number of positive elements = " + kol);
    }
}

