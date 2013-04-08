/**
 * Author: Matthew
 * Date: 4/4/13
 */
import java.util.ArrayList;
public class main
{
    public static void main (String args[])
    {


    Patient patient1 = new Patient("Matt Potts", 1);
    patient1.setAddress("1231 north road");
    MedicalRecord medicalRecord1 = new MedicalRecord();
    Visit newVisit1 = new Visit();
    newVisit1.setHeight(10);
    patient1.setMedicalRecord(medicalRecord1);

    Patient patient2 = new Patient("Tanner Narramore", 2);
    patient2.setAddress("1232 north road");

    Patient patient3 = new Patient("James Potts", 3);
    patient3.setAddress("1233 north road");

    Patient patient4 = new Patient("Alex", 4);
    patient4.setAddress("1234 north road");

    Patient patient5 = new Patient("Jason", 5);
    patient5.setAddress("1235 north road");

    Patient patient6 = new Patient("John", 6);
    patient6.setAddress("1236 north road");

    User john = new User("john", 7);

    LoginList userDatabase = new LoginList();

        int userID1 = userDatabase.addUser(patient1);
        int userID2 = userDatabase.addUser(patient2);
        int userID3 = userDatabase.addUser(patient3);
        int userID4 = userDatabase.addUser(patient4);
        int userID5 = userDatabase.addUser(patient5);
        int userID6 = userDatabase.addUser(patient6);
        int listSize = userDatabase.getListSize();
        System.out.println("List Size: " + listSize);


        Patient tempPatient1 = (Patient)userDatabase.searchUserName("Matt Potts");
        Patient tempPatient2 = (Patient)userDatabase.searchUserID(userID2);
        Patient tempPatient3 = (Patient)userDatabase.searchUserID(userID3);
        Patient tempPatient4 = (Patient)userDatabase.searchUserID(userID4);
        Patient tempPatient5 = (Patient)userDatabase.searchUserID(userID5);
        Patient tempPatient6 = (Patient)userDatabase.searchUserID(userID6);


        System.out.println("\n\nAddress : \n" +tempPatient1.getAddress());
        System.out.println(tempPatient2.getAddress());
        System.out.println(tempPatient3.getAddress());
        System.out.println(tempPatient4.getAddress());
        System.out.println(tempPatient5.getAddress());
        System.out.println(tempPatient6.getAddress());


        System.out.println("\nNames : \n" +tempPatient1.getUserName());
        System.out.println(tempPatient2.getUserName());
        System.out.println(tempPatient3.getUserName());
        System.out.println(tempPatient4.getUserName());
        System.out.println(tempPatient5.getUserName());
        System.out.println(tempPatient6.getUserName());

        System.out.println("\nUserID : \n" +tempPatient1.getUserID());
        System.out.println(tempPatient2.getUserID());
        System.out.println(tempPatient3.getUserID());
        System.out.println(tempPatient4.getUserID());
        System.out.println(tempPatient5.getUserID());
        System.out.println(tempPatient6.getUserID());

        System.out.println("Pin : \n" +tempPatient1.getPin());
        System.out.println(tempPatient2.getPin());
        System.out.println(tempPatient3.getPin());
        System.out.println(tempPatient4.getPin());
        System.out.println(tempPatient5.getPin());
        System.out.println(tempPatient6.getPin());

        Patient userMRTest = (Patient) userDatabase.searchUserName("Matt Potts");
        Visit newVisit = new Visit(1,1,2013, 200.0, 100.0, 10.0, 100.0, 20.0, 98.6, "Penicillin", "Need to hydrate more", "need to see soon");
        Visit newVisit2 = new Visit(2,5,2013, 300, 400, 10.0, 100.0, 20.0, 98.7, "No new Prescription", "Need to hydrate more", "need to see soon");
        Visit newVisit3 = new Visit(4,6,2013, 200.0, 100.0, 10.0, 100.0, 20.0, 98.9, "NEW DRUG", "Need to eat better", "talk about knee problem");

        userMRTest.getMedicalRecord().addVisit(newVisit);
        userMRTest.getMedicalRecord().addVisit(newVisit2);
        userMRTest.getMedicalRecord().addVisit(newVisit3);

        System.out.println("\nPotts, LastVisit: Prescription and Temperature \n");
        System.out.println(userMRTest.getMedicalRecord().getLastVisit().getPrescription());
        System.out.println(userMRTest.getMedicalRecord().getLastVisit().getBloodPressureBot());
        System.out.println(userMRTest.getMedicalRecord().getLastVisit().getNotes());
        System.out.println(userMRTest.getMedicalRecord().getLastVisit().getHeight());
        System.out.println(userMRTest.getMedicalRecord().getLastVisit().getTemperature());


        System.out.println("\nPotts, Visit 2:\n");
        System.out.println(userMRTest.getMedicalRecord().getVisit(2, 5, 2013).getPrescription());
        Patient tempMatt = (Patient) userDatabase.searchUserName("Matt Potts");
        System.out.println(tempMatt.getMedicalRecord().getLastVisit().getTemperature());


        System.out.println("\nArray List Chart test: \n");
        double[] tempDouble = tempMatt.getMedicalRecord().getTemperatureChart();

        int j = tempDouble.length;
        int i =0;
        while(i < j )
        {
            System.out.println(tempDouble[i]);
            i++;
        }



    }
}
