package com.company;

import java.util.Scanner;

public class Task9
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        System.out.println( " Enter '0' if you want to search with CHARACTER. Enter '1' if you want to search using ASCII. Enter something else to EXIT");
        int kol = in.nextInt();
        System.out.println( "Source text:" + str);
        switch (kol)
        {
            case 0:
                CHARACTER(str);
                break;
            case 1:
                ASCII(str);
                break;
            default:
                return;
        }
    }

    public static void ASCII(String str)
    {
        int kol_lowercase = 0;
        int kol_uppercase = 0;
        for (int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 90)
            {
                kol_uppercase++;
            }
            if((int)str.charAt(i) >= 97 && (int)str.charAt(i) <= 122)
            {
                kol_lowercase++;
            }
        }
        System.out.println( "The number of lowercase = " + kol_lowercase);
        System.out.println( "The number of uppercase = " + kol_uppercase);
    }

    public static void CHARACTER(String str)
    {
        int kol_lowercase = 0;
        int kol_uppercase = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i)))
            {
                kol_uppercase++;
            }
            if(Character.isLowerCase(str.charAt(i)))
            {
                kol_lowercase++;
            }
        }
        System.out.println( "The number of lowercase = " + kol_lowercase);
        System.out.println( "The number of uppercase = " + kol_uppercase);
    }
}
