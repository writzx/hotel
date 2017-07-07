package gs_projects.hotel;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    // ContentPane // should not be changed
    private static JPanel conPane = new JPanel(new BorderLayout());

    // Main Pane // should be changed before calling **setVisible**
    private JPanel mainConPanel = new JPanel(null);

    /// region statusBar
    private static final JPanel statusPanel = new JPanel();

    private static final JLabel dateStatus = new JLabel(formattedDate());
    private static final JLabel timeStatus = new JLabel(formattedTime(":"));

    {
        setContentPane(conPane);

        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.LINE_AXIS));
        statusPanel.setBorder(new LineBorder(Color.GRAY));
        new Timer(500, e -> {
            dateStatus.setText(formattedDate());
            timeStatus.setText(formattedTime(timeStatus.getText()));
        }).start();

        statusPanel.add(Box.createHorizontalStrut(4));
        statusPanel.add(dateStatus);
        statusPanel.add(Box.createHorizontalGlue());
        statusPanel.add(timeStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
    }
    /// endregion

    public static void main(String... args) {
        new MainFrame().setVisible(true);
    }

    public MainFrame() {
        super("MainFrame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(1024, 768);
        center();

        conPane.add(mainConPanel, BorderLayout.CENTER);
        conPane.add(statusPanel, BorderLayout.SOUTH);
    }

    // should be called after setSize()
    public void center() {
        setLocationRelativeTo(null);
    }

    private static String formattedDate() {
        return LocalDate.now().toString("dd/MM/yyyy");
    }

    private static String formattedTime(String current) {
        return LocalTime.now().toString(current.contains(":") ? "hh mm ss aa" : "hh:mm:ss aa");
    }
}
