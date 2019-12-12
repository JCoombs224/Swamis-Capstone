package edu.miracosta.cs112.swamis.controller;

import edu.miracosta.cs112.swamis.model.Item;
import edu.miracosta.cs112.swamis.model.Model;
import edu.miracosta.cs112.swamis.model.OceanBoards;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

        private static edu.miracosta.cs112.swamis.controller.Controller theInstance;
        private ObservableList<Item> mAllItemsList;
        private ObservableList<Item> mFilteredList;

        private Controller() {}

        /**
         * Gets the one instance of the Controller.
         * @return The instance
         */
        public static Controller getInstance() {
            if (theInstance == null) {
                theInstance = new Controller();
                // TODO: If the binary file has data, populate the mAllBurritosList from the binary file
                if (Model.binaryFileHasData())
                    theInstance.mAllItemsList = Model.populateListFromBinaryFile();


                theInstance.mAllItemsList = FXCollections.observableArrayList();
            }
            return theInstance;
        }

        public ObservableList<Item> getAllItemsList()
        {
            return mAllItemsList;
        }

    public void saveData() {
        Model.writeDataToBinaryFile(mAllItemsList);
    }

}
