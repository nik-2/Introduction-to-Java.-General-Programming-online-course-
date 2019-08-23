package Bouquet;

import Flowers.Flower;
import Pack.Pack;

import java.util.ArrayList;
import java.util.List;

public class Bouquet
{
    private Pack pack;
    private List<Flower> flowers = new ArrayList<>();
    private String bouquetName;

    public Bouquet(String bouquetName, Pack pack)
    {
        this.bouquetName = bouquetName;
        this.pack = pack;
    }

    public void addFlower(Flower flower)
    {
        this.flowers.add(flower);
    }

    private StringBuilder showFlowers()
    {
        StringBuilder strFlowers = new StringBuilder();
        for (Flower i:this.flowers) {
            strFlowers.append(i);
        }
        return strFlowers;
    }

    private String getBouquetName() {
        return this.bouquetName;
    }

    public String toString()
    {
        return String.format("%1$30s: \"%2$1s\"\n%3$-1s\n%4$36s\n%5$1s", "НАЗВАНИЕ БУКЕТА", getBouquetName(),
                this.pack, "СОДЕРЖИМОЕ БУКЕТА", showFlowers());
    }
}
