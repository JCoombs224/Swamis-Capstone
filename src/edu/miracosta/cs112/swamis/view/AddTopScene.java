package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddTopScene extends Scene {

    private Controller controller = Controller.getInstance();

    private ComboBox<String> typeCB;
    private ComboBox<String> sizeCB;
    private ComboBox<String> colorCB;
    private Label priceLabel;
    private Button cancelButton = new Button("Cancel");



    public AddTopScene()
    {
        super(new GridPane(),450,250);

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(10);
        pane.setPadding(new Insets(5));

        typeCB.getItems().setAll("T-shirt $24.99", "Long-Sleeve $29.99", "Tank Top $19.99", "Hoodie $64.99");
        sizeCB.getItems().setAll("XS", "S", "M", "L", "XL", "XXL");
        colorCB.getItems().setAll("Black", "White", "Red", "Navy Blue", "Brown", "Orange");

    }
}
