package com.company;

import java.util.Scanner;

public class Task8
{
    public static void main(String[] args)
    {
        int max = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        String[] words = str.split(" ");
        String max_length = new String();
        for(String word : words)
        {
            if( word.length() > max)
            {
                max = word.length();
                max_length = word;
            }
        }
        System.out.println( "Source text:" + str);
        System.out.println( "Longest word:" + max_length);
        System.out.println( "The length of the longest word:" + max);
    }
}
