package concurrency.Ex4;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.mindview.util.Generator;

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
    ExecutorService exec = Executors.newSingleThreadExecutor();
    ExecutorService execCached = Executors.newCachedThreadPool();
    ExecutorService execFixed = Executors.newFixedThreadPool(2);

    for (int i = 5; i < 10; i++) {
      exec.execute(new Ex2(i));
    }
    for (int i = 5; i < 10; i++) {
      execCached.execute(new Ex2(i));
    }
    for (int i = 5; i < 10; i++) {
      execFixed.execute(new Ex2(i));
    }

  }

  @Override public void run() {
    new Fibonacci(n);
  }
}
