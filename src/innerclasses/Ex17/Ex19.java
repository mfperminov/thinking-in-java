package innerclasses.Ex17;

import java.util.Random;

interface Toss {
  int toss();
}

interface TossFactory {
  Toss makeTossing();
}

class DiceTossing implements Toss {
  @Override public int toss() {
    Random random = new Random();
    return random.nextInt(6) + 1;
  }
  static final TossFactory factory = new TossFactory() {
    @Override public Toss makeTossing() {
      return new DiceTossing();
    }
  };
}

class CoinTossing implements Toss {
  @Override public int toss() {
    Random random = new Random();
    return random.nextInt(2);
  }
  static final TossFactory factory = new TossFactory() {
    @Override public Toss makeTossing() {
      return new CoinTossing();
    }
  };

}


public class Ex19 {
  public static void toss(TossFactory tf) {
    Toss t = tf.makeTossing();
    System.out.println(t.toss());
  }

  public static void main(String[] args) {
    toss(CoinTossing.factory);
    toss(DiceTossing.factory);
  }
}
