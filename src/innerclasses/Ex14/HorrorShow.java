package innerclasses.Ex14;
// Extending an interface with inheritance.

interface Monster {
  void menace();
}



interface Lethal {
  void kill();
}
class VeryBadVampire implements Vampire {
  public void menace() {}
  public void destroy() {}
  public void kill() {}
  public void drinkBlood() {}
}
interface DangerousMonster extends Monster {
  void destroy();
}

class DragonZilla implements DangerousMonster {
  public void menace() {}
  public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
  void drinkBlood();
}




public class HorrorShow {
  private DangerousMonster getDangerousMonster() {
    return new DangerousMonster() {
      @Override public void destroy() {
        System.out.println("DangerousMonster destroy()");
      }

      public void menace() {
        System.out.println("DangerousMonster menace()");
      }
    };
  }
  private Vampire getVampire() {
    return new Vampire() {
      @Override public void drinkBlood() {
        System.out.println("Vampire drinkBlood()");

      }

      @Override public void destroy() {
        System.out.println("Vampire destroy()");

      }

      @Override public void kill() {
        System.out.println("Vampire kill()");

      }

      @Override public void menace() {
        System.out.println("Vampire menace()");

      }
    };
  }

  static void u(Monster b) { b.menace(); }
  static void v(DangerousMonster d) {
    d.menace();
    d.destroy();
  }
  static void w(Lethal l) { l.kill(); }
  public static void main(String[] args) {
    HorrorShow hs = new HorrorShow();
    v(hs.getDangerousMonster());
    u(hs.getDangerousMonster());
    u(hs.getVampire());
    v(hs.getVampire());
    w(hs.getVampire());
  }
} ///:~
