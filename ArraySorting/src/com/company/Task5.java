package com.company;

import java.util.Scanner;

public class Task5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int n = in.nextInt();
        int [] array = new int[n];
        System.out.print( " Array:  ");
        for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100) - 50;
            System.out.print( array[i] + "  ");
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if( array[i] > array[i + 1])
            {
                temp = i;
                break;
            }
        }
        for (int i = (temp + 1); i < array.length; i++) {
            int place = BinarySearch(array, array[i], i - 1);
            for (int j = i; j > place ; j--) {
                int perm = array[j];
                array[j] = array[j - 1];
                array[j - 1] = perm;
            }
        }
        System.out.print( "\n New sorted array:  ");
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[i] + "  ");
        }
    }

    public static int BinarySearch(int arr[], int element, int index) {
        int left = 0;
        int right = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(element < arr[mid])
            {
                if(mid == 0)
                {
                    return mid;
                }
                right = mid - 1;
            }
            if (element < arr[mid] && element >= arr[mid - 1]) {
                return mid;
            }
            if(element < arr[mid])
            {
                right = mid - 1;
            }
            if( element > arr[mid] && element <= arr[mid + 1])
            {
                return (mid + 1);
            }
            if(element > arr[mid])
            {
                left = mid + 1;
            }
        }
        return - 1;
    }
}