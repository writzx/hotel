package gs_project.hotel;

import gs_project.hotel.types.Operator;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.*;

public class RoughOperatorInput extends JFrame{
    private JPanel contentPane;
    private JTextField t1;
    private JTextField t3;
    private JPasswordField p2;
    private JTextField t4;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;

    private ArrayList<Operator> operators = new ArrayList<>();

    public static void main(String... args) {
        RoughOperatorInput ri = new RoughOperatorInput();
        ri.setVisible(true);
    }

    public RoughOperatorInput() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 688, 660);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(366, 11, 296, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel l6 = new JLabel("ENTER OPERATOR UID:");
        l6.setBounds(30, 75, 136, 14);
        panel.add(l6);

        JButton b2 = new JButton("DELETE OPERATOR");
        b2.setBounds(87, 116, 153, 23);
        panel.add(b2);

        JLabel lblDeleteOperator = new JLabel("DELETE OPERATOR");
        lblDeleteOperator.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDeleteOperator.setBounds(48, 11, 238, 34);
        panel.add(lblDeleteOperator);

        p2 = new JPasswordField();
        p2.setBounds(97, 169, 112, 20);
        panel.add(p2);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 0, 346, 290);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton b1 = new JButton("SUBMIT");
        b1.setBounds(59, 256, 111, 23);
        panel_1.add(b1);

        JButton btnRemove = new JButton("DELETE");
        btnRemove.setBounds(180, 256, 111, 23);
        panel_1.add(btnRemove);

        JLabel l5 = new JLabel("ENTER E-MAIL ID:");
        l5.setBounds(10, 231, 135, 14);
        panel_1.add(l5);

        t3 = new JTextField();
        t3.setBounds(168, 101, 112, 20);
        panel_1.add(t3);
        t3.setColumns(10);

        JLabel l3 = new JLabel("ENTER PASSWORD:");
        l3.setBounds(10, 166, 112, 14);
        panel_1.add(l3);

        JLabel l2 = new JLabel("ENTER UNIQUE ID:");
        l2.setBounds(10, 104, 135, 14);
        panel_1.add(l2);

        t1 = new JTextField();
        t1.setBounds(167, 163, 111, 20);
        panel_1.add(t1);
        t1.setColumns(10);

        JLabel l1 = new JLabel("ENTER OPERATOR NAME:");
        l1.setBounds(8, 135, 150, 14);
        panel_1.add(l1);

        JLabel lblNewLabel = new JLabel("ADD/UPDATE OPERATOR");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(40, 26, 282, 34);
        panel_1.add(lblNewLabel);


        JCheckBox rdbtnNewRadioButton_1 = new JCheckBox("UPDATE/REMOVE OPERATOR");
        rdbtnNewRadioButton_1.setBounds(191, 67, 149, 23);
        panel_1.add(rdbtnNewRadioButton_1);

        t4 = new JTextField();
        t4.setBounds(168, 132, 124, 20);
        panel_1.add(t4);
        t4.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(168, 228, 112, 20);
        panel_1.add(textField_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 301, 652, 290);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JButton btnNewButton = new JButton("REFRESH TABLE");
        btnNewButton.setBounds(63, 99, 111, 23);
        panel_2.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(242, 48, 400, 233);
        panel_2.add(scrollPane);

        table = new JTable();
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(table);


        System.out.println("Reading database file...");
        try {
            operators = FileHandler.readFile("operators");
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (operators == null) { operators = new ArrayList<>(); }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            System.out.println("Writing database file...");
            try {
                FileHandler.writeFile("operators", operators);
                System.out.println("DONE!");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            }
        });
        b1.addActionListener(e -> {
            if (rdbtnNewRadioButton_1.isSelected()) {
                for (int i = 0; i < operators.size(); i++) {
                    Operator op = operators.get(i);
                    if (op.getUid().equals(t3.getText())) {
                        op.setName(t4.getText());
                        op.setEmail(textField_1.getText());
                        op.setPassword(t1.getText());
                        operators.set(i, op);

                        JOptionPane.showMessageDialog(this, "UPDATED");
                        updateTable();

                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "NOT FOUND");
            } else {
                Operator nOp = new Operator(t3.getText(), t4.getText(), t1.getText(), textField_1.getText());
                operators.add(nOp);
                t3.setText("");
                t4.setText("");
                t1.setText("");
                textField_1.setText("");

                JOptionPane.showMessageDialog(this, "ADDED");
                updateTable();
            }
        });
        t3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (rdbtnNewRadioButton_1.isSelected()) {
                    for (Operator op : operators) {
                        if (t3.getText().equals(op.getUid())) {
                            t4.setText(op.getName());
                            t1.setText(op.getPassword());
                            textField_1.setText(op.getEmail());
                        }
                    }
                }
            }
        });
        btnRemove.addActionListener(e -> {
            for (Operator op : operators) {
                if (t3.getText().equals(op.getUid())) {
                    operators.remove(op);

                    JOptionPane.showMessageDialog(this, "DELETED");
                    updateTable();
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "NOT FOUND");
        });
        updateTable();
    }

    void updateTable() {
        Object[][] data = toObjectsArray(operators);
        ((DefaultTableModel)table.getModel()).setDataVector(data, getColumns());
    }
    public static Object[] toObjects(Operator operator) {
        return new Object[] {operator.getUid(), operator.getPassword(), operator.getName(), operator.getEmail() };
    }

    static Object[] getColumns() {
        return new Object[] { "UID", "Password", "Name", "Email" };
    }

    public static Object[][] toObjectsArray(java.util.List<Operator> operators) {
        Object[][] objects = new Object[operators.size()][];
        int i = 0;
        for (Operator s:operators) {
            objects[i++] = toObjects(s);
        }
        return objects;
    }
}
