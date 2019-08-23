import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the first natural number: ");
        int a = in.nextInt();
        System.out.println( " Input the second natural number: ");
        int b = in.nextInt();
        int HOD = FirstHOD(a, b);
        int HOK = FirstHOK(a, b);
        System.out.println( " HOD using the first method: " + HOD);
        System.out.println( " HOK using the first method: " + HOK);
        HOD = SecondHOD(a, b);
        HOK = SecondHOK(a, b);
        System.out.println( " HOD using the second method: " + HOD);
        System.out.println( " HOK using the second method: " + HOK);
    }

    public static int FirstHOD(int a, int b)
    {
        while ( a != 0 && b != 0 )
        {
            if(a > b)
            {
                a = a % b;
            }
            else
            {
                b = b % a;
            }
        }
        return a + b;
    }
    public static int SecondHOD(int a, int b)
    {
        return (a*b)/SecondHOK(a, b);
    }
    public static int FirstHOK(int a, int b)
    {
        return (a*b)/FirstHOD(a,b);
    }
    public static int SecondHOK(int a, int b)
    {
        int HOK;
        if ( a < b )
        {
            HOK = a;
            while (HOK % a != 0 || HOK % b !=0)
            {
                HOK = HOK + a;
            }
        }
        else
        {
            HOK = b;
            while (HOK % a != 0 || HOK % b !=0)
            {
                HOK = HOK + b;
            }
        }
        return HOK;
    }
}
