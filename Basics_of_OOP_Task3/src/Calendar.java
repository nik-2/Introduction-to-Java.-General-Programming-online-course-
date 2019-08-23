import java.util.ArrayList;
import java.util.Scanner;

class Calendar {
    private String calendarName;
    private ArrayList<HolidaysWeekends> daysHolWeek = new ArrayList<>();
    private int kol;

    Calendar(String calendarName)
    {
        this.kol = 0;
        this.calendarName = calendarName;
    }

    class HolidaysWeekends{
        private int day;
        private String month;
        private String dayWeek;
        private String nameHolWeek;

        HolidaysWeekends(int day, String month, String dayWeek, String nameHolWeek){
             this.day = day;
             this.month = month;
             this.dayWeek = dayWeek;
             this.nameHolWeek = nameHolWeek;
        }

        String getDayWeek() {
            return dayWeek;
        }

        int getDay() {
            return day;
        }

        String getMonth() {
            return month;
        }

        String getNameHolWeek() {
            return nameHolWeek;
        }
    }

    void setDaysHolWeek(){
        Scanner in = new Scanner(System.in);
        String kod;
        do{
            System.out.print("Введите число выходного или праздничного дня: ");
            int day = Integer.parseInt(in.nextLine());
            System.out.print("Введите месяц выходного или праздничного дня: ");
            String month = in.nextLine();
            System.out.print("Введите день недели выходного или праздничного дня: ");
            String dayWeek = in.nextLine();
            System.out.print("Введите название праздника, а если это выходной день просто нажмите ENTER: ");
            String name = in.nextLine();
            if(name.equals(""))
            {
                name = "Выходной день";
            }
            this.daysHolWeek.add(new HolidaysWeekends(day, month, dayWeek, name));
            this.kol++;
            do{
                System.out.println("Нажмите '+' - чтобы добавить ещё один выходной или праздничный день\n" +
                                    "Нажмите '-' - чтобы закончить ввод выходных и праздничных дней");
                kod = in.nextLine();
                if(!kod.equals("+") && !kod.equals("-"))
                {
                    System.out.println("Неверный ввод!!! Повторите попытку...");
                }
            }while (!kod.equals("+") && !kod.equals("-"));
        }while (kod.equals("+"));
    }

    void getDaysHolWeek(){
        System.out.printf("\n%1$50s\n%2$51s",this.calendarName,"ВЫХОДНЫЕ ДНИ" + "\n\n");
        for (HolidaysWeekends i: this.daysHolWeek) {
            System.out.printf("Число: %1$-3d| Месяц: %2$-10s| День недели: %3$-15s| Причина: %4$-20s\n", i.getDay(),
                    i.getMonth(), i.getDayWeek(), i.getNameHolWeek());
        }
        System.out.println( "\nКоличество всех выходных и праздничных дней: " + this.kol);
    }
}
