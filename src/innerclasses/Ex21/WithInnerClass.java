package innerclasses.Ex21;

public interface WithInnerClass {
  void f();

  class Inner implements WithInnerClass {
    static void myMethod(WithInnerClass i) {
      i.f();
    }

    @Override public void f() {
      System.out.println("f()");
    }

    public static void main(String[] args) {
      Inner i = new Inner();
      myMethod(i);
    }
  }
}
