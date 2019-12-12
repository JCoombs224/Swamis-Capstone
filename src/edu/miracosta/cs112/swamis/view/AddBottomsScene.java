package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.Bottoms;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.Scene;

public class AddBottomsScene extends Scene {

    private Controller controller = Controller.getInstance();


    private ComboBox<String> typeCB = new ComboBox<>();
    private ComboBox<String> sizeCB = new ComboBox<>();
    private ComboBox<String> sexCB = new ComboBox<>();

    private Label typeLabel = new Label("Please specify the type of bottoms.");
    private Label sexLabel = new Label("Please specify the sex.");
    private Label sizeLabel = new Label("Please specify the size.");

    private Button addButton = new Button("Add item");
    private Button cancelButton = new Button("Cancel");

    private String[] maleItems = {"Trunks $34.99", "Board Shorts $29.99"};

    public AddBottomsScene()
    {
        super(new GridPane(),450,250);
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.setPadding(new Insets(5));

        sexCB.getItems().setAll("Male", "Female");
        sizeCB.getItems().setAll("XS", "S", "M", "L", "XL", "XXL");

        pane.add(new Label("Sex:"), 0, 0);
        pane.add(sexCB, 1, 0);
        pane.add(sexLabel, 2, 0);
        sexLabel.setTextFill(Color.RED);
        sexLabel.setVisible(false);

        pane.add(new Label("Type:"), 0, 1);
        pane.add(typeCB, 1, 1);
        typeCB.setDisable(true);
        pane.add(typeLabel, 2, 1);
        typeLabel.setTextFill(Color.RED);
        typeLabel.setVisible(false);

        pane.add(new Label("Size:"), 0, 2);
        pane.add(sizeCB, 1, 2);
        sizeCB.setDisable(true);
        pane.add(sizeLabel, 2, 2);
        sizeLabel.setTextFill(Color.RED);
        sizeLabel.setVisible(false);

        pane.add(addButton, 1, 5);
        pane.add(cancelButton, 1, 7);

        sexCB.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if(newValue!=null) {
                    typeCB.setDisable(false);
                    sizeCB.setDisable(false);
                }
                if (newValue.equals(1))
                    typeCB.getItems().setAll("Women's Bathing Suit $44.99");
                if (newValue.equals(0))
                    typeCB.getItems().setAll(maleItems);
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
        String sex, size;
        int type = -1;

        sex = sexCB.getSelectionModel().getSelectedItem();
        sexLabel.setVisible(sex==null);

        type = typeCB.getSelectionModel().getSelectedIndex();
        typeLabel.setVisible(type==-1);

        size = sizeCB.getSelectionModel().getSelectedItem();
        sizeLabel.setVisible(size==null);

        if (typeLabel.isVisible() || sexLabel.isVisible() || sizeLabel.isVisible())
            return;

        if (sex.equalsIgnoreCase("female"))
            type += 2;

        Bottoms newBottoms = new Bottoms(sex, type, size);
        controller.getAllItemsList().add(newBottoms);
        goBackToRoot();
    }
}
