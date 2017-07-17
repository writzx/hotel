package gs_project.hotel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
    private static DateTimeFormatter timeFormatterDot = DateTimeFormatter.ofPattern("hh.mm.ss a");

    protected final JPanel statusPanel;

    protected final JLabel dateStatus;
    protected final JLabel timeStatus;

    protected Container mainConPanel;

    private JPanel conPane = new JPanel(new BorderLayout());


    public MainFrame(String title) {
        super(title);

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

    private static String formattedDate() {
        return LocalDate.now().format(dateFormatter);
    }

    private static String formattedTime(String current) {
        return LocalTime.now().format(current.contains(".") ? timeFormatter : timeFormatterDot);
    }

    @Override
    public void setContentPane(Container contentPane) {
        mainConPanel = contentPane;
        conPane.add(mainConPanel, BorderLayout.CENTER);
        super.setContentPane(conPane);
    }

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void hideFrame() {
        setVisible(false);
    }

    public void showFrame() {
        setVisible(true);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height + dateStatus.getPreferredSize().height);
    }

    public void center() {
        setLocationRelativeTo(null);
    }

    protected void addDateTimeToStatusBar() {
        statusPanel.add(Box.createHorizontalGlue());
        statusPanel.add(dateStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
        statusPanel.add(timeStatus);
        statusPanel.add(Box.createHorizontalStrut(4));
    }
}