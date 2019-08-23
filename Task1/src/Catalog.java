import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Catalog
{
    private String username;
    private String password;
    private Admin admin;
    private DataBase dataBase;
    private User user;
    private List<User> users;
    private boolean loginAdmin = false;
    private boolean loginUser = false;
    private final File catalogDirectory = new File("..\\Task1\\Каталог книг");
    Catalog ()
    {
        this.dataBase = new DataBase();
        this.admin = new Admin(checkAndPrintAdminPassword());
        this.users = new ArrayList<>();
        this.user = new User();
        addLoginUsers();
    }

    private void addLoginUsers()
    {
        Pattern pattern = Pattern.compile("@gmail.com");
        Matcher matcher;
        String mail = "";
        File file = new File(this.user.getDirectoryName());
        File[] contentUsers = file.listFiles();
        if (contentUsers != null) {
            for (File i : contentUsers) {
                File[] userData = i.listFiles();
                assert  userData != null;
                for (File j: userData) {
                    matcher = pattern.matcher(j.getName());
                    if (matcher.find())
                    {
                        mail = j.getName().replaceFirst(".txt","");
                        break;
                    }
                }
                this.users.add(new User(i.getName(), mail + ".txt"));
            }
        }
    }

    void checkDataBase() throws Exception
    {
        if(this.loginAdmin)
        {
            FileReader fileReaderData = new FileReader(this.dataBase.getData());
            Scanner scannerData = new Scanner(fileReaderData);
            System.out.println("\nБАЗА ДАННЫХ АУТЕНТИФИКАЦИЙ:\n");
            while (scannerData.hasNextLine()) {
                System.out.println(scannerData.nextLine() + "\n");
            }
            fileReaderData.close();
        }
        else{
            System.out.println("\nДанными правами обладает только Администратор\n");
        }
    }

    private void encode(String password)
    {
        byte[] bytes;
        Base64.Encoder encoder = Base64.getEncoder();
        bytes = encoder.encode(password.getBytes());
        BigInteger bigInteger = new BigInteger(1, bytes);
        String encrypted = bigInteger.toString(16);
        String text = "\nUser: <" + this.username + ">-----------------Password: |" + encrypted + "|";
        File fileAppend = new File(this.dataBase.getData().getAbsolutePath());
        FileWriter fr = null;
        try {
            fr = new FileWriter(fileAppend, true);
            fr.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void checkMail() throws Exception
    {
        if(this.loginAdmin || this.loginUser)
        {
            if (this.loginUser) {
                for (User i : this.users) {
                    if (i.getUsername().getName().equals(this.username)) {
                        System.out.println("\nПОЧТА\"" + i.getMail().getName().replaceFirst(".txt", "") + "\"\n");
                        FileReader fileReaderMail = new FileReader(i.getMail());
                        Scanner scannerMail = new Scanner(fileReaderMail);
                        while (scannerMail.hasNextLine()) {
                            System.out.println(scannerMail.nextLine() + "\n");
                        }
                        fileReaderMail.close();
                    }
                }
            }
            else{
                System.out.println("\nПОЧТА\"" + this.admin.getMail().getName().replaceFirst(".txt", "") + "\"\n");
                FileReader fileReaderMail = new FileReader(this.admin.getMail());
                Scanner scannerMail = new Scanner(fileReaderMail);
                while (scannerMail.hasNextLine()) {
                    System.out.println(scannerMail.nextLine() + "\n");
                }
                fileReaderMail.close();
            }
        }
        else{
            System.out.println("\nАвторизуйтесь!\n");
        }
    }

    void logInAdmin() throws Exception
    {
        if(!this.loginAdmin && !this.loginUser) {
                Scanner in = new Scanner(System.in);
                String passwordcheck = "";
                String usernamecheck;
                do {
                    System.out.println("\nВведите имя Администратора(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
                    this.username = in.nextLine();
                    while (!Pattern.matches("[a-zA-Z\\d]+", this.username)) {
                        System.out.println("\nНекорректный ввод! Попробуйте снова: ");
                        this.username = in.nextLine();
                    }
                    System.out.println("\nВведите пароль(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
                    this.password = in.nextLine();
                    while (!Pattern.matches("[a-zA-Z\\d]+", this.password)) {
                        System.out.println("\nНекорректный ввод! Попробуйте снова: ");
                        this.password = in.nextLine();
                    }
                    FileReader fileReaderPassword = new FileReader(this.admin.getPassword());
                    Scanner scannerPassword = new Scanner(fileReaderPassword);
                    while (scannerPassword.hasNextLine()) {
                        passwordcheck = scannerPassword.nextLine();
                    }
                    fileReaderPassword.close();
                    usernamecheck = this.admin.getAdminname();
                    if(!this.username.equals(usernamecheck) || !this.password.equals(passwordcheck))
                    {
                        System.out.println("\nНеправильное имя пользователя или пароль\n");
                    }
                } while (!this.username.equals(usernamecheck) || !this.password.equals(passwordcheck));
                this.loginAdmin = true;
                System.out.println("\nВы успешно зашли как администратор\n");
                encode(passwordcheck);
            }
        else
        {
            System.out.println("\nСначала совершите логаут с текущего аккаунта, чтобы зайти в новый...\n");
        }
    }

    void logOutAdmin()
    {
        if (this.loginAdmin)
        {
            this.loginAdmin = false;
            this.username = "";
            System.out.println("\nВы больше не администратор\n");
        }
        else{
            System.out.println("\nВы не авторизованы\n");
        }
    }

    void logInUser() throws Exception
    {
        if(!this.loginAdmin && !this.loginUser) {
            if(this.users.size() != 0) {
                Scanner in = new Scanner(System.in);
                String passwordcheck = "";
                String usernamecheck = "";
                do {
                    System.out.println("\nВведите имя пользователя(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
                    this.username = in.nextLine();
                    while (!Pattern.matches("[a-zA-Z\\d]+", this.username)) {
                        System.out.println("\nНекорректный ввод! Попробуйте снова: \n");
                        this.username = in.nextLine();
                    }
                    System.out.println("\nВведите пароль(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
                    this.password = in.nextLine();
                    while (!Pattern.matches("[a-zA-Z\\d]+", this.password)) {
                        System.out.println("\nНекорректный ввод! Попробуйте снова: \n");
                        this.password = in.nextLine();
                    }
                    for (User i : this.users) {
                        FileReader fileReaderPassword = new FileReader(i.getPassword());
                        Scanner scannerPassword = new Scanner(fileReaderPassword);
                        while (scannerPassword.hasNextLine()) {
                            passwordcheck = scannerPassword.nextLine();
                        }
                        fileReaderPassword.close();
                        usernamecheck = i.getUsername().getName();
                        if (!this.username.equals(usernamecheck.trim()) || !this.password.equals(passwordcheck.trim())) {
                            System.out.println("\nНеправильное имя пользователя или пароль\n");
                        } else {
                            break;
                        }
                    }
                } while (!username.equals(usernamecheck) || !this.password.equals(passwordcheck));
                this.loginUser = true;
                System.out.println("\nВы успешно зашли как '" + this.username + "'\n");
                encode(passwordcheck);
            }
            else{
                System.out.println("\nПока что не найдено зарегистрированных пользователей\n");
            }
        }
        else
        {
            System.out.println("\nСначала совершите логаут с текущего аккаунта, чтобы зайти в новый...\n");
        }
    }

    void logOutUser()
    {
        if (this.loginUser)
        {
            this.loginUser = false;
            this.username = "";
            System.out.println("\nВы успешно вышли с аккаунта\n");
        }
        else{
            System.out.println("\nНе найдено авторизованных пользователей\n");
        }
    }

    void offer()
    {
        if(this.loginUser)
        {
            Scanner in = new Scanner(System.in);
            System.out.print("\nВведите название книги, которую хотите предложить: ");
            String nameNewBook = in.nextLine();
            String text = "\n<" + this.username + ">: Хочу предложить добавить в каталог книгу '" + nameNewBook + "'";
            File fileAppend = new File(this.admin.getMail().getAbsolutePath());
            FileWriter fr = null;
            try {
                fr = new FileWriter(fileAppend, true);
                fr.write(text);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fr != null;
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nПредложение отправлено Адмнистратору на рассмотрение\n");
        }
        else
        {
            System.out.println("\nЭта функция доступна только пользователям... Авторизуйтесь!\n");
        }
    }

    void addBook()
    {
        if (this.loginAdmin) {
            Scanner in = new Scanner(System.in);
            System.out.print("\nВведите название книги, которую хотите добавить: ");
            String nameNewBook = in.nextLine();
            File newFile = new File(this.catalogDirectory, nameNewBook.trim() + ".txt");
            try {
                boolean created = newFile.createNewFile();
                if (created) {
                    System.out.println("\nКнига была добавлена\n");
                    Pattern pattern = Pattern.compile("@gmail.com");
                    if (users.size() != 0) {
                        File file = new File(this.user.getDirectoryName());
                        File[] list = file.listFiles();
                        assert list != null;
                        for (File i : list) {
                            File[] maillist = i.listFiles();
                            assert maillist != null;
                            for (File j : maillist) {
                                Matcher matcher = pattern.matcher(j.getName());
                                if (matcher.find()) {
                                    String text = "\n<Admin>: В каталог была добавлена новая книга '" + nameNewBook + "'";
                                    File fileAppend = new File(j.getAbsolutePath());
                                    FileWriter fr = null;
                                    try {
                                        fr = new FileWriter(fileAppend, true);
                                        fr.write(text);

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } finally {
                                        try {
                                            assert fr != null;
                                            fr.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        System.out.println("\nРассылка проведена успешно\n");
                    }
                    else{
                        System.out.println("\nНет зарегистрированных пользователей,чтобы проводить рассылку\n");
                    }

                } else {
                    System.out.println("\nКнига уже существует\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("\nДанная функция доступна только администратору...\n");
        }
    }

    private String checkAndPrintAdminPassword()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пароль для администратора(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
        String str = in.nextLine();
        while (!Pattern.matches("[a-zA-Z\\d]+", str))
        {
            System.out.println("\nНекорректный ввод! Попробуйте снова: \n");
            str = in.nextLine();
        }
        return str;
    }

    void addUser() throws IOException
    {
        if(!this.loginUser && !this.loginAdmin) {
            this.user = new User(checkAndPrintUsername(), checkAndPrintUserPassword(), checkAndPrintMail() + ".txt");
            this.users.add(this.user);
            System.out.println("\nПользователь успешно зарегистрирован\n");
        }
        else{
            System.out.println("\nСначала покиньте текущий аккаунт\n");
        }
    }

    void serchPrint()
    {
        int kol = 0;
        if(this.loginAdmin || this.loginUser)
        {
            Scanner in = new Scanner(System.in);
            System.out.print("\nВведите название книги, которую хотите найти: ");
            String bookName = in.nextLine();
            File[] list = this.catalogDirectory.listFiles();
            assert list != null;
            for (File i: list) {
                if(i.getName().equalsIgnoreCase(bookName.trim() + ".txt"))
                {
                    kol++;
                    System.out.println("\nКнига найдена: " + i.getName() + "\n");
                }
            }
            if(kol == 0)
            {
                System.out.println("\nПо запросу '" + bookName +"' ничего не найдено\n");
            }
        }
        else
        {
            System.out.println("\nСписок доступен только авторизованным пользователям. Авторизуйтесь...\n");
        }
    }

    void printCatalog()
    {
        Scanner in = new Scanner(System.in);
        if(this.loginAdmin || this.loginUser) {
            String kod;
            int page;
            int temp = 1;
            File[] list = this.catalogDirectory.listFiles();
            assert list != null;
            if (list.length % 10 == 0) {
                page = list.length / 10;
            } else {
                page = (list.length / 10) + 1;
            }
            do {
                System.out.println("\nВсего страниц " + page);
                System.out.println("Мы сейчас находимся на " + temp + " странице\n");
                int length;
                if (temp == page) {
                    length = list.length;
                } else {
                    length = temp * 10;
                }
                for (int i = (temp - 1) * 10; i < length; i++) {
                    System.out.println(list[i].getName().replaceFirst(".txt", "") + "\n");
                }
                do {
                    System.out.println("\nВведите '+' - для перехода к следующей странице\n" +
                            "Введите '-' - для перехода к предыдущей странице\n" +
                            "Для того, чтобы ввести нужную страницу введите '\\'\n" +
                            "Для того, чтобы закончить просмотр каталога нажмите '0'");
                    kod = in.nextLine();
                }while (!kod.equals("+") && !kod.equals("-") && !kod.equals("\\") && !kod.equals("0"));
                switch (kod)
                {
                    case "+":
                        if(temp != page){
                            temp++;
                        }
                        else {
                            System.out.println("\nМЫ НАХОДИМСЯ НА ПОСЛЕДНЕЙ СТРАНИЦЕ\n");
                        }
                        break;
                    case "-":
                        if(temp != 1){
                            temp--;
                        }
                        else{
                            System.out.println("\nМЫ НАХОДИМСЯ НА ПЕРВОЙ СТРАНИЦЕ\n");
                        }
                        break;
                    case "\\":
                        int kol;
                        do {
                            System.out.println("\nПожалуйста, введите страницу на которую хотите перейти " +
                                                "(0 < page < " + (page+ 1) + "): ");
                            while (!in.hasNextInt()) {
                                System.out.println("\nЭто не число! Попробуйте снова: ");
                                in.next();
                            }
                            kol = in.nextInt();
                            in.nextLine();
                            if(kol == temp)
                            {
                                System.out.println("\nВы находитесь на этой странице...\n");
                            }
                        } while (kol <= 0 || kol > page || kol == temp);
                        temp = kol;
                        break;
                    case "0":
                        break;
                }
            }while (!kod.equals("0"));
        }
        else{
            System.out.println("\nСписок доступен только авторизованным пользователям. Авторизуйтесь...\n");
        }
    }

    private String checkAndPrintUserPassword()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите пароль для пользователя(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
        String str = in.nextLine();
        while (!Pattern.matches("[a-zA-Z\\d]+", str))
        {
            System.out.println("\nНекорректный ввод! Попробуйте снова: ");
            str = in.nextLine();
        }
        return str;
    }

    private String checkAndPrintUsername()
    {
        int kol;
        Scanner in = new Scanner(System.in);
        String str;
        do {
            kol = 0;
            System.out.println("\nВведите имя пользователя(Используйте английские буквы нижнего или верхнего регистра и цифры): ");
            str = in.nextLine();
            while (!Pattern.matches("[a-zA-Z\\d]+", str)) {

                System.out.println("\nНекорректный ввод! Попробуйте снова: ");
                str = in.nextLine();
            }
            if(this.users.size() != 0)
            {
                for (User i: users) {
                    if (i.getUsername().getName().equals(str))
                    {
                        kol++;
                        System.out.println("\nДанное имя пользователя уже занято...\n");
                        break;
                    }
                }
            }
        }while (kol == 1);
        return str;
    }

    private String checkAndPrintMail()
    {
        Scanner in = new Scanner(System.in);
        String str;
        int kol;
        do {
            kol = 0;
            System.out.println("\nВведите gmail: ");
            str = in.nextLine();
            while (!Pattern.matches("[a-zA-Z\\d-_]+@gmail.com", str)) {
                System.out.println("\nНекорректный ввод! Попробуйте снова: ");
                str = in.nextLine();
            }
            if (this.users.size() != 0) {
                for (User i : this.users) {
                    if (i.getMail().getName().equals(str + ".txt")) {
                        kol++;
                        System.out.println("\nЭта почта уже занята\n");
                        break;
                    }
                }
            }
        }while (kol == 1);
        return str;
    }

    private void deleteDir(File file)
    {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File i : contents) {
                deleteDir(i);
            }
        }
        file.delete();
    }

    void delete()
    {
        if(this.loginAdmin) {
            if (this.users.size() != 0) {
                for (User i : this.users) {
                    deleteDir(i.getUsername());
                }
            }
            FileWriter writerDataBase = null;
            FileWriter writerMail = null;
            try {
                writerMail = new FileWriter(this.admin.getMail().getAbsolutePath());
                writerDataBase = new FileWriter(this.dataBase.getData().getAbsolutePath());
                writerMail.write("");
                writerDataBase.write("");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert writerMail != null;
                    writerMail.close();
                    assert writerDataBase != null;
                    writerDataBase.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nДанные успешно удалены\n");
            this.users = new ArrayList<>();
        }
        else{
            System.out.println("\nДанная функция доступна только Администратору\n");
        }
    }
}
