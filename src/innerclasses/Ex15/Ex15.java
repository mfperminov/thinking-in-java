package innerclasses.Ex15;

public class Ex15 {
  private String s;

  public Ex15(String s) {
    this.s = s;
  }

  @Override public String toString() {
    return s;
  }

  public static void main(String[] args) {
    Second sec = new Second();
    System.out.println(sec.returnFirst("test"));
  }
}

class Second {
  public Ex15 returnFirst(String s) {
    return new Ex15(s);
  }
}
