package innerclasses.Ex5;

class Outer {
  class Inner {

  }
}

public class Another {
  public static void main(String[] args) {
    Outer o = new Outer();
    Outer.Inner i = o.new Inner();
  }
}
