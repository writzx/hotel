package gs_project.hotel.helpers;

import gs_project.hotel.FileHandler;
import gs_project.hotel.types.Operator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

import static gs_project.hotel.types.Operator.toObjectsArray;

public class OperatorHelper {
    public final static String FILENAME = "operators";
    public static ArrayList<Operator> operators = new ArrayList<>();

    public static void readFromFile() {
        System.out.print("Reading database file: \"" + FILENAME + "\" ...");
        try {
            operators = FileHandler.readFile(FILENAME);
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        }

        if (operators == null) {
            operators = new ArrayList<>();
        }
    }

    public static void writeToFile() {
        System.out.print("Writing database file: \"" + FILENAME + "\" ...");
        try {
            FileHandler.writeFile(FILENAME, operators);
            System.out.println("DONE!");
        } catch (IOException e1) {
            System.out.println();
            e1.printStackTrace();
        }
    }

    public static void updateTable(JTable table) {
        ((DefaultTableModel) table.getModel()).setDataVector(toObjectsArray(operators), Operator.getColumns());
    }
}
