package gs_project.hotel;

import gs_project.hotel.helpers.ComponentHelper;
import gs_project.hotel.helpers.IDGenerator;
import gs_project.hotel.helpers.PrintUIWindow;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Bill extends JFrame {

    private JPanel contentPane;
    private JTable transactionTable;
    private JTextField roomTotal;
    private JTextField serviceTotal;
    private JTextField gstTotal;
    private JTextField initAmount;
    private JTextField balanceAmount;

    public Bill(String visitrName, String cardNo, String checkIn, String checkOut, double packTotalPrice, double servTotal, double initalAmount) {
        super("INVOICE");
        setResizable(false);
        setBounds(100, 100, 466, 787);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        double total = packTotalPrice + servTotal;
        double gsttot = total * 1.28;
        double balance = gsttot - initalAmount;

        JPanel printPanel = new JPanel();
        printPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        printPanel.setBackground(Color.WHITE);
        printPanel.setBounds(10, 52, 440, 696);
        contentPane.add(printPanel);
        printPanel.setLayout(null);

        JLabel headerLabel = new JLabel("INVOICE");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBounds(10, 11, 420, 41);
        printPanel.add(headerLabel);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel invoiceNumLabel = new JLabel("INVOICE NO:");
        invoiceNumLabel.setBounds(10, 72, 116, 14);
        printPanel.add(invoiceNumLabel);

        JLabel invoiceNo = new JLabel(IDGenerator.generate().substring(8));
        invoiceNo.setBounds(136, 72, 76, 14);
        printPanel.add(invoiceNo);

        JLabel checkOutDate = new JLabel(checkOut);
        checkOutDate.setBounds(136, 145, 76, 14);
        printPanel.add(checkOutDate);

        JLabel checkInLabel = new JLabel("CHECK-IN DATE:");
        checkInLabel.setBounds(10, 109, 116, 14);
        printPanel.add(checkInLabel);

        JLabel checkInDate = new JLabel(checkIn);
        checkInDate.setBounds(138, 109, 76, 14);
        printPanel.add(checkInDate);

        JLabel checkOutLabel = new JLabel("CHECK-OUT  DATE:");
        checkOutLabel.setBounds(10, 145, 116, 14);
        printPanel.add(checkOutLabel);

        JPanel cardNumPanel = new JPanel();
        cardNumPanel.setBackground(Color.WHITE);
        cardNumPanel.setBounds(222, 119, 208, 40);
        printPanel.add(cardNumPanel);
        cardNumPanel.setLayout(null);

        JLabel cardNumLabel = new JLabel("CARD NUMBER");
        cardNumLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cardNumLabel.setBounds(0, 0, 208, 14);
        cardNumPanel.add(cardNumLabel);
        cardNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardNumLabel.setBorder(new LineBorder(Color.GRAY));

        JLabel cardNum = new JLabel(cardNo);
        cardNum.setBounds(0, 13, 208, 27);
        cardNumPanel.add(cardNum);
        cardNum.setHorizontalAlignment(SwingConstants.CENTER);
        cardNum.setFont(new Font("Tahoma", Font.BOLD, 14));
        cardNum.setBorder(new LineBorder(Color.GRAY));

        JPanel visitorNamePanel = new JPanel();
        visitorNamePanel.setLayout(null);
        visitorNamePanel.setBackground(Color.WHITE);
        visitorNamePanel.setBounds(222, 72, 208, 40);
        printPanel.add(visitorNamePanel);

        JLabel visitorNameLabel = new JLabel("VISITOR NAME");
        visitorNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        visitorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        visitorNameLabel.setBorder(new LineBorder(Color.GRAY));
        visitorNameLabel.setBounds(0, 0, 208, 14);
        visitorNamePanel.add(visitorNameLabel);

        JLabel visitorName = new JLabel(visitrName);
        visitorName.setHorizontalAlignment(SwingConstants.CENTER);
        visitorName.setFont(new Font("Tahoma", Font.BOLD, 14));
        visitorName.setBorder(new LineBorder(Color.GRAY));
        visitorName.setBounds(0, 13, 208, 27);
        visitorNamePanel.add(visitorName);

        printPanel.add(checkOutLabel);

        transactionTable = ComponentHelper.createNewTable();
        transactionTable.setFillsViewportHeight(true);

        JScrollPane p = new JScrollPane(transactionTable);
        p.setViewportView(transactionTable);
        p.setBounds(10, 170, 420, 310);
        printPanel.add(p);

        JLabel initAmountLabel = new JLabel("INITIAL AMOUNT:");
        initAmountLabel.setBounds(169, 584, 115, 14);
        printPanel.add(initAmountLabel);

        roomTotal = new JTextField("₹ " + Math.ceil(packTotalPrice));
        roomTotal.setEditable(false);
        roomTotal.setBounds(294, 491, 136, 20);
        printPanel.add(roomTotal);
        roomTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
        roomTotal.setHorizontalAlignment(SwingConstants.CENTER);

        serviceTotal = new JTextField("₹ " + Math.ceil(servTotal));
        serviceTotal.setEditable(false);
        serviceTotal.setColumns(10);
        serviceTotal.setBounds(294, 526, 136, 20);
        serviceTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
        printPanel.add(serviceTotal);
        serviceTotal.setHorizontalAlignment(SwingConstants.CENTER);

        gstTotal = new JTextField("₹ " + Math.ceil(gsttot));
        gstTotal.setEditable(false);
        gstTotal.setColumns(10);
        gstTotal.setBounds(294, 553, 136, 20);
        gstTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
        printPanel.add(gstTotal);
        gstTotal.setHorizontalAlignment(SwingConstants.CENTER);

        initAmount = new JTextField("₹ " + Math.ceil(initalAmount));
        initAmount.setEditable(false);
        initAmount.setColumns(10);
        initAmount.setBounds(294, 581, 136, 20);
        initAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
        printPanel.add(initAmount);
        initAmount.setHorizontalAlignment(SwingConstants.CENTER);

        balanceAmount = new JTextField("₹ " + Math.ceil(balance));
        balanceAmount.setEditable(false);
        balanceAmount.setColumns(10);
        balanceAmount.setBounds(294, 614, 136, 20);
        balanceAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
        printPanel.add(balanceAmount);
        balanceAmount.setHorizontalAlignment(SwingConstants.CENTER);

        JButton printButton = new JButton("PRINT");
        printButton.setBounds(196, 10, 89, 32);
        contentPane.add(printButton);
        printButton.addActionListener(new PrintUIWindow(printPanel, OrientationRequested.PORTRAIT));

        JPanel stampPanel = new JPanel();
        stampPanel.setLayout(null);
        stampPanel.setBorder(null);
        stampPanel.setBackground(Color.WHITE);
        stampPanel.setBounds(10, 490, 128, 141);
        printPanel.add(stampPanel);

        JLabel stamp = new JLabel("");
        stamp.setVerticalAlignment(SwingConstants.TOP);
        stamp.setForeground(Color.GRAY);
        stamp.setBorder(new LineBorder(Color.GRAY));
        Image i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/paid.png"));
        stamp.setIcon(new ImageIcon(i.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
        stamp.setBounds(0, 13, 128, 128);
        stampPanel.add(stamp);

        JLabel stampLabel = new JLabel("STAMP");
        stampLabel.setHorizontalAlignment(SwingConstants.CENTER);
        stampLabel.setForeground(Color.GRAY);
        stampLabel.setBorder(new LineBorder(Color.GRAY));
        stampLabel.setBounds(0, 0, 128, 14);
        stampPanel.add(stampLabel);
        JLabel pkgTotalLabel = new JLabel("PACKAGE TOTAL:");
        pkgTotalLabel.setBounds(169, 494, 115, 14);
        printPanel.add(pkgTotalLabel);

        JLabel srvTotalLabel = new JLabel("SERVICES TOTAL:");
        srvTotalLabel.setBounds(169, 529, 115, 14);
        printPanel.add(srvTotalLabel);

        JLabel taxTotalLabel = new JLabel("TOTAL (INCL. TAX):");
        taxTotalLabel.setBounds(169, 556, 115, 14);
        printPanel.add(taxTotalLabel);

        JLabel balLabel = new JLabel("BALANCE:");
        balLabel.setBounds(169, 617, 115, 14);
        printPanel.add(balLabel);

        JLabel thankLabel = new JLabel("<html><center>Thank you for your support.<br />We hope to serve you again</center></html>");
        thankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thankLabel.setBounds(10, 660, 420, 36);
        printPanel.add(thankLabel);
        thankLabel.setFont(new Font("DejaVu Serif Condensed", Font.BOLD | Font.ITALIC, 12));
    }

    public JTable getTransactionTable() {
        return transactionTable;
    }

    public void setTableColumnWidths() {
        transactionTable.getColumnModel().getColumn(0).setMinWidth(48);
        transactionTable.getColumnModel().getColumn(0).setMaxWidth(48);

        transactionTable.getColumnModel().getColumn(2).setMinWidth(96);
        transactionTable.getColumnModel().getColumn(2).setMaxWidth(96);
    }
}
