public class Engine
{
    public boolean state = false;

    public void start()
    {
        if (state)
        {
            System.out.println("Двигатель уже заведен");
        }
        else {
            state = true;
            System.out.println("Двигатель заведен");
        }
    }

    public void stop()
    {
        if (!state)
        {
            System.out.println("Двигатель и так отключен");
        }
        else {
            state = false;
            System.out.println("Двигатель отключен");
        }
    }
}
