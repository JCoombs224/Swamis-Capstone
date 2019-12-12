package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.BodyBoard;
import edu.miracosta.cs112.swamis.model.OceanBoards;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddBodyBoardScene extends Scene {

    private Scene mPrevScene;

    private Controller controller = Controller.getInstance();
    private ObservableList<OceanBoards> allOceanBoardsList;

    private TextField nameTF = new TextField();
    private Label nameLabel = new Label("Name is required.");

    private TextField brandTF = new TextField();
    private Label brandLabel = new Label("Brand is required.");

    private TextField descriptionTF = new TextField();
    // private Label descriptionLabel = new Label("Description is required."); Do we want description required

    private TextField priceTF = new TextField();
    private Label priceLabel = new Label("Price is required.");

    private TextField lengthTF = new TextField();

    private TextField coreTF = new TextField();

    private TextField colorTF = new TextField();

    private TextField tailShapeTF = new TextField();

    private Button saveButton = new Button("Save");
    private Button cancelButton = new Button("Cancel");



    public AddBodyBoardScene(Scene prevScene)
    {
        super(new GridPane(), 300, 300);
        mPrevScene = prevScene;

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(new Label("Name:"), 0, 0);
        pane.add(nameTF, 1, 0);
        pane.add(nameLabel, 2, 0);
        nameLabel.setTextFill(Color.RED);
        nameLabel.setVisible(false);

        pane.add(new Label("Brand:"), 0, 1);
        pane.add(brandTF, 1, 1);
        pane.add(brandLabel, 2, 1);
        brandLabel.setTextFill(Color.RED);
        brandLabel.setVisible(false);

        pane.add(new Label("Description:"), 0, 2);
        pane.add(descriptionTF, 1, 2);

        pane.add(new Label("Length:"), 0, 3);
        pane.add(lengthTF, 1, 3);

        pane.add(new Label("Core:"), 0, 4);
        pane.add(coreTF, 1, 4);

        pane.add(new Label("Color:"), 0, 5);
        pane.add(colorTF, 1, 5);

        pane.add(new Label("Tail Shape:"), 0, 6);
        pane.add(tailShapeTF, 1, 6);

        pane.add(new Label("Price:"), 0, 7);
        pane.add(priceTF, 1, 7);
        pane.add(priceLabel, 2, 7);
        priceLabel.setTextFill(Color.RED);
        priceLabel.setVisible(false);

        pane.add(cancelButton, 0, 8);
        pane.add(saveButton, 1, 8);

        saveButton.setOnAction(event -> save());
        cancelButton.setOnAction(event -> goBackToPrevScene());
        this.setRoot(pane);
    }


    private void save()
    {
        String name, brand, description, core, color, tailShape;
        double price = 0.0, length = 0.0; // Default values if not given

        name = nameTF.getText();
        nameLabel.setVisible(name.isEmpty());

        brand = brandTF.getText();
        brandLabel.setVisible(name.isEmpty());

        description = descriptionTF.getText();
        // if we want description mandatory...descriptionTF.setVisible(name.isEmpty());

        core = coreTF.getText();

        color = colorTF.getText();

        tailShape = tailShapeTF.getText();

        try {
            price = Double.parseDouble(priceTF.getText());
            if (price < 0.0)
                priceLabel.setVisible(true);
        }
        catch (NumberFormatException e) {  priceLabel.setVisible(true); }

        try {
            length = Double.parseDouble(lengthTF.getText());
        }
        catch (NumberFormatException e) { } // length quietly ignored if not given or invalid


        if (nameLabel.isVisible() || brandLabel.isVisible() || priceLabel.isVisible())
            return;

        BodyBoard b = new BodyBoard(name, description, brand, length, price, core, tailShape, color);
        controller.getAllItemsList().add(b);
        goBackToPrevScene();
    }

    private void goBackToPrevScene()
    {
        ViewNavigator.loadScene("Swami's Shopping Cart", mPrevScene);
    }


}
