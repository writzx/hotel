package gs_project.hotel;

import gs_project.hotel.types.RoomClass;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class RoomHelper {
    public static void readFromFile() {
        System.out.println("Reading database file...");
        try {
            roomClasses = FileHandler.readFile("roomclasses");
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (roomClasses == null) { roomClasses = new ArrayList<>(); }
    }

    public static void writeToFile() {
        System.out.println("Writing database file...");
        try {
            FileHandler.writeFile("roomclasses", RoomHelper.roomClasses);
            System.out.println("DONE!");
        } catch (IOException e1) {
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

    public static int getClassIndex(TreePath path) {
        for (int i = 0; i < roomClasses.size(); i++) {
            if (roomClasses.get(i).getType().equalsIgnoreCase(pathToType(path))) {
                return i;
            }
        }
        return -1;
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
}
