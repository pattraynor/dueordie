public class Nurse extends User
{

    public Nurse(String setName, String setPin)
    {
        super(setName, setPin, Globals.NURSE);
       

    }

    public Visit newVisit(int patientID)
    {
    
        Visit _newVisit = new Visit();
        return _newVisit;

    }
    
    public int enterMedicalInformation(int month,int day,int year,double bloodPressureTop,
    		double bloodPressureBot,double bloodSugar,double weight,double height,double temperature, String symptoms)
    {
    	
    	return 0;
    }

    public String toString()
    {
    	String print;
    	print = userType + "\r\n" + userName + "\r\n" + pin + "\r\n" + userID  + "\r\n" + answer1 + "\r\n" + answer2 + "\r\n" + answer3 + "\r\n" + "\r\n";
    	return print;
    }

}
