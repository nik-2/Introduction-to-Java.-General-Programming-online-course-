package com.company;

import java.util.Scanner;

public class Task4
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int num;
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
            if (i % 2 == 0)
            {
                num = 1;
            }
            else
                {
                    num = n;
                }
            for (int j = 0; j < array[i].length; j++)
            {
                if (i % 2 == 0)
                {
                    array[i][j] = num;
                    System.out.print("\t" + array[i][j]);
                    num++;
                }
                else
                    {
                        array[i][j] = num;
                        System.out.print("\t" + array[i][j]);
                        num--;
                    }
            }
            System.out.println(" \n ");
        }
    }
}
