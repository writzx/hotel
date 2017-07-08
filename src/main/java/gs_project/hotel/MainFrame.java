package gs_project.hotel;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    // ContentPane // should not be changed
    private static JPanel conPane = new JPanel(new BorderLayout());

    // Main Pane // should be changed before calling **setVisible**
    protected final JPanel mainConPanel;

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
        setSize(800, 600);
        center();

        setContentPane(conPane);

        mainConPanel = new JPanel(null);

        statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.LINE_AXIS));
        statusPanel.setBorder(new LineBorder(Color.GRAY));
        dateStatus = new JLabel(formattedDate());
        timeStatus = new JLabel(formattedTime("."));

        new Timer(500, e -> {
            dateStatus.setText(formattedDate());
            timeStatus.setText(formattedTime(timeStatus.getText()));
        }).start();

        conPane.add(mainConPanel, BorderLayout.CENTER);
        conPane.add(statusPanel, BorderLayout.SOUTH);
    }

    public void close() { dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); }

    public void hideFrame() { setVisible(false); }

    public void showFrame() {
        setVisible(true);
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
}