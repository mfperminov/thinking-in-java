package concurrency.Ex8;
// Adding more threads.

public class MoreBasicThreads {
  public static void main(String[] args) {
    try {
      for (int i = 0; i < 5; i++) {
        Thread t = new Thread(new LiftOff());
        t.setDaemon(true);
        t.start();
      }
      System.out.println("Waiting for LiftOff");
    } finally {
      System.out.println("Program exits");
    }
  }

}