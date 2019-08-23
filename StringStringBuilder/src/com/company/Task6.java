package com.company;

import java.util.Scanner;

public class Task6
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        String newstr = new String();
        for (int i = 0; i < str.length(); i++) {
            newstr = newstr + str.substring(i, i + 1) + str.substring(i, i + 1);
        }
        System.out.println( " Source text:" + str);
        System.out.println( " Modified text:" + newstr);
    }
}
