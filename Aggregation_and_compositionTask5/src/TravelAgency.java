import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelAgency
{
    private String name;
    private ArrayList<TravelPackage> travelPackages = new ArrayList<>();

    private TravelAgency(String name)
    {
        setName(name);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void addTravel(TravelPackage travelPackage)
    {
        travelPackages.add(travelPackage);
    }

    private List<TravelPackage> print()
    {
        return travelPackages;
    }

    private List<TravelPackage> sortbyType()
    {
        List<TravelPackage> list = new ArrayList<>(travelPackages);
        list.sort((o1, o2) -> o1.getType().compareToIgnoreCase(o2.getType()));
        return list;
    }

    private List<TravelPackage> sortbyName()
    {
        List<TravelPackage> list = new ArrayList<>(travelPackages);
        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return list;
    }

    private List<TravelPackage> sortbyTransport()
    {
        List<TravelPackage> list = new ArrayList<>(travelPackages);
        list.sort((o1, o2) -> o1.getTransport().compareToIgnoreCase(o2.getTransport()));
        return list;
    }

    private List<TravelPackage> sortbyNutrition()
    {
        List<TravelPackage> list = new ArrayList<>(travelPackages);
        list.sort((o1, o2) -> o1.getNutrition().compareToIgnoreCase(o2.getNutrition()));
        return list;
    }

    private List<TravelPackage> sortbyPrice()
    {
        List<TravelPackage> list = new ArrayList<>(travelPackages);
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i).getPrice() > list.get(i+1).getPrice())
            {
                TravelPackage temp = list.get(i);
                list.set(i, list.get(i+1));
                list.set(i + 1, temp);
                if(i != 0)
                {
                    i = i - 2;
                }
            }
        }
        return list;
    }

    private List<TravelPackage> sortbyDays()
    {
        List<TravelPackage> list = new ArrayList<>(travelPackages);
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i).getDays() > list.get(i+1).getDays())
            {
                TravelPackage temp = list.get(i);
                list.set(i, list.get(i+1));
                list.set(i + 1, temp);
                if(i != 0)
                {
                    i = i - 2;
                }
            }
        }
        return list;
    }

    private List<TravelPackage> printType(String type)
    {
        List<TravelPackage> list = new ArrayList<>();
        for (TravelPackage i: travelPackages) {
            if(i.getType().equalsIgnoreCase(type))
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<TravelPackage> printTransport(String transport)
    {
        List<TravelPackage> list = new ArrayList<>();
        for (TravelPackage i: travelPackages) {
            if(i.getTransport().equalsIgnoreCase(transport))
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<TravelPackage> printDays(int days)
    {
        List<TravelPackage> list = new ArrayList<>();
        for (TravelPackage i: travelPackages) {
            if(i.getDays() == days)
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<TravelPackage> printAll(String type, String transport, int days)
    {
        List<TravelPackage> list = new ArrayList<>();
        for (TravelPackage i: travelPackages) {
            if(i.getType().equalsIgnoreCase(type) && i.getTransport().equalsIgnoreCase(transport) && i.getDays() == days)
            {
                list.add(i);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TravelAgency travelAgency = new TravelAgency("Следопыт");
        travelAgency.addTravel(new TravelPackage("Отдых", "Релакс", "Автобус", 7, "Без питания", 20));
        travelAgency.addTravel(new TravelPackage("Экскурсия", "Маугли", "Микроавтобус", 4, "Полупансион", 25));
        travelAgency.addTravel(new TravelPackage("Лечение", "Очищение", "Без транспорта", 8, "Полный пансион", 15));
        travelAgency.addTravel(new TravelPackage("Круиз", "Мечта", "Яхта", 9, "Всё включено", 100));
        travelAgency.addTravel(new TravelPackage("Отдых", "Сказка", "Самолёт", 10, "Всё включено", 112));
        travelAgency.addTravel(new TravelPackage("Экскурсия", "Царь зверей", "Машина", 5, "Завтрак", 39));
        travelAgency.addTravel(new TravelPackage("Лечение", "Скрытая сила", "Самолёт", 15, "Без питания", 90));
        travelAgency.addTravel(new TravelPackage("Круиз", "Сирена", "Лодка", 3, "завтрак", 32));
        travelAgency.addTravel(new TravelPackage("Отдых", "Царская жизнь", "Самолёт", 9, "Полный пансион", 72));
        travelAgency.addTravel(new TravelPackage("Экскурсия", "Это интересно!", "Без транспорта", 3, "Полупансион", 13));
        travelAgency.addTravel(new TravelPackage("Лечение", "Сила земли", "Автобус", 2, "Завтрак", 9));
        travelAgency.addTravel(new TravelPackage("Круиз", "Аквамен", "Яхта", 13, "Всё включено", 213));
        travelAgency.addTravel(new TravelPackage("Отдых", "Третий мир", "Самолёт", 21, "Полу пансион", 562));
        int kod;
        do {
            System.out.println("\nВведите '1' - чтобы посмотреть путевки\n" +
                    "Введите '2' - чтобы отсортировать путёвки по типу\n" +
                    "Введите '3' - чтобы отсортировать путёвки по названию\n" +
                    "Введите '4' - чтобы отсортировать путёвки по транспорту\n" +
                    "Введите '5' - чтобы отсортировать путёвки по питанию\n" +
                    "Введите '6' - чтобы отсортировать путёвки по цене\n" +
                    "Введите '7' - чтобы отсортировтаь пётвки по дням\n" +
                    "Введите '8' - чтобы показать путёвки выбранного нами типа\n" +
                    "Введите '9' - чтобы показать путёвки с выбранным нами транспортом\n" +
                    "Введите '10' - чтобы показать путёвки с выбранным нами числом дней\n" +
                    "Введите '11' - чтобы показать путёвки выбранного нами типа, с выбранным нами транспортом и числом дней\n" +
                    "Введите любое другое число для ВЫХОДА");
            kod = Integer.parseInt(in.nextLine());
            switch (kod)
            {
                case 1:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ '" + travelAgency.getName() + "'\n");
                    for (TravelPackage i: travelAgency.print()) {
                        System.out.print(i);
                    }
                    kod = 0;
                    break;
                case 2:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ОТСОРТИРОВАННЫЕ ПО ТИПУ\n");
                    if(travelAgency.sortbyType().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.sortbyType()) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 3:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ОТСОРТИРОВАННЫЕ ПО НАЗВАНИЮ\n");
                    if(travelAgency.sortbyName().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.sortbyName()) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 4:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ОТСОРТИРОВАННЫЕ ПО ТРАНСПОРТУ\n");
                    if(travelAgency.sortbyTransport().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.sortbyTransport()) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 5:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ОТСОРТИРОВАННЫЕ ПО ПИТАНИЮ\n");
                    if(travelAgency.sortbyNutrition().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.sortbyNutrition()) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 6:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ОТСОРТИРОВАННЫЕ ПО ЦЕНЕ\n");
                    if(travelAgency.sortbyPrice().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.sortbyPrice()) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 7:
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ОТСОРТИРОВАННЫЕ ПО ДНЯМ\n");
                    if(travelAgency.sortbyDays().size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.sortbyDays()) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 8:
                    System.out.print("\nВведите тип путевок, которые вас интересуют: ");
                    String type = in.nextLine();
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ ВЫБРАННОГО ТИПА '" + type + "'\n");
                    if(travelAgency.printType(type).size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.printType(type)) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 9:
                    System.out.print("\nПутевки с каким видом транспорта вас интересуют: ");
                    String transport = in.nextLine();
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ С ВЫБРАННЫМ ВИДОМ ТРАНСПОРТА '" + transport + "'\n");
                    if(travelAgency.printTransport(transport).size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.printTransport(transport)) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 10:
                    System.out.print("\nПутёвки на сколько дней вас интересуют: ");
                    int days = Integer.parseInt(in.nextLine());
                    System.out.println( "\n\t\t\t\t\tПУТЁВКИ КОМПАНИИ C ВЫБРАННЫМ КОЛИЧЕСТВОМ ДНЕЙ '" + days + "'\n");
                    if(travelAgency.printDays(days).size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.printDays(days)) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                case 11:
                    System.out.print("\nВведите тип путевок, которые вас интересуют: ");
                    type = in.nextLine();
                    System.out.print("\nПутевки с каким видом транспорта вас интересуют: ");
                    transport = in.nextLine();
                    System.out.print("\nПутёвки на сколько дней вас интересуют: ");
                    days = Integer.parseInt(in.nextLine());
                    System.out.println( "\n\t\t\tПУТЁВКИ КОМПАНИИ ВЫБРАННОГО ТИПА '" + type + "', С ВЫБРАННЫМ ТРАНСПОРТОМ '" +
                                        transport + "' И КОЛИЧЕСТВОМ ДНЕЙ '" + days + "'\n");
                    if(travelAgency.printAll(type,transport,days).size() == 0)
                    {
                        System.out.println("ИЗВИНИТЕ!!! ПО ДАННОМУ ЗАПРОСУ ПУТЁВОК НЕ НАЙДЕНО...");
                    }
                    else
                    {
                        for (TravelPackage i:travelAgency.printAll(type,transport,days)) {
                            System.out.print(i);
                        }
                    }
                    kod = 0;
                    break;
                default:
                    kod = 1;
                    break;
            }
        }while (kod == 0);
    }
}
