package com.company;

import java.util.Scanner;

public class Task12
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: \n Strings:");
        int x = in.nextInt();
        System.out.println(" Columns: ");
        int y = in.nextInt();
        int [][] array = new int[x][y];
        System.out.println(" \t\t Array:");
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length ; j++) {
                array[i][j] = (int) Math.round((Math.random() * 20));
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println(" \n");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int check_min = 0;
                int min = array[i][j];
                int index_min = j;
                for (int temp = j; temp < array[i].length; temp++) {
                    if (array[i][temp] < min) {
                        min = array[i][temp];
                        index_min = temp;
                        check_min++;
                    }
                }
                if(check_min != 0)
                {
                    int test_min = array[i][j];
                    array[i][j] = min;
                    array[i][index_min] = test_min;
                }
            }
        }
        System.out.println( "\t Array sorted by ascending:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println("\n");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int check_max = 0;
                int max = array[i][j];
                int temp_max = j;
                for (int temp = j; temp < array[i].length; temp++) {
                    if (array[i][temp] > max) {
                        max = array[i][temp];
                        temp_max = temp;
                        check_max++;
                    }
                }
                if(check_max != 0)
                {
                    int test_max = array[i][j];
                    array[i][j] = max;
                    array[i][temp_max] = test_max;
                }
            }
        }
        System.out.println( "\t Array sorted descending:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println("\n");
        }
    }
}

