package com.company;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args)
    {
    Scanner in = new Scanner(System.in);
    double rez;
    System.out.println(" Input x: ");
    double x = in.nextDouble();
    System.out.println(" Input y: ");
    double y = in.nextDouble();
    rez = (Math.sin(x) + Math.cos(y))/(Math.cos(x) - Math.sin(y))*Math.tan(x*y);
    System.out.println(" Rez = " + rez);
    }
}
