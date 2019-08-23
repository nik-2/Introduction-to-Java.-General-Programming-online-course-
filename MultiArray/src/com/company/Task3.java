package com.company;

import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
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
                array[i][j] = (int) Math.round((Math.random() * 8) + 1);
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println(" \n");
        }
        System.out.println( " Input string №:");
        int str = in.nextInt();
        System.out.println( " Input column №:");
        int col = in.nextInt();
        if ( str > x || str < 1)
        {
            System.out.println( " String №" + str + " does not exist.");
        }
        else
            {
            System.out.print(" String №" + str + ": ");
            for (int i = str - 1, j = 0; j < y; j++) {
                System.out.print("\t" + array[i][j]);
            }
        }
        if ( col > y || col < 1)
        {
            System.out.println(" Column №" + col + " does not exist.");
        }
        System.out.print( "\n Column №" + col + ": ");
        for (int i = 0, j = col - 1; i < x; i++)
        {
            System.out.print("\t" + array[i][j]);
        }
    }
}

