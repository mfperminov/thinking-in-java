package concurrency.Ex17;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class RadiationCounter {
    private int level = 0;

    public synchronized void setLevel(int level) {
        this.level += level;
    }

    public synchronized int getLevel() {
        return level;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < Integer.valueOf(args[0]); i++) {
            exec.execute(new Sensor(i));
        }
    }
}

class Sensor implements Runnable {
    private final int id;

    public Sensor(int id) {
        this.id = id;
    }

    static RadiationCounter radiationCounter = new RadiationCounter();
    Random random = new Random(34);

    @Override public void run() {
        while (true) {
            radiationCounter.setLevel(random.nextInt(100));
            System.out.println(String.valueOf(radiationCounter.getLevel()));
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                print("sleep interrupted");
            }
        }
    }
}
