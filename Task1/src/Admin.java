import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Admin
{
   private File mail;
   private File password;
   private final String adminname = "admin";

    Admin(String password)
    {
        String adminMail = "admin@gmail.com.txt";
        File directory = new File("..\\Task1\\Администратор");
        this.mail = new File(directory, adminMail);
        this.password = new File(directory, "Password.txt");
        passwordCreate(password);
    }

    File getPassword() {
        return password;
    }

    String getAdminname() {
        return adminname;
    }

    private void passwordCreate(String password)
    {
        FileWriter fw = null;
        try {
        fw = new FileWriter(this.password.getAbsolutePath());
        fw.write(password);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fw != null;
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    File getMail() {
        return mail;
    }
}
