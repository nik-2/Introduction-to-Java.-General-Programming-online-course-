public class BankAccount
{
    public static int generatorID;
    {
        generatorID++;
    }
    public int id = generatorID;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int bankNumberCard;
    private int amountMoney;
    private boolean state;

    public BankAccount(String surname, String name, String patronymic, String address, int bankNumberCard, int amountMoney, boolean state){
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAddress(address);
        setBankNumberCard(bankNumberCard);
        setAmountMoney(amountMoney);
        setState(state);
    }

    public int getId() {
        return id;
    }

    public String getState()
    {
        if(state)
        {
            return "Активен";
        }
        else{
            return "Заблокирован";
        }

    }

    public void setState(boolean state)
    {
        this.state = state;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBankNumberCard() {
        return bankNumberCard;
    }

    public void setBankNumberCard(int bankNumberCard) {
        this.bankNumberCard = bankNumberCard;
    }

    public int getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(int amountMoney) {
        this.amountMoney = amountMoney;
    }

    public String toString()
    {
        return String.format("| ID: %1$-2d| Surname: %2$-10s| Name: %3$-10s| Patronymic: %4$-15s| Address: %5$-15s" +
                        "| Bank Account: %6$-10d| Amount money($): %7$-10d| State of an account: %8$-15s", getId(), getSurname(), getName(),
                getPatronymic(), getAddress(), getBankNumberCard(), getAmountMoney(), getState());
    }
}
