package com.company;


public class Task1
{
    public static void main(String[] args)
    {
        int kol = 0;
        char[] CamelCase = new char[] { 'B','y','t','e','I','n','t','D','o','u','b','l','e','S','h','o','r','t','L','o','n','g','F','l','o','a','t','C','h','a','r','B','o','o','l','e','a','n'};
        for (int i = 0; i < CamelCase.length; i++) {
            if((int)CamelCase[i] >= 65 && (int)CamelCase[i] <= 90)
            {
                kol++;
            }
        }
        char[] snake_case = new char[CamelCase.length + (kol - 1)];
        for (int i = 0, j = -1; i < snake_case.length; i++) {
            if((int)CamelCase[j + 1] >= 97 && (int)CamelCase[j + 1] <= 122)
            {
                snake_case[i] = CamelCase[j + 1];
                j++;
            }
            else {
                if ((int) CamelCase[j + 1] >= 65 && (int) CamelCase[j + 1] <= 90 && (j + 1) != 0) {
                    snake_case[i] = '_';
                    i++;
                    snake_case[i] = (char) ((int) CamelCase[j + 1] + 32);
                    j++;
                }
                else {
                        snake_case[i] = (char) ((int) CamelCase[j + 1] + 32);
                        j++;
                }
            }
        }
        System.out.println( "CamelCase string: ");
        System.out.println( CamelCase);
        System.out.println( "snake_case string: ");
        System.out.println( snake_case);
    }
}
