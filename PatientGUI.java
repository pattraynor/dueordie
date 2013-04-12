import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;


public class PatientGUI {
	public JFrame frame;
	private JPanel searchMedicalHistory;
	private JPanel viewProgress;
	private JPanel enterDailyInformation;
	private JComboBox<String> dayComboBox;
	private JComboBox<String> monthComboBox;
	private JComboBox<String> yearComboBox;
	private JButton btnGetMostRecent;
	private JLabel lblViewMedicalInformation;
	private JButton btnSearchVisit;
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
	private JPanel mainWindow;
	private JMenu mnNewMenu;
	private JMenuItem menuSave;
	private JMenuItem menuLogout;
	private JMenuItem menuEditAccount;
	private JPanel editAccount;
	private JTextField addressField;
	private JTextField insuranceField;
	private JTextField phoneNumberField;
	private JButton btnRefresh;
	private JButton btnUpdateInsurance;
	private JButton btnUpdateAddress;
	private JTextArea informationDisplay2;
	private JLabel lblInsurance;
	private JLabel lblAddress;
	private JButton btnUpdateNumber;
	private JPanel AccountInformation;
	private JTabbedPane tabbedPane;
	private JTextArea textArea;
	private JLabel lblOr;
	private JLabel lblAccountInformation;
	private JLabel lblToEditThis;
	private JLabel lblmgdl;
	private JLabel lbllbs;
	private JLabel lblGoToMenuedit;
	private JLabel lblsystolicdiastolic;

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
		frame.setResizable(false);
		frame.setBounds(700, 350, 694, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		mainWindow = new JPanel();
		frame.getContentPane().add(mainWindow, "name_18970707890334");
		mainWindow.setBackground(SystemColor.textHighlight);
		mainWindow.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(UIManager.getBorder("CheckBox.border"));
		tabbedPane.setBounds(0, 0, 688, 515);
		mainWindow.add(tabbedPane);

		AccountInformation = new JPanel();
		AccountInformation.setBackground(Color.WHITE);
		tabbedPane.addTab("My Account", null, AccountInformation, null);
		AccountInformation.setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(126, 62, 509, 297);
		AccountInformation.add(textArea);
		textArea.setText(Globals.userDatabase.getCurrentUser().toString());
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

		textArea.setEditable(false);
		
		lblAccountInformation = new JLabel("Account Information");
		lblAccountInformation.setForeground(SystemColor.textHighlight);
		lblAccountInformation.setFont(new Font("Consolas", Font.BOLD, 17));
		lblAccountInformation.setBounds(248, 11, 190, 27);
		AccountInformation.add(lblAccountInformation);
		
		lblToEditThis = new JLabel("To edit this information");
		lblToEditThis.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblToEditThis.setBounds(248, 444, 353, 14);
		AccountInformation.add(lblToEditThis);
		
		lblGoToMenuedit = new JLabel("Go to Menu->Edit Account");
		lblGoToMenuedit.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblGoToMenuedit.setBounds(248, 458, 353, 14);
		AccountInformation.add(lblGoToMenuedit);

		searchMedicalHistory = new JPanel();
		tabbedPane.addTab("Medical History", null, searchMedicalHistory, null);
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
		monthComboBox2.setBounds(73, 159, 52, 20);
		searchMedicalHistory.add(monthComboBox2);

		dayComboBox2.setBackground(Color.WHITE);
		dayComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox2.setToolTipText("1, 2 ,3\r\n");
		dayComboBox2.setBounds(123, 159, 50, 20);
		searchMedicalHistory.add(dayComboBox2);

		yearComboBox2.setBackground(Color.WHITE);
		yearComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox2.setToolTipText("1, 2 ,3\r\n");
		yearComboBox2.setBounds(172, 159, 58, 20);
		searchMedicalHistory.add(yearComboBox2);

		btnGetMostRecent = new JButton("Get Most Recent ");
		btnGetMostRecent.setForeground(Color.BLACK);
		btnGetMostRecent.setBackground(Color.WHITE);
		btnGetMostRecent.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGetMostRecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getLastVisit();
				if (tempVisit != null) {
					informationWindow.setText(tempVisit.toString());
				}

			}
		});
		btnGetMostRecent.setBounds(73, 342, 157, 50);
		lblViewMedicalInformation = new JLabel("Search By Date");

		btnSearchVisit = new JButton("Search");
		lblMonth = new JLabel("Month");
		lblDay = new JLabel("Day");
		lblYear = new JLabel("Year");

		searchMedicalHistory.add(btnGetMostRecent);
		lblMonth.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblMonth.setBounds(84, 145, 46, 14);

		searchMedicalHistory.add(lblMonth);
		lblDay.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblDay.setBounds(138, 145, 44, 14);

		searchMedicalHistory.add(lblDay);
		lblYear.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblYear.setBounds(184, 145, 46, 14);

		searchMedicalHistory.add(lblYear);
		lblViewMedicalInformation
				.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblViewMedicalInformation.setBounds(95, 104, 135, 44);

		searchMedicalHistory.add(lblViewMedicalInformation);
		btnSearchVisit.setForeground(Color.BLACK);
		btnSearchVisit.setBackground(Color.WHITE);
		btnSearchVisit.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnSearchVisit.addActionListener(new ActionListener() {
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
		btnSearchVisit.setBounds(73, 196, 157, 50);

		searchMedicalHistory.add(btnSearchVisit);

		informationWindow = new JTextArea();
		informationWindow.setFont(new Font("Monospaced", Font.PLAIN, 13));
		informationWindow.setBounds(332, 56, 337, 416);
		Border borderInfoWindow = BorderFactory.createLineBorder(Color.BLACK);
		informationWindow.setBorder(BorderFactory.createCompoundBorder(borderInfoWindow, 
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		searchMedicalHistory.add(informationWindow);
		informationWindow.setEditable(false);
		
		JLabel lblMedicalRecord = new JLabel("Medical Record");
		lblMedicalRecord.setForeground(SystemColor.textHighlight);
		lblMedicalRecord.setFont(new Font("Consolas", Font.BOLD, 17));
		lblMedicalRecord.setBounds(430, 11, 190, 27);
		searchMedicalHistory.add(lblMedicalRecord);
		
		lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblOr.setBounds(138, 272, 46, 44);
		searchMedicalHistory.add(lblOr);

		viewProgress = new JPanel();
		tabbedPane.addTab("Charts and Analysis", null, viewProgress, null);
		viewProgress.setLayout(null);

		editAccount = new JPanel();
		frame.getContentPane().add(editAccount, "name_46184208883226");
		editAccount.setBackground(Color.WHITE);
		editAccount.setLayout(null);

		addressField = new JTextField();
		addressField.setBounds(35, 426, 355, 23);
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

		btnUpdateInsurance = new JButton("Update Insurance");
		btnUpdateInsurance.setForeground(Color.BLACK);
		btnUpdateInsurance.setBackground(Color.LIGHT_GRAY);
		btnUpdateInsurance.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnUpdateInsurance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String insurance = insuranceField.getText();
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				tempPatient.setInsurance(insurance);
				insuranceField.setText("");

			}
		});
		btnUpdateInsurance.setBounds(220, 289, 170, 33);
		editAccount.add(btnUpdateInsurance);

		btnUpdateNumber = new JButton("Update Number");
		btnUpdateNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phoneNumber = phoneNumberField.getText();
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				tempPatient.setPhoneNumber(phoneNumber);
				phoneNumberField.setText("");

			}
		});
		btnUpdateNumber.setForeground(Color.BLACK);
		btnUpdateNumber.setBackground(Color.LIGHT_GRAY);
		btnUpdateNumber.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnUpdateNumber.setBounds(35, 289, 170, 33);
		editAccount.add(btnUpdateNumber);

		btnUpdateAddress = new JButton("Update Address");
		btnUpdateAddress.setForeground(Color.BLACK);
		btnUpdateAddress.setBackground(Color.LIGHT_GRAY);
		btnUpdateAddress.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String address = addressField.getText();
				Patient tempPatient = (Patient) Globals.userDatabase
						.getCurrentUser();
				tempPatient.setAddress(address);
				addressField.setText("");

			}
		});
		btnUpdateAddress.setBounds(221, 460, 169, 33);
		editAccount.add(btnUpdateAddress);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnChangePassword.setBackground(Color.LIGHT_GRAY);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				window.setToPassword();
			}
		});
		btnChangePassword.setBounds(442, 426, 211, 67);
		editAccount.add(btnChangePassword);

		informationDisplay2 = new JTextArea();
		informationDisplay2.setText((String) null);
		
		informationDisplay2.setEditable(false);
		informationDisplay2.setBackground(Color.WHITE);
		informationDisplay2.setBounds(10, 34, 664, 182);
		informationDisplay2.setText(Globals.userDatabase.getCurrentUser().toString());
		informationDisplay2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		editAccount.add(informationDisplay2);
	

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 227, 684, 8);
		editAccount.add(separator_1);

		btnRefresh = new JButton("REFRESH");
		btnRefresh.setForeground(SystemColor.textHighlight);
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				informationDisplay2.setText(Globals.userDatabase
						.getCurrentUser().toString());
			}
		});
		btnRefresh.setBounds(560, 11, 114, 23);
		editAccount.add(btnRefresh);

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
		lblAddress.setBounds(35, 411, 89, 14);
		editAccount.add(lblAddress);

		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(mainWindow);
				frame.getContentPane().revalidate();
				frame.repaint();
				textArea.setText(Globals.userDatabase
						.getCurrentUser().toString());
			}
		});
		btnBack.setBounds(10, 11, 114, 23);
		editAccount.add(btnBack);
		
		JButton btnSetUpSecurity = new JButton("Add Security Features");
		btnSetUpSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				window.setToAnswerQuestions();
			}
		});
		btnSetUpSecurity.setForeground(Color.BLACK);
		btnSetUpSecurity.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnSetUpSecurity.setBackground(Color.LIGHT_GRAY);
		btnSetUpSecurity.setBounds(442, 258, 211, 64);
		editAccount.add(btnSetUpSecurity);

		enterDailyInformation = new JPanel();
		frame.getContentPane()
				.add(enterDailyInformation, "name_46171595047936");
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
				bloodPressureTopBox.setText("");
				bloodPressureBotBox.setText("");
				WeightBox.setText("");
				bloodSugarBox.setText("");
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(mainWindow);
				frame.getContentPane().revalidate();
				frame.repaint();
			}

		});

		btnEnter.setBounds(281, 438, 148, 40);
		enterDailyInformation.add(btnEnter);

		WeightBox = new JTextField();
		WeightBox.setBackground(Color.WHITE);
		WeightBox.setBounds(300, 100, 103, 20);
		enterDailyInformation.add(WeightBox);
		WeightBox.setColumns(10);

		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBackground(Color.WHITE);
		bloodPressureTopBox.setBounds(366, 306, 37, 20);
		enterDailyInformation.add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);

		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBackground(Color.WHITE);
		bloodPressureBotBox.setBounds(300, 306, 37, 20);
		enterDailyInformation.add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);

		bloodSugarBox = new JTextField();
		bloodSugarBox.setBackground(Color.WHITE);
		bloodSugarBox.setBounds(300, 200, 103, 20);
		enterDailyInformation.add(bloodSugarBox);
		bloodSugarBox.setColumns(10);

		JLabel weightLabel = new JLabel("Weight ");
		weightLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		weightLabel.setBounds(298, 80, 73, 14);
		enterDailyInformation.add(weightLabel);

		JLabel bloodPressureTopLabel = new JLabel("Blood Pressure ");
		bloodPressureTopLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		bloodPressureTopLabel.setBounds(300, 280, 137, 14);
		enterDailyInformation.add(bloodPressureTopLabel);

		JLabel bloodSugarLabel = new JLabel("Blood Sugar ");
		bloodSugarLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		bloodSugarLabel.setBounds(300, 180, 109, 14);
		enterDailyInformation.add(bloodSugarLabel);

		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(280, 377, 46, 20);
		enterDailyInformation.add(monthComboBox);

		dayComboBox.setBackground(SystemColor.text);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(325, 377, 46, 20);
		enterDailyInformation.add(dayComboBox);

		yearComboBox.setBackground(SystemColor.text);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(371, 377, 58, 20);
		enterDailyInformation.add(yearComboBox);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(246, 379, 46, 14);
		enterDailyInformation.add(lblDate);

		JLabel lblMonth2 = new JLabel("Month");
		lblMonth2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMonth2.setBounds(289, 363, 37, 14);
		enterDailyInformation.add(lblMonth2);

		JLabel lblDay2 = new JLabel("Day");
		lblDay2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay2.setBounds(338, 363, 29, 14);
		enterDailyInformation.add(lblDay2);

		JLabel lblYear2 = new JLabel("Year");
		lblYear2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblYear2.setBounds(381, 362, 37, 17);
		enterDailyInformation.add(lblYear2);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(mainWindow);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});
		btnCancel.setBounds(10, 11, 89, 23);
		enterDailyInformation.add(btnCancel);
		
		lblmgdl = new JLabel("(mg/dL)");
		lblmgdl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblmgdl.setBounds(413, 204, 58, 14);
		enterDailyInformation.add(lblmgdl);
		
		lbllbs = new JLabel("(lbs)");
		lbllbs.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lbllbs.setBounds(413, 104, 73, 14);
		enterDailyInformation.add(lbllbs);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Consolas", Font.PLAIN, 12));
		label.setBounds(347, 310, 29, 14);
		enterDailyInformation.add(label);
		
		lblsystolicdiastolic = new JLabel("(Systolic/Diastolic)");
		lblsystolicdiastolic.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblsystolicdiastolic.setBounds(413, 309, 109, 14);
		enterDailyInformation.add(lblsystolicdiastolic);

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
		menuEditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(editAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});

		menuLogout = new JMenuItem("Logout");
		mnNewMenu.add(menuLogout);
		menuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
			}
		});

	}
}
