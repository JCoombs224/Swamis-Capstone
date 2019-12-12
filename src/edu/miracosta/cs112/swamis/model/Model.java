package edu.miracosta.cs112.swamis.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class Model {
    // contain parent class and two concrete children

    public static final String BINARY_FILE = "ShoppingCart.dat";

    /**
     * Determines whether the binary file exists and has data (size/length > 0).
     * @return True if the binary file exists and has data, false otherwise.
     */
    public static boolean binaryFileHasData()
    {
        // TODO: Create a File reference to the binary file
        File binaryFile = new File(BINARY_FILE);
        // TODO: Return whether the binary file exists and has data
        return (binaryFile.exists() && binaryFile.length() > 0); //  .length tells file size. If > 0, file has some data
    }

    /**
     * Populates the list of all OceanBoards from the binary file. This will be called everytime the application loads,
     * other than the very first time, since it needs initial data from CSV.
     * @return The list of all OceanBoards populated from the binary file
     */
    public static ObservableList<Item> populateListFromBinaryFile()
    {
        ObservableList<Item> allItems = FXCollections.observableArrayList();
        // Create a File reference to the binary file
        File binaryFile = new File(BINARY_FILE);
        // Check to see if the binary file exists
        if (binaryFileHasData()) {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                // Read into temp array
                OceanBoards[] tempArray = (OceanBoards[]) fileReader.readObject();
                allItems.addAll(tempArray);
                fileReader.close();
            }
            catch (Exception e)
            {
                System.err.println("Error reading from binary file");
            }

        }

        return allItems;
    }

    /**
     * Saves the list of all OceanBoards to the binary file. This will be called each time the application stops,
     * which occurs when the user exits/closes the app.  Note this method is called in the View, by the controller,
     * during the stop() method.
     * @return True if the data were saved to the binary file successfully, false otherwise.
     */
    public static boolean writeDataToBinaryFile(ObservableList<Item> allItemsList)
    {
        // Create a File reference to the binary file
        File binaryFile = new File(BINARY_FILE);
        // Instantiate an ObjectOutputStream reference to the binary file for writing
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));

            Item[] tempArray = new Item[allItemsList.size()]; // make array same size as list!
            for (int i = 0; i < tempArray.length; i++)
                tempArray[i] = allItemsList.get(i);

            fileWriter.writeObject(tempArray);

            fileWriter.close();
            return true;
        } catch (Exception e)
        {
            return false;
        }
        // Create a temp array of OceanBoard objects to read from the binary file (length should match list size)
        // Loop through the temp array and initialize each element to the corresponding element in the list
        // Write the temp array object to the binary file writer
        // Close the binary file writer and return true.
        // If an exception occurs, print its message and return false.
    }


}
