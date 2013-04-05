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
        Visit lastVisit = head.getVisit();
        return lastVisit;
    }
    
    public Visit getVisit(int year, int month, int day)
    {
        //search for visit then set it equal to visitFound
        Visit visitFound = new Visit();
        return visitFound;

    }
    
    public int getVisitCount()
    {  
        return visitCount;
        
    }
    public double[] getBloodPressureTopChart()
    {
        //Store values from ArrayList into normal array.
        double[] bloodPressureTopChart = {};
        return bloodPressureTopChart;
    }
    public double[] getBloodPressureBotChart()
    {
        //Store values from ArrayList into normal array.
        double[] bloodPressureBotChart = {};
        return bloodPressureBotChart;
    }
    
    public double[] getSugarChart()
    {
        //Store values from ArrayList into normal array.
        double[] sugarChart = {};
        return sugarChart;
    }
    
    public double[] getWeightChart()
    {
        //Store values from ArrayList into normal array.
        double[] weightChart = {};
        return weightChart;
        
    }
    public Double[] getHeightChart()
    {
        //Store values from ArrayList into normal array.
        Double[] heightChart = {};
        return heightChart;
        
    }
    
    public double[] getTemperatureChart()
    {
        //Store values from ArrayList into normal array.
        double[] temperatureChart = {};
        return temperatureChart;
        
    }
    public String[] getAllPrescriptions()
    {
        //Store values from ArrayList into normal array.
        String[] prescriptions = {};
        return prescriptions;
       /* for(int i=0; i<prescriptions.getlength(); i++)
        {
            System.out.println(prescriptions[i]);
        }*/
    }
    public String[] getDates()
    {
        //Store values from ArrayList into normal array.
        String[] dates = {};
        return dates;
    }
    public void addSugar()
    {
        
    }
    public void addBloodPressureTop()
    {

    }
    public void addBloodPressureBot()
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
    
    public void addPrescription(String newPrescription)
    {
        
    }
    public void addDate(String newDate)
    {

    }
    public void addVisit(Visit newVisit)
    {
        
    }
 
    private class Node
    {

        private Visit visit;
        private Node next;

        public Node(Visit setVisit, Node setNext)
        {
            next = setNext;
            visit = setVisit;
        }
        public Node()
        {
            next = null;
            visit = null;
        }

        public Visit getVisit()
        {
            return visit;
        }

        public Node getNext()
        {
            return next;
        }
    }
        
    private Node first;
        
    
        
        
}
