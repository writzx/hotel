package gs_project.hotel;

import gs_project.hotel.types.Room;
import gs_project.hotel.types.RoomClass;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

public class RoomEditor extends JFrame {
    private JPanel contentPane;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private ArrayList<RoomClass> roomClasses = new ArrayList<>();

    private boolean delete = false;

    public static void loadClassesInTree(JTree tree, List<RoomClass> classes) {
        for (RoomClass rc: classes) {
            buildTreeFromType((DefaultTreeModel) tree.getModel(), rc.getType());
        }
        expandTree(tree);
    }

    public RoomEditor() {
        super("Room Editor");

        setSize(640, 336);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        JTree tree = new JTree();

        JButton addBtn = new JButton("ADD");
        JButton editBtn = new JButton("EDIT");
        JButton removeBtn = new JButton("REMOVE");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createRigidArea(new Dimension(8, addBtn.getPreferredSize().height + 16)));
        buttonPanel.add(addBtn);
        buttonPanel.add(Box.createHorizontalStrut(8));
        buttonPanel.add(editBtn);
        buttonPanel.add(Box.createHorizontalStrut(8));
        buttonPanel.add(removeBtn);
        buttonPanel.add(Box.createHorizontalStrut(8));

        leftPanel.add(new JScrollPane(tree), BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);
        leftPanel.setBorder(new LineBorder(Color.GRAY));

        rightPanel = new JPanel();
        rightPanel.setLayout(null);

        JLabel rangeLabel = new JLabel("ROOM NUMBER RANGE: ");
        rangeLabel.setBounds(32, 32, 160, 24);
        JSpinner startSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        startSpinner.setBounds(200, 32, 76, 24);
        JSpinner endSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        endSpinner.setBounds(284, 32, 76, 24);

        JLabel priceLabel = new JLabel("BASE PRICE: ");
        priceLabel.setBounds(32, 88, 160, 24);
        JSpinner priceSpinner = new JSpinner(new SpinnerNumberModel(1000, 1000, null, 100));
        priceSpinner.setBounds(200, 88, 160, 24);

        JLabel adultLabel = new JLabel("MAX. ADULT: ");
        adultLabel.setBounds(32, 144, 160, 24);
        JSpinner adultSpinner = new JSpinner(new SpinnerNumberModel());
        adultSpinner.setBounds(200, 144, 160, 24);

        JLabel childLabel = new JLabel("MAX. CHILDREN: ");
        childLabel.setBounds(32, 200, 160, 24);
        JSpinner childSpinner = new JSpinner(new SpinnerNumberModel());
        childSpinner.setBounds(200, 200, 160, 24);

        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(240, 264, 120, 24);

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(32, 264, 120, 24);

        rightPanel.setPreferredSize(new Dimension(264, 336));

        rightPanel.add(rangeLabel);
        rightPanel.add(priceLabel);
        rightPanel.add(adultLabel);
        rightPanel.add(childLabel);

        rightPanel.add(startSpinner);
        rightPanel.add(endSpinner);
        rightPanel.add(priceSpinner);
        rightPanel.add(adultSpinner);
        rightPanel.add(childSpinner);

        rightPanel.add(saveButton);
        rightPanel.add(cancelButton);

        setEnabled(rightPanel, false);

        contentPane.add(leftPanel, BorderLayout.WEST);
        contentPane.add(rightPanel, BorderLayout.CENTER);

