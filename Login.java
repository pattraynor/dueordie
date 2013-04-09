import java.awt.EventQueue;

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
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.JSeparator;


public class Login {
	
	JFrame frame;
	private JTextField userID;
	private JTextField password;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JPanel login = new JPanel();
		
		JPanel nursePage = new JPanel();
		

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		login.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		login.setBackground(Color.WHITE);
		frame.getContentPane().add(login, "name_26039109728750");
		login.setLayout(null);
		
		userID = new JTextField();
		userID.setBounds(148, 69, 130, 20);
		login.add(userID);
		userID.setColumns(10);
		
		password = new JTextField();
		password.setBounds(148, 109, 130, 20);
		login.add(password);
		password.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				int loginID, loginPin;
				if(userID.getText().length() > 0)
				{
					loginID = Integer.parseInt(userID.getText());
					loginPin = Integer.parseInt(password.getText());
					User tempUser = Globals.userDatabase.login(loginID, loginPin);
					if(tempUser != null)
					{
						Globals.userDatabase.setCurrentUser(tempUser);
						if(tempUser instanceof Patient)
						{
							frame.dispose();
							PatientMain window = new PatientMain();
							window.frame.setVisible(true);
							
						}
						Globals.userDatabase.setCurrentUser(tempUser);
					}
				}
						
					
			}
		});
		btnLogin.setBounds(148, 140, 130, 23);
		login.add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnForgotPassword.setForeground(SystemColor.textInactiveText);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		
		frame.getContentPane().add(nursePage, "name_26039116238459");
		nursePage.setLayout(null);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(10, 80, 155, 23);
		nursePage.add(btnCreateAccount);
		
		JButton btnNewButton_1 = new JButton("Enter Patient Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 143, 155, 23);
		nursePage.add(btnNewButton_1);
	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
