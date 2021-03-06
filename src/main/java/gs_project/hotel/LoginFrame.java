package gs_project.hotel;

import gs_project.hotel.helpers.OperatorHelper;
import gs_project.hotel.types.Operator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends MainFrame {
    public static LoginFrame frame;

    private JPanel contentPane;
    private JTextField uid;
    private JPasswordField pass;

    public LoginFrame() {
        super("Login");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(420, 264);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ButtonGroup group = new ButtonGroup();

        JRadioButton adminOption = new JRadioButton("ADMIN");
        adminOption.setForeground(Color.DARK_GRAY);
        adminOption.setFont(new Font("Dialog", Font.BOLD, 24));
        adminOption.setBounds(58, 50, 111, 32);
        contentPane.add(adminOption);
        group.add(adminOption);

        JRadioButton operatorOption = new JRadioButton("OPERATOR");
        operatorOption.setForeground(Color.DARK_GRAY);
        operatorOption.setFont(new Font("Dialog", Font.BOLD, 24));
        operatorOption.setBounds(171, 50, 159, 32);
        contentPane.add(operatorOption);
        group.add(operatorOption);

        JLabel heading = new JLabel("LOGIN AREA");
        heading.setForeground(Color.ORANGE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        heading.setBounds(10, 10, 395, 32);
        heading.setBorder(new LineBorder(Color.RED));
        contentPane.add(heading);

        JLabel uidLabel = new JLabel("USER ID:");
        uidLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        uidLabel.setBounds(32, 87, 111, 32);
        contentPane.add(uidLabel);

        JLabel passwordLabel = new JLabel("PASWORD:");
        passwordLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        passwordLabel.setBounds(32, 131, 111, 32);
        contentPane.add(passwordLabel);

        uid = new JTextField();
        uid.setBounds(171, 89, 234, 32);
        contentPane.add(uid);
        uid.setColumns(10);

        pass = new JPasswordField();
        pass.setBounds(171, 133, 234, 32);
        contentPane.add(pass);

        JButton login = new JButton("LOGIN");
        login.setFont(new Font("Tahoma", Font.BOLD, 20));
        login.addActionListener(e -> {
            String passw = String.valueOf(pass.getPassword());
            if (adminOption.isSelected()) {
                if (uid.getText().equalsIgnoreCase("ADMIN") && passw.equalsIgnoreCase("ADMIN")) {
                    this.hideFrame();
                    AdminFrame adminFrame = new AdminFrame();
                    adminFrame.showFrame();
                } else {
                    JOptionPane.showMessageDialog(this, "WRONG UID OR PASSWORD!", "LOGIN ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else if (operatorOption.isSelected()) {
                if (uid.getText().isEmpty() || passw.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "PLEASE ENTER BOTH UID AND PASSWORD", "ENTER DETAILS", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (Operator o : OperatorHelper.operators) {
                        if (uid.getText().equals(o.getUid()) && passw.equals(o.getPassword())) {
                            this.hideFrame();
                            OperatorFrame operatorFrame = new OperatorFrame(uid.getText());
                            operatorFrame.showFrame();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "WRONG UID OR PASSWORD!", "LOGIN ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "PLEASE SELECT ONE OPTION: ADMIN OR OPERATOR", "CHOOSE OPTION!", JOptionPane.ERROR_MESSAGE);
            }
        });
        login.setBounds(129, 174, 147, 48);
        contentPane.add(login);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                uid.requestFocus();
            }
        });

        addDateTimeToStatusBar();

        center();

        OperatorHelper.readFromFile();
    }

    public static void main(String... args) {
        frame = new LoginFrame();
        frame.setVisible(true);
    }
}
