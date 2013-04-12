/**
 * Author : Matthew Potts
 * Original 3/29 Updated 4/3/2013
 */


import java.util.ArrayList;
import java.util.Random;

public class LoginList
{

    private ArrayList<User> userDatabase;
    
    private int listSize;
    private User currentUser;
   

    //===========================================
    // empty constructor for class
    // ==========================================
    public LoginList()
    {
    	userDatabase = new ArrayList<User>();
        listSize = 0;
        currentUser = null;
        


    }
    public int getListSize()
    {
        return listSize;
    }

    // ------------------------------------------------------
    // generates a 7 digit integer for UserID based on listSize
    // ------------------------------------------------------
    public String generateUserID()
    {
        int tempCount = getListSize();

        String stringID, string1, string2, string3;
        int temp1, temp2, temp3;

        Random randomGenerator = new Random();
        //creates 3 random numbers that are less than 10
        temp1 = randomGenerator.nextInt(10);
        temp2 = randomGenerator.nextInt(10);
        temp3 = randomGenerator.nextInt(10);
        //turns those random integers into strings then combines them into one string
        string1 = Integer.toString(temp1);
        string2 = Integer.toString(temp2);
        string3 = Integer.toString(temp3);
        stringID = string1 + string2 + string3;

        //adds two zeros if userCount is less than 10
        if (listSize < 10)
        {
            stringID = stringID + "00";
        }
        //adds one zero if userCount is less than 100
        else if(listSize < 100)
        {
            stringID = stringID + "0";
        }

        //creates the final string by adding the random with zeros to the userCount
        stringID = stringID + Integer.toString(tempCount);


        return stringID;
    }

    //-------------------------------------------------
    // Saves LoginList and all user information to file
    // -------------------------------------------------
    public int saveList()
    {
         return 0;
    }

    //-------------------------------------------------
    // loads LoginList and all user information from file
    // -------------------------------------------------
    public int loadList()
    {
         return 0;
    }



    // ==========================================
    // adds a newUser to the linked list
    // ==========================================
    public String addUser(User newUser)
    {
        listSize++;
        String newUserID = generateUserID();
        newUser.setUserID(newUserID);
        int insertLocation = findInsertionPoint(newUserID);
        userDatabase.add(insertLocation, newUser);
        		
        return newUserID;
    }
    
    private int findInsertionPoint(String userID)
    {
    	if(userDatabase.size() == 0)
    	{
    		return 0;
    	}
		int searchIndex = 0;
		while(searchIndex < userDatabase.size())
		{
			
			if(userID.compareTo(userDatabase.get(searchIndex).getUserID()) == 0)
	            return searchIndex;
			if(userID.compareTo(userDatabase.get(searchIndex).getUserID()) < 0)
				return searchIndex;
			searchIndex++;
			
		
    	
		}
		return searchIndex;
    }


    //----------------------------------
    // used to get current user easily
    //-----------------------------------
    public void setCurrentUser(User newCurrentUser)
    {
        currentUser = newCurrentUser;
    }
    public User getCurrentUser()
    {
        return currentUser;
    }


    //===============================================
    // searches the linked list by userName
    //===============================================
    public User searchUserName(String userName)
    {
        	
        
    	int searchIndex = 0;
    	
        if(userDatabase.size() == 0)
    	{
    		return null;
    	}
		while(searchIndex < userDatabase.size())
		{
			
			if(userName.compareTo(userDatabase.get(searchIndex).getUserName()) == 0)
	            return userDatabase.get(searchIndex);
			
			searchIndex++;
		
    	
		}
		return null;
    }


    //===============================================
    // searches the linked list by userID
    //===============================================
    public User searchUserID(String userID)
    {
        int lowerBound = 0, searchIndex;
        int upperBound = userDatabase.size() -1;	
        String userIDCompare;
    	
    	
    		while (upperBound >= lowerBound)
            {
    			
            	searchIndex = lowerBound + ((upperBound - lowerBound)/2);
            	userIDCompare = userDatabase.get(searchIndex).getUserID();
            	int compareResult = userID.compareTo(userIDCompare); 
           
            	if (compareResult < 0)  
            	{  
            	    //userName is before, if it exists
            		upperBound = searchIndex - 1;
            		
            	}  
            	else   
            	{  
            	   if (compareResult > 0)
            	   {
            	    //userName comes after, if it exists
            		lowerBound = searchIndex + 1;
            	   }
            	   else  
            	   {  
            	    //names are equal. match found
            		return userDatabase.get(searchIndex);
            	   } 
            	}
         
            }
    		
    		return null;

    }



    //-----------------------------------------------------------
    // checks if user exists then checks the pin to enable login
    //-----------------------------------------------------------
    public User login(String loginID, String loginPin)
    {
        User tempUser;
        tempUser = searchUserID(loginID);
        if(tempUser == null)
        {
            return null;
        }

        String pin = tempUser.getPin();
        if (loginPin.equals(pin))
        {
            return tempUser;
        }
        else
            return null;
    }

    //-------------------------------------
    // sets the currentUser to null
    // used when logout is pressed in GUI
    //-------------------------------------

   
   
}
