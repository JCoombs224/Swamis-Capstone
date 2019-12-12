package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.Item;
import edu.miracosta.cs112.swamis.model.OceanBoards;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MainScene extends Scene {

    public static final int HEIGHT = 600;
    public static final int WIDTH = 750;

    private ImageView swamisIV = new ImageView(); // to use images in application

    private Button addSurfBoardButton = new Button("+ Add SurfBoard");
    private Button addBodyBoardButton = new Button("+ Add BodyBoard");
    private Button addClothingButton = new Button("+ Add Clothing");
    private Button addCruiserButton = new Button("+ Add Cruiser Skateboard");
    private Button addTrickButton = new Button("+ Add Trick SkateBoard");

    private ListView<Item> itemLV = new ListView<>();

    private Button removeButton = new Button("Remove From Shopping Cart");

    private Controller controller = Controller.getInstance();
    private ObservableList<Item> itemList;
    private Item selectedItem;

    public MainScene()
    {
        super(new GridPane(), WIDTH, HEIGHT);

        itemList = controller.getAllItemsList();
        itemLV.setItems(itemList);
        itemLV.setPrefWidth(750);

        itemLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                removeButton.setDisable(true);
                if (newValue != null) {
                    selectedItem = newValue;
                    removeButton.setDisable(false);
                }
            }
        });

        addBodyBoardButton.setOnAction(event -> addBodyBoard());
        addSurfBoardButton.setOnAction(event -> addSurfBoard());
        addClothingButton.setOnAction(event -> addClothing());
        addCruiserButton.setOnAction(event -> addCruiser());
        addTrickButton.setOnAction(event -> addTrick());
        removeButton.setOnAction(event -> removeItem());

        GridPane pane = new GridPane();

        swamisIV.setImage(new Image("swamis.png"));
        swamisIV.setFitWidth(WIDTH); // width constant for size of window
        swamisIV.setFitHeight(250);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.add(swamisIV, 0, 0, 3, 1);

        itemLV.setPrefWidth(WIDTH);
        itemLV.setPrefHeight(200);


        pane.add(addBodyBoardButton, 0, 6);
        pane.add(addSurfBoardButton, 1, 6);
        pane.add(addCruiserButton,2,6);
        pane.add(addTrickButton,3,6);
        pane.add(addClothingButton, 4, 6);
        pane.add(removeButton, 4, 9);

        pane.add(itemLV, 0, 8, 6, 1); // TODO Format columns and rows accordingly for this!!

        setRoot(pane);
    }

    private void removeItem() {

        if (selectedItem == null)
            return;

        itemList.remove(selectedItem);
        updateDisplay();
    }

    private void addSurfBoard()
    {
        // Use the ViewNavigator to load the AddScene
        ViewNavigator.loadScene("Add SurfBoard", new AddSurfBoardScene(this)); // use this because we are in MainScene currently
        // Update the display when done.
        updateDisplay();
    }

    private void addBodyBoard()
    {
        // Use the ViewNavigator to load the AddScene
        ViewNavigator.loadScene("Add BodyBoard", new AddBodyBoardScene(this)); // use this because we are in MainScene currently
        // Update the display when done.
        updateDisplay();
    }

    private void addClothing()
    {
        ViewNavigator.loadScene("Please select type of clothing", new ChooseClothingScene(this));
        updateDisplay();
    }

    private void addCruiser() {
        ViewNavigator.loadScene("Add a Cruiser Skateboard", new AddCruiserScene(this));
        updateDisplay();
    }

    private void addTrick() {
        ViewNavigator.loadScene("Add a trick Skateboard", new AddTrickScene(this));
        updateDisplay();
    }


    private void updateDisplay()
    {
        itemLV.refresh();
    }

}
