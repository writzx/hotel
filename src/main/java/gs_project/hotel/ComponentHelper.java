package gs_project.hotel;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ComponentHelper {
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
            } catch (Exception ignored) { }
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
}
