package gs_project.hotel.helpers;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ComponentHelper {
    public static JTable createNewTable() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableModel readonlyModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(readonlyModel);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.setDefaultRenderer(String.class, cellRenderer);

        return table;
    }

    public static JTree setupTree(JTree tree, String rootName) {
        if (tree == null) tree = new JTree();
        tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(rootName)));
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
        return tree;
    }

    public static void expandTree(JTree tree) {
        ((DefaultTreeModel) tree.getModel()).reload();
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }

    public static void setEnabled(JComponent comp, boolean enabled) {
        for (Component c : comp.getComponents()) {
            c.setEnabled(enabled);
            try {
                setEnabled((JComponent) c, enabled);
            } catch (Exception ignored) {
            }
        }
    }

    public static void setEnabled(JComponent comp, boolean enabled, Component... excluded) {
        ArrayList<Component> excs = new ArrayList<>();
        Collections.addAll(excs, excluded);
        for (Component c : comp.getComponents()) {
            if (!excs.contains(c)) {
                c.setEnabled(enabled);
                try {
                    setEnabled((JComponent) c, enabled);
                } catch (Exception ignored) {
                }
            }
        }
    }

    public static void setEnabled(ArrayList<JButton> comp, boolean enabled, JButton... excluded) {
        ArrayList<JButton> excs = new ArrayList<>();
        Collections.addAll(excs, excluded);
        for (JButton c : comp) {
            if (!excs.contains(c)) {
                c.setEnabled(enabled);
                try {
                    setEnabled(c, enabled);
                } catch (Exception ignored) {
                }
            }
        }
    }
}
