public class Patient extends User{

    private int doctor;
    private String insurance, address, phoneNumber;
    private MedicalRecord patientRecord;

    public Patient(String _userName, int _newPin)
    {
        super(_userName, _newPin);
        userType = "Patient";
        doctor = 0;
        insurance = "";
        address = "";
        phoneNumber = "";
        patientRecord = new MedicalRecord();

    }
    public Patient()
    {
        userType = "Patient";
        userName = "";
        doctor = 0;
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

    public void setDoctor(int userID)
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

    public int getDoctor(){

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
    }
}

