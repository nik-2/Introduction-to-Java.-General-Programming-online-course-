import java.util.Scanner;

public class Task13
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Enter start of line > 2(natural number): ");
        int n = in.nextInt();
        simplenumber(n);
        simplenumbertwins(n);
    }

    public static void simplenumbertwins( int n)
    {
        int kol = 0;
        int temp = -5;
        for (int i = n; i <= 2 * n; i++) {
            for (int j = 2; j < n; j++) {
                if( i % j == 0)
                {
                    kol++;
                }
            }
            if(kol == 0)
            {
                int a = i;
                if( (a - temp) == 2)
                {
                    System.out.println( " Primes '" + temp + "' and '" + a + "' - twins...");
                }
                temp = a;
            }
            kol = 0;
        }
    }

    public static void simplenumber( int n)
    {
        int kol = 0;
        System.out.print( " Prime numbers from the gap [" + n + "," + 2*n + "]:  ");
        for (int i = n; i <= 2 * n; i++) {
            for (int j = 2; j < n; j++) {
                if( i % j == 0)
                {
                    kol++;
                }
            }
            if(kol == 0)
            {
                System.out.print( i + "  ");
            }
            kol = 0;
        }
        System.out.println();
    }
}
