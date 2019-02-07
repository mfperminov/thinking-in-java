package concurrency.Ex1;

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

    new Thread(new MyClassA()).start();
    new Thread(new MyClassB()).start();
    new Thread(new MyClassC()).start();

    System.out.println("********* End of main() *********");
  }
}
