import java.util.Scanner;

public class Task10
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the natural number: ");
        int n = in.nextInt();
        FindNumb(n);
    }

    public static void FindNumb(int n)
    {
        int temp = n;
        int kol = 0;
        while(temp >= 1)
        {
            temp = temp / 10;
            kol++;
        }
        int[] array = new int[kol];
        System.out.print( " Array:  ");
        for (int i = array.length - 1; i >= 0 ; i--) {
            temp = n / 10;
            temp = temp * 10;
            temp = n - temp;
            n = n / 10;
            array[i] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[i] + "  ");
        }
    }
}
