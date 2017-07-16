package gs_project.hotel;

import gs_project.hotel.helpers.PrintUIWindow;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.OrientationRequested;

public class Receipt extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt("BOOKING ID", "CARD NUMBER", 4000, "ECONOMY:AC:BALCONY");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Receipt(String bookingID, String cardNumber, int initialPayment, String packageType) {
	    super("RECEIPT");
	    setResizable(false);
		setBounds(100, 100, 732, 420);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel receiptPanel = new JPanel();
		receiptPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		receiptPanel.setBackground(Color.WHITE);
		receiptPanel.setBounds(10, 11, 696, 345);
		contentPane.add(receiptPanel);
		receiptPanel.setLayout(null);
		
		JLabel header = new JLabel("RECEIPT");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Tahoma", Font.BOLD, 20));
		header.setBounds(10, 11, 674, 44);
		receiptPanel.add(header);
		
		JPanel stampPane = new JPanel();
		stampPane.setBorder(null);
		stampPane.setBackground(Color.WHITE);
		stampPane.setBounds(556, 107, 128, 141);
		receiptPanel.add(stampPane);
		stampPane.setLayout(null);
		
		JLabel stamp = new JLabel("");
		stamp.setBounds(0, 13, 128, 128);
		stampPane.add(stamp);
		stamp.setForeground(Color.GRAY);
		stamp.setVerticalAlignment(SwingConstants.TOP);
		stamp.setBorder(new LineBorder(Color.GRAY));
		Image i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reserved.png"));
		stamp.setIcon(new ImageIcon(i.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
		
		JLabel stampLabel = new JLabel("STAMP");
		stampLabel.setBounds(0, 0, 128, 14);
		stampPane.add(stampLabel);
		stampLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stampLabel.setForeground(Color.GRAY);
		stampLabel.setBorder(new LineBorder(Color.GRAY));
		
		JLabel bookIdLabel = new JLabel("BOOKING ID:");
		bookIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookIdLabel.setBounds(10, 66, 196, 28);
		receiptPanel.add(bookIdLabel);
		
		JLabel cardNumLabel = new JLabel("CARD NUMBER:");
		cardNumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cardNumLabel.setBounds(10, 120, 196, 28);
		receiptPanel.add(cardNumLabel);
		
		JLabel packTypeLabel = new JLabel("PACKAGE TYPE:");
		packTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		packTypeLabel.setBounds(10, 236, 196, 44);
		receiptPanel.add(packTypeLabel);
		
		JLabel initPaymentLabel = new JLabel("INITIAL PAYMENT:");
		initPaymentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		initPaymentLabel.setBounds(10, 176, 196, 28);
		receiptPanel.add(initPaymentLabel);
		
		JLabel bookId = new JLabel(bookingID);
		bookId.setBackground(Color.WHITE);
		bookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookId.setBounds(216, 66, 468, 28);
		receiptPanel.add(bookId);
		
		JLabel cardNum = new JLabel(cardNumber);
		cardNum.setBackground(Color.WHITE);
		cardNum.setFont(new Font("Tahoma", Font.BOLD, 14));
		cardNum.setBounds(216, 120, 322, 28);
		receiptPanel.add(cardNum);
		
		JLabel initPayment = new JLabel("₹ " + initialPayment);
		initPayment.setBackground(Color.WHITE);
		initPayment.setFont(new Font("Tahoma", Font.BOLD, 14));
		initPayment.setBounds(216, 176, 322, 28);
		receiptPanel.add(initPayment);
		
		JLabel packType = new JLabel(packageType);
		packType.setFont(new Font("Tahoma", Font.BOLD, 18));
		packType.setBounds(10, 290, 674, 44);
		packType.setHorizontalAlignment(SwingConstants.CENTER);
		receiptPanel.add(packType);
		
		JButton printButton = new JButton("PRINT");
		printButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		printButton.setBounds(278, 358, 176, 23);
		contentPane.add(printButton);

		printButton.addActionListener(new PrintUIWindow(receiptPanel, OrientationRequested.LANDSCAPE));
	}
}
