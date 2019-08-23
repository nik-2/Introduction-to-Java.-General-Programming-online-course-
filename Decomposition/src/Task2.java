import java.util.Scanner;

public class Task2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input the first natural number: ");
        int a = in.nextInt();
        System.out.println(" Input the second natural number: ");
        int b = in.nextInt();
        System.out.println(" Input the third natural number: ");
        int c = in.nextInt();
        System.out.println(" Input the fourth natural number: ");
        int d = in.nextInt();
        FirstHOD(a, b, c, d);
        SecondHOD(a, b, c, d);
    }


    public static void SecondHOD(int a, int b, int c, int d)
    {
        int HOD = 0;
        while(a != 0 && b != 0)
        {
            if(a > b)
            {
                a = a % b;
            }
            else
            {
                b = b % a;
            }
            if(a == 0)
            {
                HOD = b;
            }
            if(b == 0)
            {
                HOD = a;
            }
        }
        while(c != 0 && HOD != 0)
        {
            if(c > HOD)
            {
                c = c % HOD;
            }
            else
            {
                HOD = HOD % c;
            }
            if(HOD == 0)
            {
                HOD = c;
            }
        }
        while(d != 0 && HOD != 0)
        {
            if(d > HOD)
            {
                d = d % HOD;
            }
            else
            {
                HOD = HOD % d;
            }
            if(HOD == 0)
            {
                HOD = d;
            }
        }
        System.out.println( " HOD using the second method: " + HOD);
    }


    public static void FirstHOD(int a, int b, int c, int d)
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
        if (d < HOD)
        {
            HOD = d;
        }
        while ( a % HOD != 0 || b % HOD != 0 || c % HOD != 0 || d % HOD != 0)
        {
            HOD--;
        }
        System.out.println( " HOD using the first method: " + HOD);
    }
}
