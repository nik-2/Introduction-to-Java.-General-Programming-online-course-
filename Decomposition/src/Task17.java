import java.util.Scanner;

public class Task17
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input a positive number: ");
        int n = in.nextInt();
        amountminus(n);
    }

    public static int kolnumber(int n)
    {
        int temp = n;
        int kol = 0;
        while(temp >= 1)
        {
            temp = temp / 10;
            kol++;
        }
        return kol;
    }

    public static int sumnumber(int n)
    {
        int temp;
        int kol = kolnumber(n);
        int sum = 0;
        for (int i = 1; i <= kol ; i++) {
            temp = n / 10;
            temp = temp * 10;
            temp = n - temp;
            n = n / 10;
            sum = sum + temp;
        }
        return sum;
    }

    public static void amountminus(int n)
    {
        int rez = n;
        int kol = 0;
        while(rez != 0){
            int sum = sumnumber(rez);
            System.out.println( " " + (kol + 1) + " action = " + rez + " - " + sum + " = " + (rez - sum));
            rez = rez - sum;
            kol++;
        }
        System.out.println( " Number of actions = " + kol);
    }
}
