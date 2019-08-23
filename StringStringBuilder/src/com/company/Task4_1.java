package com.company;

public class Task4_1
{
    public static void main(String[] args)
    {
        StringBuilder str = new StringBuilder("информатика");
        System.out.println( "Source word:" + str);
        str = str.append(str.substring(7,8) + str.substring(3,5) + str.substring(7,8));
        str = str.delete(0,11);
        System.out.println( "New word:" + str);
    }
}
