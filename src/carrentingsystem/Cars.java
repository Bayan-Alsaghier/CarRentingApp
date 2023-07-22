package carrentingsystem;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import org.apache.commons.dbutils.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Cars {

	JFrame frame;
	private JTextField number;
	private JTextField carmodel;
	private JTextField carstate;
	private JTextField hourrent;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblCarModel;
	private JLabel lblCarState;
	private JLabel lblHourlyRentingPrice;
	private JButton btnNewButton;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cars window = new Cars();
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
	public Cars() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cars");
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(500, 550, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		number = new JTextField();
		number.setColumns(10);
		
		carmodel = new JTextField();
		carmodel.setColumns(10);
		
		carstate = new JTextField();
		carstate.setColumns(10);
		
		hourrent = new JTextField();
		hourrent.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Car");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final Object [] row = new Object [4]; 
				if(number.getText().equals(" ") || carmodel.getText().equals(" ")|| carstate.getText().equals(" ") || hourrent.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
						PreparedStatement st  = con.prepareStatement("insert into car (CAR_NUMBER,CAR_MODEL,CAR_STATE,HRP) values (?,?,?,?)");
						st.setString(1, number.getText());
						st.setString(2, carmodel.getText());
						st.setString(3, carstate.getText());
						st.setString(4, hourrent.getText());
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "saved successfully");
						con.close();
					}
					catch (Exception connectionless) {
						System.out.println(connectionless);
					}
				row[0] = number.getText();
				row [1] = carmodel.getText();
				row [2] = carstate.getText();
				row [3] = hourrent.getText();
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				tblModel.addRow(row);
				number.setText(" ");
				carmodel.setText(" ");
				carstate.setText(" ");
				hourrent.setText(" ");
				}
			
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Delete Car");
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement pr  = con.prepareStatement("Delete from car where CAR_NUMBER =' " +number.getText()+" '");
					pr.execute();
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("Edit Car Info");
		btnNewButton_1_1_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					PreparedStatement update  = con.prepareStatement("Update  car set CAR_NUMBER =' " +number.getText()+" ' , CAR_MODEL =' " +carmodel.getText()+" ',CAR_STATE =' " +carstate.getText()+" ',HRP =' " +hourrent.getText()+" ' where CAR_NUMBER =' " +number.getText()+" ' "   );
					update.execute();
					JOptionPane.showMessageDialog(null, "Update successfully");
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
				
			}
		});
		
		JButton btnNewButton_1_1_1_1 = new JButton("Cleaning");
		btnNewButton_1_1_1_1.setBackground(new Color(255, 192, 203));
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.setText(" ");
				carmodel.setText(" ");
				carstate.setText(" ");
				hourrent.setText(" ");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblNewLabel = new JLabel("Car Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblCarModel = new JLabel("Car Model");
		lblCarModel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblCarState = new JLabel("Car State");
		lblCarState.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblHourlyRentingPrice = new JLabel("Hourly Renting Price");
		lblHourlyRentingPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnNewButton = new JButton("Show Cars");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","1990");
					Statement st  = con.createStatement();
					ResultSet rs = st.executeQuery("select * from car");
					table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch (Exception connectionless) {
					System.out.println(connectionless);
				}
			}
		});
		
		btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage window = new HomePage();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(181)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(lblCarModel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(98)
							.addComponent(lblCarState, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addComponent(number, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
									.addGap(45)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(carmodel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addGap(35)
											.addComponent(carstate, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
									.addGap(38)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(hourrent, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHourlyRentingPrice, Alignment.LEADING)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCarState)
										.addComponent(lblNewLabel)
										.addComponent(lblCarModel)
										.addComponent(lblHourlyRentingPrice))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(hourrent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(carstate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(carmodel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(number, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(44)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_1_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
									.addGap(38)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(259)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				number.setText(model.getValueAt(i, 0).toString());
				carmodel.setText(model.getValueAt(i, 1).toString());
				carstate.setText(model.getValueAt(i, 2).toString());
				hourrent.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Registration Number", "Car Model", "Car State", "Hourly Renting Price"
			}
		));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
