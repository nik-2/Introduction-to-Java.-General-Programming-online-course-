package com.company;

import java.util.Scanner;

public class Task10
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int x = 0;
        int y = 0;
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
                array[i][j] = (int)Math.round((Math.random() * 18) - 9);
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println(" \n ");
        }
        System.out.print( " The elements of the main diagonal:");
        do
        {
            System.out.print( "  " + array[x][y] + ";");
            x++;
            y++;
        }while ( x < array.length && y < array[x].length);
        x = 0;
        y = 0;
        System.out.print( "\n The positive elements of the main diagonal:");
        do
        {
            if( array[x][y] > 0)
            {
                System.out.print("  " + array[x][y] + ";");
            }
            x++;
            y++;
        }while ( x < array.length && y < array[x].length);
    }
}

