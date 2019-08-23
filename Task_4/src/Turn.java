import Ships.Ship;

import java.util.ArrayList;
import java.util.List;

class Turn
{

    private List<Ship> ships;
    private static final int turnMax = 1;
    private static final int turnMin = 0;
    private int сounter = 0;

    Turn() {
        this.ships = new ArrayList<>();
    }

    synchronized boolean add(Ship element) {
        try {
            if (this.сounter < this.turnMax) {
                notifyAll();
                this.ships.add(element);
                String info = String.format("%s\nСВОЕЙ ОЧЕРЕДИ ОЖИДАЕТ КОРАБЛЬ: %s " +
                        " С ВМЕСТИМОСТЬЮ '%d' КОНТЕЙНЕРОВ", Thread.currentThread().getName(), element.getType(), element.getSize());
                System.out.println(info);
                this.сounter++;
            } else {
                System.out.println("СВОЕЙ ОЧЕРЕДИ УЖЕ ЖДЁТ КОРАБЛЬ");
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    synchronized Ship get() {
        try {
            if (this.сounter > this.turnMin) {
                notifyAll();
                Ship ship = this.ships.get(this.ships.size() - 1);
                this.сounter--;
                System.out.println("СВОЕЙ ОЧЕРЕДИ ДОЖДАЛСЯ И ПОПЛЫЛ К ПРИСТАНЕ КОРАБЛЬ: "
                        + Thread.currentThread().getName());
                this.ships.remove(ship);
                return ship;
            }
            else {
                System.out.println("В ОЧЕРЕДИ ПОКА ЧТО НЕТ КОРАБЛЕЙ");
                wait();
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
