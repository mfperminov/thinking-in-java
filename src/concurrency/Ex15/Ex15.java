package concurrency.Ex15;

public class Ex15 {
  Object o = new Object();
  Object o1 = new Object();
  Object o2 = new Object();

  public void f() {
    synchronized (o2) {
      for (int i = 0; i < 10; i++) {
        System.out.println("f()");
        Thread.yield();
      }
    }
  }

  public void g() {
    synchronized (o) {
      for (int i = 0; i < 10; i++) {
        System.out.println("g()");
        Thread.yield();
      }
    }
  }

  public void h() {
    synchronized (o1) {
      for (int i = 0; i < 10; i++) {
        System.out.println("h()");
        Thread.yield();
      }
    }
  }

  public static void main(String[] args) {
    Ex15 ex15 = new Ex15();
    for (int i = 0; i < 3; i++) {
      new Thread(ex15::f).start();
      new Thread(ex15::g).start();
      new Thread(ex15::h).start();
    }
  }
}
