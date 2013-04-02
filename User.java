public class User {
	private String userName;
	private String userType;
	private String answer1;
	private String answer2; 
	private String answer3;
	private int pin;
	private int userID;


public String getAnswer1(){
	return answer1;
}
public String getAnswer2(){
	return answer2;
}
public String getAnswer3(){
	return answer3;
}
public void setUserID(int newID){
	userID = newID;
}
public int changePin(int newPin){
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
	return userName;
}
}
