package com.company;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args)
    {
        System.out.println(" Input X: ");
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        System.out.println(" Input Y: ");
        double y = in.nextDouble();
        if (( x >= -4 && x <= 4 && y <= 0 && y >= -3 ) || ( x >= -2 && x <= 2 && y <= 4 && y >= 0))
        {
            if ( x == 0 && y == -1)
            {
                System.out.println( false + " - value doesn't belongs to the area.");
            }
            else
                {
                    System.out.println(true + " - value belongs to the area.");
                }
        }
        else
        {
            System.out.println( false + " - value doesn't belongs to the area.");
        }
    }
}
