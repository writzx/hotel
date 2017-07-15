package gs_project.hotel.helpers;

import gs_project.hotel.FileHandler;
import gs_project.hotel.types.Booking;
import gs_project.hotel.types.Transaction;
import gs_project.hotel.types.Visitor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class BookingHelper {
    public final static String FILENAME = "bookings";

    public static void readFromFile() {
        System.out.print("Reading database file: \"" + FILENAME + "\" ...");
        try {
            bookings = FileHandler.readFile(FILENAME);
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        }

        if (bookings == null) { bookings = new ArrayList<>(); }
    }

    public static void writeToFile() {
        System.out.print("Writing database file: \"" + FILENAME + "\" ...");
        try {
            FileHandler.writeFile(FILENAME, bookings);
            System.out.println("DONE!");
        } catch (IOException e1) {
            System.out.println();
            e1.printStackTrace();
        }
    }

    public static ArrayList<Booking> bookings = new ArrayList<>();

}
