package gs_project.hotel;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
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
        return LocalDate.now().toString("dd/MM/yyyy");
    }

    private static String formattedTime(String current) {
        return LocalTime.now().toString(current.contains(".") ? "hh:mm:ss aa" : "hh.mm.ss aa");
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