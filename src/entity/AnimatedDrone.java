package entity;

import java.lang.Math;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/*
 * Adapter design pattern
 */
public class AnimatedDrone extends ImageView {
  private Duration timelineDurationLong = Duration.seconds(1);
  private Duration timelineDurationShort = Duration.seconds(0.5);
  private SequentialTransition visitLocationAnimation = new SequentialTransition();
  private SequentialTransition scanFarmAnimation = new SequentialTransition();

  public AnimatedDrone(String iconFilePath) {
    super(new Image(iconFilePath, 100, 100, true, true));
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

  private Timeline goToCurrentLocationTimeline() {
    KeyValue goBackXKeyValue = new KeyValue(
      translateXProperty(),
      getTranslateX()
    );
    KeyValue goBackYKeyValue = new KeyValue(
      translateYProperty(),
      getTranslateY()
    );
    KeyFrame goBackKeyFrame = new KeyFrame(
      timelineDurationLong,
      goBackXKeyValue,
      goBackYKeyValue
    );
    return new Timeline(goBackKeyFrame);
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
    KeyFrame rotateKeyFrame = new KeyFrame(
      timelineDurationShort,
      rotateKeyValue
    );
    return new Timeline(rotateKeyFrame);
  }

  // TODO: add stop times
  public void visitLocation(int x, int y) {
    KeyValue goToXKeyValue = new KeyValue(translateXProperty(), x);
    KeyValue goToYKeyValue = new KeyValue(translateYProperty(), y);
    KeyFrame goToKeyFrame = new KeyFrame(
      timelineDurationLong,
      goToXKeyValue,
      goToYKeyValue
    );
    Timeline goToGivenLocationTimeline = new Timeline(
      startAnimationKeyFrame(),
      goToKeyFrame
    );
    visitLocationAnimation =
      new SequentialTransition(
        rotateFromAToBTimeline(getTranslateX(), getTranslateY(), x, y),
        goToGivenLocationTimeline,
        rotateFromAToBTimeline(x, y, getTranslateX(), getTranslateY()),
        goToCurrentLocationTimeline()
      );
    visitLocationAnimation.setCycleCount(1);
    visitLocationAnimation.play();
  }

  public void scanFarm() {
    KeyValue goDownKeyValue = new KeyValue(translateYProperty(), 700);
    KeyFrame goDownKeyFrame = new KeyFrame(
      timelineDurationLong,
      goDownKeyValue
    );
    Timeline goDownTimeline1 = new Timeline(
      startAnimationKeyFrame(),
      goDownKeyFrame
    );
    Timeline goDownTimeline2 = new Timeline(goDownKeyFrame);
    Timeline goDownTimeline3 = new Timeline(goDownKeyFrame);

    KeyValue goRightKeyValue1 = new KeyValue(translateXProperty(), 100);
    KeyValue goRightKeyValue2 = new KeyValue(translateXProperty(), 200);
    KeyValue goRightKeyValue3 = new KeyValue(translateXProperty(), 300);
    KeyValue goRightKeyValue4 = new KeyValue(translateXProperty(), 400);
    KeyValue goRightKeyValue5 = new KeyValue(translateXProperty(), 500);
    KeyFrame goRightKeyFrame1 = new KeyFrame(
      timelineDurationShort,
      goRightKeyValue1
    );
    KeyFrame goRightKeyFrame2 = new KeyFrame(
      timelineDurationShort,
      goRightKeyValue2
    );
    KeyFrame goRightKeyFrame3 = new KeyFrame(
      timelineDurationShort,
      goRightKeyValue3
    );
    KeyFrame goRightKeyFrame4 = new KeyFrame(
      timelineDurationShort,
      goRightKeyValue4
    );
    KeyFrame goRightKeyFrame5 = new KeyFrame(
      timelineDurationShort,
      goRightKeyValue5
    );
    Timeline goRightTimeline1 = new Timeline(goRightKeyFrame1);
    Timeline goRightTimeline2 = new Timeline(goRightKeyFrame2);
    Timeline goRightTimeline3 = new Timeline(goRightKeyFrame3);
    Timeline goRightTimeline4 = new Timeline(goRightKeyFrame4);
    Timeline goRightTimeline5 = new Timeline(goRightKeyFrame5);

    KeyValue goUpKeyValue = new KeyValue(translateYProperty(), 0);
    KeyFrame goUpKeyFrame = new KeyFrame(timelineDurationLong, goUpKeyValue);
    Timeline goUpTimeline1 = new Timeline(goUpKeyFrame);
    Timeline goUpTimeline2 = new Timeline(goUpKeyFrame);
    Timeline goUpTimeline3 = new Timeline(goUpKeyFrame);

    scanFarmAnimation =
      new SequentialTransition(
        goDownTimeline1,
        goRightTimeline1,
        goUpTimeline1,
        goRightTimeline2,
        goDownTimeline2,
        goRightTimeline3,
        goUpTimeline2,
        goRightTimeline4,
        goDownTimeline3,
        goRightTimeline5,
        goUpTimeline3,
        goToCurrentLocationTimeline()
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
