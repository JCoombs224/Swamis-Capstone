package edu.miracosta.cs112.swamis.controller;

import edu.miracosta.cs112.swamis.model.Model;
import edu.miracosta.cs112.swamis.model.OceanBoards;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

        private static edu.miracosta.cs112.swamis.controller.Controller theInstance;
        private ObservableList<OceanBoards> mAllOceanBoardsList;
        private ObservableList<OceanBoards> mFilteredList;

        private Controller() {}

        /**
         * Gets the one instance of the Controller.
         * @return The instance
         */
        public static edu.miracosta.cs112.swamis.controller.Controller getInstance() {
            if (theInstance == null) {
                theInstance = new edu.miracosta.cs112.swamis.controller.Controller();
                // TODO: If the binary file has data, populate the mAllBurritosList from the binary file
                if (Model.binaryFileHasData())
                    theInstance.mAllOceanBoardsList = Model.populateListFromBinaryFile();


                theInstance.mAllOceanBoardsList = FXCollections.observableArrayList();
            }
            return theInstance;
        }

        public ObservableList<OceanBoards> getAllBoards()
        {
            return mAllOceanBoardsList;
        }

    public void saveData() {
        Model.writeDataToBinaryFile(mAllOceanBoardsList);
    }

}
