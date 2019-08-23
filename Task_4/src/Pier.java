import Ships.Port;
import Ships.Ship;

public class Pier extends Port implements Runnable
{
    private Turn turn;


    Pier(Turn turn)
    {
        this.turn = turn;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Судно");
                Thread.sleep(500);
                Ship ship = this.turn.get();
                if(ship != null || ship.getType().name().equals("ПУСТОЙ")){
                    while (ship.countCheckUnLoad()) {
                        if (super.getCounter() >= 10) {
                            notifyAll();
                            Thread.sleep(100);
                            ship.add(10);
                            super.minus(10);
                            System.out.println("НА КОРАБЛЕ " + ship.getCount() +
                                    " КОНТЕЙНЕРОВ. ЗАГРУЖАЕТСЯ '" + Thread.currentThread().getName() + "'");
                            System.out.println("НА ПРИЧАЛЕ СЕЙЧАС " + super.getCounter() + " КОНТЕЙНЕРОВ");
                        }
                        else{
                            System.out.println("НА ПРИЧАЛЕ СЕЙЧАС " + super.getCounter() + " КОНТЕЙНЕРОВ. ЗАГРУЗКА '"
                                    + Thread.currentThread().getName() + "' ВРЕМЕННО ПРЕКРАЩЕНА");
                            wait();
                       }
                    }
                }
                if(ship != null && ship.getType().name().equals("ПОЛНЫЙ"))
                {
                    while (ship.countCheckLoad()) {
                        if (super.getCounter() < super.getSize() - 10) {
                            notifyAll();
                            Thread.sleep(100);
                            ship.minus(10);
                            super.add(10);
                            System.out.println("НА КОРАБЛЕ " + ship.getCount() +
                                    " КОНТЕЙНЕРОВ. РАЗГРУЖАЕТСЯ '" + Thread.currentThread().getName() + "'");
                            System.out.println("НА ПРИЧАЛЕ СЕЙЧАС " + super.getCounter() + " КОНТЕЙНЕРОВ");
                        }
                        else
                    {
                        System.out.println("НА ПРИЧАЛЕ СЕЙЧАС " + super.getCounter() + " КОНТЕЙНЕРОВ. РАЗГРУЗКА '"
                                + Thread.currentThread().getName() + "' ВРЕМЕННО ПРЕКРАЩЕНА");
                        wait();
                    }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
