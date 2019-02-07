package concurrency.Ex5;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Fibonacci implements Callable<Integer> {
  int howMany = 0;

  private int fib(int n) {
    if (n < 2)
      return 1;
    return fib(n - 2) + fib(n - 1);
  }

  public void run() {
    int[] arr = new int[howMany];
    for (int i = 0; i < howMany; i++) {
      arr[i] = fib(i);
    }
    System.out.println(Arrays.toString(arr));
  }

  Fibonacci(int howMany) {
    this.howMany = howMany;
  }

  @Override public Integer call() throws Exception {
    int[] arr = new int[howMany];
    for (int i = 0; i < howMany; i++) {
      arr[i] = fib(i);
    }
    System.out.println(Arrays.toString(arr));
    return Arrays.stream(arr).sum();
  }
}

public class Ex5 {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    ArrayList<Future<Integer>> fibSums = new ArrayList<>();
    for (int i = 5; i < 10 ; i++) {
      fibSums.add(exec.submit(new Fibonacci(i)));
    }
    for (Future<Integer> fi: fibSums) {
      try {
        System.out.println("The sum is " + fi.get());
      }
      catch (InterruptedException | ExecutionException e) {
        System.out.println(e.getMessage());
      } finally {
        exec.shutdown();
      }
    }
  }
}

