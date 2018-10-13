package innerclasses.Ex2;

public class StringHolder {
  private String st;

  public StringHolder(String st) {
    this.st = st;
  }

  @Override public String toString() {
    return st;
  }

  public static void main(String[] args) {
    Sequence sequence = new Sequence(10);
    for (int i = 0; i < 10; i++)
      sequence.add(new StringHolder(String.valueOf(i)));
    Selector selector = sequence.selector();
    while (!selector.end()) {
      System.out.print(selector.current());
      selector.next();
    }
  }
}

interface Selector {
  boolean end();

  Object current();

  void next();
}

class Sequence {
  private Object[] items;
  private int next = 0;

  public Sequence(int size) {
    items = new Object[size];
  }

  public void add(Object x) {
    if (next < items.length) {
      items[next++] = x;
    }
  }

  private class SequenceSelector implements Selector {
    private int i = 0;

    public boolean end() {
      return i == items.length;
    }

    public Object current() {
      return items[i];
    }

    public void next() {
      if (i < items.length) i++;
    }
  }

  public Selector selector() {
    return new SequenceSelector();
  }
}
