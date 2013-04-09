import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class PatientDisplayInformation {

	JFrame frame;
	private JComboBox dayComboBox = new JComboBox();
	private JComboBox monthComboBox = new JComboBox();
	private JComboBox yearComboBox = new JComboBox();
	private final JButton getMostRecent = new JButton("Get Most Recent ");
	private final JLabel lblMonth = new JLabel("Month");
	private final JLabel lblDay = new JLabel("Day");
	private final JLabel lblYear = new JLabel("Year");
	private final JLabel lblViewMedicalInformation = new JLabel("View Medical Information");
	private JTextPane medicalInformationWindow = new JTextPane();
	private final JButton searchVisit = new JButton("Search");
	private int day, month, year;
	private final JButton button = new JButton("<- Go Back");


	/**
	 * Create the application.
	 */
	public PatientDisplayInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		medicalInformationWindow.setBounds(215, 11, 195, 239);
		frame.getContentPane().add(medicalInformationWindow);
		medicalInformationWindow.setEditable(false);
		
		monthComboBox.setForeground(UIManager.getColor("Menu.foreground"));
		monthComboBox.setBackground(Color.WHITE);
		monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setToolTipText("1, 2 ,3\r\n");
		monthComboBox.setBounds(26, 103, 37, 20);
		frame.getContentPane().add(monthComboBox);

		dayComboBox.setBackground(Color.WHITE);
		dayComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox.setToolTipText("1, 2 ,3\r\n");
		dayComboBox.setBounds(73, 103, 37, 20);
		frame.getContentPane().add(dayComboBox);
		

		yearComboBox.setBackground(Color.WHITE);
		yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		yearComboBox.setToolTipText("1, 2 ,3\r\n");
		yearComboBox.setBounds(120, 103, 58, 20);
		frame.getContentPane().add(yearComboBox);
		getMostRecent.setForeground(Color.BLACK);
		getMostRecent.setBackground(Color.WHITE);
		getMostRecent.setFont(new Font("Consolas", Font.PLAIN, 11));
		getMostRecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getLastVisit();
				if(tempVisit != null)
				{
				medicalInformationWindow.setText(tempVisit.toString());
				}
				
			}
		});
		getMostRecent.setBounds(26, 205, 157, 23);
		
		
		frame.getContentPane().add(getMostRecent);
		lblMonth.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblMonth.setBounds(26, 87, 46, 14);
		
			
		
		frame.getContentPane().add(lblMonth);
		lblDay.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblDay.setBounds(73, 87, 46, 14);
		
		frame.getContentPane().add(lblDay);
		lblYear.setFont(new Font("Consolas", Font.PLAIN, 10));
		lblYear.setBounds(120, 87, 46, 14);
		
		frame.getContentPane().add(lblYear);
		lblViewMedicalInformation.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblViewMedicalInformation.setBounds(20, 62, 195, 14);
		
		frame.getContentPane().add(lblViewMedicalInformation);
		searchVisit.setForeground(Color.BLACK);
		searchVisit.setBackground(Color.WHITE);
		searchVisit.setFont(new Font("Consolas", Font.PLAIN, 11));
		searchVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
				month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
				year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
				Patient tempPatient = (Patient) Globals.userDatabase.getCurrentUser();
				Visit tempVisit = tempPatient.getMedicalRecord().getVisit(month, day, year);
				if(tempVisit != null)
				{
				medicalInformationWindow.setText(tempVisit.toString());
				}
				if(tempVisit != null && tempVisit.getDay() <= 0)
				{
					medicalInformationWindow.setText("No Medical Information to Display.");
				}
			}
		});
		searchVisit.setBounds(26, 134, 157, 23);
		
		frame.getContentPane().add(searchVisit);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PatientMain window = new PatientMain();
				window.frame.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("Monospaced", Font.PLAIN, 11));
		button.setBounds(21, 11, 114, 23);
		
		frame.getContentPane().add(button);
	}
}
