import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class User
{
    private File mail;
    private File username;
    private File password;
    private final String directoryName = "..\\Task1\\Пользователи";

    User(String username, String password, String mailName) throws IOException {
        final File directory = new File(this.directoryName);
        this.username = new File(directory + "\\" + username);
        this.username.mkdir();
        this.password = new File(this.username, "Password.txt");
        this.password.createNewFile();
        this.mail = new File(this.username, mailName);
        this.mail.createNewFile();
        passwordCreate(password);
    }

    User(String username, String mailName){
        final File directory = new File(this.directoryName);
        this.username = new File(directory + "\\" + username);
        this.password = new File(this.username, "Password.txt");
        this.mail = new File(this.username, mailName);
    }

    User(){}

    private void passwordCreate(String password)
    {
        File fileAppend = new File(this.password.getAbsolutePath());
        FileWriter fr = null;
        try {
            fr = new FileWriter(fileAppend, true);
            fr.write(password);

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

    String getDirectoryName() {
        return directoryName;
    }

    File getPassword() {
        return password;
    }

    File getUsername() {
        return username;
    }

    File getMail() {
        return mail;
    }
}
