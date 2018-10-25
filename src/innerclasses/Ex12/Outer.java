package innerclasses.Ex12;



public class Outer {
  private String field;

  public Outer(String field) {
    this.field = field;
  }

  private void method() {
    System.out.println("Outer method() call");
  }

  abstract class Inner {
    abstract void modifyAndCall();
  }

  private Inner createAndCall() {
    return new Inner() {
      void modifyAndCall() {
        field = "newString";
        method();
      }
    };
  }

  public static void main(String[] args) {
    Outer o1 = new Outer("init string");
    System.out.println(o1.field);
    o1.createAndCall().modifyAndCall();
    System.out.println(o1.field);
  }
}
