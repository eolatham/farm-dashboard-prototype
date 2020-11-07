package entity;

import java.lang.Math;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/*
 * Adapter design pattern
 */
public class AnimatedDrone extends ImageView {
  private final int travelSpeed = 100; // pixels per second
  private final Duration rotateDuration = Duration.seconds(1.5); // seconds
  private final Duration stopDuration = Duration.seconds(1.5); // seconds
  private SequentialTransition visitLocationAnimation = new SequentialTransition();
  private SequentialTransition scanFarmAnimation = new SequentialTransition();

  public AnimatedDrone(String iconFilePath) {
    super(new Image(iconFilePath, 100, 100, true, true));
  }

  /*
   * distance: pixels
   * speed: pixels per second
   */
  private Duration secondsToTravelFromAToB(
    double aX,
    double aY,
    double bX,
    double bY,
    double speed
  ) {
    return Duration.seconds(Math.abs(Math.hypot(bX - aX, bY - aY) / speed));
  }

  private double angleFromAToB(double aX, double aY, double bX, double bY) {
    return Math.toDegrees(Math.atan2(bY - aY, bX - aX));
  }

  private Timeline rotateFromAToBTimeline(
    double aX,
    double aY,
    double bX,
    double bY
  ) {
    KeyValue rotateKeyValue = new KeyValue(
      rotateProperty(),
      angleFromAToB(aX, aY, bX, bY)
    );
    KeyFrame rotateKeyFrame = new KeyFrame(rotateDuration, rotateKeyValue);
    return new Timeline(rotateKeyFrame);
  }

  private Timeline rotateUpTimeline() {
    return rotateFromAToBTimeline(0, 0, 0, -1);
  }

  private Timeline rotateDownTimeline() {
    return rotateFromAToBTimeline(0, 0, 0, 1);
  }

  private Timeline rotateLeftTimeline() {
    return rotateFromAToBTimeline(0, 0, -1, 0);
  }

  private Timeline rotateRightTimeline() {
    return rotateFromAToBTimeline(0, 0, 1, 0);
  }

  private KeyFrame startAnimationKeyFrame() {
    KeyValue startXKeyValue = new KeyValue(
      translateXProperty(),
      getTranslateX()
    );
    KeyValue startYKeyValue = new KeyValue(
      translateYProperty(),
      getTranslateY()
    );
    return new KeyFrame(Duration.seconds(0), startXKeyValue, startYKeyValue);
  }

  public void visitLocation(int x, int y) {
    if (getTranslateX() == x && getTranslateY() == y) return;

    Duration keyFrameDuration = secondsToTravelFromAToB(
      getTranslateX(),
      getTranslateY(),
      x,
      y,
      travelSpeed
    );

    KeyValue goToXKeyValue = new KeyValue(translateXProperty(), x);
    KeyValue goToYKeyValue = new KeyValue(translateYProperty(), y);
    KeyFrame goToKeyFrame = new KeyFrame(
      keyFrameDuration,
      goToXKeyValue,
      goToYKeyValue
    );
    Timeline goToTimeline = new Timeline(
      startAnimationKeyFrame(),
      goToKeyFrame
    );

    KeyValue goBackXKeyValue = new KeyValue(
      translateXProperty(),
      getTranslateX()
    );
    KeyValue goBackYKeyValue = new KeyValue(
      translateYProperty(),
      getTranslateY()
    );
    KeyFrame goBackKeyFrame = new KeyFrame(
      keyFrameDuration,
      goBackXKeyValue,
      goBackYKeyValue
    );
    Timeline goBackTimeline = new Timeline(goBackKeyFrame);

    visitLocationAnimation =
      new SequentialTransition(
        rotateFromAToBTimeline(getTranslateX(), getTranslateY(), x, y),
        goToTimeline,
        new PauseTransition(stopDuration),
        rotateFromAToBTimeline(x, y, getTranslateX(), getTranslateY()),
        goBackTimeline
      );
    visitLocationAnimation.setCycleCount(1);
    visitLocationAnimation.play();
  }

