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
import javax.swing.JPasswordField;


public class PatientGUI {
	public JFrame frame;
	private JPanel mainMenu;
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
	private double temperature, weight, height, bloodPressureTop, bloodPressureBot, bloodSugar;
	private JPanel patientAccount;
	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JTextField newInsurance;
	private JTextField newAddress;
	private JButton btnRefreshInfo;
	private JButton btnUpdatePhoneNumber;
	private JTextField newPhoneNumber;
	private JTextArea informationDisplay;
	private JLabel lblNewPhoneNumber;
	private JLabel lblNewAddress;
	private JLabel lblInsurance;
	private JLabel lblNewPassword;
	
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
		frame.setBounds(700, 350, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu = new JPanel();
		mainMenu.setBackground(Color.WHITE);
		frame.getContentPane().add(mainMenu, "name_101192612223363");
		mainMenu.setLayout(null);
		
		searchMedicalHistory = new JPanel();
		searchMedicalHistory.setBackground(Color.WHITE);
		frame.getContentPane().add(searchMedicalHistory, "name_101194774405030");
		searchMedicalHistory.setLayout(null);
		
		enterDailyInformation = new JPanel();
		enterDailyInformation.setBackground(Color.WHITE);
		frame.getContentPane().add(enterDailyInformation, "name_101212507959946");
		enterDailyInformation.setLayout(null);
		
		viewProgress = new JPanel();
		frame.getContentPane().add(viewProgress, "name_101318021138167");
		viewProgress.setLayout(null);
		
		//------------------------------------------------------------
		// mainMenu
		//------------------------------------------------------------
		JButton btnEnterDailyInformation = new JButton("Enter Daily Information");
		btnEnterDailyInformation.setBounds(143, 230, 199, 51);
		mainMenu.add(btnEnterDailyInformation);
		btnEnterDailyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(enterDailyInformation);
				frame.getContentPane().revalidate();
				frame.repaint();
				
			}
		});
		btnEnterDailyInformation.setForeground(Color.BLACK);
		btnEnterDailyInformation.setBackground(Color.WHITE);
		btnEnterDailyInformation.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton btnSearchMedicalHistory = new JButton("Search Medical History");
		btnSearchMedicalHistory.setBounds(143, 313, 199, 51);
		mainMenu.add(btnSearchMedicalHistory);
		btnSearchMedicalHistory.setForeground(Color.BLACK);
		btnSearchMedicalHistory.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnSearchMedicalHistory.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("View Progress");
		btnNewButton.setBounds(143, 395, 199, 51);
		mainMenu.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnLogout.setBounds(380, 11, 94, 23);
		mainMenu.add(btnLogout);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton_1 = new JButton("Edit Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(patientAccount);
				frame.getContentPane().revalidate();
				frame.repaint();
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton_1.setBounds(143, 70, 199, 51);
		mainMenu.add(btnNewButton_1);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.dispose();
				LoginGUI window = new LoginGUI();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSearchMedicalHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(searchMedicalHistory);
				frame.getContentPane().revalidate();
				frame.repaint();
				
			}
		});
		
		//------------------------------------------------------------------
		//Search Medical History
		//--------------------------------------------------------------------
		
		dayComboBox = new JComboBox<String>();
		monthComboBox = new JComboBox<String>();
		yearComboBox = new JComboBox<String>();
		dayComboBox2 = new JComboBox<String>();
		monthComboBox2 = new JComboBox<String>();
		yearComboBox2 = new JComboBox<String>();
		
		monthComboBox2.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox2.setBackground(Color.WHITE);
		monthComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox2.setToolTipText("1, 2 ,3\r\n");
		monthComboBox2.setBounds(21, 159, 37, 20);
		searchMedicalHistory.add(monthComboBox2);

		dayComboBox2.setBackground(Color.WHITE);
		dayComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox2.setToolTipText("1, 2 ,3\r\n");
		dayComboBox2.setBounds(68, 159, 36, 20);
		searchMedicalHistory.add(dayComboBox2);
		

		yearComboBox2.setBackground(Color.WHITE);
		yearComboBox2.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		yearComboBox2.setToolTipText("1, 2 ,3\r\n");
		yearComboBox2.setBounds(120, 159, 58, 20);
		searchMedicalHistory.add(yearComboBox2);
		
		getMostRecent = new JButton("Get Most Recent ");
		getMostRecent.setForeground(Color.BLACK);
		getMostRecent.setBackground(Color.WHITE);
		getMostRecent.setFont(new Font("Consolas", Font.PLAIN, 11));
		getMostRecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getLastVisit();
				if(tempVisit != null)
				{
					informationWindow.setText(tempVisit.toString());
				}
				
			}
		});
		getMostRecent.setBounds(21, 349, 157, 50);
		lblViewMedicalInformation = new JLabel("Search By Date");
		
		
		searchVisit = new JButton("Search");
		lblMonth = new JLabel("Month");
		lblDay = new JLabel("Day");
		lblYear = new JLabel("Year");
		
		searchMedicalHistory.add(getMostRecent);
		lblMonth.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblMonth.setBounds(21, 145, 46, 14);
		
			
		
		searchMedicalHistory.add(lblMonth);
		lblDay.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblDay.setBounds(68, 145, 46, 14);
		
		searchMedicalHistory.add(lblDay);
		lblYear.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblYear.setBounds(130, 145, 46, 14);
		
		searchMedicalHistory.add(lblYear);
		lblViewMedicalInformation.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblViewMedicalInformation.setBounds(47, 104, 157, 44);
		
		searchMedicalHistory.add(lblViewMedicalInformation);
		searchVisit.setForeground(Color.BLACK);
		searchVisit.setBackground(Color.WHITE);
		searchVisit.setFont(new Font("Consolas", Font.PLAIN, 11));
		searchVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				day = Integer.parseInt(dayComboBox2.getSelectedItem().toString());
				month = Integer.parseInt(monthComboBox2.getSelectedItem().toString());
				year = Integer.parseInt(yearComboBox2.getSelectedItem().toString());
				Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getVisit(month, day, year);
				if(tempVisit != null)
				{
					informationWindow.setText(tempVisit.toString());
				}
				if(tempVisit != null && tempVisit.getDay() <= 0)
				{
					informationWindow.setText("No Information to Display.");
				}
			}
		});
		searchVisit.setBounds(21, 190, 157, 50);
		
		searchMedicalHistory.add(searchVisit);
		
		JButton button_1 = new JButton("<- Go Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(mainMenu);
				frame.getContentPane().revalidate();
				frame.repaint();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Monospaced", Font.PLAIN, 11));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(20, 22, 158, 25);
		searchMedicalHistory.add(button_1);
		
		informationWindow = new JTextArea();
		informationWindow.setFont(new Font("Monospaced", Font.PLAIN, 13));
		informationWindow.setBounds(226, 29, 230, 399);
		searchMedicalHistory.add(informationWindow);
		informationWindow.setEditable(false);
		
		//----------------------------------------------------------
		// enter information
		//-----------------------------------------------------------
		JButton btnGoBack = new JButton("<-  Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();

				frame.getContentPane().add(mainMenu);
				frame.getContentPane().revalidate();
				frame.repaint();
				
			}
		});
		enterDailyInformation.setLayout(null);
		btnGoBack.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGoBack.setBackground(Color.LIGHT_GRAY);
		btnGoBack.setBounds(10, 11, 110, 23);
		enterDailyInformation.add(btnGoBack);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(SystemColor.textHighlight);
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
		
			
				if(WeightBox.getText().length() > 0)
				{
					weight = Double.parseDouble(WeightBox.getText());
				}
				else 
					weight = 0;
				
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
				
			
				
				
					int day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
					int month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
					int year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
				
				
					
						User tempUser = Globals.userDatabase.getCurrentUser();
						
						if(tempUser instanceof Patient)
						{
						
							Visit newVisit = new Visit(month, day, year, bloodPressureTop,
							bloodPressureBot, bloodSugar, weight, height, temperature);
							Patient tempPatient = (Patient) tempUser;
							tempPatient.getMedicalRecord().addVisit(newVisit);
							
						}
						frame.getContentPane().removeAll();
						frame.getContentPane().invalidate();

						frame.getContentPane().add(mainMenu);
						frame.getContentPane().revalidate();
						frame.repaint();
					}
			
					
				
				
			});		
		
	
			
			
			
		
		
		btnEnter.setBounds(195, 353, 89, 23);
		enterDailyInformation.add(btnEnter);
		
		WeightBox = new JTextField();
		WeightBox.setBounds(238, 74, 46, 20);
		enterDailyInformation.add(WeightBox);
		WeightBox.setColumns(10);
		
		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBounds(238, 105, 46, 20);
		enterDailyInformation.add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);
		
		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBounds(238, 136, 46, 20);
		enterDailyInformation.add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);
		
		bloodSugarBox = new JTextField();
		bloodSugarBox.setBounds(238, 167, 46, 20);
		enterDailyInformation.add(bloodSugarBox);
		bloodSugarBox.setColumns(10);
		
		JLabel weightLabel = new JLabel("Weight (lbs)");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		weightLabel.setBounds(124, 77, 73, 14);
		enterDailyInformation.add(weightLabel);
		
		JLabel bloodPressureTopLabel = new JLabel("Blood Pressure Top");
		bloodPressureTopLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureTopLabel.setBounds(124, 108, 116, 14);
		enterDailyInformation.add(bloodPressureTopLabel);
		
		JLabel bloodSugarLabel = new JLabel("Blood Sugar (mg/dL)");
		bloodSugarLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodSugarLabel.setBounds(124, 167, 135, 14);
		enterDailyInformation.add(bloodSugarLabel);
		
		JLabel bloodPressureBotLabel = new JLabel("Blood Pressure Bot");
		bloodPressureBotLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureBotLabel.setBounds(124, 139, 116, 14);
		enterDailyInformation.add(bloodPressureBotLabel);
		
		
		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(154, 247, 37, 20);
		enterDailyInformation.add(monthComboBox);
		
				dayComboBox.setBackground(SystemColor.text);
				dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
				dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				dayComboBox.setToolTipText("1, 2 ,3\r\n");
				dayComboBox.setBounds(203, 247, 37, 20);
				enterDailyInformation.add(dayComboBox);
				

				yearComboBox.setBackground(SystemColor.text);
				yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
				yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
				yearComboBox.setToolTipText("1, 2 ,3\r\n");
				yearComboBox.setBounds(250, 247, 58, 20);
				enterDailyInformation.add(yearComboBox);
				
				
				JLabel lblDate = new JLabel("Date");
				lblDate.setBounds(109, 249, 46, 14);
				enterDailyInformation.add(lblDate);
				
				JLabel lblMonth2 = new JLabel("Month");
				lblMonth2.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblMonth2.setBounds(154, 230, 37, 14);
				enterDailyInformation.add(lblMonth2);
				
				JLabel lblDay2 = new JLabel("Day");
				lblDay2.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblDay2.setBounds(203, 230, 29, 14);
				enterDailyInformation.add(lblDay2);
				
				JLabel lblYear2 = new JLabel("Year");
				lblYear2.setFont(new Font("Tahoma", Font.PLAIN, 9));
				lblYear2.setBounds(247, 229, 37, 17);
				enterDailyInformation.add(lblYear2);
				
				patientAccount = new JPanel();
				patientAccount.setBackground(Color.WHITE);
				frame.getContentPane().add(patientAccount, "name_109013812379284");
				patientAccount.setLayout(null);
				
				JSeparator separator = new JSeparator();
				separator.setBackground(SystemColor.scrollbar);
				separator.setBounds(-10, 233, 494, 2);
				patientAccount.add(separator);
				
				JButton btnNewButton_2 = new JButton("Change Password");
				btnNewButton_2.setForeground(Color.BLACK);
				btnNewButton_2.setBackground(Color.LIGHT_GRAY);
				btnNewButton_2.setFont(new Font("Consolas", Font.PLAIN, 11));
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						char[] passwordInput = oldPassword.getPassword();
                        String loginPin = new String(passwordInput);
						
						
						if(loginPin.equals(Globals.userDatabase.getCurrentUser().getPin()))
						{
							char[] _newPassword = newPassword.getPassword();
                            String newLoginPin = new String(_newPassword);
							Globals.userDatabase.getCurrentUser().setPin(newLoginPin);
						}
						
					
					}
				});
				btnNewButton_2.setBounds(320, 425, 154, 23);
				patientAccount.add(btnNewButton_2);
				
				JLabel lblNewLabel = new JLabel("Current Password");
				lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
				lblNewLabel.setBounds(320, 317, 112, 14);
				patientAccount.add(lblNewLabel);
				
				oldPassword = new JPasswordField();
				oldPassword.setBounds(320, 330, 154, 23);
				patientAccount.add(oldPassword);
				
				newPassword = new JPasswordField();
				newPassword.setBounds(320, 383, 154, 23);
				patientAccount.add(newPassword);
				
				newInsurance = new JTextField();
				newInsurance.setFont(new Font("Monospaced", Font.PLAIN, 12));
				newInsurance.setBounds(10, 317, 147, 23);
				patientAccount.add(newInsurance);
				newInsurance.setColumns(10);
				
				newAddress = new JTextField();
				newAddress.setFont(new Font("Monospaced", Font.PLAIN, 12));
				newAddress.setBounds(10, 258, 300, 23);
				patientAccount.add(newAddress);
				newAddress.setColumns(10);
				
				JButton btnUpdateAddress = new JButton("Update Address");
				btnUpdateAddress.setForeground(Color.BLACK);
				btnUpdateAddress.setBackground(Color.LIGHT_GRAY);
				btnUpdateAddress.setFont(new Font("Consolas", Font.PLAIN, 11));
				btnUpdateAddress.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String address = newAddress.getText();
						Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
						tempPatient.setAddress(address);
					}
				});
				btnUpdateAddress.setBounds(320, 258, 154, 23);
				patientAccount.add(btnUpdateAddress);
				
				JButton btnUpdateInsurance = new JButton("Update Insurance");
				btnUpdateInsurance.setForeground(Color.BLACK);
				btnUpdateInsurance.setBackground(Color.LIGHT_GRAY);
				btnUpdateInsurance.setFont(new Font("Consolas", Font.PLAIN, 11));
				btnUpdateInsurance.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String insurance = newInsurance.getText();
						Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
						tempPatient.setInsurance(insurance);
					}
				});
				btnUpdateInsurance.setBounds(159, 317, 131, 23);
				patientAccount.add(btnUpdateInsurance);
				
				btnRefreshInfo = new JButton("Refresh");
				btnRefreshInfo.setFont(new Font("Monospaced", Font.BOLD, 11));
				btnRefreshInfo.setForeground(Color.BLACK);
				btnRefreshInfo.setBackground(Color.LIGHT_GRAY);
				btnRefreshInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						informationDisplay.setText(Globals.userDatabase.getCurrentUser().toString());
					}
				});
				btnRefreshInfo.setBounds(367, 8, 107, 23);
				patientAccount.add(btnRefreshInfo);
				
				JLabel lblNewLabel_2 = new JLabel("Account Information");
				lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 15));
				lblNewLabel_2.setBounds(145, 7, 232, 20);
				patientAccount.add(lblNewLabel_2);
				
				JButton button = new JButton("<- Go Back");
				button.setFont(new Font("Monospaced", Font.PLAIN, 12));
				button.setForeground(Color.BLACK);
				button.setBackground(Color.LIGHT_GRAY);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						frame.getContentPane().removeAll();
						frame.getContentPane().invalidate();

						frame.getContentPane().add(mainMenu);
						frame.getContentPane().revalidate();
						frame.repaint();
						
					}
				});
				button.setBounds(10, 7, 107, 23);
				patientAccount.add(button);
				
				btnUpdatePhoneNumber = new JButton("Update Phone");
				btnUpdatePhoneNumber.setForeground(Color.BLACK);
				btnUpdatePhoneNumber.setBackground(Color.LIGHT_GRAY);
				btnUpdatePhoneNumber.setFont(new Font("Consolas", Font.PLAIN, 11));
				btnUpdatePhoneNumber.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String phoneNumber = newPhoneNumber.getText();
						Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
						tempPatient.setPhoneNumber(phoneNumber);
						
						
					}
				});
				btnUpdatePhoneNumber.setBounds(159, 383, 131, 23);
				patientAccount.add(btnUpdatePhoneNumber);
				
				newPhoneNumber = new JTextField();
				newPhoneNumber.setFont(new Font("Monospaced", Font.PLAIN, 12));
				newPhoneNumber.setColumns(10);
				newPhoneNumber.setBounds(10, 383, 147, 23);
				patientAccount.add(newPhoneNumber);
				
				informationDisplay = new JTextArea();
				informationDisplay.setBackground(Color.WHITE);
				informationDisplay.setEditable(false);
				informationDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
				informationDisplay.setBounds(10, 42, 464, 180);
				patientAccount.add(informationDisplay);
				informationDisplay.setText(Globals.userDatabase.getCurrentUser().toString());
				
				lblNewPhoneNumber = new JLabel("Phone Number");
				lblNewPhoneNumber.setFont(new Font("Monospaced", Font.PLAIN, 12));
				lblNewPhoneNumber.setBounds(10, 361, 112, 14);
				patientAccount.add(lblNewPhoneNumber);
				
				lblNewAddress = new JLabel("Address");
				lblNewAddress.setFont(new Font("Monospaced", Font.PLAIN, 12));
				lblNewAddress.setBounds(10, 243, 112, 14);
				patientAccount.add(lblNewAddress);
				
				lblInsurance = new JLabel("Insurance");
				lblInsurance.setFont(new Font("Monospaced", Font.PLAIN, 12));
				lblInsurance.setBounds(10, 299, 94, 14);
				patientAccount.add(lblInsurance);
				
				lblNewPassword = new JLabel("New Password");
				lblNewPassword.setFont(new Font("Monospaced", Font.PLAIN, 12));
				lblNewPassword.setBounds(320, 361, 112, 14);
				patientAccount.add(lblNewPassword);
				
	}
}
