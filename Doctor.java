import java.util.Arrays;

public class Doctor extends User {
	private int[] patients = new int[20];
	

	public Doctor(){
		userType = "doctor";
	}
	public int addPatient(int userID){
		int i = 0;
		while(i<patients.length){
		if(i<patients.length && patients[i] == 0){
		patients[i] = userID;
		i = patients.length;
		return 1;
		}else{
			i++;
		}
		}
		return 0;
		
	}
	public int patientCheck(int userID){
		int i = 0;
		while(i<patients.length){
			if(patients[i] == userID){
				return 1;
			}else i++;
			}
		return 0;
	}
	public int deletePatient(int userID){
		int i = 0;
		while(i<patients.length){
			if(patients[i] == userID){
				patients[i] = 0;
				return 1;
			}else i++;
		} return 0;
	}
	public int enterprescription(LoginList userDatabase, int userID, String prescription){
		userDatabase.searchUserID(userID).getMedicalRecord().addprescription(prescription);
		userDatabase.saveUserChanges(userDatabase.searchUserID(userID));
		return 1;
	}
	
	public int enterNotes(LoginList userDatabase, int userID, String notes){
		userDatabase.searchUserID(userID).getMedicalRecord().getLastVisit().setSymptoms(notes);
		userDatabase.saveUserChanges(userDatabase.searchUserID(userID));
		return 1;
	}
	public void displayMedicalInformation(LoginList userDatabase, int userID){
		User tempUser = userDatabase.searchUserID(userID);
		
		System.out.println("Patient Name: "+tempUser.getMedicalRecord().patientName);
		System.out.println("BloodPressure: "+Arrays.toString(tempUser.getMedicalRecord().bloodPressure));
		System.out.println("Sugar: "+Arrays.toString(tempUser.getMedicalRecord().sugar));
		System.out.println("Weight: "+Arrays.toString(tempUser.getMedicalRecord().weight));
		System.out.println("Height: "+Arrays.toString(tempUser.getMedicalRecord().height));
		System.out.println("Temperature: "+Arrays.toString(tempUser.getMedicalRecord().temperature));
	}
	public String[] getPrescriptions(LoginList userDatabase, int userID){
		return userDatabase.searchUserID(userID).getMedicalRecord().perscription;
	}
	public String getPatientInsurance(Patient currentPatient){
		return currentPatient.insurance;
	}
	
	
}
