import java.util.Scanner;

public class Task4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input size array: ");
        int n = in.nextInt();
        double [] array = new double [n];
        System.out.print(" Array:");
        for (int i = 0; i < array.length ; i++)
        {
            array[i] = Math.round(((Math.random() * 100) - 50) * 100.0) / 100.0;
            System.out.print("  " + array[i] );
        }
        double max = array[0];
        int max_i = 0;
        double min = array[0];
        int min_i = 0;
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] > max)
            {
                max = array[i];
                max_i = i;
            }
            if( array[i] < min)
            {
                min = array[i];
                min_i = i;
            }
        }
        System.out.print("\n Maximum element = " + max + ", His index = " + max_i + "; \n Minimum element = " + min + ", His index = " + min_i + ";");
        array[max_i] = array[min_i];
        array[min_i] = max;
        System.out.print(" \n Modified array:");
        for (int i = 0; i < array.length ; i++)
        {
            System.out.print("  " + array[i] );
        }
    }
}
