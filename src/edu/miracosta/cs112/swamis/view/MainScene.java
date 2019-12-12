package edu.miracosta.cs112.swamis;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class MainScene extends Scene {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private javafx.scene.control.Button addCruiserButton = new javafx.scene.control.Button("+ Add Cruiser");
    private javafx.scene.control.Button addTrickButton = new javafx.scene.control.Button("+ Add Trick Skateboard");

    private ListView<SkateBoards> sk8BoardsLV = new ListView<>();
    private javafx.scene.control.Button removeButton = new javafx.scene.control.Button("Remove From Shopping Cart");

    private Controller controller = Controller.getInstance();
    private ObservableList<SkateBoards> skateBoardsList;
    private SkateBoards selectedItem;

    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        skateBoardsList = controller.getAllBoards();
        sk8BoardsLV.setItems(skateBoardsList);

        sk8BoardsLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SkateBoards>() {
            @Override
            public void changed(ObservableValue<? extends SkateBoards> observable, SkateBoards oldValue, SkateBoards newValue) {
                removeButton.setDisable(true);
                if (newValue != null) {
                    selectedItem = newValue;
                    removeButton.setDisable(false);
                }
            }
        });

        addCruiserButton.setOnAction(event -> addCruiser());
        addTrickButton.setOnAction(event -> addTrick());
        removeButton.setOnAction(event -> removeItem());

        GridPane pane = new GridPane();
        sk8BoardsLV.setPrefWidth(WIDTH);
        pane.add(sk8BoardsLV,0,8,3,1);
        pane.add(addCruiserButton, 0, 5);
        pane.add(addTrickButton, 1, 5);
        pane.add(removeButton, 0, 20);

        setRoot(pane);

    }

    private void removeItem() {

        if (selectedItem == null)
            return;

        skateBoardsList.remove(selectedItem);
        updateDisplay();
    }

    private void addCruiser()
    {
        ViewNavigator.loadScene("Add Cruiser Board", new AddCruiserScene(this));
        updateDisplay();
    }

    private void addTrick()
    {
        ViewNavigator.loadScene("Add Trick Board", new AddTrickScene(this));
        updateDisplay();
    }

    private void updateDisplay() {
        sk8BoardsLV.refresh();
    }
}








