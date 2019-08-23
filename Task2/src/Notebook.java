import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Notebook {

    private List<Note> notes;
    private Note note;
    Notebook() throws Exception
    {
        this.notes = new ArrayList<>();
        this.note = new Note();
        addCreatedNotes();
    }

    private void addCreatedNotes() throws Exception
    {
        String notes;
        FileReader fileReaderNotes = new FileReader(this.note.getNotebook());
        Scanner scannerNotes = new Scanner(fileReaderNotes);
        StringBuilder notesBuilder = new StringBuilder();
        while (scannerNotes.hasNextLine()) {
            notesBuilder.append(scannerNotes.nextLine());
        }
        notes = notesBuilder.toString();
        fileReaderNotes.close();
        String[] arraysOfString = notes.split(">\t");
        for (int i = 0; i < arraysOfString.length - 3; i++) {
            this.notes.add(new Note(arraysOfString[i].replaceFirst("Тема: <",""),
                    arraysOfString[i+2].replaceFirst("e-mail: <",""),
                    arraysOfString[i+1].replaceFirst("Дата создания: <",""),
                    arraysOfString[i+3].replaceFirst("Сообщение: <","")));
            i = i + 3;
        }
    }

    void addNote()
    {
        String topic = checkAndPrintTopic();
        String mail = checkAndPrintMail();
        String text = checkAndPrintText();
        String date = LocalDate.now().toString();
        this.notes.add(new Note(topic, mail, date, text));
        this.note.addNote(topic, date, mail, text);
    }

    private String checkAndPrintMail()
    {
        Scanner in = new Scanner(System.in);
        String str;
        System.out.println("\nВведите mail: ");
        str = in.nextLine();
        while (!Pattern.matches("[a-zA-Z\\d-_]+@[a-z]{3,}.[a-z]{2,4}", str)) {
            System.out.println("\nНекорректный ввод! Попробуйте снова...\n" +
                    "Вы можете использовать английскую раскладку в" +
                    " верхнем и нижнем регистре, цифры, а также '-', '_'... " +
                    "Почта должна быть представлена в корректном виде: ");
            str = in.nextLine();
        }
        return str;
    }

    private String checkAndPrintTopic()
    {
        Scanner in = new Scanner(System.in);
        String str;
        System.out.println("\nВведите тему заметки: ");
        str = in.nextLine();
        while (!Pattern.matches("[a-zA-Zа-яА-Я\\d-]+", str)) {
            System.out.println("\nНекорректный ввод! Попробуйте снова...\n" +
                    "Вы можете использовать буквы в верхних и нижних регистрах, цифры и '-': ");
            str = in.nextLine();
        }
        return str;
    }

    private String checkAndPrintText()
    {
        Pattern pattern = Pattern.compile("[<>]+");
        Matcher matcher;
        Scanner in = new Scanner(System.in);
        String str;
        System.out.println("\nВведите сообщение заметки: ");
        str = in.nextLine();
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("\nНекорректный ввод! Попробуйте снова: ");
            str = in.nextLine();
            matcher = pattern.matcher(str);
        }
        return str;
    }

    void printNotebook()
    {
        if(notes.size() != 0)
        {
            for (Note i: notes) {
                System.out.println(i);
            }
        }
        else{
            System.out.println("\nЗаметок не найдено!\n");
        }
    }

    void searchAndPrintByTopic()
    {
        if(this.notes.size() != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("\nВведите название заголовка по которому хотите найти заметки: ");
            String str = in.nextLine();
            while (!Pattern.matches("[a-zA-Zа-яА-Я\\d-]+", str)) {
                System.out.println("\nНекорректный ввод! Попробуйте снова...\n" +
                        "Вы можете использовать буквы в верхних и нижних регистрах, цифры и '-': ");
                str = in.nextLine();
            }
            int kol = 0;
            System.out.println("\nСПИСОК ЗАМЕТОК С ЗАГОЛОВКОМ '" + str + "' ОТСОРТИРОВАННЫХ ПО ДАТЕ ДОБАВЛЕНИЯ\n");
            List<Note> list = new ArrayList<>();
            for (Note i : this.notes) {
                if (Pattern.matches(str.toLowerCase(), i.getName().toLowerCase()))
                {
                    list.add(i);
                    kol++;
                }
            }
            list.sort((o1, o2) -> o1.getDate().compareToIgnoreCase(o2.getDate()));
            if(kol != 0) {
                for (Note i : list) {
                    System.out.println(i);
                }
            }
            else
            {
                System.out.println("\nЗаметок с заголовком '" + str + "' не найдено\n");
            }
        }
        else{
            System.out.println("\nЗаметок нет!\n");
        }
    }

    void searchAndPrintByDate()
    {
        if(this.notes.size() != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("\nВведите дату по которой хотите найти заметки(YYYY-MM-DD): ");
            String str = in.nextLine();
            while (!Pattern.matches("\\d{4}-\\d{2}-\\d{2}", str)) {
                System.out.println("\nНекорректный ввод! Попробуйте снова... Запишите дату в виде YYYY-MM-DD: ");
                str = in.nextLine();
            }
            int kol = 0;
            System.out.println("\nСПИСОК ЗАМЕТОК КОТОРЫЕ БЫЛИ ДОБАВЛЕНЫ '" + str + "' И ОТСОРТИРОВАННЫХ ПО ЗАГОЛОВКУ\n");
            List<Note> list = new ArrayList<>();
            for (Note i : this.notes) {
                if (Pattern.matches(str.toLowerCase(), i.getDate().toLowerCase()))
                {
                    list.add(i);
                    kol++;
                }
            }
            if(kol !=0 ) {
                list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                for (Note i : list) {
                    System.out.println(i);
                }
            }
            else{
                System.out.println("\nЗаметок добавленных '" + str + "' не найдено\n");
            }
        }
        else{
            System.out.println("\nЗаметок нет!\n");
        }
    }

    void searchAndPrintByMail()
    {
        if(this.notes.size() != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("\nВведите e-mail по которому хотите найти заметки: ");
            String str = in.nextLine();
            while (!Pattern.matches("[a-zA-Z\\d-_]+@[a-z]{3,}.[a-z]{2,4}", str)) {
                System.out.println("\nНекорректный ввод! Попробуйте снова...\n" +
                        "Вы можете использовать английскую раскладку в" +
                        " верхнем и нижнем регистре, цифры, а также '-', '_'... " +
                        "Почта должна быть представлена в корректном виде: ");
                str = in.nextLine();
            }
            int kol = 0;
            System.out.println("\nСПИСОК ЗАМЕТОК С E-MAIL '" + str + "' ОТСОРТИРОВАННЫХ ПО ДАТЕ ДОБАВЛЕНИЯ\n");
            List<Note> list = new ArrayList<>();
            for (Note i : this.notes) {
                if (Pattern.matches(str.toLowerCase(), i.getMail().toLowerCase()))
                {
                    list.add(i);
                    kol++;
                }
            }
            list.sort((o1, o2) -> o1.getDate().compareToIgnoreCase(o2.getDate()));
            if(kol != 0) {
                for (Note i : list) {
                    System.out.println(i);
                }
            }
            else
            {
                System.out.println("\nЗаметок с e-mail '" + str + "' не найдено\n");
            }
        }
        else{
            System.out.println("\nЗаметок нет!\n");
        }
    }

    void searchAndPrintByText()
    {
        if(this.notes.size() != 0) {
            Scanner in = new Scanner(System.in);
            Pattern pattern = Pattern.compile("[<>\\s]+");
            Matcher matcher;
            System.out.println("\nВведите слово из содержания по которому хотите найти заметки, с этим словом: ");
            String str = in.nextLine();
            matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.println("\nНекорректный ввод! Попробуйте снова ввести СЛОВО: ");
                str = in.nextLine();
                matcher = pattern.matcher(str);
            }
            int kol = 0;
            System.out.println("\nСПИСОК ЗАМЕТОК У КОТОРЫХ В СОДЕРЖАНИИ ВСТРЕЧАЕТСЯ СЛОВО '" + str + "' ОТСОРТИРОВАННЫХ ПО ДАТЕ ДОБАВЛЕНИЯ\n");
            Pattern searchPattern = Pattern.compile(str);
            Matcher searchMatcher;
            List<Note> list = new ArrayList<>();
            for (Note i : this.notes) {
                searchMatcher = searchPattern.matcher(i.getText());
                if (searchMatcher.find())
                {
                    list.add(i);
                    kol++;
                }
            }
            list.sort((o1, o2) -> o1.getDate().compareToIgnoreCase(o2.getDate()));
            if(kol != 0) {
                for (Note i : list) {
                    System.out.println(i);
                }
            }
            else
            {
                System.out.println("\nЗаметок у которых в содержании есть слово '" + str + "' не найдено\n");
            }
        }
        else{
            System.out.println("\nЗаметок нет!\n");
        }
    }

    void sortByTopic()
    {
        if (this.notes.size() != 0) {
            List<Note> list = new ArrayList<>(this.notes);
            list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            System.out.println("\nЗАМЕТКИ ОТСОРТИРОВАННЫЕ ПО ЗАГОЛОВКУ\n");
            for (Note i: list) {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("\nЗаметок нет\n");
        }
    }

    void sortByDate()
    {
        if(this.notes.size() != 0) {
            List<Note> list = new ArrayList<>(this.notes);
            list.sort((o1, o2) -> o1.getDate().compareToIgnoreCase(o2.getDate()));
            System.out.println("\nЗАМЕТКИ ОТСОРТИРОВАННЫЕ ПО ДАТЕ ДОБАВЛЕНИЯ\n");
            for (Note i: list) {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("\nЗаметок нет\n");
        }
    }

    void sortByMail()
    {
        if(this.notes.size() != 0) {
            List<Note> list = new ArrayList<>(this.notes);
            list.sort((o1, o2) -> o1.getMail().compareToIgnoreCase(o2.getMail()));
            System.out.println("\nЗАМЕТКИ ОТСОРТИРОВАННЫЕ ПО E-MAIL\n");
            for (Note i: list) {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("\nЗаметок нет\n");
        }
    }
}
