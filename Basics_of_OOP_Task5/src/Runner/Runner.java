package Runner;

import Bouquet.Bouquet;
import Flowers.Chamomile;
import Flowers.Pion;
import Flowers.Rose;
import Pack.Pack;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Runner
{
    private static int checkAndPrintLenth() {
        Scanner in = new Scanner(System.in);
        int stemLength;
        do {
            System.out.println("Пожалуйста, введите длину стебля большую нуля: ");
            while (!in.hasNextInt()) {
                System.out.println("Это не число! Попробуйте снова: ");
                in.next();
            }
            stemLength = in.nextInt();
        } while (stemLength <= 0);
        return stemLength;
    }

    private static String checkAndPrintString(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        while (!Pattern.matches("^[А-Яа-яa-zA-Z]+[\\s-]?[([А-Яа-яa-zA-Z]+)[\\s-]?]*$", str)){
            System.out.println("Некорректный ввод! Попробуйте снова: ");
            str = in.nextLine();
        }
        return str.trim();
    }


    public static void main(String[] args) {
        System.out.print("Введите название букета: ");
        String bouquetName = checkAndPrintString();
        System.out.print("Введите материал упаковки: ");
        String material = checkAndPrintString();
        System.out.print("Введите цвет упаковки: ");
        String color = checkAndPrintString();
        Pack pack = new Pack(material, color);
        Bouquet bouquet = new Bouquet(bouquetName, pack);
        Chamomile chamomile = new Chamomile(checkAndPrintLenth());
        Rose rose = new Rose(checkAndPrintLenth());
        Pion pion = new Pion(checkAndPrintLenth());
        bouquet.addFlower(chamomile);
        bouquet.addFlower(rose);
        bouquet.addFlower(pion);
        System.out.println(bouquet);
    }
}
