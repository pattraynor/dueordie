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
    
    public Double[] getSugarChart()
    {
        //Store values from ArrayList into normal array.
        Double[] sugarChart = {};
        return sugarChart;
    }
    
    public Double[] getWeightChart()
    {
        //Store values from ArrayList into normal array.
        Double[] weightChart = {};
        return weightChart;
        
    }
    public Double[] getHeightChart()
    {
        //Store values from ArrayList into normal array.
        Double[] heightChart = {};
        return heightChart;
        
    }
    
    public Double[] getTemperatureChart()
    {
        //Store values from ArrayList into normal array.
        Double[] temperatureChart = {};
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
    
    public void addPrescription(String newPrescription)
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
