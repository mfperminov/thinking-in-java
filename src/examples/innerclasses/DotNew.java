//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

public class DotNew {
  public static void main(String[] args) {
    DotNew dn = new DotNew();
    DotNew.Inner dni = dn.new Inner();
  }

  public class Inner {
  }
} ///:~
