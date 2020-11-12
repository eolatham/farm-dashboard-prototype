package entity.adapter.drone.physical;

import constants.Constants;
import entity.adapter.drone.virtual.AnimatedDroneInterface;
import java.io.IOException;

public class TelloDroneAdapter implements AnimatedDroneInterface {
  private TelloDrone telloDrone; // physical drone object
  private int flightFloor; // feet

  public TelloDroneAdapter(TelloDrone telloDrone) {
    this.telloDrone = telloDrone;
    this.flightFloor = 0;
  }

  private int pixelsToFeet(int pixels) {
    return pixels / Constants.PIXELS_PER_FOOT;
  }

  /*
   * flightFloor: pixels
   */
  public void setFlightFloor(int flightFloor) {
    this.flightFloor = pixelsToFeet(flightFloor);
  }

  private void startFlight() {
    try {
      telloDrone.activateSDK();
      telloDrone.takeoff();
      // make sure the drone is 5 feet above the flight floor
      telloDrone.increaseAltitude(flightFloor + 5);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void endFlight() {
    try {
      telloDrone.land();
      telloDrone.end();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * x, y: pixels
   */
  public void visitLocation(int x, int y) throws IllegalArgumentException {
    // TODO: make physical drone do what our animated drone does

  }

  public void scanFarm() {
    if (isDeployed()) return;

    int vDistance = Constants.REAL_DRONE_Y_BOUND;
    int rDistance = Constants.REAL_DRONE_X_BOUND / 5;
    int lDistance = Constants.REAL_DRONE_X_BOUND;

    try {
      startFlight();

      for (int i = 0; i < 3; i++) {
        // down
        System.out.println("The drone turns 90 degrees clockwise");
        telloDrone.turnCW(90);
        System.out.printf("The drone flies forward %d feet", vDistance);
        telloDrone.flyForward(vDistance);

        // right
        System.out.println("The drone turns 90 degrees counter clockwise");
        telloDrone.turnCCW(90);
        System.out.printf("The drone flies forward %d feet", rDistance);
        telloDrone.flyForward(rDistance);

        // up
        System.out.println("The drone turns 90 degrees counter clockwise");
        telloDrone.turnCCW(90);
        System.out.printf("The drone flies forward %d feet", vDistance);
        telloDrone.flyForward(vDistance);

        if (i < 2) {
          // right
          System.out.println("The drone turns 90 degrees clockwise");
          telloDrone.turnCW(90);
          System.out.printf("The drone flies forward %d feet", rDistance);
          telloDrone.flyForward(rDistance);
        }
      }

      // left
      System.out.println("The drone turns 90 degrees counter clockwise");
      telloDrone.turnCCW(90);
      System.out.printf("The drone flies forward %d feet", lDistance);
      telloDrone.flyForward(lDistance);

      endFlight();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * Assuming visitLocation and scanFarm are blocking until completion,
   * this method can only be called when the drone is not deployed.
   * Therefore, it always returns false.
   */
  public boolean isDeployed() {
    return false;
  }
}
