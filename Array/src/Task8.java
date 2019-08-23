import java.util.Scanner;

public class Task8
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(" Input array size: ");
        int n = in.nextInt();
        int nMod = n;
        double [] array = new double[n];
        System.out.print( " Array:");
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Math.round(((Math.random() * 50) - 25) * 100.0) / 100.0;
            System.out.print( "  " + array[i]);
        }
        double min = array[0];
        int min_index = 0;
        for (int i = 0; i < array.length; i++)
        {
            if ( array[i] < min )
            {
               min = array[i];
            }
        }
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] == min)
            {
                min_index = i;
                System.out.print( "\n Minimum array element = " + min + " - his index = " + min_index);
                nMod--;
            }
        }
        double [] array_mod = new double[nMod];
        int iMod = -1;
        for (int i = 0; i < array.length; i++)
        {
            if( array[i] != min)
            {
                iMod++;
                array_mod[iMod] = array[i];
            }
        }
        System.out.print( "\n New array:");
        for (int c = 0; c < array_mod.length; c++)
        {
            System.out.print( "  " + array_mod[c]);
        }
    }

}
