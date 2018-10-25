package innerclasses.Ex18;

public class Ex18 {
  static class Nested {
    static void print(String s) {
      System.out.println(s);
    }
  }
  public static void main(String[] args) {
    Ex18.Nested.print("I wanna rock");
    Nested n = new Nested();
    n.print("Hello");
  }
}
