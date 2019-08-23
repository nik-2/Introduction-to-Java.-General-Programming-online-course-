package com.company;

import java.util.Scanner;

public class Task7_1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        StringBuilder new_str = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int index = new_str.toString().indexOf(str.charAt(i));
            if( index == -1 && str.charAt(i) != ' ')
            {
                new_str = new_str.append(str.substring(i, i + 1));
            }
        }
        System.out.println( "Source text:" + str);
        System.out.println( "Modified text:" + new_str);
    }
}
