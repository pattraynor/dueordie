public class Patient extends User{
    
    public int doctor;
    public String insurance;
    public String address;
    public String phoneNumber;
    public MedicalRecord patientRecord;

    public Patient(){
        userType = "Patient";
    }
    
    public void setInsurance(String newInsurance){        
        insurance = newInsurance;
    }
    
    public void setAddress(String newAddress){
        address = newAddress;    
    }
    
    public void setDoctor(int userID){
        doctor = userID;
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
    
    public int getDoctor(){        
        return doctor;        
    }
    
    public void addDailyInformation(){
        
    }
    
    public String[] getPrescriptions(){    
        return patientRecord.prescription;    
    } 
    
    public MedicalRecord getMedicalRecord(){    
        return patientRecord;    
    }
    
    public phoneNumber getPhoneNumber(){        
    }
}
