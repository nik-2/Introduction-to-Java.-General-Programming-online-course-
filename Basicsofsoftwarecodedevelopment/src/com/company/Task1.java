package com.company;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double rez;
        System.out.println(" Input a: ");
        double a = in.nextDouble();
        System.out.println(" Input b: ");
        double b = in.nextDouble();
        System.out.println(" Input c: ");
        double c = in.nextDouble();
        rez = ((a - 3) * b / 2) + c;
        System.out.println(" rez = " + rez );
    }
}
