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

 

}
