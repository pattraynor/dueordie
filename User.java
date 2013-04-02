public class User {
  private String userName;
	private String userType;
	private String[] answers;
	private int pin;
	private int userID;


public String[] getAnswers(){
	return answers;
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
