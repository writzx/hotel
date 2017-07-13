package gs_project.hotel;

import javax.swing.*;
import java.awt.*;

public class TypePopUp extends JPopupMenu {
    private JMenuItem firstItem;
    private JMenuItem secondItem;

    public TypePopUp(String nodeText, String leafText) {
        firstItem = new JMenuItem(nodeText);
        secondItem = new JMenuItem(leafText);
        add(firstItem);
        add(secondItem);
    }

    public static TypePopUp show(Component c, String nodeText, String leafText) {
        TypePopUp popUp = new TypePopUp(nodeText, leafText);
        popUp.show(c, c.getX() + (c.getWidth() / 2), c.getY() + (c.getHeight() / 2));
        return popUp;
    }

    public JMenuItem getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(JMenuItem firstItem) {
        this.firstItem = firstItem;
    }

    public JMenuItem getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(JMenuItem secondItem) {
        this.secondItem = secondItem;
    }
}
