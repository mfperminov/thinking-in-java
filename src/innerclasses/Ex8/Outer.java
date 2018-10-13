package innerclasses.Ex8;

public class Outer {
  class Inner {
    private String st = "private String";
  }

  public static void main(String[] args) {
    Outer o = new Outer();
    Inner i = o.new Inner();
    System.out.println(o.new Inner().st);
  }
}
