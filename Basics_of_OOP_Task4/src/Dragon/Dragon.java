package Dragon;

public class Dragon
{
    private String dragonName;

    public Dragon(String dragonName)
    {
        this.dragonName = dragonName;
    }

    private String getDragonName() {
        return dragonName;
    }

    public String toString(){
        return String.format("Имя дракона: %1$-15s", getDragonName());
    }
}
