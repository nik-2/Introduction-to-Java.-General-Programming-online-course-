package com.company;

import java.util.Scanner;

public class Task2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        String repstr = str.replace("a","ab");
        System.out.println( " Source text:" + str);
        System.out.println(" Modified text:" + repstr);
    }
}
