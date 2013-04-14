
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
		prescriptions = null;
		symptoms = null;
		notes = null;	
	}
	
	public Visit(int mon, int today, int newYear)
	{
		month = mon;
		day = today;
		year = newYear;
		bloodPressureTop = 0;
        bloodPressureBot = 0;
		sugar = 0;
		weight = 0;
		height = 0;
		temperature = 0;
		prescriptions = null;
		symptoms = null;
		notes = null;	
	}
	
	public Visit(int mon, int today, int newYear, double pressureTop, 
			double pressureBot, double sweet, double pounds,
			double inches, double fever, String problems)
	{
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
		prescriptions = null;
		notes = null;	
		
		
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
	
	public Visit(int mon, int today, int newYear, double pressureTop, double pressureBot, double sweet, double pounds,
			double inches, double fever)
	{
		month = mon;
		day = today;
		year = newYear;
		bloodPressureTop = pressureTop;
        bloodPressureBot = pressureBot;
		sugar = sweet;
		weight = pounds;
		height = inches;
		temperature = fever;
		symptoms = "";
		prescriptions = "";
		notes = "";	
		
		
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
	
	public String print()
	{
		String print;
		String tempWeight, tempHeight, tempTemperature, tempBloodSugar, tempBloodPressure, tempDate;
		tempDate = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
		String prescriptionsCopy;
		String symptomsCopy;
		String notesCopy;
		
		if(symptoms == null)
		{
			symptomsCopy = "";
		}
		else
		{
			symptomsCopy = symptoms;
			
		}
		
		if(notes == null)
		{
			notesCopy = "";
		}
		else 
		{
			notesCopy = notes;
		}
		
		if(prescriptions == null)
		{
			prescriptionsCopy = "";
		}
		else 
		{
			prescriptionsCopy = prescriptions;
		}
		
		if(weight == 0)
			tempWeight = "";
		else	
			tempWeight = Double.toString(weight);
		if(height == 0)
			tempHeight = "";
		else
			tempHeight = Double.toString(height);
		
		if(temperature == 0)
			tempTemperature = "";
		else 
			tempTemperature = Double.toString(temperature);
		if(sugar == 0)
			tempBloodSugar = "";
		else 
			tempBloodSugar = Double.toString(sugar);
		if(bloodPressureTop == 0)
			tempBloodPressure = "";
		else
			tempBloodPressure = Double.toString(bloodPressureTop) + "/" + Double.toString(bloodPressureBot);
		


		
		print = "Date: \t\t\t" + tempDate + "\n\nTemperature(F): \t" + tempTemperature + "\n\nWeight(lbs): \t\t" + tempWeight + 
		"\n\nHeight(inches): \t" + tempHeight+ "\n\nBloodPressure: \t\t" + tempBloodPressure + 
		"\n\nBlood Sugar(mg/dL): \t" + tempBloodSugar + "\n\n\nPrescriptions: \n" + prescriptionsCopy + 
		"\n\nDoctor's Notes: \n" + notesCopy + "\n\nSymptoms: \n" + symptomsCopy;
		
		return print;
	}
	
	public String toString()
	{
		String print;
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

		
		print = "\r\n" + tempWeight + "\r\n" + tempHeight +  "\r\n" + tempTemperature +  "\r\n" + tempBloodSugar +  "\r\n" + tempBloodPressureTop +
				 "\r\n" + tempBloodPressureBot +  "\r\n" + tempMonth +  "\r\n" + tempDay + "\r\n" + tempYear + "\r\n" + symptoms + "\r\n" + notes + "\r\n" + prescriptions;
		
		return print;
		
	}
}
