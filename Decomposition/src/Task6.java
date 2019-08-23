import java.util.Scanner;

public class Task6
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input the first natural number: ");
        int a = in.nextInt();
        System.out.println(" Input the second natural number: ");
        int b = in.nextInt();
        System.out.println(" Input the third natural number: ");
        int c = in.nextInt();
        if (HOD(a, b, c) == 1)
        {
            System.out.println( " These numbers are mutually simple!");
        }
        else {
            System.out.println( " These numbers aren't mutually simple!");
        }
    }

    public static int HOD(int a, int b, int c)
    {
        int HOD = a;
        if(b < HOD)
        {
            HOD = b;
        }
        if (c < HOD)
        {
            HOD = c;
        }
        while ( a % HOD != 0 || b % HOD != 0 || c % HOD != 0)
        {
            HOD--;
        }
        System.out.println( " HOD: " + HOD);
        return HOD;
    }
}
