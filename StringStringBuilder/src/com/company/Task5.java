package com.company;

import java.util.Scanner;

public class Task5
{
    public static void main(String[] args)
    {
        int kol = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a')
            {
                kol++;
            }
        }
        System.out.println( "Source text:" + str);
        System.out.println( "Number of characters 'a' = " + kol);
    }
}
