import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TextFILE extends FILE {
    private TextFILE(String dirName, String fileName) {
        super(dirName, fileName);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        TextFILE textFILE = new TextFILE("..\\Basics_of_OOPTask1\\Direction", "file.txt");
        int kod;
        do {
            System.out.println("Введите '1' - чтобы проверить существует ли файл\n" +
                    "Введите '2' - чтобы напечатать файл\n" +
                    "Введите '3' - чтобы создать файл\n" +
                    "Введите '4' - чтобы добаить к файлу текст\n" +
                    "Введите '5' - удалить файл\n" +
                    "Введите '6' - переименовать файл\n" +
                    "Введите '0' - чтобы закончить\n");
            do {
                System.out.println("Пожалуйста, введите число от '0' до '6'");
                while (!in.hasNextInt()) {
                    System.out.println("Это не число! Попробуйте снова: ");
                    in.next();
                }
                kod = in.nextInt();
                in.nextLine();
            } while (kod < 0 || kod > 6);
            switch (kod) {
                case 1:
                    textFILE.check(textFILE.getFile());
                    break;
                case 2:
                    textFILE.print(textFILE.getFile());
                    break;
                case 3:
                    textFILE.create();
                    break;
                case 4:
                    textFILE.append(textFILE.getFile());
                    break;
                case 5:
                    textFILE.deleteFile(textFILE.getFile());
                    break;
                case 6:
                    File file = textFILE.rename(textFILE.getFile());
                    textFILE = new TextFILE(file.getParent(), file.getName());
                    break;
            }
        } while (kod != 0);
    }
}
