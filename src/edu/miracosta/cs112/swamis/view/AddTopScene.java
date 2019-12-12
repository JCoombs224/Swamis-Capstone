package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.Top;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddTopScene extends Scene {

    private Controller controller = Controller.getInstance();

    private ComboBox<String> typeCB = new ComboBox<>();
    private ComboBox<String> sizeCB = new ComboBox<>();
    private ComboBox<String> colorCB = new ComboBox<>();
    private ComboBox<String> sexCB = new ComboBox<>();

    private Label typeLabel = new Label("Please specify the type of top.");
    private Label sexLabel = new Label("Please specify the sex.");
    private Label colorLabel = new Label("Please specify the color.");
    private Label sizeLabel = new Label("Please specify the size.");

    private Button addButton = new Button("Add item");
    private Button cancelButton = new Button("Cancel");
    private String[] allSex = {"Male", "Female"};



    public AddTopScene()
    {
        super(new GridPane(),450,250);

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.setPadding(new Insets(5));

        typeCB.getItems().setAll("T-shirt $24.99", "Long-Sleeve $29.99", "Tank Top $19.99", "Hoodie $64.99");
        sexCB.getItems().setAll(allSex);
        sizeCB.getItems().setAll("XS", "S", "M", "L", "XL", "XXL");
        colorCB.getItems().setAll("Black", "White", "Red", "Navy Blue", "Brown", "Orange");

        pane.add(new Label("Type:"), 0, 0);
        pane.add(typeCB, 1, 0);
        pane.add(typeLabel, 2, 0);
        typeLabel.setTextFill(Color.RED);
        typeLabel.setVisible(false);

        pane.add(new Label("Sex:"), 0, 1);
        pane.add(sexCB, 1, 1);
        pane.add(sexLabel, 2, 1);
        sexLabel.setTextFill(Color.RED);
        sexLabel.setVisible(false);

        pane.add(new Label("Size:"), 0, 2);
        pane.add(sizeCB, 1, 2);
        pane.add(sizeLabel, 2, 2);
        sizeLabel.setTextFill(Color.RED);
        sizeLabel.setVisible(false);

        pane.add(new Label("Color:"), 0, 3);
        pane.add(colorCB, 1, 3);
        pane.add(colorLabel, 2, 3);
        colorLabel.setTextFill(Color.RED);
        colorLabel.setVisible(false);


        pane.add(addButton, 1, 5);
        pane.add(cancelButton, 1, 7);

        typeCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if (newValue.equals(3))
                    sexCB.getItems().setAll("Unisex");
                else
                    sexCB.getItems().setAll(allSex);
            }
        });

        addButton.setOnAction(event -> addItem());
        cancelButton.setOnAction(event -> goBackToRoot());

        this.setRoot(pane);
    }

    private void goBackToRoot(){
        ViewNavigator.loadScene("Swami's Shopping Cart", new MainScene());
    }

    private void addItem(){
        int type = -1;
        String sex, size, color;

        type = typeCB.getSelectionModel().getSelectedIndex();
        typeLabel.setVisible(type==-1);

        sex = sexCB.getSelectionModel().getSelectedItem();
        sexLabel.setVisible(sex==null);

        size = sizeCB.getSelectionModel().getSelectedItem();
        sizeLabel.setVisible(size==null);

        color = colorCB.getSelectionModel().getSelectedItem();
        colorLabel.setVisible(color==null);

        if (typeLabel.isVisible() || sexLabel.isVisible() || sizeLabel.isVisible() || colorLabel.isVisible())
            return;

        Top newTop = new Top(sex, type, size, color);
        controller.getAllItemsList().add(newTop);
        goBackToRoot();

    }
}
