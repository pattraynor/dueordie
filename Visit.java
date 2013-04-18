//Each time a patient visits the doctors office 
//or enters daily values, a new instance of Visit 
//is created and added to he medical record ArrayList
public class Visit 
{

	private int year;
	private int day;
	private int month;
	private double bloodPressureTop;
    private double bloodPressureBot;
	private double sugar;
	private double weight; //measured in inches
	private double height; //measured in pounds
	private double temperature;
	private String prescriptions;
	private String symptoms;
	private String notes;
	
	public Visit()
	{
		year = 0;
		day = 0;
		month = 0;
		bloodPressureTop = 0;
        bloodPressureBot = 0;
		sugar = 0;
		weight = 0;
		height = 0;
		temperature = 0;
		prescriptions = "N/A";
		symptoms = "N/A";
		notes = "N/A";	
	}
	
	public Visit(int mon, int today, int newYear, double pressureTop, 
			double pressureBot, double sweet, double pounds,
			double inches, double fever, String problems)
	{
		if(problems.length() <= 0)
			problems = "N/A";
		month = mon;
		day = today;
		year = newYear;
		bloodPressureTop = pressureTop;
        bloodPressureBot = pressureBot;
		sugar = sweet;
		weight = pounds;
		height = inches;
		temperature = fever;
		symptoms = problems;
		prescriptions = "N/A";
		notes = "N/A";	
		
		
	}

	public Visit(int _month, int _day, int _year, double pressureTop, 
			double pressureBot, double _sugar, double _weight,
			double _height, double _temperature, String _symptoms,
			String _notes, String _prescriptions)
	{
		month = _month;
		day = _day;
		year = _year;
		bloodPressureTop = pressureTop;
        bloodPressureBot = pressureBot;
		sugar = _sugar;
		weight = _weight;
		height = _height;
		temperature = _temperature;
		notes = _notes;
		symptoms = _symptoms;
		prescriptions = _prescriptions;
		notes = _notes;	
		
		
	}
	
	public Visit(int mon, int today, int newYear, double pressureTop, double pressureBot, double sweet, double pounds)
	{
		month = mon;
		day = today;
		year = newYear;
		bloodPressureTop = pressureTop;
        bloodPressureBot = pressureBot;
		sugar = sweet;
		weight = pounds;
		height = 0;
		temperature = 0;
		symptoms = "N/A";
		prescriptions = "N/A";
		notes = "N/A";
		
		
	}
	public int getDay()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setDay(int date)
	{
		day = date;
	}
	
	public void setMonth(int newMonth)
	{
		month = newMonth;
	}
	
	public void setYear(int newYear)
	{
		year = newYear;
	}
	
	public String getDate()
	{
		if(month != 0 && day != 0 && year !=0)
		{
			return month + "/" + day + "/" + year;
		}else
		{
			return "Please enter month, day, and year";
		}
	}
	
	public void setNotes(String newNotes)
	{
		notes = newNotes;
	}
	
	public double getBloodPressureTop()
	{
		return bloodPressureTop;
	}
    public double getBloodPressureBot()
    {
        return bloodPressureBot;
    }


    public String getNotes()
	{
		return notes;
	}
	
	public double getSugar()
	{
		return sugar;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getTemperature()
	{
		return temperature;
	}
	
	public String getPrescription()
	{
		return prescriptions;
	}
	
	public String getSymptoms()
	{
		return symptoms;
	}
	
	public void setBloodPressureTop(double newbloodPressureTop)
	{
		bloodPressureTop = newbloodPressureTop;
	}
    public void setBloodPressureBot(double newbloodPressureBot)
    {
        bloodPressureBot = newbloodPressureBot;
    }
	
	public void setSugar(double newSugar)
	{
		sugar = newSugar;
	}
	
	public void setWeight(double newWeight)
	{
		weight = newWeight;
	}
	
	public void setTemperature(int newTemp)
	{
		temperature = newTemp;
	}
	
	public void setPrescription(String newPres)
	{
		prescriptions = newPres;
	}
	
	public void setSymptoms(String newSymp)
	{
		symptoms = newSymp;
	}
	
	public void setHeight(double newHeight)
	{
		height = newHeight;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	//Goes through the recorded values and makes them 
	//suitable for printing to GUI. Turns null Strings to empty
	//Strings and turns doubles that are 0 to empty Strings.
	private String[] visitToArray()
	{
		int index = 0, index2 = 0;
		Double[] doubleArray = {temperature, weight, height, bloodPressureTop, bloodPressureBot, sugar};
		String[] tempString = {prescriptions, notes, symptoms};
		String[] visitArray = new String[9];
		
		while(index2 < tempString.length)
		{
	
			if(tempString[index2].equals("N/A"))
			{
				tempString[index2] = "";
			}
			index2++;
		}
		
		while(index < doubleArray.length)
		{
			if(doubleArray[index] == 0)
			{
				visitArray[index] = "";
			}
			else
			{
				visitArray[index] = Double.toString(doubleArray[index]);
			}
			index++;
				
		}
		visitArray[6] = tempString[0];
		visitArray[7] = tempString[1];
		visitArray[8] = tempString[2];
		
		return visitArray;
	}
	
	//Prints out all info in a readable format for the GUI
	public String print()
	{
		
		String[] printVales = visitToArray();
		
		return "Date: \t\t\t" + getDate() + "\n\nTemperature(F): \t" + printVales[0] + "\n\nWeight(lbs): \t\t" +  printVales[1] + 
		"\n\nHeight(inches): \t" +  printVales[2]+ "\n\nBloodPressure: \t\t" +  printVales[3] + "/" +  printVales[4] + 
		"\n\nBlood Sugar(mg/dL): \t" +  printVales[5] + "\n\n\nPrescriptions: \n" +  printVales[6] + 
		"\n\nDoctor's Notes: \n" +  printVales[7] + "\n\nSymptoms: \n" +  printVales[8];
		
		
	}
	
	
	//used by FileHandler to print Visit info to the textfile
	public String toString()
	{
		
		String tempWeight, tempHeight, tempTemperature, tempBloodSugar, tempBloodPressureTop, tempBloodPressureBot, 
		tempDay, tempYear, tempMonth;
		
	
	
			tempWeight = Double.toString(weight);
			tempHeight = Double.toString(height);
			tempTemperature = Double.toString(temperature);
			tempBloodSugar = Double.toString(sugar);
			tempBloodPressureTop = Double.toString(bloodPressureTop); 
			tempBloodPressureBot = Double.toString(bloodPressureBot);
			tempDay = Integer.toString(day);
			tempMonth = Integer.toString(month);
			tempYear = Integer.toString(year);
		
		return "\r\n" + tempWeight + "\r\n" + tempHeight +  "\r\n" + tempTemperature +  "\r\n" + tempBloodSugar +  "\r\n" + tempBloodPressureTop +
				 "\r\n" + tempBloodPressureBot +  "\r\n" + tempMonth +  "\r\n" + tempDay + "\r\n" + tempYear + "\r\n" + symptoms + "\r\n" + notes + "\r\n" + prescriptions;
		
	}
}
