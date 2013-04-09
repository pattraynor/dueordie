
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
		prescriptions = "";
		symptoms = "";
		notes = "";	
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
		prescriptions = "";
		symptoms = "";
		notes = "";	
	}
	
	public Visit(int mon, int today, int newYear, double pressureTop, double pressureBot, double sweet, double pounds,
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
	
	public String toString()
	{
		String print;
		print = "Temperature : " + temperature + " (F)" + "\nWeight : " + weight + " (lbs)" + "\nHeight : " + height +
		"(inches)" + "\nBloodPressure : " + bloodPressureTop + "/" + bloodPressureBot + "\nBlood Sugar : " + sugar +
		"(mg/dL)" + "\n\nPrescriptions : " + prescriptions + "\n\nDoctor's Notes : " + notes + "\n\nSymptoms : " + symptoms;
		return print;
	}
}
