package concurrency.Ex21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.mindview.util.Print;

class FirstTask implements Runnable {
  final Lock lock = new ReentrantLock();
  @Override public synchronized void run() {
    Print.print("Running FirstTask()");
    synchronized (lock) {
      try {
        lock.wait();
      } catch (InterruptedException e) {
        Print.print("End by Interrupting in FirstTask()");
      }
    }
    Print.print("Exit waiting");
  }
}

class SecondTask implements Runnable {
  private FirstTask firstTask;

    SecondTask(FirstTask firstTask) {
    this.firstTask = firstTask;
  }

  @Override public synchronized void run() {
    Print.print("Running SecondTask()");
    try {
      Print.print("Sleep for two seconds");
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      Print.print("End by Interrupting in SecondTask()");
    }
    synchronized (firstTask.lock) {
      firstTask.lock.notifyAll();
    }
  }
}

public class Ex21 {
  public static void main(String[] args) throws InterruptedException {
    FirstTask firstTask = new FirstTask();
    SecondTask secondTask = new SecondTask(firstTask);
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(firstTask);
    exec.execute(secondTask);
    TimeUnit.SECONDS.sleep(5); // Run for a while...
    exec.shutdownNow();
  }
}

///version with IllegalMonitorException (SecondTask wants to notifyall on FirstTask while don't have monitor of it)

//class FirstTask implements Runnable {
//  @Override public synchronized void run() {
//    try {
//      wait();
//    } catch (InterruptedException e) {
//      Print.print("End by Interrupting");
//    }
//    Print.print("Exit waiting");
//  }
//}
//
//class SecondTask implements Runnable {
//  private FirstTask firstTask;
//
//  public SecondTask(FirstTask firstTask) {
//    this.firstTask = firstTask;
//  }
//
//  @Override public synchronized void run() {
//    try {
//      TimeUnit.SECONDS.sleep(2);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    firstTask.notifyAll();
//  }
//}
//
//public class Ex21 {
//  public static void main(String[] args) throws InterruptedException {
//    FirstTask firstTask = new FirstTask();
//    SecondTask secondTask = new SecondTask(firstTask);
//    ExecutorService exec = Executors.newCachedThreadPool();
//    //exec.execute(firstTask);
//    exec.execute(secondTask);
//    TimeUnit.SECONDS.sleep(5); // Run for a while...
//    exec.shutdownNow();
//  }
//}