  public void scanFarm() {
    Duration timeToTravel700 = secondsToTravelFromAToB(
      0,
      0,
      0,
      700,
      travelSpeed
    );
    Duration timeToTravel100 = secondsToTravelFromAToB(
      0,
      0,
      100,
      0,
      travelSpeed
    );

    KeyValue goDownKeyValue = new KeyValue(translateYProperty(), 700);
    KeyFrame goDownKeyFrame = new KeyFrame(timeToTravel700, goDownKeyValue);
    Timeline goDownTimeline1;
    if (getTranslateX() != 0 || getTranslateY() != 0) {
      // make sure we start at (0, 0)
      KeyValue originXKeyValue = new KeyValue(translateXProperty(), 0);
      KeyValue originYKeyValue = new KeyValue(translateYProperty(), 0);
      KeyFrame originKeyFrame = new KeyFrame(
        secondsToTravelFromAToB(
          getTranslateX(),
          getTranslateY(),
          0,
          0,
          travelSpeed
        ),
        originXKeyValue,
        originYKeyValue
      );
      goDownTimeline1 =
        new Timeline(startAnimationKeyFrame(), originKeyFrame, goDownKeyFrame);
    } else {
      // we are already at (0, 0)
      goDownTimeline1 = new Timeline(startAnimationKeyFrame(), goDownKeyFrame);
    }
    Timeline goDownTimeline2 = new Timeline(goDownKeyFrame);
    Timeline goDownTimeline3 = new Timeline(goDownKeyFrame);

    KeyValue goRightKeyValue1 = new KeyValue(translateXProperty(), 100);
    KeyValue goRightKeyValue2 = new KeyValue(translateXProperty(), 200);
    KeyValue goRightKeyValue3 = new KeyValue(translateXProperty(), 300);
    KeyValue goRightKeyValue4 = new KeyValue(translateXProperty(), 400);
    KeyValue goRightKeyValue5 = new KeyValue(translateXProperty(), 500);
    KeyFrame goRightKeyFrame1 = new KeyFrame(timeToTravel100, goRightKeyValue1);
    KeyFrame goRightKeyFrame2 = new KeyFrame(timeToTravel100, goRightKeyValue2);
    KeyFrame goRightKeyFrame3 = new KeyFrame(timeToTravel100, goRightKeyValue3);
    KeyFrame goRightKeyFrame4 = new KeyFrame(timeToTravel100, goRightKeyValue4);
    KeyFrame goRightKeyFrame5 = new KeyFrame(timeToTravel100, goRightKeyValue5);
    Timeline goRightTimeline1 = new Timeline(goRightKeyFrame1);
    Timeline goRightTimeline2 = new Timeline(goRightKeyFrame2);
    Timeline goRightTimeline3 = new Timeline(goRightKeyFrame3);
    Timeline goRightTimeline4 = new Timeline(goRightKeyFrame4);
    Timeline goRightTimeline5 = new Timeline(goRightKeyFrame5);

    KeyValue goUpKeyValue = new KeyValue(translateYProperty(), 0);
    KeyFrame goUpKeyFrame = new KeyFrame(timeToTravel700, goUpKeyValue);
    Timeline goUpTimeline1 = new Timeline(goUpKeyFrame);
    Timeline goUpTimeline2 = new Timeline(goUpKeyFrame);
    Timeline goUpTimeline3 = new Timeline(goUpKeyFrame);

    KeyValue goLeftKeyValue = new KeyValue(translateXProperty(), 0);
    KeyFrame goLeftKeyFrame = new KeyFrame(timeToTravel700, goLeftKeyValue);
    Timeline goLeftTimeline1 = new Timeline(goLeftKeyFrame);

    scanFarmAnimation =
      new SequentialTransition(
        rotateDownTimeline(),
        goDownTimeline1,
        rotateRightTimeline(),
        goRightTimeline1,
        rotateUpTimeline(),
        goUpTimeline1,
        rotateRightTimeline(),
        goRightTimeline2,
        rotateDownTimeline(),
        goDownTimeline2,
        rotateRightTimeline(),
        goRightTimeline3,
        rotateUpTimeline(),
        goUpTimeline2,
        rotateRightTimeline(),
        goRightTimeline4,
        rotateDownTimeline(),
        goDownTimeline3,
        rotateRightTimeline(),
        goRightTimeline5,
        rotateUpTimeline(),
        goUpTimeline3,
        rotateLeftTimeline(),
        goLeftTimeline1
      );
    scanFarmAnimation.setCycleCount(1);
    scanFarmAnimation.play();
  }

  public boolean isDeployed() {
    return (
      scanFarmAnimation.getStatus() == Animation.Status.RUNNING ||
      visitLocationAnimation.getStatus() == Animation.Status.RUNNING
    );
  }
}
