import java.util.Scanner;

public class Runner
{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner (System.in);
        Catalog catalog = new Catalog();
        int kod;
        do {
            System.out.println("Введите '1' - чтобы войти в профиль администратора\n" +
                    "Введите '2' - чтобы войти в профиль пользователя\n" +
                    "Введите '3' - чтобы выйти с профиля админа\n" +
                    "Введите '4' - чтобы выйти с профиля пользователя\n" +
                    "Введите '5' - чтобы зарегистрировать пользователя\n" +
                    "Введите '6' - чтобы просмотреть каталог\n" +
                    "Введите '7' - чтобы найти книгу в каталоге\n" +
                    "Введите '8' - чтобы предложить книгу Администратору\n" +
                    "Введите '9' - чтобы добавить книгу в каталог\n" +
                    "Введите '10' - чтобы проверить почту\n" +
                    "Введите '11' - чтобы проверить базу данных аутентификаций\n" +
                    "Введите '12' - чтобы удалить аккаунты всех зарегистрированных пользователей, " +
                    "очистить почту Администратора и базу данных аутентификций\n" +
                    "Введите '0' - чтобы покинуть сервис\n");
            do {
                System.out.println("Пожалуйста, введите число от '0' до '12'");
                while (!in.hasNextInt()) {
                    System.out.println("Это не число! Попробуйте снова: ");
                    in.next();
                }
                kod = in.nextInt();
                in.nextLine();
            } while (kod < 0 || kod > 12);
            switch (kod) {
                case 1:
                    catalog.logInAdmin();
                    break;
                case 2:
                    catalog.logInUser();
                    break;
                case 3:
                    catalog.logOutAdmin();
                    break;
                case 4:
                    catalog.logOutUser();
                    break;
                case 5:
                    catalog.addUser();
                    break;
                case 6:
                    catalog.printCatalog();
                    break;
                case 7:
                    catalog.serchPrint();
                    break;
                case 8:
                    catalog.offer();
                    break;
                case 9:
                    catalog.addBook();
                    break;
                case 10:
                    catalog.checkMail();
                    break;
                case 11:
                    catalog.checkDataBase();
                    break;
                case 12:
                    catalog.delete();
                default:
                    break;
            }
        }while (kod != 0);
    }
}
