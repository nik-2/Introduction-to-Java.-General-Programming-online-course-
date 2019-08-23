package com.company;

import java.util.Scanner;

public class Task10
{
    public static void main(String[] args)
    {
        int kol_sentence = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if( (str.charAt(i) == '!' || str.charAt(i) == '.' || str.charAt(i) == '?') && (str.charAt(i - 1) != '!' && str.charAt(i - 1) != '.' && str.charAt(i - 1) != '?') )
            {
                kol_sentence++;
            }
        }
        System.out.println( "Source text:" + str);
        System.out.println( "The number of sentences in the text = " + kol_sentence);
    }
}
