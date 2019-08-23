package com.company;

import java.math.BigInteger;

public class Task1_1_4
{
    public static void main(String[] args)
    {
        BigInteger rez = new BigInteger("1");
        for ( int x = 1; x <= 200; x++)
        {
            BigInteger bix = BigInteger.valueOf(x);
            rez = rez.multiply(bix.multiply(bix));
        }
        System.out.println(" The product of the squares of the first two hundred numbers: " + rez);
    }
}
