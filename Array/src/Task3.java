import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int kol_pos = 0;
        int kol_neg = 0;
        int kol_0 = 0;
        System.out.println( " Input size array: ");
        int n = in.nextInt();
        double [] array = new double [n];
        System.out.print(" Array: ");
        for (int i = 0; i < array.length ; i++)
        {
            array[i] = Math.round(((Math.random() * 100) - 50) * 100.0) / 100.0;
            System.out.print("  " + array[i] );
        }
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] > 0)
            {
                kol_pos++;
                System.out.print( "\n The number " + array[i] + " > 0");
            }
            if( array[i] < 0)
            {
                kol_neg++;
                System.out.print("\n The number " + array[i] + " < 0");
            }
            if( array[i] == 0)
            {
                kol_0++;
            }
        }
        System.out.print("\n Amount positive elements = " + kol_pos + "; \n Amount negative elements = " + kol_neg + "; \n Amount 0 elements = " + kol_0 + ";");
    }
}
