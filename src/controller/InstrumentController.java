package controller;

import model.Instrument;
import javax.swing.JOptionPane;


public class InstrumentController
{

	//private declaration section
	private Instrument myInstrument;
	private Instrument userInstrument;
	private Instrument whileInstrument;
	
	
	
	//constructors
	public InstrumentController()
	{
		myInstrument = new Instrument(4, "E", false, "violin"); 
		//put this constructor's parameters in the parenthesis
		userInstrument = new Instrument(); 
		//constructor with no parameters
		Instrument whileInstrument = new Instrument(); //just for practicing the while() loop
	}
	
	public void Start()
	{
		JOptionPane.showMessageDialog(null, myInstrument);
		loopy();
		
		
		String userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		int numStrings = 0;
		if(validInt(userInput))
		{
			numStrings = Integer.parseInt(userInput);
		}
		userInstrument.setNumStrings(numStrings);
		if (numStrings == 4)
		{
			JOptionPane.showMessageDialog(null, "Your instrument has " + userInstrument.getNumStrings()
					+ " strings. It probably belongs in a string orchestra!" );
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Your instrument has " + userInstrument.getNumStrings() 
					+ " strings. It is not a typical string orchestra instrument.");
		}
		
		
		
		
		userInput = JOptionPane.showInputDialog(null, "Does your instrument have an end pin?"
				+ " (True/False)");
		boolean hasEndPin = false; //default value
		
		hasEndPin = Boolean.parseBoolean(userInput);
		userInstrument.setHasEndPin(hasEndPin);
		JOptionPane.showMessageDialog(null, "It is " + userInstrument.getHasEndPin() 
						+ " that your instrument has an end pin."); 
		
	
		
		//instrumentType depends on what highestStringPitch is
		userInput = JOptionPane.showInputDialog(null, "What is the pitch name of your instrument's highest string?");
		String highestStringPitch = userInput;
		userInstrument.setHighestStringPitch(highestStringPitch);
		boolean isCelloOrBass = false; //default value
		isCelloOrBass = userInstrument.getHasEndPin();
		//isCellorOrBass = userInstrument.getHasEndPin();
		if (userInstrument.getNumStrings() != 4)
		{
			userInstrument.setInstrumentType("n unknown"); //n because it adds onto "it must be a"
			JOptionPane.showMessageDialog(null, "Your instrument is sure unusual!");
		}
		else if (highestStringPitch.equalsIgnoreCase("A"))
		{
			if (isCelloOrBass = false)
			{
				userInstrument.setInstrumentType("viola");
			}
			else 
			{
				userInstrument.setInstrumentType("cello");
			}
		}
		else if (highestStringPitch.equalsIgnoreCase("E"))
		{
			userInstrument.setInstrumentType("violin");
		}
		else if (highestStringPitch.equalsIgnoreCase("G"))
		{
			userInstrument.setInstrumentType("bass");
		}
		else
		{
			userInstrument.setInstrumentType("n unknown"); //n because it adds onto "it must be a"
			JOptionPane.showMessageDialog(null, "Your instrument is sure unusual!");
		}
		
		
		
		JOptionPane.showMessageDialog(null, userInstrument);
	} //end of Start() method
	
	//test the code
	private void loopy()
	{
		//define a variable before the loop
		boolean isFinished = false;
		int someCount = 0;
		while (!isFinished) // "while not isFinished" (while not false) 
		{
			
			JOptionPane.showMessageDialog(null, "Yay orchestra!");
			someCount += 1;
			someCount ++; 
			
			if (someCount > 4)
			{
				isFinished = true; //ends the loop after one run
			}
		}
		String response = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		while(!validInt(response))
		{
			response = JOptionPane.showInputDialog(null, "Type in a whole number!");
		}
		whileInstrument.setNumStrings(Integer.parseInt(response));
	} //end of loopy() method
	
	
	
	public boolean validInt (String maybeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "You need to type in a whole number.");
		}
		return isValid;
		
	}
	
	
	
}
