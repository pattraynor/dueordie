/**
 * Author : Matthew Potts 
 * Original 3/29 Updated 4/13/2013
 */



import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LoginList {

	private ArrayList<User> userDatabase;

	private User currentUser;

	// ===========================================
	// empty constructor for class
	// ==========================================
	public LoginList() {
		userDatabase = new ArrayList<User>();
		currentUser = null;

	}

	public int getListSize() {
		return userDatabase.size();
	}

	// ------------------------------------------------------
	// generates a 7 digit integer for UserID based on listSize
	// ------------------------------------------------------
	private String generateUserID(User newUser) {
		int tempCount = getListSize();

		String stringID, string1, string2, type;
		if (newUser.getUserType() == Globals.PATIENT)
			type = "P";
		else if (newUser.getUserType() == Globals.NURSE)
			type = "N";
		else
			type = "D";

		int temp1, temp2;

		Random randomGenerator = new Random();
		// creates 2 random numbers that are less than 10
		temp1 = randomGenerator.nextInt(10);
		temp2 = randomGenerator.nextInt(10);
		// turns those random integers into strings then combines them into one
		// string
		string1 = Integer.toString(temp1);
		string2 = Integer.toString(temp2);
		stringID = type + string1 + string2;

		// adds two zeros if userCount is less than 10
		if (getListSize() < 10) {
			stringID = stringID + "00";
		}
		// adds one zero if userCount is less than 100
		else if (getListSize() < 100) {
			stringID = stringID + "0";
		}

		// creates the final string by adding the random with zeros to the
		// userCount
		stringID = stringID + Integer.toString(tempCount);
		newUser.setUserID(stringID);

		return stringID;
	}

	public String generatePassword() {

		final String ALPHABET = "0123456789ABCDE";
		final int N = ALPHABET.length() - 1;

		Random r = new Random();

		for (int i = 0; i < 50; i++) {
			System.out.print(ALPHABET.charAt(r.nextInt(N)));
		}

		String rand1, rand2, rand3, randChar, stringID;
		int randInt1, randInt2, randInt3;
		randChar = Character.toString(ALPHABET.charAt(N));
		Random randomGenerator = new Random();
		// creates 3 random numbers that are less than 10
		randInt1 = randomGenerator.nextInt(10);
		randInt2 = randomGenerator.nextInt(10);
		randInt3 = randomGenerator.nextInt(10);
		// turns those random integers into strings then combines them into one
		// string
		rand1 = Integer.toString(randInt1);
		rand2 = Integer.toString(randInt2);
		rand3 = Integer.toString(randInt3);
		stringID = randChar + rand1 + rand2 + rand3;

		return stringID;
	}

	// -------------------------------------------------
	// Saves LoginList and all user information to file
	// -------------------------------------------------
	public void saveDatabase() throws IOException {


	}

	// -------------------------------------------------
	// loads LoginList and all user information from file
	// -------------------------------------------------
	public void loadList() throws IOException {

		

	}

	// ==========================================
	// adds a newUser to the linked list
	// ==========================================

	public void insert(User newUser) {
		String userID = newUser.getUserID();
		int insertLocation = findInsertionPoint(userID);
		userDatabase.add(insertLocation, newUser);

	}

	public String addUser(User newUser) {

		String newUserID = generateUserID(newUser);

		int insertLocation = findInsertionPoint(newUserID);
		userDatabase.add(insertLocation, newUser);

		return newUserID;
	}

	private int findInsertionPoint(String userID) {
		if (userDatabase.size() == 0) {
			return 0;
		}
		int searchIndex = 0;
		while (searchIndex < userDatabase.size()) {

			if (userID.compareTo(userDatabase.get(searchIndex).getUserID()) == 0)
				return searchIndex;
			if (userID.compareTo(userDatabase.get(searchIndex).getUserID()) > 0)
				return searchIndex;
			searchIndex++;

		}
		return searchIndex;
	}

	// ----------------------------------
	// used to get current user easily
	// -----------------------------------
	public void setCurrentUser(User newCurrentUser) {
		currentUser = newCurrentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	
	public User getUser(int index)
	{
		return userDatabase.get(index);
	}
	
	// ===============================================
	// searches the linked list by userName
	// ===============================================
	public User searchUserName(String userName) {

		int searchIndex = 0;

		if (userDatabase.size() == 0) {
			return null;
		}
		while (searchIndex < userDatabase.size()) {

			if (userName.compareTo(userDatabase.get(searchIndex).getUserName()) == 0)
				return userDatabase.get(searchIndex);

			searchIndex++;

		}
		return null;
	}

	// ===============================================
	// searches the linked list by userID
	// ===============================================
	public User searchUserID(String userID) {
		int lowerBound = 0, searchIndex;
		int upperBound = userDatabase.size() - 1;
		String userIDCompare;

		while (upperBound >= lowerBound) {

			searchIndex = lowerBound + ((upperBound - lowerBound) / 2);
			userIDCompare = userDatabase.get(searchIndex).getUserID();
			int compareResult = userID.compareTo(userIDCompare);

			if (compareResult > 0) {
				// userName is before, if it exists
				upperBound = searchIndex - 1;

			} else {
				if (compareResult < 0) {
					// userName comes after, if it exists
					lowerBound = searchIndex + 1;
				} else {
					// names are equal. match found
					return userDatabase.get(searchIndex);
				}
			}

		}

		return null;

	}

	// -----------------------------------------------------------
	// checks if user exists then checks the pin to enable login
	// -----------------------------------------------------------
	public User login(String loginID, String loginPin) {
		User tempUser;
		tempUser = searchUserID(loginID);
		if (tempUser == null) {
			return null;
		}

		String pin = tempUser.getPin();
		if (loginPin.equals(pin)) {
			return tempUser;
		} else
			return null;
	}

	// -------------------------------------
	// sets the currentUser to null
	// used when logout is pressed in GUI
	// -------------------------------------

}
