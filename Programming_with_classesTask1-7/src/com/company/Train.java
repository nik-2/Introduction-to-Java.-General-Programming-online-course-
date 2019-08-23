//Task4
package com.company;

import java.util.Scanner;

public class Train {
    private String place;
    private String trainNumber;
    private String time;

    private Train(){}

    private Train(String trainNumber, String place, String time)
    {
        setTrainNumber(trainNumber);
        setPlace(place);
        setTime(time);
    }

    private String getPlace() {
        return place;
    }

    private void setPlace(String place) {
        this.place = place;
    }

    private String getTrainNumber() {
        return trainNumber;
    }

    private void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    private String getTime() {
        return time;
    }

    private void setTime(String time) {
        this.time = time;
    }

    private void show()
    {
        System.out.printf(" |Train number: %1$-6s|Destination: %2$-15s|Departure time: %3$-5s\n", getTrainNumber(), getPlace(), getTime());
    }

    private void infoTrainNumber(Train[] info, String trainNumber)
    {
        int kol = 0;
        for (int i = 0; i < info.length; i++) {
            if(info[i].getTrainNumber().equals(trainNumber))
            {
                info[i].show();
                kol++;
            }
        }
        if(kol == 0)
        {
            System.out.println( " Excuse me. There is no information about this train.");
        }
    }

    private void sortTime(Train[] info)
    {
        for (int i = 0; i < info.length - 1; i++) {
            if(info[i].getPlace().equals(info[i + 1].getPlace())) {
                for (int j = 0; j < info[i].getTime().length() && j < info[i + 1].getTime().length(); j++) {
                    if ((int) info[i].getTime().charAt(j) > (int) info[i + 1].getTime().charAt(j)) {
                        Train temp = info[i];
                        info[i] = info[i + 1];
                        info[i + 1] = temp;
                        if (i != 0) {
                            i = i - 2;
                        }
                        break;
                    }
                    if ((int) info[i].getTime().charAt(j) < (int) info[i + 1].getTime().charAt(j)) {
                        break;
                    }
                }
            }
        }
    }

    private void sortPlace(Train[] info)
    {
        int kol = 0;
        for (int i = 0; i < info.length - 1; i++) {
            for (int j = 0; j < info[i].getPlace().length() && j < info[i + 1].getPlace().length(); j++) {
                if((int)info[i].getPlace().charAt(j) > (int)info[i + 1].getPlace().charAt(j))
                {
                    Train temp = info[i];
                    info[i] = info[i + 1];
                    info[i + 1] = temp;
                    if( i != 0)
                    {
                        i = i - 2;
                    }
                    break;
                }
                if((int)info[i].getPlace().charAt(j) < (int)info[i + 1].getPlace().charAt(j))
                {
                    break;
                }
                if(info[i].getPlace().equals(info[i + 1].getPlace()))
                {
                    kol++;
                }
            }
        }
        if (kol != 0)
        {
            sortTime(info);
        }
        for (int i = 0; i < info.length; i++) {
            info[i].show();
        }
    }

    private void sortTrainNumber(Train[] info)
    {
        for (int i = 0; i < info.length - 1; i++) {
            for (int j = 0; j < info[i].getTrainNumber().length() && j < info[i + 1].getTrainNumber().length(); j++) {
                if((int)info[i].getTrainNumber().charAt(j) > (int)info[i + 1].getTrainNumber().charAt(j))
                {
                    Train temp = info[i];
                    info[i] = info[i + 1];
                    info[i + 1] = temp;
                    if( i != 0)
                    {
                        i = i - 2;
                    }
                    break;
                }
                if((int)info[i].getTrainNumber().charAt(j) < (int)info[i + 1].getTrainNumber().charAt(j))
                {
                    break;
                }
            }
        }
        for (int i = 0; i < info.length; i++) {
            info[i].show();
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Train []info = new Train[5];
        for (int i = 0; i < info.length; i++) {
            System.out.print( " Input train number: ");
            String train = in.nextLine();
            System.out.print( " Input destination: ");
            String place = in.nextLine();
            System.out.print( " Input departure time(HH:MM): ");
            String time = in.nextLine();
            info[i] = new Train(train, place, time);
        }
        System.out.println( "\n\t\t\t\t\t\t TRAIN SCHEDULE");
        for (int i = 0; i < info.length; i++) {
            info[i].show();
        }
        System.out.println( "\n\t\t\t\t\t\t TRAIN SCHEDULE SORTED BY TRAIN NUMBER:");
        info[0].sortTrainNumber(info);

        System.out.print( "\n Input the train number you want to receive information about: ");
        String trainNumber = in.nextLine();
        System.out.println( "\n\t\t\t\t\t\t INFORMATION ABOUT TRAIN №" + trainNumber);
        info[0].infoTrainNumber(info, trainNumber);
        System.out.println( "\n\t\t\t\t\t\t TRAIN SCHEDULE SORTED BY PLACE");
        info[0].sortPlace(info);
    }
}
