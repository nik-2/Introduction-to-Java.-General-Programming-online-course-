import java.util.Scanner;

public class Task5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: ");
        int n = in.nextInt();
        int kol = 0;
        int [] array = new int[n];
        System.out.print( " Array:");
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)Math.round(Math.random() * 50) - 25;
            System.out.print( "  " + array[i]);
        }
        for (int i = 0; i < array.length; i++)
        {
            if(array[i] > i)
            {
                kol++;
                System.out.print( "\n Element = " + array[i] + " - His index = " + i + ";");
            }
        }
        if(kol != 0)
        {
            System.out.print("\n New array:");
            for (int i = 0; i < array.length; i++) {
                if (array[i] > i) {
                    System.out.print("  " + array[i]);
                }
            }
        }
        else
        {
            System.out.print( "\n There are no numbers for which a[i] > i. ");
        }
    }
}
