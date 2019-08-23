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
        char[] chars = str.toCharArray();
        int temp_start = 0;
        int temp_end = chars.length - 1;
        while(chars[temp_start] == ' ')
        {
            temp_start++;
            kol++;
        }
        while(chars[temp_end] == ' ')
        {
            temp_end--;
            kol++;
        }
        for (int i = temp_start; i <= temp_end ; i++) {
            if (i != (chars.length - 1) && (int) chars[i] == 32 && (int) chars[i + 1] == 32) {
                while (chars[i + 1] == ' ') {
                    i++;
                    kol++;
                    if (i == (chars.length - 1)) {
                        break;
                    }
                }
            }
        }
        char[] charsdop = new char[chars.length - kol];
        for (int i = 0, j = temp_start; i < charsdop.length && j <= temp_end; i++) {
            if (j != (chars.length - 1) && (int) chars[j] == 32 && (int) chars[j + 1] == 32) {
                charsdop[i] = chars[j];
                while (chars[j] == ' ') {
                    j++;
                    if (j == (chars.length)) {
                        break;
                    }
                }
            }
            else
            {
                charsdop[i] = chars[j];
                j++;
            }
        }
        System.out.println( "Source text:");
        System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print( "'" + chars[i] + "'|" );
        }
        System.out.println( "\nNumber of extra spaces = " + kol);
        System.out.println( "Source text without extra spaces:");
        System.out.println(charsdop);
        for (int i = 0; i < charsdop.length; i++) {
            System.out.print( "'" + charsdop[i] + "'|" );
        }
    }
}
