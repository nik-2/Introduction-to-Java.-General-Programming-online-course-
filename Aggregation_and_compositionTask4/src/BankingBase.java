import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingBase
{
    private String name;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();


    private  BankingBase(String name)
    {
        setName(name);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void newBankAccount(BankAccount bankAccount)
    {
        bankAccounts.add(bankAccount);
    }

    private List<BankAccount> printBankAccounts()
    {
        return bankAccounts;
    }

    private void block(int bankNumberCard)
    {
        int kol = 0;
        for (BankAccount i: bankAccounts) {
            if(i.getBankNumberCard() == bankNumberCard)
            {
                kol++;
                System.out.println("СЧЁТ '" + bankNumberCard + "' ЗАБЛОКИРОВАН!!!");
                i.setState(false);
            }
        }
        if(kol == 0)
        {
            System.out.println("СЧЁТ НЕ НАЙДЕН");
        }
    }

    private void unlock(int bankNumberCard)
    {
        int kol = 0;
        for (BankAccount i: bankAccounts) {
            if(i.getBankNumberCard() == bankNumberCard)
            {
                kol++;
                System.out.println("СЧЁТ '" + bankNumberCard + "' РАЗБЛОКИРОВАН!!!");
                i.setState(true);
            }
        }
        if(kol == 0)
        {
            System.out.println("СЧЁТ НЕ НАЙДЕН");
        }
    }

    private List<BankAccount> sortbySurname()
    {
        List<BankAccount> list = new ArrayList<>(bankAccounts);
        list.sort((o1, o2) -> o1.getSurname().compareToIgnoreCase(o2.getSurname()));
        return list;
    }

    private List<BankAccount> printBlock()
    {
        List<BankAccount> list = new ArrayList<>();
        for (BankAccount i:bankAccounts) {
            if(i.getState().equals("Заблокирован"))
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<BankAccount> printActive()
    {
        List<BankAccount> list = new ArrayList<>();
        for (BankAccount i:bankAccounts) {
            if(i.getState().equals("Активен"))
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<BankAccount> searchSurname(String surname)
    {
        List<BankAccount> list = new ArrayList<>();
        for (BankAccount i:bankAccounts) {
            if (i.getSurname().equals(surname))
            {
                list.add(i);
            }
        }
        return list;
    }

    private void searchBankNumberCard(int bankNumberCard)
    {
        int kol = 0;
        for (BankAccount i: bankAccounts) {
            if(i.getBankNumberCard() == bankNumberCard)
            {
                kol++;
                System.out.println(i);
            }
        }
        if(kol == 0)
        {
            System.out.println("СЧЁТ НЕ НАЙДЕН");
        }
    }

    private int sumCustomer(String surname)
    {
        int sum = 0;
        for (BankAccount i:bankAccounts) {
            if (i.getSurname().equals(surname) && i.getState().equals("Активен"))
            {
                sum = sum + i.getAmountMoney();
            }
        }
        return sum;
    }

    private int sum()
    {
        int sum = 0;
        for (BankAccount i:bankAccounts) {
            if (i.getState().equals("Активен"))
            {
                sum = sum + i.getAmountMoney();
            }
        }
        return sum;
    }

    private int sumMinus()
    {
        int sum = 0;
        for (BankAccount i:bankAccounts) {
            if (i.getState().equals("Активен") && i.getAmountMoney() < 0)
            {
                sum = sum + i.getAmountMoney();
            }
        }
        return sum;
    }

    private int sumPlus()
    {
        int sum = 0;
        for (BankAccount i:bankAccounts) {
            if (i.getAmountMoney() > 0 && i.getState().equals("Активен"))
            {
                sum = sum + i.getAmountMoney();
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankingBase bankingBase = new BankingBase("BELARUSBANK");
        bankingBase.newBankAccount(new BankAccount("Поляков", "Никита", "Владимирович", "Беларусь", 10101010, 1056, true));
        bankingBase.newBankAccount(new BankAccount("Бабенко", "Александра", "Павловна", "Беларусь", 20202020, 5689, true));
        bankingBase.newBankAccount(new BankAccount("Сигел", "Майк", "Александрович", "Австрия", 30303030, 14568, true));
        bankingBase.newBankAccount(new BankAccount("Нольде", "Андреас", "Вадимович", "Германия", 40404040, 5429, true));
        bankingBase.newBankAccount(new BankAccount("Холмс", "Том", "Артурович", "Англия", 50505050, 984, true));
        bankingBase.newBankAccount(new BankAccount("Франклин", "Бенджамин", "Константинович", "Канада", 60606060, 871, true));
        bankingBase.newBankAccount(new BankAccount("Поляков", "Никита", "Владимирович", "Беларусь", 11111111, -100, true));
        bankingBase.newBankAccount(new BankAccount("Бабенко", "Александра", "Павловна", "Беларусь", 21212121, 25, true));
        bankingBase.newBankAccount(new BankAccount("Сигел", "Майк", "Александрович", "Австрия", 31313131, -5689, true));
        bankingBase.newBankAccount(new BankAccount("Нольде", "Андреас", "Вадимович", "Германия", 41414141, -63, true));
        bankingBase.newBankAccount(new BankAccount("Холмс", "Том", "Артурович", "Англия", 51515151, 687, true));
        bankingBase.newBankAccount(new BankAccount("Франклин", "Бенджамин", "Константинович", "Канада", 61616161, 3650, true));
        bankingBase.newBankAccount(new BankAccount("Поляков", "Никита", "Владимирович", "Беларусь", 12121212, -1589, true));
        bankingBase.newBankAccount(new BankAccount("Бабенко", "Александра", "Павловна", "Беларусь", 22222222, -1000, true));
        bankingBase.newBankAccount(new BankAccount("Сигел", "Майк", "Александрович", "Австрия", 32323232, 250, true));
        bankingBase.newBankAccount(new BankAccount("Нольде", "Андреас", "Вадимович", "Германия", 42424242, 235, true));
        bankingBase.newBankAccount(new BankAccount("Холмс", "Том", "Артурович", "Англия", 52525252, -587, true));
        bankingBase.newBankAccount(new BankAccount("Франклин", "Бенджамин", "Константинович", "Канада", 62626262, -524, true));
        bankingBase.newBankAccount(new BankAccount("Поляков", "Никита", "Владимирович", "Беларусь", 13131313, 874, true));
        bankingBase.newBankAccount(new BankAccount("Бабенко", "Александра", "Павловна", "Беларусь", 23232323, 2547, true));
        bankingBase.newBankAccount(new BankAccount("Сигел", "Майк", "Александрович", "Австрия", 33333333, -892, true));
        bankingBase.newBankAccount(new BankAccount("Нольде", "Андреас", "Вадимович", "Германия", 43434343, 4876, true));
        bankingBase.newBankAccount(new BankAccount("Холмс", "Том", "Артурович", "Англия", 53535353, -624, true));
        bankingBase.newBankAccount(new BankAccount("Франклин", "Бенджамин", "Константинович", "Канада", 63636363, -321, true));
        int kod;
        do {
            System.out.println("\nВведите '1' - чтобы посмотреть банковские счета клиентов банка\n" +
                    "Введите '2' - чтобы отсортировать банковские счета клиентов банка по фамилиям\n" +
                    "Введите '3' - чтобы заблокировать банковский счёт\n" +
                    "Введите '4' - чтобы разблокировать банковский счёт\n" +
                    "Введите '5' - чтобы показать заблокированные банковские счета\n" +
                    "Введите '6' - чтобы показать активные банковские счета\n" +
                    "Введите '7' - чтобы посмотреть банковские счета клиента с кокретной фамилией\n" +
                    "Введите '8' - чтобы посмотреть банковский счет с конкретным номером\n" +
                    "Введите '9' - чтобы посчитать сумму денег на активных счетах определённого клиента\n" +
                    "Введите '10' - чтобы посчитать сумму денег на ВСЕХ активных счетах\n" +
                    "Введите '11' - чтобы посчитать сумму денег на всех активных счетах с положительным балансом\n" +
                    "Введите '12' - чтобы посчиать сумму денег на всех активных счетах с отрицательным балансом\n" +
                    "Введите любое другое число для ВЫХОДА");
            kod = Integer.parseInt(in.nextLine());
            switch (kod)
            {
                case 1:
                    System.out.println( "\n\t\t\t\t\t\t\t\t\tБАНКОВСКИЕ СЧЕТА КЛИЕНТОВ БАНКА '" + bankingBase.getName() + "'\n");
                    for (BankAccount i: bankingBase.printBankAccounts()) {
                        System.out.println(i);
                    }
                    kod = 0;
                    break;
                case 2:
                    System.out.println( "\n\t\t\t\t\t\t\t\t\tОТСОРТИРОВАННЫЕ БАНКОВСКИЕ СЧЕТА ПО ФАМИЛИЯМ КЛИЕНТА\n");
                    for (BankAccount i: bankingBase.sortbySurname()) {
                        System.out.println(i);
                    }
                    kod = 0;
                    break;
                case 3:
                    System.out.print("\nВведите номер банковского счёта, который хотите заблокировать: ");
                    int number = Integer.parseInt(in.nextLine());
                    bankingBase.block(number);
                    kod = 0;
                    break;
                case 4:
                    System.out.print("\nВведите номер банковского счёта, который хотите разблокировать: ");
                    number = Integer.parseInt(in.nextLine());
                    bankingBase.unlock(number);
                    kod = 0;
                    break;
                case 5:
                    System.out.println( "\n\t\t\t\t\t\t\t\t\tЗАБЛОКИРОВАННЫЕ БАНКОВСКИЕ СЧЕТА КЛИЕНТОВ БАНКА\n");
                    if(bankingBase.printBlock().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ БАНКОВСКИХ СЧЕТОВ НЕ НАЙДЕНО...");
                    }
                    else {
                        for (BankAccount i : bankingBase.printBlock()) {
                            System.out.println(i);
                        }
                    }
                    kod = 0;
                    break;
                case 6:
                    System.out.println( "\n\t\t\t\t\t\t\t\t\tАКТИВНЫЕ БАНКОВСКИЕ СЧЕТА КЛИЕНТОВ БАНКА\n");
                    if(bankingBase.printActive().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ БАНКОВСКИХ СЧЕТОВ НЕ НАЙДЕНО...");
                    }
                    else {
                        for (BankAccount i : bankingBase.printActive()) {
                            System.out.println(i);
                        }
                    }
                    kod = 0;
                    break;
                case 7:
                    System.out.print("\nВведите фамилию клиента, банковские счета которого хотите посмореть: ");
                    String surname = in.nextLine();
                    System.out.println("\n\t\t\t\t\t\t\t\t\tСЧЕТА КЛИЕНТА '" + surname + "'\n");
                    if(bankingBase.searchSurname(surname).size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ БАНКОВСКИХ СЧЕТОВ НЕ НАЙДЕНО...");
                    }
                    else {
                        for (BankAccount i : bankingBase.searchSurname(surname)) {
                            System.out.println(i);
                        }
                    }
                    kod = 0;
                    break;
                case 8:
                    System.out.print("\nВведите номер банковского счёта, который хотите посмотреть: ");
                    number = Integer.parseInt(in.nextLine());
                    bankingBase.searchBankNumberCard(number);
                    kod = 0;
                    break;
                case 9:
                    System.out.print("\nВведите фамилию клиента у которого хотите посчитать сумму денег на всех активных счетах: ");
                    surname = in.nextLine();
                    System.out.println("Сумма денег на активных счетах '" + surname + "' = " + bankingBase.sumCustomer(surname) + "$\n");
                    kod = 0;
                    break;
                case 10:
                    System.out.println("Сумма денег на ВСЕХ активных счетах = " + bankingBase.sum() + "$\n");
                    kod = 0;
                    break;
                case 11:
                    System.out.println("Сумма денег на ВСЕХ активных счетах с положительным балансом = " + bankingBase.sumPlus() + "$\n");
                    kod = 0;
                    break;
                case 12:
                    System.out.println("Сумма денег на ВСЕХ активных счетах с отрицательным балансом = " + bankingBase.sumMinus() + "$\n");
                    kod = 0;
                    break;
                default:
                    kod = 1;
                    break;
            }
        }while (kod == 0);
    }
}
