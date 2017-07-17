package gs_project.hotel;

import com.github.lgooddatepicker.components.DatePicker;
import gs_project.hotel.helpers.*;
import gs_project.hotel.types.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AdminFrame extends OperatorFrame {

    private final JTabbedPane manageOperatorTabPanel;

    private final JPanel roomEditorPanel;
    private final JPanel roomEditorLeftPanel;
    private final JPanel roomEditorRightPanel;
    private final JPanel operatorManagePanel;
    private final JPanel editRemoveOperatorPanel;
    private final JPanel addOperatorPanel;
    private final JPanel reportsPanel;
    private final JPanel reportsButtonPanel;

    private final JScrollPane reportsScrollPane;

    private JTable operatorTable;
    private JTable reportsTable;

    private final JLabel operatorIdLabel;
    private final JLabel operatorNameLabel;
    private final JLabel operatorPasswordLabel;
    private final JLabel operatorConfirmPasswordLabel;
    private final JLabel operatorEmailLabel;
    private final JLabel operatorPhoneLabel;
    private final JLabel operatorAddressLabel;
    private final JLabel editOperatorIdLabel;
    private final JLabel editOperatorNameLabel;
    private final JLabel editOperatorPasswordLabel;
    private final JLabel editOperatorConfirmPasswordLabel;
    private final JLabel editOperatorEmailLabel;
    private final JLabel editOperatorPhoneLabel;
    private final JLabel editOperatorAddressLabel;
    private final JLabel reportsHeader;
    private final JLabel reportsDateRangeLabel;

    private final JTextField operatorIdBox;
    private final JTextField operatorNameBox;
    private final JTextField operatorEmailBox;
    private final JTextField operatorPhoneBox;
    private final JTextField editOperatorIdBox;
    private final JTextField editOperatorNameBox;
    private final JTextField editOperatorEmailBox;
    private final JTextField editOperatorPhoneBox;
    private final JTextArea operatorAddressBox;
    private final JTextArea editOperatorAddressBox;
    private final JPasswordField operatorPasswordBox;
    private final JPasswordField operatorConfirmPasswordBox;
    private final JPasswordField editOperatorPasswordBox;
    private final JPasswordField editOperatorConfirmPasswordBox;

    private final JButton operatorDeleteButton;
    private final JButton operatorUpdateButton;
    private final JButton operatorFormClearBtn;
    private final JButton operatorAddButton;
    private final JButton operatorManageButton;
    private final JButton manageRoomsButton;
    private final JButton editMealsMenuButton;
    private final JButton transactionReportButton;
    private final JButton visitorDatabaseButton;
    private final JButton currentBookingsButton;

    private final DatePicker reportsStartDatePicker;
    private final DatePicker reportsEndDatePicker;
    private final JPanel menuEditorPanel;
    private final JPanel menuEditorLeftPanel;
    private final JPanel menuEditorRightPanel;
    private JTable menuEditorStartersTable;
    private JTable menuEditorMainCourseTable;
    private JTable menuEditorDessertTable;
    private JTree dishesMenuTree;
    private JTree roomPackageTree;
    private final JButton addPackageButton;
    private final JButton editPackageButton;
    private final JButton removePackageButton;
    private final JPanel managePackageButtonPanel;
    private final JLabel roomEditorRangeLabel;
    private final JSpinner roomEditorStartSpinner;
    private final JSpinner roomEditorEndSpinner;
    private final JLabel roomEditorPriceLabel;
    private final JSpinner roomEditorPriceSpinner;
    private final JLabel roomEditorAdultLabel;
    private final JSpinner roomEditorAdultSpinner;
    private final JLabel roomEditorChildLabel;
    private final JSpinner roomEditorChildSpinner;
    private final JButton roomEditorSaveButton;
    private final JButton roomEditorCancelButton;
    private final JButton menuEditorAddMenuButton;
    private final JButton menuEditorEditMenuButton;
    private final JButton menuEditorRemoveMenuButton;
    private final JPanel manageMenuButtonPanel;
    private final JLabel menuEditorStartersLabel;
    private final JScrollPane menuEditorStarterScroller;
    private final JButton menuEditorStartersAddButton;
    private final JButton menuEditorStartersRemoveButton;
    private final JLabel menuEditorMainCourseLabel;
    private final JButton menuEditorMainCourseAddButton;
    private final JButton menuEditorMainCourseRemoveButton;
    private final JScrollPane menuEditorMainCourseScroller;
    private final JLabel menuEditorDessertLabel;
    private final JButton menuEditorDessertAddButton;
    private final JButton menuEditorDessertRemoveButton;
    private final JScrollPane menuEditorDessertScroller;
    private final JButton menuEditorSaveButton;
    private final JButton menuEditorCancelButton;

    public static void main(String[] args) {
        AdminFrame frame = new AdminFrame();
        frame.setVisible(true);
    }

    public AdminFrame() {
        super("Admin Landing Page");

        /// region leftButtons
        /// region operatorButtons (Bounds)
        bookButton.setBounds(10, 269, 172, 32);

        checkInButton.setBounds(10, 312, 172, 32);

        checkOutButton.setBounds(10, 355, 172, 32);

        foodOrderButton.setBounds(10, 398, 172, 32);

        cancelBookingButton.setBounds(10, 441, 172, 32);
        /// endregion

        /// region adminButtons
        operatorManageButton = new JButton("Manage Operators");
        operatorManageButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorManageButton.setBounds(10, 11, 172, 32);
        contentPane.add(operatorManageButton);
        leftButtons.add(operatorManageButton);

        manageRoomsButton = new JButton("Edit Packages");
        manageRoomsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        manageRoomsButton.setBounds(10, 54, 172, 32);
        contentPane.add(manageRoomsButton);
        leftButtons.add(manageRoomsButton);

        editMealsMenuButton = new JButton("Edit Meal Menu");
        editMealsMenuButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        editMealsMenuButton.setBounds(10, 97, 172, 32);
        contentPane.add(editMealsMenuButton);
        leftButtons.add(editMealsMenuButton);

        transactionReportButton = new JButton("Transaction Report");
        transactionReportButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        transactionReportButton.setBounds(10, 140, 172, 32);
        contentPane.add(transactionReportButton);
        leftButtons.add(transactionReportButton);

        visitorDatabaseButton = new JButton("Registered Visitors");
        visitorDatabaseButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        visitorDatabaseButton.setBounds(10, 183, 172, 32);
        contentPane.add(visitorDatabaseButton);
        leftButtons.add(visitorDatabaseButton);

        currentBookingsButton = new JButton("Current Bookings");
        currentBookingsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        currentBookingsButton.setBounds(10, 226, 172, 32);
        contentPane.add(currentBookingsButton);
        leftButtons.add(currentBookingsButton);
        /// endregion
        /// endregion

        /// region operatorManagePanel
        operatorManagePanel = new JPanel();
        operatorManagePanel.setBounds(0, 0, 592, 549);
        operatorManagePanel.setBorder(new LineBorder(Color.GRAY));
        operatorManagePanel.setLayout(null);

        JScrollPane operatorTableScrollPane = new JScrollPane();
        operatorTableScrollPane.setBounds(10, 283, 572, 255);
        operatorManagePanel.add(operatorTableScrollPane);

        /// region operatorTable
        operatorTable = ComponentHelper.createNewTable();
        ((DefaultTableModel) operatorTable.getModel()).setColumnIdentifiers(Operator.getColumns());
        operatorTable.getColumnModel().getColumn(0).setResizable(false);
        operatorTable.getColumnModel().getColumn(0).setPreferredWidth(96);
        operatorTable.getColumnModel().getColumn(0).setMinWidth(96);
        operatorTable.getColumnModel().getColumn(0).setMaxWidth(96);

        operatorTable.getColumnModel().getColumn(1).setResizable(false);
        operatorTable.getColumnModel().getColumn(1).setPreferredWidth(128);
        operatorTable.getColumnModel().getColumn(1).setMinWidth(128);
        operatorTable.getColumnModel().getColumn(1).setMaxWidth(128);

        operatorTable.getColumnModel().getColumn(2).setResizable(false);
        operatorTable.getColumnModel().getColumn(2).setPreferredWidth(96);
        operatorTable.getColumnModel().getColumn(2).setMinWidth(96);
        operatorTable.getColumnModel().getColumn(2).setMaxWidth(96);

        operatorTable.getColumnModel().getColumn(3).setResizable(false);
        operatorTable.getColumnModel().getColumn(3).setPreferredWidth(96);
        operatorTable.getColumnModel().getColumn(3).setMinWidth(96);
        operatorTable.getColumnModel().getColumn(3).setMaxWidth(96);

        operatorTable.getColumnModel().getColumn(4).setResizable(false);
        operatorTable.getColumnModel().getColumn(4).setPreferredWidth(156);
        operatorTable.getColumnModel().getColumn(4).setMinWidth(156);
        operatorTable.getColumnModel().getColumn(4).setMaxWidth(156);

        operatorTable.setShowGrid(false);
        operatorTable.setShowHorizontalLines(false);
        operatorTable.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorTableScrollPane.setViewportView(operatorTable);
        operatorTable.setFillsViewportHeight(true);
        /// endregion

        manageOperatorTabPanel = new JTabbedPane(JTabbedPane.TOP);
        manageOperatorTabPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
        manageOperatorTabPanel.setBounds(10, 11, 572, 276);
        operatorManagePanel.add(manageOperatorTabPanel);

        addOperatorPanel = new JPanel();
        manageOperatorTabPanel.addTab("ADD NEW", null, addOperatorPanel, null);
        addOperatorPanel.setLayout(null);

        operatorIdLabel = new JLabel("USER ID:");
        operatorIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorIdLabel.setBounds(10, 12, 128, 24);
        addOperatorPanel.add(operatorIdLabel);

        operatorIdBox = new JTextField();
        operatorIdBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorIdBox.setBounds(146, 12, 128, 24);
        operatorIdBox.setColumns(10);
        addOperatorPanel.add(operatorIdBox);

        operatorNameLabel = new JLabel("FULL NAME:");
        operatorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorNameLabel.setBounds(293, 12, 128, 24);
        addOperatorPanel.add(operatorNameLabel);

        operatorNameBox = new JTextField();
        operatorNameBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorNameBox.setBounds(429, 12, 128, 24);
        operatorNameBox.setColumns(10);
        addOperatorPanel.add(operatorNameBox);

        operatorPasswordLabel = new JLabel("PASSWORD:");
        operatorPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorPasswordLabel.setBounds(10, 47, 128, 24);
        addOperatorPanel.add(operatorPasswordLabel);

        operatorPasswordBox = new JPasswordField();
        operatorPasswordBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorPasswordBox.setBounds(146, 47, 128, 24);
        addOperatorPanel.add(operatorPasswordBox);

        operatorConfirmPasswordLabel = new JLabel("PASSWORD(AGAIN):");
        operatorConfirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        operatorConfirmPasswordLabel.setBounds(293, 47, 128, 24);
        addOperatorPanel.add(operatorConfirmPasswordLabel);

        operatorConfirmPasswordBox = new JPasswordField();
        operatorConfirmPasswordBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorConfirmPasswordBox.setBounds(429, 47, 128, 24);
        addOperatorPanel.add(operatorConfirmPasswordBox);

        operatorEmailLabel = new JLabel("E-MAIL ADDRESS:");
        operatorEmailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorEmailLabel.setBounds(10, 82, 128, 24);
        addOperatorPanel.add(operatorEmailLabel);

        operatorEmailBox = new JTextField();
        operatorEmailBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorEmailBox.setBounds(146, 82, 128, 24);
        operatorEmailBox.setColumns(10);
        addOperatorPanel.add(operatorEmailBox);

        operatorFormClearBtn = new JButton("CLEAR");
        operatorFormClearBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorFormClearBtn.setBounds(293, 202, 128, 32);
        addOperatorPanel.add(operatorFormClearBtn);

        operatorPhoneLabel = new JLabel("CONTACT NUMBER:");
        operatorPhoneLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        operatorPhoneLabel.setBounds(293, 82, 128, 24);
        addOperatorPanel.add(operatorPhoneLabel);

        operatorPhoneBox = new JTextField();
        operatorPhoneBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorPhoneBox.setColumns(10);
        operatorPhoneBox.setBounds(429, 82, 128, 24);
        addOperatorPanel.add(operatorPhoneBox);

        operatorAddressLabel = new JLabel("ADDRESS:");
        operatorAddressLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorAddressLabel.setBounds(10, 117, 128, 24);
        addOperatorPanel.add(operatorAddressLabel);

        operatorAddressBox = new JTextArea();
        operatorAddressBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorAddressBox.setLineWrap(true);
        operatorAddressBox.setBorder(new LineBorder(Color.GRAY));
        operatorAddressBox.setBounds(146, 117, 411, 74);
        addOperatorPanel.add(operatorAddressBox);

        operatorAddButton = new JButton("SUBMIT");
        operatorAddButton.setBounds(429, 202, 128, 32);
        addOperatorPanel.add(operatorAddButton);
        operatorAddButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        editRemoveOperatorPanel = new JPanel();
        editRemoveOperatorPanel.setLayout(null);
        manageOperatorTabPanel.addTab("EDIT/REMOVE", null, editRemoveOperatorPanel, null);

        editOperatorIdLabel = new JLabel("USER ID:");
        editOperatorIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorIdLabel.setBounds(10, 12, 128, 24);
        editRemoveOperatorPanel.add(editOperatorIdLabel);

        editOperatorIdBox = new JTextField();
        editOperatorIdBox.setEditable(false);
        editOperatorIdBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorIdBox.setColumns(10);
        editOperatorIdBox.setBounds(146, 12, 128, 24);
        editRemoveOperatorPanel.add(editOperatorIdBox);

        editOperatorNameLabel = new JLabel("FULL NAME:");
        editOperatorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorNameLabel.setBounds(293, 12, 128, 24);
        editRemoveOperatorPanel.add(editOperatorNameLabel);

        editOperatorNameBox = new JTextField();
        editOperatorNameBox.setEditable(false);
        editOperatorNameBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorNameBox.setColumns(10);
        editOperatorNameBox.setBounds(429, 12, 128, 24);
        editRemoveOperatorPanel.add(editOperatorNameBox);

        editOperatorPasswordLabel = new JLabel("PASSWORD:");
        editOperatorPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorPasswordLabel.setBounds(10, 47, 128, 24);
        editRemoveOperatorPanel.add(editOperatorPasswordLabel);

        editOperatorPasswordBox = new JPasswordField();
        editOperatorPasswordBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorPasswordBox.setBounds(146, 47, 128, 24);
        editRemoveOperatorPanel.add(editOperatorPasswordBox);

        editOperatorConfirmPasswordLabel = new JLabel("PASSWORD(AGAIN):");
        editOperatorConfirmPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        editOperatorConfirmPasswordLabel.setBounds(293, 47, 128, 24);
        editRemoveOperatorPanel.add(editOperatorConfirmPasswordLabel);

        editOperatorConfirmPasswordBox = new JPasswordField();
        editOperatorConfirmPasswordBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorConfirmPasswordBox.setBounds(429, 47, 128, 24);
        editRemoveOperatorPanel.add(editOperatorConfirmPasswordBox);

        editOperatorEmailLabel = new JLabel("E-MAIL ADDRESS:");
        editOperatorEmailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorEmailLabel.setBounds(10, 82, 128, 24);
        editRemoveOperatorPanel.add(editOperatorEmailLabel);

        editOperatorEmailBox = new JTextField();
        editOperatorEmailBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorEmailBox.setColumns(10);
        editOperatorEmailBox.setBounds(146, 82, 128, 24);
        editRemoveOperatorPanel.add(editOperatorEmailBox);

        operatorDeleteButton = new JButton("DELETE");
        operatorDeleteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorDeleteButton.setBounds(293, 202, 128, 32);
        editRemoveOperatorPanel.add(operatorDeleteButton);

        editOperatorPhoneLabel = new JLabel("CONTACT NUMBER:");
        editOperatorPhoneLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        editOperatorPhoneLabel.setBounds(293, 82, 128, 24);
        editRemoveOperatorPanel.add(editOperatorPhoneLabel);

        editOperatorPhoneBox = new JTextField();
        editOperatorPhoneBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorPhoneBox.setColumns(10);
        editOperatorPhoneBox.setBounds(429, 82, 128, 24);
        editRemoveOperatorPanel.add(editOperatorPhoneBox);

        editOperatorAddressLabel = new JLabel("ADDRESS:");
        editOperatorAddressLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorAddressLabel.setBounds(10, 117, 128, 24);
        editRemoveOperatorPanel.add(editOperatorAddressLabel);

        editOperatorAddressBox = new JTextArea();
        editOperatorAddressBox.setLineWrap(true);
        editOperatorAddressBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        editOperatorAddressBox.setBorder(new LineBorder(Color.GRAY));
        editOperatorAddressBox.setBounds(146, 117, 411, 74);
        editRemoveOperatorPanel.add(editOperatorAddressBox);

        operatorUpdateButton = new JButton("UPDATE");
        operatorUpdateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorUpdateButton.setBounds(429, 202, 128, 32);
        editRemoveOperatorPanel.add(operatorUpdateButton);
        /// endregion

        /// region roomEditorPanel
        roomEditorPanel = new JPanel();
        roomEditorPanel.setLayout(new BorderLayout());
        roomEditorPanel.setBounds(0, 0, 592, 549);
        roomEditorPanel.setBorder(new LineBorder(Color.GRAY));

        roomEditorLeftPanel = new JPanel();
        roomEditorLeftPanel.setLayout(new BorderLayout());

        roomPackageTree = new JTree();
        roomPackageTree.setFont(new Font("Tahoma", Font.BOLD, 14));

        addPackageButton = new JButton("ADD");
        editPackageButton = new JButton("EDIT");
        removePackageButton = new JButton("REMOVE");

        managePackageButtonPanel = new JPanel();
        managePackageButtonPanel.setLayout(new BoxLayout(managePackageButtonPanel, BoxLayout.LINE_AXIS));
        managePackageButtonPanel.add(Box.createRigidArea(new Dimension(8, addPackageButton.getPreferredSize().height + 16)));
        managePackageButtonPanel.add(addPackageButton);
        managePackageButtonPanel.add(Box.createHorizontalStrut(8));
        managePackageButtonPanel.add(editPackageButton);
        managePackageButtonPanel.add(Box.createHorizontalStrut(8));
        managePackageButtonPanel.add(removePackageButton);
        managePackageButtonPanel.add(Box.createHorizontalStrut(8));
        ComponentHelper.setEnabled(managePackageButtonPanel, false);

        roomEditorLeftPanel.add(new JScrollPane(roomPackageTree), BorderLayout.CENTER);
        roomEditorLeftPanel.add(managePackageButtonPanel, BorderLayout.SOUTH);
        roomEditorLeftPanel.setBorder(new LineBorder(Color.GRAY));

        roomEditorRightPanel = new JPanel();
        roomEditorRightPanel.setLayout(null);

        roomEditorRangeLabel = new JLabel("ROOM# RANGE: ");
        roomEditorRangeLabel.setBounds(32, 32, 128, 32);
        roomEditorRangeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorStartSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        roomEditorStartSpinner.setBounds(160, 32, 76, 32);
        roomEditorStartSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorEndSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        roomEditorEndSpinner.setBounds(244, 32, 76, 32);
        roomEditorEndSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorPriceLabel = new JLabel("BASE PRICE: ");
        roomEditorPriceLabel.setBounds(32, 88, 128, 32);
        roomEditorPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorPriceSpinner = new JSpinner(new SpinnerNumberModel(1000, 1000, null, 100));
        roomEditorPriceSpinner.setBounds(160, 88, 160, 32);
        roomEditorPriceSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorAdultLabel = new JLabel("MAX. ADULT: ");
        roomEditorAdultLabel.setBounds(32, 144, 128, 32);
        roomEditorAdultLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorAdultSpinner = new JSpinner(new SpinnerNumberModel());
        roomEditorAdultSpinner.setBounds(160, 144, 160, 32);
        roomEditorAdultSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorChildLabel = new JLabel("MAX. CHILD: ");
        roomEditorChildLabel.setBounds(32, 200, 128, 32);
        roomEditorChildLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorChildSpinner = new JSpinner(new SpinnerNumberModel());
        roomEditorChildSpinner.setBounds(160, 200, 160, 32);
        roomEditorChildSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorSaveButton = new JButton("SAVE");
        roomEditorSaveButton.setBounds(192, 264, 128, 32);
        roomEditorSaveButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorCancelButton = new JButton("CANCEL");
        roomEditorCancelButton.setBounds(32, 264, 128, 32);
        roomEditorCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        roomEditorRightPanel.add(roomEditorRangeLabel);
        roomEditorRightPanel.add(roomEditorPriceLabel);
        roomEditorRightPanel.add(roomEditorAdultLabel);
        roomEditorRightPanel.add(roomEditorChildLabel);

        roomEditorRightPanel.add(roomEditorStartSpinner);
        roomEditorRightPanel.add(roomEditorEndSpinner);
        roomEditorRightPanel.add(roomEditorPriceSpinner);
        roomEditorRightPanel.add(roomEditorAdultSpinner);
        roomEditorRightPanel.add(roomEditorChildSpinner);

        roomEditorRightPanel.add(roomEditorSaveButton);
        roomEditorRightPanel.add(roomEditorCancelButton);

        ComponentHelper.setEnabled(roomEditorRightPanel, false, backButton);

        roomEditorPanel.add(roomEditorLeftPanel, BorderLayout.WEST);
        roomEditorPanel.add(roomEditorRightPanel, BorderLayout.CENTER);

        roomPackageTree = ComponentHelper.setupTree(roomPackageTree, "ROOM");
        RoomHelper.loadClassesInTree(roomPackageTree);

        /// endregion

        /// region menuEditorPanel
        menuEditorPanel = new JPanel();
        menuEditorPanel.setLayout(new BorderLayout());
        menuEditorPanel.setBounds(0, 0, 592, 549);
        menuEditorPanel.setBorder(new LineBorder(Color.GRAY));

        menuEditorLeftPanel = new JPanel();
        menuEditorLeftPanel.setLayout(new BorderLayout());

        dishesMenuTree = new JTree();
        dishesMenuTree.setFont(new Font("Tahoma", Font.BOLD, 14));

        menuEditorAddMenuButton = new JButton("ADD");
        menuEditorEditMenuButton = new JButton("EDIT");
        menuEditorRemoveMenuButton = new JButton("REMOVE");

        manageMenuButtonPanel = new JPanel();
        manageMenuButtonPanel.setLayout(new BoxLayout(manageMenuButtonPanel, BoxLayout.LINE_AXIS));
        manageMenuButtonPanel.add(Box.createRigidArea(new Dimension(8, menuEditorAddMenuButton.getPreferredSize().height + 16)));
        manageMenuButtonPanel.add(menuEditorAddMenuButton);
        manageMenuButtonPanel.add(Box.createHorizontalStrut(8));
        manageMenuButtonPanel.add(menuEditorEditMenuButton);
        manageMenuButtonPanel.add(Box.createHorizontalStrut(8));
        manageMenuButtonPanel.add(menuEditorRemoveMenuButton);
        manageMenuButtonPanel.add(Box.createHorizontalStrut(8));
        ComponentHelper.setEnabled(manageMenuButtonPanel, false);

        menuEditorLeftPanel.add(new JScrollPane(dishesMenuTree), BorderLayout.CENTER);
        menuEditorLeftPanel.add(manageMenuButtonPanel, BorderLayout.SOUTH);
        menuEditorLeftPanel.setBorder(new LineBorder(Color.GRAY));

        menuEditorRightPanel = new JPanel();
        menuEditorRightPanel.setLayout(null);

        /// region menuEditorRightPanel
        JPanel menuEditorRightPanel = new JPanel();
        menuEditorRightPanel.setLayout(null);

        menuEditorStartersLabel = new JLabel("<html><center>STARTER</center></html>");
        menuEditorStartersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuEditorStartersLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorStartersLabel.setBounds(12, 12, 84, 32);
        menuEditorRightPanel.add(menuEditorStartersLabel);

        menuEditorStarterScroller = new JScrollPane();
        menuEditorStarterScroller.setBounds(109, 12, 232, 121);
        menuEditorRightPanel.add(menuEditorStarterScroller);

        menuEditorStartersTable = ComponentHelper.createNewTable();
        ((DefaultTableModel)menuEditorStartersTable.getModel()).setColumnIdentifiers(Dish.getColumns());
        menuEditorStartersTable.setFillsViewportHeight(true);
        menuEditorStarterScroller.setViewportView(menuEditorStartersTable);

        menuEditorStartersAddButton = new JButton("ADD");
        menuEditorStartersAddButton.setBounds(12, 56, 84, 32);
        menuEditorRightPanel.add(menuEditorStartersAddButton);

        menuEditorStartersRemoveButton = new JButton("REMOVE");
        menuEditorStartersRemoveButton.setBounds(12, 100, 84, 32);
        menuEditorRightPanel.add(menuEditorStartersRemoveButton);

        menuEditorMainCourseLabel = new JLabel("<html><center>MAIN COURSE</center></html>");
        menuEditorMainCourseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorMainCourseLabel.setBounds(12, 145, 84, 32);
        menuEditorRightPanel.add(menuEditorMainCourseLabel);

        menuEditorMainCourseAddButton = new JButton("ADD");
        menuEditorMainCourseAddButton.setBounds(12, 189, 84, 32);
        menuEditorRightPanel.add(menuEditorMainCourseAddButton);

        menuEditorMainCourseRemoveButton = new JButton("REMOVE");
        menuEditorMainCourseRemoveButton.setBounds(12, 233, 84, 32);
        menuEditorRightPanel.add(menuEditorMainCourseRemoveButton);

        menuEditorMainCourseScroller = new JScrollPane();
        menuEditorMainCourseScroller.setBounds(109, 145, 232, 121);
        menuEditorRightPanel.add(menuEditorMainCourseScroller);

        menuEditorMainCourseTable = ComponentHelper.createNewTable();
        ((DefaultTableModel)menuEditorMainCourseTable.getModel()).setColumnIdentifiers(Dish.getColumns());
        menuEditorMainCourseTable.setFillsViewportHeight(true);
        menuEditorMainCourseScroller.setViewportView(menuEditorMainCourseTable);

        menuEditorDessertLabel = new JLabel("<html><center>DESSERT</center></html>");
        menuEditorDessertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuEditorDessertLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorDessertLabel.setBounds(12, 278, 84, 32);
        menuEditorRightPanel.add(menuEditorDessertLabel);

        menuEditorDessertAddButton = new JButton("ADD");
        menuEditorDessertAddButton.setBounds(12, 322, 84, 32);
        menuEditorRightPanel.add(menuEditorDessertAddButton);

        menuEditorDessertRemoveButton = new JButton("REMOVE");
        menuEditorDessertRemoveButton.setBounds(12, 366, 84, 32);
        menuEditorRightPanel.add(menuEditorDessertRemoveButton);

        menuEditorDessertScroller = new JScrollPane();
        menuEditorDessertScroller.setBounds(109, 278, 232, 121);
        menuEditorRightPanel.add(menuEditorDessertScroller);

        menuEditorDessertTable = ComponentHelper.createNewTable();
        ((DefaultTableModel)menuEditorDessertTable.getModel()).setColumnIdentifiers(Dish.getColumns());
        menuEditorDessertTable.setFillsViewportHeight(true);
        menuEditorDessertScroller.setViewportView(menuEditorDessertTable);

        menuEditorSaveButton = new JButton("SAVE");
        menuEditorSaveButton.setBounds(213, 411, 128, 32);
        menuEditorSaveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorRightPanel.add(menuEditorSaveButton);

        menuEditorCancelButton = new JButton("CANCEL");
        menuEditorCancelButton.setBounds(12, 410, 128, 32);
        menuEditorCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorRightPanel.add(menuEditorCancelButton);
        /// endregion

        ComponentHelper.setEnabled(menuEditorRightPanel, false, backButton);

        menuEditorPanel.add(menuEditorLeftPanel, BorderLayout.WEST);
        menuEditorPanel.add(menuEditorRightPanel, BorderLayout.CENTER);

        dishesMenuTree = ComponentHelper.setupTree(dishesMenuTree, "MENU");
        MenuHelper.loadClassesInTree(dishesMenuTree);
        /// endregion

        /// region reportsCommonPanel
        reportsPanel = new JPanel();
        reportsPanel.setBorder(new LineBorder(Color.GRAY));
        reportsPanel.setBounds(0, 0, 592, 549);
        reportsPanel.setLayout(null);

        reportsHeader = new JLabel("REGISTERED VISITORS");
        reportsHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
        reportsHeader.setHorizontalAlignment(SwingConstants.CENTER);
        reportsHeader.setBounds(12, 12, 568, 32);
        reportsPanel.add(reportsHeader);

        reportsScrollPane = new JScrollPane();
        reportsScrollPane.setBounds(12, 56, 568, 413);
        reportsPanel.add(reportsScrollPane);

        reportsTable = ComponentHelper.createNewTable();
        reportsTable.setShowHorizontalLines(false);
        reportsTable.setShowGrid(false);
        reportsTable.setFont(new Font("Tahoma", Font.BOLD, 14));
        reportsTable.setFillsViewportHeight(true);
        reportsScrollPane.setViewportView(reportsTable);

        reportsButtonPanel = new JPanel();
        reportsButtonPanel.setBounds(12, 481, 568, 56);
        reportsPanel.add(reportsButtonPanel);
        reportsButtonPanel.setLayout(null);

        reportsStartDatePicker = new DatePicker();
        reportsStartDatePicker.setBounds(234, 12, 155, 32);
        reportsButtonPanel.add(reportsStartDatePicker);

        reportsEndDatePicker = new DatePicker();
        reportsEndDatePicker.setBounds(401, 12, 155, 32);
        reportsButtonPanel.add(reportsEndDatePicker);

        reportsDateRangeLabel = new JLabel("<html><p  style=\"text-align:right\">DATE &#183;<br>RANGE &#183;</p></html>");
        reportsDateRangeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        reportsDateRangeLabel.setBounds(152, 12, 72, 32);
        reportsButtonPanel.add(reportsDateRangeLabel);
        /// endregion

        /// region events
        /// region menuEditor events
        menuEditorDessertAddButton.addActionListener(e -> {
            Dish d = MenuHelper.takeDishInput(AdminFrame.this);

            if (d != null) {
                ((DefaultTableModel) menuEditorDessertTable.getModel()).addRow(d.toObjects());
            }
        });

        menuEditorStartersAddButton.addActionListener(e -> {
            Dish d = MenuHelper.takeDishInput(AdminFrame.this);

            if (d != null) {
                ((DefaultTableModel) menuEditorStartersTable.getModel()).addRow(d.toObjects());
            }
        });

        menuEditorMainCourseAddButton.addActionListener(e -> {
            Dish d = MenuHelper.takeDishInput(AdminFrame.this);

            if (d != null) {
                ((DefaultTableModel) menuEditorMainCourseTable.getModel()).addRow(d.toObjects());
            }
        });

        menuEditorDessertRemoveButton.addActionListener(e -> {
            if (menuEditorDessertTable.getSelectedRow() != -1) {
                ((DefaultTableModel) menuEditorDessertTable.getModel()).removeRow(menuEditorDessertTable.getSelectedRow());
            }
        });

        menuEditorStartersRemoveButton.addActionListener(e -> {
            if (menuEditorStartersTable.getSelectedRow() != -1) {
                ((DefaultTableModel) menuEditorStartersTable.getModel()).removeRow(menuEditorStartersTable.getSelectedRow());
            }
        });

        menuEditorMainCourseRemoveButton.addActionListener(e -> {
            if (menuEditorMainCourseTable.getSelectedRow() != -1) {
                ((DefaultTableModel) menuEditorMainCourseTable.getModel()).removeRow(menuEditorMainCourseTable.getSelectedRow());
            }
        });

        dishesMenuTree.addTreeSelectionListener(e -> {
            try {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) dishesMenuTree.getSelectionPath().getLastPathComponent();
                int ind = MenuHelper.getClassIndex(new TreePath(node.getPath()));
                if (ind > -1) {
                    MenuPackage mPack = MenuHelper.menuPackages.get(ind);
                    ((DefaultTableModel) menuEditorStartersTable.getModel()).setDataVector(Dish.toObjectsArray(mPack.getStarters()), Dish.getColumns());
                    ((DefaultTableModel) menuEditorMainCourseTable.getModel()).setDataVector(Dish.toObjectsArray(mPack.getMaincourse()), Dish.getColumns());
                    ((DefaultTableModel) menuEditorDessertTable.getModel()).setDataVector(Dish.toObjectsArray(mPack.getDesserts()), Dish.getColumns());
                    menuEditorEditMenuButton.setEnabled(!node.isRoot());
                    menuEditorRemoveMenuButton.setEnabled(!node.isRoot());
                } else {
                    ((DefaultTableModel) menuEditorStartersTable.getModel()).setRowCount(0);
                    ((DefaultTableModel) menuEditorMainCourseTable.getModel()).setRowCount(0);
                    ((DefaultTableModel) menuEditorDessertTable.getModel()).setRowCount(0);
                    menuEditorEditMenuButton.setEnabled(node != null && !node.isRoot());
                    menuEditorRemoveMenuButton.setEnabled(node != null && !node.isRoot());
                }

                if (node.isLeaf() && ind >=0) {
                    menuEditorAddMenuButton.setEnabled(false);
                } else {
                    menuEditorAddMenuButton.setEnabled(true);
                }
            } catch (Exception ignored) { }
        });

        menuEditorAddMenuButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) dishesMenuTree.getSelectionPath().getLastPathComponent();
            TypePopUp popUp = TypePopUp.show(menuEditorAddMenuButton, "NEW MENU PACKAGE", "NEW MENU");
            popUp.getFirstItem().addActionListener(e1 -> {
                String new_t = JOptionPane.showInputDialog(AdminFrame.this, "Enter new Menu Package Name:", "Add Menu Package", JOptionPane.QUESTION_MESSAGE);
                if (new_t == null || new_t.isEmpty()) return;

                DefaultMutableTreeNode new_node = new DefaultMutableTreeNode(new_t);
                node.add(new_node);

                ComponentHelper.expandTree(dishesMenuTree);

                dishesMenuTree.setSelectionPath(new TreePath(new_node.getPath()));
            });
            popUp.getSecondItem().addActionListener(e1 -> {
                String new_t = JOptionPane.showInputDialog(AdminFrame.this, "Enter new Menu Name:", "Add Menu Name", JOptionPane.QUESTION_MESSAGE);
                if (new_t == null || new_t.isEmpty()) return;

                DefaultMutableTreeNode new_node = new DefaultMutableTreeNode(new_t);
                node.add(new_node);

                ComponentHelper.expandTree(dishesMenuTree);

                dishesMenuTree.setSelectionPath(new TreePath(new_node.getPath()));

                ComponentHelper.setEnabled(menuEditorRightPanel, true);
                ComponentHelper.setEnabled(menuEditorLeftPanel, false);
            });
        });

        menuEditorEditMenuButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) dishesMenuTree.getSelectionPath().getLastPathComponent();
            TypePopUp popUp = TypePopUp.show(menuEditorEditMenuButton, "RENAME", "EDIT DISHES");

            if (node != null && !node.isLeaf()) popUp.getSecondItem().setEnabled(false);

            if (node == null) return;

            popUp.getFirstItem().addActionListener(e1 -> {
                if (node.isLeaf()) {
                    String new_name = JOptionPane.showInputDialog(AdminFrame.this, "Enter new name:", "Rename Menu", JOptionPane.QUESTION_MESSAGE);
                    for (MenuPackage rc : MenuHelper.menuPackages) {
                        String path = MenuHelper.pathToType(new TreePath(node.getPath()));
                        if (rc.getType().equals(path)) {
                            int last = path.lastIndexOf(":");
                            rc.setType(path.substring(0, last < 0 ? 0 : last) + (last < 0 ? "" : ":") + new_name);
                            break;
                        }
                    }
                } else {
                    String new_name = JOptionPane.showInputDialog(AdminFrame.this, "Enter new name:", "Rename Menu Package", JOptionPane.QUESTION_MESSAGE);
                    for (MenuPackage rc : MenuHelper.menuPackages) {
                        String path = MenuHelper.pathToType(new TreePath(node.getPath()));
                        if (rc.getType().startsWith(path + ":")) {
                            int last = path.lastIndexOf(":");
                            rc.setType(path.substring(0, last < 0 ? 0 : last) + (last < 0 ? "" : ":") + new_name + rc.getType().substring(path.length()));
                        }
                    }
                }
                dishesMenuTree = ComponentHelper.setupTree(dishesMenuTree, "MENU");
                MenuHelper.loadClassesInTree(dishesMenuTree);

                orderMenuPackageTree = ComponentHelper.setupTree(orderMenuPackageTree, "MENU");
                MenuHelper.loadDishesInTree(orderMenuPackageTree);
            });
            popUp.getSecondItem().addActionListener(e1 -> {
                ComponentHelper.setEnabled(menuEditorRightPanel, true);
                ComponentHelper.setEnabled(menuEditorLeftPanel, false);
            });
        });

        menuEditorRemoveMenuButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) dishesMenuTree.getSelectionPath().getLastPathComponent();
            if (node == null) return;
            if (node.isLeaf()) {
                for (MenuPackage rc : MenuHelper.menuPackages) {
                    if (rc.getType().equals(MenuHelper.pathToType(new TreePath(node.getPath())))) {
                        MenuHelper.menuPackages.remove(rc);
                        break;
                    }
                }
            } else {
                MenuHelper.menuPackages.removeIf(roomClass -> roomClass.getType().startsWith(RoomHelper.pathToType(new TreePath(node.getPath())) + ":"));
            }

            dishesMenuTree = ComponentHelper.setupTree(dishesMenuTree, "MENU");
            MenuHelper.loadClassesInTree(dishesMenuTree);

            orderMenuPackageTree = ComponentHelper.setupTree(orderMenuPackageTree, "MENU");
            MenuHelper.loadDishesInTree(orderMenuPackageTree);

            ((DefaultTableModel) menuEditorStartersTable.getModel()).setRowCount(0);
            ((DefaultTableModel) menuEditorMainCourseTable.getModel()).setRowCount(0);
            ((DefaultTableModel) menuEditorDessertTable.getModel()).setRowCount(0);
            menuEditorEditMenuButton.setEnabled(false);
            menuEditorRemoveMenuButton.setEnabled(false);
        });

        menuEditorCancelButton.addActionListener(e -> {
            dishesMenuTree = ComponentHelper.setupTree(dishesMenuTree, "MENU");
            MenuHelper.loadClassesInTree(dishesMenuTree);

            orderMenuPackageTree = ComponentHelper.setupTree(orderMenuPackageTree, "MENU");
            MenuHelper.loadDishesInTree(orderMenuPackageTree);

            ComponentHelper.setEnabled(menuEditorRightPanel, false);
            ComponentHelper.setEnabled(menuEditorLeftPanel, true);
        });

        menuEditorSaveButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) dishesMenuTree.getSelectionPath().getLastPathComponent();

            int ind = MenuHelper.getClassIndex(new TreePath(node.getPath()));

            if (menuEditorMainCourseTable.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(AdminFrame.this, "Main Courses table cannot be empty", "Invalid Table Data", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                ArrayList<Dish> starters = MenuHelper.tableToDishList(menuEditorStartersTable);
                ArrayList<Dish> maincourse = MenuHelper.tableToDishList(menuEditorMainCourseTable);
                ArrayList<Dish> desserts = MenuHelper.tableToDishList(menuEditorDessertTable);
                if (starters == null) {
                    JOptionPane.showMessageDialog(AdminFrame.this, "Errors in the Starters table", "Invalid Table Data", JOptionPane.ERROR_MESSAGE);
                } else if (maincourse == null) {
                    JOptionPane.showMessageDialog(AdminFrame.this, "Errors in the Main Courses table", "Invalid Table Data", JOptionPane.ERROR_MESSAGE);
                } else if (desserts == null) {
                    JOptionPane.showMessageDialog(AdminFrame.this, "Errors in the Desserts table", "Invalid Table Data", JOptionPane.ERROR_MESSAGE);
                } else {
                    MenuPackage pk = new MenuPackage(MenuHelper.pathToType(new TreePath(node.getPath())), starters, maincourse, desserts);
                    if (ind < 0) {
                        MenuHelper.menuPackages.add(pk);
                    } else {
                        MenuHelper.menuPackages.set(ind, pk);
                    }
                }
            }


            dishesMenuTree = ComponentHelper.setupTree(dishesMenuTree, "MENU");
            MenuHelper.loadClassesInTree(dishesMenuTree);


            orderMenuPackageTree = ComponentHelper.setupTree(orderMenuPackageTree, "MENU");
            MenuHelper.loadDishesInTree(orderMenuPackageTree);

            ComponentHelper.setEnabled(menuEditorRightPanel, false);
            ComponentHelper.setEnabled(menuEditorLeftPanel, true);
        });
        /// endregion

        /// region roomEditor events
        roomPackageTree.addTreeSelectionListener(e -> {
            try {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) roomPackageTree.getSelectionPath().getLastPathComponent();
                int ind = RoomHelper.getClassIndex(new TreePath(node.getPath()));
                if (ind > -1) {
                    RoomClass selclass = RoomHelper.roomClasses.get(ind);
                    roomEditorStartSpinner.setValue(selclass.getRooms().get(0).getRoomNo());
                    roomEditorEndSpinner.setValue(selclass.getRooms().get(selclass.getRooms().size() - 1).getRoomNo());
                    roomEditorAdultSpinner.setValue(selclass.getAdults());
                    roomEditorChildSpinner.setValue(selclass.getChildren());
                    roomEditorPriceSpinner.setValue(selclass.getPrice());
                    editPackageButton.setEnabled(!node.isRoot());
                    removePackageButton.setEnabled(!node.isRoot());
                } else {
                    roomEditorStartSpinner.setValue(((SpinnerNumberModel) roomEditorStartSpinner.getModel()).getMinimum());
                    roomEditorEndSpinner.setValue(((SpinnerNumberModel) roomEditorEndSpinner.getModel()).getMinimum());
                    roomEditorAdultSpinner.setValue(0);
                    roomEditorChildSpinner.setValue(0);
                    roomEditorPriceSpinner.setValue(((SpinnerNumberModel) roomEditorPriceSpinner.getModel()).getMinimum());
                    editPackageButton.setEnabled(node != null && !node.isRoot());
                    removePackageButton.setEnabled(node != null && !node.isRoot());
                }
                if (node.isLeaf() && ind >= 0) {
                    addPackageButton.setEnabled(false);
                } else {
                    addPackageButton.setEnabled(true);
                }
            } catch (Exception ignored) { }
        });

        addPackageButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) roomPackageTree.getSelectionPath().getLastPathComponent();
            TypePopUp popUp = TypePopUp.show(addPackageButton, "NEW ROOM CLASS", "NEW ROOM TYPE");
            popUp.getFirstItem().addActionListener(e1 -> {
                String new_t = JOptionPane.showInputDialog(AdminFrame.this, "Enter new Room Class:", "Add Room Class", JOptionPane.QUESTION_MESSAGE);
                if (new_t == null || new_t.isEmpty()) return;

                DefaultMutableTreeNode new_node = new DefaultMutableTreeNode(new_t);
                node.add(new_node);

                ComponentHelper.expandTree(roomPackageTree);

                roomPackageTree.setSelectionPath(new TreePath(new_node.getPath()));
            });
            popUp.getSecondItem().addActionListener(e1 -> {
                String new_t = JOptionPane.showInputDialog(AdminFrame.this, "Enter new Room Type:", "Add Room Type", JOptionPane.QUESTION_MESSAGE);
                if (new_t == null || new_t.isEmpty()) return;

                DefaultMutableTreeNode new_node = new DefaultMutableTreeNode(new_t);
                node.add(new_node);

                ComponentHelper.expandTree(roomPackageTree);

                roomPackageTree.setSelectionPath(new TreePath(new_node.getPath()));

                ComponentHelper.setEnabled(roomEditorRightPanel, true);
                ComponentHelper.setEnabled(roomEditorLeftPanel, false);
            });
        });

        editPackageButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) roomPackageTree.getSelectionPath().getLastPathComponent();
            TypePopUp popUp = TypePopUp.show(editPackageButton, "RENAME", "EDIT ROOM");

            if (node != null && !node.isLeaf()) popUp.getSecondItem().setEnabled(false);

            if (node == null) return;

            popUp.getFirstItem().addActionListener(e1 -> {
                if (node.isLeaf()) {
                    String new_name = JOptionPane.showInputDialog(AdminFrame.this, "Enter new name:", "Rename Room Type", JOptionPane.QUESTION_MESSAGE);
                    for (RoomClass rc : RoomHelper.roomClasses) {
                        String path = RoomHelper.pathToType(new TreePath(node.getPath()));
                        if (rc.getType().equals(path)) {
                            int last = path.lastIndexOf(":");
                            rc.setType(path.substring(0, last < 0 ? 0 : last) + (last < 0 ? "" : ":") + new_name);
                            break;
                        }
                    }
                } else {
                    String new_name = JOptionPane.showInputDialog(AdminFrame.this, "Enter new name:", "Rename Room Class", JOptionPane.QUESTION_MESSAGE);
                    for (RoomClass rc : RoomHelper.roomClasses) {
                        String path = RoomHelper.pathToType(new TreePath(node.getPath()));
                        if (rc.getType().startsWith(path + ":")) {
                            int last = path.lastIndexOf(":");
                            rc.setType(path.substring(0, last < 0 ? 0 : last) + (last < 0 ? "" : ":") + new_name + rc.getType().substring(path.length()));
                        }
                    }
                }

                roomPackageTree = ComponentHelper.setupTree(roomPackageTree, "ROOM");
                RoomHelper.loadClassesInTree(roomPackageTree);
            });
            popUp.getSecondItem().addActionListener(e1 -> {
                ComponentHelper.setEnabled(roomEditorRightPanel, true);
                ComponentHelper.setEnabled(roomEditorLeftPanel, false);
            });
        });

        roomEditorCancelButton.addActionListener(e -> {
            roomPackageTree = ComponentHelper.setupTree(roomPackageTree, "ROOM");
            RoomHelper.loadClassesInTree(roomPackageTree);

            ComponentHelper.setEnabled(roomEditorRightPanel, false);
            ComponentHelper.setEnabled(roomEditorLeftPanel, true);
        });
        roomEditorSaveButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) roomPackageTree.getSelectionPath().getLastPathComponent();

            int ind = RoomHelper.getClassIndex(new TreePath(node.getPath()));

            if (roomEditorStartSpinner.getValue() == roomEditorEndSpinner.getValue()) {
                JOptionPane.showMessageDialog(AdminFrame.this, "The start and end of Room Range cannot be same.", "No rooms in range", JOptionPane.ERROR_MESSAGE);
                return;
            } else if ((int) roomEditorAdultSpinner.getValue() <= 0) {
                JOptionPane.showMessageDialog(AdminFrame.this, "The number of adults cannot be zero.", "No room capacity", JOptionPane.ERROR_MESSAGE);
                return;
            } else if ((int) roomEditorPriceSpinner.getValue() <= 1000 || (int) roomEditorPriceSpinner.getValue() >= 10000) {
                JOptionPane.showMessageDialog(AdminFrame.this, "The entered price is out of acceptable range", "Wrong price", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                ArrayList<Room> rooml = RoomHelper.buildRoomList((int) roomEditorStartSpinner.getValue(), (int) roomEditorEndSpinner.getValue());
                if (rooml == null) {
                    JOptionPane.showMessageDialog(AdminFrame.this, "The room range cannot overlap with other rooms' range.", "Overlapping room range", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    RoomClass rc = new RoomClass(RoomHelper.pathToType(new TreePath(node.getPath())), (int) roomEditorPriceSpinner.getValue(), (int) roomEditorAdultSpinner.getValue(), (int) roomEditorChildSpinner.getValue(), rooml);
                    if (ind < 0) {
                        RoomHelper.roomClasses.add(rc);
                    } else {
                        RoomHelper.roomClasses.set(ind, rc);
                    }
                    RoomHelper.roomClasses.sort(Comparator.comparing(RoomClass::getPrice));
                }
            }

            roomPackageTree = ComponentHelper.setupTree(roomPackageTree, "ROOM");
            RoomHelper.loadClassesInTree(roomPackageTree);

            ComponentHelper.setEnabled(roomEditorRightPanel, false);
            ComponentHelper.setEnabled(roomEditorLeftPanel, true);
        });

        removePackageButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) roomPackageTree.getSelectionPath().getLastPathComponent();
            if (node == null) return;
            if (node.isLeaf()) {
                for (RoomClass rc : RoomHelper.roomClasses) {
                    if (rc.getType().equals(RoomHelper.pathToType(new TreePath(node.getPath())))) {
                        RoomHelper.roomClasses.remove(rc);
                        break;
                    }
                }
            } else {
                RoomHelper.roomClasses.removeIf(roomClass -> roomClass.getType().startsWith(RoomHelper.pathToType(new TreePath(node.getPath())) + ":"));
            }

            roomPackageTree = ComponentHelper.setupTree(roomPackageTree, "ROOM");
            RoomHelper.loadClassesInTree(roomPackageTree);

            roomEditorStartSpinner.setValue(((SpinnerNumberModel) roomEditorStartSpinner.getModel()).getMinimum());
            roomEditorEndSpinner.setValue(((SpinnerNumberModel) roomEditorEndSpinner.getModel()).getMinimum());
            roomEditorAdultSpinner.setValue(0);
            roomEditorChildSpinner.setValue(0);
            roomEditorPriceSpinner.setValue(((SpinnerNumberModel) roomEditorPriceSpinner.getModel()).getMinimum());
            editPackageButton.setEnabled(false);
            removePackageButton.setEnabled(false);
        });
        /// endregion

        detCardNumBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (e.getOppositeComponent() == detCardGenerateButton) {
                    detCardNumBox.requestFocus();
                    return;
                }
                if (detCardNumBox.getText().length() != 16) {
                    JOptionPane.showMessageDialog(AdminFrame.this, "Card Number should be 16 characters long!", "Invalid Card Number", JOptionPane.ERROR_MESSAGE);
                    detCardNumBox.requestFocus();
                }
            }
        });

        operatorAddButton.addActionListener(e -> {
            if(operatorIdBox.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"ID CANNOT BE BLANK","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(operatorNameBox.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"PLEASE ENTER OPERATOR NAME","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(operatorPasswordBox.getPassword().length==0){
                JOptionPane.showMessageDialog(this,"PASSWORD CANNOT BE BLANK","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(operatorConfirmPasswordBox.getPassword().length==0){
                JOptionPane.showMessageDialog(this,"CONFIRM PASSWORD CANNOT BE BLANK","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!ValidateHelper.validatePhone("+91"+operatorPhoneBox.getText())){
                JOptionPane.showMessageDialog(this,"PHONE NUMBER NOT ACCEPTED","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!ValidateHelper.validateEmail(operatorEmailBox.getText())){
                JOptionPane.showMessageDialog(this,"EMAIL ID NOT ACCEPTED","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (Arrays.equals(operatorPasswordBox.getPassword(),operatorConfirmPasswordBox.getPassword())){
                Operator nOp = new Operator(operatorIdBox.getText(),new String(operatorPasswordBox.getPassword()), operatorNameBox.getText(), operatorEmailBox.getText(),operatorPhoneBox.getText(),operatorAddressBox.getText());
                OperatorHelper.operators.add(nOp);
                operatorIdBox.setText("");
                operatorPasswordBox.setText("");
                operatorNameBox.setText("");
                operatorConfirmPasswordBox.setText("");
                operatorEmailBox.setText("");
                operatorAddressBox.setText("");
                operatorPhoneBox.setText("");
                OperatorHelper.updateTable(operatorTable);

                JOptionPane.showMessageDialog(this,"OPERATOR ADDED SUCCESSFULLY","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this,"PASSWORD'S DO NOT MATCH.PLEASE TRY AGAIN","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
        operatorUpdateButton.addActionListener(e ->{
             if(editOperatorPasswordBox.getPassword().length == 0){
                JOptionPane.showMessageDialog(this,"PASSWORD CANNOT BE BLANK","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(editOperatorConfirmPasswordBox.getPassword().length==0){
                JOptionPane.showMessageDialog(this,"CONFIRM PASSWORD CANNOT BE BLANK","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!ValidateHelper.validatePhone("+91"+editOperatorPhoneBox.getText())){
                JOptionPane.showMessageDialog(this,"PHONE NUMBER NOT ACCEPTED","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(!ValidateHelper.validateEmail(editOperatorEmailBox.getText())){
                JOptionPane.showMessageDialog(this,"EMAIL ID NOT ACCEPTED","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(Arrays.equals(editOperatorPasswordBox.getPassword(),editOperatorConfirmPasswordBox.getPassword())){
                 for (int i = 0; i < OperatorHelper.operators.size(); i++) {
                     Operator op = OperatorHelper.operators.get(i);
                     if (op.getUid().equals(editOperatorIdBox.getText())) {
                         op.setName(editOperatorNameBox.getText());
                         op.setEmail(editOperatorEmailBox.getText());
                         op.setPassword(new String(editOperatorPasswordBox.getPassword()));
                         op.setPhoneNumber(editOperatorPhoneBox.getText());
                         OperatorHelper.operators.set(i, op);
                         OperatorHelper.updateTable(operatorTable);
                         editOperatorIdBox.setText("");
                         editOperatorNameBox.setText("");
                         editOperatorPasswordBox.setText("");
                         editOperatorConfirmPasswordBox.setText("");
                         editOperatorEmailBox.setText("");
                         editOperatorPhoneBox.setText("");
                         editOperatorAddressBox.setText("");
                         return;
                     }
                 }
                JOptionPane.showMessageDialog(this,"OPERATOR UPDATED SUCCESSFULLY","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this,"PASSWORD'S DO NOT MATCH.PLEASE TRY AGAIN","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
        operatorTable.getSelectionModel().addListSelectionListener(e ->{
            if(operatorTable.getSelectedRow()<0){
                return;
            }
            String opid=String.valueOf(operatorTable.getValueAt(operatorTable.getSelectedRow(),0));
            for(Operator os:OperatorHelper.operators)
            {
                if(os.getUid().equals(opid)){
                    editOperatorIdBox.setText(os.getUid());
                    editOperatorNameBox.setText(os.getName());
                    editOperatorPasswordBox.setText(os.getPassword());
                    editOperatorConfirmPasswordBox.setText(os.getPassword());
                    editOperatorEmailBox.setText(os.getEmail());
                    editOperatorPhoneBox.setText(os.getPhoneNumber());
                    editOperatorAddressBox.setText(os.getAddress());
                }
            }
        });
        operatorDeleteButton.addActionListener(e ->{
            for(Operator op:OperatorHelper.operators){
                if(editOperatorIdBox.getText().equals(op.getUid())) {
                    OperatorHelper.operators.remove(op);
                    OperatorHelper.updateTable(operatorTable);
                    editOperatorIdBox.setText("");
                    editOperatorNameBox.setText("");
                    editOperatorPasswordBox.setText("");
                    editOperatorConfirmPasswordBox.setText("");
                    editOperatorEmailBox.setText("");
                    editOperatorPhoneBox.setText("");
                    editOperatorAddressBox.setText("");
                    break;
                }
            }
        });

        operatorManageButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, operatorManageButton);
            backButton.setBounds(10, 202, 128, 32);
            ((JPanel) manageOperatorTabPanel.getSelectedComponent()).add(backButton);
            OperatorHelper.updateTable(operatorTable);
            setPanel(operatorManagePanel, rightPanel);
        });

        manageRoomsButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, manageRoomsButton);
            backButton.setBounds(112, 500, 128, 32);
            roomEditorRightPanel.add(backButton);

            setPanel(roomEditorPanel, rightPanel);
        });

        editMealsMenuButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, editMealsMenuButton);
            backButton.setBounds(112, 500, 128, 32);
            menuEditorRightPanel.add(backButton);

            setPanel(menuEditorPanel, rightPanel);
        });

        manageOperatorTabPanel.addChangeListener(e -> {
            ((JPanel) manageOperatorTabPanel.getSelectedComponent()).add(backButton);
        });

        visitorDatabaseButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, visitorDatabaseButton);
            backButton.setBounds(12, 12, 128, 32);
            reportsButtonPanel.add(backButton);

            reportsHeader.setText("REGISTERED VISITORS");
            reportsStartDatePicker.setVisible(false);
            reportsEndDatePicker.setVisible(false);
            reportsDateRangeLabel.setVisible(false);

            ((DefaultTableModel) reportsTable.getModel()).setRowCount(0);
            ((DefaultTableModel) reportsTable.getModel()).setDataVector(Visitor.toObjectsArray(VisitorHelper.visitors), Visitor.getColumns());

            setPanel(reportsPanel, rightPanel);
        });

        transactionReportButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, transactionReportButton);
            backButton.setBounds(12, 12, 128, 32);
            reportsButtonPanel.add(backButton);

            reportsHeader.setText("RECENT TRANSACTIONS");

            reportsStartDatePicker.setVisible(true);
            reportsEndDatePicker.setVisible(true);
            reportsDateRangeLabel.setVisible(true);


            ((DefaultTableModel)reportsTable.getModel()).setRowCount(0);
            RoomHelper.loadTransactions(reportsTable, reportsStartDatePicker.getDate(), reportsEndDatePicker.getDate());

            setPanel(reportsPanel, rightPanel);
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

        currentBookingsButton.addActionListener(e -> {
            ComponentHelper.setEnabled(leftButtons, false, currentBookingsButton);
            backButton.setBounds(12, 12, 128, 32);
            reportsButtonPanel.add(backButton);

            reportsHeader.setText("CURRENT BOOKINGS");

            reportsStartDatePicker.setVisible(true);
            reportsEndDatePicker.setVisible(true);
            reportsDateRangeLabel.setVisible(true);

            ((DefaultTableModel)reportsTable.getModel()).setRowCount(0);
            RoomHelper.loadCurrentBookings(reportsTable, reportsStartDatePicker.getDate(), reportsEndDatePicker.getDate());

            setPanel(reportsPanel, rightPanel);
        });

        reportsStartDatePicker.addDateChangeListener(e -> {
            if (reportsHeader.getText().equals("CURRENT BOOKINGS")) {
                ((DefaultTableModel) reportsTable.getModel()).setRowCount(0);
                RoomHelper.loadCurrentBookings(reportsTable, reportsStartDatePicker.getDate(), reportsEndDatePicker.getDate());
            } else if (reportsHeader.getText().equals("RECENT TRANSACTIONS")) {
                ((DefaultTableModel)reportsTable.getModel()).setRowCount(0);
                RoomHelper.loadTransactions(reportsTable, reportsStartDatePicker.getDate(), reportsEndDatePicker.getDate());
            }
        });
        reportsEndDatePicker.addDateChangeListener(e -> {
            if (reportsHeader.getText().equals("CURRENT BOOKINGS")) {
                ((DefaultTableModel) reportsTable.getModel()).setRowCount(0);
                RoomHelper.loadCurrentBookings(reportsTable, reportsStartDatePicker.getDate(), reportsEndDatePicker.getDate());
            } else if (reportsHeader.getText().equals("RECENT TRANSACTIONS")) {
                ((DefaultTableModel)reportsTable.getModel()).setRowCount(0);
                RoomHelper.loadTransactions(reportsTable, reportsStartDatePicker.getDate(), reportsEndDatePicker.getDate());
            }
        });
        /// endregion

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MenuHelper.writeToFile();
                VisitorHelper.writeToFile();
                OperatorHelper.writeToFile();
            }
        });

        reportsStartDatePicker.setDateToToday();
        reportsEndDatePicker.setDateToToday();
    }

    @Override
    protected void resetPanels() {
        super.resetPanels();

        operatorIdBox.setText("");
        operatorNameBox.setText("");
        operatorEmailBox.setText("");
        operatorPhoneBox.setText("");
        editOperatorIdBox.setText("");
        editOperatorNameBox.setText("");
        editOperatorEmailBox.setText("");
        editOperatorPhoneBox.setText("");
        operatorAddressBox.setText("");
        editOperatorAddressBox.setText("");
        operatorPasswordBox.setText("");
        editOperatorPasswordBox.setText("");
        operatorConfirmPasswordBox.setText("");
        editOperatorConfirmPasswordBox.setText("");

        roomEditorStartSpinner.setModel(new SpinnerNumberModel(100, 100, 1000, 1));
        roomEditorEndSpinner.setModel(new SpinnerNumberModel(100, 100, 1000, 1));
        roomEditorPriceSpinner.setModel(new SpinnerNumberModel(1000, 1000, null, 100));
        roomEditorAdultSpinner.setModel(new SpinnerNumberModel());
        roomEditorChildSpinner.setModel(new SpinnerNumberModel());

        /// region operatorTable
        operatorTable = ComponentHelper.createNewTable();
        ((DefaultTableModel) operatorTable.getModel()).setColumnIdentifiers(Operator.getColumns());
        operatorTable.getColumnModel().getColumn(0).setResizable(false);
        operatorTable.getColumnModel().getColumn(0).setPreferredWidth(96);
        operatorTable.getColumnModel().getColumn(0).setMinWidth(96);
        operatorTable.getColumnModel().getColumn(0).setMaxWidth(96);

        operatorTable.getColumnModel().getColumn(1).setResizable(false);
        operatorTable.getColumnModel().getColumn(1).setPreferredWidth(128);
        operatorTable.getColumnModel().getColumn(1).setMinWidth(128);
        operatorTable.getColumnModel().getColumn(1).setMaxWidth(128);

        operatorTable.getColumnModel().getColumn(2).setResizable(false);
        operatorTable.getColumnModel().getColumn(2).setPreferredWidth(96);
        operatorTable.getColumnModel().getColumn(2).setMinWidth(96);
        operatorTable.getColumnModel().getColumn(2).setMaxWidth(96);

        operatorTable.getColumnModel().getColumn(3).setResizable(false);
        operatorTable.getColumnModel().getColumn(3).setPreferredWidth(96);
        operatorTable.getColumnModel().getColumn(3).setMinWidth(96);
        operatorTable.getColumnModel().getColumn(3).setMaxWidth(96);

        operatorTable.getColumnModel().getColumn(4).setResizable(false);
        operatorTable.getColumnModel().getColumn(4).setPreferredWidth(156);
        operatorTable.getColumnModel().getColumn(4).setMinWidth(156);
        operatorTable.getColumnModel().getColumn(4).setMaxWidth(156);

        operatorTable.setShowGrid(false);
        operatorTable.setShowHorizontalLines(false);
        /// endregion

        ComponentHelper.setEnabled(managePackageButtonPanel, false);
        ComponentHelper.setEnabled(roomEditorRightPanel, false, backButton);
        ComponentHelper.setEnabled(manageMenuButtonPanel, false);

        roomPackageTree = ComponentHelper.setupTree(roomPackageTree, "ROOM");
        RoomHelper.loadClassesInTree(roomPackageTree);

        menuEditorStartersTable = ComponentHelper.createNewTable();
        ((DefaultTableModel) menuEditorStartersTable.getModel()).setColumnIdentifiers(Dish.getColumns());

        menuEditorMainCourseTable = ComponentHelper.createNewTable();
        ((DefaultTableModel) menuEditorMainCourseTable.getModel()).setColumnIdentifiers(Dish.getColumns());

        menuEditorDessertTable = ComponentHelper.createNewTable();
        ((DefaultTableModel) menuEditorDessertTable.getModel()).setColumnIdentifiers(Dish.getColumns());

        ComponentHelper.setEnabled(menuEditorRightPanel, false, backButton);

        dishesMenuTree = ComponentHelper.setupTree(dishesMenuTree, "MENU");
        MenuHelper.loadClassesInTree(dishesMenuTree);

        reportsStartDatePicker.setDateToToday();
        reportsEndDatePicker.setDateToToday();
    }
}
