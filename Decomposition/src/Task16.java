import java.util.Scanner;

public class Task16
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " What N-digit numbers will we study?\n Input N: ");
        int n = in.nextInt();
        System.out.println( " The sum of " + n + "-digit numbers with odd numbers only = " + sumnumber(n));
        System.out.println( " The number of even digits in the number '" + sumnumber(n) + "' = " + amountevendigits(sumnumber(n)));
    }

    public static int sumnumber(int n)
    {
        int sum = 0;
        for (int i = (int) Math.pow(10, (n - 1)); i < (int) Math.pow(10, n); i++) {
            int dop_i = i;
            for (int j = 1; j <= n; j++) {
                int temp = dop_i / 10;
                temp = temp * 10;
                temp = dop_i - temp;
                dop_i = dop_i / 10;
                if (temp % 2 == 0) {
                    break;
                }
                if (j == n) {
                    sum = sum + i;
                }
            }
        }
        return sum;
    }

    public static int kolnumber(int number)
    {
        int temp = number;
        int kol = 0;
        while(temp >= 1)
        {
            temp = temp / 10;
            kol++;
        }
        return kol;
    }

    public static int amountevendigits(int number)
    {
        int kol_even = 0;
        int kol_number = kolnumber(number);
        for (int j = 1; j <= kol_number; j++) {
            int temp = number / 10;
            temp = temp * 10;
            temp = number - temp;
            number = number / 10;
            if (temp % 2 == 0){
                kol_even++;
            }
        }
        return kol_even;
    }
}
