/**
 * This file was adapted from the "Sample Controller Skeleton"
 * generated by SceneBuilder.
 */

package control;

import boundary.Main;
import constants.Constants;
import entity.adapter.drone.virtual.AnimatedDrone;
import entity.composite.Item;
import entity.composite.ItemComponent;
import entity.composite.ItemContainer;
import entity.visitor.AggregateMarketValueVisitor;
import entity.visitor.AggregatePurchasePriceVisitor;
import java.lang.Integer;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class DashboardController {
  private Main main;
  private AnimatedDrone animatedDrone;

  @FXML
  private URL location;

  @FXML
  private ResourceBundle resources;

  @FXML
  private TextArea infoLog = new TextArea();

  private TreeItem<ItemComponent> rootTreeItem;
  private TreeItem<ItemComponent> commandCenterTreeItem;
  private TreeItem<ItemComponent> droneTreeItem;

  @FXML
  private TreeView<ItemComponent> farmTreeView = new TreeView<ItemComponent>();

  @FXML
  private TextField selectionName = new TextField();

  @FXML
  private TextField selectionLocationX = new TextField();

  @FXML
  private TextField selectionLocationY = new TextField();

  @FXML
  private TextField selectionLength = new TextField();

  @FXML
  private TextField selectionWidth = new TextField();

  @FXML
  private TextField selectionHeight = new TextField();

  @FXML
  private TextField selectionPurchasePrice = new TextField();

  @FXML
  private TextField selectionAggregatePurchasePrice = new TextField();

  @FXML
  private TextField selectionMarketValue = new TextField();

  @FXML
  private TextField selectionAggregateMarketValue = new TextField();

  private UnaryOperator<TextFormatter.Change> intFilter = new UnaryOperator<TextFormatter.Change>() {

    public TextFormatter.Change apply(TextFormatter.Change textField) {
      textField.setText(textField.getText().replaceAll("[^0-9]", ""));
      return textField;
    }
  };

  @FXML
  private Group farmMap = new Group();

  @FXML
  public void initialize() {
    assert infoLog !=
    null : "fx:id=\"infoLog\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert farmTreeView !=
    null : "fx:id=\"farmTreeView\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionName !=
    null : "fx:id=\"selectionName\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionLocationX !=
    null : "fx:id=\"selectionLocationX\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionLocationY !=
    null : "fx:id=\"selectionLocationY\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionLength !=
    null : "fx:id=\"selectionLength\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionWidth !=
    null : "fx:id=\"selectionWidth\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionHeight !=
    null : "fx:id=\"selectionHeight\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionPurchasePrice !=
    null : "fx:id=\"selectionPurchasePrice\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionMarketValue !=
    null : "fx:id=\"selectionMarketValue\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionAggregatePurchasePrice !=
    null : "fx:id=\"selectionAggregatePurchasePrice\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert selectionAggregateMarketValue !=
    null : "fx:id=\"selectionAggregateMarketValue\" was not injected: check your FXML file 'Dashboard.fxml'.";
    assert farmMap !=
    null : "fx:id=\"farmMap\" was not injected: check your FXML file 'Dashboard.fxml'.";
    infoLog.setEditable(false);
    selectionLocationX.setTextFormatter(new TextFormatter<>(intFilter));
    selectionLocationY.setTextFormatter(new TextFormatter<>(intFilter));
    selectionLength.setTextFormatter(new TextFormatter<>(intFilter));
    selectionWidth.setTextFormatter(new TextFormatter<>(intFilter));
    selectionHeight.setTextFormatter(new TextFormatter<>(intFilter));
    selectionPurchasePrice.setTextFormatter(new TextFormatter<>(intFilter));
    selectionMarketValue.setTextFormatter(new TextFormatter<>(intFilter));
    selectionAggregatePurchasePrice.setEditable(false);
    selectionAggregateMarketValue.setEditable(false);
  }

  public void setMain(Main main) {
    this.main = main;

    ItemContainer root = main.getRootItemContainer();
    root.setLength(Constants.SCREEN_FARM_LENGTH);
    root.setWidth(Constants.SCREEN_FARM_WIDTH);
    rootTreeItem = new TreeItem<ItemComponent>(root);
    ItemContainer commandCenter = new ItemContainer("Command Center");
    commandCenter.setLength(Constants.SCREEN_DRONE_SIZE);
    commandCenter.setWidth(Constants.SCREEN_DRONE_SIZE);
    commandCenterTreeItem = new TreeItem<ItemComponent>(commandCenter);
    Item droneItem = new Item("Drone");
    droneItem.setLength(Constants.SCREEN_DRONE_SIZE);
    droneItem.setWidth(Constants.SCREEN_DRONE_SIZE);
    droneItem.setPurchasePrice(1000);
    droneItem.setMarketValue(900);
    droneTreeItem = new TreeItem<ItemComponent>(droneItem);
    commandCenter.addItemComponent(droneItem);
    root.addItemComponent(commandCenter);

    farmTreeView.setEditable(false);
    farmTreeView.setRoot(rootTreeItem);
    commandCenterTreeItem.getChildren().add(droneTreeItem);
    rootTreeItem.getChildren().add(commandCenterTreeItem);
    rootTreeItem.setExpanded(true);
    commandCenterTreeItem.setExpanded(true);

    farmMap.getChildren().add(commandCenter.getRectangle());
    animatedDrone = main.getAnimatedDrone();
    farmMap.getChildren().add(animatedDrone);
  }

  private void addToInfoLog(String message) {
    infoLog.appendText(String.format("%s\n", message));
  }

  private TreeItem<ItemComponent> getCurrentSelection() {
    return farmTreeView.getSelectionModel().getSelectedItem();
  }

  private void addToFarmTreeViewAndFarmMap(ItemComponent component) {
    TreeItem<ItemComponent> selection = getCurrentSelection();
    if (selection == null) {
      addToInfoLog("Failed to add; nothing is selected");
      return;
    }
    ItemComponent selectionValue = selection.getValue();
    if (selectionValue instanceof Item) addToInfoLog(
      "Failed to add; Item is selected"
    ); else { // selection is an ItemContainer
      selection.getValue().addItemComponent(component);
      TreeItem<ItemComponent> treeItem = new TreeItem<ItemComponent>(component);
      treeItem.setExpanded(true);
      selection.getChildren().add(treeItem);
      farmMap.getChildren().add(component.getRectangle());
      animatedDrone.toFront();
      addToInfoLog(
        String.format("%s added", component.getClass().getSimpleName())
      );
    }
  }

  @FXML
  /*
   * Called when the "Add Item" button is clicked
   */
  public void addItem(ActionEvent event) {
    addToFarmTreeViewAndFarmMap(new Item());
  }

  @FXML
  /*
   * Called when the "Add ItemContainer" button is clicked
   */
  public void addItemContainer(ActionEvent event) {
    addToFarmTreeViewAndFarmMap(new ItemContainer());
  }

  @FXML
  /*
   * Called when the "Delete Selection" button is clicked
   */
  public void deleteSelection(ActionEvent event) {
    TreeItem<ItemComponent> selection = getCurrentSelection();
    if (selection == null) addToInfoLog(
      "Failed to delete; nothing is selected"
    ); else if (selection == rootTreeItem) addToInfoLog(
      "Failed to delete; Root is selected"
    ); else if (selection == commandCenterTreeItem) addToInfoLog(
      "Failed to delete; Command Center is selected"
    ); else if (selection == droneTreeItem) addToInfoLog(
      "Failed to delete; Drone is selected"
    ); else {
      ItemComponent component = selection.getValue();
      TreeItem<ItemComponent> parent = selection.getParent();
      parent.getValue().deleteItemComponent(selection.getValue());
      parent.getChildren().remove(selection);
      farmMap.getChildren().removeAll(component.getRectangles());
      addToInfoLog("Selection deleted");
      loadSelectionDetails();
    }
  }

  private void refreshselectionAggregatePurchasePrice(ItemComponent component) {
    AggregatePurchasePriceVisitor visitor = new AggregatePurchasePriceVisitor();
    component.acceptVisitor(visitor);
    selectionAggregatePurchasePrice.setText(
      String.format("%d", visitor.value())
    );
  }

  private void refreshselectionAggregateMarketValue(ItemComponent component) {
    AggregateMarketValueVisitor visitor = new AggregateMarketValueVisitor();
    component.acceptVisitor(visitor);
    selectionAggregateMarketValue.setText(String.format("%d", visitor.value()));
  }

  @FXML
  /*
   * Called when the "Farm TreeView" is interacted with
   */
  public void loadSelectionDetails() {
    TreeItem<ItemComponent> selection = getCurrentSelection();
    if (selection == null) return;
    ItemComponent component = selection.getValue();
    selectionName.setText(component.getName());
    selectionLocationX.setText(String.format("%d", component.getLocationX()));
    selectionLocationY.setText(String.format("%d", component.getLocationY()));
    selectionLength.setText(String.format("%d", component.getLength()));
    selectionWidth.setText(String.format("%d", component.getWidth()));
    selectionHeight.setText(String.format("%d", component.getHeight()));
    selectionPurchasePrice.setText(
      String.format("%d", component.getPurchasePrice())
    );
    if (component instanceof Item) {
      selectionMarketValue.setText(
        String.format("%d", component.getMarketValue())
      );
      selectionMarketValue.setDisable(false);
    } else {
      selectionMarketValue.setText("");
      selectionMarketValue.setDisable(true);
    }
    refreshselectionAggregatePurchasePrice(component);
    refreshselectionAggregateMarketValue(component);
    addToInfoLog("Selection details loaded");
  }

  private int parseIntFromTextField(TextField textField) {
    String text = textField.getText();
    if (text.length() == 0) text = "0";
    return Integer.parseInt(text);
  }

  @FXML
  /*
   * Called when the "Update Selection" button is clicked
   */
  public void updateSelection(ActionEvent event) {
    TreeItem<ItemComponent> selection = getCurrentSelection();
    if (selection == null) addToInfoLog(
      "Failed to update; nothing is selected"
    ); else if (selection == rootTreeItem) addToInfoLog(
      "Failed to update; Root is selected"
    ); else if (selection == commandCenterTreeItem) addToInfoLog(
      "Failed to update; Command Center is selected"
    ); else if (selection == droneTreeItem) addToInfoLog(
      "Failed to update; Drone is selected"
    ); else {
      ItemComponent component = selection.getValue();
      component.setName(selectionName.getText());
      component.setLocationX(parseIntFromTextField(selectionLocationX));
      component.setLocationY(parseIntFromTextField(selectionLocationY));
      component.setLength(parseIntFromTextField(selectionLength));
      component.setWidth(parseIntFromTextField(selectionWidth));
      component.setHeight(parseIntFromTextField(selectionHeight));
      component.setPurchasePrice(parseIntFromTextField(selectionPurchasePrice));
      if (component instanceof Item) component.setMarketValue(
        parseIntFromTextField(selectionMarketValue)
      );
      selection.setValue(component);
      farmTreeView.refresh();
      farmMap.getChildren().remove(component.getRectangle());
      farmMap.getChildren().add(component.getRectangle());
      animatedDrone.toFront();
      addToInfoLog("Selection updated");
      loadSelectionDetails();
    }
  }

  @FXML
  /*
   * Called when the "Visit Selection Simulation" button is clicked
   */
  public void visitSelectionSim() {
    TreeItem<ItemComponent> selection = getCurrentSelection();
    if (animatedDrone.isDeployed()) addToInfoLog(
      "Failed to visit; drone is already deployed"
    ); else if (selection == null) addToInfoLog(
      "Failed to visit; nothing is selected"
    ); else if (selection == rootTreeItem) addToInfoLog(
      "Failed to visit; Root is selected"
    ); else if (selection == commandCenterTreeItem) addToInfoLog(
      "Failed to visit; Command Center is selected"
    ); else if (selection == droneTreeItem) addToInfoLog(
      "Failed to visit; Drone is selected"
    ); else {
      ItemComponent component = selection.getValue();
      animatedDrone.visitLocation(
        component.getLocationX(),
        component.getLocationY()
      );
      addToInfoLog("Drone deployed");
    }
  }

  @FXML
  /*
   * Called when the "Scan Farm Simulation" button is clicked
   */
  public void scanFarmSim() {
    if (animatedDrone.isDeployed()) addToInfoLog(
      "Failed to scan; drone is already deployed"
    ); else {
      animatedDrone.scanFarm();
      addToInfoLog("Drone deployed");
    }
  
    @FXML
    /*
     * Called when the "Drone Visit Selection" button is clicked
     */
    public void droneSelection() {
    	TreeItem<ItemComponent> selection = getCurrentSelection();
        if (TelloDroneAdapter.isDeployed()) addToInfoLog(
          "Failed to visit; drone is already deployed"
        ); else if (selection == null) addToInfoLog(
          "Failed to visit; nothing is selected"
        ); else if (selection == rootTreeItem) addToInfoLog(
          "Failed to visit; Root is selected"
        ); else if (selection == commandCenterTreeItem) addToInfoLog(
          "Failed to visit; Command Center is selected"
        ); else if (selection == droneTreeItem) addToInfoLog(
          "Failed to visit; Drone is selected"
        ); else {
          ItemComponent component = selection.getValue();
          TelloDroneAdapter.visitLocation(
            component.getLocationX(),
            component.getLocationY()
          );
          addToInfoLog("Drone deployed");
      }
    
      @FXML
      /*
       * Called when the "Drone Farm Scan" button is clicked
       */
      public void droneScan() {
        if (TelloDroneAdapter.isDeployed()) addToInfoLog(
          "Failed to scan; drone is already deployed"
        ); else {
        	TelloDroneAdapter.scanFarm();
          addToInfoLog("Drone deployed");
        }
  }
}
