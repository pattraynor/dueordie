public class Patient extends User{

    private Doctor doctor;
    private String insurance, address, phoneNumber;
    private MedicalRecord patientRecord;

    public Patient(String _userName, String _newPin, Doctor myDoctor, String myInsurance, String myNumber, String myAddress)
    {
        super(_userName, _newPin, Globals.PATIENT);
        doctor = myDoctor;
        insurance = myInsurance;
        address = myAddress;
        phoneNumber = myNumber;
        patientRecord = new MedicalRecord();

    }
    public Patient()
    {
        userType = Globals.PATIENT;
        userName = "";
        doctor = null;
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

    public void setDoctor(Doctor setDoctor)
    {

        doctor = setDoctor;

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

    public Doctor getDoctor(){

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
    	
    	String doctorName = doctor.getUserName();
    	
    		
    	
    	String print = "\nName: \t\t\t" + userName + "\n\nInsurance: \t\t" + insurance + "\n\nAddress: \t\t" + address + "\n\nPhone Number: \t\t" + phoneNumber + "\n\nDoctor: \t\t" + doctorName;
    	
    	return print;
    }
}

