package carrentingsystem;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class HomePage {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	ImageIcon logo = new ImageIcon (getClass().getClassLoader().getResource("Rent.jpg"));
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Home Window");
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 715, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(logo.getImage());
		JButton btnNewButton_1 = new JButton("Drivers");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Drivers windowD = new Drivers();
				windowD.frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Customers");
		btnNewButton_1_1.setBackground(new Color(175, 238, 238));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Customers window = new Customers();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("Cars");
		btnNewButton_1_1_1.setBackground(new Color(238, 232, 170));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Cars window = new Cars();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1_1_1 = new JButton("Booking");
		btnNewButton_1_1_1_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Booking window = new Booking();
				window.frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Eclips Workspace\\Car Renting Project\\Rent.png"));
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(100, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(73))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(305)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(284, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
