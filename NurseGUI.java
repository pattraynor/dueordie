import javax.swing.ButtonGroup;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NurseGUI {

	public JFrame frame;
	private JTextField temperatureBox;
	private JTextField weightBox;
	private JTextField heightBox;
	private JTextField bloodPressureTopBox;
	private JTextField bloodPressureBotBox;
	private JTextField bloodSugarBox;
	private JComboBox<String> dayComboBox = new JComboBox<String>();
	private JComboBox<String> monthComboBox = new JComboBox<String>();
	private JComboBox<String> yearComboBox = new JComboBox<String>();
	private JTextPane symptomsBox;
	private double temperature, weight, height, bloodPressureTop,
			bloodPressureBot, bloodSugar;
	private String symptoms;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField addressField;
	private JTextField insuranceField;
	private JTextField numberField;
	private JLabel lblInsurance, lblAddress, lblPhoneNumber;
	private JRadioButton nurseButton, patientButton;
	private JTextField doctorField;
	private JLabel lblDoctor;
	private List doctorList;
	private List patientList;
	private JPanel nurseMain;
	private JTextArea textArea;
	private JPanel editAccount;


	public NurseGUI() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(700, 350, 686, 554);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frame.getContentPane().setLayout(new CardLayout(0, 0));
		JPanel mainWindow = new JPanel();

		frame.getContentPane().add(mainWindow, "name_18970707890334");
		mainWindow.setBackground(SystemColor.textHighlight);
		mainWindow.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 681, 508);
		mainWindow.add(tabbedPane);
		tabbedPane.setBorder(UIManager.getBorder("CheckBox.border"));
		
		nurseMain = new JPanel();
		nurseMain.setBackground(Color.WHITE);
		tabbedPane.addTab("My Account", null, nurseMain, null);
		nurseMain.setLayout(null);
		
	
		
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setText(Globals.userDatabase.getCurrentUser().print());
		textArea.setBounds(158, 109, 384, 126);
		nurseMain.add(textArea);
		
		JLabel label = new JLabel("Account Information");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Consolas", Font.BOLD, 17));
		label.setBounds(237, 11, 190, 27);
		nurseMain.add(label);
		
		JLabel lblNurse = new JLabel("Nurse");
		lblNurse.setForeground(SystemColor.textHighlight);
		lblNurse.setFont(new Font("Consolas", Font.BOLD, 17));
		lblNurse.setBounds(293, 46, 78, 27);
		nurseMain.add(lblNurse);
		JPanel enterPatientInformation = new JPanel();
		enterPatientInformation.setBackground(Color.WHITE);
		tabbedPane.addTab("New Patient Entry", null, enterPatientInformation,
				null);
		enterPatientInformation.setLayout(null);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.LIGHT_GRAY, null, null, null));
		btnEnter.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnEnter.setForeground(SystemColor.textHighlight);
		btnEnter.setBackground(Color.WHITE);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (temperatureBox.getText().length() > 0) {
					temperature = Double.parseDouble(temperatureBox.getText());
				} else
					temperature = 0;

				if (weightBox.getText().length() > 0) {
					weight = Double.parseDouble(weightBox.getText());
				} else
					weight = 0;

				if (heightBox.getText().length() > 0) {
					height = Double.parseDouble(heightBox.getText());
				} else
					height = 0;

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

				if (symptomsBox.getText().length() > 0) {
					symptoms = symptomsBox.getText();
				} else
					symptoms = "";

				int day = Integer.parseInt(dayComboBox.getSelectedItem()
						.toString());
				int month = Integer.parseInt(monthComboBox.getSelectedItem()
						.toString());
				int year = Integer.parseInt(yearComboBox.getSelectedItem()
						.toString());

				int patientIndex = patientList.getSelectedIndex();

				if (patientIndex >= 0) {
					int doctorIndex = doctorList.getSelectedIndex();
					Doctor doctorSelected = (Doctor) Globals.userDatabase
							.getUser(doctorIndex);
					Patient tempPatient = doctorSelected
							.getPatient(patientIndex);

					Visit newVisit = new Visit(month, day, year,
							bloodPressureTop, bloodPressureBot, bloodSugar,
							weight, height, temperature, symptoms);

					tempPatient.getMedicalRecord().addVisit(newVisit);

					frame.dispose();
					NurseGUI window = new NurseGUI();
					window.frame.setVisible(true);

				}

			}

		});
		btnEnter.setBounds(492, 389, 116, 41);
		enterPatientInformation.add(btnEnter);

		temperatureBox = new JTextField();
		temperatureBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		temperatureBox.setBounds(586, 170, 46, 20);
		enterPatientInformation.add(temperatureBox);
		temperatureBox.setColumns(10);

		weightBox = new JTextField();
		weightBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		weightBox.setBounds(586, 201, 46, 20);
		enterPatientInformation.add(weightBox);
		weightBox.setColumns(10);

		heightBox = new JTextField();
		heightBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		heightBox.setBounds(586, 232, 46, 20);
		enterPatientInformation.add(heightBox);
		heightBox.setColumns(10);

		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		bloodPressureTopBox.setBounds(586, 263, 46, 20);
		enterPatientInformation.add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);

		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		bloodPressureBotBox.setBounds(586, 294, 46, 20);
		enterPatientInformation.add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);

		bloodSugarBox = new JTextField();
		bloodSugarBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		bloodSugarBox.setBounds(586, 325, 46, 20);
		enterPatientInformation.add(bloodSugarBox);
		bloodSugarBox.setColumns(10);

		JLabel temperatureLabel = new JLabel("Temperature (F)");
		temperatureLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		temperatureLabel.setBounds(443, 174, 124, 14);
		enterPatientInformation.add(temperatureLabel);

		JLabel weightLabel = new JLabel("Weight (lbs)");
		weightLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		weightLabel.setBounds(443, 205, 103, 14);
		enterPatientInformation.add(weightLabel);

		JLabel heightLabel = new JLabel("Height (inches)");
		heightLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		heightLabel.setBounds(443, 238, 124, 14);
		enterPatientInformation.add(heightLabel);

		JLabel bloodPressureTopLabel = new JLabel("Blood Pressure Top");
		bloodPressureTopLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		bloodPressureTopLabel.setBounds(443, 267, 146, 14);
		enterPatientInformation.add(bloodPressureTopLabel);

		JLabel bloodSugarLabel = new JLabel("Blood Sugar (mg/dL)");
		bloodSugarLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		bloodSugarLabel.setBounds(443, 328, 165, 14);
		enterPatientInformation.add(bloodSugarLabel);

		JLabel bloodPressureBotLabel = new JLabel("Blood Pressure Bot");
		bloodPressureBotLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		bloodPressureBotLabel.setBounds(443, 297, 146, 14);
		enterPatientInformation.add(bloodPressureBotLabel);

		JLabel lblSymptoms = new JLabel("Symptoms:");
		lblSymptoms.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblSymptoms.setBounds(443, 94, 74, 14);
		enterPatientInformation.add(lblSymptoms);

		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(487, 43, 40, 20);
		enterPatientInformation.add(monthComboBox);

		dayComboBox.setBackground(SystemColor.text);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(529, 43, 43, 20);
		enterPatientInformation.add(dayComboBox);

		yearComboBox.setBackground(SystemColor.text);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(574, 43, 58, 20);
		enterPatientInformation.add(yearComboBox);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDate.setBounds(443, 46, 46, 14);
		enterPatientInformation.add(lblDate);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMonth.setBounds(492, 23, 37, 14);
		enterPatientInformation.add(lblMonth);

		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay.setBounds(538, 23, 29, 14);
		enterPatientInformation.add(lblDay);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblYear.setBounds(586, 23, 29, 14);
		enterPatientInformation.add(lblYear);

		doctorList = new List();
		doctorList.setBounds(84, 75, 184, 114);
		enterPatientInformation.add(doctorList);
		patientList = new List();
		patientList.setBounds(84, 261, 184, 114);
		enterPatientInformation.add(patientList);

		JLabel lblDoctorList = new JLabel("Doctor List");
		lblDoctorList.setFont(new Font("Consolas", Font.BOLD, 13));
		lblDoctorList.setBounds(84, 49, 88, 14);
		enterPatientInformation.add(lblDoctorList);

		JLabel lblPatientList = new JLabel("Patient List");
		lblPatientList.setFont(new Font("Consolas", Font.BOLD, 13));
		lblPatientList.setBounds(84, 236, 88, 14);
		enterPatientInformation.add(lblPatientList);

		JLabel lblDoubleClickOn = new JLabel("Double Click on Doctor");
		lblDoubleClickOn.setBounds(84, 195, 184, 14);
		enterPatientInformation.add(lblDoubleClickOn);

		JLabel lblDoubleClickOn_1 = new JLabel("Double Click on Patient");
		lblDoubleClickOn_1.setBounds(84, 380, 184, 14);
		enterPatientInformation.add(lblDoubleClickOn_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(443, 111, 189, 48);
		enterPatientInformation.add(scrollPane);

		symptomsBox = new JTextPane();
		scrollPane.setViewportView(symptomsBox);
		symptomsBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.LIGHT_GRAY, null));
		symptomsBox.setFont(new Font("Arial", Font.PLAIN, 12));
		symptomsBox.setBackground(Color.WHITE);
		
		JLabel lblSelectDoctorThen = new JLabel("Select doctor, then select patient.");
		lblSelectDoctorThen.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblSelectDoctorThen.setBounds(40, 15, 306, 29);
		enterPatientInformation.add(lblSelectDoctorThen);

		doctorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                patientList.removeAll();
				int index = doctorList.getSelectedIndex();
				Doctor doctorSelected = (Doctor) Globals.userDatabase
						.getUser(index);
				String[] patientNames = doctorSelected.getPatientNames();
				index = 0;
				if (patientNames != null) {
					int arraySize = patientNames.length;
					while (index < arraySize) {
						patientList.add(patientNames[index]);
						index++;
					}
				}

			}
		});

		JPanel createAccount = new JPanel();
		tabbedPane.addTab("Create a new Account", null, createAccount, null);
		createAccount.setBackground(Color.WHITE);
		createAccount.setLayout(null);

		firstNameField = new JTextField();
		firstNameField.setBounds(179, 154, 109, 25);
		createAccount.add(firstNameField);
		firstNameField.setColumns(10);
		patientButton = new JRadioButton("Patient");
		patientButton.setBackground(Color.WHITE);
		patientButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		patientButton.setBounds(266, 53, 137, 23);

		createAccount.add(patientButton);
		patientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				lblDoctor.setVisible(true);
				doctorField.setVisible(true);
				insuranceField.setVisible(true);
				numberField.setVisible(true);
				addressField.setVisible(true);
				lblInsurance.setVisible(true);
				lblPhoneNumber.setVisible(true);
				lblAddress.setVisible(true);
			}
		});
		nurseButton = new JRadioButton("Nurse");
		nurseButton.setBackground(Color.WHITE);
		nurseButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		nurseButton.setBounds(266, 96, 137, 23);

		createAccount.add(nurseButton);
		nurseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				lblDoctor.setVisible(false);
				doctorField.setVisible(false);
				insuranceField.setVisible(false);
				numberField.setVisible(false);
				addressField.setVisible(false);
				lblInsurance.setVisible(false);
				lblPhoneNumber.setVisible(false);
				lblAddress.setVisible(false);
			}
		});

		lastNameField = new JTextField();
		lastNameField.setBounds(342, 154, 109, 25);
		createAccount.add(lastNameField);
		lastNameField.setColumns(10);

		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(179, 289, 263, 25);
		createAccount.add(addressField);

		insuranceField = new JTextField();
		insuranceField.setColumns(10);
		insuranceField.setBounds(342, 227, 109, 25);
		createAccount.add(insuranceField);

		numberField = new JTextField();
		numberField.setColumns(10);
		numberField.setBounds(179, 227, 109, 25);
		createAccount.add(numberField);

		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAccountType.setBounds(151, 73, 109, 14);
		createAccount.add(lblAccountType);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblFirstName.setBounds(200, 140, 109, 14);
		createAccount.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblLastName.setBounds(370, 140, 109, 14);
		createAccount.add(lblLastName);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(179, 214, 109, 14);
		createAccount.add(lblPhoneNumber);

		lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblInsurance.setBounds(342, 214, 109, 14);
		createAccount.add(lblInsurance);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAddress.setBounds(179, 273, 109, 14);
		createAccount.add(lblAddress);

		JLabel lblAccountCreation = new JLabel("Create Account");
		lblAccountCreation.setForeground(SystemColor.textHighlight);
		lblAccountCreation.setFont(new Font("Consolas", Font.BOLD, 15));
		lblAccountCreation.setBackground(Color.WHITE);
		lblAccountCreation.setBounds(273, 0, 143, 48);
		createAccount.add(lblAccountCreation);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (patientButton.isSelected()) {
					User tempUser;
					String doctorID = doctorField.getText();

					tempUser = Globals.userDatabase.searchUserID(doctorID);

					if (tempUser != null) {
						Doctor patientDoctor = (Doctor) tempUser;
						String newPin = Globals.userDatabase.generatePassword();
						String newName = firstNameField.getText()
								+ lastNameField.getText();
						Patient newPatient = new Patient(newName, newPin,
								patientDoctor, insuranceField.getText(),
								numberField.getText(), addressField.getText());
						String patientID = Globals.userDatabase
								.addUser(newPatient);
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null,
								"Account was created\nUser ID: " + patientID
										+ "\nPassword: " + newPin,
								"Account Created", JOptionPane.DEFAULT_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, options,
								options[0]);
						frame.dispose();
						NurseGUI window = new NurseGUI();
						window.frame.setVisible(true);
					} else {
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null,
								"Please enter the correct Doctor ID",
								"Wrong Doctor ID", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
					}

				}
				if (nurseButton.isSelected()) {
					String newPin = Globals.userDatabase.generatePassword();
					String newName = firstNameField.getText()
							+ lastNameField.getText();
					Nurse newNurse = new Nurse(newName, newPin);
					String nurseID = Globals.userDatabase.addUser(newNurse);
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null,
							"Account was created\nUser ID: " + nurseID
									+ "\n Password: " + newPin,
							"Account Created", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					frame.dispose();
					NurseGUI window = new NurseGUI();
					window.frame.setVisible(true);

				}
			}
		});
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnCreate.setBackground(SystemColor.textHighlight);
		btnCreate.setBounds(245, 416, 130, 23);
		createAccount.add(btnCreate);

		doctorField = new JTextField();
		doctorField.setColumns(10);
		doctorField.setBounds(179, 352, 109, 25);
		createAccount.add(doctorField);

		lblDoctor = new JLabel("Doctor ID");
		lblDoctor.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblDoctor.setBounds(179, 339, 109, 14);
		createAccount.add(lblDoctor);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);

		JMenuItem menuSave = new JMenuItem("Save ");
		mnNewMenu.add(menuSave);
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Globals.userDatabase.saveDatabase();
				} catch (IOException e1) {
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null,
							"There was a problem with saving to the file",
							"Error", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
					e1.printStackTrace();
				}
			}
		});

		JMenuItem menuLogout = new JMenuItem("Logout");
		mnNewMenu.add(menuLogout);
		menuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
			}
		});
		JMenuItem menuEditAccount = new JMenuItem("Edit Account");
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


		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(nurseButton);
		radioGroup.add(patientButton);
		
		editAccount = new JPanel();
		editAccount.setBounds(0, 0, 10, 10);
		mainWindow.add(editAccount);
		
		editAccount = new JPanel();
		frame.getContentPane().add(editAccount, "name_46184208883226");
		editAccount.setBackground(Color.WHITE);
		editAccount.setLayout(null);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBorder(new BevelBorder(BevelBorder.RAISED,
				new Color(128, 128, 128), null, null, null));
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnChangePassword.setBackground(Color.WHITE);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				window.setToPassword();
			}
		});
		btnChangePassword.setBounds(222, 290, 211, 67);
		editAccount.add(btnChangePassword);

		JButton btnBack = new JButton("BACK");
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(160,
				160, 160), null, null, null));
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				NurseGUI window = new NurseGUI();
				window.frame.setVisible(true);
				
			}
		});
		btnBack.setBounds(10, 11, 114, 23);
		editAccount.add(btnBack);

		JButton btnSetUpSecurity = new JButton("Add Security Features");
		btnSetUpSecurity.setBorder(new BevelBorder(BevelBorder.RAISED,
				new Color(128, 128, 128), null, null, null));
		btnSetUpSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				window.setToAnswerQuestions();
			}
		});
		btnSetUpSecurity.setForeground(Color.BLACK);
		btnSetUpSecurity.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnSetUpSecurity.setBackground(Color.WHITE);
		btnSetUpSecurity.setBounds(222, 146, 211, 64);
		editAccount.add(btnSetUpSecurity);

		String[] doctorNames = Globals.userDatabase.getDoctorNames();
		int newIndex = 0;
		if (doctorNames != null) {
			int arraySize = doctorNames.length;
			if (arraySize > 0) {
				while (newIndex < arraySize) {
					doctorList.add(doctorNames[newIndex]);
					newIndex++;
				}
			}
		}
		

	}
}
