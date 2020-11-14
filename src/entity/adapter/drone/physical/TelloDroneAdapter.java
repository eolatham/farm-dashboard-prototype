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

  /*
   * flightFloor: feet
   */
  public void setFlightFloor(int flightFloor) {
    this.flightFloor = flightFloor;
  }

  public int getFlightFloor() {
    return flightFloor;
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

  private double angleFromAToB(double aX, double aY, double bX, double bY) {
    return Math.toDegrees(Math.atan2(bY - aY, bX - aX));
  }

  /*
   * x, y: feet
   */
  public void visitLocation(int x, int y) throws IllegalArgumentException {
    if (isDeployed()) return;
    if (
      x < 0 ||
      y < 0 ||
      x > Constants.REAL_FARM_LENGTH ||
      y > Constants.REAL_FARM_WIDTH
    ) throw new IllegalArgumentException("Location is out of bounds!");

    try {
      startFlight();

      int turnValue = (int) Math.round(angleFromAToB(0, 0, x, y));
      int distanceToTravel = (int) Math.round(Math.hypot(x, y));

      // travel to
      System.out.println("The drone turns to face the specified location");
      telloDrone.turnCW(turnValue);
      System.out.println("The drone flies to the specified location");
      telloDrone.flyForward(distanceToTravel);
      System.out.println("The drone hovers over the specified location");
      telloDrone.hoverInPlace((int) Constants.DRONE_STOP_DURATION.toSeconds());

      // travel back
      System.out.println("The drone turns to face the starting location");
      telloDrone.turnCW(180);
      System.out.println("The drone flies to the starting location");
      telloDrone.flyForward(distanceToTravel);

      endFlight();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
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
