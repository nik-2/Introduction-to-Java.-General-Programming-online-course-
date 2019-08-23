import java.util.Scanner;

public class Task7
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size (even number): ");
        int n = in.nextInt();
        double [] array = new double[n];
        System.out.print( " Array:");
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Math.round(((Math.random() * 50) - 25) * 100.0) / 100.0;
            System.out.print( "  " + array[i]);
        }
        double max = array[0] + array[array.length - 1];
        int index_i = 0;
        int index_j = 0;
        double max_i = 0;
        double max_j = 0;
        for (int i = 0, j = array.length - 1; i < array.length / 2 && j >= array.length / 2 ;j--, i++)
        {
            if ( (array[i] + array[j]) > max )
            {
                index_i = i;
                index_j = j;
                max_i = array[i];
                max_j = array[j];
                max = array[i] + array[j];
            }
        }
        System.out.println( "\n Maximum amount = " + Math.round(max * 100.0) / 100.0);
        System.out.println( " Its components: number " + max_i + " with an index " + index_i + " and number " + max_j + " with an index " + index_j);
    }
}
