import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Note
{
    private String name;
    private String mail;
    private String date;
    private String text;
    private final File notebook = new File("..\\Task2\\Блокнот.txt");

    Note(String name, String mail, String date, String text)
    {
        this.name = name;
        this.mail = mail;
        this.date = date;
        this.text = text;
    }

    Note(){}

    public String toString()
    {
        return "Тема: <" + getName() + "> \tДата создания: <" + getDate() + "> \te-mail: <" + getMail() +
                ">\nСообщение: <" + getText() + ">\n";
    }

    void addNote(String name, String date, String mail, String text)
    {
        File fileAppend = new File(this.notebook.getAbsolutePath());
        FileWriter nameWriter = null;
        FileWriter dateWriter = null;
        FileWriter mailWriter = null;
        FileWriter textWriter = null;
        try {
            nameWriter = new FileWriter(fileAppend, true);
            nameWriter.write("Тема: <" + name + ">\r\t");
            dateWriter = new FileWriter(fileAppend, true);
            dateWriter.write("Дата создания: <" + date + ">\r\t");
            mailWriter = new FileWriter(fileAppend, true);
            mailWriter.write("e-mail: <" + mail + ">\r\t\r\n");
            textWriter = new FileWriter(fileAppend, true);
            textWriter.write("Сообщение: <" + text + ">\r\t\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert nameWriter != null;
                nameWriter.close();
                assert dateWriter != null;
                dateWriter.close();
                assert mailWriter != null;
                mailWriter.close();
                assert textWriter != null;
                textWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    File getNotebook() {
        return notebook;
    }

    String getName() {
        return name;
    }

    String getMail() {
        return mail;
    }

    String getDate() {
        return date;
    }

    String getText() {
        return text;
    }
}