        tree.setModel(new DefaultTreeModel( new DefaultMutableTreeNode("ROOM")));
        tree.setEditable(false);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeWillExpandListener(new TreeWillExpandListener() {
            @Override
            public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {

            }

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                throw new ExpandVetoException(event);
            }
        });

        System.out.println("Reading database file...");
        try {
            roomClasses = FileHandler.readFile("roomclasses");
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (roomClasses == null) { roomClasses = new ArrayList<>(); }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Writing database file...");
                try {
                    FileHandler.writeFile("roomclasses", roomClasses);
                    System.out.println("DONE!");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        loadClassesInTree(tree, roomClasses);

        addBtn.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
            if (node == null) {
                return;
            }
            int i = getClassIndex(new TreePath(node.getPath()));
            if (i > -1) {
                roomClasses.remove(i);
            }
            String new_t = JOptionPane.showInputDialog(RoomEditor.this, "Enter new Room Type:", "Add Room", JOptionPane.QUESTION_MESSAGE);
            if (new_t == null || new_t.isEmpty()) return;

            delete = true;

            DefaultMutableTreeNode new_node = new DefaultMutableTreeNode(new_t);
            node.add(new_node);

            expandTree(tree);

            tree.setSelectionPath(new TreePath(new_node.getPath()));

            setEnabled(rightPanel, true);
            setEnabled(leftPanel, false);
        });

        saveButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
            int index = getClassIndex(new TreePath(node.getPath()));
            ArrayList<Room> rooml = new ArrayList<>();
            for (int i = (int) startSpinner.getValue(); i <= (int) endSpinner.getValue(); i++) {
                rooml.add(new Room(i));
            }
            if (index > -1) {
                // updating
                roomClasses.get(index).setPrice((Integer) priceSpinner.getValue());
                roomClasses.get(index).setAdults((Integer) adultSpinner.getValue());
                roomClasses.get(index).setChildren((Integer) childSpinner.getValue());
            } else {
                // adding
                RoomClass rc = new RoomClass(pathToType(new TreePath(node.getPath())), (int)priceSpinner.getValue(), (int)adultSpinner.getValue(), (int) childSpinner.getValue(), rooml);
                roomClasses.add(rc);
            }
            roomClasses.sort(Comparator.comparing(RoomClass::getPrice));

            setEnabled(rightPanel, false);
            setEnabled(leftPanel, true);
        });

        editBtn.addActionListener(e -> {
            delete = false;
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
            if (node != null && node.isLeaf()) {
                setEnabled(rightPanel, true);
                setEnabled(leftPanel, false);
            }
        });

        cancelButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
            if (node != null && node.isLeaf()) {
                if (delete) {
                    node.removeFromParent();
                }

                expandTree(tree);
                setEnabled(rightPanel, false);
                setEnabled(leftPanel, true);
            }
        });

        tree.addTreeSelectionListener(e -> {
            try {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                int ind = getClassIndex(new TreePath(node.getPath()));
                if (ind > -1) {
                    RoomClass selclass = roomClasses.get(ind);
                    startSpinner.setValue(selclass.getRooms().get(0).getRoomNo());
                    endSpinner.setValue(selclass.getRooms().get(selclass.getRooms().size() - 1).getRoomNo());
                    adultSpinner.setValue(selclass.getAdults());
                    childSpinner.setValue(selclass.getChildren());
                    priceSpinner.setValue(selclass.getPrice());
                }
            } catch (Exception ignored) { }
        });

        removeBtn.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
            if (node == null) return;
            TreePath tp = new TreePath(node.getPath());
            node.removeFromParent();
            if (node.isLeaf()) {
                roomClasses.remove(getClassIndex(tp));
            } else {
                for (int i: getClassIndices(tp)) {
                    roomClasses.remove(i);
                }
            }
            expandTree(tree);

            loadClassesInTree(tree, roomClasses);
        });
    }

    public static void expandTree(JTree tree) {
        ((DefaultTreeModel) tree.getModel()).reload();
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }

    public int getClassIndex(TreePath path) {
        for (int i = 0; i < roomClasses.size(); i++) {
            if (roomClasses.get(i).getType().equalsIgnoreCase(pathToType(path))) {
                return i;
            }
        }
        return -1;
    }

    public List<Integer> getClassIndices (TreePath path) {
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

    private static void buildTreeFromType(final DefaultTreeModel model, final String str) {
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
    private static int childIndex(final DefaultMutableTreeNode node, final String childValue) {
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

    private static void setEnabled(JComponent comp, boolean enabled) {
        for (Component c : comp.getComponents()) {
            c.setEnabled(enabled);
            try {
                setEnabled((JComponent) c, enabled);
            } catch (Exception ignored) { }
        }
    }

//    public static void main(String[] args) {
//        RoomEditor frame = new RoomEditor();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }

    private static String pathToType(TreePath path) {
        Object[] pathParts = path.getPath();
        List<String> str = new ArrayList<>();
        for (int i = 1; i < pathParts.length; i++) {
            Object o = pathParts[i];
            str.add(o.toString());
        }
        return String.join(":", str.toArray(new String[str.size()]));
    }
}
