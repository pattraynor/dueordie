public class Nurse extends User
{

    public Nurse(String setName, String setPin)
    {
        super(setName, setPin, Globals.NURSE);
       

    }



    public String toString()
    {
    	String print;
    	print = userType + "\r\n" + userName + "\r\n" + pin + "\r\n" + userID  + "\r\n" + answer1 + "\r\n" + answer2 + "\r\n" + answer3 + "\r\n" + "\r\n";
    	return print;
    }
    
    public String print()
    {
    	return "Name: \t\t" + userName;
    }

}
