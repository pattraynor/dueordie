

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;




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
	private JTextField nameBox;
	private JTextField patientIDBox;
	private JTextPane symptomsBox;
	private JLabel lblUserExists = new JLabel("User Exists");
	private JLabel lblUserNotFound = new JLabel("User not Found");
	private double temperature, weight, height, bloodPressureTop, bloodPressureBot, bloodSugar;
	private String symptoms, name, ID; 
	private JPanel createAccount;
	private JPanel enterPatientInformation;
	private JPanel mainMenu;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField addressField;
	private JTextField insuranceField;
	private JTextField numberField;
	private ButtonGroup radioGroup;
	private JLabel lblInsurance, lblAddress, lblPhoneNumber;
	private JRadioButton nurseButton, patientButton;
	private JTextField doctorField;
	private JLabel lblDoctor;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public NurseGUI() {
		initialize();
	}
	
	private void clearTextFields()
	{
		nameBox.setText("");
		patientIDBox.setText("");
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		insuranceField.setText("");
		numberField.setText("");
		doctorField.setText("");
		temperatureBox.setText("");
		weightBox.setText("");
		heightBox.setText("");
		bloodPressureTopBox.setText("");
		bloodPressureBotBox.setText("");
		bloodSugarBox.setText("");
		symptomsBox.setText("");
		lblUserExists.setVisible(false);
		lblUserNotFound.setVisible(false);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 350, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu = new JPanel();
		mainMenu.setBackground(Color.WHITE);
		frame.getContentPane().add(mainMenu, "name_23546861032426");
		mainMenu.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(createAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(134, 139, 202, 51);
		mainMenu.add(btnNewButton);
		
		JButton btnEnterPatientInfo = new JButton("Enter Patient Info");
		btnEnterPatientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(enterPatientInformation);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});
		btnEnterPatientInfo.setForeground(Color.BLACK);
		btnEnterPatientInfo.setBackground(Color.WHITE);
		btnEnterPatientInfo.setBounds(134, 239, 202, 51);
		mainMenu.add(btnEnterPatientInfo);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
			}
		});
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnLogout.setBounds(375, 11, 99, 27);
		mainMenu.add(btnLogout);
		
		enterPatientInformation = new JPanel();
		frame.getContentPane().add(enterPatientInformation, "name_23551793417647");
		enterPatientInformation.setLayout(null);
		
		createAccount = new JPanel();
		createAccount.setBackground(Color.WHITE);
		frame.getContentPane().add(createAccount, "name_23592594807845");
		createAccount.setLayout(null);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(112, 154, 109, 25);
		createAccount.add(firstNameField);
		firstNameField.setColumns(10);
		
		radioGroup = new ButtonGroup();
		patientButton = new JRadioButton("Patient");
		patientButton.setBackground(Color.WHITE);
		patientButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		patientButton.setBounds(172, 55, 137, 23);
		radioGroup.add(patientButton);
		createAccount.add(patientButton);
		patientButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg1) 
			{
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
		nurseButton.setBounds(172, 96, 137, 23);
		radioGroup.add(nurseButton);
		createAccount.add(nurseButton);
		nurseButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg1) 
			{
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
		lastNameField.setBounds(266, 154, 109, 25);
		createAccount.add(lastNameField);
		lastNameField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(112, 289, 263, 25);
		createAccount.add(addressField);
		
		insuranceField = new JTextField();
		insuranceField.setColumns(10);
		insuranceField.setBounds(266, 227, 109, 25);
		createAccount.add(insuranceField);
		
		numberField = new JTextField();
		numberField.setColumns(10);
		numberField.setBounds(112, 227, 109, 25);
		createAccount.add(numberField);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAccountType.setBounds(54, 78, 109, 14);
		createAccount.add(lblAccountType);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblFirstName.setBounds(112, 140, 109, 14);
		createAccount.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblLastName.setBounds(266, 140, 109, 14);
		createAccount.add(lblLastName);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(112, 214, 109, 14);
		createAccount.add(lblPhoneNumber);
		
		lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblInsurance.setBounds(266, 214, 109, 14);
		createAccount.add(lblInsurance);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAddress.setBounds(112, 275, 109, 14);
		createAccount.add(lblAddress);
		
		JLabel lblAccountCreation = new JLabel("Create Account");
		lblAccountCreation.setForeground(SystemColor.textHighlight);
		lblAccountCreation.setFont(new Font("Consolas", Font.BOLD, 15));
		lblAccountCreation.setBackground(Color.WHITE);
		lblAccountCreation.setBounds(180, 0, 143, 48);
		createAccount.add(lblAccountCreation);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(patientButton.isSelected())
				{
					User tempUser;
					String doctorID = doctorField.getText();
					
					tempUser = Globals.userDatabase.searchUserID(doctorID);
					System.out.println("dur");
					if(tempUser != null)
					{
					Doctor patientDoctor = (Doctor) tempUser;
					String newPin = Globals.userDatabase.generateUserID();
					String newName = firstNameField.toString() + lastNameField.getText();
					Patient newPatient = new Patient(newName, newPin, patientDoctor, insuranceField.getText(), numberField.getText(), addressField.getText());
					String patientID = Globals.userDatabase.addUser(newPatient);
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Account was created\nUser ID: " + patientID + "\nPassword: " + newPin, "Account Created",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, options, options[0]);
					frame.getContentPane().removeAll();
					frame.getContentPane().invalidate();
					clearTextFields();
					frame.getContentPane().add(mainMenu);
					frame.getContentPane().revalidate();
					frame.repaint();
					}
					else 
					{
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(null, "Please enter the correct Doctor ID", "Wrong Doctor ID",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);
					}
					
					
				}
				if(nurseButton.isSelected())
				{
					String newPin = Globals.userDatabase.generateUserID();
					String newName =  firstNameField.getText() + lastNameField.getText();
					Nurse newNurse = new Nurse(newName, newPin);
					String nurseID = Globals.userDatabase.addUser(newNurse);
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Account was created\nUser ID: " + nurseID + "\n Password: " + newPin, "Account Created",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
					frame.getContentPane().removeAll();
					frame.getContentPane().invalidate();
					clearTextFields();
					frame.getContentPane().add(mainMenu);
					frame.getContentPane().revalidate();
					frame.repaint();
					
				}
			}
		});
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnCreate.setBackground(SystemColor.textHighlight);
		btnCreate.setBounds(179, 412, 130, 23);
		createAccount.add(btnCreate);
		
		doctorField = new JTextField();
		doctorField.setColumns(10);
		doctorField.setBounds(112, 352, 109, 25);
		createAccount.add(doctorField);
		
		lblDoctor = new JLabel("Doctor ID");
		lblDoctor.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblDoctor.setBounds(112, 338, 109, 14);
		createAccount.add(lblDoctor);
		
		
		JButton btnGoBack = new JButton("<- Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				clearTextFields();
				frame.getContentPane().add(mainMenu);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});
		btnGoBack.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGoBack.setBackground(Color.LIGHT_GRAY);
		btnGoBack.setBounds(10, 11, 83, 23);
		enterPatientInformation.add(btnGoBack);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnEnter.setForeground(SystemColor.textHighlight);
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
		
				
				if(temperatureBox.getText().length() > 0)
				{
					temperature = Double.parseDouble(temperatureBox.getText());
				}
				else 
					temperature = 0;
				
				if(weightBox.getText().length() > 0)
				{
					weight = Double.parseDouble(weightBox.getText());
				}
				else 
					weight = 0;
				
				if(heightBox.getText().length() > 0)
				{
					height = Double.parseDouble(heightBox.getText());
				}
				else 
					height = 0;
				
				if(bloodPressureTopBox.getText().length() > 0)
				{
					bloodPressureTop = Double.parseDouble(bloodPressureTopBox.getText());
				}
				else 
					bloodPressureTop = 0;
				
				if(bloodPressureBotBox.getText().length() > 0)
				{
					bloodPressureBot = Double.parseDouble(bloodPressureBotBox.getText());
				}
				else 
					bloodPressureBot = 0;
				
				if(bloodSugarBox.getText().length() > 0)
				{
					bloodSugar = Double.parseDouble(bloodSugarBox.getText());
				}
				else 
					bloodSugar = 0;
				
				if(symptomsBox.getText().length() > 0)
				{
					symptoms = symptomsBox.getText();
				}
				else 
					symptoms = "";
				
				
				int day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
				int month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
				int year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
				
				if(nameBox.getText().length() > 0)
				{
					name = nameBox.getText();
					Patient tempPatient;
					User tempUser;
					if(Globals.userDatabase.searchUserName(name) != null)
					{
						tempUser = Globals.userDatabase.searchUserName(name);
						
						if(tempUser instanceof Patient)
						{
						
							Visit newVisit = new Visit(month, day, year, bloodPressureTop,
							bloodPressureBot, bloodSugar, weight, height, temperature, symptoms);
							tempPatient = (Patient) tempUser;
							tempPatient.getMedicalRecord().addVisit(newVisit);



                            frame.getContentPane().removeAll();
							frame.getContentPane().invalidate();

							clearTextFields();
							


							frame.getContentPane().add(mainMenu);
                            frame.getContentPane().revalidate();
                            frame.repaint();
							
						}
						
					}
					
				}
				else	
				{
					if(patientIDBox.getText().length() > 0)
					{
						ID = patientIDBox.getText().toString();
						Patient tempPatient;
						User tempUser;
						if(Globals.userDatabase.searchUserID(ID) != null)
						{
							tempUser = Globals.userDatabase.searchUserID(ID);
							if(tempUser instanceof Patient)
							{
								Visit newVisit = new Visit(month, day, year, bloodPressureTop,
								bloodPressureBot, bloodSugar, weight, height, temperature, symptoms);
								tempPatient = (Patient) tempUser;
								tempPatient.getMedicalRecord().addVisit(newVisit);
								frame.getContentPane().removeAll();
								frame.getContentPane().invalidate();
								clearTextFields();
								frame.getContentPane().add(mainMenu);
								frame.getContentPane().revalidate();
								frame.repaint();
								
							}
						}
					}
				}
				
				
			}
		});
		btnEnter.setBounds(325, 388, 97, 23);
		enterPatientInformation.add(btnEnter);
		
		temperatureBox = new JTextField();
		temperatureBox.setBounds(376, 170, 46, 20);
		enterPatientInformation.add(temperatureBox);
		temperatureBox.setColumns(10);
		
		weightBox = new JTextField();
		weightBox.setBounds(376, 201, 46, 20);
		enterPatientInformation.add(weightBox);
		weightBox.setColumns(10);
		
		heightBox = new JTextField();
		heightBox.setBounds(376, 232, 46, 20);
		enterPatientInformation.add(heightBox);
		heightBox.setColumns(10);
		
		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBounds(376, 263, 46, 20);
		enterPatientInformation.add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);
		
		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBounds(376, 294, 46, 20);
		enterPatientInformation.add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);
		
		bloodSugarBox = new JTextField();
		bloodSugarBox.setBounds(376, 325, 46, 20);
		enterPatientInformation.add(bloodSugarBox);
		bloodSugarBox.setColumns(10);
		
		JLabel temperatureLabel = new JLabel("Temperature (F)");
		temperatureLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		temperatureLabel.setBounds(262, 173, 94, 14);
		enterPatientInformation.add(temperatureLabel);
		
		JLabel weightLabel = new JLabel("Weight (lbs)");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		weightLabel.setBounds(262, 204, 73, 14);
		enterPatientInformation.add(weightLabel);
		
		JLabel heightLabel = new JLabel("Height (inches)");
		heightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		heightLabel.setBounds(262, 235, 94, 14);
		enterPatientInformation.add(heightLabel);
		
		JLabel bloodPressureTopLabel = new JLabel("Blood Pressure Top");
		bloodPressureTopLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureTopLabel.setBounds(262, 266, 116, 14);
		enterPatientInformation.add(bloodPressureTopLabel);
		
		JLabel bloodSugarLabel = new JLabel("Blood Sugar (mg/dL)");
		bloodSugarLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodSugarLabel.setBounds(262, 328, 135, 14);
		enterPatientInformation.add(bloodSugarLabel);
		
		JLabel bloodPressureBotLabel = new JLabel("Blood Pressure Bot");
		bloodPressureBotLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureBotLabel.setBounds(262, 297, 116, 14);
		enterPatientInformation.add(bloodPressureBotLabel);
		
		JLabel lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setBounds(10, 311, 74, 14);
		enterPatientInformation.add(lblSymptoms);
		
		
		
		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(62, 215, 37, 20);
		enterPatientInformation.add(monthComboBox);

		dayComboBox.setBackground(SystemColor.text);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(109, 215, 37, 20);
		enterPatientInformation.add(dayComboBox);
		

		yearComboBox.setBackground(SystemColor.text);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(156, 215, 58, 20);
		enterPatientInformation.add(yearComboBox);
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 217, 46, 14);
		enterPatientInformation.add(lblDate);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMonth.setBounds(62, 204, 37, 14);
		enterPatientInformation.add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay.setBounds(109, 204, 29, 14);
		enterPatientInformation.add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblYear.setBounds(156, 204, 29, 14);
		enterPatientInformation.add(lblYear);
		
		nameBox = new JTextField();
		nameBox.setBounds(208, 71, 94, 20);
		enterPatientInformation.add(nameBox);
		nameBox.setColumns(10);
		
		JLabel lblPatientNameOr = new JLabel("Patient Name");
		lblPatientNameOr.setForeground(SystemColor.textHighlight);
		lblPatientNameOr.setFont(new Font("Consolas", Font.BOLD, 13));
		lblPatientNameOr.setBounds(100, 74, 103, 14);
		enterPatientInformation.add(lblPatientNameOr);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setForeground(SystemColor.textHighlight);
		lblPatientId.setFont(new Font("Consolas", Font.BOLD, 13));
		lblPatientId.setBounds(100, 111, 98, 14);
		enterPatientInformation.add(lblPatientId);
		
		patientIDBox = new JTextField();
		patientIDBox.setColumns(10);
		patientIDBox.setBounds(208, 108, 94, 20);
		enterPatientInformation.add(patientIDBox);
		
		JLabel lblEnterPatientName = new JLabel("Enter Patient Name\r\n or Patient ID");
		lblEnterPatientName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEnterPatientName.setBounds(169, 37, 201, 23);
		enterPatientInformation.add(lblEnterPatientName);
		lblUserExists.setForeground(Color.GREEN);
		lblUserExists.setFont(new Font("Consolas", Font.ITALIC, 11));
		
		
		lblUserExists.setBounds(325, 111, 89, 14);
		enterPatientInformation.add(lblUserExists);
		lblUserExists.setVisible(false);
		
		lblUserNotFound.setForeground(new Color(220, 20, 60));
		lblUserNotFound.setFont(new Font("Consolas", Font.ITALIC, 11));
		lblUserNotFound.setBounds(332, 111, 103, 14);
		enterPatientInformation.add(lblUserNotFound);
		lblUserNotFound.setVisible(false);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCheck.setForeground(Color.BLACK);
		btnCheck.setBackground(Color.LIGHT_GRAY);
		btnCheck.setBounds(324, 70, 73, 23);
		enterPatientInformation.add(btnCheck);
		
		symptomsBox = new JTextPane();
		symptomsBox.setFont(new Font("Arial", Font.PLAIN, 12));
		symptomsBox.setBackground(Color.WHITE);
		symptomsBox.setBounds(10, 336, 204, 75);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		symptomsBox.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		enterPatientInformation.add(symptomsBox);
		
		btnCheck.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg1) 
			{
				String tempName;
				String tempID;
				if(nameBox.getText().length() > 0)
				{
					tempName = nameBox.getText();
					User tempUser = Globals.userDatabase.searchUserName(tempName);
					if(tempUser != null && tempUser instanceof Patient)
					{
						lblUserNotFound.setVisible(false);
						lblUserExists.setVisible(true);
					}
					else 
					{
						lblUserExists.setVisible(false);
						lblUserNotFound.setVisible(true);
					}
				}
				else	
				{
					if(patientIDBox.getText().length() > 0)
					{
						
						tempID =patientIDBox.getText().toString();
						
						User tempUser = Globals.userDatabase.searchUserID(tempID);
						if(tempUser != null && tempUser instanceof Patient)
						{
							lblUserNotFound.setVisible(false);
							lblUserExists.setVisible(true);
						}
						else 
						{
							lblUserExists.setVisible(false);
							lblUserNotFound.setVisible(true);
						}
					}
				}
				
				
			}
		});
		
		
		
		
	}
}

	
