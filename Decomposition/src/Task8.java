import java.util.Scanner;

public class Task8
{
    public static void main(String[] args)
    {
        int kod;
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int n = in.nextInt();
        int [] array = new int[n];
        System.out.println( " Array:  ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 20) - 10;
            System.out.print( array[i] + "  ");
        }
        System.out.println();
        do {
            SumOfThree(array);
            System.out.println( " Input '0' to exit or another number to repeat...");
            kod = in.nextInt();
        }while(kod != 0);
    }

    public static void SumOfThree(int arr[])
    {
        int sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the index of the first of three consecutive elements <= " + (arr.length - 3) + " : ");
        int k = in.nextInt();
        for (int i = k; i < k + 3; i++) {
            sum = sum + arr[i];
        }
        System.out.println( " Sum of elements: D[" + k + "] + D[" + (k + 1) + "] + D[" + (k + 2) + "] = " + sum);
    }
}
