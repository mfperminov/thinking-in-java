package concurrency.Ex11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DataClass {
  private int intValue;
  private String stringValue;

  public DataClass(int intValue, String stringValue) {
    this.intValue = intValue;
    this.stringValue = stringValue;
  }

  public synchronized void manipulateData() {
    int saveInt = intValue;
    intValue = intValue / 100;
    for (int i =0; i<10000; i++) {
      String save = stringValue;
      stringValue = "In improper state";
      stringValue = save;
    }
    intValue = saveInt;
  }

  public synchronized int getIntValue() {
    return intValue;
  }

  public synchronized String getStringValue() {
    return stringValue;
  }
}

public class Ex11 implements Runnable {
  private DataClass dataClass;

  public static void main(String[] args) {
    Ex11 ex11 = new Ex11();
    ex11.dataClass = new DataClass(1000, "Hello");
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < 6; i++)
      exec.execute(ex11);
    exec.shutdown();

  }

  @Override public void run() {
    dataClass.manipulateData();
    System.out.println(String.valueOf(dataClass.getIntValue()));
    System.out.println(dataClass.getStringValue());
  }
}