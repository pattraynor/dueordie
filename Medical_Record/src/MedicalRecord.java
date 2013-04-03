/*
 * Class to be implemented with Visit.
 */

/**
 *
 * @author Patrick Traynor
 */
import java.util.ArrayList;
import java.util.Random;

public class MedicalRecord 
{
    protected Node head;
    protected int listSize;
    protected int visitCount;
    
    //ArrayLists to Implement for charts:_____________________________________
    protected ArrayList<double> sugarChart = new ArrayList<double>();
                // How to add into double arraylist: 
                // intList.add(1);
                // intList.add(2);
    protected ArrayList<double> weightChart = new ArrayList<double>();
    protected ArrayList<double> heightChart = new ArrayList<double>();
    protected ArrayList<double> temperatureChart = new ArrayList<double>();
    protected ArrayList<double> bloodPressureChart = new ArrayList<double>();
    protected ArrayList<String> prescriptions = new ArrayList<String>();
    //___________________________________________________________________
    public MedicalRecord()
    {
        head = null;        
        listSize = 0;
        visitCount = 0;
    }
    
    public Visit getLastVisit()
    {
       
        return null;
    }
    
    public Visit getVisit(int year, int month, int day)
    {
        
        //return 
    }
    
    public int getVisitCount()
    {  
        return visitCount;
        
    }
    
    public Array getSugarChart()
    {
        return ..;
    }
    
    public Array getWeightChart()
    {
        
    }
    public Array getHeightChart()
    {
        
    }
    
    public Array getTemperatureChart()
    {
        
    }
    public String getAllPrescriptions()
    {
        for(int i=0; i<prescriptions.getlength(); i++)
        {
            System.out.println(prescriptions[i]);
        }
    }
    public void addSugar()
    {
        
    }
    public void addWeight()
    {
        
    }
    public void addHeight()
    {
        
    }
    
    public void addTempetature()
    {
        
    }
    
    public void addPrescription()
    {
        
    }
    public void addVisit(new Visit)
    {
        
    }
    
}
