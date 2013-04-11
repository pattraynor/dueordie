

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;



public class RecoverAccountGUI {

	public JFrame frame;
	private JTextField answerField;
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JComboBox<String> securityQuestionBox;
	public JPanel recoverAccount, changePassword;

	/**
	 * Create the application.
	 */
	public RecoverAccountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 350, 450, 300);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		recoverAccount = new JPanel();
		recoverAccount.setBackground(Color.WHITE);
		frame.getContentPane().add(recoverAccount, "name_125095884621296");
		recoverAccount.setLayout(null);
		
		answerField = new JTextField();
		answerField.setBounds(157, 138, 189, 20);
		recoverAccount.add(answerField);
		answerField.setColumns(10);
		
		userIDField = new JTextField();
		userIDField.setBounds(157, 58, 189, 20);
		recoverAccount.add(userIDField);
		userIDField.setColumns(10);
		
		securityQuestionBox = new JComboBox<String>();
		securityQuestionBox.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		securityQuestionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Where did you attend HighSchool?", "What is your favorite animal?", "What is your mother's maiden name?"}));
		securityQuestionBox.setBounds(157, 103, 189, 20);
		recoverAccount.add(securityQuestionBox);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		submitButton.setForeground(Color.BLACK);
		submitButton.setBackground(SystemColor.textHighlight);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tempID = userIDField.getText();
				String tempAnswer = answerField.getText();
				String realAnswer = null;
				String tempQuestion = (String) securityQuestionBox.getSelectedItem();
				User tempUser = Globals.userDatabase.searchUserID(tempID);
				if(tempUser != null)
				{
					
				
						if(tempQuestion.equals(Globals.QUESTION1))
						{
							realAnswer = tempUser.getAnswer1();
						}
						if(tempQuestion.equals(Globals.QUESTION2))
						{
							realAnswer = tempUser.getAnswer2();
						}
						if(tempQuestion.equals(Globals.QUESTION3))
						{
							realAnswer = tempUser.getAnswer3();
						}
						
						if(realAnswer.equals(tempAnswer))
						{
							Globals.userDatabase.setCurrentUser(tempUser);
							frame.getContentPane().removeAll();
							frame.getContentPane().invalidate();
							frame.getContentPane().add(changePassword);
							frame.getContentPane().revalidate();
							frame.repaint();
						}
				}
				
				
			
				
			}
		});
		submitButton.setBounds(157, 190, 189, 42);
		recoverAccount.add(submitButton);
		
		JLabel answerLabel = new JLabel("Answer");
		answerLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		answerLabel.setBounds(10, 140, 83, 14);
		recoverAccount.add(answerLabel);
		
		JLabel userIDlabel = new JLabel("User ID or Name");
		userIDlabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		userIDlabel.setBounds(10, 60, 151, 14);
		recoverAccount.add(userIDlabel);
		
		JLabel lblSelectSecuritQuestion = new JLabel("Security Question");
		lblSelectSecuritQuestion.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblSelectSecuritQuestion.setBounds(10, 105, 153, 14);
		recoverAccount.add(lblSelectSecuritQuestion);
		
		changePassword = new JPanel();
		changePassword.setBackground(Color.WHITE);
		frame.getContentPane().add(changePassword, "name_125098458476250");
		changePassword.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 64, 150, 28);
		changePassword.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(163, 116, 150, 28);
		changePassword.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(23, 70, 117, 14);
		changePassword.add(lblNewLabel_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(23, 118, 128, 22);
		changePassword.add(lblConfirmPassword);
		
		JButton btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPassword, confirmPassword;
				char[] passwordInput = passwordField.getPassword();
				newPassword = new String(passwordInput);
				char[] passwordInput2 = passwordField_1.getPassword();
				confirmPassword = new String(passwordInput2);
				
				if(confirmPassword.equals(newPassword))
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Password Changed!", "Congrats!",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
					Globals.userDatabase.getCurrentUser().setPin(newPassword);
					frame.dispose();
					
				}
				else 
				{
					Object[] options = { "OK"};
					JOptionPane.showOptionDialog(null, "Passwords Do Not Match!", "Warning",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
					
				}
				
			}
		});
		btnNewButton_1.setBounds(163, 190, 150, 42);
		changePassword.add(btnNewButton_1);
	}
}
