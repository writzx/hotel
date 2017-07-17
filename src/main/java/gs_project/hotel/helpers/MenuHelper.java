package gs_project.hotel.helpers;

import gs_project.hotel.FileHandler;
import gs_project.hotel.types.Dish;
import gs_project.hotel.types.MenuPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MenuHelper {
    public final static String FILENAME = "menupackages";
    public static ArrayList<MenuPackage> menuPackages = new ArrayList<>();

    public static void readFromFile() {
        System.out.print("Reading database file: \"" + FILENAME + "\" ...");
        try {
            menuPackages = FileHandler.readFile(FILENAME);
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        }

        if (menuPackages == null) {
            menuPackages = new ArrayList<>();
        }
    }

    public static ArrayList<Dish> tableToDishList(JTable table) {
        ArrayList<Dish> dishes = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < table.getRowCount(); i++) {
            String name = model.getValueAt(i, 0).toString();
            int minQua = Integer.valueOf(model.getValueAt(i, 1).toString());
            int maxQua = Integer.valueOf(model.getValueAt(i, 2).toString());
            int price = Integer.valueOf(model.getValueAt(i, 3).toString());
            if (name.isEmpty() || minQua <= 0 || maxQua <= 0 || minQua > maxQua || price <= 0) {
                return null;
            }
            dishes.add(new Dish(name, minQua, maxQua, price));
        }
        return dishes;
    }

    public static Dish takeDishInput(Component root) {
        String name = "";
        while (name == null || name.isEmpty()) {
            name = JOptionPane.showInputDialog(root, "Enter Dish name:", "NAME", JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.isEmpty()) {
                int yn = JOptionPane.showConfirmDialog(root, "Name cannot be empty. Do you want to re-enter and continue?", "Invalid Name", JOptionPane.YES_NO_OPTION);
                if (yn != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
        }
        String minQua = "";
        int min = 0;
        while (minQua == null || minQua.isEmpty()) {
            minQua = JOptionPane.showInputDialog(root, "Enter minimum quantity:", "MIN. QUANTITY", JOptionPane.QUESTION_MESSAGE);
            if (minQua == null || minQua.isEmpty()) {
                int yn = JOptionPane.showConfirmDialog(root, "Minimum quantity cannot be empty. Do you want to re-enter and continue?", "Invalid Quantity", JOptionPane.YES_NO_OPTION);
                if (yn != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
            try {
                min = Integer.valueOf(minQua);
                if (min < 0) {
                    minQua = "";
                    JOptionPane.showMessageDialog(root, "Minimum quantity cannot be less than zero. Re-enter!", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                minQua = "";
                JOptionPane.showMessageDialog(root, "Minimum quantity can only be a integer. Re-enter!", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
            }
        }
        String maxQua = "";
        int max = 0;
        while (maxQua == null || maxQua.isEmpty()) {
            maxQua = JOptionPane.showInputDialog(root, "Enter maximum quantity:", "MAX. QUANTITY", JOptionPane.QUESTION_MESSAGE);
            if (maxQua == null || maxQua.isEmpty()) {
                int yn = JOptionPane.showConfirmDialog(root, "Maximum quantity cannot be empty. Do you want to re-enter and continue?", "Invalid Quantity", JOptionPane.YES_NO_OPTION);
                if (yn != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
            try {
                max = Integer.valueOf(maxQua);
                if (max < min) {
                    maxQua = "";
                    JOptionPane.showMessageDialog(root, "Minimum quantity cannot be less than minimum quantity. Re-enter!", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                maxQua = "";
                JOptionPane.showMessageDialog(root, "Maximum quantity can only be a integer. Re-enter!", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
            }
        }
        String priceStr = "";
        int price = 0;
        while (priceStr == null || priceStr.isEmpty()) {
            priceStr = JOptionPane.showInputDialog(root, "Enter price:", "PRICE", JOptionPane.QUESTION_MESSAGE);
            if (priceStr == null || priceStr.isEmpty()) {
                int yn = JOptionPane.showConfirmDialog(root, "Price quantity cannot be empty. Do you want to re-enter and continue?", "Invalid Price", JOptionPane.YES_NO_OPTION);
                if (yn != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
            try {
                price = Integer.valueOf(priceStr);
                if (price <= 0) {
                    priceStr = "";
                    JOptionPane.showMessageDialog(root, "Price cannot be less than or equal to zero. Re-enter!", "Invalid Price", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                priceStr = "";
                JOptionPane.showMessageDialog(root, "Price can only be a integer. Re-enter!", "Invalid Price", JOptionPane.ERROR_MESSAGE);
            }
        }
        return new Dish(name, min, max, price);
    }

    public static void writeToFile() {
        System.out.print("Writing database file: \"" + FILENAME + "\" ...");
        try {
            FileHandler.writeFile(FILENAME, menuPackages);
            System.out.println("DONE!");
        } catch (IOException e1) {
            System.out.println();
            e1.printStackTrace();
        }
    }

    public static void loadDishesInTree(JTree tree) {
        loadClassesInTree(tree);
        loadDishesInNode((DefaultMutableTreeNode) tree.getModel().getRoot());
        ComponentHelper.expandTree(tree);
    }

    public static ArrayList<DefaultMutableTreeNode> getAllLeafNodes(DefaultMutableTreeNode node) {
        ArrayList<DefaultMutableTreeNode> lNodes = new ArrayList<>();
        if (node.isLeaf()) {
            lNodes.add(node);
        } else {
            int n = node.getChildCount();
            for (int i = 0; i < n; i++) {
                lNodes.addAll(getAllLeafNodes((DefaultMutableTreeNode) node.getChildAt(i)));
            }
        }
        return lNodes;
    }

    public static void loadDishesInNode(DefaultMutableTreeNode node) {
        int count = node.getChildCount();
        for (int i = 0; i < count; i++) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
            if (childNode.getChildCount() > 0) {
                loadDishesInNode(childNode);
            } else {
                int ind = getClassIndex(new TreePath(childNode.getPath()));
                if (ind != -1) {
                    MenuPackage mpack = MenuHelper.menuPackages.get(ind);

                    if (mpack.getStarters().size() > 0) {
                        DefaultMutableTreeNode starters = new DefaultMutableTreeNode("STARTERS");
                        for (Dish d : mpack.getStarters()) {
                            starters.add(new DefaultMutableTreeNode(d.getName() + "\t[₹ " + d.getPrice() + "]"));
                        }
                        childNode.add(starters);
                    }
                    if (mpack.getMaincourse().size() > 0) {
                        DefaultMutableTreeNode maincourse = new DefaultMutableTreeNode("MAIN-COURSE");
                        for (Dish d : mpack.getMaincourse()) {
                            maincourse.add(new DefaultMutableTreeNode(d.getName() + "\t[₹ " + d.getPrice() + "]"));
                        }
                        childNode.add(maincourse);
                    }
                    if (mpack.getDesserts().size() > 0) {
                        DefaultMutableTreeNode desserts = new DefaultMutableTreeNode("DESSERTS");
                        for (Dish d : mpack.getDesserts()) {
                            desserts.add(new DefaultMutableTreeNode(d.getName() + "\t[₹ " + d.getPrice() + "]"));
                        }
                        childNode.add(desserts);
                    }
                }
            }
        }
    }

    public static void loadClassesInTree(JTree tree) {
        for (MenuPackage rc : menuPackages) {
            buildTreeFromType((DefaultTreeModel) tree.getModel(), rc.getType());
        }
        ComponentHelper.expandTree(tree);
    }

    public static int getClassIndex(TreePath path) {
        for (int i = 0; i < menuPackages.size(); i++) {
            if (menuPackages.get(i).getType().equalsIgnoreCase(pathToType(path))) {
                return i;
            }
        }
        return -1;
    }


    public static List<Integer> getClassIndices(TreePath path) {
        String type = pathToType(path);
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < menuPackages.size(); i++) {
            String ntype = menuPackages.get(i).getType();
            if (ntype.startsWith(type) && ntype.charAt(type.length()) == ':') {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void buildTreeFromType(final DefaultTreeModel model, final String str) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        String[] strings = str.split(":");
        DefaultMutableTreeNode node = root;

        for (String s : strings) {
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
