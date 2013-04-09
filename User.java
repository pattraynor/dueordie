public class User {
	protected String userName;
	protected String userType;
	protected String answer1, answer2, answer3;
	protected int pin, userID;

public User(){
	userName = "";
	userType = "User";
	answer1 = "";
	answer2 = "";
	answer3 = "";
	pin = 0000;
	userID = 000000;
}
public User(String setName,int setPin, String setType)
{
        userName = setName;
        userType = setType;
        answer1 = null;
        answer2 = null;
        answer3 = null;
        pin = setPin;
        userID = 000000;
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
public void setUserID(int newID){
	userID = newID;
}
public int setPin(int newPin){
	pin = newPin;
	return pin;
}
public int getPin(){
	return pin;
}
public int getUserID(){
	return userID;
}
public String getUserName(){
	return userName;
}
public String getUserType(){
	return userType;
}
}
