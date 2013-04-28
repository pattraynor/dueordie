import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileHandler {
	
	//file that will be used for loading and saving
	private static File databaseFile;
	
	public FileHandler()
	{
		databaseFile = null;	
	}
	
	//sets the database file after it is retrieved
	private static void setDatabaseFile(File newFile)
	{
		databaseFile = newFile;
	}
	
	//returns the file used for loading and saving
	private static File getDatabaseFile()
	{
		return databaseFile;
	}
	
	//created a buffered reader that is needed by loadDatabase
	private static BufferedReader getReader()
	{
		BufferedReader in = null;
		try
		{
			File file = getFile();
			if(file != null)
			{
			in = new BufferedReader(new FileReader(file));
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The file does not exist.");
			return in;
		}
	
		return in;
	}
	
	//opens dialog box and asks user to select file
	private static File getFile()
	{
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION)
			file = fc.getSelectedFile();
		setDatabaseFile(file);
		return file;
	}
	
	//creates a file writer that is needed by save
	private static FileWriter openWriter()
	{
		try
		{
			File file = getDatabaseFile();
			FileWriter out = new FileWriter((file));
			return out;
		}
		catch(IOException e)
		{
			System.out.println("I/0 error");
		}
		return null;
		
	}
	
	
	// -------------------------------------------------
	// Saves all users information to text file
	// -------------------------------------------------
	public void saveDatabase() throws IOException {

		
		// Create some data to write.
		int index = 0;
		FileWriter saveFile = openWriter();
		int databaseSize = Globals.userDatabase.getListSize();
		while (index < databaseSize) {
			saveFile.write(Globals.userDatabase.getUser(index).toString());
			index++;

		}
		saveFile.write("ENDFILE");

		// All done, close the FileWriter.
		saveFile.close();

	}

	// -------------------------------------------------
	// loads all users information from text file
	// -------------------------------------------------
	public void loadDatabase() throws IOException {

		BufferedReader saveFile = getReader();
		if(saveFile == null)
		{
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null,
					"No file selected or there was an error loading the file. " +
					"Please close the application and select the correct file.",
					"File Error", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options,
					options[0]);
		}
		else
		{
		String setID, setName, setPin, setAnswer1, setAnswer2, setAnswer3;

		
		String fileLine = "";
		while (!(fileLine.equals("ENDFILE"))) {

			fileLine = saveFile.readLine();
			if (fileLine.equals(Globals.DOCTOR)) {
				setName = saveFile.readLine();
				setPin = saveFile.readLine();
				setID = saveFile.readLine();
				setAnswer1 = saveFile.readLine();
				setAnswer2 = saveFile.readLine();
				setAnswer3 = saveFile.readLine();
				Doctor newDoctor = new Doctor(setName, setPin);
				newDoctor.setAnswers(setAnswer1, setAnswer2, setAnswer3);
				newDoctor.setUserID(setID);
				Globals.userDatabase.insert(newDoctor);
				fileLine = saveFile.readLine();
				
			}
			if (fileLine.equals(Globals.NURSE)) {
				setName = saveFile.readLine();
				setPin = saveFile.readLine();
				setID = saveFile.readLine();
				setAnswer1 = saveFile.readLine();
				setAnswer2 = saveFile.readLine();
				setAnswer3 = saveFile.readLine();
				Nurse newNurse = new Nurse(setName, setPin);
				newNurse.setAnswers(setAnswer1, setAnswer2, setAnswer3);
				newNurse.setUserID(setID);
				Globals.userDatabase.insert(newNurse);
				fileLine = saveFile.readLine();

			}
			if (fileLine.equals(Globals.PATIENT)) {
				int visitDay, visitMonth, visitYear;
				String setInsurance, setAddress, setPhone, doctorID, setSymptoms, setNotes, setPrescription;
				double setBloodPressureTop, setBloodPressureBot, setTemperature, setHeight, setWeight, setSugar;
				Doctor setDoctor;

				setName = saveFile.readLine();
				setPin = saveFile.readLine();
				setID = saveFile.readLine();
				setInsurance = saveFile.readLine();
				setAddress = saveFile.readLine();
				setPhone = saveFile.readLine();
				doctorID = saveFile.readLine();
				setAnswer1 = saveFile.readLine();
				setAnswer2 = saveFile.readLine();
				setAnswer3 = fileLine = saveFile.readLine();

				setDoctor = (Doctor) Globals.userDatabase
						.searchUserID(doctorID);
				Patient newPatient = new Patient(setName, setPin, setDoctor,
						setInsurance, setPhone, setAddress);
				fileLine = saveFile.readLine();
				while (!(fileLine.equals("END RECORD"))) 
				{
					String temp = fileLine;
					setWeight = Double.parseDouble(temp);
					setHeight = Double.parseDouble(saveFile.readLine());
					setTemperature = Double.parseDouble(saveFile.readLine());
					setSugar = Double.parseDouble(saveFile.readLine());
					setBloodPressureTop = Double.parseDouble(saveFile
							.readLine());
					setBloodPressureBot = Double.parseDouble(saveFile
							.readLine());
					visitMonth = Integer.parseInt(saveFile.readLine());
					visitDay = Integer.parseInt(saveFile.readLine());
					visitYear = Integer.parseInt(saveFile.readLine());
					setSymptoms = saveFile.readLine();
					setNotes = saveFile.readLine();
					setPrescription = saveFile.readLine();
					Visit newVisit = new Visit(visitMonth, visitDay, visitYear,
							setBloodPressureTop, setBloodPressureBot, setSugar,
							setWeight, setHeight, setTemperature, setSymptoms,
							setNotes, setPrescription);
					newPatient.getMedicalRecord().addVisit(newVisit);
					fileLine = saveFile.readLine();

				}
				setDoctor = (Doctor) Globals.userDatabase
						.searchUserID(doctorID);
				if(setDoctor != null)
				{
				setDoctor.addPatient(newPatient);
				newPatient.setDoctor(setDoctor);
				}
				newPatient.setAnswers(setAnswer1, setAnswer2, setAnswer3);
				newPatient.setUserID(setID);
				Globals.userDatabase.insert(newPatient);
				fileLine = saveFile.readLine();
				
			}
		
		}

		saveFile.close();
		}
	}
}