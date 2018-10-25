package innerclasses.Ex26;

public class Ex26 {
  class Inner {
    private String s;

    public Inner(String s) {
      this.s = s;
    }
  }

  public static void main(String[] args) {
    Second sec = new Second();
    Second.SecondInner sc = sec.new SecondInner(new Ex26(), "Hello");

  }
}

class Second {
  class SecondInner extends Ex26.Inner{

    public SecondInner(Ex26 ex, String s) {
      ex.super(s);
      System.out.println(s);
    }
  }
}
