package gs_project.hotel.helpers;

import gs_project.hotel.FileHandler;
import gs_project.hotel.types.Booking;
import gs_project.hotel.types.Room;
import gs_project.hotel.types.RoomClass;
import gs_project.hotel.types.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;
import java.awt.print.Book;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class RoomHelper {
    public final static String FILENAME = "roomclasses";

    public static void readFromFile() {
        System.out.print("Reading database file: \"" + FILENAME + "\" ...");
        try {
            roomClasses = FileHandler.readFile(FILENAME);
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        }

        if (roomClasses == null) { roomClasses = new ArrayList<>(); }
    }

    public static void writeToFile() {
        System.out.print("Writing database file: \"" + FILENAME + "\" ...");
        try {
            FileHandler.writeFile(FILENAME, RoomHelper.roomClasses);
            System.out.println("DONE!");
        } catch (IOException e1) {
            System.out.println();
            e1.printStackTrace();
        }
    }

    public static ArrayList<RoomClass> roomClasses = new ArrayList<>();

    public static void loadClassesInTree(JTree tree) {
        for (RoomClass rc: roomClasses) {
            buildTreeFromType((DefaultTreeModel) tree.getModel(), rc.getType());
        }
        ComponentHelper.expandTree(tree);
    }

    public static void loadClassesInTree(JTree tree, ArrayList<RoomClass> classes) {
        for (RoomClass rc: classes) {
            buildTreeFromType((DefaultTreeModel) tree.getModel(), rc.getType());
        }
        ComponentHelper.expandTree(tree);
    }

    public static int getClassIndex(TreePath path) {
        for (int i = 0; i < roomClasses.size(); i++) {
            if (roomClasses.get(i).getType().equalsIgnoreCase(pathToType(path))) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Room> buildRoomList(int start, int end) {
        for (RoomClass rc: roomClasses) {
            for (Room r: rc.getRooms()) {
                if (r.getRoomNo() >= start && r.getRoomNo() <= end) {
                    return null;
                }
            }
        }
        ArrayList<Room> rooml = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            rooml.add(new Room(i));
        }
        return rooml;
    }

    public static List<Integer> getClassIndices (TreePath path) {
        String type = pathToType(path);
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < roomClasses.size(); i++) {
            String ntype = roomClasses.get(i).getType();
            if (ntype.startsWith(type) && ntype.charAt(type.length()) == ':') {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void buildTreeFromType(final DefaultTreeModel model, final String str) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        String [] strings = str.split(":");
        DefaultMutableTreeNode node = root;

        for (String s: strings) {
            int index = childIndex(node, s);
            if (index < 0) {
                DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(s);
                node.insert(newChild, node.getChildCount());
                node = newChild;
            } else {
                node = (DefaultMutableTreeNode) node.getChildAt(index);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static int childIndex(final DefaultMutableTreeNode node, final String childValue) {
        Enumeration<DefaultMutableTreeNode> children = node.children();
        DefaultMutableTreeNode child = null;
        int index = -1;

        while (children.hasMoreElements() && index < 0) {
            child = children.nextElement();

            if (child.getUserObject() != null && childValue.equals(child.getUserObject())) {
                index = node.getIndex(child);
            }
        }

        return index;
    }

    public static String pathToType(TreePath path) {
        Object[] pathParts = path.getPath();
        List<String> str = new ArrayList<>();
        for (int i = 1; i < pathParts.length; i++) {
            Object o = pathParts[i];
            str.add(o.toString());
        }
        return String.join(":", str.toArray(new String[str.size()]));
    }

    public static void loadTransactions(JTable table, LocalDate dateStart, LocalDate dateEnd) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for (RoomClass rc:roomClasses) {
            for (Room r: rc.getRooms()) {
                for (Booking b : r.getBookings()) {
                    for (Transaction t: b.getTransactions()) {
                        LocalDate date =LocalDate.parse(t.getDate());
                        if ((date.isAfter(dateStart) || date.isEqual(dateStart)) && (date.isBefore(dateEnd) || date.isEqual(dateEnd))) {
                            transactions.add(t);
                        }
                    }
                }
            }
        }
        transactions.sort(Comparator.comparing(transaction -> LocalDate.parse(transaction.getDate())));
        ((DefaultTableModel) table.getModel()).setDataVector(Transaction.toObjectsArray(transactions), Transaction.getColumns());
    }

    public static void loadCurrentBookings(JTable table, LocalDate dateStart, LocalDate dateEnd) {
        ((DefaultTableModel) table.getModel()).setDataVector(RoomClass.toBookingObjectsArray(RoomHelper.roomClasses), RoomClass.getBookingColumns());
        //((DefaultTableModel) table.getModel()).setDataVector(Booking.toObjectsArray(bookings), Booking.getColumns());
    }
}
