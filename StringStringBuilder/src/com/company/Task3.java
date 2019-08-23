package com.company;

import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        System.out.println( "Word for analysis:" + str);
        int  kol = -1;
        int i = 0;
        while((Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(str.length() - 1 - i))) && kol != (str.length() - 1) / 2)
        {
            i++;
            kol++;
        }
        if ( kol == (str.length() - 1) / 2)
        {
            System.out.println( "This word is a palindrome!!!");
        }
        else
        {
            System.out.println( "This word is not a palindrome!!!");
        }
    }
}
