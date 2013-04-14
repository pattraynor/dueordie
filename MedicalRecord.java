/*
 * Class to be implemented with Visit.
 */

/**
 *
 * @author Patrick Traynor
 */
import java.util.ArrayList;


public class MedicalRecord 
{
    
    
    private ArrayList<Visit> medicalRecordList;
    
    //ArrayLists to Implement for charts:_____________________________________
    protected ArrayList<Double> sugarChart = new ArrayList<Double>();
             
    protected ArrayList<Double> weightChart = new ArrayList<Double>();
    protected ArrayList<Double> heightChart = new ArrayList<Double>();
    protected ArrayList<Double> temperatureChart = new ArrayList<Double>();
    protected ArrayList<Double> bloodPressureTopChart = new ArrayList<Double>();
    protected ArrayList<Double> bloodPressureBotChart = new ArrayList<Double>();
    protected ArrayList<String> prescriptions = new ArrayList<String>();
    protected ArrayList<String> dates = new ArrayList<String>();
    //___________________________________________________________________
    public MedicalRecord()
    {
    	medicalRecordList = new ArrayList<Visit>();
    }

    // takes in Double ArrayList and returns double[]
    private double[] createDoubleArray(ArrayList<Double> arrayList)
    {
        int arraySize = arrayList.size();
        double newDouble[] = new double[arraySize];
        int iterNode = 0;
        while(iterNode < arraySize)
        {
            newDouble[iterNode] = arrayList.get(iterNode);
            iterNode++;

        }
        return newDouble;
    }

    //takes String ArrayList and returns String[]
    private String[] createStringArray(ArrayList<String> arrayList)
    {
        int arraySize = arrayList.size();
        String newString[] = new String[arraySize];
        newString = arrayList.toArray(newString);
        return newString;
    }

    public Visit getLastVisit()
    {
    	if(getVisitCount() > 0)
    	{
        Visit lastVisit = medicalRecordList.get(0);;
        return lastVisit;
    	}
    	else 
    		return null;
    }
    
    public Visit getVisit(int index)
    {
    	if(getVisitCount() > 0)
    	{
        Visit _visit = medicalRecordList.get(index);;
        return _visit;
    	}
    	else 
    		return null;
    }
    
    public Visit getVisit(int month, int day, int year)
    {
    	
        int searchIndex = 0;
        int searchUpperBound = getVisitCount() -1;
        while(searchIndex <= searchUpperBound)
        {
        	
            if(medicalRecordList.get(searchIndex).getYear() == year)
            {
        
                if(medicalRecordList.get(searchIndex).getMonth() == month)
                {
              
                    if(medicalRecordList.get(searchIndex).getDay() == day)
                    {
                    	
                        return medicalRecordList.get(searchIndex);
                    }
                }
            }
            searchIndex++;
        }
        Visit visitNotFound = null;
        return visitNotFound;

    }

    public int getVisitCount()
    {  
        return medicalRecordList.size();
        
    }

    public double[] getBloodPressureTopChart()
    {
        double tempChart[] = (createDoubleArray(bloodPressureTopChart));
        return tempChart;
    }
    public double[] getBloodPressureBotChart()
    {
        double tempChart[] = (createDoubleArray(bloodPressureBotChart));
        return tempChart;
    }
    
    public double[] getSugarChart()
    {
        double tempChart[] = (createDoubleArray(sugarChart));
        return tempChart;
    }
    
    public double[] getWeightChart()
    {
        double tempChart[] = (createDoubleArray(weightChart));
        return tempChart;
        
    }
    public double[] getHeightChart()
    {
        double tempChart[] = (createDoubleArray(heightChart));
        return tempChart;
        
    }
    
    public double[] getTemperatureChart()
    {
        double tempChart[] = createDoubleArray(temperatureChart);
        return tempChart;
        
    }
    public String[] getAllPrescriptions()
    {
        String tempChart[] = createStringArray(prescriptions);
        return tempChart;
    }
    public String[] getDates()
    {
        String tempChart[] = createStringArray(dates);
        return tempChart;
    }
    public void addSugar(double newSugar)
    {
        sugarChart.add(newSugar);
        
    }
    public void addBloodPressureTop(double newBPTop)
    {
       bloodPressureTopChart.add(newBPTop);
    }
    public void addBloodPressureBot(double newBPBot)
    {
       bloodPressureBotChart.add(newBPBot);
    }
    public void addWeight(double newWeight)
    {
        weightChart.add(newWeight);
    }
    public void addHeight(double newHeight)
    {
        heightChart.add(newHeight);
    }
    
    public void addTemperature(double newTemperature)
    {
        temperatureChart.add(newTemperature);
    }
    
    public void addPrescription(String newPrescription)
    {
        prescriptions.add(newPrescription);
    }
    public void addDate(String newDate)
    {
        dates.add(newDate);
    }

    //-----------------------------------------
    // adds a visit instance to the list
    //----------------------------------------
    public void addVisit(Visit newVisit)
    {
        

        this.addToCharts(newVisit);
        medicalRecordList.add(0, newVisit);
        
    }
    // -------------------------------------------------------------
    // used by addVisit, when a new visit is added to the list-
    // it calls this method to add all information into designated-
    // Array Lists
    //--------------------------------------------------------------
    private void addToCharts(Visit newVisit)
    {
        this.addTemperature(newVisit.getTemperature());
        this.addBloodPressureBot(newVisit.getBloodPressureBot());
        this.addBloodPressureTop(newVisit.getBloodPressureTop());
        this.addHeight(newVisit.getHeight());
        this.addWeight(newVisit.getHeight());
        this.addSugar(newVisit.getSugar());
        this.addDate(newVisit.getDate());
        this.addPrescription(newVisit.getPrescription());
    }

 
   
    public String toString()
    {
    	
    	String medicalRecordString = "";
    	int printIndex = 0;
    	int indexBound = getVisitCount() - 1;
    	if(getVisitCount() < 0)
    	{
    		return "\r\nEND RECORD";
    	}
    	while(printIndex <= indexBound)
    	{
    		medicalRecordString = medicalRecordString + 
    				medicalRecordList.get(printIndex).toString();
    		printIndex++;
    	}
    	
    	medicalRecordString = medicalRecordString + "\r\nEND RECORD" + "\r\n";
    	return medicalRecordString;
        
    }

	public String[] toArray() {
		int index = 0;
		int indexBound = getVisitCount() - 1;
		if(indexBound >= 0)
		{
		String[] visitDates = new String[indexBound + 1];
	
			while(index <= indexBound)
			{
				visitDates[index] = medicalRecordList.get(index).getDate();
				index++;
		
			}
			return visitDates;
		}
		String[] visitDates = new String[1];
		visitDates[0] = "No Entries";
		return visitDates;
	}
        
    
        
        
}
