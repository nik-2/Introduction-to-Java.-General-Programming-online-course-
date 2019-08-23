package com.company;

import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        int max = 0;
        int temp;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            temp = 0;
            if( str.charAt(i) == ' ')
            {
               do {
                   temp++;
                   i++;
                   if(i == str.length())
                   {
                       break;
                   }
               }while(str.charAt(i) == ' ');
            }
            if( temp > max)
            {
                max = temp;
            }
        }
        System.out.println( "Source text:" + str);
        System.out.println( "The largest number of spaces = " + max);
    }
}
