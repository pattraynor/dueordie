import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;


public class PatientGUI {
	public JFrame frame;
	private JPanel searchMedicalHistory;
	private JPanel viewProgress;
	private JPanel enterDailyInformation;
	private JComboBox<String> dayComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> yearComboBox;
	private JButton getMostRecent;
	private JLabel lblViewMedicalInformation;
	private JButton searchVisit;
	private int day, month, year;
	private JLabel lblMonth;
	private JLabel lblDay;
	private JLabel lblYear;
	private JTextArea informationWindow;
	private JTextField WeightBox;
	private JTextField bloodPressureTopBox;
	private JTextField bloodPressureBotBox;
	private JTextField bloodSugarBox;
	private JComboBox<String> dayComboBox2;
	private JComboBox<String> monthComboBox2;
	private JComboBox<String> yearComboBox2;
	private double temperature, weight, height, bloodPressureTop,
			bloodPressureBot, bloodSugar;
	private JPanel patientAccount;
	private JTextArea informationDisplay;
	private JMenu mnNewMenu;
	private Button viewProgressButton;
	private Button viewMedicalButton;
	private Button viewAccountButton;
	private JMenuItem menuSave;
	private JMenuItem menuLogout;
	private JMenuItem menuEditAccount;
	private JPanel editAccount;
	private JTextField addressField;
	private JTextField insuranceField;
	private JTextField phoneNumberField;
	private JButton refreshButton;
	private JButton updateInsuranceField;
	private JButton updateAddressButton;
	private JTextArea informationDisplay2;
	private JLabel lblInsurance;
	private JLabel lblAddress;
	private JButton updateNumberButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PatientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 350, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		patientAccount = new JPanel();
		frame.getContentPane().add(patientAccount, "name_18970707890334");
		patientAccount.setBackground(Color.WHITE);
		patientAccount.setLayout(null);

		

		JLabel lblNewLabel_2 = new JLabel("Account Information");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_2.setBounds(91, 11, 232, 20);
		patientAccount.add(lblNewLabel_2);

		informationDisplay = new JTextArea();
		informationDisplay.setBackground(Color.WHITE);
		informationDisplay.setEditable(false);
		informationDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
		informationDisplay.setBounds(10, 42, 360, 385);
		patientAccount.add(informationDisplay);
		informationDisplay.setText(Globals.userDatabase.getCurrentUser()
				.toString());

		enterDailyInformation = new JPanel();
		frame.getContentPane()
				.add(enterDailyInformation, "name_18980754575334");
		enterDailyInformation.setBackground(Color.WHITE);
		enterDailyInformation.setLayout(null);

		// ------------------------------------------------------------------
		// Search Medical History
		// --------------------------------------------------------------------

		dayComboBox = new JComboBox<String>();
		monthComboBox = new JComboBox<String>();
		yearComboBox = new JComboBox<String>();
		enterDailyInformation.setLayout(null);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnEnter.setForeground(Color.BLACK);
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (WeightBox.getText().length() > 0) {
					weight = Double.parseDouble(WeightBox.getText());
				} else
					weight = 0;

				if (bloodPressureTopBox.getText().length() > 0) {
					bloodPressureTop = Double.parseDouble(bloodPressureTopBox
							.getText());
				} else
					bloodPressureTop = 0;

				if (bloodPressureBotBox.getText().length() > 0) {
					bloodPressureBot = Double.parseDouble(bloodPressureBotBox
							.getText());
				} else
					bloodPressureBot = 0;

				if (bloodSugarBox.getText().length() > 0) {
					bloodSugar = Double.parseDouble(bloodSugarBox.getText());
				} else
					bloodSugar = 0;

				int day = Integer.parseInt(dayComboBox.getSelectedItem()
						.toString());
				int month = Integer.parseInt(monthComboBox.getSelectedItem()
						.toString());
				int year = Integer.parseInt(yearComboBox.getSelectedItem()
						.toString());

				User tempUser = Globals.userDatabase.getCurrentUser();

