//Task7
package com.company;

import java.util.Scanner;

public class Triangle
{
    private int ab;
    private int ac;
    private int bc;

    private Triangle(int ab, int ac, int bc)
    {
        this.ab = ab;
        this.ac = ac;
        this.bc = bc;
    }

    private int getAb() {
        return ab;
    }

    private int getAc() {
        return ac;
    }

    private int getBc() {
        return bc;
    }

    private void info()
    {
        System.out.println( " The triangle ABC: AB = " + getAb() + "  AC = " + getAc() + "  BC = " + getBc());
    }

    private double perimeter()
    {
        return (getAb() + getAc() + getBc());

    }

    private double square()
    {
        return (Math.sqrt( perimeter()/2 * (perimeter()/2 - getAb()) * (perimeter()/2 - getBc()) * (perimeter()/2 - getAc())));
    }

    private double medianBM()
    {
        return (0.5*Math.sqrt( 2 * getAb()*getAb() + 2 * getBc()*getBc() - getAc()*getAc()));
    }

    private double medianAM()
    {
        return (0.5*Math.sqrt( 2 * getAb()*getAb() + 2 * getAc()*getAc() - getBc()*getBc()));
    }

    private double medianCM()
    {
        return (0.5*Math.sqrt( 2 * getAc()*getAc() + 2 * getBc()*getBc() - getAb()*getAb()));
    }

    private void pointOfMedian()
    {
        System.out.println(" The intersection point of the medians divides the median AM = " + Math.round(medianAM()*1000.0)/1000.0 +
                " into two parts (1: 2) counting from the vertex A: the first part = "
                + Math.round((medianAM()/3) * 1000.0) / 1000.0 + "; the second part = " + Math.round((2*medianAM()/3) * 1000.0) / 1000.0);
        System.out.println(" The intersection point of the medians divides the median BM = " + Math.round(medianBM()*1000.0)/1000.0 +
                " into two parts (1: 2) counting from the vertex B: the first part = "
                + Math.round((medianBM()/3) * 1000.0) / 1000.0 + "; the second part = " + Math.round((2*medianBM()/3) * 1000.0) / 1000.0);
        System.out.println(" The intersection point of the medians divides the median CM = " + Math.round(medianCM() * 1000.0)/1000.0 +
                " into two parts (1: 2) counting from the vertex C: the first part = "
                + Math.round((medianCM()/3) * 1000.0) / 1000.0 + "; the second part = " + Math.round((2*medianCM()/3) * 1000.0) / 1000.0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Triangle triangle;
        System.out.print( " Input side length AB: ");
        int ab = in.nextInt();
        System.out.print( " Input side length AC: ");
        int ac = in.nextInt();
        System.out.print( " Input side length BC: ");
        int bc = in.nextInt();
        triangle = new Triangle(ab, ac, bc);
        triangle.info();
        System.out.println( " Triangle P = " + triangle.perimeter());
        System.out.println( " Triangle S = " + Math.round(triangle.square()* 1000.0) / 1000.0);
        triangle.pointOfMedian();
    }
}
