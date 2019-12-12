package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.Accessory;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddAccessoryScene extends Scene {

    private Controller controller = Controller.getInstance();

    private ComboBox<String> typeCB = new ComboBox<>();
    private ComboBox<String> sexCB = new ComboBox<>();

    private Label typeLabel = new Label("Please specify the type of accessory.");
    private Label sexLabel = new Label("Please specify the sex.");

    private Button addButton = new Button("Add item");
    private Button cancelButton = new Button("Cancel");

    public AddAccessoryScene()
    {
        super(new GridPane(),450,250);
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.setPadding(new Insets(5));

        sexCB.getItems().setAll("Male", "Female");
        typeCB.getItems().setAll("Hat", "Helmet", "Sunglasses", "Wallet", "Belt");

        pane.add(new Label("Sex:"), 0, 0);
        pane.add(sexCB, 1, 0);
        pane.add(sexLabel, 2, 0);
        sexLabel.setTextFill(Color.RED);
        sexLabel.setVisible(false);

        pane.add(new Label("Type:"), 0, 1);
        pane.add(typeCB, 1, 1);
        pane.add(typeLabel, 2, 1);
        typeLabel.setTextFill(Color.RED);
        typeLabel.setVisible(false);

        pane.add(addButton, 1, 5);
        pane.add(cancelButton, 1, 7);

        addButton.setOnAction(event -> addItem());
        cancelButton.setOnAction(event -> goBackToRoot());

        this.setRoot(pane);
    }

    private void goBackToRoot(){
        ViewNavigator.loadScene("Swami's Shopping Cart", new MainScene());
    }

    private void addItem(){
        int type = -1;
        String sex;

        type = typeCB.getSelectionModel().getSelectedIndex();
        typeLabel.setVisible(type==-1);

        sex = sexCB.getSelectionModel().getSelectedItem();
        sexLabel.setVisible(sex==null);

        if (typeLabel.isVisible() || sexLabel.isVisible())
            return;

        Accessory newAccessory = new Accessory(sex, type);
        controller.getAllItemsList().add(newAccessory);
        goBackToRoot();
    }
}
