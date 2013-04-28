
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
	public Double[] checkDoubleInputs(String[] stringInputs)
	{
		if(stringInputs == null)
			return null;
		
		int indexBound = stringInputs.length;
		
		int index = 0;
		boolean errorCheck = true;
		
		while(index < indexBound && (errorCheck != false))
		{
			if(stringInputs[index].length() > 0)
				errorCheck = isDouble(stringInputs[index]);
			index++;
				
		}
		index = 0;
		if(errorCheck != false)
		{
			Double[] doubleArray = new Double[indexBound];
			while(index < indexBound)
			{
					
				if(stringInputs[index].length() > 0)
					doubleArray[index] = Double.parseDouble(stringInputs[index]);
				else doubleArray[index] = 0.0;
				
				index++;
				
			}
			return doubleArray;
		}
		else return null;
	
	}
	
	//checks to make sure input is within certain bounds
	public int checkInputSize(Double[] inputs)
	{
		
		int index = 0;
		
	
			//checks blood pressure top
			if(inputs[index] > 300)
				return -1;
			index++;	
			//checks blood pressure bot
			if(inputs[index] > 300)
				return -1;
			index++;
			//checks blood sugar
			if(inputs[index] > 300)
				return -1;
			index++;
			//checks weight
			if(inputs[index] > 1600)
				return -1;
			index++;
			//checks height
			if(inputs[index] > 120)
				return -1;
			index++;
			//checks temperature
			if(inputs[index] > 107)
				return -1;
		
			
		return 0;	
			
		
	}
	
	//bloodPressureTopBox.getText(),
	//bloodPressureBotBox.getText(), bloodSugarBox.getText(),
	//weightBox.getText(), heightBox.getText(),
	//temperatureBox.getText() };
	//------------------------------------------------------------------
	// Checks string length. Returns -1 if String length is 0 or less
	//------------------------------------------------------------------
	public int checkStringlength(String newString)
	{
		if(newString.length() > 0)
		{
			return 0;
		}
		else return -1;
	}
}
