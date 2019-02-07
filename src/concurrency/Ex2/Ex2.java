package concurrency.Ex2;

import java.util.Arrays;
import java.util.concurrent.Executor;
import net.mindview.util.*;

class Fibonacci implements Generator<Integer> {
  private int count = 0;
  public Integer next() { return fib(count++); }
  private int fib(int n) {
    if(n < 2) return 1;
    return fib(n-2) + fib(n-1);
  }

  public Fibonacci(int n) {
    int[] result = new int[n];
    for(int i = 0; i < n; i++)
      result[i] = next();
    System.out.println(Arrays.toString(result));
  }

}

public class Ex2 implements Runnable {
  private int n;

  public Ex2(int n) {
    this.n = n;
  }

  public static void main(String[] args) {

    for (int i = 5; i < 10; i++) {
      new Thread(new Ex2(i)).start();
    }

  }

  @Override public void run() {
    Fibonacci gen = new Fibonacci(n);
  }
}
