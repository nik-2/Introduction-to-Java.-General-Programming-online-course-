import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the length of the side of a regular hexagon: ");
        int a = in.nextInt();
        double S = Math.round((6 * SquareRightTriangle(a)) * 100.0 ) / 100.0;
        System.out.println( " Regular hexagon area: " + S);

    }

    public static double SquareRightTriangle(int a)
    {
        double S = 0.25 * a * a * Math.sqrt(3);
        return S;
    }
}
