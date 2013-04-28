/**
 * Author : Matthew Potts   
 * Original 3/29 Updated 4/16/2013
 */

import java.util.ArrayList;
import java.util.Random;

public class LoginList {

	private ArrayList<User> userDatabase;

	// used for easy access of the user that is
	// is currently logged in.
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
	// generates a 7 digit String for UserID based on listSize
	// ------------------------------------------------------
	private String generateUserID(User newUser) {
		int tempCount = getListSize();

		String stringID, string1, string2, type;
		if (newUser.getUserType().equals(Globals.PATIENT))
			type = "P";
		else if (newUser.getUserType().equals(Globals.NURSE))
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

	// -----------------------------------------------------
	// generates a password for new users
	// one random char and 3 random integers put in a string
	// -----------------------------------------------------
	public String generatePassword() {

		final String ALPHABET = "ABCDEFGHIJK";

		Random randomGenerator = new Random();

		String rand1, rand2, rand3, randChar, stringID;
		int randInt1, randInt2, randInt3, randCharInt;

		randCharInt = randomGenerator.nextInt(10);

		randChar = Character.toString(ALPHABET.charAt(randCharInt));

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

	// ==========================================
	// adds a newUser to the linked list
	// ==========================================

	public void insert(User newUser) {

		userDatabase.add(newUser);

	}

	public String addUser(User newUser) {

		String newUserID = generateUserID(newUser);

		int insertLocation = findInsertionPoint(newUserID);
		userDatabase.add(insertLocation, newUser);

		return newUserID;
	}

	// --------------------------------------------------
	// finds the location of where the user should
	// be inserted into the array.
	// --------------------------------------------------
	private int findInsertionPoint(String userID) {
		if (userDatabase.size() == 0) {
			return 0;
		}
		int searchIndex = 0;
		while (searchIndex < userDatabase.size()) {

			if (userID.compareTo(userDatabase.get(searchIndex).getUserID()) < 0)
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

	// returns the user by index
	public User getUser(int index) {
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

			if (compareResult < 0) {
				// userName is before, if it exists
				upperBound = searchIndex - 1;

			} else {
				if (compareResult > 0) {
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
			Globals.userDatabase.setCurrentUser(tempUser);
			return tempUser;
		} else
			return null;
	}

	// --------------------------------------------------
	// returns all of the Doctor Names in an String array.
	// --------------------------------------------------
	public String[] getDoctorNames() {
		int index = 0, doctorCount = 0;
		int indexBound = getListSize();
		while (index < indexBound) {

			if (userDatabase.get(index).getUserType().equals(Globals.DOCTOR)) {
				doctorCount++;
			}
			index++;

		}

		index = 0;
		if (doctorCount > 0) {

			String[] doctorNames = new String[doctorCount];

			while (index < doctorCount) {
				doctorNames[index] = userDatabase.get(index).getUserName();

				index++;
			}

			return doctorNames;
		}
		return null;

	}

}
