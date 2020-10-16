/*
 * This file was adapted from the example provided in the official
 * assignment tutorial available at the following link:
 * https://code.makery.ch/library/javafx-tutorial/part1/
 */

package boundary;

import control.DashboardController;

import entity.ItemContainer;
import entity.Drone;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.animation.TranslateTransition;

public class Main extends Application {
  private Stage primaryStage;
  private BorderPane rootLayout;
  private ItemContainer rootItemContainer = new ItemContainer("Root");
  private Drone dummyDrone;
  
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setResizable(false);
    this.primaryStage.setTitle("Dashboard");
    initRootLayout();
    showDashboard();
  }

  public void initRootLayout() {
    try {
      // load root layout from FXML file
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("RootLayout.fxml"));
      rootLayout = (BorderPane) loader.load();

      // show the scene containing the root layout
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showDashboard() {
    try {
      // load dashboard
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("Dashboard.fxml"));
      HBox Dashboard = (HBox) loader.load();

      // set dashboard into the center of root layout
      rootLayout.setCenter(Dashboard);

      // give the controller access to the main application
      DashboardController controller = loader.getController();
      controller.setMain(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }

  public ItemContainer getRootItemContainer() {
    return rootItemContainer;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
