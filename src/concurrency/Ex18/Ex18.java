package concurrency.Ex18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Sleeping {
    public void sleep() {
        System.out.println("Goes to sleep");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Awake");
    }
}

class Task implements Runnable {
    private Sleeping s;
    public Task() {
        s = new Sleeping();
    }

    @Override public void run() {
        System.out.println("Running task");
        s.sleep();
    }
}

public class Ex18 {
  public static void main(String[] args) throws InterruptedException {
      ExecutorService executorService = Executors.newCachedThreadPool();
      Future<?> f = executorService.submit(new Task());
      TimeUnit.MILLISECONDS.sleep(200);
      f.cancel(true);
  }
}
