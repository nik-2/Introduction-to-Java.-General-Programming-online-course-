package com.company;

import java.util.Scanner;

public class Task14
{
    public static void main(String[] args)
    {
        int kol;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: \n Strings:");
        int x = in.nextInt();
        System.out.println(" Columns: ");
        int y = in.nextInt();
        int [][] array = new int[x][y];
        System.out.println(" \t Array:");
        for (int j = 0; j < y; j++)
        {
            do {
                int i_stop = 0;
                kol = 0;
                for (int i = 0; i < array.length; i++) {
                    array[i][j] = (int) Math.round(Math.random() * 1);
                    if (array[i][j] == 1) {
                        kol++;
                    }
                    if (kol == j + 1) {
                        i_stop = i;
                        break;
                    }
                }
                for (int i = i_stop + 1; i < array.length; i++) {
                    array[i][j] = 0;
                }
            }while( kol != (j + 1));
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println("\n");
        }
    }
}

