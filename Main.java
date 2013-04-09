
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;


public class main {
	public static void main(String[] args) {
		
		
	 	Patient patient1 = new Patient("Matt Potts", 1);
	 
	 	String address = "1231 north road";
	 	patient1.setAddress(address);
	   

	    Patient patient2 = new Patient("Tanner Narramore", 2);
	    patient2.setAddress("1232 north road");

	    Patient patient3 = new Patient("James Potts", 3);
	    patient3.setAddress("1233 north road");

	    Patient patient4 = new Patient("Alex", 4);
	    patient4.setAddress("1234 north road");

	    Patient patient5 = new Patient("Jason", 5);
	    patient5.setAddress("1235 north road");

	    Patient patient6 = new Patient("John", 6);
	    patient6.setAddress("1236 north road");

	    

	   

	        int userID1 = Globals.userDatabase.addUser(patient1);
	        System.out.println(userID1);
	        int userID2 = Globals.userDatabase.addUser(patient2);
	        int userID3 = Globals.userDatabase.addUser(patient3);
	        int userID4 = Globals.userDatabase.addUser(patient4);
	        int userID5 = Globals.userDatabase.addUser(patient5);
	        int userID6 = Globals.userDatabase.addUser(patient6);
	        int listSize = Globals.userDatabase.getListSize();
	       
	        Globals.userDatabase.setCurrentUser(patient1);
	        
	        Patient tempPatient1 = (Patient)Globals.userDatabase.searchUserName("Matt Potts");
	        Patient tempPatient2 = (Patient)Globals.userDatabase.searchUserID(userID2);
	        Patient tempPatient3 = (Patient)Globals.userDatabase.searchUserID(userID3);
	        Patient tempPatient4 = (Patient)Globals.userDatabase.searchUserID(userID4);
	        Patient tempPatient5 = (Patient)Globals.userDatabase.searchUserID(userID5);
	        Patient tempPatient6 = (Patient)Globals.userDatabase.searchUserID(userID6);


	       



	       

	     

	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
}

}


