import java.util.ArrayList;




public class Doctor extends User
{
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	
    //------------------------------
    // Empty Constructor
    // -----------------------------
	public Doctor()
    {
		userType = Globals.DOCTOR;
	}

    //------------------------------------------------
    // Constructor that sets userName and pin
    // -----------------------------------------------
    public Doctor(String setName,String setPin)
    {
        super(setName, setPin, Globals.DOCTOR);
       
    }

	public void addPatient(Patient newPatient){
		patients.add(newPatient);
		
	}
	public int patientCheck(Patient _patient){
		int searchResult = patients.indexOf(_patient);
		return searchResult;
	}
	public int deletePatient(Patient _patient){
		int searchResult = patientCheck(_patient);
		if(searchResult == -1)
			return searchResult;
		else
		{
		patients.remove(searchResult);
		return 0;
		}
		
	}
	public int enterprescription(LoginList userDatabase, String userID, String prescription)
    {
        User tempPatient = userDatabase.searchUserID(userID);
        Patient newPatient = (Patient) tempPatient;
        newPatient.getMedicalRecord().addPrescription(prescription);
		return 0;
	}
	
	public int enterNotes(LoginList userDatabase, String userID, String notes)
    {
        User tempPatient = userDatabase.searchUserID(userID);
        Patient newPatient = (Patient) tempPatient;
        newPatient.getMedicalRecord().getLastVisit().setNotes(notes);
		return 0;
	}
//	public void displayMedicalInformation(LoginList userDatabase, int userID){
//		User tempUser = userDatabase.searchUserID(userID);
//
//		System.out.println("Patient Name: " + tempUser.getUserName());
//		System.out.println("BloodPressure: " + Arrays.toString(tempUser.getMedicalRecord().bloodPressure));
//		System.out.println("Sugar: "+Arrays.toString(tempUser.getMedicalRecord().sugar));
//		System.out.println("Weight: "+Arrays.toString(tempUser.getMedicalRecord().weight));
//		System.out.println("Height: "+Arrays.toString(tempUser.getMedicalRecord().height));
//		System.out.println("Temperature: "+Arrays.toString(tempUser.getMedicalRecord().temperature));
//	}
	public String[] getPrescriptions(LoginList userDatabase, String userID)
    {


        User tempPatient = userDatabase.searchUserID(userID);
        Patient newPatient = (Patient) tempPatient;
		return newPatient.getMedicalRecord().getAllPrescriptions();
	}
	public String getPatientInsurance(Patient currentPatient)
    {
		return currentPatient.getInsurance();
	}
	
	public String toString()
	{
		String patientString = "";
		int bound = patients.size() -1;
		if(bound >= 0)
		{
			while(bound >= 0)
			{
					patientString = patientString + "\r\n" + patients.get(bound).getUserID();
					bound--;
			}
			patientString = patientString + "\r\n";
		}
		
		String print = userType + "\r\n" + userName + "\r\n" + pin + "\r\n" + userID + "\r\n" + 
		answer1 + "\r\n" + answer2 + "\r\n" + answer3 + "\r\n" + patientString + "\r\n";
		
		return print;
	}
	
}
