import java.util.Scanner;

public class Task5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int n = in.nextInt();
        int []array = new int[n];
        System.out.print( " Array:  ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 20) - 10;
            System.out.print( array[i] + "  ");
        }
        premax(array);
    }

    public static int max(int array[])
    {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max)
            {
                max = array[i];
            }
        }
        return max;
    }

    public static void premax(int array[])
    {
        int premax = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > premax && array[i] != max(array))
            {
                premax = array[i];
            }
        }
        System.out.println( "\n Premaximal element: " + premax);
    }
}
