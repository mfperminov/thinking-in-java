package innerclasses.Ex1;

public class Outer {
  class Inner {

  }

  private Inner getInnner() {
    System.out.println("new Inner created");
    return new Inner();
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    Inner inner = outer.getInnner();
  }
}
