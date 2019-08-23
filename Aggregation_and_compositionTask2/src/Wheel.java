public class Wheel
{
    public String wheel;

    Wheel(String wheel)
    {
        setWheel(wheel);
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public void changeWheel()
    {
        System.out.println("Заменяем " + getWheel() + " колесо");
    }
}
