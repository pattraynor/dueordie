import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PatientEnterInformation {

	
	
	public JFrame frame;
	private JTextField WeightBox;
	private JTextField bloodPressureTopBox;
	private JTextField bloodPressureBotBox;
	private JTextField bloodSugarBox;
	private JComboBox dayComboBox = new JComboBox();
	private JComboBox monthComboBox = new JComboBox();
	private JComboBox yearComboBox = new JComboBox();
	private double temperature, weight, height, bloodPressureTop, bloodPressureBot, bloodSugar;
	private String symptoms, name; 
	private int ID;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public PatientEnterInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Menu.selectionForeground"));
		frame.getContentPane().setBackground(UIManager.getColor("text"));
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGoBack = new JButton("<-  Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PatientMain window = new PatientMain();
				window.frame.setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnGoBack.setBackground(Color.LIGHT_GRAY);
		btnGoBack.setBounds(10, 11, 110, 23);
		frame.getContentPane().add(btnGoBack);
		
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
							bloodPressureBot, bloodSugar, weight, height, temperature, symptoms);
							Patient tempPatient = (Patient) tempUser;
							tempPatient.getMedicalRecord().addVisit(newVisit);
							
						}
						
					}
					
				
				
			});		
			
	
				
				
				
			
		
		btnEnter.setBounds(135, 327, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		WeightBox = new JTextField();
		WeightBox.setBounds(178, 74, 46, 20);
		frame.getContentPane().add(WeightBox);
		WeightBox.setColumns(10);
		
		bloodPressureTopBox = new JTextField();
		bloodPressureTopBox.setBounds(178, 105, 46, 20);
		frame.getContentPane().add(bloodPressureTopBox);
		bloodPressureTopBox.setColumns(10);
		
		bloodPressureBotBox = new JTextField();
		bloodPressureBotBox.setBounds(178, 136, 46, 20);
		frame.getContentPane().add(bloodPressureBotBox);
		bloodPressureBotBox.setColumns(10);
		
		bloodSugarBox = new JTextField();
		bloodSugarBox.setBounds(178, 167, 46, 20);
		frame.getContentPane().add(bloodSugarBox);
		bloodSugarBox.setColumns(10);
		
		JLabel weightLabel = new JLabel("Weight (lbs)");
		weightLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		weightLabel.setBounds(69, 77, 73, 14);
		frame.getContentPane().add(weightLabel);
		
		JLabel bloodPressureTopLabel = new JLabel("Blood Pressure Top");
		bloodPressureTopLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureTopLabel.setBounds(69, 105, 116, 14);
		frame.getContentPane().add(bloodPressureTopLabel);
		
		JLabel bloodSugarLabel = new JLabel("Blood Sugar (mg/dL)");
		bloodSugarLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodSugarLabel.setBounds(69, 167, 135, 14);
		frame.getContentPane().add(bloodSugarLabel);
		
		JLabel bloodPressureBotLabel = new JLabel("Blood Pressure Bot");
		bloodPressureBotLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bloodPressureBotLabel.setBounds(69, 139, 116, 14);
		frame.getContentPane().add(bloodPressureBotLabel);
		
		
		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(SystemColor.text);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(97, 247, 37, 20);
		frame.getContentPane().add(monthComboBox);

		dayComboBox.setBackground(SystemColor.text);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(144, 247, 37, 20);
		frame.getContentPane().add(dayComboBox);
		

		yearComboBox.setBackground(SystemColor.text);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(191, 247, 58, 20);
		frame.getContentPane().add(yearComboBox);
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(55, 249, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMonth.setBounds(97, 230, 37, 14);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDay.setBounds(144, 230, 29, 14);
		frame.getContentPane().add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblYear.setBounds(191, 230, 29, 14);
		frame.getContentPane().add(lblYear);
		
		
		
		
	}
}

	
