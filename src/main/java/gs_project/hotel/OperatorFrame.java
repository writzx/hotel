package gs_project.hotel;
import java.awt.EventQueue;

import javax.swing.*;
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

        /// region bookingPanel

        /// endregion

        /// region checkoutpanel
        JPanel checkOutPanel = new JPanel();
        checkOutPanel.setBounds(1, 1, 590, 547);
        checkOutPanel.setVisible(false);
        checkOutPanel.setLayout(null);

        JPanel checkBookIdPanel = new JPanel();
        checkBookIdPanel.setBounds(10, 11, 572, 97);
        checkOutPanel.add(checkBookIdPanel);
        checkBookIdPanel.setLayout(null);

        JLabel checkOutHeader = new JLabel("CHECK OUT");
        checkOutHeader.setBounds(0, 0, 572, 52);
        checkBookIdPanel.add(checkOutHeader);
        checkOutHeader.setHorizontalAlignment(SwingConstants.CENTER);
        checkOutHeader.setFont(new Font("Tahoma", Font.BOLD, 24));

        JLabel bookIdLabel = new JLabel("BOOKING ID:*");
        bookIdLabel.setBounds(0, 63, 119, 32);
        checkBookIdPanel.add(bookIdLabel);
        bookIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        bookId = new JTextField();
        bookId.setBounds(129, 65, 309, 32);
        checkBookIdPanel.add(bookId);
        bookId.setColumns(10);

        JButton checkButton = new JButton("CHECK");
        checkButton.setBounds(448, 65, 124, 32);
        checkBookIdPanel.add(checkButton);
        checkButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        JPanel billingPanel = new JPanel();
        billingPanel.setLayout(null);
        billingPanel.setBounds(10, 117, 572, 421);
        checkOutPanel.add(billingPanel);

        JPanel bookInfoPanel = new JPanel();
        bookInfoPanel.setBounds(10, 11, 552, 271);
        billingPanel.add(bookInfoPanel);
        bookInfoPanel.setLayout(null);

        JLabel custNameLabel = new JLabel("CUSTOMER NAME:");
        custNameLabel.setBounds(0, 0, 208, 32);
        bookInfoPanel.add(custNameLabel);
        custNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel custName = new JLabel("New label");
        custName.setBounds(218, 0, 334, 32);
        bookInfoPanel.add(custName);
        custName.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel roomNoLabel = new JLabel("ROOM NO:");
        roomNoLabel.setBounds(0, 35, 208, 32);
        bookInfoPanel.add(roomNoLabel);
        roomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel roomNo = new JLabel("New label");
        roomNo.setBounds(218, 35, 334, 32);
        bookInfoPanel.add(roomNo);
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel checkInLabel = new JLabel("CHECK IN DATE:");
        checkInLabel.setBounds(0, 78, 208, 32);
        bookInfoPanel.add(checkInLabel);
        checkInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel checkInDate = new JLabel("New label");
        checkInDate.setBounds(218, 78, 334, 32);
        bookInfoPanel.add(checkInDate);
        checkInDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel checkOutLabel = new JLabel("CHECK OUT DATE:");
        checkOutLabel.setBounds(0, 121, 208, 32);
        bookInfoPanel.add(checkOutLabel);
        checkOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel checkOutDate = new JLabel("New label");
        checkOutDate.setBounds(218, 121, 334, 32);
        bookInfoPanel.add(checkOutDate);
        checkOutDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel totalPriceLabel = new JLabel("TOTAL PRICE:");
        totalPriceLabel.setBounds(0, 196, 208, 32);
        bookInfoPanel.add(totalPriceLabel);
        totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel totalPrice = new JLabel("New label");
        totalPrice.setBounds(218, 196, 334, 32);
        bookInfoPanel.add(totalPrice);
        totalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel initPaymentLabel = new JLabel("INITIAL PAYMENT:");
        initPaymentLabel.setBounds(0, 239, 208, 32);
        bookInfoPanel.add(initPaymentLabel);
        initPaymentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        initPaymentBox = new JTextField();
        initPaymentBox.setBounds(218, 240, 334, 31);
        bookInfoPanel.add(initPaymentBox);
        initPaymentBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        initPaymentBox.setEditable(false);
        initPaymentBox.setColumns(10);

        JLabel gstLabel = new JLabel("GST:");
        gstLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        gstLabel.setBounds(10, 292, 208, 32);
        billingPanel.add(gstLabel);

        gstBox = new JTextField();
        gstBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        gstBox.setEditable(false);
        gstBox.setColumns(10);
        gstBox.setBounds(228, 293, 334, 32);
        billingPanel.add(gstBox);

        JLabel payAmountLabel = new JLabel("AMOUNT TO PAY:");
        payAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        payAmountLabel.setBounds(10, 336, 208, 32);
        billingPanel.add(payAmountLabel);

        amountBox = new JTextField();
        amountBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        amountBox.setEditable(false);
        amountBox.setColumns(10);
        amountBox.setBounds(228, 337, 334, 32);
        billingPanel.add(amountBox);

        JButton genBillButton = new JButton("GENERATE BILL");
        genBillButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        genBillButton.setBounds(288, 378, 274, 32);
        billingPanel.add(genBillButton);

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBounds(10, 378, 129, 32);
        billingPanel.add(backButton);
        /// endregion

        /// region checkInPanel
        JPanel checkInPanel = new JPanel();
        checkInPanel.setBounds(1, 1, 590, 547);
        checkInPanel.setVisible(false);
        checkInPanel.setLayout(null);

        JPanel confirmCheckInPanel = new JPanel();
        confirmCheckInPanel.setLayout(null);
        confirmCheckInPanel.setBounds(10, 117, 572, 421);
        checkInPanel.add(confirmCheckInPanel);

        JButton confirmCheckInButton = new JButton("CONFIRM CHECK IN");
        confirmCheckInButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckInButton.setBounds(288, 378, 274, 32);
        confirmCheckInPanel.add(confirmCheckInButton);
        /// endregion

        /// region leftButtons
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

        JButton cancelBookingButton = new JButton("Cancel Booking");
        cancelBookingButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelBookingButton.setBounds(10, 183, 172, 32);
        contentPane.add(cancelBookingButton);

        /// endregion

        addDateTimeToStatusBar();

        center();


        /// region events
        checkOutButton.addActionListener(e -> {
            rightPanel.removeAll();

            checkOutPanel.setVisible(true);

            checkOutHeader.setText("CHECK OUT");
            checkOutPanel.add(checkBookIdPanel);
            billingPanel.add(backButton);
            billingPanel.add(bookInfoPanel);
            rightPanel.add(checkOutPanel);

            // call set visible in checkButton method
            billingPanel.setVisible(false);

            rightPanel.repaint();
            rightPanel.revalidate();
        });
        checkInButton.addActionListener(e -> {
            rightPanel.removeAll();

            checkInPanel.setVisible(true);

            checkOutHeader.setText("CHECK IN");
            checkInPanel.add(checkBookIdPanel);
            confirmCheckInPanel.add(backButton);
            confirmCheckInPanel.add(bookInfoPanel);
            rightPanel.add(checkInPanel);

            // call set visible in checkButton method
            confirmCheckInPanel.setVisible(false);

            rightPanel.repaint();
            rightPanel.revalidate();
        });
        /// endregion
    }
}

