package entity.adapter.drone.physical;

import entity.adapter.drone.virtual.AnimatedDroneInterface;

public class TelloDroneAdapter implements AnimatedDroneInterface {
  private TelloDrone telloDrone;

  public TelloDroneAdapter(TelloDrone telloDrone) {
    this.telloDrone = telloDrone;
  }

  /*
   * x, y: pixels
   */
  public void visitLocation(int x, int y) throws IllegalArgumentException {
    // TODO: make physical drone do what our animated drone does

  }

  public void scanFarm() {
    // TODO: make physical drone do what our animated drone does

  }

  public boolean isDeployed() {
    // TODO: actually return whether or not the drone is deployed
    return true;
  }
}
