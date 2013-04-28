

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
import java.awt.Toolkit;

//GUI for logging in
//displays login screen and then redirects 
//users to certain screens based on user type
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
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
		userID.setBounds(162, 69, 130, 20);
		login.add(userID);
		userID.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(0, 153, 204));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Monospaced", Font.PLAIN, 17));
		
		//-------------------------------------------------
		//Action listener for login button
		//if user is Doctor, doctorGui is created
		//same for for patients and nurses.
		//--------------------------------------------------
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
						else if(tempUser instanceof Nurse)
						{
							frame.dispose();
							NurseGUI window = new NurseGUI();
							window.frame.setVisible(true);
							
						}
						else if(tempUser instanceof Doctor)
						{
								frame.dispose();
								DoctorGUI window = new DoctorGUI();
								window.frame.setVisible(true);
								
						}
						
					}
					else
					{
						lblWrongPasswordUser.setVisible(true);
					}
				}
					
		
			}
		});
		btnLogin.setBounds(162, 139, 130, 23);
		login.add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBorder(null);
		btnForgotPassword.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnForgotPassword.setForeground(SystemColor.textHighlight);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RecoverAccountGUI window = new RecoverAccountGUI();
				window.frame.setVisible(true);
				
			}
		});
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.setBounds(162, 226, 130, 23);
		login.add(btnForgotPassword);
		
		JLabel lblUserName = new JLabel("User ID");
		lblUserName.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblUserName.setBounds(88, 73, 64, 14);
		login.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPassword.setBounds(88, 112, 64, 14);
		login.add(lblPassword);
		
		JLabel lblMedrecSoftware = new JLabel("MedRec Software");
		lblMedrecSoftware.setFont(new Font("Consolas", Font.BOLD, 15));
		lblMedrecSoftware.setForeground(SystemColor.textHighlight);
		lblMedrecSoftware.setBackground(Color.WHITE);
		lblMedrecSoftware.setBounds(162, 10, 130, 48);
		login.add(lblMedrecSoftware);
		
		password = new JPasswordField();
		password.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		password.setBounds(162, 108, 130, 20);
		login.add(password);
		
		
		lblWrongPasswordUser = new JLabel("Wrong UserID/Password");
		lblWrongPasswordUser.setForeground(Color.RED);
		lblWrongPasswordUser.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblWrongPasswordUser.setBounds(152, 188, 183, 14);
		login.add(lblWrongPasswordUser);
		lblWrongPasswordUser.setVisible(false);
	}


}
