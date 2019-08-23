import java.util.Scanner;

public class Task9
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the first side of the quad: ");
        int X = in.nextInt();
        System.out.println( " Input the second side of the quad: ");
        int Y = in.nextInt();
        System.out.println( " Input the third side of the quad: ");
        int Z = in.nextInt();
        System.out.println( " Input the fourth side of the quad: ");
        int T = in.nextInt();
        System.out.println( " Angel between sides '" + X + "' and '" + Y + "' = 90...");
        QuadArea(X, Y, Z, T);
    }

    public static double AreaRectangularTriangle(int a, int b)
    {
        double S = 0.5 * a * b;
        return S;
    }

    public static double ThirdSideRectangularTriangle(int a, int b)
    {
        double c = Math.sqrt(a*a + b*b);
        return c;
    }

    public static double PerimeterTriangle(int a, int b, int c, int d)
    {
        double per = (c + d + ThirdSideRectangularTriangle(a, b)) * 0.5;
        return  per;
    }

    public static double AreaSimpleTriangle(int a, int b, int c, int d)
    {
        double S = Math.sqrt(PerimeterTriangle(a, b, c, d) * (PerimeterTriangle(a, b, c, d) - c ) * (PerimeterTriangle(a, b, c, d) - d ) * (PerimeterTriangle(a, b, c, d) - ThirdSideRectangularTriangle(a, b) ));
        return S;
    }

    public static void QuadArea(int a, int b, int c, int d)
    {
        double S = Math.round((AreaSimpleTriangle(a, b, c, d) + AreaRectangularTriangle( a, b)) * 1000.0) / 1000.0;
        System.out.println( " Quad area: " + S);
    }
}
