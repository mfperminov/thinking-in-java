package innerclasses.Ex11;

class Outer {
  private class MyPrinter implements MyInterface {
    @Override public void printString(String s) {
      System.out.println(s + " world");
    }
  }

  MyInterface print() {
    return new MyPrinter();
  }
}
public class Ex11 {
  public static void main(String[] args) {
    Outer o = new Outer();
    MyInterface mi = o.print();
    // error below
    // MyPrinter mp = (MyPrinter) mi;
  }
}
