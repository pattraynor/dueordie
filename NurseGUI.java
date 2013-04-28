import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
	private String symptoms;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField addressField;
	private JTextField insuranceField;
	private JTextField numberField;
	private JLabel lblInsurance, lblAddress, lblPhoneNumber;
	private JRadioButton nurseButton, patientButton;
	private JList<String> patientList;
	private JPanel nurseMain;
	private JPanel editAccount;
	private JComboBox<String> doctorList, doctorSelection;
	private JTabbedPane tabbedPane;
	DefaultListModel<String> listModel;;

	public NurseGUI() {
		initialize();
	}
	
	public void setFieldsBlank()
	{
		temperatureBox.setText("");
		weightBox.setText("");
		heightBox.setText("");
		bloodPressureTopBox.setText("");
		bloodPressureBotBox.setText("");
		bloodSugarBox.setText("");
		dayComboBox.setSelectedIndex(0);
		monthComboBox.setSelectedIndex(0);
		yearComboBox.setSelectedIndex(0);
		symptomsBox.setText("");
	}

	private void initialize() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				NurseGUI.class
						.getResource("/images/app_window_black_icon&32.png")));
		frame.setResizable(false);
		frame.setBounds(700, 350, 686, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new CardLayout(0, 0));

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
		menuSave.setIcon(new ImageIcon(NurseGUI.class
				.getResource("/images/save_icon&16.png")));
		mnNewMenu.add(menuSave);
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Globals.fileHandler.saveDatabase();
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
		JMenuItem menuEditAccount = new JMenuItem("Edit Account");
		menuEditAccount.setIcon(new ImageIcon(NurseGUI.class
				.getResource("/images/doc_edit_icon&16.png")));
		mnNewMenu.add(menuEditAccount);

		JMenuItem menuLogout = new JMenuItem("Logout");
		menuLogout.setIcon(new ImageIcon(NurseGUI.class
				.getResource("/images/1366296517_logout.png")));
		mnNewMenu.add(menuLogout);
		menuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
			}
		});
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

		listModel = new DefaultListModel<String>();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_9827206490587");
		tabbedPane.setBorder(UIManager.getBorder("CheckBox.border"));

		nurseMain = new JPanel();
		nurseMain.setBackground(Color.WHITE);
		tabbedPane.addTab("My Account", null, nurseMain, null);
		nurseMain.setLayout(null);

		JLabel label = new JLabel("Nurse "
				+ Globals.userDatabase.getCurrentUser().getUserName());
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Consolas", Font.BOLD, 17));
		label.setBounds(205, 11, 362, 27);
		nurseMain.add(label);

		JPanel createAccount = new JPanel();
		tabbedPane.addTab("Create a new Account", null, createAccount, null);
		createAccount.setBackground(Color.WHITE);
		createAccount.setLayout(null);

		firstNameField = new JTextField();
		firstNameField.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		firstNameField.setBounds(216, 154, 109, 25);
		createAccount.add(firstNameField);
		firstNameField.setColumns(10);
		patientButton = new JRadioButton("Patient");
		patientButton.setBackground(Color.WHITE);
		patientButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		patientButton.setBounds(352, 54, 137, 23);

		createAccount.add(patientButton);
		patientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				doctorSelection.setVisible(true);
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
		nurseButton.setBounds(352, 92, 137, 23);

		createAccount.add(nurseButton);
		nurseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				doctorSelection.setVisible(false);
				insuranceField.setVisible(false);
				numberField.setVisible(false);
				addressField.setVisible(false);
				lblInsurance.setVisible(false);
				lblPhoneNumber.setVisible(false);
				lblAddress.setVisible(false);
			}
		});

		lastNameField = new JTextField();
		lastNameField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(
				192, 192, 192), null, null, null));
		lastNameField.setBounds(352, 154, 109, 25);
		createAccount.add(lastNameField);
		lastNameField.setColumns(10);

		addressField = new JTextField();
		addressField.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		addressField.setColumns(10);
		addressField.setBounds(216, 288, 245, 25);
		createAccount.add(addressField);

		insuranceField = new JTextField();
		insuranceField.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		insuranceField.setColumns(10);
		insuranceField.setBounds(352, 227, 109, 25);
		createAccount.add(insuranceField);

		numberField = new JTextField();
		numberField.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(
				192, 192, 192), null, null, null));
		numberField.setColumns(10);
		numberField.setBounds(216, 227, 109, 25);
		createAccount.add(numberField);

		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAccountType.setBounds(237, 81, 109, 14);
		createAccount.add(lblAccountType);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblFirstName.setBounds(216, 140, 109, 14);
		createAccount.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblLastName.setBounds(352, 140, 109, 14);
		createAccount.add(lblLastName);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(216, 214, 109, 14);
		createAccount.add(lblPhoneNumber);

		lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblInsurance.setBounds(352, 214, 109, 14);
		createAccount.add(lblInsurance);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAddress.setBounds(216, 274, 109, 14);
		createAccount.add(lblAddress);

		JLabel lblAccountCreation = new JLabel("Create Account");
		lblAccountCreation.setForeground(SystemColor.textHighlight);
		lblAccountCreation.setFont(new Font("Consolas", Font.BOLD, 20));
		lblAccountCreation.setBackground(Color.WHITE);
		lblAccountCreation.setBounds(245, 0, 230, 48);
		createAccount.add(lblAccountCreation);

		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (patientButton.isSelected()) {

					Doctor patientDoctor = (Doctor) Globals.userDatabase
							.getUser(doctorSelection.getSelectedIndex());

					if (firstNameField.getText().length() > 0
							&& lastNameField.getText().length() > 0) {

						String newPin = Globals.userDatabase.generatePassword();
						String newName = firstNameField.getText() + " "
								+ lastNameField.getText();
						Patient newPatient = new Patient(newName, newPin,
								patientDoctor, insuranceField.getText(),
								numberField.getText(), addressField.getText());
						String patientID = Globals.userDatabase
								.addUser(newPatient);
						patientDoctor.addPatient(newPatient);
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null,
								"Account was created\nUser ID: " + patientID
										+ "\nPassword: " + newPin,
								"Account Created", JOptionPane.DEFAULT_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, options,
								options[0]);
						
						//sets the fields blank
						firstNameField.setText("");
						lastNameField.setText("");
						insuranceField.setText("");
						addressField.setText("");
						numberField.setText("");
						
						try {
							Globals.fileHandler.saveDatabase();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//sets the window back to the nurses main page
						frame.getContentPane().removeAll();
						frame.getContentPane().invalidate();
						frame.getContentPane().add(tabbedPane);
						tabbedPane.setSelectedIndex(0);
						frame.getContentPane().revalidate();
						frame.repaint();
					} else {
						Object[] options = { "OK" };
						JOptionPane
								.showOptionDialog(
										null,
										"Please do not leave fields for First and Last name blank!",
										"Empty Fields",
										JOptionPane.DEFAULT_OPTION,
										JOptionPane.WARNING_MESSAGE, null,
										options, options[0]);
					}

				}
				if (nurseButton.isSelected()) {

					if (firstNameField.getText().length() > 0
							&& lastNameField.getText().length() > 0) {
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
						
						try {
							Globals.fileHandler.saveDatabase();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
			}
		});
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Monospaced", Font.PLAIN, 14));
		btnCreate.setBackground(SystemColor.textHighlight);
		btnCreate.setBounds(286, 411, 116, 40);
		createAccount.add(btnCreate);
		radioGroup.add(nurseButton);
		radioGroup.add(patientButton);

		doctorSelection = new JComboBox<String>();
		doctorSelection.setBounds(216, 355, 150, 20);
		createAccount.add(doctorSelection);

		JLabel lblDoctorSelection = new JLabel("Doctor Selection");
		lblDoctorSelection.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblDoctorSelection.setBounds(216, 340, 129, 14);
		createAccount.add(lblDoctorSelection);
		JPanel enterPatientInformation = new JPanel();
		enterPatientInformation.setBackground(Color.WHITE);
		tabbedPane.addTab("New Patient Entry", null, enterPatientInformation,
				null);
		enterPatientInformation.setLayout(null);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBorder(null);
		btnEnter.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setBackground(SystemColor.textHighlight);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[] doubleInputs = { bloodPressureTopBox.getText(),
						bloodPressureBotBox.getText(), bloodSugarBox.getText(),
						weightBox.getText(), heightBox.getText(),
						temperatureBox.getText() };

				Double[] doubleArray = Globals.inputHandler
						.checkDoubleInputs(doubleInputs);

				if (doubleArray != null) {
					if (Globals.inputHandler.checkInputSize(doubleArray) == 0) {

						symptoms = symptomsBox.getText();

						int day = Integer.parseInt(dayComboBox
								.getSelectedItem().toString());
						int month = Integer.parseInt(monthComboBox
								.getSelectedItem().toString());
						int year = Integer.parseInt(yearComboBox
								.getSelectedItem().toString());

						int patientIndex = patientList.getSelectedIndex();
						Patient tempPatient = null;
						if (patientIndex >= 0) {
							int doctorIndex = doctorList.getSelectedIndex();
							Doctor doctorSelected = (Doctor) Globals.userDatabase
									.getUser(doctorIndex);
							tempPatient = doctorSelected
									.getPatient(patientIndex);

						}

						if (tempPatient != null) {

							Visit newVisit = new Visit(month, day, year,
									doubleArray[0], doubleArray[1],
									doubleArray[2], doubleArray[3],
									doubleArray[4], doubleArray[5], symptoms);

							tempPatient.getMedicalRecord().addVisit(newVisit);

							Object[] options = { "OK" };
							JOptionPane.showOptionDialog(
									null,
									"Patient Form for "
											+ tempPatient.getUserName()
											+ " was added to the database.",
									"Entry Submitted",
									JOptionPane.DEFAULT_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									options, options[0]);
							
							//makes the fields blank
							setFieldsBlank();
							
							try {
								Globals.fileHandler.saveDatabase();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							//refreshes the window
							frame.getContentPane().removeAll();
							frame.getContentPane().invalidate();
							frame.getContentPane().add(tabbedPane);
							tabbedPane.setSelectedIndex(2);
							frame.getContentPane().revalidate();
							frame.repaint();
						}

						else {
							Object[] options = { "OK" };
							JOptionPane
									.showOptionDialog(
											null,
											"Please select a patient from the list or enter patient's name in the Name box",
											"No Patient Selected",
											JOptionPane.DEFAULT_OPTION,
											JOptionPane.WARNING_MESSAGE, null,
											options, options[0]);
						}
					} else {
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null,
								"Please check inputs for errors",
								"Input out of Bounds",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);
					}

				} else {
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null,
							"Please check inputs for errors",
							"Wrong input type", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
				}

			}

		});
		btnEnter.setBounds(473, 351, 116, 41);
		enterPatientInformation.add(btnEnter);

		temperatureBox = new JTextField();
		temperatureBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		temperatureBox.setBounds(519, 290, 46, 20);
		enterPatientInformation.add(temperatureBox);
		temperatureBox.setColumns(10);

		weightBox = new JTextField();
		weightBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		weightBox.setBounds(519, 197, 46, 20);
		enterPatientInformation.add(weightBox);
		weightBox.setColumns(10);

		heightBox = new JTextField();
		heightBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		heightBox.setBounds(519, 228, 46, 20);
		enterPatientInformation.add(heightBox);
		heightBox.setColumns(10);

		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		bloodPressureTopBox.setBounds(519, 166, 46, 20);
		enterPatientInformation.add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);

		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		bloodPressureBotBox.setBounds(586, 166, 46, 20);
		enterPatientInformation.add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);

		bloodSugarBox = new JTextField();
		bloodSugarBox.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.LIGHT_GRAY, null, null, null));
		bloodSugarBox.setBounds(519, 259, 46, 20);
		enterPatientInformation.add(bloodSugarBox);
		bloodSugarBox.setColumns(10);

		JLabel temperatureLabel = new JLabel("Temperature (F)");
		temperatureLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		temperatureLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		temperatureLabel.setBounds(364, 294, 145, 14);
		enterPatientInformation.add(temperatureLabel);

		JLabel weightLabel = new JLabel("Weight (lbs)");
		weightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		weightLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		weightLabel.setBounds(373, 201, 136, 14);
		enterPatientInformation.add(weightLabel);

		JLabel heightLabel = new JLabel("Height (inches)");
		heightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		heightLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		heightLabel.setBounds(368, 232, 141, 14);
		enterPatientInformation.add(heightLabel);

		JLabel bloodSugarLabel = new JLabel("Blood Sugar (mg/dL)");
		bloodSugarLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		bloodSugarLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		bloodSugarLabel.setBounds(343, 263, 166, 14);
		enterPatientInformation.add(bloodSugarLabel);

		JLabel bloodPressureBotLabel = new JLabel("Blood Pressure ");
		bloodPressureBotLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		bloodPressureBotLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		bloodPressureBotLabel.setBounds(363, 170, 146, 14);
		enterPatientInformation.add(bloodPressureBotLabel);

		JLabel lblSymptoms = new JLabel("Symptoms:");
		lblSymptoms.setFont(new Font("Consolas", Font.BOLD, 12));
		lblSymptoms.setBounds(400, 98, 74, 14);
		enterPatientInformation.add(lblSymptoms);

		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(453, 69, 63, 20);
		enterPatientInformation.add(monthComboBox);

		dayComboBox.setBackground(SystemColor.text);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(519, 69, 46, 20);
		enterPatientInformation.add(dayComboBox);

		yearComboBox.setBackground(SystemColor.text);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020",
				"2021", "2022" }));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(569, 69, 63, 20);
		enterPatientInformation.add(yearComboBox);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Consolas", Font.BOLD, 12));
		lblDate.setBounds(400, 72, 46, 14);
		enterPatientInformation.add(lblDate);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMonth.setBounds(463, 52, 37, 14);
		enterPatientInformation.add(lblMonth);

		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay.setBounds(531, 52, 29, 14);
		enterPatientInformation.add(lblDay);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblYear.setBounds(586, 52, 29, 14);
		enterPatientInformation.add(lblYear);

		doctorList = new JComboBox<String>();
		doctorList.setForeground(Color.BLACK);
		doctorList.setBackground(Color.WHITE);
		doctorList.setFont(new Font("Monospaced", Font.PLAIN, 14));
		doctorList.setBounds(80, 111, 184, 20);
		enterPatientInformation.add(doctorList);

		JLabel lblDoctorList = new JLabel("Select Doctor");
		lblDoctorList.setFont(new Font("Consolas", Font.BOLD, 13));
		lblDoctorList.setBounds(80, 85, 116, 14);
		enterPatientInformation.add(lblDoctorList);

		JLabel lblPatientList = new JLabel("Patient List");
		lblPatientList.setFont(new Font("Consolas", Font.BOLD, 13));
		lblPatientList.setBounds(80, 205, 88, 14);
		enterPatientInformation.add(lblPatientList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 111, 232, 48);
		enterPatientInformation.add(scrollPane);

		symptomsBox = new JTextPane();
		scrollPane.setViewportView(symptomsBox);
		symptomsBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				Color.LIGHT_GRAY, null));
		symptomsBox.setFont(new Font("Arial", Font.PLAIN, 12));
		symptomsBox.setBackground(Color.WHITE);

		JLabel lblPatientVisitForm = new JLabel("Patient Visit Form");
		lblPatientVisitForm.setForeground(SystemColor.textHighlight);
		lblPatientVisitForm.setFont(new Font("Consolas", Font.BOLD, 17));
		lblPatientVisitForm.setBounds(453, 14, 190, 27);
		enterPatientInformation.add(lblPatientVisitForm);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(336, -22, 18, 498);
		enterPatientInformation.add(separator);

		JLabel lblPatientSelection = new JLabel("Patient Selection");
		lblPatientSelection.setForeground(SystemColor.textHighlight);
		lblPatientSelection.setFont(new Font("Consolas", Font.BOLD, 17));
		lblPatientSelection.setBounds(96, 14, 190, 27);
		enterPatientInformation.add(lblPatientSelection);

		JScrollPane scrollPanePatientList = new JScrollPane();
		scrollPanePatientList.setBounds(80, 229, 184, 113);
		enterPatientInformation.add(scrollPanePatientList);
		patientList = new JList<String>(listModel);
		patientList.setSelectionForeground(Color.BLACK);
		scrollPanePatientList.setViewportView(patientList);
		patientList.setBackground(Color.WHITE);
		patientList.setForeground(Color.BLACK);
		patientList.setFont(new Font("Monospaced", Font.PLAIN, 14));

		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Consolas", Font.BOLD, 12));
		label_1.setBounds(570, 170, 18, 14);
		enterPatientInformation.add(label_1);

		doctorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();

				Doctor doctorSelected = (Doctor) Globals.userDatabase
						.getUser(doctorList.getSelectedIndex());
				String[] patientNames = doctorSelected.getPatientNames();
				int index = 0;
				if (patientNames != null) {
					int arraySize = patientNames.length;
					while (index < arraySize) {
						listModel.addElement(patientNames[index]);
						index++;
					}
				}

			}
		});

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

		JButton btnBack = new JButton("< BACK");
		btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(160,
				160, 160), null, null, null));
		btnBack.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(tabbedPane);
				tabbedPane.setSelectedIndex(0);
				frame.getContentPane().revalidate();
				frame.repaint();
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
					doctorSelection.addItem(doctorNames[newIndex]);
					doctorList.addItem(doctorNames[newIndex]);
					newIndex++;
				}
			}
		}

	}
}
