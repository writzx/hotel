package gs_project.hotel.helpers;

import gs_project.hotel.FileHandler;
import gs_project.hotel.types.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class TransactionHelper {
    public final static String FILENAME = "transactions";

    public static void readFromFile() {
        System.out.print("Reading database file: \"" + FILENAME + "\" ...");
        try {
            transactions = FileHandler.readFile(FILENAME);
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        }

        if (transactions == null) { transactions = new ArrayList<>(); }
    }

    public static void writeToFile() {
        System.out.print("Writing database file: \"" + FILENAME + "\" ...");
        try {
            FileHandler.writeFile(FILENAME, transactions);
            System.out.println("DONE!");
        } catch (IOException e1) {
            System.out.println();
            e1.printStackTrace();
        }
    }

    public static ArrayList<Transaction> transactions = new ArrayList<>();
}
