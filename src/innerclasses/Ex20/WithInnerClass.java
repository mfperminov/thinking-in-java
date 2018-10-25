package innerclasses.Ex20;

public interface WithInnerClass {
  void f();
  class Inner implements WithInnerClass {
    @Override public void f() {
      System.out.println("f()");
    }
    public static void main(String[] args){
      Inner i = new Inner();
    }
  }

}
