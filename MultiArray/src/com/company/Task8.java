package com.company;

import java.util.Scanner;

public class Task8
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
        System.out.println( " Input first column №:");
        int col1 = in.nextInt();
        if ( col1 > y || col1 < 1)
        {
            System.out.println(" Column №" + col1 + " does not exist.");
            System.exit(1);
        }
        System.out.println( " Input second column №:");
        int col2 = in.nextInt();
        if ( col2 > y || col2 < 1)
        {
            System.out.println(" Column №" + col2 + " does not exist.");
            System.exit(1);
        }
        for (int i = 0; i < array.length; i++)
        {
            int per = array[i][col2 - 1];
            array[i][col2 - 1] = array[i][col1 - 1];
            array[i][col1 - 1] = per;
        }
        System.out.println( "\t\t Array with column swapping: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println("\n");
        }
    }
}

