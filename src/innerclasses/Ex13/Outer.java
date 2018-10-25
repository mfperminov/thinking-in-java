package innerclasses.Ex13;

public class Outer {
  public MyInterface print(){
    return new MyInterface() {
      @Override public void printString(String s) {
        System.out.println(s + " world");
      }
    };
  }
  public static void main(String[] args) {
    Outer o = new Outer();
    MyInterface mi = o.print();
    mi.printString("Hello");
  }
}
