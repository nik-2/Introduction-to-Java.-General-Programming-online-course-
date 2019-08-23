package Ships;

import Ships.Type.Type;

public class Ship {
    private int count;
    private final int size;
    private Type type;

    public Ship(Type type) {
        this.size = 50;
        this.type = type;
        if (type.name().equals("ПОЛНЫЙ"))
        {
            this.count = this.size;
        }
        if (type.name().equals("ПУСТОЙ"))
        {
            this.count = 0;
        }
    }

    public void minus(int count)
    {
        this.count -= count;
    }

    public void add(int count) {
        this.count += count;
    }

    public boolean countCheckUnLoad() {
        if (this.count >= this.size) {
            return false;
        }
        return true;
    }

    public boolean countCheckLoad()
    {
        if(this.count <= 0)
        {
            return false;
        }
        return true;
    }

    public int getCount() {
        return count;
    }

    public Type getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
