package concurrency.Ex3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassA implements Runnable {
  MyClassA() {
    System.out.println("Creation of MyClassA");
  }

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println("MyClassA.run()");
      Thread.yield();
    }
    System.out.println("Task from MyClassA completed");
  }
}

class MyClassB implements Runnable {
  MyClassB() {
    System.out.println("Creation of MyClassB");
  }

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println("MyClassB.run()");
      Thread.yield();
    }
    System.out.println("Task from MyClassB completed");
  }
}

class MyClassC implements Runnable {
  MyClassC() {
    System.out.println("Creation of MyClassC");
  }

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println("MyClassC.run()");
      Thread.yield();
    }
    System.out.println("Task from MyClassC completed");
  }
}

public class Ex1 {

  public static void main(String[] args) {
    System.out.println("********* Beginning of main() *********");
    ExecutorService execSingle = Executors.newSingleThreadExecutor();
    execSingle.execute(new MyClassA());
    execSingle.execute(new MyClassB());
    execSingle.execute(new MyClassC());
   execSingle.shutdown();
    System.out.println("********* End of SingleThreadExecutor *********");
    ExecutorService execCached = Executors.newCachedThreadPool();
    execCached.execute(new MyClassA());
    execCached.execute(new MyClassB());
    execCached.execute(new MyClassC());
    execCached.shutdown();
    System.out.println("********* End of CachedThreadExecutor *********");
    ExecutorService execFixed = Executors.newFixedThreadPool(2);
    execFixed.execute(new MyClassA());
    execFixed.execute(new MyClassB());
    execFixed.execute(new MyClassC());
    execFixed.shutdown();
    System.out.println("********* End of FixedThreadExecutor *********");
    System.out.println("********* End of main() *********");
  }
}
