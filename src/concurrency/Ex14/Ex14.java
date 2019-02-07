package concurrency.Ex14;

import java.util.Timer;
import java.util.TimerTask;

public class Ex14 {
  public static void main(String[] args) {
    for (int i = 0; i < 500; i++) {
      int finalI = i;
      new Timer("Timer "+ String.valueOf(i)).schedule(new TimerTask() {
        @Override public void run() {
          System.out.println("Timer #" + finalI + " is here");
        }
      }, 1000);
    }

  }
}
