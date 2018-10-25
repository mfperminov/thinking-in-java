package innerclasses.Ex25;

import innerclasses.Ex25.controller.Event;

public class Ex25 extends GreenhouseControls {
  private boolean waterMist = false;
  public class WaterMistOn extends Event {
    public WaterMistOn(long delayTime) { super(delayTime); }
    public void action() {
      // Put hardware control code here to
      // physically turn on the light.
      waterMist = true;
    }
    public String toString() { return "Water Mist is on"; }
  }
  public class WaterMistOff extends Event {
    public WaterMistOff(long delayTime) { super(delayTime); }
    public void action() {
      // Put hardware control code here to
      // physically turn off the light.
      waterMist = false;
    }
    public String toString() { return "Water Mist is off"; }
  }
  public static void main(String[] args) {

  }
}
