import java.io.*;
import java.util.Scanner;

class FILE extends Directory
{
    private File file;

    FILE(String dirName, String fileName) {
        super(dirName);
        setFile(fileName);
    }

    File getFile() {
        return file;
    }

    private void setFile(String fileName) {
        this.file = new File(super.getDir(), fileName);
    }

    void check(File fileName)
    {
        if(fileName.exists()) {
            System.out.println("\nФайл существует\n");
        }
        else {
            System.out.println("\nФайл не существует\n");
        }
    }

    File rename(File fileName)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите имя на которое переименовать файл: ");
        String newName = in.nextLine();
        File file = new File(super.getDir(), newName + ".txt");
        if (!file.exists()) {
            if (fileName.exists()) {
                System.out.println("\nФайл успешно переименован\n");
                fileName.renameTo(file);
            } else {
                System.out.println("\nФайл не найден!\n");
            }
            return file;
        }
        else{
            System.out.println("\nФайл с таким именем уже существует\n");
            return fileName;
        }
    }

    void deleteFile(File fileName)
    {
        boolean deleted = fileName.delete();
        if(deleted) {
            System.out.println("\nФайл был удалён\n");
        }
        else{
            System.out.println("\nФайл удалён не был(проверьте существует ли файл)\n");
        }
    }

    void print(File fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
        String line = in.readLine();
        System.out.println("\nСодержимое файла '" + fileName.getName().replaceFirst(".txt","") + "'\n");
        while(line != null)
        {
            System.out.println(line);
            line = in.readLine();
        }
        in.close();
    }

    void create()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите имя нового файла: ");
        String nameNewFile = in.nextLine();
        File newFile = new File(super.getDir(), nameNewFile + ".txt");
        try
        {
            boolean created = newFile.createNewFile();
            if(created) {
                System.out.println("\nФайл был создан\n");
            }
            else {
                System.out.println("\nФайл уже существует\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    void append(File fileName) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите текст, который хотите добавить в текстовый файл: ");
        String text = " " + in.nextLine();
        FileWriter fr = null;
        try {
            fr = new FileWriter(fileName, true);
            fr.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
