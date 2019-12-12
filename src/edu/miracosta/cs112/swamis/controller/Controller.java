package edu.miracosta.cs112.swamis.controller;

import edu.miracosta.cs112.swamis.model.Item;
import edu.miracosta.cs112.swamis.model.Model;
import edu.miracosta.cs112.swamis.model.OceanBoards;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

        private static Controller theInstance;
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

                if (Model.binaryFileHasData())
                    theInstance.mAllItemsList = Model.populateListFromBinaryFile();
                else
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
