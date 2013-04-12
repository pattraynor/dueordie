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

 

}
