import java.util.Scanner;

public class Runner
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        Notebook notebook = new Notebook();
        int kod;
        do {
            System.out.println("Введите '1' - чтобы просмотреть заметки\n" +
                    "Введите '2' - чтобы добавить заметку\n" +
                    "Введите '3' - чтобы найти заметки добавленные в определённую дату\n" +
                    "Введите '4' - чтобы найти заметки с определённым заголовком\n" +
                    "Введите '5' - чтобы нйти заметки в содержании которых встречается определённое слово\n" +
                    "Введите '6' - чтобы найти заметки с определённым e-mail\n" +
                    "Введите '7' - чтобы отсортировать заметки по заголовку\n" +
                    "Введите '8' - чтобы отсортировать заметки по дате добавления\n" +
                    "Введите '9' - чтобы отсортировать заметки по по e-mail\n" +
                    "Введите '0' - чтобы выйти\n");
            do {
                System.out.println("Пожалуйста, введите число от '0' до '9'");
                while (!in.hasNextInt()) {
                    System.out.println("Это не число! Попробуйте снова: ");
                    in.next();
                }
                kod = in.nextInt();
                in.nextLine();
            } while (kod < 0 || kod > 9);
            switch (kod) {
                case 1:
                    notebook.printNotebook();
                    break;
                case 2:
                    notebook.addNote();
                    break;
                case 3:
                    notebook.searchAndPrintByDate();
                    break;
                case 4:
                    notebook.searchAndPrintByTopic();
                    break;
                case 5:
                    notebook.searchAndPrintByText();
                    break;
                case 6:
                    notebook.searchAndPrintByMail();
                    break;
                case 7:
                    notebook.sortByTopic();
                    break;
                case 8:
                    notebook.sortByDate();
                    break;
                case 9:
                    notebook.sortByMail();
                    break;
            }
        }while (kod != 0);
    }
}
