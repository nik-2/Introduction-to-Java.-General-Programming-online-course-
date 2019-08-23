import java.util.Scanner;


public class Task11
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input first number: ");
        double n1 = Math.round(in.nextDouble() * 1000.0) / 1000.0;
        System.out.println( " Input second number: ");
        double n2 = Math.round(in.nextDouble() * 1000.0) / 1000.0;
        int n1_kol = kol_num(n1);
        int n2_kol = kol_num(n2);
        System.out.println( " First number '" + n1 + "' have number of digits = " + n1_kol);
        System.out.println( " Second number '" + n2 + "' have number of digits = " + n2_kol);
        max(n1_kol, n2_kol);
    }

    public static int kol_num(double n)
    {
        int kol = 0;
        int temp = (int)n;
            while (Math.round(n * Math.pow(10, kol) * 1000.0) / 1000.0 - (int) (n * Math.pow(10, kol)) != 0) {
                kol++;
            }
        do {
            kol++;
            temp = temp / 10;
        }while (temp != 0 );
        return kol;
    }

    public static void max(int a, int b)
    {
        if( a > b)
        {
            System.out.println( " In the first number, the number of digits is greater...");
        }
        if ( a < b)
        {
            System.out.println( " In the second number, the number of digits is greater...");
        }
        if ( a == b)
        {
            System.out.println( " In the first and second numbers the number of digits is the same...");
        }
    }
}
