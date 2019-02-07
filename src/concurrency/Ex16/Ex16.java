package concurrency.Ex16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex16 {
  private Lock lock = new ReentrantLock();
  private Lock lock1 = new ReentrantLock();
  private Lock lock2 = new ReentrantLock();

  public void f() {
    lock.lock();
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println("f()");
        Thread.yield();
      }
    } finally {
      lock.unlock();
    }
  }

  public void g() {
    lock1.lock();
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println("g()");
        Thread.yield();
      }
    } finally {
      lock1.unlock();
    }
  }

  public void h() {
    lock2.lock();
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println("h()");
        Thread.yield();
      }
    } finally {
      lock2.unlock();
    }
  }

  public static void main(String[] args) {
    Ex16 ex16 = new Ex16();
    for (int i = 0; i < 3; i++) {
      new Thread(ex16::f).start();
      new Thread(ex16::g).start();
      new Thread(ex16::h).start();
    }
  }
}


