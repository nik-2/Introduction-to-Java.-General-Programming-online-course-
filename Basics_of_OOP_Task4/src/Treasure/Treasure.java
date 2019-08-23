package Treasure;

import java.io.File;

public class Treasure {
    private File treasureName;
    private File treasurePrice;

    public Treasure(String treasureName, String treasurePrice) {
        this.treasureName = new File(treasureName);
        this.treasurePrice = new File(treasurePrice);
    }

    public File getTreasureName() {
        return treasureName;
    }

    public File getTreasurePrice() {
        return treasurePrice;
    }
}