package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class ChooseClothingScene extends Scene {
    private Scene mPrevScene;

    private Controller controller = Controller.getInstance();

    private Label choiceLabel = new Label("Please make a selection of what type of clothing you would like to add:");

    private Button topsButton = new Button("Tops");
    private Button bottomsButton = new Button("Bottoms");
    private Button accessoryButton = new Button("Accessories");
    private Button cancelButton = new Button("Cancel");

    public ChooseClothingScene(Scene prevScene)
    {
        super(new GridPane(),450,250);
        mPrevScene = prevScene;

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.setPadding(new Insets(5));

        pane.add(choiceLabel, 0, 0);
        pane.add(topsButton, 0, 1);
        pane.add(bottomsButton, 0, 2);
        pane.add(accessoryButton, 0, 3);
        pane.add(cancelButton, 0, 6);

        topsButton.setOnAction(event -> goTopScene());
        //bottomsButton.setOnAction(event -> );
        //accessoryButton.setOnAction(event -> );

        cancelButton.setOnAction(event -> goBackToPrevScene());

        this.setRoot(pane);
    }

    private void goTopScene() {
        ViewNavigator.loadScene("Add a new top", new AddTopScene());
    }

    private void goBackToPrevScene() {
        ViewNavigator.loadScene("Swami's Shopping Cart", mPrevScene);
    }
}