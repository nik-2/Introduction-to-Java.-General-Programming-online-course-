import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightSchedule
{
    private ArrayList<Airline> airplane = new ArrayList<>();

    private List<Airline> print()
    {
        return airplane;
    }

    private void addAirplane(Airline airline)
    {
        airplane.add(airline);
    }

    private List<Airline> printDirection(String direction)
    {
        List<Airline> list = new ArrayList<>();
        for (Airline i: airplane) {
            if(i.getDestination().equals(direction))
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<Airline> printDays(String days)
    {
        List<Airline> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(days);
        for (Airline i: airplane) {
            Matcher matcher = pattern.matcher(i.getDaysWeek());
            if(matcher.find())
            {
                list.add(i);
            }
        }
        return list;
    }

    private List<Airline> printDaysAndTime(String days, String time)
    {
        List<Airline> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(days);
        for (Airline i: airplane) {
            Matcher matcher = pattern.matcher(i.getDaysWeek());
            if(matcher.find())
            {
                for (int j = 0; j < time.length() && j < i.getTime().length(); j++) {
                    if ((int)time.charAt(j) < (int)i.getTime().charAt(j))
                    {
                        list.add(i);
                        break;
                    }
                    if ((int)time.charAt(j) > (int)i.getTime().charAt(j) || i.getTime().equals(time))
                    {
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FlightSchedule flightSchedule = new FlightSchedule();
        flightSchedule.addAirplane(new Airline("Ванкувер", "785А", "Боинг-737", "18:55",
                                                "Понедельник, Среда, Пятница"));
        flightSchedule.addAirplane(new Airline("Торонто", "956", "Боинг-777", "10:30",
                                                 "Вторник, Четверг"));
        flightSchedule.addAirplane(new Airline("Лос-Анджелес", "565Б", "АэробусА330", "17:10",
                                                "Суббота, Воскресенье"));
        flightSchedule.addAirplane(new Airline("Москва", "323", "АэробусА310", "06:29",
                                                "Понедельник, Чеверг"));
        flightSchedule.addAirplane(new Airline("Минск", "875В", "Суперджет-100", "02:25",
                                                "Понедельник, Вторник, Среда, Пятница"));
        flightSchedule.addAirplane(new Airline("Амстердам", "567В", "АэробусА320", "23:38",
                                                "Понедельник, Вторник, Среда, Четверг, Пятница"));
        flightSchedule.addAirplane(new Airline("Париж", "008А", "Ильюшин ИЛ-86", "20:15",
                                                "Понедельник, Среда, Пятница, Суббота, Воскресенье"));
        flightSchedule.addAirplane(new Airline("Сидней", "777", "Боинг-777", "00:26",
                                                "Среда, Суббота"));
        System.out.println("\t\t\tFLIGHT SCHEDULE");
        for (Airline i: flightSchedule.print()) {
            System.out.println(i);
        }
        System.out.print( "\nEnter your destination to see the flights you need: ");
        String destination = in.nextLine();
        System.out.println("\n\t\tLIST OF FLIGHTS FOR A DESTINED DIRECTION '" + destination + "'\n");
        if(flightSchedule.printDirection(destination).size() == 0)
        {
            System.out.println("EXCUSE ME... FLIGHTS NO FOUND!");
        }
        else {
            for (Airline i : flightSchedule.printDirection(destination)) {
                System.out.println(i);
            }
        }
        System.out.print( "\nEnter the day of the week for which you are interested in flights: ");
        String days = in.nextLine();
        System.out.println("\n\t\tLIST OF FLIGHTS FOR A SET DAY OF THE WEEK '" + days + "'\n");
        if(flightSchedule.printDays(days).size() == 0)
        {
            System.out.println("EXCUSE ME... FLIGHTS NO FOUND!");
        }
        else {
            for (Airline i : flightSchedule.printDays(days)) {
                System.out.println(i);
            }
        }
        System.out.print( "\nEnter the day of the week for which you are interested in flights: ");
        days = in.nextLine();
        System.out.print( "and after what time: ");
        String time = in.nextLine();
        System.out.println("\n\tLIST OF FLIGHTS FOR A SET DAY OF THE WEEK '" + days + "' AND BY TIME LATER THAN SPECIFIED '" + time + "'\n");
        if(flightSchedule.printDaysAndTime(days, time).size() == 0)
        {
            System.out.println("EXCUSE ME... FLIGHTS NO FOUND!");
        }
        else {
            for (Airline i : flightSchedule.printDaysAndTime(days, time)) {
                System.out.println(i);
            }
        }
    }

}
