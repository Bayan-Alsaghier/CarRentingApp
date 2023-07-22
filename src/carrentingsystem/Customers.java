package carrentingsystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JRadioButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Color;

public class Customers {

	JFrame frame;
	private JTextField nID;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField cID;
	private JTable table;
	private String gender;
	private JTextField DoB;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers window = new Customers();
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
	public Customers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Customers");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.setBounds(100, 100, 730, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nID = new JTextField();
		nID.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		
		cID = new JTextField();
		cID.setColumns(10);
		
		JRadioButton male = new JRadioButton("M");
		male.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(male);
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "M";
			}
		});
		
		JRadioButton female = new JRadioButton("F");
		female.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(female);
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "F";
			}
		});
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName = new JLabel("National ID Number");
		lblCustomerFullName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1 = new JLabel("Customer Full Name");
		lblCustomerFullName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1_1 = new JLabel("Gender");
		lblCustomerFullName_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1_1_1 = new JLabel("DoB");
		lblCustomerFullName_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1_1_1_1 = new JLabel("Phone Number");
		lblCustomerFullName_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCustomerFullName_1_1_1_1_1 = new JLabel("Address");
		lblCustomerFullName_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Add New Customer");
		btnNewButton.setBackground(new Color(238, 232, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(cID.getText().equals(" ") || nID.getText().equals(" ")|| address.getText().equals(" ") || phone.getText().equals(" ") || name.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
						PreparedStatement st  = con.prepareStatement("insert into customer (CUSTOMER_ID,NATIONAL_ID,FULL_NAME,GENDER,DOB,PHONE_NUMBER,ADDRESS) values (?,?,?,?,?,?,?)");
						st.setString(1, cID.getText());
						st.setString(2, nID.getText());
						st.setString(3, name.getText());
						st.setString(4, gender);
						st.setString(5, DoB.getText());
						st.setString(6, phone.getText());
						st.setString(7, address.getText());
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
		
		JButton btnNewButton_1 = new JButton("Delete Customer");
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement pr  = con.prepareStatement("Delete from customer where CUSTOMER_ID =' " +cID.getText()+" '");
					pr.execute();
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("Show All Customers");
		btnNewButton_1_1_1.setBackground(new Color(255, 248, 220));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from customer");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		DoB = new JTextField();
		DoB.setColumns(10);
		
		JLabel lblCustomerFullName_1_1_1_2 = new JLabel("Ex: 01-MAY-1990");
		lblCustomerFullName_1_1_1_2.setForeground(new Color(50, 205, 50));
		lblCustomerFullName_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage window = new HomePage();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from customer where CUSTOMER_ID =' " +search.getText()+" ' ");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(143, 188, 143));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		search = new JTextField();
		search.setColumns(10);
		
		JLabel lblCustomerFullName_1_1_1_2_1 = new JLabel("Ex: 5");
		lblCustomerFullName_1_1_1_2_1.setForeground(new Color(50, 205, 50));
		lblCustomerFullName_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_4 = new JButton("Filter By Name");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from customer ORDER BY FULL_NAME");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBackground(Color.ORANGE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addComponent(lblCustomerFullName)
										.addComponent(lblCustomerFullName_1_1_1_1)
										.addComponent(lblCustomerFullName_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCustomerFullName_1)
										.addComponent(lblCustomerFullName_1_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCustomerFullName_1_1_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nID, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(39)
									.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(108)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCustomerFullName_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(search, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnNewButton_3)))
									.addGap(79))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
									.addGap(90))))
						.addComponent(cID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(DoB, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblCustomerFullName_1_1_1_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(female)
									.addGap(18)
									.addComponent(male))
								.addComponent(phone, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(address, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
					.addGap(79))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerFullName)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomerFullName_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(female)
								.addComponent(male)
								.addComponent(lblCustomerFullName_1_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(DoB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerFullName_1_1_1)
						.addComponent(lblCustomerFullName_1_1_1_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerFullName_1_1_1_1)
								.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCustomerFullName_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerFullName_1_1_1_1_1)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "National ID Number", "Full Name", "Gender", "DoB", "Phone Number", "Address"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				cID.setText(model.getValueAt(i, 0).toString());
				nID.setText(model.getValueAt(i, 1).toString());
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
				address.setText(model.getValueAt(i, 6).toString());
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(82);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
