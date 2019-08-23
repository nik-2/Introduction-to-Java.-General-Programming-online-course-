package com.company;

import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: \n Strings:");
        int kol = 0;
        int x = in.nextInt();
        System.out.println(" Columns: ");
        int y = in.nextInt();
        int [][] array = new int[x][y];
        System.out.println(" Array:");
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y ; j++) {
                array[i][j] = (int) Math.round((Math.random() * 8) + 1);
                System.out.print( "  " + array[i][j]);
            }
            System.out.println(" \n");
        }
        System.out.println( " Odd columns whose first element is greater than the last: ");
        for (int i = 0; i < x; i ++)
        {
            for (int j = 0; j < y ; j = j + 2)
            {
                if( array [0][j] > array [x - 1][j])
                {
                    System.out.print("  " + array[i][j]);
                    kol++;
                }
            }
            if ( kol != 0)
            {
                System.out.println(" \n");
            }
            else
            {
                System.out.println( " There are no odd columns whose first element is greater than the last: ");
                break;
            }
        }
    }
}
