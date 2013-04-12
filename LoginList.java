/**
 * Author : Matthew Potts
 * Original 3/29 Updated 4/3/2013
 */


import java.util.Random;

public class LoginList
{

    private Node head;
    
    private int listSize;
    private User currentUser;
    private String question1, question2, question3;

    //===========================================
    // empty constructor for class
    // ==========================================
    public LoginList()
    {
        head = null;
        listSize = 0;
        currentUser = null;
        question1 = Globals.QUESTION1;
        question2 = Globals.QUESTION2;
        question3 = Globals.QUESTION3;


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

        String stringID = "", string1, string2, string3;
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
        Node newHead = new Node(newUser, head);
        head = newHead;

        return newUserID;
    }

    // ----------------------------------------
    // stores updated user back into the list
    // -----------------------------------------
    public void saveUserChanges(User updatedUser)
    {
        Node iterationNode = head;
        while(iterationNode != null)
        {
            if(iterationNode.getUserAccount().getUserID() == updatedUser.getUserID())
            {
                iterationNode.setUserAccount(updatedUser);
                currentUser = updatedUser;
            }
            iterationNode = iterationNode.getNext();
        }

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
        Node tempNode = head;
        	
            while (tempNode != null)
            {
                String userNameCompare;
                userNameCompare = tempNode.getUserAccount().getUserName();
                if (userNameCompare.equals(userName))
                {
                    return tempNode.getUserAccount();
                }
                tempNode = tempNode.getNext();
            }

        return null;
    }

    //===============================================
    // searches the linked list by userID
    //===============================================
    public User searchUserID(String userID)
    {
        Node tempNode = head;

        while (tempNode != null)
        {

            String userIDCompare;
            userIDCompare = tempNode.getUserAccount().getUserID();
            if (userIDCompare.equals(userID))
            {
               return tempNode.getUserAccount();
            }
            tempNode = tempNode.getNext();

        }

        return null;
    }

    //================================================
    // get security questions
    //================================================
    public String getQuestion1()
    {
        return question1;
    }
    public String getQuestion2()
    {
        return question2;
    }
    public String getQuestion3()
    {
        return question3;
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
    public void logout()
    {
        currentUser = null;
    }

    //-----------------------------------------------
    // Used to recover account password, compares
    // security questions, and if equal returns pin
    // ----------------------------------------------
    public String recoverAccount(String attemptedAnswer, String userID, int questionNumber)
    {
        User accountRecovering = searchUserID(userID);
        if(accountRecovering == null)
        {
             return "Error";
        }

        String answer2Question = "";
        if(questionNumber == 1)
        {
            answer2Question = accountRecovering.getAnswer1();
        }
        if(questionNumber == 2)
        {
            answer2Question = accountRecovering.getAnswer2();
        }
        if(questionNumber == 3)
        {
            answer2Question = accountRecovering.getAnswer3();
        }

        if(answer2Question.equals(attemptedAnswer))
        {
        return accountRecovering.getPin();
        }
        else
            return "Error";
    }

    // ---------------------------------------------------------
    // Node class implements the structure of the linked list
    // ---------------------------------------------------------
    private class Node
    {
        private Node next;

        private User userAccount;

     
        public Node(User _newUser, Node newNext)
        {
            next = newNext;
            userAccount = _newUser;
        }
        public User getUserAccount()
        {
            return userAccount;
        }
        public void setUserAccount(User _newUser)
        {
            userAccount = _newUser;
        }

        public Node getNext()
        {
            return next;
        }

      
    }
}
