import java.util.Scanner;

public class Task14
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input a positive number: ");
        int k = in.nextInt();
        System.out.println( " Armstrong numbers from '1' to '" + k + "': ");
        for (int i = 1; i <= k; i++) {
            armstrong(i);
        }
    }

    public static int kolNumber(int k)
    {
        int temp = k;
        int kol = 0;
        while(temp >= 1)
        {
            temp = temp / 10;
            kol++;
        }
        return kol;
    }

    public static int sumNumber(int k)
    {
        int temp;
        int kol = kolNumber(k);
        int sum = 0;
        for (int i = 1; i <= kol ; i++) {
            temp = k / 10;
            temp = temp * 10;
            temp = k - temp;
            k = k / 10;
            sum = sum + (int)Math.pow(temp, kol);
        }
        return sum;
    }

    public static void armstrong(int k)
    {
        if( sumNumber(k) == k)
        {
            System.out.print( "(" + k + "), ");
        }
    }
}
