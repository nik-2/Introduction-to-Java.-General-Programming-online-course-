package com.company;

public class Task1_1_6
{
    public static void main(String[] args)
    {
        for( int x = 0; x <= 255; x++)
        {
            if ( x % 5 == 0)
            {
                System.out.println( "\n");
            }
            System.out.print( "     Code " + x + " - " + (char)x);
        }
    }
}
