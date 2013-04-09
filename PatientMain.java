import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class PatientMain {

	public JFrame frame;

	
	

	/**
	 * Create the application.
	 */
	public PatientMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(SystemColor.textHighlight);
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login window = new Login();
				window.frame.setVisible(true);
				Globals.userDatabase.setCurrentUser(null);
			}
		});
		btnLogout.setBounds(10, 11, 82, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnEnterDailyInformation = new JButton("Enter Daily Information");
		btnEnterDailyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PatientEnterInformation window = new PatientEnterInformation();
				window.frame.setVisible(true);
			}
		});
		btnEnterDailyInformation.setForeground(Color.BLACK);
		btnEnterDailyInformation.setBackground(Color.WHITE);
		btnEnterDailyInformation.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnEnterDailyInformation.setBounds(116, 135, 207, 45);
		frame.getContentPane().add(btnEnterDailyInformation);
		
		JButton btnNewButton = new JButton("View Progress");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(116, 191, 207, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSearchMedicalHistory = new JButton("Search Medical History");
		btnSearchMedicalHistory.setForeground(Color.BLACK);
		btnSearchMedicalHistory.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnSearchMedicalHistory.setBackground(Color.WHITE);
		btnSearchMedicalHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				PatientDisplayInformation window = new PatientDisplayInformation();
				window.frame.setVisible(true);
			}
		});
		btnSearchMedicalHistory.setBounds(116, 79, 207, 45);
		frame.getContentPane().add(btnSearchMedicalHistory);
	}

}
