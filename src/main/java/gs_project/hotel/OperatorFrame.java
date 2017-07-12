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
    /// region panels
    protected final JPanel contentPane;
    protected final JPanel rightPanel;
    protected final JPanel checkOutPanel;
    protected final JPanel checkBookIdPanel;
    protected final JPanel billingPanel;
    protected final JPanel bookInfoPanel;
    protected final JPanel cancelBookingPanel;
    protected final JPanel confirmCancelPanel;
    protected final JPanel bookingPanel;
    protected final JPanel stepsPanel;
    protected final JPanel currentStepPanel;
    protected final JPanel confirmPanel;
    protected final JPanel detailsPanel;
    protected final JPanel roomSelectionPanel;
    protected final JPanel datesPeoplePanel;
    protected final JPanel checkInPanel;
    protected final JPanel confirmCheckInPanel;
    /// endregion

    /// region buttons
    protected final JButton bookButton;
    protected final JButton checkInButton;
    protected final JButton checkOutButton;
    protected final JButton foodOrderButton;
    protected final JButton cancelBookingButton;
    protected final JButton detCardCheckButton;
    protected final JButton roomSelSearchBtn;
    protected final JButton bookNextStepButton;
    protected final JButton bookCancelButton;
    protected final JButton checkButton;
    protected final JButton genBillButton;
    protected final JButton backButton;
    protected final JButton confirmCheckInButton;
    protected final JButton confirmCancelButton;
    /// endregion

    /// region labels
    protected final JLabel datesPeopleStep;
    protected final JLabel roomSelectStep;
    protected final JLabel detailsStep;
    protected final JLabel confirmStep;
    protected final JLabel confirmCustNameLabel;
    protected final JLabel confirmCardNumLabel;
    protected final JLabel confirmCheckInLabel;
    protected final JLabel confirmCheckOutLabel;
    protected final JLabel confirmRoomPackageLabel;
    protected final JLabel confirmAdultsLabel;
    protected final JLabel confirmChildrenLabel;
    protected final JLabel confirmPriceLabel;
    protected final JLabel confirmHeader;
    protected final JLabel detVerifyDocLabel;
    protected final JLabel detVisitorNameLabel;
    protected final JLabel detPhoneNumLabel;
    protected final JLabel detEmailLabel;
    protected final JLabel detAddressLabel;
    protected final JLabel detCardNumLabel;
    protected final JLabel detHeader;
    protected final JLabel roomSelCheckInLabel;
    protected final JLabel roomSelCheckOutLabel;
    protected final JLabel roomSelPriceLabel;
    protected final JLabel roomSelRoomNoLabel;
    protected final JLabel roomSelHeader;
    protected final JLabel selectDatePeopleHeader;
    protected final JLabel dateCheckInLabel;
    protected final JLabel dateCheckOutLabel;
    protected final JLabel datekNumAdultsLabel;
    protected final JLabel dateNumChildLabel;
    protected final JLabel checkOutHeader;
    protected final JLabel bookIdLabel;
    protected final JLabel custNameLabel;
    protected final JLabel custName;
    protected final JLabel roomPackageNumLabel;
    protected final JLabel roomPackageAndNum;
    protected final JLabel checkInLabel;
    protected final JLabel checkInDate;
    protected final JLabel checkOutLabel;
    protected final JLabel checkOutDate;
    protected final JLabel totalPriceLabel;
    protected final JLabel totalPrice;
    protected final JLabel initPaymentLabel;
    protected final JLabel gstLabel;
    protected final JLabel payAmountLabel;
    protected final JLabel roomNumLabel;
    /// endregion

    /// region textFields
    protected final JTextField confirmRoomPackageBox;
    protected final JTextField confirmCardNumBox;
    protected final JTextField confirmCustNameBox;
    protected final JTextField confirmCheckInBox;
    protected final JTextField confirmCheckOutBox;
    protected final JTextField confirmAdultsBox;
    protected final JTextField confirmChildrenBox;
    protected final JTextField confirmPriceBox;
    protected final JTextField detCardNumBox;
    protected final JTextField detVisitorNameBox;
    protected final JTextField detEmailBox;
    protected final JTextField detPhoneNumBox;
    protected final JTextField roomselPriceBox;
    protected final JTextField roomSelRoomNoBox;
    protected final JTextField bookId;
    protected final JTextField initPaymentBox;
    protected final JTextField gstBox;
    protected final JTextField amountBox;
    protected final JTextField roomNumBox;
    protected final JScrollPane roomSelTreeScroller;
    protected final JTree roomSelRoomTypesTree;
    protected final DatePicker roomSelCheckInBox;
    protected final DatePicker roomSelCheckOutBox;
    protected final JSpinner dateAdults;
    protected final JSpinner dateChildren;
    protected final DatePicker dateCheckInPicker;
    protected final DatePicker dateCheckoutPicker;
    /// endregion

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

    public OperatorFrame() {
        this("Operator Landing Page");
    }
    /**
     * Create the frame.
     */
    public OperatorFrame(String title) {
        super(title);
        RoomHelper.readFromFile();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBorder(new LineBorder(Color.GRAY));
        rightPanel.setBounds(192, 11, 592, 549);
        contentPane.add(rightPanel);

        /// region leftButtons
        bookButton = new JButton("Booking");
        bookButton.setFont(new Font("Verdana", Font.BOLD, 14));
        bookButton.setBounds(10, 11, 172, 32);
        contentPane.add(bookButton);

        checkInButton = new JButton("Check In");
        checkInButton.setFont(new Font("Verdana", Font.BOLD, 14));
        checkInButton.setBounds(10, 54, 172, 32);
        contentPane.add(checkInButton);

        checkOutButton = new JButton("Check Out");
        checkOutButton.setFont(new Font("Verdana", Font.BOLD, 14));
        checkOutButton.setBounds(10, 97, 172, 32);
        contentPane.add(checkOutButton);

        foodOrderButton = new JButton("Food Order");
        foodOrderButton.setFont(new Font("Verdana", Font.BOLD, 14));
        foodOrderButton.setBounds(10, 140, 172, 32);
        contentPane.add(foodOrderButton);

        cancelBookingButton = new JButton("Cancel Booking");
        cancelBookingButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelBookingButton.setBounds(10, 183, 172, 32);
        contentPane.add(cancelBookingButton);
        /// endregion

        addDateTimeToStatusBar();

        center();

        /// region bookingPanel
        bookingPanel = new JPanel();
        bookingPanel.setBounds(0, 0, 592, 549);
        bookingPanel.setBorder(new LineBorder(Color.GRAY));
        bookingPanel.setLayout(null);

        /// region stepsPanel
        stepsPanel = new JPanel();
        stepsPanel.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.setBounds(0, 0, 592, 48);
        bookingPanel.add(stepsPanel);
        stepsPanel.setLayout(null);

        datesPeopleStep = new JLabel("<html><center>DATES<br>PEOPLE</center></html>");
        datesPeopleStep.setForeground(Color.BLUE);
        datesPeopleStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        datesPeopleStep.setHorizontalAlignment(SwingConstants.CENTER);
        datesPeopleStep.setBounds(0, 0, 141, 48);
        datesPeopleStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(datesPeopleStep);

        roomSelectStep = new JLabel("<html><center>ROOM<br>SELECTION</center></html>");
        roomSelectStep.setEnabled(false);
        roomSelectStep.setForeground(Color.BLUE);
        roomSelectStep.setHorizontalAlignment(SwingConstants.CENTER);
        roomSelectStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        roomSelectStep.setBounds(151, 0, 141, 48);
        roomSelectStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(roomSelectStep);

        detailsStep = new JLabel("<html><center>PROVIDE<br>DETAILS</center></html>");
        detailsStep.setEnabled(false);
        detailsStep.setForeground(Color.BLUE);
        detailsStep.setHorizontalAlignment(SwingConstants.CENTER);
        detailsStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        detailsStep.setBounds(302, 0, 141, 48);
        detailsStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(detailsStep);

        confirmStep = new JLabel("<html><center>CONFIRM</center></html>");
        confirmStep.setEnabled(false);
        confirmStep.setForeground(Color.BLUE);
        confirmStep.setHorizontalAlignment(SwingConstants.CENTER);
        confirmStep.setFont(new Font("Tahoma", Font.BOLD, 20));
        confirmStep.setBounds(453, 0, 139, 48);
        confirmStep.setBorder(new LineBorder(Color.GRAY));
        stepsPanel.add(confirmStep);
        /// endregion

        /// region currentStepPanel
        currentStepPanel = new JPanel();
        currentStepPanel.setBorder(new LineBorder(Color.GRAY));
        currentStepPanel.setBounds(0, 47, 592, 458);
        bookingPanel.add(currentStepPanel);
        currentStepPanel.setLayout(null);

        /// region confirmPanel
        confirmPanel = new JPanel();
        confirmPanel.setLayout(null);
        confirmPanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(confirmPanel);

        confirmCustNameLabel = new JLabel("CUSTOMER NAME:");
        confirmCustNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCustNameLabel.setBounds(10, 59, 232, 32);
        confirmPanel.add(confirmCustNameLabel);

        confirmCardNumLabel = new JLabel("CARD NUMBER:");
        confirmCardNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCardNumLabel.setBounds(10, 102, 232, 32);
        confirmPanel.add(confirmCardNumLabel);

        confirmCheckInLabel = new JLabel("CHECK IN DATE:");
        confirmCheckInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckInLabel.setBounds(10, 201, 232, 32);
        confirmPanel.add(confirmCheckInLabel);

        confirmCheckOutLabel = new JLabel("CHECK OUT DATE:");
        confirmCheckOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckOutLabel.setBounds(10, 244, 232, 32);
        confirmPanel.add(confirmCheckOutLabel);

        confirmRoomPackageLabel = new JLabel("PACKAGE:");
        confirmRoomPackageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmRoomPackageLabel.setBounds(10, 158, 232, 32);
        confirmPanel.add(confirmRoomPackageLabel);

        confirmAdultsLabel = new JLabel("TOTAL ADULTS:");
        confirmAdultsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmAdultsLabel.setBounds(10, 298, 232, 32);
        confirmPanel.add(confirmAdultsLabel);

        confirmChildrenLabel = new JLabel("TOTAL CHILDREN:");
        confirmChildrenLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmChildrenLabel.setBounds(10, 341, 232, 32);
        confirmPanel.add(confirmChildrenLabel);

        confirmPriceLabel = new JLabel("TOTAL PRICE (INCL. TAX):");
        confirmPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmPriceLabel.setBounds(10, 394, 232, 32);
        confirmPanel.add(confirmPriceLabel);

        confirmHeader = new JLabel("CONFIRM YOUR BOOKING");
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
        detailsPanel = new JPanel();
        detailsPanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(detailsPanel);
        detailsPanel.setLayout(null);

        detVerifyDocLabel = new JLabel("VERIFICATION DOCMENT:*");
        detVerifyDocLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detVerifyDocLabel.setBounds(10, 394, 216, 32);
        detailsPanel.add(detVerifyDocLabel);

        detCardNumBox = new JTextField();
        detCardNumBox.setColumns(10);
        detCardNumBox.setBounds(245, 76, 211, 32);
        detailsPanel.add(detCardNumBox);

        detVisitorNameLabel = new JLabel("VISITOR NAME:*");
        detVisitorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detVisitorNameLabel.setBounds(10, 128, 216, 32);
        detailsPanel.add(detVisitorNameLabel);

        detPhoneNumLabel = new JLabel("PHONE NUMBER:*");
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

        detEmailLabel = new JLabel("EMAIL ID:*");
        detEmailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detEmailLabel.setBounds(10, 226, 216, 32);
        detailsPanel.add(detEmailLabel);

        JScrollPane detAdressScroller = new JScrollPane();
        detAdressScroller.setBounds(245, 276, 317, 98);
        detailsPanel.add(detAdressScroller);

        JTextArea detAddressBox = new JTextArea();
        detAdressScroller.setViewportView(detAddressBox);
        detAddressBox.setLineWrap(true);

        detAddressLabel = new JLabel("ADDRESS:");
        detAddressLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detAddressLabel.setBounds(10, 276, 216, 32);
        detailsPanel.add(detAddressLabel);

        detPhoneNumBox = new JTextField();
        detPhoneNumBox.setColumns(10);
        detPhoneNumBox.setBounds(245, 176, 317, 32);
        detailsPanel.add(detPhoneNumBox);

        detCardNumLabel = new JLabel("CARD NUMBER:");
        detCardNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        detCardNumLabel.setBounds(10, 76, 216, 32);
        detailsPanel.add(detCardNumLabel);

        detHeader = new JLabel("PERSONAL DETAILS");
        detHeader.setHorizontalAlignment(SwingConstants.CENTER);
        detHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        detHeader.setBounds(0, 0, 562, 48);
        detailsPanel.add(detHeader);

        JComboBox detVerifyDocBox = new JComboBox();
        detVerifyDocBox.setBounds(245, 394, 317, 32);
        detailsPanel.add(detVerifyDocBox);

        detCardCheckButton = new JButton("CHECK");
        detCardCheckButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        detCardCheckButton.setBounds(466, 76, 96, 32);
        detailsPanel.add(detCardCheckButton);
        /// endregion

        /// region roomSelectionPanel
        roomSelectionPanel = new JPanel();
        roomSelectionPanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(roomSelectionPanel);
        roomSelectionPanel.setLayout(null);

        roomselPriceBox = new JTextField();
        roomselPriceBox.setBounds(127, 313, 162, 32);
        roomSelectionPanel.add(roomselPriceBox);
        roomselPriceBox.setEditable(false);
        roomselPriceBox.setColumns(10);

        roomSelCheckInLabel = new JLabel("CHECK IN:");
        roomSelCheckInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelCheckInLabel.setBounds(10, 93, 108, 32);
        roomSelectionPanel.add(roomSelCheckInLabel);

        roomSelCheckOutLabel = new JLabel("CHECK OUT:");
        roomSelCheckOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelCheckOutLabel.setBounds(9, 169, 108, 32);
        roomSelectionPanel.add(roomSelCheckOutLabel);

        roomSelSearchBtn = new JButton("SEARCH");
        roomSelSearchBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
        roomSelSearchBtn.setBounds(10, 394, 279, 32);
        roomSelectionPanel.add(roomSelSearchBtn);

        roomSelPriceLabel = new JLabel("PRICE:");
        roomSelPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelPriceLabel.setBounds(10, 313, 108, 32);
        roomSelectionPanel.add(roomSelPriceLabel);

        roomSelRoomNoLabel = new JLabel("ROOM NO:");
        roomSelRoomNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomSelRoomNoLabel.setBounds(10, 240, 108, 32);
        roomSelectionPanel.add(roomSelRoomNoLabel);

        roomSelHeader = new JLabel("ROOM SELECTION");
        roomSelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        roomSelHeader.setBounds(0, 0, 562, 48);
        roomSelectionPanel.add(roomSelHeader);
        roomSelHeader.setFont(new Font("Tahoma", Font.BOLD, 20));

        roomSelTreeScroller = new JScrollPane();
        roomSelTreeScroller.setBounds(315, 81, 247, 345);
        roomSelectionPanel.add(roomSelTreeScroller);

        DefaultTreeModel roomModel = new DefaultTreeModel(new DefaultMutableTreeNode("ROOMS"));
        roomSelRoomTypesTree = new JTree(roomModel);
        roomSelTreeScroller.setViewportView(roomSelRoomTypesTree);

        roomSelRoomNoBox = new JTextField();
        roomSelRoomNoBox.setBounds(127, 240, 162, 32);
        roomSelectionPanel.add(roomSelRoomNoBox);
        roomSelRoomNoBox.setEditable(false);
        roomSelRoomNoBox.setColumns(10);

        roomSelCheckInBox = new DatePicker();
        roomSelCheckInBox.setBounds(127, 93, 162, 32);
        roomSelectionPanel.add(roomSelCheckInBox);

        roomSelCheckOutBox = new DatePicker();
        roomSelCheckOutBox.setBounds(127, 169, 162, 32);
        roomSelectionPanel.add(roomSelCheckOutBox);
        /// endregion

        /// region datesPeoplePanel
        datesPeoplePanel = new JPanel();
        datesPeoplePanel.setLayout(null);
        datesPeoplePanel.setBounds(10, 11, 572, 437);
        // currentStepPanel.add(datesPeoplePanel);

        selectDatePeopleHeader = new JLabel("<html><center>SELECT: STAY PERIOD and <br> NUMBER OF ADULTS and CHILDREN</center></html>");
        selectDatePeopleHeader.setHorizontalAlignment(SwingConstants.CENTER);
        selectDatePeopleHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        selectDatePeopleHeader.setBounds(0, 0, 572, 49);
        datesPeoplePanel.add(selectDatePeopleHeader);

        dateCheckInLabel = new JLabel("CHECK IN:*");
        dateCheckInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateCheckInLabel.setBounds(56, 95, 170, 32);
        datesPeoplePanel.add(dateCheckInLabel);

        dateCheckOutLabel = new JLabel("CHECK OUT:*");
        dateCheckOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateCheckOutLabel.setBounds(56, 178, 170, 32);
        datesPeoplePanel.add(dateCheckOutLabel);

        datekNumAdultsLabel = new JLabel("NUMBER OF ADULTS:*");
        datekNumAdultsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        datekNumAdultsLabel.setBounds(56, 265, 170, 32);
        datesPeoplePanel.add(datekNumAdultsLabel);

        dateNumChildLabel = new JLabel("NUMBER OF CHILDERN:");
        dateNumChildLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateNumChildLabel.setBounds(56, 350, 170, 32);
        datesPeoplePanel.add(dateNumChildLabel);

        dateAdults = new JSpinner();
        dateAdults.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateAdults.setBounds(312, 266, 230, 32);
        datesPeoplePanel.add(dateAdults);

        dateChildren = new JSpinner();
        dateChildren.setFont(new Font("Tahoma", Font.BOLD, 14));
        dateChildren.setBounds(312, 351, 230, 32);
        datesPeoplePanel.add(dateChildren);

        dateCheckInPicker = new DatePicker();
        dateCheckInPicker.setBounds(312, 95, 230, 32);
        datesPeoplePanel.add(dateCheckInPicker);

        dateCheckoutPicker = new DatePicker();
        dateCheckoutPicker.setBounds(312, 178, 230, 32);
        datesPeoplePanel.add(dateCheckoutPicker);
        /// endregion

        /// endregion

        bookNextStepButton = new JButton("NEXT STEP");
        bookNextStepButton.setBounds(402, 511, 180, 32);
        bookingPanel.add(bookNextStepButton);
        bookNextStepButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        bookCancelButton = new JButton("CANCEL");
        bookCancelButton.setBounds(296, 511, 96, 32);
        bookingPanel.add(bookCancelButton);
        bookCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        /// endregion

        /// region checkoutpanel
        checkOutPanel = new JPanel();
        checkOutPanel.setBounds(0, 0, 592, 549);
        checkOutPanel.setBorder(new LineBorder(Color.GRAY));
        checkOutPanel.setLayout(null);

        checkBookIdPanel = new JPanel();
        checkBookIdPanel.setBounds(10, 11, 572, 97);
        checkOutPanel.add(checkBookIdPanel);
        checkBookIdPanel.setLayout(null);

        checkOutHeader = new JLabel("CHECK OUT");
        checkOutHeader.setBounds(0, 0, 572, 52);
        checkBookIdPanel.add(checkOutHeader);
        checkOutHeader.setHorizontalAlignment(SwingConstants.CENTER);
        checkOutHeader.setFont(new Font("Tahoma", Font.BOLD, 24));

        bookIdLabel = new JLabel("BOOKING ID:*");
        bookIdLabel.setBounds(0, 63, 119, 32);
        checkBookIdPanel.add(bookIdLabel);
        bookIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        bookId = new JTextField();
        bookId.setBounds(129, 65, 309, 32);
        checkBookIdPanel.add(bookId);
        bookId.setColumns(10);

        checkButton = new JButton("CHECK");
        checkButton.setBounds(448, 65, 124, 32);
        checkBookIdPanel.add(checkButton);
        checkButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        billingPanel = new JPanel();
        billingPanel.setLayout(null);
        billingPanel.setBounds(10, 117, 572, 421);
        checkOutPanel.add(billingPanel);

        bookInfoPanel = new JPanel();
        bookInfoPanel.setBounds(10, 11, 552, 271);
        billingPanel.add(bookInfoPanel);
        bookInfoPanel.setLayout(null);

        custNameLabel = new JLabel("CUSTOMER NAME:");
        custNameLabel.setBounds(0, 0, 208, 32);
        bookInfoPanel.add(custNameLabel);
        custNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        custName = new JLabel("New label");
        custName.setBounds(218, 0, 334, 32);
        bookInfoPanel.add(custName);
        custName.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomPackageNumLabel = new JLabel("PACKAGE(with ROOM#):");
        roomPackageNumLabel.setBounds(0, 35, 208, 32);
        bookInfoPanel.add(roomPackageNumLabel);
        roomPackageNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomPackageAndNum = new JLabel("New label");
        roomPackageAndNum.setBounds(218, 35, 334, 32);
        bookInfoPanel.add(roomPackageAndNum);
        roomPackageAndNum.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkInLabel = new JLabel("CHECK IN DATE:");
        checkInLabel.setBounds(0, 78, 208, 32);
        bookInfoPanel.add(checkInLabel);
        checkInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkInDate = new JLabel("New label");
        checkInDate.setBounds(218, 78, 334, 32);
        bookInfoPanel.add(checkInDate);
        checkInDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkOutLabel = new JLabel("CHECK OUT DATE:");
        checkOutLabel.setBounds(0, 121, 208, 32);
        bookInfoPanel.add(checkOutLabel);
        checkOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkOutDate = new JLabel("New label");
        checkOutDate.setBounds(218, 121, 334, 32);
        bookInfoPanel.add(checkOutDate);
        checkOutDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        totalPriceLabel = new JLabel("TOTAL PRICE:");
        totalPriceLabel.setBounds(0, 196, 208, 32);
        bookInfoPanel.add(totalPriceLabel);
        totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        totalPrice = new JLabel("New label");
        totalPrice.setBounds(218, 196, 334, 32);
        bookInfoPanel.add(totalPrice);
        totalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));

        initPaymentLabel = new JLabel("INITIAL PAYMENT:");
        initPaymentLabel.setBounds(0, 239, 208, 32);
        bookInfoPanel.add(initPaymentLabel);
        initPaymentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        initPaymentBox = new JTextField();
        initPaymentBox.setBounds(218, 240, 334, 31);
        bookInfoPanel.add(initPaymentBox);
        initPaymentBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        initPaymentBox.setEditable(false);
        initPaymentBox.setColumns(10);

        gstLabel = new JLabel("GST:");
        gstLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        gstLabel.setBounds(10, 292, 208, 32);
        billingPanel.add(gstLabel);

        gstBox = new JTextField();
        gstBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        gstBox.setEditable(false);
        gstBox.setColumns(10);
        gstBox.setBounds(228, 293, 334, 32);
        billingPanel.add(gstBox);

        payAmountLabel = new JLabel("AMOUNT TO PAY:");
        payAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        payAmountLabel.setBounds(10, 336, 208, 32);
        billingPanel.add(payAmountLabel);

        amountBox = new JTextField();
        amountBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        amountBox.setEditable(false);
        amountBox.setColumns(10);
        amountBox.setBounds(228, 337, 334, 32);
        billingPanel.add(amountBox);

        genBillButton = new JButton("GENERATE BILL");
        genBillButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        genBillButton.setBounds(288, 378, 274, 32);
        billingPanel.add(genBillButton);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBounds(10, 378, 129, 32);
        billingPanel.add(backButton);
        /// endregion

        /// region checkInPanel
        checkInPanel = new JPanel();
        checkInPanel.setBounds(0, 0, 592, 549);
        checkInPanel.setBorder(new LineBorder(Color.GRAY));
        checkInPanel.setLayout(null);

        confirmCheckInPanel = new JPanel();
        confirmCheckInPanel.setLayout(null);
        confirmCheckInPanel.setBounds(10, 117, 572, 421);
        checkInPanel.add(confirmCheckInPanel);

        roomNumLabel = new JLabel("ROOM NUMBER:");
        roomNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNumLabel.setBounds(10, 322, 208, 32);
        confirmCheckInPanel.add(roomNumLabel);

        roomNumBox = new JTextField();
        roomNumBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNumBox.setEditable(false);
        roomNumBox.setColumns(10);
        roomNumBox.setBounds(228, 322, 334, 32);
        confirmCheckInPanel.add(roomNumBox);

        confirmCheckInButton = new JButton("CONFIRM CHECK IN");
        confirmCheckInButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCheckInButton.setBounds(288, 378, 274, 32);
        confirmCheckInPanel.add(confirmCheckInButton);
        /// endregion

        /// region cancelBookingPanel
        cancelBookingPanel = new JPanel();
        cancelBookingPanel.setBounds(0, 0, 592, 549);
        cancelBookingPanel.setBorder(new LineBorder(Color.GRAY));
        cancelBookingPanel.setLayout(null);

        confirmCancelPanel = new JPanel();
        confirmCancelPanel.setLayout(null);
        confirmCancelPanel.setBounds(10, 117, 572, 421);
        cancelBookingPanel.add(confirmCancelPanel);

        confirmCancelButton = new JButton("CONFIRM CHECK IN");
        confirmCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCancelButton.setBounds(288, 378, 274, 32);
        confirmCancelPanel.add(confirmCancelButton);
        /// endregion

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

        bookCancelButton.addActionListener(e -> setPanel(null, rightPanel)); // clear right panel

        cancelBookingButton.addActionListener(e -> {
            checkOutHeader.setText("CANCEL BOOKING");
            cancelBookingPanel.add(checkBookIdPanel);
            confirmCancelPanel.add(bookInfoPanel);

            backButton.setBounds(10, 378, 129, 32);
            confirmCancelPanel.add(backButton);

            // todo call set visible in checkButton method
            confirmCancelPanel.setVisible(true);

            setPanel(cancelBookingPanel, rightPanel);
        });

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

        RoomHelper.loadClassesInTree(roomSelRoomTypesTree);
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

