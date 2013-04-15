

import javax.swing.JFrame; 
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;


public class LoginGUI {
	
	JFrame frame;
	private JTextField userID;
	private JPasswordField password;
	private JLabel lblWrongPasswordUser;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JPanel login = new JPanel();
		

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(700, 350, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		login.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		login.setBackground(Color.WHITE);
		frame.getContentPane().add(login, "name_26039109728750");
		login.setLayout(null);
		
		userID = new JTextField();
		userID.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		userID.setBounds(148, 69, 130, 20);
		login.add(userID);
		userID.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(0, 153, 204));
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				
				if(userID.getText().length() > 0)
				{
                    String loginID, loginPin;
					loginID = userID.getText();
					char[] passwordInput = password.getPassword();
					loginPin = new String(passwordInput);
					User tempUser = Globals.userDatabase.login(loginID, loginPin);
					if(tempUser != null)
					{
						Globals.userDatabase.setCurrentUser(tempUser);
						if(tempUser instanceof Patient)
						{
							frame.dispose();
							PatientGUI window = new PatientGUI();
							window.frame.setVisible(true);
							
						}
						if(tempUser instanceof Nurse)
						{
							frame.dispose();
							NurseGUI window = new NurseGUI();
							window.frame.setVisible(true);
							
						}
						Globals.userDatabase.setCurrentUser(tempUser);
						
					}
					else
					{
						lblWrongPasswordUser.setVisible(true);
					}
				
					
						
				}
						
					
			}
		});
		btnLogin.setBounds(148, 140, 130, 23);
		login.add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
		btnForgotPassword.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnForgotPassword.setForeground(SystemColor.textInactiveText);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				
			}
		});
		btnForgotPassword.setBackground(SystemColor.text);
		btnForgotPassword.setBounds(148, 227, 130, 23);
		login.add(btnForgotPassword);
		
		JLabel lblUserName = new JLabel("User ID");
		lblUserName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblUserName.setBounds(74, 73, 64, 14);
		login.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPassword.setBounds(74, 113, 64, 14);
		login.add(lblPassword);
		
		JLabel lblMedrecSoftware = new JLabel("MedRec Software");
		lblMedrecSoftware.setFont(new Font("Consolas", Font.BOLD, 15));
		lblMedrecSoftware.setForeground(SystemColor.textHighlight);
		lblMedrecSoftware.setBackground(Color.WHITE);
		lblMedrecSoftware.setBounds(148, 11, 130, 48);
		login.add(lblMedrecSoftware);
		
		password = new JPasswordField();
		password.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		password.setBounds(148, 109, 130, 20);
		login.add(password);
		
		
		lblWrongPasswordUser = new JLabel("Wrong UserID/Password");
		lblWrongPasswordUser.setForeground(Color.RED);
		lblWrongPasswordUser.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblWrongPasswordUser.setBounds(136, 185, 183, 14);
		login.add(lblWrongPasswordUser);
		lblWrongPasswordUser.setVisible(false);
	}


}
