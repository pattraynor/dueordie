

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
import java.io.IOException;



public class RecoverAccountGUI {

	public JFrame frame;
	private JTextField answerField;
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField2;
	private JPasswordField passwordField3;
	private JComboBox<String> securityQuestionBox;
	public JPanel recoverAccount, changePassword;
	private JPanel changePasswordLoggedIn;
	private JPanel answerQuestions;
	private JTextField answer1Field;
	private JTextField answer2Field;
	private JTextField answer3Field;


	/**
	 * Create the application.
	 */
	public RecoverAccountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setToPassword()
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		frame.getContentPane().add(changePasswordLoggedIn);
		frame.getContentPane().revalidate();
		frame.repaint();
	}
	public void setToAnswerQuestions()
	{
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		frame.getContentPane().add(answerQuestions);
		frame.getContentPane().revalidate();
		frame.repaint();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
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
				
				int returnValue, index = securityQuestionBox.getSelectedIndex();
				String attemptedAnswer = answerField.getText();
				
				User searchUser = Globals.userDatabase.searchUserID(userIDField.getText());
				if(searchUser == null)
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Wrong User ID or Answer", "Wrong ID/Answer",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
				}
				else
				{
				returnValue = searchUser.recoverAccount(index, attemptedAnswer);
				if(returnValue == -1)
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "You have not set up the security features for your account", "Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
					
				}
				if(returnValue == 1)
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Answers do not match.", "Incorrect Answer",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
				}
				if(returnValue == 0)
				{
					Globals.userDatabase.setCurrentUser(searchUser);
					frame.getContentPane().removeAll();
					frame.getContentPane().invalidate();
					frame.getContentPane().add(changePassword);
					frame.getContentPane().revalidate();
					frame.repaint();
				}
				}

		}});
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
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewPassword.setBounds(23, 70, 117, 14);
		changePassword.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(23, 118, 128, 22);
		changePassword.add(lblConfirmPassword);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setBackground(SystemColor.textHighlight);
		btnChangePassword.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPassword, confirmPassword;
				char[] passwordInput = passwordField.getPassword();
				newPassword = new String(passwordInput);
				char[] passwordInput2 = passwordField_1.getPassword();
				confirmPassword = new String(passwordInput2);
				
				if(newPassword.length() < 4)
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Password is not long Enough. \nPassword must be 4 charcters long.", "Password too Short",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
					passwordField.setText("");
					passwordField_1.setText("");
					
				}
				else
				{
					if(confirmPassword.equals(newPassword))
					{
					
					
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(null, "Password Changed!", "Password Changed",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						Globals.userDatabase.getCurrentUser().setPin(newPassword);
						try {
							Globals.userDatabase.saveDatabase();
						} catch (IOException e1) {
							JOptionPane.showOptionDialog(null, "There was a problem saving changes", "Error during Save",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							e1.printStackTrace();
						}
						Globals.userDatabase.setCurrentUser(null);
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
			}
		});
		btnChangePassword.setBounds(163, 190, 150, 42);
		changePassword.add(btnChangePassword);
		
		changePasswordLoggedIn = new JPanel();
		frame.getContentPane().add(changePasswordLoggedIn, "name_1412434526974");
		

		changePasswordLoggedIn.setBackground(Color.WHITE);
		frame.getContentPane().add(changePasswordLoggedIn, "name_125098458476250");
		changePasswordLoggedIn.setLayout(null);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(163, 64, 150, 28);
		changePasswordLoggedIn.add(passwordField2);
		
		passwordField3 = new JPasswordField();
		passwordField3.setBounds(163, 116, 150, 28);
		changePasswordLoggedIn.add(passwordField3);
		
		JLabel lblNewPassword2 = new JLabel("New Password");
		lblNewPassword2.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewPassword2.setBounds(23, 70, 117, 14);
		changePasswordLoggedIn.add(lblNewPassword2);
		
		JLabel lblConfirmPassword2 = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(23, 118, 128, 22);
		changePasswordLoggedIn.add(lblConfirmPassword2);
		
		JButton btnChangePassword2 = new JButton("Change Password");
		btnChangePassword2.setForeground(Color.BLACK);
		btnChangePassword2.setBackground(SystemColor.textHighlight);
		btnChangePassword2.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnChangePassword2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPassword, confirmPassword;
				char[] passwordInput = passwordField2.getPassword();
				newPassword = new String(passwordInput);
				char[] passwordInput2 = passwordField3.getPassword();
				confirmPassword = new String(passwordInput2);
				
				if(newPassword.length() < 4)
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Password is not long Enough. \nPassword must be 4 characters long", "Password too Short",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
					passwordField2.setText("");
					passwordField3.setText("");
					
				}
				else 
				{
					if(confirmPassword.equals(newPassword))
					{
						Object[] options = {"OK"};
						JOptionPane.showOptionDialog(null, "Password Changed!", "Password Changed",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						Globals.userDatabase.getCurrentUser().setPin(newPassword);
				
						try {
							Globals.userDatabase.saveDatabase();
						} catch (IOException e1) {
							JOptionPane.showOptionDialog(null, "There was a problem saving", "Error during Save",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
							e1.printStackTrace();
						}
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
			}
		});
		btnChangePassword2.setBounds(163, 190, 150, 42);
		changePasswordLoggedIn.add(btnChangePassword2);

		JLabel label = new JLabel("Confirm Password");
		label.setFont(new Font("Consolas", Font.PLAIN, 13));
		label.setBounds(23, 120, 128, 22);
		changePasswordLoggedIn.add(label);
		
		answerQuestions = new JPanel();
		answerQuestions.setBackground(Color.WHITE);
		frame.getContentPane().add(answerQuestions, "name_5294565203151");
		answerQuestions.setLayout(null);
		
		answer1Field = new JTextField();
		answer1Field.setBackground(Color.WHITE);
		answer1Field.setBounds(100, 60, 238, 20);
		answerQuestions.add(answer1Field);
		answer1Field.setColumns(10);
		
		answer2Field = new JTextField();
		answer2Field.setBackground(Color.WHITE);
		answer2Field.setColumns(10);
		answer2Field.setBounds(100, 120, 238, 20);
		answerQuestions.add(answer2Field);
		
		answer3Field = new JTextField();
		answer3Field.setBackground(Color.WHITE);
		answer3Field.setColumns(10);
		answer3Field.setBounds(100, 190, 238, 20);
		answerQuestions.add(answer3Field);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if((answer1Field.getText().toString().length()) <= 0 || 
						(answer2Field.getText().toString().length()) <= 0 || 
						(answer3Field.getText().toString().length() <= 0))
				{
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null, "Please Answer all Questions", "Empty Field",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[0]);
					
				}
				else
				{
				Globals.userDatabase.getCurrentUser().
				setAnswers(answer1Field.getText(), answer2Field.getText(), answer3Field.getText());
				frame.dispose();
				}
			
			}
		});
		btnSubmit.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setBounds(161, 227, 111, 23);
		answerQuestions.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Where did you attend High School?");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel.setBounds(100, 35, 238, 14);
		answerQuestions.add(lblNewLabel);
		
		JLabel lblWhatIsYour = new JLabel("What is your favorite animal?");
		lblWhatIsYour.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblWhatIsYour.setBounds(100, 106, 238, 14);
		answerQuestions.add(lblWhatIsYour);
		
		JLabel lblWhatIsYour_1 = new JLabel("What is your mother's maiden name?");
		lblWhatIsYour_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblWhatIsYour_1.setBounds(100, 175, 238, 14);
		answerQuestions.add(lblWhatIsYour_1);
	}
}
