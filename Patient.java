
public class Patient extends User{

    private Doctor doctor;
    private String insurance, address, phoneNumber;
    private MedicalRecord patientRecord;

    //creates a new Patient and sets all info 
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

    public String getAddress(){

        return address;

    }

    public String getInsurance(){

        return insurance;

    }

    public Doctor getDoctor(){

        return doctor;

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
    }
    
    
    //used by save to file
    public String toString()
    {
    	
    	String doctorID = doctor.getUserID();
    	String medicalRecordString = patientRecord.toString();

    	
    	return userType + "\r\n" + userName + "\r\n" + pin + "\r\n" + userID + "\r\n" + insurance + "\r\n" + address + "\r\n" +
                phoneNumber + "\r\n" + doctorID + "\r\n"  + answer1 + "\r\n" + answer2 + "\r\n" + answer3 + medicalRecordString + "\r\n";
    }
    
    //method used to display info on GUI
    public String print()
    {
    	
    	String doctorName = doctor.getUserName();
    	
    	return "\nName: \t\t\t" + userName + "\n\nInsurance: \t\t" + insurance + "\n\nAddress: \t\t" + address +
                "\n\nPhone Number: \t\t" + phoneNumber + "\n\nDoctor: \t\t" + doctorName;

    }

}