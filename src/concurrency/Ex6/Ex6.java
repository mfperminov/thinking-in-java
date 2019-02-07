package concurrency.Ex6;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyTask implements Runnable {
  @Override public void run() {
    try {
      Random random = new Random();
      int sleeptime = random.nextInt(11)+1;
      TimeUnit.SECONDS.sleep(sleeptime);
      System.out.println("I sleep for " + sleeptime + " seconds");
    }
    catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
public class Ex6 {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i<5; i++) {
      executorService.execute(new MyTask());
    }
    executorService.shutdown();
  }
}
