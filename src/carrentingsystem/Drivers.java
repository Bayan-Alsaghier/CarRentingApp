package carrentingsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.Color;

public class Drivers {

	JFrame frame;
	private JTextField dID;
	private JTextField lNumber;
	private JTextField name;
	private JTextField phone;
	private JTextField exYear;
	private JTable table;
	private JTextField DoB;
	private String gender;
	private String availble;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drivers window = new Drivers();
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
	public Drivers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame  = new JFrame("Driver");
		frame.getContentPane().setBackground(new Color(245, 245, 220));
		frame.setBounds(500, 500, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDriverId = new JLabel("Driver ID");
		lblDriverId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		dID = new JTextField();
		dID.setColumns(10);
		
		lNumber = new JTextField();
		lNumber.setColumns(10);
		
		JLabel lblLicenceNumber = new JLabel("Licence number");
		lblLicenceNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1 = new JLabel(" Full Name");
		lblCustomerFullName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel lblCustomerFullName_1_1 = new JLabel("Gender");
		lblCustomerFullName_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JRadioButton female = new JRadioButton("F");
		female.setFont(new Font("Tahoma", Font.BOLD, 12));
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "F";
			}
		});
		
		JRadioButton male = new JRadioButton("M");
		male.setFont(new Font("Tahoma", Font.BOLD, 12));
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "M";
			}
		});
		
		JLabel lblCustomerFullName_1_1_1 = new JLabel("DoB");
		lblCustomerFullName_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1_1_1_1 = new JLabel("Phone Number");
		lblCustomerFullName_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		phone = new JTextField();
		phone.setColumns(10);
		
		exYear = new JTextField();
		exYear.setColumns(10);
		
		JLabel lblCustomerFullName_1_1_1_1_1 = new JLabel("Experience Years");
		lblCustomerFullName_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JRadioButton AV = new JRadioButton("Available");
		AV.setFont(new Font("Tahoma", Font.BOLD, 12));
		AV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				availble = "A";
			}
		});
		
		JRadioButton NAV = new JRadioButton("Not Available");
		NAV.setFont(new Font("Tahoma", Font.BOLD, 12));
		NAV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				availble = "N";
			}
		});
		
		JLabel lblCustomerFullName_1_1_1_1_1_1 = new JLabel("Availability");
		lblCustomerFullName_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Add Driver");
		btnNewButton.setBackground(new Color(0, 250, 154));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dID.getText().equals(" ") || lNumber.getText().equals(" ")|| name.getText().equals(" ") || phone.getText().equals(" ") || DoB.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
						PreparedStatement st  = con.prepareStatement("insert into Driver (D_ID,L_NUMBER,FULL_NAME,GENDER,DOB,PHONE_NUMBER,E_YEAR,AV) values (?,?,?,?,?,?,?,?)");
						st.setString(1, dID.getText());
						st.setString(2, lNumber.getText());
						st.setString(3, name.getText());
						st.setString(4, gender);
						st.setString(5, DoB.getText());
						st.setString(6, phone.getText());
						st.setString(7, exYear.getText());
						st.setString(8, availble);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "saved successfully");
						con.close();
					}
					catch (Exception connectionless) {
						System.out.println(connectionless);
					}
				
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Delete Driver");
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement pr  = con.prepareStatement("Delete from Driver where D_ID =' " +dID.getText()+" '");
					pr.execute();
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement update  = con.prepareStatement("Update  driver set D_ID = ? , L_NUMBER = ? , FULL_NAME = ?, GENDER = ?, DOB = ? , PHONE_NUMBER= ? , E_YEAR = ? , AV = ? where D_ID=' " +dID.getText()+" ' ");
					update.setString(1, dID.getText());
					update.setString(2, lNumber.getText());
					update.setString(3, name.getText());
					update.setString(4, gender);
					update.setString(5, DoB.getText());
					update.setString(6, phone.getText());
					update.setString(7, exYear.getText());
					update.setString(8, availble);
					update.execute();
					JOptionPane.showMessageDialog(null, "Update successfully");
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
				
			}
				
			
		});
		
		DoB = new JTextField();
		DoB.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Show All Drivers");
		btnNewButton_2.setBackground(new Color(175, 238, 238));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from driver");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		JLabel lblCustomerFullName_1_1_1_2 = new JLabel("Ex: 01-MAY-1990");
		lblCustomerFullName_1_1_1_2.setForeground(new Color(50, 205, 50));
		lblCustomerFullName_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage window = new HomePage();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setBackground(new Color(50, 205, 50));
		
		search = new JTextField();
		search.setColumns(10);
		
		JLabel lblCustomerFullName_1_1_1_2_1 = new JLabel("Ex: 10");
		lblCustomerFullName_1_1_1_2_1.setForeground(new Color(50, 205, 50));
		lblCustomerFullName_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2_1_1 = new JButton("Search");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from driver where D_ID =' " +search.getText()+" ' ");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1.setBackground(new Color(219, 112, 147));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(16)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDriverId, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
											.addComponent(dID, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addGap(43))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblLicenceNumber, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblCustomerFullName_1_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
											.addGap(90)
											.addComponent(female, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(male)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCustomerFullName_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(lblCustomerFullName_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblCustomerFullName_1_1_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
														.addGap(33))
													.addComponent(lblCustomerFullName_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(16)
													.addComponent(lblCustomerFullName_1_1_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addGap(35)
															.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(AV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(NAV)))
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(phone, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED))
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(exYear, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
															.addPreferredGap(ComponentPlacement.RELATED)))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(DoB, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)))
												.addComponent(name, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lNumber, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)))))))
							.addGap(4)
							.addComponent(lblCustomerFullName_1_1_1_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(151))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(search, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerFullName_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2_1_1, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(102)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDriverId)
						.addComponent(dID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLicenceNumber)
								.addComponent(lNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomerFullName_1))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerFullName_1_1)
								.addComponent(male)
								.addComponent(female))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerFullName_1_1_1)
								.addComponent(DoB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomerFullName_1_1_1_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomerFullName_1_1_1_1))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(exYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomerFullName_1_1_1_1_1))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(AV)
								.addComponent(lblCustomerFullName_1_1_1_1_1_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NAV)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_2_1_1)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCustomerFullName_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Drivr ID", "License Number", "Driver Full Name", "Gender", "DoB", "Phone Number", "Experince Year", "Availability"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				dID.setText(model.getValueAt(i, 0).toString());
				lNumber.setText(model.getValueAt(i, 1).toString());
				name.setText(model.getValueAt(i, 2).toString());
				gender = model.getValueAt(i, 3).toString();
				if (gender.equals("M")) {
					male.setSelected(true);
				}
				else {
					female.setSelected(true);
				}
				DoB.setText(model.getValueAt(i, 4).toString());
				phone.setText(model.getValueAt(i, 5).toString());
				exYear.setText(model.getValueAt(i, 6).toString());
				availble = model.getValueAt(i, 7).toString();
				if (availble.equals("A")) {
					AV.setSelected(true);
				}
				else {
					NAV.setSelected(true);
				}
			}
		});
		
		
		
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
