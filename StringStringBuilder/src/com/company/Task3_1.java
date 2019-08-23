package com.company;

import java.util.Scanner;

public class Task3_1
{
    public static void main(String[] args)
    {
        StringBuilder str_bui = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.println(" Input word:");
        String str = in.nextLine();
        str_bui.append(str.toLowerCase());
        System.out.println( "Word for analysis:" + str);
        if ( str_bui.toString().equals(str_bui.reverse().toString()))
        {
            System.out.println( "This word is a palindrome!!!");
        }
        else
        {
            System.out.println( "This word is not a palindrome!!!");
        }
    }
}
