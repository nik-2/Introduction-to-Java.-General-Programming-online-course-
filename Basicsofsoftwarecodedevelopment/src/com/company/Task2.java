package com.company;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double st = 0.5;
        System.out.println(" Input a: ");
        double a = in.nextDouble();
        System.out.println(" Input b: ");
        double b = in.nextDouble();
        System.out.println(" Input c: ");
        double c = in.nextDouble();
        double rez;
        rez = (b + Math.pow((Math.pow(b , 2) + 4*a*c), st)) / 2*a - Math.pow(a , 3) * c + Math.pow(b, -2);
        System.out.println(" rez = " + rez );
    }
}
