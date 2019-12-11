package edu.miracosta.cs112.swamis.view;

import edu.miracosta.cs112.swamis.controller.Controller;
import edu.miracosta.cs112.swamis.model.OceanBoards;
import edu.miracosta.cs112.swamis.model.SurfBoard;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AddSurfBoardScene extends Scene {

    private Scene mPrevScene;

    private Controller controller = Controller.getInstance();
    private ObservableList<OceanBoards> allOceanBoardsList;

    private TextField nameTF = new TextField();
    private Label nameLabel = new Label("Name is required."); // NAME IS REQUIRED

    private TextField brandTF = new TextField();
    private Label brandLabel = new Label("Brand is required.");

    private TextField descriptionTF = new TextField();
    // private Label descriptionLabel = new Label("Description is required."); Do we want description required?

    private TextField priceTF = new TextField();
    private Label priceLabel = new Label("Price is required.");

    private TextField lengthTF = new TextField();

    private TextField widthTF = new TextField();

    private TextField thicknessTF = new TextField();

    private TextField volumeTF = new TextField();

    private CheckBox epoxyCB = new CheckBox();

    private Button saveButton = new Button("Save");
    private Button cancelButton = new Button("Cancel");



    public AddSurfBoardScene(Scene prevScene)
    {
        super(new GridPane(), 400, 300);
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

        pane.add(new Label("Length (in inches):"), 0, 3);
        pane.add(lengthTF, 1, 3);

        pane.add(new Label("Width (in inches):"), 0, 4);
        pane.add(widthTF, 1, 4);

        pane.add(new Label("Thickness (in inches):"), 0, 5);
        pane.add(thicknessTF, 1, 5);

        pane.add(new Label("Volume (in cubic liters):"), 0, 6);
        pane.add(volumeTF, 1, 6);

       // EPOXY SELECTION...TRUE/FALSE ROW 7
        pane.add(new Label("Epoxy:"), 0, 7);
        pane.add(epoxyCB, 1, 7);


        pane.add(new Label("Price:"), 0, 8);
        pane.add(priceTF, 1, 8);
        pane.add(priceLabel, 2, 8);
        priceLabel.setTextFill(Color.RED);
        priceLabel.setVisible(false);

        pane.add(cancelButton, 0, 9);
        pane.add(saveButton, 1, 9);

        saveButton.setOnAction(event -> save());
        cancelButton.setOnAction(event -> goBackToPrevScene());
        this.setRoot(pane);
    }


    private void save()
    {
        String name, brand, description;
        double price = 0.0, length = 0.0, width = 0.0, thickness = 0.0, volume = 0.0; // Default values if not given
        boolean epoxy = false;

        name = nameTF.getText();
        nameLabel.setVisible(name.isEmpty());

        brand = brandTF.getText();
        brandLabel.setVisible(name.isEmpty());

        description = descriptionTF.getText();
        // if we want description mandatory...descriptionTF.setVisible(name.isEmpty());

        epoxy = epoxyCB.isSelected();

        try {
            price = Double.parseDouble(priceTF.getText());
            if (price < 0.0)
                priceLabel.setVisible(true);
        }
        catch (NumberFormatException e) {  priceLabel.setVisible(true); }

        try {
            length = Double.parseDouble(lengthTF.getText());
        }
        catch (NumberFormatException e) { } // length, width, thickness and volume quietly ignored if not given or invalid

        try {
            width = Double.parseDouble(widthTF.getText());
        }
        catch (NumberFormatException e) { }

        try {
            thickness = Double.parseDouble(thicknessTF.getText());
        }
        catch (NumberFormatException e) { }

        try {
            volume = Double.parseDouble(volumeTF.getText());
        }
        catch (NumberFormatException e) { }

        if (nameLabel.isVisible() || brandLabel.isVisible() || priceLabel.isVisible())
            return;

        SurfBoard s = new SurfBoard(name, description, brand, length,price,width,thickness,volume,epoxy);
        controller.getAllBoards().add(s);
        goBackToPrevScene();
    }

    private void goBackToPrevScene()
    {
        ViewNavigator.loadScene("Swami's Shopping Cart", mPrevScene);
    }


}
