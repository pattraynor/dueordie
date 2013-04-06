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
    protected ArrayList<Double> bloodPressureTopChart = new ArrayList<Double>();
    protected ArrayList<Double> bloodPressureBotChart = new ArrayList<Double>();
    protected ArrayList<String> prescriptions = new ArrayList<String>();
    protected ArrayList<String> dates = new ArrayList<String>();
    //___________________________________________________________________
    public MedicalRecord()
    {
        head = null;        
        listSize = 0;
        visitCount = 0;
    }

    // takes in Double ArrayList and returns double[]
    private double[] createDoubleArray(ArrayList<Double> arrayList)
    {
        int arraySize = arrayList.size();
        double newDouble[] = new double[arraySize];
        int iterNode = 0;
        while(iterNode < arraySize)
        {
            newDouble[arraySize] = arrayList.get(arraySize);
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
        Visit lastVisit = head.getVisit();
        return lastVisit;
    }
    
    public Visit getVisit(int year, int month, int day)
    {
        Node tempNode = head;
        while(tempNode.getVisit() != null)
        {
            if(tempNode.getVisit().getYear() == year)
            {
                if(tempNode.getVisit().getMonth() == month)
                {
                    if(tempNode.getVisit().getDay() == day)
                    {
                        return tempNode.getVisit();
                    }
                }
            }
            tempNode = tempNode.getNext();
        }
        Visit visitFound = new Visit();
        return visitFound;

    }
    
    public int getVisitCount()
    {  
        return visitCount;
        
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
    
    public void addTempetature(double newTemperature)
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
    public void addVisit(Visit newVisit)
    {
        visitCount++;


        Node newHead = new Node(newVisit, head);
        head = newHead;
        
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
