package com.company;

import java.util.Scanner;

public class Task15
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: \n Strings:");
        int x = in.nextInt();
        System.out.println(" Columns: ");
        int y = in.nextInt();
        int [][] array = new int[x][y];
        int max = array[0][0];
        System.out.println(" \t\t Array:");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length ; j++) {
                array[i][j] = (int) Math.round(Math.random() * 20);
                System.out.print( "\t" + array[i][j]);
                if(array[i][j] > max)
                {
                    max = array[i][j];
                }
            }
            System.out.println(" \n");
        }
        System.out.println( " The max element = " + max + "\n\n\t\t Replaced array:");
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] % 2 != 0)
                {
                    array[i][j] = max;
                }
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println( "\n");
        }
    }
}