				if (tempUser instanceof Patient) {

					Visit newVisit = new Visit(month, day, year,
							bloodPressureTop, bloodPressureBot, bloodSugar,
							weight, height, temperature);
					Patient tempPatient = (Patient) tempUser;
					tempPatient.getMedicalRecord().addVisit(newVisit);

				}
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(patientAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
			}

		});

		btnEnter.setBounds(462, 227, 166, 58);
		enterDailyInformation.add(btnEnter);

		WeightBox = new JTextField();
		WeightBox.setBounds(291, 74, 89, 20);
		enterDailyInformation.add(WeightBox);
		WeightBox.setColumns(10);

		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBounds(291, 136, 89, 20);
		enterDailyInformation.add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);

		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBounds(291, 197, 89, 20);
		enterDailyInformation.add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);

		bloodSugarBox = new JTextField();
		bloodSugarBox.setBounds(291, 265, 89, 20);
		enterDailyInformation.add(bloodSugarBox);
		bloodSugarBox.setColumns(10);

		JLabel weightLabel = new JLabel("Weight (lbs)");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		weightLabel.setBounds(176, 77, 73, 14);
		enterDailyInformation.add(weightLabel);

		JLabel bloodPressureTopLabel = new JLabel("Blood Pressure Top");
		bloodPressureTopLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureTopLabel.setBounds(176, 139, 116, 14);
		enterDailyInformation.add(bloodPressureTopLabel);

		JLabel bloodSugarLabel = new JLabel("Blood Sugar (mg/dL)");
		bloodSugarLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodSugarLabel.setBounds(176, 268, 135, 14);
		enterDailyInformation.add(bloodSugarLabel);

		JLabel bloodPressureBotLabel = new JLabel("Blood Pressure Bot");
		bloodPressureBotLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureBotLabel.setBounds(176, 200, 116, 14);
		enterDailyInformation.add(bloodPressureBotLabel);

		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(462, 168, 46, 20);
		enterDailyInformation.add(monthComboBox);

		dayComboBox.setBackground(SystemColor.text);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(518, 168, 46, 20);
		enterDailyInformation.add(dayComboBox);

		yearComboBox.setBackground(SystemColor.text);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(570, 168, 58, 20);
		enterDailyInformation.add(yearComboBox);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(428, 170, 46, 14);
		enterDailyInformation.add(lblDate);

		JLabel lblMonth2 = new JLabel("Month");
		lblMonth2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMonth2.setBounds(462, 153, 37, 14);
		enterDailyInformation.add(lblMonth2);

		JLabel lblDay2 = new JLabel("Day");
		lblDay2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay2.setBounds(520, 153, 29, 14);
		enterDailyInformation.add(lblDay2);

		JLabel lblYear2 = new JLabel("Year");
		lblYear2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblYear2.setBounds(570, 152, 37, 17);
		enterDailyInformation.add(lblYear2);

		searchMedicalHistory = new JPanel();
		frame.getContentPane().add(searchMedicalHistory, "name_18985202491491");
		searchMedicalHistory.setBackground(Color.WHITE);
		searchMedicalHistory.setLayout(null);
		dayComboBox2 = new JComboBox<String>();
		monthComboBox2 = new JComboBox<String>();
		yearComboBox2 = new JComboBox<String>();

		monthComboBox2.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox2.setBackground(Color.WHITE);
		monthComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox2
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		monthComboBox2.setToolTipText("1, 2 ,3\r\n");
		monthComboBox2.setBounds(130, 159, 52, 20);
		searchMedicalHistory.add(monthComboBox2);

		dayComboBox2.setBackground(Color.WHITE);
		dayComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox2.setToolTipText("1, 2 ,3\r\n");
		dayComboBox2.setBounds(182, 159, 48, 20);
		searchMedicalHistory.add(dayComboBox2);

		yearComboBox2.setBackground(Color.WHITE);
		yearComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox2.setToolTipText("1, 2 ,3\r\n");
		yearComboBox2.setBounds(229, 159, 58, 20);
		searchMedicalHistory.add(yearComboBox2);

		getMostRecent = new JButton("Get Most Recent ");
		getMostRecent.setForeground(Color.BLACK);
		getMostRecent.setBackground(Color.WHITE);
		getMostRecent.setFont(new Font("Consolas", Font.PLAIN, 11));
		getMostRecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getLastVisit();
				if (tempVisit != null) {
					informationWindow.setText(tempVisit.toString());
				}

			}
		});
		getMostRecent.setBounds(130, 341, 157, 50);
		lblViewMedicalInformation = new JLabel("Search By Date");

		searchVisit = new JButton("Search");
		lblMonth = new JLabel("Month");
		lblDay = new JLabel("Day");
		lblYear = new JLabel("Year");

		searchMedicalHistory.add(getMostRecent);
		lblMonth.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblMonth.setBounds(240, 145, 46, 14);

		searchMedicalHistory.add(lblMonth);
		lblDay.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblDay.setBounds(196, 145, 46, 14);

		searchMedicalHistory.add(lblDay);
		lblYear.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblYear.setBounds(143, 145, 46, 14);

		searchMedicalHistory.add(lblYear);
		lblViewMedicalInformation
				.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblViewMedicalInformation.setBounds(152, 94, 135, 44);

		searchMedicalHistory.add(lblViewMedicalInformation);
		searchVisit.setForeground(Color.BLACK);
		searchVisit.setBackground(Color.WHITE);
		searchVisit.setFont(new Font("Consolas", Font.PLAIN, 11));
		searchVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				day = Integer.parseInt(dayComboBox2.getSelectedItem()
						.toString());
				month = Integer.parseInt(monthComboBox2.getSelectedItem()
						.toString());
				year = Integer.parseInt(yearComboBox2.getSelectedItem()
						.toString());
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getVisit(
						month, day, year);
				if (tempVisit != null) {
					informationWindow.setText(tempVisit.toString());
				}
				if (tempVisit != null && tempVisit.getDay() <= 0) {
					informationWindow.setText("No Information to Display.");
				}
			}
		});
		searchVisit.setBounds(130, 190, 157, 50);

		searchMedicalHistory.add(searchVisit);

		informationWindow = new JTextArea();
		informationWindow.setFont(new Font("Monospaced", Font.PLAIN, 13));
		informationWindow.setBounds(399, 11, 275, 416);
		searchMedicalHistory.add(informationWindow);
		informationWindow.setEditable(false);

		viewProgress = new JPanel();
		frame.getContentPane().add(viewProgress, "name_18989156376860");
		viewProgress.setLayout(null);
		
		editAccount = new JPanel();
		editAccount.setBackground(Color.WHITE);
		frame.getContentPane().add(editAccount, "name_28521593453304");
		editAccount.setLayout(null);
		
		
		addressField = new JTextField();
		addressField.setBounds(35, 354, 355, 23);
		editAccount.add(addressField);
		addressField.setColumns(10);
		
		insuranceField = new JTextField();
		insuranceField.setBounds(220, 258, 170, 20);
		editAccount.add(insuranceField);
		insuranceField.setColumns(10);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(35, 258, 170, 20);
		editAccount.add(phoneNumberField);
		
		updateInsuranceField = new JButton("Update Insurance");
		updateInsuranceField.setForeground(Color.BLACK);
		updateInsuranceField.setBackground(Color.LIGHT_GRAY);
		updateInsuranceField.setFont(new Font("Monospaced", Font.BOLD, 13));
		updateInsuranceField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String insurance = insuranceField.getText();
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				tempPatient.setInsurance(insurance);
				
			}
		});
		updateInsuranceField.setBounds(220, 289, 170, 33);
		editAccount.add(updateInsuranceField);
		
		updateNumberButton = new JButton("Update Number");
		updateNumberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneNumber = phoneNumberField.getText();
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				tempPatient.setPhoneNumber(phoneNumber);
			
				
				
			}
		});
		updateNumberButton.setForeground(Color.BLACK);
		updateNumberButton.setBackground(Color.LIGHT_GRAY);
		updateNumberButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		updateNumberButton.setBounds(35, 289, 170, 33);
		editAccount.add(updateNumberButton);
		
		updateAddressButton = new JButton("Update Address");
		updateAddressButton.setForeground(Color.BLACK);
		updateAddressButton.setBackground(Color.LIGHT_GRAY);
		updateAddressButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		updateAddressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String address = addressField.getText();
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				tempPatient.setAddress(address);
			
			}
		});
		updateAddressButton.setBounds(221, 388, 169, 33);
		editAccount.add(updateAddressButton);
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.setForeground(Color.BLACK);
		changePasswordButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		changePasswordButton.setBackground(Color.WHITE);
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
			}
		});
		changePasswordButton.setBounds(472, 299, 170, 78);
		editAccount.add(changePasswordButton);
		
		informationDisplay2 = new JTextArea();
		informationDisplay2.setText((String) null);
		informationDisplay2.setFont(new Font("Arial", Font.PLAIN, 14));
		informationDisplay2.setEditable(false);
		informationDisplay2.setBackground(Color.WHITE);
		informationDisplay2.setBounds(10, 23, 664, 163);
		editAccount.add(informationDisplay2);
		informationDisplay2.setText(Globals.userDatabase.getCurrentUser()
				.toString());
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 227, 684, 8);
		editAccount.add(separator_1);
		
	
		refreshButton = new JButton("Refresh");
		refreshButton.setForeground(Color.BLACK);
		refreshButton.setBackground(Color.WHITE);
		refreshButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				informationDisplay2.setText(Globals.userDatabase
						.getCurrentUser().toString());
			}
		});
		refreshButton.setBounds(545, 197, 97, 23);
		editAccount.add(refreshButton);
		
		JLabel lblNewLabel = new JLabel("Phone Number");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel.setBounds(35, 243, 89, 14);
		editAccount.add(lblNewLabel);
		
		lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblInsurance.setBounds(220, 242, 89, 14);
		editAccount.add(lblInsurance);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAddress.setBounds(35, 340, 89, 14);
		editAccount.add(lblAddress);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		frame.setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);

		menuSave = new JMenuItem("Save ");
		mnNewMenu.add(menuSave);
		
		JMenuItem menuNewEntry = new JMenuItem("New Entry");
		mnNewMenu.add(menuNewEntry);
		menuNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(enterDailyInformation);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});

		menuEditAccount = new JMenuItem("Edit Account");
		mnNewMenu.add(menuEditAccount);
		menuEditAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(editAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});
		

		menuLogout = new JMenuItem("Logout");
		mnNewMenu.add(menuLogout);
		menuLogout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
			}
		});

		viewMedicalButton = new Button("Medical History");
		viewMedicalButton.setBackground(Color.WHITE);
		viewMedicalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(searchMedicalHistory);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});

		viewAccountButton = new Button("Account Information");
		viewAccountButton.setBackground(Color.WHITE);
		viewAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(patientAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});
		menuBar.add(viewAccountButton);
		menuBar.add(viewMedicalButton);

		viewProgressButton = new Button("View Progress");
		viewProgressButton.setBackground(Color.WHITE);
		menuBar.add(viewProgressButton);

	}
}
