package Pack;

public class Pack
{
    private String material;
    private String color;
    public Pack(String material, String color){
        this.material = material;
        this.color = color;
    }

    private String getMaterial() {
        return material;
    }

    private String getColor() {
        return color;
    }

    public String toString()
    {
        return String.format("%1$32s\n Материал упаковки - %2$-10s| Цвет упаковки - %3$-10s","УПАКОВКА",
                getMaterial(),getColor());
    }
}
