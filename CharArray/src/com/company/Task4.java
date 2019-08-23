package com.company;

import java.util.Scanner;

public class Task4
{
    public static void main(String[] args)
    {
        int kol = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int temp = 0;
            if(((int) chars[i] >= 48 && (int) chars[i] <= 57) || ( chars[i] == '-' && (int) chars[i + 1] >= 48 && (int) chars[i + 1] <= 57))
            {
                do{
                    if(chars[i] == '.')
                    {
                        temp++;
                        if(temp > 1)
                        {
                            break;
                        }
                    }
                    i++;
                    if(i == chars.length)
                    {
                        break;
                    }
                }while(((int) chars[i] >= 48 && (int) chars[i] <= 57) || chars[i] == '.');
                kol++;
            }
        }
        System.out.println(chars);
        System.out.println( "The number of numbers in the text = " + kol);
    }
}
