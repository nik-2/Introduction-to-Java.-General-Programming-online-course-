import java.util.Scanner;

public class Task15
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " What N-digit numbers will we study?\n Input N: ");
        int n = in.nextInt();
        System.out.println( " Numbers with strictly increasing sequence:");
        LineOfNumbers(n);
    }

    public static void LineOfNumbers(int n)
    {
        for (int i = (int)Math.pow(10,(n - 1)); i < (int)Math.pow(10,n); i++) {
            int dop_i = i;
            for (int j = 1, prev = 10; j <= n ; j++) {
                int temp = dop_i / 10;
                temp = temp * 10;
                temp = dop_i - temp;
                dop_i = dop_i / 10;
                if( temp >= prev)
                {
                    break;
                }
                prev = temp;
                if(j == n)
                {
                    System.out.println( i );
                }
            }
        }
    }
}
