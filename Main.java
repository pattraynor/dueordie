
import java.awt.EventQueue;



public class Main {
	public static void main(String[] args) {
		
		Doctor doctor1 = new Doctor("Dr Oz", "2");
		String doctorID = Globals.userDatabase.addUser(doctor1);
	 	Patient patient1 = new Patient("Matt Potts", "1", doctor1, "Unitedhealth Group", "234-343-9221", "101 north elm street Tempe AZ");
	 	
	 	
	 	
	 	patient1.setAnswers("dog", "cat", "mouse");
	 	System.out.println("security answers for Patient 1: dog, cat, mouse");
	   

	    Patient patient2 = new Patient("Tanner Narramore", "2", doctor1, "Cigna", "103-123-1234", "102 north rock street tempe AZ");
	    Patient patient3 = new Patient("Rebecca Napper", "2", doctor1, "Humana Group", "103-123-1234", "102 north lake street tempe AZ");
	    Patient patient4 = new Patient("Patrick Traynor", "2", doctor1, "Wellpoint", "123-123-1234", "102 north pebble street tempe AZ");
	    Patient patient5 = new Patient("Tyler Nakai", "2", doctor1, "Regence Group", "453-123-1234", "102 north stone street tempe AZ");
	    Nurse nurse1 = new Nurse("James Potts", "3");
	    






          
	    	
		String userID1 = Globals.userDatabase.addUser(patient1);
		System.out.println("Matt Potts : " + userID1 + "\t\tPassword: 1");
		String userID2 = Globals.userDatabase.addUser(patient2);
		System.out.println("Tanner Narramore : " + userID2 + "\tPassword: 2");
		String userID3 = Globals.userDatabase.addUser(patient3);
		System.out.println("Rebecca Napper : " + userID3 + "\t\tPassword: 2");
		String userID4 = Globals.userDatabase.addUser(patient4);
		System.out.println("Patrick Traynor : " + userID4 + "\tPassword: 2");
		String userID5 = Globals.userDatabase.addUser(patient5);
		System.out.println("Tyler Nakai : " + userID5 + "\tPassword: 2");
		String userID6 = Globals.userDatabase.addUser(nurse1);

        System.out.println("Nurse: " + userID6 + "\t\tPassword: 3");
        System.out.println("Doctor: " + doctorID + "\t\tPassword: 2");
       




	       



	       

	     

	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
}

}


