package Flowers;

public class Flower
{
    private String flowerName;
    private int stemLength;
    Flower(String flowerName, int stemLength)
    {
        this.flowerName = flowerName;
        this.stemLength = stemLength;
    }

    private String getFlowerName() {
        return flowerName;
    }

    private int getStemLength() {
        return stemLength;
    }

    public String toString()
    {
        return String.format(" %1$20s| Длина стебля: %2$-3d\n", getFlowerName(), getStemLength());
    }
}
