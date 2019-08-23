import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {
        System.out.println("ДОСТУПНОЕ ЧИСЛО ЯДЕР: " + Runtime.getRuntime().availableProcessors());

        Turn turn = new Turn();

        ShipCreater shipCreater = new ShipCreater(turn, 10);

        Pier pierLoader1 = new Pier(turn);
        Pier pierLoader2 = new Pier(turn);
        Pier pierLoader3 = new Pier(turn);
        Pier pierLoader4 = new Pier(turn);
        Pier pierLoader5 = new Pier(turn);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipCreater);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);
        service.execute(pierLoader4);
        service.execute(pierLoader5);

        service.shutdown();
    }
}