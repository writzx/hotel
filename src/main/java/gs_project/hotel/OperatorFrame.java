package gs_project.hotel;

import com.github.lgooddatepicker.components.DatePicker;
import gs_project.hotel.types.RoomClass;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class OperatorFrame extends MainFrame {

    private JPanel contentPane;
    private JTextField bookId;
    private JTextField gstBox;
    private JTextField initPaymentBox;
    private JTextField amountBox;
    private JTextField roomNumBox;
    private JTextField roomselPriceBox;
    private JTextField roomSelRoomNoBox;
    private JTextField detCardNumBox;
    private JTextField detEmailBox;
    private JTextField detVisitorNameBox;
    private JTextField detPhoneNumBox;
    private JTextField confirmRoomPackageBox;
    private JTextField confirmCardNumBox;
    private JTextField confirmCustNameBox;
    private JTextField confirmCheckInBox;
    private JTextField confirmCheckOutBox;
    private JTextField confirmAdultsBox;
    private JTextField confirmChildrenBox;
    private JTextField confirmPriceBox;

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

    ArrayList<RoomClass> roomClasses = new ArrayList<>();

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
        JPanel bookingPanel = new JPanel();
        bookingPanel.setBounds(0, 0, 592, 549);
        bookingPanel.setBorder(new LineBorder(Color.GRAY));
        bookingPanel.setLayout(null);

        /// region stepsPanel
        JPanel stepsPanel = new JPanel();
        stepsPanel.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.setBounds(0, 0, 592, 48);
        bookingPanel.add(stepsPanel);
        stepsPanel.setLayout(null);

        JLabel datesPeopleStep = new JLabel("<html><center>DATES<br>PEOPLE</center></html>");
        datesPeopleStep.setForeground(Color.BLUE);
        datesPeopleStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        datesPeopleStep.setHorizontalAlignment(SwingConstants.CENTER);
        datesPeopleStep.setBounds(0, 0, 141, 48);
        datesPeopleStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(datesPeopleStep);

        JLabel roomSelectStep = new JLabel("<html><center>ROOM<br>SELECTION</center></html>");
        roomSelectStep.setEnabled(false);
        roomSelectStep.setForeground(Color.BLUE);
        roomSelectStep.setHorizontalAlignment(SwingConstants.CENTER);
        roomSelectStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        roomSelectStep.setBounds(151, 0, 141, 48);
        roomSelectStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(roomSelectStep);

        JLabel detailsStep = new JLabel("<html><center>PROVIDE<br>DETAILS</center></html>");
        detailsStep.setEnabled(false);
        detailsStep.setForeground(Color.BLUE);
        detailsStep.setHorizontalAlignment(SwingConstants.CENTER);
        detailsStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        detailsStep.setBounds(302, 0, 141, 48);
        detailsStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(detailsStep);

        JLabel confirmStep = new JLabel("<html><center>CONFIRM</center></html>");
        confirmStep.setEnabled(false);
        confirmStep.setForeground(Color.BLUE);
        confirmStep.setHorizontalAlignment(SwingConstants.CENTER);
        confirmStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        confirmStep.setBounds(453, 0, 139, 48);
        confirmStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(confirmStep);
        /// endregion

        /// region currentStepPanel
        JPanel currentStepPanel = new JPanel();
        currentStepPanel.setBorder(new LineBorder(Color.GRAY));
        currentStepPanel.setBounds(0, 47, 592, 458);
        bookingPanel.add(currentStepPanel);
        currentStepPanel.setLayout(null);

        /// region confirmPanel
        JPanel confirmPanel = new JPanel();
        confirmPanel.setLayout(null);
        confirmPanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(confirmPanel);

        JLabel confirmCustNameLabel = new JLabel("CUSTOMER NAME:");
        confirmCustNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCustNameLabel.setBounds(10, 59, 232, 32);
        confirmPanel.add(confirmCustNameLabel);

        JLabel confirmCardNumLabel = new JLabel("CARD NUMBER:");
        confirmCardNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCardNumLabel.setBounds(10, 102, 232, 32);
        confirmPanel.add(confirmCardNumLabel);

        JLabel confirmCheckInLabel = new JLabel("CHECK IN DATE:");
        confirmCheckInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckInLabel.setBounds(10, 201, 232, 32);
        confirmPanel.add(confirmCheckInLabel);

        JLabel confirmCheckOutLabel = new JLabel("CHECK OUT DATE:");
        confirmCheckOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckOutLabel.setBounds(10, 244, 232, 32);
        confirmPanel.add(confirmCheckOutLabel);

        JLabel confirmRoomPackageLabel = new JLabel("PACKAGE:");
        confirmRoomPackageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmRoomPackageLabel.setBounds(10, 158, 232, 32);
        confirmPanel.add(confirmRoomPackageLabel);

        JLabel confirmAdultsLabel = new JLabel("TOTAL ADULTS:");
        confirmAdultsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmAdultsLabel.setBounds(10, 298, 232, 32);
        confirmPanel.add(confirmAdultsLabel);

        JLabel confirmChildrenLabel = new JLabel("TOTAL CHILDREN:");
        confirmChildrenLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmChildrenLabel.setBounds(10, 341, 232, 32);
        confirmPanel.add(confirmChildrenLabel);

        JLabel confirmPriceLabel = new JLabel("TOTAL PRICE (INCL. TAX):");
        confirmPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmPriceLabel.setBounds(10, 394, 232, 32);
        confirmPanel.add(confirmPriceLabel);

        JLabel confirmHeader = new JLabel("CONFIRM YOUR BOOKING");
        confirmHeader.setHorizontalAlignment(SwingConstants.CENTER);
        confirmHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        confirmHeader.setBounds(0, 0, 562, 48);
        confirmPanel.add(confirmHeader);

        confirmRoomPackageBox = new JTextField();
        confirmRoomPackageBox.setEditable(false);
        confirmRoomPackageBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmRoomPackageBox.setColumns(10);
        confirmRoomPackageBox.setBounds(250, 158, 312, 32);
        confirmPanel.add(confirmRoomPackageBox);

        confirmCardNumBox = new JTextField();
        confirmCardNumBox.setEditable(false);
        confirmCardNumBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCardNumBox.setColumns(10);
        confirmCardNumBox.setBounds(250, 102, 312, 32);
        confirmPanel.add(confirmCardNumBox);

        confirmCustNameBox = new JTextField();
        confirmCustNameBox.setEditable(false);
        confirmCustNameBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCustNameBox.setColumns(10);
        confirmCustNameBox.setBounds(250, 59, 312, 32);
        confirmPanel.add(confirmCustNameBox);

        confirmCheckInBox = new JTextField();
        confirmCheckInBox.setEditable(false);
        confirmCheckInBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckInBox.setColumns(10);
        confirmCheckInBox.setBounds(250, 201, 312, 32);
        confirmPanel.add(confirmCheckInBox);

        confirmCheckOutBox = new JTextField();
        confirmCheckOutBox.setEditable(false);
        confirmCheckOutBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckOutBox.setColumns(10);
        confirmCheckOutBox.setBounds(250, 244, 312, 32);
        confirmPanel.add(confirmCheckOutBox);

        confirmAdultsBox = new JTextField();
        confirmAdultsBox.setEditable(false);
        confirmAdultsBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmAdultsBox.setColumns(10);
        confirmAdultsBox.setBounds(250, 298, 312, 32);
        confirmPanel.add(confirmAdultsBox);

        confirmChildrenBox = new JTextField();
        confirmChildrenBox.setEditable(false);
        confirmChildrenBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmChildrenBox.setColumns(10);
        confirmChildrenBox.setBounds(250, 341, 312, 32);
        confirmPanel.add(confirmChildrenBox);

        confirmPriceBox = new JTextField();
        confirmPriceBox.setEditable(false);
        confirmPriceBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmPriceBox.setColumns(10);
        confirmPriceBox.setBounds(250, 394, 312, 32);
        confirmPanel.add(confirmPriceBox);
        /// endregion

        /// region detailsPanel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(detailsPanel);
        detailsPanel.setLayout(null);

        JLabel detVerifyDocLabel = new JLabel("VERIFICATION DOCMENT:*");
        detVerifyDocLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detVerifyDocLabel.setBounds(10, 394, 216, 32);
        detailsPanel.add(detVerifyDocLabel);

        detCardNumBox = new JTextField();
        detCardNumBox.setColumns(10);
        detCardNumBox.setBounds(245, 76, 211, 32);
        detailsPanel.add(detCardNumBox);

        JLabel detVisitorNameLabel = new JLabel("VISITOR NAME:*");
        detVisitorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detVisitorNameLabel.setBounds(10, 128, 216, 32);
        detailsPanel.add(detVisitorNameLabel);

        JLabel detPhoneNumLabel = new JLabel("PHONE NUMBER:*");
        detPhoneNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detPhoneNumLabel.setBounds(10, 176, 216, 32);
        detailsPanel.add(detPhoneNumLabel);

        detVisitorNameBox = new JTextField();
        detVisitorNameBox.setColumns(10);
        detVisitorNameBox.setBounds(245, 128, 317, 32);
        detailsPanel.add(detVisitorNameBox);

        detEmailBox = new JTextField();
        detEmailBox.setColumns(10);
        detEmailBox.setBounds(245, 226, 317, 32);
        detailsPanel.add(detEmailBox);

        JLabel detEmailLabel = new JLabel("EMAIL ID:*");
        detEmailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detEmailLabel.setBounds(10, 226, 216, 32);
        detailsPanel.add(detEmailLabel);

        JScrollPane detAdressScroller = new JScrollPane();
        detAdressScroller.setBounds(245, 276, 317, 98);
        detailsPanel.add(detAdressScroller);

        JTextArea detAddressBox = new JTextArea();
        detAdressScroller.setViewportView(detAddressBox);
        detAddressBox.setLineWrap(true);

        JLabel detAddressLabel = new JLabel("ADDRESS:");
        detAddressLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detAddressLabel.setBounds(10, 276, 216, 32);
        detailsPanel.add(detAddressLabel);

        detPhoneNumBox = new JTextField();
        detPhoneNumBox.setColumns(10);
        detPhoneNumBox.setBounds(245, 176, 317, 32);
        detailsPanel.add(detPhoneNumBox);

        JLabel detCardNumLabel = new JLabel("CARD NUMBER:");
        detCardNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detCardNumLabel.setBounds(10, 76, 216, 32);
        detailsPanel.add(detCardNumLabel);

        JLabel detHeader = new JLabel("PERSONAL DETAILS");
        detHeader.setHorizontalAlignment(SwingConstants.CENTER);
        detHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        detHeader.setBounds(0, 0, 562, 48);
        detailsPanel.add(detHeader);

        JComboBox detVerifyDocBox = new JComboBox();
        detVerifyDocBox.setBounds(245, 394, 317, 32);
        detailsPanel.add(detVerifyDocBox);

        JButton detCardCheckButton = new JButton("CHECK");
        detCardCheckButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        detCardCheckButton.setBounds(466, 76, 96, 32);
        detailsPanel.add(detCardCheckButton);
        /// endregion

        /// region roomSelectionPanel
        JPanel roomSelectionPanel = new JPanel();
        roomSelectionPanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(roomSelectionPanel);
        roomSelectionPanel.setLayout(null);

        roomselPriceBox = new JTextField();
        roomselPriceBox.setBounds(127, 313, 162, 32);
        roomSelectionPanel.add(roomselPriceBox);
        roomselPriceBox.setEditable(false);
        roomselPriceBox.setColumns(10);

        JLabel roomSelCheckInLabel = new JLabel("CHECK IN:");
        roomSelCheckInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelCheckInLabel.setBounds(10, 93, 108, 32);
        roomSelectionPanel.add(roomSelCheckInLabel);

        JLabel roomSelCheckOutLabel = new JLabel("CHECK OUT:");
        roomSelCheckOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelCheckOutLabel.setBounds(9, 169, 108, 32);
        roomSelectionPanel.add(roomSelCheckOutLabel);

        JButton roomSelSearchBtn = new JButton("SEARCH");
        roomSelSearchBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
        roomSelSearchBtn.setBounds(10, 394, 279, 32);
        roomSelectionPanel.add(roomSelSearchBtn);

        JLabel roomSelPriceLabel = new JLabel("PRICE:");
        roomSelPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelPriceLabel.setBounds(10, 313, 108, 32);
        roomSelectionPanel.add(roomSelPriceLabel);

        JLabel roomSelRoomNoLabel = new JLabel("ROOM NO:");
        roomSelRoomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelRoomNoLabel.setBounds(10, 240, 108, 32);
        roomSelectionPanel.add(roomSelRoomNoLabel);

        JLabel roomSelHeader = new JLabel("ROOM SELECTION");
        roomSelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        roomSelHeader.setBounds(0, 0, 562, 48);
        roomSelectionPanel.add(roomSelHeader);
        roomSelHeader.setFont(new Font("Tahoma", Font.BOLD, 20));

        JScrollPane roomSelTreeScroller = new JScrollPane();
        roomSelTreeScroller.setBounds(315, 81, 247, 345);
        roomSelectionPanel.add(roomSelTreeScroller);

        DefaultTreeModel roomModel = new DefaultTreeModel(new DefaultMutableTreeNode("ROOMS"));
        JTree roomSelRoomTypesTree = new JTree(roomModel);
        roomSelTreeScroller.setViewportView(roomSelRoomTypesTree);

        roomSelRoomNoBox = new JTextField();
        roomSelRoomNoBox.setBounds(127, 240, 162, 32);
        roomSelectionPanel.add(roomSelRoomNoBox);
        roomSelRoomNoBox.setEditable(false);
        roomSelRoomNoBox.setColumns(10);

        DatePicker roomSelCheckInBox = new DatePicker();
        roomSelCheckInBox.setBounds(127, 93, 162, 32);
        roomSelectionPanel.add(roomSelCheckInBox);

        DatePicker roomSelCheckOutBox = new DatePicker();
        roomSelCheckOutBox.setBounds(127, 169, 162, 32);
        roomSelectionPanel.add(roomSelCheckOutBox);
        /// endregion

        /// region datesPeoplePanel
        JPanel datesPeoplePanel = new JPanel();
        datesPeoplePanel.setLayout(null);
        datesPeoplePanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(datesPeoplePanel);

        JLabel selectDatePeopleHeader = new JLabel("<html><center>SELECT: STAY PERIOD and <br> NUMBER OF ADULTS and CHILDREN</center></html>");
        selectDatePeopleHeader.setHorizontalAlignment(SwingConstants.CENTER);
        selectDatePeopleHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectDatePeopleHeader.setBounds(0, 0, 572, 49);
        datesPeoplePanel.add(selectDatePeopleHeader);

        JLabel dateCheckInLabel = new JLabel("CHECK IN:*");
        dateCheckInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateCheckInLabel.setBounds(56, 95, 170, 32);
        datesPeoplePanel.add(dateCheckInLabel);

        JLabel dateCheckOutLabel = new JLabel("CHECK OUT:*");
        dateCheckOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateCheckOutLabel.setBounds(56, 178, 170, 32);
        datesPeoplePanel.add(dateCheckOutLabel);

        JLabel datekNumAdultsLabel = new JLabel("NUMBER OF ADULTS:*");
        datekNumAdultsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        datekNumAdultsLabel.setBounds(56, 265, 170, 32);
        datesPeoplePanel.add(datekNumAdultsLabel);

        JLabel dateNumChildLabel = new JLabel("NUMBER OF CHILDERN:");
        dateNumChildLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateNumChildLabel.setBounds(56, 350, 170, 32);
        datesPeoplePanel.add(dateNumChildLabel);

        JSpinner dateAdults = new JSpinner();
        dateAdults.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateAdults.setBounds(312, 266, 230, 32);
        datesPeoplePanel.add(dateAdults);

        JSpinner dateChildren = new JSpinner();
        dateChildren.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateChildren.setBounds(312, 351, 230, 32);
        datesPeoplePanel.add(dateChildren);

        DatePicker dateCheckInPicker = new DatePicker();
        dateCheckInPicker.setBounds(312, 95, 230, 32);
        datesPeoplePanel.add(dateCheckInPicker);

        DatePicker dateCheckoutPicker = new DatePicker();
        dateCheckoutPicker.setBounds(312, 178, 230, 32);
        datesPeoplePanel.add(dateCheckoutPicker);
        /// endregion

        /// endregion

        JButton bookNextStepButton = new JButton("NEXT STEP");
        bookNextStepButton.setBounds(402, 511, 180, 32);
        bookingPanel.add(bookNextStepButton);
        bookNextStepButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton bookingCancelButton = new JButton("CANCEL");
        bookingCancelButton.setBounds(296, 511, 96, 32);
        bookingPanel.add(bookingCancelButton);
        bookingCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        /// endregion

        /// region checkoutpanel
        JPanel checkOutPanel = new JPanel();
        checkOutPanel.setBounds(0, 0, 592, 549);
        checkOutPanel.setBorder(new LineBorder(Color.GRAY));
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

        JLabel roomPackageNumLabel = new JLabel("PACKAGE(with ROOM#):");
        roomPackageNumLabel.setBounds(0, 35, 208, 32);
        bookInfoPanel.add(roomPackageNumLabel);
        roomPackageNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel roomPackageAndNum = new JLabel("New label");
        roomPackageAndNum.setBounds(218, 35, 334, 32);
        bookInfoPanel.add(roomPackageAndNum);
        roomPackageAndNum.setFont(new Font("Tahoma", Font.BOLD, 14));

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
        checkInPanel.setBounds(0, 0, 592, 549);
        checkInPanel.setBorder(new LineBorder(Color.GRAY));
        checkInPanel.setLayout(null);

        JPanel confirmCheckInPanel = new JPanel();
        confirmCheckInPanel.setLayout(null);
        confirmCheckInPanel.setBounds(10, 117, 572, 421);
        checkInPanel.add(confirmCheckInPanel);

        JLabel roomNumLabel = new JLabel("ROOM NUMBER:");
        roomNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNumLabel.setBounds(10, 322, 208, 32);
        confirmCheckInPanel.add(roomNumLabel);

        roomNumBox = new JTextField();
        roomNumBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNumBox.setEditable(false);
        roomNumBox.setColumns(10);
        roomNumBox.setBounds(228, 322, 334, 32);
        confirmCheckInPanel.add(roomNumBox);

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
            checkOutHeader.setText("CHECK OUT");
            checkOutPanel.add(checkBookIdPanel);
            billingPanel.add(bookInfoPanel);

            backButton.setBounds(10, 378, 129, 32);
            billingPanel.add(backButton);

            // todo call set visible in checkButton method
            billingPanel.setVisible(true);

            setPanel(checkOutPanel, rightPanel);
        });

        checkInButton.addActionListener(e -> {
            checkOutHeader.setText("CHECK IN");
            checkInPanel.add(checkBookIdPanel);
            confirmCheckInPanel.add(bookInfoPanel);

            backButton.setBounds(10, 378, 129, 32);
            confirmCheckInPanel.add(backButton);

            // todo call set visible in checkButton method
            confirmCheckInPanel.setVisible(true);

            setPanel(checkInPanel, rightPanel);
        });

        bookButton.addActionListener(e -> {
            backButton.setBounds(10, 511, 129, 32);
            bookingPanel.add(backButton);

            setPanel(bookingPanel, rightPanel);

            setStep(datesPeopleStep, stepsPanel);
            setPanel(datesPeoplePanel, currentStepPanel);

        });

        bookNextStepButton.addActionListener(e -> {
            if (datesPeopleStep.isEnabled()) {
                bookNextStepButton.setText("NEXT STEP");
                setStep(roomSelectStep, stepsPanel);
                setPanel(roomSelectionPanel, currentStepPanel);
            } else if (roomSelectStep.isEnabled()) {
                bookNextStepButton.setText("NEXT STEP");
                setStep(detailsStep, stepsPanel);
                setPanel(detailsPanel, currentStepPanel);
            } else if (detailsStep.isEnabled()) {
                bookNextStepButton.setText("CONFIRM BOOKING");
                setStep(confirmStep, stepsPanel);
                setPanel(confirmPanel, currentStepPanel);
            } else if (confirmStep.isEnabled()) {
                // todo confirmBooking
                JOptionPane.showMessageDialog(OperatorFrame.this, "Booking Confirmed", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                bookNextStepButton.setText("NEXT STEP");
                setStep(datesPeopleStep, stepsPanel);
                setPanel(datesPeoplePanel, currentStepPanel);

            }
        });

        backButton.addActionListener(e -> {
            if (detailsStep.isEnabled()) {
                bookNextStepButton.setText("NEXT STEP");
                setStep(roomSelectStep, stepsPanel);
                setPanel(roomSelectionPanel, currentStepPanel);
            } else if (confirmStep.isEnabled()) {
                bookNextStepButton.setText("NEXT STEP");
                setStep(detailsStep, stepsPanel);
                setPanel(detailsPanel, currentStepPanel);
            } else if (roomSelectStep.isEnabled()) {
                bookNextStepButton.setText("NEXT STEP");
                setStep(datesPeopleStep, stepsPanel);
                setPanel(datesPeoplePanel, currentStepPanel);
            } else {
                // clear right panel
                setPanel(null, rightPanel);
            }
        });

        cancelBookingButton.addActionListener(e -> setPanel(null, rightPanel)); // clear right panel

        /// region stepsEvents
        datesPeopleStep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookNextStepButton.setText("NEXT STEP");

                setStep(datesPeopleStep, stepsPanel);
                setPanel(datesPeoplePanel, currentStepPanel);
            }
        });

        roomSelectStep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookNextStepButton.setText("NEXT STEP");

                setStep(roomSelectStep, stepsPanel);
                setPanel(roomSelectionPanel, currentStepPanel);
            }
        });

        detailsStep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookNextStepButton.setText("NEXT STEP");

                setStep(detailsStep, stepsPanel);
                setPanel(detailsPanel, currentStepPanel);
            }
        });

        confirmStep.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bookNextStepButton.setText("CONFIRM BOOKING");

                setStep(confirmStep, stepsPanel);
                setPanel(confirmPanel, currentStepPanel);
            }
        });
        /// endregion

        /// endregion

        System.out.println("Reading database file...");
        try {
            roomClasses = FileHandler.readFile("roomclasses");
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RoomEditor.loadClassesInTree(roomSelRoomTypesTree, roomClasses);
    }

    public static void setStep(Container step, Container panel) {
        for (Component comp : panel.getComponents()) {
            comp.setEnabled(false);
        }
        step.setEnabled(true);
    }

    public static void setPanel(Container inner, Container outer) {
        outer.removeAll();

        if (inner != null) {
            outer.add(inner);
        }

        outer.repaint();
        outer.revalidate();
    }
}

