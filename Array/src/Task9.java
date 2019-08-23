import java.util.Scanner;

public class Task9
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
            array[i] = (int)Math.round(Math.random() * 10) - 5;
            System.out.print( "  " + array[i]);
        }
        int kol_max = 0;
        int value_min = array[0];
        for (int i = 0; i < array.length; i++)
        {
            int kol = 0;
            for (int j = 0; j < array.length; j++)
            {
                if(array[i] == array[j])
                {
                    kol++;
                }
            }
            if( (kol > kol_max) || (kol == kol_max && array[i] < value_min))
            {
                value_min = array[i];
                kol_max = kol;
            }
        }
        System.out.println( "\n The smallest most common number: " + value_min + " \n Number meets " + kol_max + " times");
    }
}
