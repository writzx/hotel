package gs_project.hotel;

import com.github.lgooddatepicker.components.DatePicker;
import gs_project.hotel.helpers.ComponentHelper;
import gs_project.hotel.helpers.MenuHelper;
import gs_project.hotel.helpers.RoomHelper;
import gs_project.hotel.helpers.VisitorHelper;
import gs_project.hotel.types.Dish;
import gs_project.hotel.types.MenuPackage;
import gs_project.hotel.types.Operator;
import gs_project.hotel.types.RoomClass;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.BoxLayout.LINE_AXIS;

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

    private final JTable operatorTable;
    private final JTable reportsTable;

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
    private final JButton operatorMangeButton;
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
    private final JTable menuEditorStartersTable;
    private final JTable menuEditorMainCourseTable;
    private final JTable menuEditorDessertTable;

    private ArrayList<Operator> operators = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminFrame frame = new AdminFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
        operatorMangeButton = new JButton("Manage Operators");
        operatorMangeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        operatorMangeButton.setBounds(10, 11, 172, 32);
        contentPane.add(operatorMangeButton);

        manageRoomsButton = new JButton("Edit Packages");
        manageRoomsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        manageRoomsButton.setBounds(10, 54, 172, 32);
        contentPane.add(manageRoomsButton);

        editMealsMenuButton = new JButton("Edit Meal Menu");
        editMealsMenuButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        editMealsMenuButton.setBounds(10, 97, 172, 32);
        contentPane.add(editMealsMenuButton);

        transactionReportButton = new JButton("Transaction Report");
        transactionReportButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        transactionReportButton.setBounds(10, 140, 172, 32);
        contentPane.add(transactionReportButton);

        visitorDatabaseButton = new JButton("Registered Visitors");
        visitorDatabaseButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        visitorDatabaseButton.setBounds(10, 183, 172, 32);
        contentPane.add(visitorDatabaseButton);

        currentBookingsButton = new JButton("Current Bookings");
        currentBookingsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        currentBookingsButton.setBounds(10, 226, 172, 32);
        contentPane.add(currentBookingsButton);
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
        operatorTable = new JTable();
        operatorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        operatorTable.getTableHeader().setReorderingAllowed(false);
        operatorTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "USER ID", "NAME", "EMAIL","PASSWORD", "CONTACT NO.", "ADDRESS" }) {
            Class[] columnTypes = new Class[] { String.class, String.class, String.class,String.class, String.class, String.class };


            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

        });
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

        JTree roomPackageTree = new JTree();
        roomPackageTree.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton addPackageButton = new JButton("ADD");
        JButton editPackageButton = new JButton("EDIT");
        JButton removePackageButton = new JButton("REMOVE");

        JPanel managePackageButtonPanel = new JPanel();
        managePackageButtonPanel.setLayout(new BoxLayout(managePackageButtonPanel, LINE_AXIS));
        managePackageButtonPanel.add(Box.createRigidArea(new Dimension(8, addPackageButton.getPreferredSize().height + 16)));
        managePackageButtonPanel.add(addPackageButton);
        managePackageButtonPanel.add(Box.createHorizontalStrut(8));
        managePackageButtonPanel.add(editPackageButton);
        managePackageButtonPanel.add(Box.createHorizontalStrut(8));
        managePackageButtonPanel.add(removePackageButton);
        managePackageButtonPanel.add(Box.createHorizontalStrut(8));

        roomEditorLeftPanel.add(new JScrollPane(roomPackageTree), BorderLayout.CENTER);
        roomEditorLeftPanel.add(managePackageButtonPanel, BorderLayout.SOUTH);
        roomEditorLeftPanel.setBorder(new LineBorder(Color.GRAY));

        roomEditorRightPanel = new JPanel();
        roomEditorRightPanel.setLayout(null);

        JLabel roomEditorRangeLabel = new JLabel("ROOM# RANGE: ");
        roomEditorRangeLabel.setBounds(32, 32, 128, 32);
        roomEditorRangeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JSpinner roomEditorStartSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        roomEditorStartSpinner.setBounds(160, 32, 76, 32);
        roomEditorStartSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        JSpinner roomEditorEndSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        roomEditorEndSpinner.setBounds(244, 32, 76, 32);
        roomEditorEndSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel roomEditorPriceLabel = new JLabel("BASE PRICE: ");
        roomEditorPriceLabel.setBounds(32, 88, 128, 32);
        roomEditorPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JSpinner roomEditorPriceSpinner = new JSpinner(new SpinnerNumberModel(1000, 1000, null, 100));
        roomEditorPriceSpinner.setBounds(160, 88, 160, 32);
        roomEditorPriceSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel roomEditorAdultLabel = new JLabel("MAX. ADULT: ");
        roomEditorAdultLabel.setBounds(32, 144, 128, 32);
        roomEditorAdultLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JSpinner roomEditorAdultSpinner = new JSpinner(new SpinnerNumberModel());
        roomEditorAdultSpinner.setBounds(160, 144, 160, 32);
        roomEditorAdultSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel roomEditorChildLabel = new JLabel("MAX. CHILD: ");
        roomEditorChildLabel.setBounds(32, 200, 128, 32);
        roomEditorChildLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JSpinner roomEditorChildSpinner = new JSpinner(new SpinnerNumberModel());
        roomEditorChildSpinner.setBounds(160, 200, 160, 32);
        roomEditorChildSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton roomEditorSaveButton = new JButton("SAVE");
        roomEditorSaveButton.setBounds(192, 264, 128, 32);
        roomEditorSaveButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton roomEditorCancelButton = new JButton("CANCEL");
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

        roomPackageTree.setModel(new DefaultTreeModel( new DefaultMutableTreeNode("ROOM")));
        roomPackageTree.setEditable(false);
        roomPackageTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        roomPackageTree.addTreeWillExpandListener(new TreeWillExpandListener() {
            @Override
            public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
            }

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                throw new ExpandVetoException(event);
            }
        });

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
                }
            } catch (Exception ignored) { }
        });

        RoomHelper.loadClassesInTree(roomPackageTree);

        /// endregion

        /// region menuEditorPanel
        menuEditorPanel = new JPanel();
        menuEditorPanel.setLayout(new BorderLayout());
        menuEditorPanel.setBounds(0, 0, 592, 549);
        menuEditorPanel.setBorder(new LineBorder(Color.GRAY));

        menuEditorLeftPanel = new JPanel();
        menuEditorLeftPanel.setLayout(new BorderLayout());

        JTree dishesMenuTree = new JTree();
        dishesMenuTree.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton menuEditorAddMenuButton = new JButton("ADD");
        JButton menuEditorEditMenuButton = new JButton("EDIT");
        JButton menuEditorRemoveMenuButton = new JButton("REMOVE");

        JPanel manageMenuButtonPanel = new JPanel();
        manageMenuButtonPanel.setLayout(new BoxLayout(manageMenuButtonPanel, LINE_AXIS));
        manageMenuButtonPanel.add(Box.createRigidArea(new Dimension(8, menuEditorAddMenuButton.getPreferredSize().height + 16)));
        manageMenuButtonPanel.add(menuEditorAddMenuButton);
        manageMenuButtonPanel.add(Box.createHorizontalStrut(8));
        manageMenuButtonPanel.add(menuEditorEditMenuButton);
        manageMenuButtonPanel.add(Box.createHorizontalStrut(8));
        manageMenuButtonPanel.add(menuEditorRemoveMenuButton);
        manageMenuButtonPanel.add(Box.createHorizontalStrut(8));

        menuEditorLeftPanel.add(new JScrollPane(dishesMenuTree), BorderLayout.CENTER);
        menuEditorLeftPanel.add(manageMenuButtonPanel, BorderLayout.SOUTH);
        menuEditorLeftPanel.setBorder(new LineBorder(Color.GRAY));

        menuEditorRightPanel = new JPanel();
        menuEditorRightPanel.setLayout(null);

        /// region menuEditorRightPanel
        JPanel menuEditorRightPanel = new JPanel();
        menuEditorRightPanel.setLayout(null);

        JLabel menuEditorStartersLabel = new JLabel("<html><center>STARTER</center></html>");
        menuEditorStartersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuEditorStartersLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorStartersLabel.setBounds(12, 12, 84, 32);
        menuEditorRightPanel.add(menuEditorStartersLabel);

        JScrollPane menuEditorStarterScroller = new JScrollPane();
        menuEditorStarterScroller.setBounds(109, 12, 232, 121);
        menuEditorRightPanel.add(menuEditorStarterScroller);

        menuEditorStartersTable = new JTable();
        menuEditorStartersTable.setFillsViewportHeight(true);
        menuEditorStarterScroller.setViewportView(menuEditorStartersTable);

        JButton menuEditorStartersAddButton = new JButton("ADD");
        menuEditorStartersAddButton.setBounds(12, 56, 84, 32);
        menuEditorRightPanel.add(menuEditorStartersAddButton);

        JButton menuEditorStartersRemoveButton = new JButton("REMOVE");
        menuEditorStartersRemoveButton.setBounds(12, 100, 84, 32);
        menuEditorRightPanel.add(menuEditorStartersRemoveButton);

        JLabel menuEditorMainCourseLabel = new JLabel("<html><center>MAIN COURSE</center></html>");
        menuEditorMainCourseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorMainCourseLabel.setBounds(12, 145, 84, 32);
        menuEditorRightPanel.add(menuEditorMainCourseLabel);

        JButton menuEditorMainCourseAddButton = new JButton("ADD");
        menuEditorMainCourseAddButton.setBounds(12, 189, 84, 32);
        menuEditorRightPanel.add(menuEditorMainCourseAddButton);

        JButton menuEditorMainCourseRemoveButton = new JButton("REMOVE");
        menuEditorMainCourseRemoveButton.setBounds(12, 233, 84, 32);
        menuEditorRightPanel.add(menuEditorMainCourseRemoveButton);

        JScrollPane menuEditorMainCourseScroller = new JScrollPane();
        menuEditorMainCourseScroller.setBounds(109, 145, 232, 121);
        menuEditorRightPanel.add(menuEditorMainCourseScroller);

        menuEditorMainCourseTable = new JTable();
        menuEditorMainCourseTable.setFillsViewportHeight(true);
        menuEditorMainCourseScroller.setViewportView(menuEditorMainCourseTable);

        JLabel menuEditorDessertLabel = new JLabel("<html><center>DESSERT</center></html>");
        menuEditorDessertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuEditorDessertLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorDessertLabel.setBounds(12, 278, 84, 32);
        menuEditorRightPanel.add(menuEditorDessertLabel);

        JButton menuEditorDessertAddButton = new JButton("ADD");
        menuEditorDessertAddButton.setBounds(12, 322, 84, 32);
        menuEditorRightPanel.add(menuEditorDessertAddButton);

        JButton menuEditorDessertRemoveButton = new JButton("REMOVE");
        menuEditorDessertRemoveButton.setBounds(12, 366, 84, 32);
        menuEditorRightPanel.add(menuEditorDessertRemoveButton);

        JScrollPane menuEditorDessertScroller = new JScrollPane();
        menuEditorDessertScroller.setBounds(109, 278, 232, 121);
        menuEditorRightPanel.add(menuEditorDessertScroller);

        menuEditorDessertTable = new JTable();
        menuEditorDessertTable.setFillsViewportHeight(true);
        menuEditorDessertScroller.setViewportView(menuEditorDessertTable);


        JButton menuEditorSaveButton = new JButton("SAVE");
        menuEditorSaveButton.setBounds(213, 411, 128, 32);
        menuEditorSaveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorRightPanel.add(menuEditorSaveButton);

        JButton menuEditorCancelButton = new JButton("CANCEL");
        menuEditorCancelButton.setBounds(12, 410, 128, 32);
        menuEditorCancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        menuEditorRightPanel.add(menuEditorCancelButton);
        /// endregion

        ComponentHelper.setEnabled(menuEditorRightPanel, false, backButton);

        menuEditorPanel.add(menuEditorLeftPanel, BorderLayout.WEST);
        menuEditorPanel.add(menuEditorRightPanel, BorderLayout.CENTER);

        dishesMenuTree.setModel(new DefaultTreeModel( new DefaultMutableTreeNode("MENU")));
        dishesMenuTree.setEditable(false);
        dishesMenuTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        dishesMenuTree.addTreeWillExpandListener(new TreeWillExpandListener() {
            @Override
            public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
            }

            @Override
            public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                throw new ExpandVetoException(event);
            }
        });

        dishesMenuTree.addTreeSelectionListener(e -> {
            try {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) dishesMenuTree.getSelectionPath().getLastPathComponent();
                int ind = MenuHelper.getClassIndex(new TreePath(node.getPath()));
                if (ind > -1) {
                    MenuPackage menuPackage = MenuHelper.menuPackages.get(ind);

                    // todo show values
                }
            } catch (Exception ignored) { }
        });

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

        reportsTable = new JTable();
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
        operatorAddButton.addActionListener(e ->{
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
            else if(Arrays.equals(operatorPasswordBox.getPassword(),operatorConfirmPasswordBox.getPassword())){
                Operator nOp = new Operator(operatorIdBox.getText(),new String(operatorPasswordBox.getPassword()), operatorNameBox.getText(), operatorEmailBox.getText(),operatorPhoneBox.getText(),operatorAddressBox.getText());
                operators.add(nOp);
                operatorIdBox.setText("");
                operatorPasswordBox.setText("");
                operatorNameBox.setText("");
                operatorConfirmPasswordBox.setText("");
                operatorEmailBox.setText("");
                operatorAddressBox.setText("");
                operatorPhoneBox.setText("");
                updateTable();

                JOptionPane.showMessageDialog(this,"OPERATOR ADDED SUCCESSFULLY","SUCCESS",JOptionPane.INFORMATION_MESSAGE);

            }
            else{
                JOptionPane.showMessageDialog(this,"PASSWORD'S DO NOT MATCH.PLEASE TRY AGAIN","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
        operatorUpdateButton.addActionListener(e ->{
             if(operatorPasswordBox.getPassword().length==0){
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
            else if(Arrays.equals(operatorPasswordBox.getPassword(),operatorConfirmPasswordBox.getPassword())){

                JOptionPane.showMessageDialog(this,"OPERATOR ADDED SUCCESSFULLY","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this,"PASSWORD'S DO NOT MATCH.PLEASE TRY AGAIN","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
        operatorDeleteButton.addActionListener(e ->{

        });

        operatorMangeButton.addActionListener(e -> {
            backButton.setBounds(10, 202, 128, 32);
            ((JPanel) manageOperatorTabPanel.getSelectedComponent()).add(backButton);
            updateTable();
            setPanel(operatorManagePanel, rightPanel);
        });

        manageRoomsButton.addActionListener(e -> {
            backButton.setBounds(112, 500, 128, 32);
            roomEditorRightPanel.add(backButton);

            setPanel(roomEditorPanel, rightPanel);
        });

        editMealsMenuButton.addActionListener(e -> {
            backButton.setBounds(112, 500, 128, 32);
            menuEditorRightPanel.add(backButton);

            setPanel(menuEditorPanel, rightPanel);
        });

        manageOperatorTabPanel.addChangeListener(e -> {
            ((JPanel) manageOperatorTabPanel.getSelectedComponent()).add(backButton);
        });

        visitorDatabaseButton.addActionListener(e -> {
            backButton.setBounds(12, 12, 128, 32);
            reportsButtonPanel.add(backButton);

            reportsHeader.setText("REGISTERED VISITORS");
            reportsStartDatePicker.setVisible(false);
            reportsEndDatePicker.setVisible(false);
            reportsDateRangeLabel.setVisible(false);

            // todo change reportsTable

            setPanel(reportsPanel, rightPanel);
        });

        transactionReportButton.addActionListener(e -> {
            backButton.setBounds(12, 12, 128, 32);
            reportsButtonPanel.add(backButton);

            reportsHeader.setText("RECENT TRANSACTIONS");
            reportsStartDatePicker.setVisible(true);
            reportsEndDatePicker.setVisible(true);
            reportsDateRangeLabel.setVisible(true);

            // todo change reportsTable

            setPanel(reportsPanel, rightPanel);
        });

        currentBookingsButton.addActionListener(e -> {

            backButton.setBounds(12, 12, 128, 32);
            reportsButtonPanel.add(backButton);

            reportsHeader.setText("CURRENT BOOKINGS");
            reportsStartDatePicker.setVisible(true);
            reportsEndDatePicker.setVisible(true);
            reportsDateRangeLabel.setVisible(true);

            // todo change reportsTable

            setPanel(reportsPanel, rightPanel);
        });
        /// endregion
        System.out.println("Reading database file...");
        try {
            operators = FileHandler.readFile("operators");
            System.out.println("DONE!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                RoomHelper.writeToFile();
                MenuHelper.writeToFile();
                VisitorHelper.writeToFile();
                try {
                    FileHandler.writeFile("operators", operators);
                    System.out.println("DONE!");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    void updateTable() {
        Object[][] data = toObjectsArray(operators);
        ((DefaultTableModel)operatorTable.getModel()).setDataVector(data, getColumns());
    }
    public static Object[] toObjects(Operator operator) {
        return new Object[] {operator.getUid(), operator.getName(), operator.getEmail(),new String(operator.getPassword()),operator.getPhoneNumber(), operator.getAddress() };
    }

    static Object[] getColumns() {
        return new Object[] { "USER ID", "NAME","EMAIL","PASSWORD","PHONE NUMBER","ADDRESS" };
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
