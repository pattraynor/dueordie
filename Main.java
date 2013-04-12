
import java.awt.EventQueue;



public class main {
	public static void main(String[] args) {
		
		Doctor doctor1 = new Doctor("Dr Oz", "2");
		String doctorID = Globals.userDatabase.addUser(doctor1);
	 	Patient patient1 = new Patient("Matt Potts", "1", doctor1, "1234", "23333", "23232");
	 	
	 	String address = "1231 north road";
	 	patient1.setAddress(address);
	 
	   

	    Patient patient2 = new Patient("Tanner Narramore", "2", doctor1, "north elm", "1233", "12222");
	    patient2.setAddress("1232 north road");
	    
	    Nurse nurse1 = new Nurse("James Potts", "3");
	    






          
	    	
        String userID1 = Globals.userDatabase.addUser(patient1);
	        System.out.println("Patient 1 : " + userID1 + "\tPassword: 1");
        String userID2 = Globals.userDatabase.addUser(patient2);
	        System.out.println("Patient 2 : " + userID2 + "\tPassword: 2");
	       
        String userID3 = Globals.userDatabase.addUser(nurse1);
        
        System.out.println("Nurse: " + userID3 + "\tPassword: 3");
        System.out.println("Doctor: " + doctorID + "\tPassword: 2");
       




	       
	       
	        Globals.userDatabase.setCurrentUser(patient1);
	        
	       
	       



	       

	     

	
	
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


