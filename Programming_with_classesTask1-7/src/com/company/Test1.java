package com.company;

public class Test1
{
    private int x = 5;
    private int y = 6;

    private void print()
    {
        System.out.println(" x = " + x + "\n y = " + y);
    }

    private void change(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    private void sum()
    {
        System.out.println(" Sum(x + y) = " + (x + y));
    }

    private void max()
    {
        if( x > y)
        {
            System.out.println( " x > y ... x = " + x);
        }
        else
        {
            if ( x < y)
            {
                System.out.println( " x < y ... y = " + y);
            }
            else
            {
                System.out.println( " x = y = " + x);
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.print();
        test1.sum();
        test1.max();
        test1.change(15, 10);
        test1.print();
        test1.sum();
        test1.max();
    }
}
