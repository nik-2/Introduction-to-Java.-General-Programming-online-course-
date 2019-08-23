package com.company;

public class Task4
{
    public static void main(String[] args)
    {
        String str = "информатика";
        String str1 = str.substring(7,8);
        String str2 = str.substring(3,5);
        String new_str = str1 + str2 + str1;
        System.out.println( "Source word:" + str);
        System.out.println( "New word:" + new_str);
    }
}
