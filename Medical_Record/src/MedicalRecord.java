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
    protected ArrayList<Double> sugarChart = new ArrayList<Double>();
                // How to add into double arraylist: 
                // intList.add(1);
                // intList.add(2);
    protected ArrayList<Double> weightChart = new ArrayList<Double>();
    protected ArrayList<Double> heightChart = new ArrayList<Double>();
    protected ArrayList<Double> temperatureChart = new ArrayList<Double>();
    protected ArrayList<Double> bloodPressureChart = new ArrayList<Double>();
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
        
        return 
    }
    public int getVisitCount()
    {  
        return visitCount;
        
    }
    public Arraylist getSugarChart()
    {
        return ..;
    }
    public
    
}
