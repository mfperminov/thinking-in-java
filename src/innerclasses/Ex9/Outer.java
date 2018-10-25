package innerclasses.Ex9;

public class Outer {
  public MyInterface print(){
    class MyPrinter implements MyInterface {
      @Override public void printString(String s) {
        System.out.println(s + " world");
      }
    }
    return new MyPrinter();
  }
  public static void main(String[] args) {
    Outer o = new Outer();
    MyInterface mi = o.print();
    mi.printString("Hello");
  }
}
