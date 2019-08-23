package Cave;
import Dragon.Dragon;
import Treasure.Treasure;

import java.io.FileReader;
import java.util.Scanner;

public class Cave
{
    private String caveName;
    private Dragon dragon;
    private Treasure treasure;
    public Cave(String caveName, Dragon dragon, Treasure treasure){
        this.caveName = caveName;
        this.dragon = dragon;
        this.treasure = treasure;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public String getCaveName() {
        return caveName;
    }

    public void getTreasure() throws Exception
    {
        FileReader fileReaderName = new FileReader(this.treasure.getTreasureName());
        FileReader fileReaderPrice = new FileReader(this.treasure.getTreasurePrice());
        Scanner scannerName = new Scanner(fileReaderName);
        Scanner scannerPrice = new Scanner(fileReaderPrice);
        int i = 1;
        System.out.printf("%1$40s\n","СПИСОК СОКРОВИЩ");
        while (scannerName.hasNextLine() && scannerPrice.hasNextInt())
        {
            System.out.printf( "Cокровище %1$-5d| Название: %2$-20s| Цена: %3$-10d\n", i, scannerName.nextLine(), scannerPrice.nextInt());
            i++;
        }
        fileReaderName.close();
        fileReaderPrice.close();
    }

    public void getMaxPrice() throws Exception
    {
        FileReader fileReaderName = new FileReader(this.treasure.getTreasureName());
        FileReader fileReaderPriceSearchMax = new FileReader(this.treasure.getTreasurePrice());
        FileReader fileReaderPriceMax = new FileReader(this.treasure.getTreasurePrice());
        Scanner scannerPriceMax = new Scanner(fileReaderPriceMax);
        Scanner scannerName = new Scanner(fileReaderName);
        Scanner scannerPriceSearchMax = new Scanner(fileReaderPriceSearchMax);
        int max_price = 0;
        while (scannerPriceSearchMax.hasNextInt())
        {
            int max = scannerPriceSearchMax.nextInt();
            if(max > max_price)
            {
                max_price = max;
            }
        }
        fileReaderPriceSearchMax.close();
        int i = 1;
        System.out.printf("\n%1$45s\n","СПИСОК САМЫХ ДОРОГИХ СОКРОВИЩ");
        while (scannerName.hasNextLine() && scannerPriceMax.hasNextInt())
        {
            int temp = scannerPriceMax.nextInt();
            if(temp == max_price)
            {
                System.out.printf( "Cокровище %1$-5d| Название: %2$-20s| Цена: %3$-10d\n", i, scannerName.nextLine(), temp);
            }
            else
            {
                scannerName.nextLine();
            }
            i++;
        }
        fileReaderName.close();
        fileReaderPriceMax.close();
    }

    public void getPrice(int price) throws Exception
    {
        FileReader fileReaderName = new FileReader(this.treasure.getTreasureName());
        FileReader fileReaderPrice = new FileReader(this.treasure.getTreasurePrice());
        Scanner scannerName = new Scanner(fileReaderName);
        Scanner scannerPrice = new Scanner(fileReaderPrice);
        int i = 1;
        int kol = 0;
        System.out.printf("\n%1$50s\n","СПИСОК СОКРОВИЩ НА ЗАДАННУЮ ЦЕНУ");
        while (scannerName.hasNextLine() && scannerPrice.hasNextInt())
        {
            int temp = scannerPrice.nextInt();
            if (temp == price) {
                System.out.printf("Cокровище %1$-5d| Название: %2$-20s| Цена: %3$-10d\n", i, scannerName.nextLine(), temp);
                kol++;
            }
            else{
                scannerName.nextLine();
            }
            i++;
        }
        if(kol == 0)
        {
            System.out.println("Сокровищ на заданную цену нет...");
        }
        fileReaderName.close();
        fileReaderPrice.close();
    }
}
