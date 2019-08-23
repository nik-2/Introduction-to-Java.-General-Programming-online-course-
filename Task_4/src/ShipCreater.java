import Ships.Port;
import Ships.Ship;
import Ships.Type.Type;

import java.util.Random;

public class ShipCreater implements Runnable {

    private Turn turn;
    private int shipCount;
    private Port port = new Port();

    ShipCreater(Turn turn, int shipCount) {
        this.shipCount = shipCount;
        this.turn = turn;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < this.shipCount) {
            Thread.currentThread().setName("СОЗДАЁМ КОРАБЛЬ ");
            count++;
            if(this.port.getCounter() == this.port.getSize())
            {
                this.turn.add(new Ship(Type.ПУСТОЙ));
            }
            else {
                if (this.port.getCounter() == 0) {
                    this.turn.add(new Ship(Type.ПОЛНЫЙ));
                }
                else{
                    {
                        this.turn.add(new Ship(getRandomType()));
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }
}