public class Task7
{
    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if(i % 2 !=0)
            {
              sum = sum + Factorial(i);
            }
        }
        System.out.println( " The sum of factorials the odd numbers = " + sum);
    }

    public static int Factorial(int n)
    {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println( " Factorial '" + n + "' = " + fact);
        return fact;
    }
}
