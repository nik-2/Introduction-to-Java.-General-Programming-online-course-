import java.util.Scanner;

public class Task4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println( " Input the number of point: ");
        int n = in.nextInt();
        int [] x = new int[n];
        int [] y = new int[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = (int)(Math.random() * 20) - 10;
            y[i] = (int)(Math.random() * 20) - 10;
            System.out.println( " Point number " + (i + 1) + " has coordinates (" + x[i] + ";" + y[i] + ")");
        }
        length(x, y);
    }

    public static void length(int x[],int y[])
    {
        double max = 0;
        int start_max = 0;
        int i_max = 0;
        int start = 0;
        do {
            for (int i = start + 1; i < x.length; i++) {
                double length = Math.round((Math.sqrt(Math.pow((x[start] - x[i]),2) + Math.pow((y[start] - y[i]),2))) * 100.0) / 100.0;
                System.out.println( " The length between point number " + (start + 1) + " and point number " + (i + 1) + " = " + length);
                if(length > max)
                {
                    max = length;
                    start_max = start;
                    i_max = i;
                }
            }
            start++;
        }while(start != x.length);
        System.out.println( " The max length between point number " + (start_max + 1) + " and point number " + (i_max + 1) + " = " + max);
    }
}
