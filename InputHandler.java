
public class InputHandler {
	
	//checks to make sure the string can be turned into a double
	private boolean isDouble(String newDouble)
	{
	
			try
			{
				Double.parseDouble(newDouble);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		
		
	}

	
	//uses isDouble to check if string can be a double,
	//then puts all strings into a new double array.
	//If one of the strings is empty, the double is set to 0.
	public Double[] checkDoubleInputs(String[] stringArray)
	{
			int indexBound = stringArray.length;
		
			int index = 0;
			boolean errorCheck = true;
		
			while(index < indexBound && (errorCheck != false))
			{
				if(stringArray[index].length() > 0)
					errorCheck = isDouble(stringArray[index]);
				index++;
				
			}
			index = 0;
			if(errorCheck != false)
			{
				Double[] doubleArray = new Double[indexBound];
				while(index < indexBound)
				{
					
						if(stringArray[index].length() > 0)
							doubleArray[index] = Double.parseDouble(stringArray[index]);
						else doubleArray[index] = 0.0;
				
						index++;
				
				}
				return doubleArray;
			}
			else return null;

		
	}
	

	//checks to make sure string length is at least 1.
	public int checkStringlength(String newString)
	{
		if(newString.length() > 0)
			return 0;
		else return -1;
	}
}
