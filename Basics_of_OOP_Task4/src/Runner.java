import Cave.Cave;
import Dragon.Dragon;
import Treasure.Treasure;

import java.util.Scanner;

public class Runner
{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Cave cave = new Cave("Чертоги дракона", new Dragon("Алекстраза"),
                    new Treasure("..\\Basics_of_OOP_Task4\\src\\Treasure\\NameTreasure.txt",
                                "..\\Basics_of_OOP_Task4\\src\\Treasure\\PriceTreasure.txt"));
        System.out.printf("%1$50s\n%2$50s\n","Название пещеры: " + cave.getCaveName(), cave.getDragon());
        cave.getTreasure();
        cave.getMaxPrice();
        System.out.println("\nВведите цену на которую хотите посмотреть сокровища: ");
        int price = in.nextInt();
        cave.getPrice(price);
    }
}
