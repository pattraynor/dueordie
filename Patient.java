public class Patient extends User{

    private String doctor;
    private String insurance, address, phoneNumber;
    private MedicalRecord patientRecord;

    public Patient(String _userName, String _newPin)
    {
        super(_userName, _newPin, Globals.PATIENT);
        doctor = "";
        insurance = "";
        address = "";
        phoneNumber = "";
        patientRecord = new MedicalRecord();

    }
    public Patient()
    {
        userType = Globals.PATIENT;
        userName = "";
        doctor = "";
        insurance = "";
        address = "";
        phoneNumber = "";
        patientRecord = new MedicalRecord();

    }
    public void setInsurance(String newInsurance)
    {
        insurance = newInsurance;
    }

    public void setAddress(String newAddress){

        address = newAddress;

    }

    public void setDoctor(String userID)
    {

        doctor = userID;

    }

    public void setPhoneNumber(String setNumber){

        phoneNumber = setNumber;

    }
    public void setMedicalRecord(MedicalRecord newMedicalRecord)
    {
        patientRecord = newMedicalRecord;
    }

    public String getAddress(){

        return address;

    }

    public String getInsurance(){

        return insurance;

    }

    public String getDoctor(){

        return doctor;

    }


    public void addDailyInformation()
    {

    }


    public String[] getPrescriptions(){

        return patientRecord.getAllPrescriptions();

    }

    public MedicalRecord getMedicalRecord()
    {

        return patientRecord;

    }

    public String getPhoneNumber()
    {
           return phoneNumber;
    };
    
    public String toString()
    {
    	String doctorName;
    	User tempUser = Globals.userDatabase.searchUserID(doctor);
    	if(tempUser != null)
    	{
    		doctorName = tempUser.getUserName();
    	}
    	else
    		doctorName = "N/A";
    		
    	
    	String print = "\nInsurance: \t" + insurance + "\n\nAddress: \t" + address + "\n\nPhone Number: \t" + phoneNumber + "\n\nDoctor: \t" + doctorName;
    	
    	return print;
    }
}

