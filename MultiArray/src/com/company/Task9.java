package com.company;

import java.util.Scanner;

public class Task9
{
    public static void main(String[] args)
    {
        int sum = 0;
        int max_sum = 0;
        int max_ind = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: \n Strings:");
        int x = in.nextInt();
        System.out.println(" Columns: ");
        int y = in.nextInt();
        int [][] array = new int[x][y];
        System.out.println(" \t Array:");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length ; j++) {
                array[i][j] = (int) Math.round((Math.random() * 9));
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println(" \n");
        }
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[j].length; i++) {
                sum = sum + array[i][j];
            }
            System.out.println("The sum of the elements of the column number " + (j + 1) + " = " + sum);
            if (sum > max_sum)
            {
                max_sum = sum;
                max_ind = j;
            }
            sum = 0;
        }
        System.out.println( "The max sum elements = " + max_sum + " has column number " + (max_ind + 1));
    }
}

