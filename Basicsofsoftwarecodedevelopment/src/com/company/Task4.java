package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task4
{
    public static void main(String[] args)
    {
        System.out.println(" Input number: ");
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        BigDecimal bdFractional = new BigDecimal((n));
        BigDecimal bdInteger = new BigDecimal(n);
        bdFractional = bdFractional.setScale(3, BigDecimal.ROUND_HALF_UP);
        bdInteger = bdInteger.setScale(0, BigDecimal.ROUND_DOWN);
        bdFractional = bdFractional.subtract(bdInteger);
        double fractional = bdFractional.doubleValue();
        double integer = bdInteger.doubleValue();
        System.out.println(" Int part: " + integer);
        System.out.println(" Double part: " + fractional);
        double x = 10;
        while( (integer / x) > 1 )
        {
        x = x * 10;
        }
        double newInteger = fractional * 1000;
        System.out.println(" NewInt part: " + newInteger);
        double newFractional = integer / x;
        System.out.println(" New double part:" + newFractional);
        double rez = newInteger + newFractional;
        System.out.println(" Rez = " + rez);
    }
}
