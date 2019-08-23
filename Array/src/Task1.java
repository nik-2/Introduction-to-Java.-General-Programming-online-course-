import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        System.out.println( " Input size array: ");
        int n = in.nextInt();
        System.out.println( " The number to divide: ");
        int div = in.nextInt();
        int [] array = new int [n];
        System.out.print(" Array: ");
        for (int i = 0; i < array.length ; i++)
        {
            array[i] = (int)Math.round((Math.random() * 49) + 1);
            System.out.print(" " + array[i] );
        }
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] % div == 0)
            {
                sum = sum + array[i];
                System.out.print( "\n The number " + array[i] + " is a multiple of " + div);
            }
        }
        if ( sum == 0 )
        {
            System.out.print( "\n There are no multiples of " + div);
        }
        else
        {
            System.out.print( "\n The sum of these numbers = " + sum);
        }
    }
}
