package innerclasses.Ex6.onemore;

import innerclasses.Ex6.Outer;
import innerclasses.Ex6.special.specialif;

public class OuterChild extends Outer {
  public specialif getSpecialInterface() {
    return this.new Inner();
  }
  public static void main(String[] args) {
    System.out.println("Compiles fine!");
    OuterChild oc = new OuterChild();
    specialif sc = oc.getSpecialInterface();
    sc.method();
  }
}
