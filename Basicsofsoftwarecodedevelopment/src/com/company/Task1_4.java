package com.company;

import java.util.Scanner;

public class Task1_4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input brick sizes: \n x: ");
        double x = in.nextDouble();
        System.out.println( " y: ");
        double y = in.nextDouble();
        System.out.println( " z: ");
        double z = in.nextDouble();
        System.out.println( " Input hole size: \n A: ");
        double A = in.nextDouble();
        System.out.println( " B: ");
        double B = in.nextDouble();
        if( ((x <= A) && (y <= B || z <= B)) || ((y <= A) && (x <= B || z <= B)) || ((z <= A) && (x <= B || y <= B)) )
        {
            System.out.println( " The brick will pass through the hole. ");
        }
        else
        {
            System.out.println( " The brick won't go through the hole. ");
        }
    }
}
