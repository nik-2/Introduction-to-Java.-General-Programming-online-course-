public class Book
{
    {
        generateID++;
    }
    private static int generateID;
    private int id = generateID;
    private String name;
    private String author;
    private String edition;
    private int yearEdition;
    private int pagesNumber;
    private int price;
    private String bindingType;

    public Book(String name, String author, String edition, int yearEdition, int pagesNumber, int price, String bindingType){
        setName(name);
        setAuthor(author);
        setEdition(edition);
        setYearEdition(yearEdition);
        setPagesNumber(pagesNumber);
        setPrice(price);
        setBindingType(bindingType);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getYearEdition() {
        return yearEdition;
    }

    public void setYearEdition(int yearEdition) {
        this.yearEdition = yearEdition;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public String toString()
    {
        return String.format("|ID: %1$-2d|:Title of the book: %2$-35s|Author: %3$-25s|Edition: %4$-15s|The year of publishing: %5$-8d" +
                        "|Number of pages: %6$-7d|Price($): %7$-5d|Binding type: %8$-20s", getId(), getName(), getAuthor(), getEdition(),
                getYearEdition(), getPagesNumber(), getPrice(), getBindingType());
    }
}
