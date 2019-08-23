import java.util.Scanner;

public class Task10
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input array size: ");
        int n = in.nextInt();
        int [] array = new int[n];
        System.out.print( " Array:");
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)Math.round(Math.random() * 20) - 10;
            System.out.print( "  " + array[i]);
        }
        for (int i = 1; i <= array.length / 2 ; i++)
        {
            int c = i;
            for (int j = i + 1; j < array.length; j++)
            {
                array[c] = array[j];
                c++;
            }
            array[array.length - i] = 0;
        }
        System.out.print( "\n New array:");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print( "  " + array[i]);
        }
    }
}
