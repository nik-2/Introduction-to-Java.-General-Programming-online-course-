package com.company;

import java.util.Scanner;

public class Task2
{
    public static void main(String[] args)
    {
        int kol = 0;
        Scanner in = new Scanner(System.in);
        System.out.println( " Input text:");
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 3; i++) {
            if((chars[i] == 'w' || chars[i] == 'W') && (chars[i + 1] == 'O' || chars[i + 1] == 'o') && (chars[i + 2] == 'r' || chars[i + 2] == 'R') && (chars[i + 3] == 'd' || chars[i + 3] == 'D'))
            {
                kol++;
            }
        }
        char[] charsdop = new char[chars.length + 2*kol];
        for (int i = 0, j = 0; i < charsdop.length; i++) {
            if((chars[j] == 'w' || chars[j] == 'W') && (chars[j + 1] == 'O' || chars[j + 1] == 'o') && (chars[j + 2] == 'r' || chars[j + 2] == 'R') && (chars[j + 3] == 'd' || chars[j + 3] == 'D'))
            {
                if(chars[j] == 'w') {
                    charsdop[i] = 'l';
                }
                else {
                    charsdop[i] = 'L';
                }
                charsdop[++i] = 'e';
                charsdop[++i] = 't';
                charsdop[++i] = 't';
                charsdop[++i] = 'e';
                charsdop[++i] = 'r';
                j = j + 4;
            }
            else{
                charsdop[i] = chars[j];
                j++;
            }
        }
        System.out.println(chars);
        System.out.println(charsdop);
    }
}
