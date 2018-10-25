package innerclasses.Ex16;

interface Cycle {
  void getCycleName();
}

interface CycleFactory {
  Cycle getCycle();
}

class Unicycle implements Cycle {
  @Override public void getCycleName() {
    System.out.println("Unicycle");
  }

  static final CycleFactory factory = new CycleFactory() {
    @Override public Cycle getCycle() {
      return new Unicycle();
    }
  };
}

class Bicycle implements Cycle {
  @Override public void getCycleName() {
    System.out.println("Bicycle");
  }
  static final CycleFactory factory = new CycleFactory() {
    @Override public Cycle getCycle() {
      return new Bicycle();
    }
  };
}

class Tricycle implements Cycle {
  @Override public void getCycleName() {
    System.out.println("Tricycle");
  }
  static final CycleFactory factory = new CycleFactory() {
    @Override public Cycle getCycle() {
      return new Tricycle();
    }
  };
}


public class Ex18 {
  private static void cycleTrade(CycleFactory cf) {
    Cycle c = cf.getCycle();
    c.getCycleName();
  }

  public static void main(String[] args) {
    cycleTrade(Unicycle.factory);
    cycleTrade(Bicycle.factory);
    cycleTrade(Tricycle.factory);
  }
}
