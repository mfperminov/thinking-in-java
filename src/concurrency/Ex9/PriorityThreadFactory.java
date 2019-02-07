package concurrency.Ex9;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
  private int priority;

  public PriorityThreadFactory(int priority) {
    this.priority = priority;
  }

  @Override public Thread newThread(Runnable runnable) {
    Thread t = new Thread(runnable);
    t.setPriority(priority);
    return t;
  }
}
