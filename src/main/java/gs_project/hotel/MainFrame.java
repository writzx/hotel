package gs_project.hotel;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    // ContentPane // should not be changed
    private JPanel conPane = new JPanel(new BorderLayout());

    // Main Pane // should be changed before calling **setVisible**
    protected Container mainConPanel;

    protected final JPanel statusPanel;

    // used by all the subclasses
    protected final JLabel dateStatus;
    protected final JLabel timeStatus;


    public static void main(String... args) {
        new BookingFrame("WRITWICK", "ADMIN").showFrame();
    }

    public MainFrame(String title) {
        super(title);
        // should be set by only the root form
        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // default properties
        setResizable(true);
        super.setSize(800, 600);
        center();

        super.setContentPane(conPane);

        statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.LINE_AXIS));
        statusPanel.setBorder(new LineBorder(Color.GRAY));
        dateStatus = new JLabel(formattedDate());
        timeStatus = new JLabel(formattedTime("."));

        new Timer(500, e -> {
            dateStatus.setText(formattedDate());
            timeStatus.setText(formattedTime(timeStatus.getText()));
        }).start();

        conPane.add(statusPanel, BorderLayout.SOUTH);
    }

    @Override
    public void setContentPane(Container contentPane) {
        mainConPanel = contentPane;
        conPane.add(mainConPanel, BorderLayout.CENTER);
        super.setContentPane(conPane);
    }

    public void close() { dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); }

    public void hideFrame() { setVisible(false); }

    public void showFrame() {
        setVisible(true);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height + dateStatus.getPreferredSize().height);
    }

    // should be called after setSize()
    public void center() {
        setLocationRelativeTo(null);
    }

    private static String formattedDate() {
        return LocalDate.now().toString("dd/MM/yyyy");
    }

    private static String formattedTime(String current) {
        return LocalTime.now().toString(current.contains(".") ? "hh:mm:ss aa" : "hh.mm.ss aa" );
    }

    protected void addDateTimeToStatusBar() {
        statusPanel.add(Box.createHorizontalGlue());
        statusPanel.add(dateStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
        statusPanel.add(timeStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
    }
}