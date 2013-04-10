
import java.awt.EventQueue;



public class main {
	public static void main(String[] args) {
		
		
	 	Patient patient1 = new Patient("Matt Potts", "1");
	 	Doctor doctor1 = new Doctor("Dr Oz", "2");
	 	String address = "1231 north road";
	 	patient1.setAddress(address);
	 
	   

	    Patient patient2 = new Patient("Tanner Narramore", "2");
	    patient2.setAddress("1232 north road");
	    
	    Nurse nurse1 = new Nurse("James Potts", "3");
	    






            String doctorID = Globals.userDatabase.addUser(doctor1);
	    	patient1.setDoctor(doctorID);
	    	patient1.setInsurance("MetLife 1232113");
	    	patient1.setAnswers("dog", "ca", "mouse");
	    	patient2.setDoctor(doctorID);
	    	
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


