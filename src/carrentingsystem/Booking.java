package carrentingsystem;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.Color;
public class Booking<Availble_drivers> {
	JFrame frame;
	private JTextField total;
	private JTextField price;
	private JTable table;
	private JComboBox names;
	private JTextField cID;
	private JTextField carID;
	private JTextField rentingdate;
	private JTextField restordate;
	private JTextField bID;
	private String availble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking window = new Booking();
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
	public Booking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Booking");
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 853, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		total = new JTextField();
		total.setColumns(10);
		
		price = new JTextField();
		price.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Booking");
		btnNewButton.setBackground(new Color(253, 245, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cID.getText().equals(" ") || carID.getText().equals(" ")|| rentingdate.getText().equals(" ") || total.getText().equals(" ") || price.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
						PreparedStatement st  = con.prepareStatement("insert into booking (BOOKING_ID,CAR_NUMBER,CUSTOMER_ID,RENTING_DATE,RESTORATION_DATE,TOTAL_DAYS,PRICE,DRIVER) values (?,?,?,?,?,?,?,?)");
						st.setString(1, bID.getText());
						st.setString(2, carID.getText());
						st.setString(3, cID.getText());
						st.setString(4, rentingdate.getText());
						st.setString(5, restordate.getText());
						st.setString(6, total.getText());
						st.setString(7, price.getText());
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
		
		JButton btnNewButton_1 = new JButton("Edit Booking");
		btnNewButton_1.setBackground(new Color(175, 238, 238));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement update  = con.prepareStatement("Update  booking set BOOKING_ID = ? , CAR_NUMBER = ? , CUSTOMER_ID = ?, RENTING_DATE = ?, RESTORATION_DATE = ? , TOTAL_DAYS= ? , PRICE = ? , DRIVER = ? where BOOKING_ID=' " +bID.getText()+" ' ");
					update.setString(1, bID.getText());
					update.setString(2, carID.getText());
					update.setString(3, cID.getText());
					update.setString(4, rentingdate.getText());
					update.setString(5, restordate.getText());
					update.setString(6, total.getText());
					update.setString(7, price.getText());
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
		
		JButton btnNewButton_1_1 = new JButton("Delete Booking");
		btnNewButton_1_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement pr  = con.prepareStatement("Delete from booking where BOOKING_ID =' " +bID.getText()+" '");
					pr.execute();
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCar = new JLabel("Car ID");
		lblCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRentingDate = new JLabel("Renting Date");
		lblRentingDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRestorationDate = new JLabel("Restoration Date");
		lblRestorationDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblTotalDays = new JLabel("Total Days");
		lblTotalDays.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox driver = new JCheckBox("");
		driver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				availble = "D";
			}
		});
		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		cID = new JTextField();
		cID.setColumns(10);
		
		carID = new JTextField();
		carID.setColumns(10);
		
		rentingdate = new JTextField();
		rentingdate.setColumns(10);
		
		restordate = new JTextField();
		restordate.setColumns(10);
		
		bID = new JTextField();
		bID.setColumns(10);
		
		JLabel lblCar_1 = new JLabel("Booking ID");
		lblCar_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Show All Booking");
		btnNewButton_2.setBackground(new Color(173, 216, 230));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from booking");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(55, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
															.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblRentingDate)
																.addComponent(lblCar_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
																.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																	.addComponent(lblNewLabel)
																	.addComponent(lblCar, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
															.addGap(30))
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(lblTotalDays, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
															.addGap(18)))
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(32)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(lblDriver)
															.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
												.addGap(10))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblRestorationDate)
												.addGap(18)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(total, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(rentingdate, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addComponent(restordate, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addComponent(bID, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addComponent(cID, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addComponent(carID, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(10)
														.addComponent(driver))
													.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addGap(18))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addGap(40)))
								.addGap(18))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(110)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addGap(23)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCar_1))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(carID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rentingdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRentingDate))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(restordate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRestorationDate))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(total, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalDays))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrice))
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(driver)
									.addGap(23)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblDriver))
							.addGap(18)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				bID.setText(model.getValueAt(i, 0).toString());
				carID.setText(model.getValueAt(i, 1).toString());
				cID.setText(model.getValueAt(i, 2).toString());
				rentingdate.setText(model.getValueAt(i, 3).toString());
				restordate.setText(model.getValueAt(i, 4).toString());
				total.setText(model.getValueAt(i, 5).toString());
				price.setText(model.getValueAt(i, 6).toString());
				availble = model.getValueAt(i, 7).toString();
				if (availble.equals("D")) {
					driver.setSelected(true);
				}
				else {
					driver.setSelected(false);
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Booking ID", "Car ID", "Customer ID", "Renting Date", "Restoring Date", "Price", "Driver"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(94);
		table.getColumnModel().getColumn(4).setPreferredWidth(91);
		table.getColumnModel().getColumn(5).setPreferredWidth(82);
		table.getColumnModel().getColumn(6).setPreferredWidth(83);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
