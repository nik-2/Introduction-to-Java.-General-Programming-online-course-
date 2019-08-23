import java.util.Scanner;

public class Task12
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input the natural number K: ");
        int k = in.nextInt();
        System.out.println(" Input the natural number N: ");
        int n = in.nextInt();
        createarray(k ,n);
    }

    public  static void createarray(int k, int n)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int size = in.nextInt();
        int[] array = new int[size];
        System.out.print( " Array: ");
        for (int i = 0; i < array.length; i++) {
            do {
                array[i] = (int)(Math.random() * 1000) - 500;
            }while(array[i] > n || sumdigital(array[i]) != k);
            System.out.print( array[i] + "  ");
        }
    }

    public static int sumdigital(int n)
    {
        if (n < 0)
        {
            n = n * (-1);
        }
        int temp = n;
        int sum = 0;
        while(n >= 1)
        {
            temp = n / 10;
            temp = temp * 10;
            temp = n - temp;
            n = n / 10;
            sum = sum + temp;
        }
        return sum;
    }
}
