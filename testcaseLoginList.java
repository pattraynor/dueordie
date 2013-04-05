/**
 * Author: Matthew
 * Date: 4/4/13
 */
public class main
{
    public static void main (String args[]){


    Patient patient1 = new Patient("Matt Potts", 1234);
    patient1.setAddress("1231 north road");
    Patient patient2 = new Patient("Tanner Narramore", 1234);
        patient2.setAddress("1232 north road");
    Patient patient3 = new Patient("James Potts", 1234);
        patient3.setAddress("1233 north road");
    Patient patient4 = new Patient("Alex", 1234);
        patient4.setAddress("1234 north road");
    Patient patient5 = new Patient("Jason", 1234);
        patient5.setAddress("1235 north road");
    Patient patient6 = new Patient("John", 1234);
        patient6.setAddress("1236 north road");
    User john = new User("john", 1234);
    LoginList userDatabase = new LoginList();

        int userID1 = userDatabase.addUser(patient1);
        int userID2 = userDatabase.addUser(patient2);
        int userID3 = userDatabase.addUser(patient3);
        int userID4 = userDatabase.addUser(patient4);
        int userID5 = userDatabase.addUser(patient5);
        int userID6 = userDatabase.addUser(patient6);
        int listSize = userDatabase.getListSize();
        System.out.println("List SizeL: " + listSize);
        System.out.println("User IDs : \n" + userID6);
        System.out.println(userID5);
        System.out.println(userID4);
        System.out.println(userID3);
        System.out.println(userID2);
        System.out.println(userID1);

        User tempUser1 = userDatabase.searchUserName("Matt Potts");
        User tempUser2 = userDatabase.searchUserID(userID2);
        User tempUser3 = userDatabase.searchUserID(userID3);
        User tempUser4 = userDatabase.searchUserID(userID4);
        User tempUser5 = userDatabase.searchUserID(userID5);
        User tempUser6 = userDatabase.searchUserID(userID6);

        Patient tempPatien1 = (Patient) tempUser1;
        Patient tempPatien2 = (Patient) tempUser2;
        Patient tempPatien3 = (Patient) tempUser3;
        Patient tempPatien4 = (Patient) tempUser4;
        Patient tempPatien5 = (Patient) tempUser5;
        Patient tempPatien6 = (Patient) tempUser6;

        System.out.println("Address : \n" +tempPatien1.getAddress());
        System.out.println(tempPatien2.getAddress());
        System.out.println(tempPatien3.getAddress());
        System.out.println(tempPatien4.getAddress());
        System.out.println(tempPatien5.getAddress());
        System.out.println(tempPatien6.getAddress());



    }

}
