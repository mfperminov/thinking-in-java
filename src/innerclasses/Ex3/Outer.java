package innerclasses.Ex3;

public class Outer {
  private String st;

  public Outer(String st) {
    this.st = st;
  }

  class Inner {
    @Override public String toString() {
      return st;
    }
  }

  private Inner getInnner() {
    return new Inner();
  }

  public static void main(String[] args) {
    Outer outer = new Outer("String must be printed");
    Inner inner = outer.getInnner();
    System.out.println(inner);
  }
}

