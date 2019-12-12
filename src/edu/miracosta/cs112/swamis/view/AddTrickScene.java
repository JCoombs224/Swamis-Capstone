package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.SkateBoards;
import edu.miracosta.cs112.swamis.model.Trick;
import edu.miracosta.cs112.swamis.view.ViewNavigator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddTrickScene extends Scene {

    private Scene mPrevScene;

    private Controller controller = Controller.getInstance();
    private ObservableList<SkateBoards> allSkateBoardsList;

    private TextField trucksTF = new TextField();
    private Label trucksLabel = new Label("Truck Brand: ");

    private TextField wheelsTF = new TextField();
    private Label wheelsLabel = new Label("Wheel Type: ");

    private TextField priceTF = new TextField();
    private Label priceLabel = new Label("Price of Cruiser: ");

    private TextField brandTF = new TextField();
    private Label brandsLabel = new Label("Wood or Metal: ");

    private TextField deckSizeTF = new TextField();
    private Label deckLabel = new Label("Deck Size(inches: ");

    private TextField wheelSizeTF = new TextField();
    private Label wheelSizeLabel = new Label("Truck Size: ");


    private Button saveButton = new Button("Save");
    private Button cancelButton = new Button("Cancel");



    public AddTrickScene(Scene prevScene)
    {
        super(new GridPane(), 400, 300);
        mPrevScene = prevScene;

        GridPane pane = new GridPane();
        pane.setHgap(15.0);
        pane.setVgap(15.0);
        pane.setPadding(new Insets(5));

        pane.add(new Label("Trucks:"), 0, 0);
        pane.add(trucksTF, 1, 0);
        pane.add(trucksLabel, 2, 0);
        trucksLabel.setVisible(false);

        pane.add(new Label("Wheels:"), 0, 1);
        pane.add(wheelsTF, 1, 1);
        pane.add(wheelsLabel, 2, 1);
        wheelsLabel.setVisible(false);

        pane.add(new Label("Price:"), 0, 2);
        pane.add(priceTF, 1, 2);

        pane.add(new Label("Brand:"), 0, 3);
        pane.add(brandTF, 1, 3);

        pane.add(new Label("Deck Size (inches):"), 0, 4);
        pane.add(deckSizeTF, 1, 4);

        pane.add(new Label("Wheel Size:"), 0, 5);
        pane.add(wheelSizeTF, 1, 5);

        pane.add(cancelButton, 0, 8);
        pane.add(saveButton, 1, 8);

        saveButton.setOnAction(event -> save());
        cancelButton.setOnAction(event -> goBackToPrevScene());
        this.setRoot(pane);
    }


    private void save()
    {
        String trucks, wheels, brand;
        double price = 0.0;
        int deckSize = 0, wheelSize = 0;

        trucks = trucksTF.getText();
        trucksLabel.setVisible(trucks.isEmpty());

        wheels = wheelsTF.getText();
        wheelsLabel.setVisible(wheels.isEmpty());

        brand = brandTF.getText();


        try {
            price = Double.parseDouble(priceTF.getText());
            if (price < 0.0)
                priceLabel.setVisible(true);
        }
        catch (NumberFormatException e) {  priceLabel.setVisible(true); }

        try {
            wheelSize = Integer.parseInt(wheelSizeTF.getText());
        }
        catch (NumberFormatException e) { }

        try {
            deckSize = Integer.parseInt(deckSizeTF.getText());
        }
        catch (NumberFormatException e) { }


        Trick t = new Trick(trucks, wheels, price, deckSize, brand, wheelSize);
        controller.getAllItemsList().add(t);
        goBackToPrevScene();
    }

    private void goBackToPrevScene()
    {
        ViewNavigator.loadScene("Swami's Shopping Cart", mPrevScene);
    }
}
