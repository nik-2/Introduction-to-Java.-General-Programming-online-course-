package com.company;

public class Test2
{
    private int x;
    private int y;

    private Test2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Test2() {
        x = 5;
        y = 6;
    }

    private int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    private int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Test2 constructor1 = new Test2();
        Test2 constructor2 = new Test2(10, 20);
        System.out.println( " x1 = " + constructor1.getX());
        System.out.println( " y1 = " + constructor1.getY());
        System.out.println( " x2 = " + constructor2.getX());
        System.out.println( " y2 = " + constructor2.getY());
        constructor1.setX(20);
        constructor1.setY(50);
        System.out.println( " x1 = " + constructor1.getX());
        System.out.println( " y1 = " + constructor1.getY());
    }
}
