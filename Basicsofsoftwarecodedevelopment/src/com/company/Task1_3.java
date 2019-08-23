package com.company;

import java.util.Scanner;

public class Task1_3
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input A(x1,y1) \n x1: ");
        double x1 = in.nextDouble();
        System.out.println( " y1: ");
        double y1 = in.nextDouble();
        System.out.println( " Input B(x2,y2) \n x2: ");
        double x2 = in.nextDouble();
        System.out.println( " y2: ");
        double y2 = in.nextDouble();
        System.out.println( " Input C(x3,y3) \n x3: ");
        double x3 = in.nextDouble();
        System.out.println( " y3: ");
        double y3 = in.nextDouble();
        if (((x1 - x3)*(y2 - y3)) == ((x2 - x3)*(y1 - y3)))
        {
            System.out.println( " A,B and C located on the same line. ");
        }
        else
        {
            System.out.println( " A,B and C not located on the same line. ");
        }
    }
}
