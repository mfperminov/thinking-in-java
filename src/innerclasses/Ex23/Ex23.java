package innerclasses.Ex23;

interface U {
  void method1();

  void method2();

  void method3();
}

class A {
  U returnU() {
    return new U() {
      @Override public void method1() {
        System.out.println("returnU() method1");
      }

      @Override public void method2() {
        System.out.println("returnU() method2");
      }

      @Override public void method3() {
        System.out.println("returnU() method3");
      }
    };
  }
}

class B {
  U[] arr = new U[5];
  int size = 0;

  void addU(U u) {
    arr[size++] = u;
  }

  void setToNull(int index) {
    arr[index] = null;
  }

  void moveThroughArray() {
    for (int i = 0; i < size; i++) {
      arr[i].method1();
      arr[i].method2();
      arr[i].method3();
    }
  }
}

public class Ex23 {
  public static void main(String[] args) {
    A a1 = new A();
    A a2 = new A();
    A a3 = new A();
    B b = new B();
    b.addU(a1.returnU());
    b.addU(a2.returnU());
    b.addU(a3.returnU());
    b.moveThroughArray();
    b.setToNull(1);
  }
}
