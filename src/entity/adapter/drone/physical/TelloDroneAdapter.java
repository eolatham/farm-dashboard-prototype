package entity.adapter.drone.physical;

import constants.Constants;
import entity.adapter.drone.virtual.AnimatedDroneInterface;
import java.io.IOException;

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
    if (isDeployed()) return;

    try {
      // unsure where to apply this
      int flightFloor = Constants.ITEM_HEIGHT_MAX / 25; // converted to feet

      int travelVerticalDistance = Constants.REAL_DRONE_Y_BOUND;
      int travelLeftDistance = Constants.REAL_DRONE_X_BOUND;
      int travelRightDistance = Constants.REAL_DRONE_X_BOUND / 5;

      // initial turn
      telloDrone.turnCCW(90);
      System.out.println("The drone turns 90 degrees counter clockwise");

      for (int i = 0; i < 2; i++) {
        telloDrone.flyForward(travelVerticalDistance);
        System.out.println(
          "The drone travels forward " +
          travelVerticalDistance +
          " feet to the bottom of the farm"
        );
        telloDrone.turnCCW(90);
        System.out.println("The drone turns 90 degrees counter clockwise");
        telloDrone.flyForward(travelRightDistance);
        System.out.println(
          "The drone travels forward " +
          travelRightDistance +
          " feet to the right"
        );
        telloDrone.turnCCW(90);
        System.out.println("The drone turns 90 degrees counter clockwise");
        telloDrone.flyForward(travelVerticalDistance);
        System.out.println(
          "The drone travels forward " +
          travelVerticalDistance +
          " feet to the top of the farm"
        );
        telloDrone.turnCW(90);
        System.out.println("The drone turns 90 degree clockwise");
        telloDrone.flyForward(travelRightDistance);
        System.out.println(
          "The drone travels forward " +
          travelRightDistance +
          " feet to the right"
        );
        telloDrone.turnCW(90);
        System.out.println("The drone turns 90 degree clockwise");
      }

      telloDrone.flyForward(travelVerticalDistance);
      System.out.println(
        "The drone travels forward " +
        travelVerticalDistance +
        " feet to the bottom of the farm"
      );
      telloDrone.turnCCW(90);
      System.out.println("The drone turns 90 degrees counter clockwise");
      telloDrone.flyForward(travelRightDistance);
      System.out.println(
        "The drone travels forward " +
        travelRightDistance +
        " feet to the right"
      );
      telloDrone.turnCCW(90);
      System.out.println("The drone turns 90 degrees counter clockwise");
      telloDrone.flyForward(travelVerticalDistance);
      System.out.println(
        "The drone travels forward " +
        travelVerticalDistance +
        " feet to the top of the farm"
      );
      // at top right of farm here

      telloDrone.turnCCW(90);
      System.out.println("The drone turns 90 degrees counter clockwise");
      telloDrone.flyForward(travelLeftDistance);
      System.out.println(
        "The drone travels forward " +
        travelLeftDistance +
        " feet to the left back to the origin"
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isDeployed() {
    // TODO: actually return whether or not the drone is deployed
    return true;
  }
}
