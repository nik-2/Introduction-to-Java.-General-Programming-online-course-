import java.util.Scanner;

public class Task2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int kol = 0;
        System.out.println( " Input size array: ");
        int n = in.nextInt();
        System.out.println( " The number to compare: ");
        double compare = in.nextInt();
        double [] array = new double [n];
        System.out.print(" Array: ");
        for (int i = 0; i < array.length ; i++)
        {
            array[i] = Math.round(((Math.random() * 100) - 50) * 100.0) / 100.0;
            System.out.print("  " + array[i] );
        }
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] > compare)
            {
                kol++;
                System.out.print( "\n The number " + array[i] + " > " + compare);
                array[i] = compare;
            }
        }
        if ( kol == 0 )
        {
            System.out.print( "\n There are no numbers > " + compare);
        }
        else
        {
            System.out.print( "\n After replacement array:");
            for (int i = 0; i < array.length ; i++)
            {
                System.out.print("  " + array[i] );
            }
            System.out.println("\n Number of replacements = " + kol);
        }
    }
}