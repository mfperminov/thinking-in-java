package concurrency.Ex10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Fibonacci implements Callable<Integer> {
  private ExecutorService exec = Executors.newCachedThreadPool();

  int howMany = 0;

  private int fib(int n) {
    if (n < 2) {
      return 1;
    }
    return fib(n - 2) + fib(n - 1);
  }

  public void run() {
    int[] arr = new int[howMany];
    for (int i = 0; i < howMany; i++) {
      arr[i] = fib(i);
    }
    System.out.println(Arrays.toString(arr));
  }

  @Override public Integer call() throws Exception {
    int[] arr = new int[howMany];
    for (int i = 0; i < howMany; i++) {
      arr[i] = fib(i);
    }
    System.out.println(Arrays.toString(arr));
    return Arrays.stream(arr).sum();
  }

  public Future<Integer> runTask(int howMany) {
    this.howMany = howMany;
    return exec.submit(this);
  }
}

public class Ex5ThreadMethod {

  public static void main(String[] args) {
    ArrayList<Integer> fibSums = new ArrayList<>();
    for (int i = 5; i < 10; i++) {
      try {
        fibSums.add(new Fibonacci().runTask(i).get());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    for (Integer fi : fibSums) {
      System.out.println("The sum is " + fi);
    }
  }
}

