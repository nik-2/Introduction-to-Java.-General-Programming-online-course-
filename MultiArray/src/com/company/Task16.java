package com.company;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task16
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int kod;
        int n;
        do {
            System.out.println(" Input array size ( n > 2 ):");
            System.out.println(" Strings and columns:");
            n = in.nextInt();
            if (n <= 2) {
                System.out.println(" Error!!! Strings and columns <= 2!!! Try again and input number bigger then two!!!");
            }
        } while (n <= 2);
        int[][] array_magic = new int[n][n];
        int[][] array = new int[n][n];
        Create(array);
        System.out.println("\t\t Array: \n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println("\n");
        }
        if ( n % 2 != 0) {
            if(n == 3)
            {
                do {
                    System.out.println(" Input '1' for random or input '2' for algorithm: ");
                    kod = in.nextInt();
                    if( kod != 1 && kod != 2)
                    {
                        System.out.println( " Error!!! Input '1' or '2'!!! Try again!!! ");
                    }
                } while( kod != 1 && kod != 2);
                switch (kod)
                {
                    case 1:
                        Random(array, n);
                        Print(array);
                        break;
                    case 2:
                        AlgorithmOdd(array, n, array_magic);
                        Print(array_magic);
                        break;
                }
            }
            else {
                AlgorithmOdd(array, n, array_magic);
                Print(array_magic);
            }
        }
        if (n % 2 == 0)
        {
            if( n % 2 == 0 && n % 4 == 0)
            {
                Algorithm_4(array, n);
            }
            else
            {
                Algorithm_2(array, n);
            }
            Print(array);
        }
    }
    public static void Create( int array[][])
    {
        int num = 1;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = num;
                num++;
            }
        }
    }
    public static void Print ( int array[][])
    {
        System.out.println("\t The magic square: \n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print( "\t" + array[i][j]);
            }
            System.out.println("\n");
        }
    }
    public static void Random ( int array[][], int n)
    {
        SecureRandom r = new SecureRandom();
        int check = (n * ( n * n + 1)) / 2;
        int diag1;
        int diag2;
        int str = 0;
        int col = 0;
        do {
            int i_temp0 = r.nextInt(n);
            int j_temp0 = r.nextInt(n);
            int i_temp = r.nextInt(n);
            int j_temp = r.nextInt(n);
            int temp = array[i_temp0][j_temp0];
            array[i_temp0][j_temp0] = array[i_temp][j_temp];
            array[i_temp][j_temp] = temp;
            diag1 = 0;
            for (int i = 0, j = 0; i < array.length; i++, j++) {
                diag1 = diag1 + array[i][j];
            }
            diag2 = 0;
            for (int j = array.length - 1, i = 0; i < array.length; j--, i++) {
                diag2 = diag2 + array[i][j];
            }
            for (int i = 0; i < array.length; i++) {
                str = 0;
                for (int j = 0; j < array[i].length; j++) {
                    str = str + array[i][j];
                }
                if (str != check) {
                    break;
                }
            }
            for (int j = 0; j < array.length; j++) {
                col = 0;
                for (int i = 0; i < array.length; i++) {
                    col = col + array[i][j];
                }
                if (col != check) {
                    break;
                }
            }
        }while( str != check ||  col != check || diag1 != check || diag2 != check);
    }
    public static void AlgorithmOdd ( int array[][],int n, int array_magic[][])
    {
        int n_start = (n / 2) + 2;
        int sum;
        for (int i = 0; i < array_magic.length; i++) {
            if (i % 2 == 0) {
                n_start--;
                sum = n_start;
            } else {
                n_start = n_start + n;
                sum = n_start;
            }
            for (int j = 0; j < array_magic[i].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        array_magic[i][j] = sum;
                        sum = sum + (n + 1);
                    } else {
                        array_magic[i][j] = 0;
                    }
                } else {
                    if (j % 2 == 0) {
                        array_magic[i][j] = 0;
                    } else {
                        array_magic[i][j] = sum;
                        sum = sum + (n + 1);
                    }
                }
            }
        }
        List<Integer> array_temp = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n / 2) - i; j++) {
                array_temp.add(array[i][j]);
            }
        }
        int temp = 0;
        int kol = 0;
        do {
            int kol_col = 0;
            for (int i = n / 2 + kol; i >= 1 + kol * 2; i--) {
                int j = n - n / 2 + kol_col + kol;
                array_magic[i][j] = array_temp.get(temp);
                kol_col++;
                temp++;
            }
            kol++;
        } while (kol != n / 2);
        temp = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = n / 2 + 1 + i; j < n; j++) {
                array_temp.set(temp, array[i][j]);
                temp++;
            }
        }
        temp = 0;
        kol = 0;
        int need = 0;
        do {
            int kol_col = 0;
            for (int i = n - 1; i > n / 2 + need; i--) {
                int j = 1 + kol_col + kol;
                array_magic[i][j] = array_temp.get(temp);
                kol_col++;
                temp++;
            }
            kol = kol + 2;
            need++;
        } while (kol != n - 1);
        temp = 0;
        need = 0;
        for (int j = n - 1; j > n / 2; j--) {
            for (int i = n / 2 + 1 + need; i < n; i++) {
                array_temp.set(temp, array[i][j]);
                temp++;
            }
            need++;
        }
        temp = 0;
        kol = 0;
        need = 0;
        do {
            int kol_col = 0;
            for (int j = 0; j < n / 2 - need; j++) {
                int i = 1 + kol_col + kol;
                array_magic[i][j] = array_temp.get(temp);
                kol_col++;
                temp++;
            }
            kol = kol + 2;
            need++;
        } while (kol != n - 1);
        temp = 0;
        need = 0;
        for (int j = 0; j < n / 2; j++) {
            for (int i = n / 2 + 1 + need; i < n; i++) {
                array_temp.set(temp, array[i][j]);
                temp++;
            }
            need++;
        }
        temp = 0;
        kol = 0;
        need = 0;
        do {
            int kol_col = 0;
            for (int i = 0; i < n / 2 - need; i++) {
                int j = 1 + kol_col + kol;
                array_magic[i][j] = array_temp.get(temp);
                kol_col++;
                temp++;
            }
            kol = kol + 2;
            need++;
        } while (kol != n - 1);
    }
    public static void Algorithm_2 ( int array[][], int n)
    {
        int number = n / 2;
        int [][] array_dop = new int[number][number];
        Create(array_dop);
        int[][] array_magic = new int[number][number];
        AlgorithmOdd(array_dop, number, array_magic);
        for (int i = 0; i < array_magic.length ; i++) {
            for (int j = 0; j < array_magic.length; j++) {
                array[i][j] = array_magic[i][j];
                array[i][j + n/2] = 2 * (n / 2) * (n / 2) + array_magic[i][j];
                array[i + n/2][j] = 3 * (n / 2) * (n / 2) + array_magic[i][j];
                array[i + n/2][j + n/2] = (n / 2) * (n / 2) + array_magic[i][j];
            }
        }
        int temp1 = array[0][0];
        array[0][0] = array[n/2][0];
        array[n/2][0] = temp1;
        temp1 = array[n/2 - 1][0];
        array[n/2 - 1][0] = array[n - 1][0];
        array[n - 1][0] = temp1;
        for (int i = 1, j = 1 ; i < (n / 2) - 1; i++) {
            temp1 = array[i][j];
            array[i][j] = array[i + n/2][j];
            array[i + n/2][j] = temp1;
        }
        if(n != 6)
        {
            for (int i = 0; i < n / 2 ; i++) {
                for (int j = (n / 2) - ((n - 6) / 4); j < n / 2 + ((n - 6) / 4) ; j++) {
                    temp1 = array[i][j];
                    array[i][j] = array[i + n/2][j];
                    array[i + n/2][j] = temp1;
                }
            }
        }
    }
    public static void Algorithm_4 ( int array[][], int n)
    {
        for (int i = 0, k = n - 1; i < n / 2; i++, k--) {
            for (int j = 0, l = n - 1; j < n / 2; j++, l--) {
                if (i == j) {
                    int temp = array[i][j];
                    array[i][j] = array[k][l];
                    array[k][l] = temp;
                }
            }
        }
        for (int i = 4, k = n - 5; i < n; i++, k--) {
            for (int j = 0, l = n - 1; j < n; j++, l--) {
                if (i == j) {
                    l = n - 1;
                    break;
                }
                if ((j - i) % 4 == 0 || (i - j) % 4 == 0) {
                    int temp = array[i][j];
                    array[i][j] = array[k][l];
                    array[k][l] = temp;
                }
            }
        }
        for (int i = n - 1, k = 0; i > 0; i--, k++) {
            for (int j = 0, l = n - 1; j < n; j++, l--) {
                if (i == j) {
                    l = n - 1;
                    break;
                }
                if ((l - i) % 4 == 0 || (i - l) % 4 == 0) {
                    int temp = array[i][j];
                    array[i][j] = array[k][l];
                    array[k][l] = temp;
                }
            }
        }
    }
}

