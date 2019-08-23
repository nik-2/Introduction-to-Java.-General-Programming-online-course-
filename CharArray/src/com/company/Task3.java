package com.company;

import java.util.Scanner;

public class Task3
{
    public static void main(String[] args) {
        int kol = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(" Input text:");
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] >= 48 && (int) chars[i] <= 57) {
                kol++;
            }
        }
        System.out.println(chars);
        System.out.println( " The number of digits in the text = " + kol);
    }
}
