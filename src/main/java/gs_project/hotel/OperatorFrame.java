package gs_project.hotel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import gs_project.hotel.helpers.*;
import gs_project.hotel.types.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class OperatorFrame extends MainFrame {
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
    protected final JScrollPane roomSelTreeScroller;
    protected final JScrollPane detAdressScroller;

    protected final JButton backButton;
    protected final JButton bookButton;
    protected final JButton checkInButton;

    protected final JButton checkOutButton;
    protected final JButton foodOrderButton;
    protected final JButton cancelBookingButton;
    protected final JButton detCardGenerateButton;
    protected final JButton roomSelSearchBtn;
    protected final JButton bookNextStepButton;
    protected final JButton bookCancelButton;
    protected final JButton checkButton;
    protected final JButton confirmCheckInButton;
    protected final JButton genBillButton;
    protected final JButton confirmCancelButton;
    protected final JButton orderMenuConfirmButton;
    protected final JButton orderMenuOrderClearButton;
    protected final JButton orderMenuRemoveButton;
    protected final JButton orderMenuAddButton;
    protected final JRadioButton orderMenuTypeHalfOption;
    protected final JRadioButton orderMenuTypeSingleOption;
    protected final JRadioButton orderMenuTypeDoubleOption;

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
    protected final JLabel roomPackageNameLabel;
    protected final JLabel roomPackage;
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
    protected final JLabel orderMenuTypeLabel;
    protected final JLabel orderMenuTypePricesLabel;
    protected final JLabel orderMenuQuantityLabel;
    protected final JLabel orderMenuHeader;
    protected final JLabel orderMenuTotalLabel;

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
    protected final JTextField orderMenuTypeHalfPriceBox;
    protected final JTextField orderMenuTypeDoublePriceBox;
    protected final JTextField orderMenuTypeSinglePriceBox;
    protected final JTextField orderMenuTotalBox;
    protected final JTextArea detAddressBox;
    protected final DatePicker roomSelCheckInBox;
    protected final DatePicker roomSelCheckOutBox;
    protected final JSpinner dateAdults;

    protected final JSpinner dateChildren;
    protected final JSpinner orderMenuQuantityBox;
    protected final DatePicker dateCheckInPicker;
    protected final DatePicker dateCheckoutPicker;
    protected final JTable orderMenuOrderTable;
    protected final ButtonGroup buttonGroup = new ButtonGroup();
    protected final JComboBox<String> detVerifyDocBox;
    protected final ArrayList<JButton> leftButtons = new ArrayList<>();
    protected JPanel menuOrderPanel;
    protected JScrollPane orderMenuPackageScroller;
    protected JScrollPane orderMenuOrderScroller;
    protected JTree orderMenuPackageTree;
    protected JTree roomSelRoomTypesTree;
    Visitor vis;
    int vis_index;
    double price;

    public OperatorFrame() {
        this("Operator Landing Page");
    }

    public OperatorFrame(String title) {
        super(title);

        RoomHelper.readFromFile();
        MenuHelper.readFromFile();
        VisitorHelper.readFromFile();
        OperatorHelper.readFromFile();

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


        bookButton = new JButton("Booking");
        bookButton.setFont(new Font("Verdana", Font.BOLD, 14));
        bookButton.setBounds(10, 11, 172, 32);
        contentPane.add(bookButton);
        leftButtons.add(bookButton);

        checkInButton = new JButton("Check In");
        checkInButton.setFont(new Font("Verdana", Font.BOLD, 14));
        checkInButton.setBounds(10, 54, 172, 32);
        contentPane.add(checkInButton);
        leftButtons.add(checkInButton);

        checkOutButton = new JButton("Check Out");
        checkOutButton.setFont(new Font("Verdana", Font.BOLD, 14));
        checkOutButton.setBounds(10, 97, 172, 32);
        contentPane.add(checkOutButton);
        leftButtons.add(checkOutButton);

        foodOrderButton = new JButton("Food Order");
        foodOrderButton.setFont(new Font("Verdana", Font.BOLD, 14));
        foodOrderButton.setBounds(10, 140, 172, 32);
        contentPane.add(foodOrderButton);
        leftButtons.add(foodOrderButton);

        cancelBookingButton = new JButton("Cancel Booking");
        cancelBookingButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelBookingButton.setBounds(10, 183, 172, 32);
        contentPane.add(cancelBookingButton);
        leftButtons.add(cancelBookingButton);


        addDateTimeToStatusBar();

        center();


        menuOrderPanel = new JPanel();
        menuOrderPanel.setBorder(new LineBorder(Color.GRAY));
        menuOrderPanel.setBounds(0, 0, 592, 549);
        menuOrderPanel.setLayout(null);

        orderMenuPackageScroller = new JScrollPane();
        orderMenuPackageScroller.setBounds(12, 72, 183, 421);
        menuOrderPanel.add(orderMenuPackageScroller);

        orderMenuPackageTree = ComponentHelper.setupTree(orderMenuPackageTree, "MENU");
        orderMenuPackageScroller.setViewportView(orderMenuPackageTree);
        orderMenuPackageTree.setFont(new Font("Tahoma", Font.PLAIN, 14));

        MenuHelper.loadDishesInTree(orderMenuPackageTree);

        orderMenuOrderScroller = new JScrollPane();
        orderMenuOrderScroller.setBounds(207, 204, 373, 289);
        menuOrderPanel.add(orderMenuOrderScroller);

        orderMenuOrderTable = ComponentHelper.createNewTable();
        ((DefaultTableModel) orderMenuOrderTable.getModel()).setColumnIdentifiers(Dish.getOrderColumns());
        orderMenuOrderScroller.setViewportView(orderMenuOrderTable);
        orderMenuOrderTable.setFillsViewportHeight(true);
        orderMenuOrderTable.setFont(new Font("Tahoma", Font.BOLD, 12));

        orderMenuHeader = new JLabel("MEALS ORDER - MENU");
        orderMenuHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        orderMenuHeader.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuHeader.setBounds(12, 12, 568, 48);
        menuOrderPanel.add(orderMenuHeader);

        orderMenuConfirmButton = new JButton("CONFIRM ORDER");
        orderMenuConfirmButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuConfirmButton.setBounds(423, 505, 157, 32);
        menuOrderPanel.add(orderMenuConfirmButton);

        orderMenuOrderClearButton = new JButton("CLEAR");
        orderMenuOrderClearButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuOrderClearButton.setBounds(376, 160, 96, 32);
        menuOrderPanel.add(orderMenuOrderClearButton);

        orderMenuRemoveButton = new JButton("REMOVE");
        orderMenuRemoveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuRemoveButton.setBounds(484, 160, 96, 32);
        menuOrderPanel.add(orderMenuRemoveButton);

        orderMenuTotalLabel = new JLabel("TOTAL:");
        orderMenuTotalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTotalLabel.setBounds(207, 505, 52, 32);
        menuOrderPanel.add(orderMenuTotalLabel);

        orderMenuTotalBox = new JTextField();
        orderMenuTotalBox.setEditable(false);
        orderMenuTotalBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTotalBox.setHorizontalAlignment(SwingConstants.RIGHT);
        orderMenuTotalBox.setBounds(277, 505, 134, 32);
        menuOrderPanel.add(orderMenuTotalBox);
        orderMenuTotalBox.setColumns(10);

        orderMenuAddButton = new JButton("ADD TO ORDER");
        orderMenuAddButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuAddButton.setBounds(376, 116, 204, 32);
        menuOrderPanel.add(orderMenuAddButton);

        orderMenuQuantityBox = new JSpinner();
        orderMenuQuantityBox.setBounds(475, 72, 105, 32);
        menuOrderPanel.add(orderMenuQuantityBox);

        orderMenuTypeHalfOption = new JRadioButton("Half");
        buttonGroup.add(orderMenuTypeHalfOption);
        orderMenuTypeHalfOption.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeHalfOption.setBounds(203, 112, 73, 24);
        menuOrderPanel.add(orderMenuTypeHalfOption);

        orderMenuTypeSingleOption = new JRadioButton("Single");
        buttonGroup.add(orderMenuTypeSingleOption);
        orderMenuTypeSingleOption.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeSingleOption.setBounds(203, 140, 73, 24);
        menuOrderPanel.add(orderMenuTypeSingleOption);

        orderMenuTypeDoubleOption = new JRadioButton("Double");
        buttonGroup.add(orderMenuTypeDoubleOption);
        orderMenuTypeDoubleOption.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeDoubleOption.setBounds(203, 168, 73, 24);
        menuOrderPanel.add(orderMenuTypeDoubleOption);

        orderMenuTypeLabel = new JLabel("<html><center>PLATE TYPE</center></html>");
        orderMenuTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuTypeLabel.setBounds(207, 74, 73, 30);
        menuOrderPanel.add(orderMenuTypeLabel);

        orderMenuTypePricesLabel = new JLabel("PRICES");
        orderMenuTypePricesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuTypePricesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypePricesLabel.setBounds(285, 74, 73, 30);
        menuOrderPanel.add(orderMenuTypePricesLabel);

        orderMenuTypeHalfPriceBox = new JTextField("");
        orderMenuTypeHalfPriceBox.setEditable(false);
        orderMenuTypeHalfPriceBox.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuTypeHalfPriceBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeHalfPriceBox.setBounds(285, 112, 73, 24);
        menuOrderPanel.add(orderMenuTypeHalfPriceBox);

        orderMenuTypeDoublePriceBox = new JTextField("");
        orderMenuTypeDoublePriceBox.setEditable(false);
        orderMenuTypeDoublePriceBox.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuTypeDoublePriceBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeDoublePriceBox.setBounds(285, 168, 73, 24);
        menuOrderPanel.add(orderMenuTypeDoublePriceBox);

        orderMenuTypeSinglePriceBox = new JTextField("");
        orderMenuTypeSinglePriceBox.setEditable(false);
        orderMenuTypeSinglePriceBox.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuTypeSinglePriceBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuTypeSinglePriceBox.setBounds(285, 140, 73, 24);
        menuOrderPanel.add(orderMenuTypeSinglePriceBox);

        orderMenuQuantityLabel = new JLabel("QUANTITY:");
        orderMenuQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderMenuQuantityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        orderMenuQuantityLabel.setBounds(376, 74, 81, 30);
        menuOrderPanel.add(orderMenuQuantityLabel);

        orderMenuQuantityBox.setEnabled(false);
        orderMenuTypeHalfOption.setEnabled(false);
        orderMenuTypeSingleOption.setEnabled(false);
        orderMenuTypeDoubleOption.setEnabled(false);
        orderMenuAddButton.setEnabled(false);

        orderMenuRemoveButton.setEnabled(false);

        bookingPanel = new JPanel();
        bookingPanel.setBounds(0, 0, 592, 549);
        bookingPanel.setBorder(new LineBorder(Color.GRAY));
        bookingPanel.setLayout(null);

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


        currentStepPanel = new JPanel();
        currentStepPanel.setBorder(new LineBorder(Color.GRAY));
        currentStepPanel.setBounds(0, 47, 592, 458);
        bookingPanel.add(currentStepPanel);
        currentStepPanel.setLayout(null);


        confirmPanel = new JPanel();
        confirmPanel.setLayout(null);
        confirmPanel.setBounds(10, 11, 572, 437);

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


        detailsPanel = new JPanel();
        detailsPanel.setBounds(10, 11, 572, 437);
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

        detAdressScroller = new JScrollPane();
        detAdressScroller.setBounds(245, 276, 317, 98);
        detailsPanel.add(detAdressScroller);

        detAddressBox = new JTextArea();
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

        detVerifyDocBox = new JComboBox<>(new String[]{"AADHAR", "VOTER ID", "ELECTRICITY BILL"});
        detVerifyDocBox.setBounds(245, 394, 317, 32);
        detailsPanel.add(detVerifyDocBox);

        detCardGenerateButton = new JButton("GENERATE");
        detCardGenerateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        detCardGenerateButton.setBounds(466, 76, 96, 32);
        detailsPanel.add(detCardGenerateButton);


        roomSelectionPanel = new JPanel();
        roomSelectionPanel.setBounds(10, 11, 572, 437);
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

        roomSelRoomTypesTree = ComponentHelper.setupTree(roomSelRoomTypesTree, "ROOM");
        roomSelTreeScroller.setViewportView(roomSelRoomTypesTree);

        roomSelRoomNoBox = new JTextField();
        roomSelRoomNoBox.setBounds(127, 240, 162, 32);
        roomSelectionPanel.add(roomSelRoomNoBox);
        roomSelRoomNoBox.setEditable(false);
        roomSelRoomNoBox.setColumns(10);

        roomSelCheckInBox = new DatePicker();
        roomSelCheckInBox.setBounds(127, 93, 162, 32);
        roomSelectionPanel.add(roomSelCheckInBox);
        datePickerSettings(roomSelCheckInBox);
        roomSelCheckInBox.setDateToToday();

        roomSelCheckOutBox = new DatePicker();
        roomSelCheckOutBox.setBounds(127, 169, 162, 32);
        roomSelectionPanel.add(roomSelCheckOutBox);
        datePickerSettings(roomSelCheckOutBox);
        roomSelCheckOutBox.setDateToToday();


        datesPeoplePanel = new JPanel();
        datesPeoplePanel.setLayout(null);
        datesPeoplePanel.setBounds(10, 11, 572, 437);

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
        datePickerSettings(dateCheckInPicker);
        dateCheckInPicker.setDateToToday();


        dateCheckoutPicker = new DatePicker();
        dateCheckoutPicker.setBounds(312, 178, 230, 32);
        datesPeoplePanel.add(dateCheckoutPicker);
        datePickerSettings(dateCheckoutPicker);
        dateCheckoutPicker.setDateToToday();


        bookNextStepButton = new JButton("NEXT STEP");
        bookNextStepButton.setBounds(402, 511, 180, 32);
        bookingPanel.add(bookNextStepButton);
        bookNextStepButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        bookCancelButton = new JButton("CANCEL");
        bookCancelButton.setBounds(296, 511, 96, 32);
        bookingPanel.add(bookCancelButton);
        bookCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));


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

        custName = new JLabel("");
        custName.setBounds(218, 0, 334, 32);
        bookInfoPanel.add(custName);
        custName.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomPackageNameLabel = new JLabel("PACKAGE:");
        roomPackageNameLabel.setBounds(0, 35, 208, 32);
        bookInfoPanel.add(roomPackageNameLabel);
        roomPackageNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomPackage = new JLabel("");
        roomPackage.setBounds(218, 35, 334, 32);
        bookInfoPanel.add(roomPackage);
        roomPackage.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkInLabel = new JLabel("CHECK IN DATE:");
        checkInLabel.setBounds(0, 78, 208, 32);
        bookInfoPanel.add(checkInLabel);
        checkInLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkInDate = new JLabel("");
        checkInDate.setBounds(218, 78, 334, 32);
        bookInfoPanel.add(checkInDate);
        checkInDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkOutLabel = new JLabel("CHECK OUT DATE:");
        checkOutLabel.setBounds(0, 121, 208, 32);
        bookInfoPanel.add(checkOutLabel);
        checkOutLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        checkOutDate = new JLabel("");
        checkOutDate.setBounds(218, 121, 334, 32);
        bookInfoPanel.add(checkOutDate);
        checkOutDate.setFont(new Font("Tahoma", Font.BOLD, 14));

        totalPriceLabel = new JLabel("TOTAL PRICE:");
        totalPriceLabel.setBounds(0, 196, 208, 32);
        bookInfoPanel.add(totalPriceLabel);
        totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        totalPrice = new JLabel("");
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


        cancelBookingPanel = new JPanel();
        cancelBookingPanel.setBounds(0, 0, 592, 549);
        cancelBookingPanel.setBorder(new LineBorder(Color.GRAY));
        cancelBookingPanel.setLayout(null);

        confirmCancelPanel = new JPanel();
        confirmCancelPanel.setLayout(null);
        confirmCancelPanel.setBounds(10, 117, 572, 421);
        cancelBookingPanel.add(confirmCancelPanel);

        confirmCancelButton = new JButton("CONFIRM CANCEL");
        confirmCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        confirmCancelButton.setBounds(288, 378, 274, 32);
        confirmCancelPanel.add(confirmCancelButton);


        orderMenuConfirmButton.addActionListener(e -> {
            if (orderMenuOrderTable.getRowCount() > 0) {
                StringBuilder entry = new StringBuilder("FOOD ORDER: (");
                double cprice = 0;
                for (int i = 0; i < orderMenuOrderTable.getRowCount(); i++) {
                    String name = orderMenuOrderTable.getValueAt(i, 0).toString();
                    String plate = orderMenuOrderTable.getValueAt(i, 1).toString();
                    String quantity = orderMenuOrderTable.getValueAt(i, 2).toString();
                    cprice += Double.valueOf(orderMenuOrderTable.getValueAt(i, 3).toString().substring(2));
                    entry.append(plate).append("-").append(name).append(" x").append(quantity);
                    if (i < orderMenuOrderTable.getRowCount() - 1) {
                        entry.append(", ");
                    } else {
                        entry.append(")");
                    }
                }
                int visIndex = -1;
                int index = -1;

                int payNow = JOptionPane.showConfirmDialog(OperatorFrame.this, "Complete payment now?", "Pay Now", JOptionPane.YES_NO_OPTION);

                String bookingID = JOptionPane.showInputDialog(OperatorFrame.this, "Please enter the booking id:", "Booking ID", JOptionPane.OK_CANCEL_OPTION);

                while (bookingID == null || bookingID.isEmpty()) {
                    int ret = JOptionPane.showConfirmDialog(OperatorFrame.this, "Booking ID can't be empty! Do you want to cancel the confirmation?", "Invalid Booking ID", JOptionPane.YES_NO_OPTION);
                    if (ret == JOptionPane.NO_OPTION) {
                        return;
                    }
                    bookingID = JOptionPane.showInputDialog(OperatorFrame.this, "Please enter the booking id:", "Booking ID", JOptionPane.OK_CANCEL_OPTION);
                }

                do {
                    for (int j = 0; j < VisitorHelper.visitors.size(); j++) {
                        Visitor v = VisitorHelper.visitors.get(j);
                        for (int i = 0; i < v.getBookings().size(); i++) {
                            if (bookingID.equals(v.getBookings().get(i).getId())) {
                                index = i;
                                visIndex = j;
                                break;
                            }
                        }
                        if (visIndex > -1 && index > -1) {
                            break;
                        }
                    }

                    if (visIndex > -1 && index > -1) {
                        Transaction tr = new Transaction(IDGenerator.generate().substring(7), bookingID, (int) cprice, LocalDate.now().toString(), (payNow == JOptionPane.YES_OPTION ? "[PAID]" : "[PENDING]") + entry.toString());

                        VisitorHelper.visitors.get(visIndex).getBookings().get(index).getTransactions().add(tr);
                        JOptionPane.showMessageDialog(OperatorFrame.this, "SUCCESS");
                        resetPanels();
                        setPanel(null, rightPanel);
                        return;
                    } else {
                        int ret = JOptionPane.showConfirmDialog(OperatorFrame.this, "Booking ID not found!  Do you want to cancel the confirmation?", "Invalid Booking ID", JOptionPane.YES_NO_OPTION);
                        if (ret == JOptionPane.NO_OPTION) {
                            return;
                        }
                        bookingID = "";
                    }
                } while (bookingID.isEmpty());
            }
        });

        orderMenuAddButton.addActionListener(e -> {
            String plate = "";
            double multiplier = 1;
            if (orderMenuTypeHalfOption.isSelected()) {
                plate = "HALF";
                multiplier = 0.7;
            } else if (orderMenuTypeSingleOption.isSelected()) {
                plate = "SINGLE";
                multiplier = 1;
            } else if (orderMenuTypeDoubleOption.isSelected()) {
                plate = "DOUBLE";
                multiplier = 1.85;
            }
            if (plate.isEmpty()) {
                JOptionPane.showMessageDialog(OperatorFrame.this, "You must select Plate Type.", "Plate Type error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int quantity = 0;
            try {
                quantity = Integer.valueOf(orderMenuQuantityBox.getValue().toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(OperatorFrame.this, "You must enter a valid quantity.", "Quantity error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                DefaultMutableTreeNode dishNode = (DefaultMutableTreeNode) orderMenuPackageTree.getLastSelectedPathComponent();
                if (dishNode == null) return;

                DefaultMutableTreeNode typeNode = (DefaultMutableTreeNode) dishNode.getParent();
                if (typeNode == null) return;

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) typeNode.getParent();
                if (node == null) return;

                int ind = MenuHelper.getClassIndex(new TreePath(node.getPath()));

                if (ind > -1) {
                    MenuPackage menuPackage = MenuHelper.menuPackages.get(ind);
                    DefaultTableModel model = (DefaultTableModel) orderMenuOrderTable.getModel();
                    if (typeNode.toString().equals("STARTERS")) {
                        for (Dish d : menuPackage.getStarters()) {
                            if (d.getName().equals(dishNode.toString().split("\t")[0])) {
                                model.addRow(new Object[]{d.getName(), plate, quantity, "₹ " + Math.floor(multiplier * quantity * d.getPrice())});
                            }
                        }
                    } else if (typeNode.toString().equals("DESSERTS")) {
                        for (Dish d : menuPackage.getDesserts()) {
                            if (d.getName().equals(dishNode.toString().split("\t")[0])) {
                                model.addRow(new Object[]{d.getName(), plate, quantity, "₹ " + Math.floor(multiplier * quantity * d.getPrice())});
                            }
                        }
                    } else if (typeNode.toString().equals("MAIN-COURSE")) {
                        for (Dish d : menuPackage.getMaincourse()) {
                            if (d.getName().equals(dishNode.toString().split("\t")[0])) {
                                model.addRow(new Object[]{d.getName(), plate, quantity, "₹ " + Math.floor(multiplier * quantity * d.getPrice())});
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(OperatorFrame.this, "Invalid dish or Currently Unavailable.", "DISH NOT FOUND", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(OperatorFrame.this, "Invalid dish or Currently Unavailable.", "DISH NOT FOUND", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception ignored) {
            }
            int totalPrice = 0;
            int invalid = 0;
            for (int i = 0; i < orderMenuOrderTable.getRowCount(); i++) {
                try {
                    totalPrice += Double.valueOf(orderMenuOrderTable.getValueAt(i, 3).toString().substring(2));
                } catch (NumberFormatException nfe) {
                    invalid++;
                    ((DefaultTableModel) orderMenuOrderTable.getModel()).removeRow(i);
                }
            }
            if (invalid > 0) {
                JOptionPane.showMessageDialog(OperatorFrame.this, "Removed " + invalid + " invalid entries.", "Invalid Entries", JOptionPane.WARNING_MESSAGE);
            }
            orderMenuTotalBox.setText("₹ " + (double) totalPrice);
        });

        orderMenuOrderTable.getSelectionModel().addListSelectionListener(e -> {
            int ind = orderMenuOrderTable.getSelectedRow();
            if (ind > -1) {
                orderMenuRemoveButton.setEnabled(true);
            } else {
                orderMenuRemoveButton.setEnabled(false);
            }
        });

        orderMenuOrderClearButton.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) orderMenuOrderTable.getModel();
            model.setRowCount(0);
        });

        orderMenuRemoveButton.addActionListener(e -> {
            int ind = orderMenuOrderTable.getSelectedRow();
            if (ind > -1) {
                DefaultTableModel model = (DefaultTableModel) orderMenuOrderTable.getModel();
                model.removeRow(ind);
            } else {
                JOptionPane.showMessageDialog(OperatorFrame.this, "Invalid Order entry.", "Order Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
        orderMenuPackageTree.addTreeSelectionListener(e -> {
            try {
                DefaultMutableTreeNode dishNode = (DefaultMutableTreeNode) orderMenuPackageTree.getLastSelectedPathComponent();
                if (dishNode == null) return;

                DefaultMutableTreeNode typeNode = (DefaultMutableTreeNode) dishNode.getParent();
                if (typeNode == null) return;

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) typeNode.getParent();
                if (node == null) return;

                int ind = MenuHelper.getClassIndex(new TreePath(node.getPath()));
                if (ind > -1) {
                    MenuPackage menuPackage = MenuHelper.menuPackages.get(ind);
                    if (typeNode.toString().equals("STARTERS")) {
                        for (Dish d : menuPackage.getStarters()) {
                            if (d.getName().equals(dishNode.toString().split("\t")[0])) {
                                orderMenuTypeHalfPriceBox.setText("₹ " + Math.ceil(.7 * d.getPrice()));
                                orderMenuTypeSinglePriceBox.setText("₹ " + Math.ceil(d.getPrice()));
                                orderMenuTypeDoublePriceBox.setText("₹ " + Math.floor(1.85 * d.getPrice()));
                                orderMenuQuantityBox.setModel(new SpinnerNumberModel(d.getMinQuantity(), d.getMinQuantity(), d.getMaxQuantity(), 1));
                                orderMenuQuantityBox.setEnabled(true);
                                orderMenuTypeHalfOption.setEnabled(true);
                                orderMenuTypeSingleOption.setEnabled(true);
                                orderMenuTypeDoubleOption.setEnabled(true);
                                orderMenuAddButton.setEnabled(true);
                                break;
                            } else {
                                orderMenuTypeHalfPriceBox.setText("");
                                orderMenuTypeSinglePriceBox.setText("");
                                orderMenuTypeDoublePriceBox.setText("");
                                orderMenuQuantityBox.setModel(new SpinnerNumberModel());
                                orderMenuQuantityBox.setValue(0);
                                orderMenuQuantityBox.setEnabled(false);
                                orderMenuTypeHalfOption.setEnabled(false);
                                orderMenuTypeSingleOption.setEnabled(false);
                                orderMenuTypeDoubleOption.setEnabled(false);
                                orderMenuAddButton.setEnabled(false);
                            }
                        }
                    } else if (typeNode.toString().equals("DESSERTS")) {
                        for (Dish d : menuPackage.getDesserts()) {
                            if (d.getName().equals(dishNode.toString().split("\t")[0])) {
                                orderMenuTypeHalfPriceBox.setText("₹ " + Math.ceil(.7 * d.getPrice()));
                                orderMenuTypeSinglePriceBox.setText("₹ " + Math.ceil(d.getPrice()));
                                orderMenuTypeDoublePriceBox.setText("₹ " + Math.floor(1.85 * d.getPrice()));
                                orderMenuQuantityBox.setModel(new SpinnerNumberModel(d.getMinQuantity(), d.getMinQuantity(), d.getMaxQuantity(), 1));
                                orderMenuQuantityBox.setEnabled(true);
                                orderMenuTypeHalfOption.setEnabled(true);
                                orderMenuTypeSingleOption.setEnabled(true);
                                orderMenuTypeDoubleOption.setEnabled(true);
                                orderMenuAddButton.setEnabled(true);
                                break;
                            } else {
                                orderMenuTypeHalfPriceBox.setText("");
                                orderMenuTypeSinglePriceBox.setText("");
                                orderMenuTypeDoublePriceBox.setText("");
                                orderMenuQuantityBox.setModel(new SpinnerNumberModel());
                                orderMenuQuantityBox.setValue(0);
                                orderMenuQuantityBox.setEnabled(false);
                                orderMenuTypeHalfOption.setEnabled(false);
                                orderMenuTypeSingleOption.setEnabled(false);
                                orderMenuTypeDoubleOption.setEnabled(false);
                                orderMenuAddButton.setEnabled(false);
                            }
                        }
                    } else if (typeNode.toString().equals("MAIN-COURSE")) {
                        for (Dish d : menuPackage.getMaincourse()) {
                            if (d.getName().equals(dishNode.toString().split("\t")[0])) {
                                orderMenuTypeHalfPriceBox.setText("₹ " + Math.ceil(.7 * d.getPrice()));
                                orderMenuTypeSinglePriceBox.setText("₹ " + Math.ceil(d.getPrice()));
                                orderMenuTypeDoublePriceBox.setText("₹ " + Math.floor(1.85 * d.getPrice()));
                                orderMenuQuantityBox.setModel(new SpinnerNumberModel(d.getMinQuantity(), d.getMinQuantity(), d.getMaxQuantity(), 1));
                                orderMenuQuantityBox.setEnabled(true);
                                orderMenuTypeHalfOption.setEnabled(true);
                                orderMenuTypeSingleOption.setEnabled(true);
                                orderMenuTypeDoubleOption.setEnabled(true);
                                orderMenuAddButton.setEnabled(true);
                                break;
                            } else {
                                orderMenuTypeHalfPriceBox.setText("");
                                orderMenuTypeSinglePriceBox.setText("");
                                orderMenuTypeDoublePriceBox.setText("");
                                orderMenuQuantityBox.setModel(new SpinnerNumberModel());
                                orderMenuQuantityBox.setValue(0);
                                orderMenuQuantityBox.setEnabled(false);
                                orderMenuTypeHalfOption.setEnabled(false);
                                orderMenuTypeSingleOption.setEnabled(false);
                                orderMenuTypeDoubleOption.setEnabled(false);
                                orderMenuAddButton.setEnabled(false);
                            }
                        }
                    } else {
                        orderMenuTypeHalfPriceBox.setText("");
                        orderMenuTypeSinglePriceBox.setText("");
                        orderMenuTypeDoublePriceBox.setText("");
                        orderMenuQuantityBox.setModel(new SpinnerNumberModel());
                        orderMenuQuantityBox.setValue(0);
                        orderMenuQuantityBox.setEnabled(false);
                        orderMenuTypeHalfOption.setEnabled(false);
                        orderMenuTypeSingleOption.setEnabled(false);
                        orderMenuTypeDoubleOption.setEnabled(false);
                        orderMenuAddButton.setEnabled(false);
                    }
                } else {
                    orderMenuTypeHalfPriceBox.setText("");
                    orderMenuTypeSinglePriceBox.setText("");
                    orderMenuTypeDoublePriceBox.setText("");
                    orderMenuQuantityBox.setModel(new SpinnerNumberModel());
                    orderMenuQuantityBox.setValue(0);
                    orderMenuQuantityBox.setEnabled(false);
                    orderMenuTypeHalfOption.setEnabled(false);
                    orderMenuTypeSingleOption.setEnabled(false);
                    orderMenuTypeDoubleOption.setEnabled(false);
                    orderMenuAddButton.setEnabled(false);
                }
            } catch (Exception ignored) {
            }
        });

        confirmCheckInButton.addActionListener(e -> {
            for (RoomClass rc : RoomHelper.roomClasses) {
                for (Room r : rc.getRooms()) {
                    for (Booking b : r.getBookings()) {
                        if (bookId.getText().equals(b.getId())) {
                            if (b.getBookingstate().equals("CANCELLED") || b.getBookingstate().equals("CHECKED OUT") || b.getBookingstate().equals("CHECKED IN")) {
                                JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING ALREADY CHECKED IN, CHECKED OUT OR CANCELLED!", "ERROR IN BOOKING STATUS", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if (LocalDate.parse(b.getCheckindate()).isAfter(LocalDate.now()) || LocalDate.parse(b.getCheckoutdate()).isBefore(LocalDate.now())) {
                                JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING NOT ACTIVE YET OR ALREADY EXPIRED!", "ERROR IN BOOKING DATE", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            b.setBookingstate("CHECKED IN");
                            break;
                        }
                    }
                }
            }
            for (Visitor vs : VisitorHelper.visitors) {
                for (Booking b : vs.getBookings()) {
                    if (bookId.getText().equals(b.getId())) {
                        b.setBookingstate("CHECKED IN");
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(OperatorFrame.this, "CHECK IN SUCCESSFUL!", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);

            resetPanels();
            setPanel(null, rightPanel);
        });

        confirmCancelButton.addActionListener(e -> {
            for (RoomClass rc : RoomHelper.roomClasses) {
                for (Room r : rc.getRooms()) {
                    for (Booking b : r.getBookings()) {
                        if (bookId.getText().equals(b.getId())) {
                            if (b.getBookingstate().equals("CANCELLED") || b.getBookingstate().equals("CHECKED OUT") || b.getBookingstate().equals("CHECKED IN")) {
                                JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING ALREADY CHECKED IN, CHECKED OUT OR CANCELLED!", "ERROR IN BOOKING STATUS", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if (LocalDate.parse(b.getCheckoutdate()).isBefore(LocalDate.now())) {
                                JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING ALREADY EXPIRED!", "ERROR IN BOOKING DATE", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            b.setBookingstate("CANCELLED");
                            break;
                        }
                    }
                }
            }
            for (Visitor vs : VisitorHelper.visitors) {
                for (Booking b : vs.getBookings()) {
                    if (bookId.getText().equals(b.getId())) {
                        b.setBookingstate("CANCELLED");
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING HAS BEEN CANCELLED!", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);

            resetPanels();
            setPanel(null, rightPanel);
        });

        genBillButton.addActionListener(e -> {
            int packageprice = 0;
            int paidprice = 0;
            int servprice = 0;

            Visitor v = null;
            Booking bx = null;

            ArrayList<Transaction> trans = new ArrayList<>();

            for (RoomClass rc : RoomHelper.roomClasses) {
                for (Room r : rc.getRooms()) {
                    for (Booking b : r.getBookings()) {
                        if (bookId.getText().equals(b.getId())) {
                            if (!b.getBookingstate().equals("CHECKED IN")) {
                                JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING IS NOT ACTIVE!", "ERROR IN BOOKING STATUS", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            if (LocalDate.parse(b.getCheckoutdate()).isBefore(LocalDate.now())) {
                                JOptionPane.showMessageDialog(OperatorFrame.this, "BOOKING ALREADY EXPIRED!", "ERROR IN BOOKING DATE", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            b.setBookingstate("CHECKED OUT");
                            for (Transaction t : b.getTransactions()) {
                                packageprice += t.getValue();
                                if (t.getDetails().contains("[PAID]")) {
                                    paidprice += t.getValue();
                                }
                            }
                            trans.add(new Transaction("", b.getId(), packageprice, b.getBookingdate(), "[PACKAGE] " + rc.getType()));
                            break;
                        }
                    }
                }
            }

            for (Visitor vs : VisitorHelper.visitors) {
                for (Booking b : vs.getBookings()) {
                    if (bookId.getText().equals(b.getId())) {
                        b.setBookingstate("CHECKED OUT");
                        for (Transaction t : b.getTransactions()) {
                            servprice += t.getValue();
                            if (t.getDetails().contains("[PAID]")) {
                                paidprice += t.getValue();
                            }
                            trans.add(t);
                        }
                        v = vs;
                        bx = b;
                        break;
                    }
                }
            }

            if (v != null && bx != null) {
                Bill bill = new Bill(v.getName(), v.getCardId(), bx.getCheckindate(), bx.getCheckoutdate(), packageprice, servprice, paidprice);

                ((DefaultTableModel) bill.getTransactionTable().getModel()).setDataVector(Transaction.toBillingObjectsArray(trans), Transaction.getBillingColumns());

                bill.setTableColumnWidths();
                bill.setVisible(true);
                JOptionPane.showMessageDialog(bill, "CHECK OUT CONFIRMED! PLEASE MAKE SURE TO SAVE OR PRINT YOUR RECEIPT!", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);

                resetPanels();
                setPanel(null, rightPanel);
            }
        });

        checkOutButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, checkOutButton);
            checkOutHeader.setText("CHECK OUT");
            checkOutPanel.add(checkBookIdPanel);
            billingPanel.add(bookInfoPanel);

            backButton.setBounds(20, 495, 129, 32);
            checkOutPanel.add(backButton);

            billingPanel.setVisible(false);

            setPanel(checkOutPanel, rightPanel);
        });

        checkInButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, checkInButton);
            checkOutHeader.setText("CHECK IN");
            checkInPanel.add(checkBookIdPanel);
            confirmCheckInPanel.add(bookInfoPanel);

            backButton.setBounds(20, 495, 129, 32);
            checkInPanel.add(backButton);

            confirmCheckInPanel.setVisible(false);

            setPanel(checkInPanel, rightPanel);
        });

        bookButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, bookButton);
            backButton.setBounds(10, 511, 129, 32);
            bookingPanel.add(backButton);

            setPanel(bookingPanel, rightPanel);

            setStep(datesPeopleStep, stepsPanel);
            setPanel(datesPeoplePanel, currentStepPanel);
        });
        bookNextStepButton.addActionListener(e -> {
            if (datesPeopleStep.isEnabled()) {
                if ((int) dateAdults.getValue() <= 0) {
                    JOptionPane.showMessageDialog(this, "PLEASE SELECT ADULTS", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!dateCheckoutPicker.getDate().isAfter(dateCheckInPicker.getDate())) {
                    JOptionPane.showMessageDialog(this, "PLEASE CHANGE CHECK OUT DATE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                roomSelCheckInBox.setDate(dateCheckInPicker.getDate());
                roomSelCheckOutBox.setDate(dateCheckoutPicker.getDate());

                confirmAdultsBox.setText(String.valueOf(dateAdults.getValue()));
                confirmChildrenBox.setText(String.valueOf(dateChildren.getValue()));

                bookNextStepButton.setText("NEXT STEP");
                setStep(roomSelectStep, stepsPanel);
                setPanel(roomSelectionPanel, currentStepPanel);
            } else if (roomSelectStep.isEnabled()) {
                if (roomselPriceBox.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "SEARCH FOR ROOMS FIRST", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!roomSelCheckOutBox.getDate().isAfter(roomSelCheckInBox.getDate())) {
                    JOptionPane.showMessageDialog(this, "PLEASE CHANGE CHECK OUT DATE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                confirmCheckInBox.setText(roomSelCheckInBox.getDate().toString());
                confirmCheckOutBox.setText(roomSelCheckOutBox.getDate().toString());

                confirmRoomPackageBox.setText(roomSelRoomNoBox.getText());

                price = Integer.valueOf(roomselPriceBox.getText());
                confirmPriceBox.setText(Math.ceil(.7 * price) + " + " + Math.ceil(.3 * price) + " (INITIAL)");

                bookNextStepButton.setText("NEXT STEP");
                setStep(detailsStep, stepsPanel);
                setPanel(detailsPanel, currentStepPanel);
            } else if (detailsStep.isEnabled()) {
                if (detCardNumBox.getText().isEmpty() || !ValidateHelper.validateCardNumber(detCardNumBox.getText())) {
                    JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR CARD NUMBER", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (detVisitorNameBox.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR NAME FIRST", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!ValidateHelper.validatePhone("+91" + detPhoneNumBox.getText())) {
                    JOptionPane.showMessageDialog(this, "PHONE NUMBER NOT ACCEPTED", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!ValidateHelper.validateEmail(detEmailBox.getText())) {
                    JOptionPane.showMessageDialog(this, "EMAIL NOT ACCEPTED", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                vis_index = searchCard();
                vis = new Visitor(detCardNumBox.getText(), detVisitorNameBox.getText(), detEmailBox.getText(), detPhoneNumBox.getText(), detAddressBox.getText(), detVerifyDocBox.getSelectedItem().toString(), new ArrayList<>());

                confirmCustNameBox.setText(detVisitorNameBox.getText());
                confirmCardNumBox.setText(detCardNumBox.getText());

                bookNextStepButton.setText("CONFIRM BOOKING");
                setStep(confirmStep, stepsPanel);
                setPanel(confirmPanel, currentStepPanel);
            } else if (confirmStep.isEnabled()) {
                Booking booking = new Booking(IDGenerator.generate().substring(5), LocalDate.now().toString(), confirmCheckInBox.getText(), confirmCheckOutBox.getText(), "CURRENT");
                Booking b = new Booking(booking.getId(), LocalDate.now().toString(), confirmCheckInBox.getText(), confirmCheckOutBox.getText(), "CURRENT");

                double amount = Double.valueOf(confirmPriceBox.getText().replace("(INITIAL)", "").split("\\+")[1]);

                int x = JOptionPane.showConfirmDialog(OperatorFrame.this, "Please pay Rs. " + amount + " before proceeding!", "Pay initial amount.", JOptionPane.OK_CANCEL_OPTION);

                if (x == JOptionPane.CANCEL_OPTION) {
                    bookCancelButton.doClick();
                    return;
                }

                vis.getBookings().add(b);

                booking.getTransactions().add(new Transaction(IDGenerator.generate().substring(7), booking.getId(), (int) amount, booking.getBookingdate(), "[PAID]INITIAL PAYMENT"));
                booking.getTransactions().add(new Transaction(IDGenerator.generate().substring(7), booking.getId(), (int) (price - amount), booking.getBookingdate(), "[PENDING]REMAINING PACKAGE PRICE"));

                if (vis_index < 0) {
                    VisitorHelper.visitors.add(vis);
                } else {
                    VisitorHelper.visitors.set(vis_index, vis);
                }
                boolean found = false;
                for (RoomClass rc : RoomHelper.roomClasses) {
                    if (rc.getType().equals(confirmRoomPackageBox.getText())) {
                        for (Room r : rc.getRooms()) {
                            if (r.getBookings().size() == 0) {
                                r.getBookings().add(booking);
                                found = true;
                            } else if (LocalDate.parse(confirmCheckInBox.getText()).isAfter(LocalDate.parse(r.getBookings().get(r.getBookings().size() - 1).getCheckoutdate()))) {
                                r.getBookings().add(r.getBookings().size(), booking);
                                found = true;
                            } else if (LocalDate.parse(confirmCheckOutBox.getText()).isBefore(LocalDate.parse(r.getBookings().get(0).getCheckoutdate()))) {
                                r.getBookings().add(0, booking);
                                found = true;
                            } else {
                                for (int i = 0; i < r.getBookings().size() - 1; i++) {
                                    if (LocalDate.parse(confirmCheckInBox.getText()).isAfter(LocalDate.parse(r.getBookings().get(i).getCheckoutdate())) && LocalDate.parse(confirmCheckOutBox.getText()).isBefore(LocalDate.parse(r.getBookings().get(i + 1).getCheckindate()))) {
                                        r.getBookings().add(i, booking);
                                        found = true;
                                        break;
                                    }
                                }
                            }

                            if (found) {
                                r.getBookings().sort(Comparator.comparing(o -> LocalDate.parse(o.getCheckindate())));
                                Receipt receipt = new Receipt(booking.getId(), vis.getCardId(), (int) amount, rc.getType());
                                receipt.setVisible(true);
                                JOptionPane.showMessageDialog(receipt, "BOOKING CONFIRMED! PLEASE MAKE SURE TO SAVE OR PRINT YOUR RECEIPT!", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);

                                resetPanels();
                                setPanel(null, rightPanel);
                                break;
                            }
                        }
                        break;
                    }
                }

                bookNextStepButton.setText("NEXT STEP");
                setStep(datesPeopleStep, stepsPanel);
                setPanel(datesPeoplePanel, currentStepPanel);
            } else {
                bookNextStepButton.setText("NEXT STEP");
                setStep(datesPeopleStep, stepsPanel);
                setPanel(datesPeoplePanel, currentStepPanel);
            }
        });

        roomSelRoomTypesTree.addTreeSelectionListener(e -> {
            try {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) roomSelRoomTypesTree.getSelectionPath().getLastPathComponent();

                if (node == null) return;
                int ind = RoomHelper.getClassIndex(new TreePath(node.getPath()));

                int days = roomSelCheckInBox.getDate().until(roomSelCheckOutBox.getDate()).getDays();
                if (ind > -1) {
                    RoomClass rc = RoomHelper.roomClasses.get(ind);
                    roomselPriceBox.setText("" + (days * rc.getPrice()));
                    roomSelRoomNoBox.setText("" + rc.getType());
                } else {
                    roomselPriceBox.setText("");
                }
            } catch (Exception ignored) {
            }
        });

        backButton.addActionListener(e -> {
            if (bookButton.isEnabled()) {
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
                    resetPanels();
                }
            } else {
                resetPanels();
            }
            setPanel(null, rightPanel);
        });

        bookCancelButton.addActionListener(e -> {
            resetPanels();
            setPanel(null, rightPanel);
        });

        cancelBookingButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, cancelBookingButton);
            checkOutHeader.setText("CANCEL BOOKING");
            cancelBookingPanel.add(checkBookIdPanel);
            confirmCancelPanel.add(bookInfoPanel);

            backButton.setBounds(20, 495, 129, 32);
            cancelBookingPanel.add(backButton);

            confirmCancelPanel.setVisible(false);

            setPanel(cancelBookingPanel, rightPanel);
        });

        foodOrderButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, foodOrderButton);
            backButton.setBounds(12, 505, 180, 32);
            menuOrderPanel.add(backButton);

            setPanel(menuOrderPanel, rightPanel);
        });

        checkButton.addActionListener(e -> {
            if (bookId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "PLEASE ENTER BOOKING ID TO CONTINUE", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                boolean found = false;
                for (RoomClass rc : RoomHelper.roomClasses) {
                    for (Room r : rc.getRooms()) {
                        for (Booking b : r.getBookings()) {
                            if (bookId.getText().equals(b.getId())) {
                                checkInDate.setText(b.getCheckindate());
                                checkOutDate.setText(b.getCheckoutdate());
                                roomPackage.setText(rc.getType());
                                int initial = 0;
                                int total = 0;
                                for (Transaction t : b.getTransactions()) {
                                    if (t.getDetails().startsWith("[PAID]")) {
                                        initial += t.getValue();
                                    }
                                    total += t.getValue();
                                }
                                totalPrice.setText("" + total);
                                initPaymentBox.setText("" + initial);
                                roomNumBox.setText("" + r.getRoomNo());
                                int x = (total * 28 / 100);
                                gstBox.setText("" + x);
                                amountBox.setText("" + (x + total - initial));
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                    if (found) break;
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "PLEASE ENTER CORRECT BOOKING ID TO CONTINUE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    backButton.setBounds(20, 495, 129, 32);
                    if (checkOutHeader.getText().equals("CHECK IN")) {
                        confirmCheckInPanel.setVisible(false);
                        confirmCheckInPanel.add(backButton);
                    } else if (checkOutHeader.getText().equals("CHECK OUT")) {
                        billingPanel.setVisible(false);
                        billingPanel.add(backButton);
                    } else {
                        confirmCancelPanel.setVisible(false);
                        confirmCancelPanel.add(backButton);
                    }
                    return;
                }
                for (Visitor vs : VisitorHelper.visitors) {
                    for (Booking b : vs.getBookings()) {
                        if (bookId.getText().equals(b.getId())) {
                            custName.setText(vs.getName());
                            break;
                        }
                    }
                }
                backButton.setBounds(10, 378, 129, 32);
                if (checkOutHeader.getText().equals("CHECK IN")) {
                    confirmCheckInPanel.setVisible(true);
                    confirmCheckInPanel.add(backButton);
                } else if (checkOutHeader.getText().equals("CHECK OUT")) {
                    billingPanel.setVisible(true);
                    billingPanel.add(backButton);
                } else {
                    confirmCancelPanel.setVisible(true);
                    confirmCancelPanel.add(backButton);
                }
            }
        });

        detCardNumBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                populateVisitor(searchCard());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                populateVisitor(searchCard());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                populateVisitor(searchCard());
            }
        });

        detCardGenerateButton.addActionListener(e -> {
            detCardNumBox.setText(IDGenerator.generate());
        });

        roomSelSearchBtn.addActionListener(e -> {
            ArrayList<RoomClass> classes = new ArrayList<>();

            for (RoomClass rc : RoomHelper.roomClasses) {
                for (Room r : rc.getRooms()) {
                    boolean found = false;
                    if (r.getBookings().size() == 0) {
                        classes.add(rc);
                        break;
                    } else if (roomSelCheckInBox.getDate().isAfter(LocalDate.parse(r.getBookings().get(r.getBookings().size() - 1).getCheckoutdate()))) {
                        classes.add(rc);
                        break;
                    } else if (roomSelCheckOutBox.getDate().isBefore(LocalDate.parse(r.getBookings().get(0).getCheckoutdate()))) {
                        classes.add(rc);
                        break;
                    } else {
                        for (int i = 0; i < r.getBookings().size() - 1; i++) {
                            if (roomSelCheckInBox.getDate().isAfter(LocalDate.parse(r.getBookings().get(i).getCheckoutdate())) && roomSelCheckOutBox.getDate().isBefore(LocalDate.parse(r.getBookings().get(i + 1).getCheckindate()))) {
                                classes.add(rc);
                                found = true;
                                break;
                            }
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }
            RoomHelper.loadClassesInTree(roomSelRoomTypesTree, classes);
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                RoomHelper.writeToFile();
            }
        });
    }

    public static void main(String[] args) {
        OperatorFrame frame = new OperatorFrame();
        frame.setVisible(true);
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

    private static void datePickerSettings(DatePicker db) {
        DatePickerSettings ds = new DatePickerSettings();
        db.setSettings(ds);
        ds.setDateRangeLimits(LocalDate.now(), null);
        db.setDateToToday();
    }

    public int searchCard() {
        for (int i = 0; i < VisitorHelper.visitors.size(); i++) {
            Visitor vs = VisitorHelper.visitors.get(i);
            if (vs.getCardId().equals(detCardNumBox.getText())) {
                return i;
            }
        }
        return -1;
    }

    void populateVisitor(int i) {
        if (i == -1) {
            detVisitorNameBox.setText("");
            detPhoneNumBox.setText("");
            detEmailBox.setText("");
            detAddressBox.setText("");
            return;
        }
        Visitor vs = VisitorHelper.visitors.get(i);
        detVisitorNameBox.setText(vs.getName());
        detPhoneNumBox.setText(vs.getContactNo());
        detEmailBox.setText(vs.getEmailId());
        detAddressBox.setText(vs.getAddress());
    }

    protected void resetPanels() {
        roomSelCheckInBox.setDateToToday();
        roomSelCheckOutBox.setDateToToday();
        dateCheckInPicker.setDateToToday();
        dateCheckoutPicker.setDateToToday();
        dateAdults.setModel(new SpinnerNumberModel(0, 0, null, 1));
        dateChildren.setModel(new SpinnerNumberModel(0, 0, null, 1));
        orderMenuQuantityBox.setModel(new SpinnerNumberModel(0, 0, null, 1));

        ((DefaultTableModel) orderMenuOrderTable.getModel()).setRowCount(0);
        orderMenuPackageTree = ComponentHelper.setupTree(orderMenuPackageTree, "MENU");
        roomSelRoomTypesTree = ComponentHelper.setupTree(roomSelRoomTypesTree, "ROOM");
        detVerifyDocBox.setSelectedIndex(0);
        confirmRoomPackageBox.setText("");
        confirmCardNumBox.setText("");
        confirmCustNameBox.setText("");
        confirmCheckInBox.setText("");
        confirmCheckOutBox.setText("");
        confirmAdultsBox.setText("");
        confirmChildrenBox.setText("");
        confirmPriceBox.setText("");
        detCardNumBox.setText("");
        detVisitorNameBox.setText("");
        detEmailBox.setText("");
        detPhoneNumBox.setText("");
        roomselPriceBox.setText("");
        roomSelRoomNoBox.setText("");
        bookId.setText("");
        initPaymentBox.setText("");
        gstBox.setText("");
        amountBox.setText("");
        roomNumBox.setText("");
        orderMenuTypeHalfPriceBox.setText("");
        orderMenuTypeDoublePriceBox.setText("");
        orderMenuTypeSinglePriceBox.setText("");
        orderMenuTotalBox.setText("");
        detAddressBox.setText("");
        orderMenuTypeHalfOption.setSelected(false);
        orderMenuTypeSingleOption.setSelected(false);
        orderMenuTypeDoubleOption.setSelected(false);
        custName.setText("");
        roomPackage.setText("");
        checkInDate.setText("");
        checkOutDate.setText("");
        totalPrice.setText("");

        rightPanel.removeAll();
        rightPanel.repaint();
        rightPanel.revalidate();

        ComponentHelper.setEnabled(leftButtons, true);

        MenuHelper.loadDishesInTree(orderMenuPackageTree);
        ((DefaultTableModel) orderMenuOrderTable.getModel()).setColumnIdentifiers(Dish.getOrderColumns());

        orderMenuQuantityBox.setEnabled(false);
        orderMenuTypeHalfOption.setEnabled(false);
        orderMenuTypeSingleOption.setEnabled(false);
        orderMenuTypeDoubleOption.setEnabled(false);
        orderMenuAddButton.setEnabled(false);

        orderMenuRemoveButton.setEnabled(false);
        roomSelectStep.setEnabled(false);
        detailsStep.setEnabled(false);
        confirmStep.setEnabled(false);
    }
}

