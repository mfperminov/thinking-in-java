package concurrency.Ex22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

// First version with busy wait

//class BusyTask implements Runnable {
//  Boolean flag = false;
//
//  @Override public void run() {
//    try {
//      TimeUnit.SECONDS.sleep(2);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    flag = true;
//  }
//}
//
//class Waiter implements Runnable {
//  private BusyTask busyTask;
//
//  public Waiter(BusyTask busyTask) {
//    this.busyTask = busyTask;
//  }
//
//  @Override public void run() {
//    while (!busyTask.flag) {
//      try {
//        TimeUnit.MILLISECONDS.sleep(200);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      print("Flag is " + busyTask.flag.toString());
//    }
//    print("BusyTask.flag changed");
//    busyTask.flag = false;
//    print("Change back it to " + busyTask.flag.toString());
//  }
//}
//
//public class Ex22 {
//  public static void main(String[] args) throws InterruptedException {
//    ExecutorService exec = Executors.newCachedThreadPool();
//    BusyTask busyTask = new BusyTask();
//    exec.execute(busyTask);
//    exec.execute(new Waiter(busyTask));
//    TimeUnit.SECONDS.sleep(5);
//    exec.shutdown();
//  }
//}

class BusyTask implements Runnable {
    Boolean flag = false;

    @Override public void run() {
        synchronized (this) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            this.notifyAll();
        }
    }
}

class Waiter implements Runnable {
    private final BusyTask busyTask;

    Waiter(BusyTask busyTask) {
        this.busyTask = busyTask;
    }

    @Override public void run() {
        synchronized (busyTask) {
            while (!busyTask.flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        print("BusyTask.flag changed");
        busyTask.flag = false;
        print("Change back it to " + busyTask.flag.toString());
    }
}

public class Ex22 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        BusyTask busyTask = new BusyTask();
        exec.execute(busyTask);
        exec.execute(new Waiter(busyTask));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdown();
    }
}
