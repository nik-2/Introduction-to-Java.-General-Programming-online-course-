package com.company;

public class Task11
{
    public static void main(String[] args) {
        int check = 0;
        int kol = 0;
        int x = 10;
        int y = 20;
        int[][] array = new int[x][y];
        System.out.println("\t\t Array: \n");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = (int)Math.round((Math.random() * 15));
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println(" \n ");
        }
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 5)
                {
                    kol++;
                }
            }
            if( kol >= 3)
            {
                check++;
                System.out.println( " In string " + (i + 1) + " the number 5 occurs " + kol + " times...");
            }
            kol = 0;
        }
        if ( check == 0)
        {
            System.out.println( " No strings where the number 5 occurs 3 times or more...");
        }
    }
}


