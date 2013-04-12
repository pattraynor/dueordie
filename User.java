

public class User {
	protected String userName;
	protected String userType;
	protected String answer1, answer2, answer3;
	protected String pin, userID;

public User(){
	userName = "";
	userType = "User";
	answer1 = "";
	answer2 = "";
	answer3 = "";
	pin = "";
	userID = "000000";
}
public User(String setName,String setPin, String setType)
{
        userName = setName;
        userType = setType;
        answer1 = null;
        answer2 = null;
        answer3 = null;
        pin = setPin;
        userID = "000000";
}
public String getAnswer1(){
	return answer1;
}
public String getAnswer2(){
	return answer2;
}
public String getAnswer3(){
	return answer3;
}
public void setAnswers(String a1, String a2, String a3){
	answer1 = a1;
	answer2 = a2;
	answer3 = a3;
}
public void setUserID(String newID){
	userID = newID;
}
public String setPin(String newPin){
	pin = newPin;
	return pin;
}
public String getPin(){
	return pin;
}
public String getUserID(){
	return userID;
}
public String getUserName(){
	return userName;
}
public String getUserType(){
	return userType;
}
public int recoverAccount(int questionIndex, String attemptedAnswer)
{
	String realAnswer = null;
	if(questionIndex == 0)
	{
		realAnswer = getAnswer1();
	}
	if(questionIndex == 1)
	{
		realAnswer = getAnswer2();
	}
	if(questionIndex == 2)
	{
		realAnswer = getAnswer3();
	}
	
	if(realAnswer == null)
	{ 
		//returns -1 to show that answers were not created
		return -1;
	}
	else
	{
		if(realAnswer.equals(attemptedAnswer))
		{
			//returns 0 to show that answers matched
			return 0;
		}
		else
		{
			//returns 1 to show that answers did not match
			return 1;
		}
	}
	
	
}
}
