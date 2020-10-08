/*
 * This file was adapted from the example provided in the official
 * assignment tutorial available at the following link:
 * https://code.makery.ch/library/javafx-tutorial/part1/
 */

package menu;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import menu.view.MenuOverviewController;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    // choices to be set in the "elements" ChoiceBox by MenuOverviewController
    public ObservableList<String> elementChoices =
    		FXCollections.observableArrayList(
    		"Element 1",
    		"Element 2"
    );

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Menu");
        initRootLayout();
        showMenuOverview();
    }

    /*
     * Initializes the root layout
     */
    public void initRootLayout() {
        try {
            // load root layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Shows the menu overview inside the root layout
     */
    public void showMenuOverview() {
        try {
            // load menu overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MenuOverview.fxml"));
            HBox menuOverview = (HBox) loader.load();

            // set menu overview into the center of root layout
            rootLayout.setCenter(menuOverview);

            // give the controller access to the main application
            MenuOverviewController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/*
	 * Returns the main stage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }
}
