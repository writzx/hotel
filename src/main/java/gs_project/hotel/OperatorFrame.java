package gs_project.hotel;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class OperatorFrame extends MainFrame {

    private JPanel contentPane;
    private JTextField bookId;
    private JTextField gstBox;
    private JTextField initPaymentBox;
    private JTextField amountBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OperatorFrame frame = new OperatorFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public OperatorFrame() {
        super("Operator Landing Page");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBorder(new LineBorder(Color.GRAY));
        rightPanel.setBounds(192, 11, 592, 549);
        contentPane.add(rightPanel);

        /// region checkoutpanel
        JPanel checkOutPanel = new JPanel();
        checkOutPanel.setBounds(1, 1, 590, 547);
        // checkOutPanel.setVisible(false);
        rightPanel.add(checkOutPanel);
        checkOutPanel.setLayout(null);

        JLabel checkOutHeader = new JLabel("CHECK OUT ");
        checkOutHeader.setHorizontalAlignment(SwingConstants.CENTER);
        checkOutHeader.setFont(new Font("Tahoma", Font.BOLD, 24));
        checkOutHeader.setBounds(10, 11, 572, 52);
        checkOutPanel.add(checkOutHeader);

        JLabel bookIdLabel = new JLabel("BOOKING ID:*");
        bookIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookIdLabel.setBounds(10, 74, 119, 32);
        checkOutPanel.add(bookIdLabel);

        bookId = new JTextField();
        bookId.setColumns(10);
        bookId.setBounds(139, 76, 309, 32);
        checkOutPanel.add(bookId);

        JButton checkButton = new JButton("CHECK");
        checkButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkButton.setBounds(458, 76, 124, 32);
        checkOutPanel.add(checkButton);

        JPanel custInfoPanel = new JPanel();
        custInfoPanel.setLayout(null);
        custInfoPanel.setBounds(10, 117, 572, 421);
        custInfoPanel.setBorder(new LineBorder(Color.GRAY));
        checkOutPanel.add(custInfoPanel);

        JLabel custNameLabel = new JLabel("CUSTOMER NAME:");
        custNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        custNameLabel.setBounds(10, 11, 208, 32);
        custInfoPanel.add(custNameLabel);

        JLabel custName = new JLabel("New label");
        custName.setFont(new Font("Tahoma", Font.BOLD, 14));
        custName.setBounds(228, 11, 334, 32);
        custInfoPanel.add(custName);

        JLabel roomNoLabel = new JLabel("ROOM NO:");
        roomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNoLabel.setBounds(10, 46, 208, 32);
        custInfoPanel.add(roomNoLabel);

        JLabel roomNo = new JLabel("New label");
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNo.setBounds(228, 46, 334, 32);
        custInfoPanel.add(roomNo);

        JLabel checkInLabel = new JLabel("CHECK IN DATE:");
        checkInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkInLabel.setBounds(10, 89, 208, 32);
        custInfoPanel.add(checkInLabel);

        JLabel checkInDate = new JLabel("New label");
        checkInDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkInDate.setBounds(228, 89, 334, 32);
        custInfoPanel.add(checkInDate);

        JLabel checkOutLabel = new JLabel("CHECK OUT DATE:");
        checkOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkOutLabel.setBounds(10, 132, 208, 32);
        custInfoPanel.add(checkOutLabel);

        JLabel checkOutDate = new JLabel("New label");
        checkOutDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkOutDate.setBounds(228, 132, 334, 32);
        custInfoPanel.add(checkOutDate);

        JLabel totalPriceLabel = new JLabel("TOTAL PRICE:");
        totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        totalPriceLabel.setBounds(10, 207, 208, 32);
        custInfoPanel.add(totalPriceLabel);

        JLabel totalPrice = new JLabel("New label");
        totalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
        totalPrice.setBounds(228, 207, 334, 32);
        custInfoPanel.add(totalPrice);

        JLabel gstLabel = new JLabel("GST:");
        gstLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        gstLabel.setBounds(10, 250, 208, 32);
        custInfoPanel.add(gstLabel);

        gstBox = new JTextField();
        gstBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        gstBox.setEditable(false);
        gstBox.setColumns(10);
        gstBox.setBounds(228, 251, 334, 32);
        custInfoPanel.add(gstBox);

        JLabel initPaymentLabel = new JLabel("INITIAL PAYMENT:");
        initPaymentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        initPaymentLabel.setBounds(10, 293, 208, 32);
        custInfoPanel.add(initPaymentLabel);

        initPaymentBox = new JTextField();
        initPaymentBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        initPaymentBox.setEditable(false);
        initPaymentBox.setColumns(10);
        initPaymentBox.setBounds(228, 294, 334, 31);
        custInfoPanel.add(initPaymentBox);

        JLabel payAmountLabel = new JLabel("AMOUNT TO PAY:");
        payAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        payAmountLabel.setBounds(10, 336, 208, 32);
        custInfoPanel.add(payAmountLabel);

        amountBox = new JTextField();
        amountBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        amountBox.setEditable(false);
        amountBox.setColumns(10);
        amountBox.setBounds(228, 337, 334, 32);
        custInfoPanel.add(amountBox);

        JButton genBillButton = new JButton("GENERATE BILL");
        genBillButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        genBillButton.setBounds(288, 378, 274, 32);
        custInfoPanel.add(genBillButton);

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBounds(10, 378, 129, 32);
        custInfoPanel.add(backButton);
        /// endregion

        JButton bookButton = new JButton("Booking");
        bookButton.setFont(new Font("Verdana", Font.BOLD, 14));
        bookButton.setBounds(10, 11, 172, 32);
        contentPane.add(bookButton);

        JButton checkInButton = new JButton("Check In");
        checkInButton.setFont(new Font("Verdana", Font.BOLD, 14));
        checkInButton.setBounds(10, 54, 172, 32);
        contentPane.add(checkInButton);

        JButton checkOutButton = new JButton("Check Out");
        checkOutButton.setFont(new Font("Verdana", Font.BOLD, 14));
        checkOutButton.setBounds(10, 97, 172, 32);
        contentPane.add(checkOutButton);

        JButton foodOrderButton = new JButton("Food Order");
        foodOrderButton.setFont(new Font("Verdana", Font.BOLD, 14));
        foodOrderButton.setBounds(10, 140, 172, 32);
        contentPane.add(foodOrderButton);

        JButton cancelButton = new JButton("Cancel Booking");
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelButton.setBounds(10, 183, 172, 32);
        contentPane.add(cancelButton);

        addDateTimeToStatusBar();

        center();
    }
}

