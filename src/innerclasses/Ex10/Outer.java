package innerclasses.Ex10;

public class Outer {
  public MyInterface print(Boolean doPrint){
    if(doPrint) {
      class MyPrinter implements MyInterface {
        @Override public void printString(String s) {
          System.out.println(s + " world");
        }
      }
      return new MyPrinter();
    }
    return null;
  }
  public static void main(String[] args) {
    Outer o = new Outer();
    MyInterface mi = o.print(false);
    if (mi != null) {
      mi.printString("Hello");
    } else {
      System.out.println("cannot print");
    }
  }
}
