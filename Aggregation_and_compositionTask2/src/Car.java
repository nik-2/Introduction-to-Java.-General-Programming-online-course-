import java.util.Scanner;

public class Car
{
    private String carName;
    private Engine engine = new Engine();
    private Wheel[] wheels = new Wheel[4];
    private boolean rideGo = false;

    private Car(String carName)
    {
        setCarName(carName);
        wheels[0] = new Wheel("переднее левое");
        wheels[1] = new Wheel("переднее правое");
        wheels[2] = new Wheel("заднее левое");
        wheels[3] = new Wheel("заднее правое");
    }

    private String getCarName() {
        return carName;
    }

    private void setCarName(String carName) {
        this.carName = carName;
    }

    private void changeWheels(){
        wheels[0].changeWheel();
        wheels[1].changeWheel();
        wheels[2].changeWheel();
        wheels[3].changeWheel();
        System.out.println("Все колёса заменены. Можно ехать");
    }

    private void refuel()
    {
        if (engine.state && rideGo)
        {
            System.out.println("Нельзя заправляться на ходу. Остановите машину и заглушите двигатель");
        }
        else {
            if (engine.state)
            {
                System.out.println("Нельзя заправляться с включенным двигателем. Заглушите машину");
            }
            else {
                System.out.println("Машина заправлена.Можно ехать");
            }
        }
    }

    private void rideGo()
    {
        if (!engine.state)
        {
            System.out.println("Нельзя ехать. Двигатель выключен. Заведите машину");
        }
        else {
            if (rideGo)
            {
                System.out.println("Мы уже в пути");
            }
            else {
                System.out.println("Поехалиии...");
                rideGo = true;
            }
        }
    }

    private void rideStop()
    {
        if(!engine.state)
        {
            System.out.println("Мы и так стоим.Двигатель выключен");
        }
        else
        {
            if (!rideGo)
            {
                System.out.println("Мы и так стоим");
            }
            else {
                System.out.println("Стоооп. Рекомендуем заглушить двигатель");
                rideGo = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Car car = new Car("FIAT");
        System.out.println(" Добро пожаловать в " + car.getCarName());
        System.out.println(" Панель управления:");
        System.out.println(" Нажмите '1' - для включения двигателя\n" +
                            " Нажмите '2' - для выключения двигателя\n" +
                            " Нажмите '3' - для замены колёс\n" +
                            " Нажмите '4' - для того, чтобы заправить автомобиль\n" +
                            " Нажмите '5' - для того, чтобы начать ехать\n" +
                            " Нажмите '6' - для того, чтобы остановиться\n" +
                            " Нажмите любое другое число, чтобы покинуть машину.");
        int kod;
        do {
            System.out.println(" Что делаем?");
            kod = in.nextInt();
            switch (kod)
            {
                case 1:
                    car.engine.start();
                    kod = 0;
                    break;
                case 2:
                    car.engine.stop();
                    kod = 0;
                    break;
                case 3:
                    if (car.engine.state && car.rideGo)
                    {
                        System.out.println("Невозможно менять колёса на ходу. Остановите машину и заглушите двигатель");
                    }
                    else {
                        if(car.engine.state)
                        {
                            System.out.println("Рекомендуем заглушить двигатель, прежде чем менять колёса");
                        }
                        else {
                            System.out.println(" Какое колесо меняем?");
                            System.out.println(" Нажмите '0' - для замены переднего левого колеса\n" +
                                    " Нажмите '1' - для замены переднего правого колеса\n" +
                                    " Нажмите '2' - для замены заднего левого колеса\n" +
                                    " Нажмите '3' - для замены заднего правого колеса\n" +
                                    " Нажмите любое другое число, чтобы заменить все колёса.");
                            System.out.println(" Что делаем?");
                            kod = in.nextInt();
                            switch (kod) {
                                case 0:
                                    car.wheels[0].changeWheel();
                                    break;
                                case 1:
                                    car.wheels[1].changeWheel();
                                    break;
                                case 2:
                                    car.wheels[2].changeWheel();
                                    break;
                                case 3:
                                    car.wheels[3].changeWheel();
                                    break;
                                default:
                                    car.changeWheels();
                                    break;
                            }
                        }
                    }
                    kod = 0;
                    break;
                case 4:
                    car.refuel();
                    kod = 0;
                    break;
                case 5:
                    car.rideGo();
                    kod = 0;
                    break;
                case 6:
                    car.rideStop();
                    kod = 0;
                    break;
                default:
                    if (car.rideGo)
                    {
                        car.rideStop();
                        car.engine.stop();
                    }
                    if (car.engine.state && !car.rideGo)
                    {
                        car.engine.stop();
                    }
                    System.out.println("Удачного дня:)");
                    kod = 1;
            }
        }while(kod == 0);
    }
}

