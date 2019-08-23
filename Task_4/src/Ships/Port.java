package Ships;

public class Port
{
    private final int size = 500;
    private int counter = (int)(Math.random()*500);

    public int getSize() {
        return size;
    }

    public int getCounter() {
        return counter;
    }

    public void minus(int count)
    {
        this.counter -= count;
    }

    public void add(int count) {
        this.counter += count;
    }
}
