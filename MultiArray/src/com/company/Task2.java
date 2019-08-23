package com.company;

import java.util.Scanner;

public class Task2
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
        System.out.println( " The elements on the diagonal: ");
        for (int i = 0, j = 0; i < x & j < y; i ++, j++)
        {
            System.out.print("\t" + array[i][j]);
        }
    }
}
