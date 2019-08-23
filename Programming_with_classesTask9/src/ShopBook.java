import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopBook
{
    private ArrayList<Book> books = new ArrayList<>();

    private List<Book> print()
    {
        return books;
    }

    private void addBook(Book book)
    {
        books.add(book);
    }

    private List<Book> printYearEdition(int year)
    {
        List<Book> yearEditionBooks = new ArrayList<>();
        for (Book i: books) {
            if(i.getYearEdition() > year)
            {
                yearEditionBooks.add(i);
            }
        }
        return yearEditionBooks;
    }

    private List<Book> printEdition(String edition)
    {
        List<Book> editionBooks = new ArrayList<>();
        for (Book i: books) {
            if(i.getEdition().equals(edition))
            {
                editionBooks.add(i);
            }
        }
        return editionBooks;
    }

    private List<Book> printAuthor(String author)
    {
        List<Book> authorBooks = new ArrayList<>();
        Pattern pattern = Pattern.compile(author);
        for (Book i: books) {
            Matcher matcher = pattern.matcher(i.getAuthor());
            if(matcher.find())
            {
                authorBooks.add(i);
            }
        }
        return authorBooks;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ShopBook catalog = new ShopBook();
        catalog.addBook(new Book("Кладбище домашних животных","Стивен Кинг", "ACT", 2016,
                                480, 10, "Твёрдый переплёт"));
        catalog.addBook(new Book("Чужак","Стивен Кинг", "ACT", 2019,
                                  576, 11, "Мягкий переплёт"));
        catalog.addBook(new Book("Краткая история времени","Стивен Хокинг", "ACT", 2018,
                               232, 13, "Твёрдый переплёт"));
        catalog.addBook(new Book("Метро 2033","Дмитрий Глуховский", "BOOKS", 2019,
                                 384, 15, "Мягкий переплёт"));
        catalog.addBook(new Book("Игра Престолов","Джордж Мартин", "RELAX", 2019,
                               768, 9, "Интегральный переплёт"));
        catalog.addBook(new Book("Ведьмак.Последнее желание","Анджей Сапковский", "BOOKS", 2016,
                                 320, 8, "Твёрдый переплёт"));
        System.out.println("\t\t\tCATALOG\n");
        for (Book i: catalog.print()) {
            System.out.println(i);
        }
        System.out.print("\nEnter the author of the book you want to see: ");
        String author = in.nextLine();
        System.out.println("\n\t\tBOOKS BY '" + author + "'\n");
        if(catalog.printAuthor(author).size() == 0)
        {
            System.out.println("EXCUSE ME... NOTHING FOUND FOR THIS SEARCH!");
        }
        else {
            for (Book i : catalog.printAuthor(author)) {
                System.out.println(i);
            }
        }
        System.out.print("\nEnter the edition of the book you want to see: ");
        String edition = in.nextLine();
        System.out.println("\n\t\tBOOKS BY EDITION '" + edition + "'\n");
        if(catalog.printEdition(edition).size() == 0)
        {
            System.out.println("EXCUSE ME... NOTHING FOUND FOR THIS SEARCH!");
        }
        else {
            for (Book i : catalog.printEdition(edition)) {
                System.out.println(i);
            }
        }
        System.out.print("\nEnter the year to see books released later than entered: ");
        int year = Integer.parseInt(in.nextLine());
        System.out.println("\n\t\tBOOKS THAT WERE PUBLISHED LATER '" + year + "'\n");
        if(catalog.printYearEdition(year).size() == 0)
        {
            System.out.println("EXCUSE ME... NOTHING FOUND FOR THIS SEARCH!");
        }
        else {
            for (Book i : catalog.printYearEdition(year)) {
                System.out.println(i);
            }
        }
    }
}
