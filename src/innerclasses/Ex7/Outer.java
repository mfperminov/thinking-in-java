package innerclasses.Ex7;

public class Outer {
  private String field;

  public Outer(String field) {
    this.field = field;
  }

  private void method() {
    System.out.println("Outer method() call");
  }

  class Inner {
    private void modifyAndCall() {
      field = "newString";
      method();
    }
  }

  private void createAndCall() {
    Inner i = this.new Inner();
    i.modifyAndCall();
  }

  public static void main(String[] args) {
    Outer o1 = new Outer("init string");
    System.out.println(o1.field);
    o1.createAndCall();
    System.out.println(o1.field);
  }
}
