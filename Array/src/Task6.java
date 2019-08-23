import java.util.Scanner;

public class Task6
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: ");
        double sum = 0;
        int n = in.nextInt();
        double [] array = new double[n];
        System.out.print( " Array:");
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Math.round(((Math.random() * 50) - 25) * 100.0) / 100.0;
            System.out.print( "  " + array[i]);
        }
        for (int i = 0; i < array.length; i++)
        {
            int kol = -1;
            for (int j = 2; j < i ; j++)
            {
              if ( i % j == 0)
              {
                  kol++;
              }
            }
            if((kol == -1 || i == 1 || i == 2) && i!= 0)
            {
                System.out.print( "\n Element = " + array[i] + " - Its index is prime = " + i + ";");
                sum = sum + array[i];
            }
        }
        System.out.println( "\n Sum of these elements = " + Math.round(sum * 100.0) / 100.0);
    }
}
