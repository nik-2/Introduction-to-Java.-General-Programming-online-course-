package com.company;

import java.util.Scanner;

public class Task7
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        String new_str = new String();
        for (int i = 0; i < str.length(); i++) {
            int index = new_str.indexOf(str.charAt(i));
            if( index == -1 && str.charAt(i) != ' ')
            {
                new_str = new_str + str.substring(i, i + 1);
            }
        }
        System.out.println( "Source text:" + str);
        System.out.println( "Modified text:" + new_str);
    }
}
