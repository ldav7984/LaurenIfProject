package controller;

import model.Instrument;
import javax.swing.JOptionPane;


public class InstrumentController
{

	//private declaration section
	private Instrument myInstrument;
	private Instrument userInstrument;

	
	//constructors
	public InstrumentController()
	{
		myInstrument = new Instrument(4, "E", false, " violin"); 
		//put this constructor's parameters in the parenthesis
		userInstrument = new Instrument(); 
		//constructor with no parameters
	}
	
	public void Start()
	{
		JOptionPane.showMessageDialog(null, myInstrument);
		loopy();
		
		
		String userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		int numStrings = 0; //default value
		//if(validInt(userInput))
		//{
		//	numStrings = Integer.parseInt(userInput);
		//}
		//userInstrument.setNumStrings(numStrings);
		while(!validInt(userInput)) //if the user does not type in an integer
		{
			userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		}
		userInstrument.setNumStrings(Integer.parseInt(userInput)); //if input is an integer set it to the new numStrings count
		if (userInstrument.getNumStrings() == 4) //if it has 4 strings
		{
			JOptionPane.showMessageDialog(null, "Your instrument has " + userInstrument.getNumStrings()
					+ " strings. It probably belongs in a string orchestra!" );
		}
		else //if it doesn't have 4 strings
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
		if (userInstrument.getNumStrings() != 4) //if it does not have 4 strings
		{
			userInstrument.setInstrumentType("n unknown"); //n because it adds onto "it must be a"
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
											+ userInstrument.getHighestStringPitch() + ". Your instrument is sure unusual!");
		}
		else if (highestStringPitch.equalsIgnoreCase("A"))
		{
			if (isCelloOrBass) //if its highest string is A and it is a cello or bass it must be a cello
			{
				JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
						+ userInstrument.getHighestStringPitch() + ".");
				userInstrument.setInstrumentType(" cello");
			}
			else //if its highest string is A and it is not a cello or bass it must be a viola
			{
				JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
						+ userInstrument.getHighestStringPitch() + ".");
				userInstrument.setInstrumentType(" viola");
			}
		}
		else if (highestStringPitch.equalsIgnoreCase("E") && isCelloOrBass == false) //if the highest string is E and it is not a cellor or bass
		{
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
					+ userInstrument.getHighestStringPitch() + ".");
			userInstrument.setInstrumentType(" violin");
		}
		else if (highestStringPitch.equalsIgnoreCase("G") && isCelloOrBass) //if the highest string is G and it is a cello or bass
		{
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
					+ userInstrument.getHighestStringPitch() + ".");
			userInstrument.setInstrumentType("n upright bass");
		}
		else
		{
			userInstrument.setInstrumentType("n unknown"); //n because it adds onto "it must be a"
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
					+ userInstrument.getHighestStringPitch() + ". Your instrument is sure unusual!");
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
			
			if (someCount > 3)
			{
				isFinished = true; //ends the loop after one run
			}
		}
		
		//for (int index = 0; index < 10; index++) //starting value, condition, change
		//{
		//	JOptionPane.showMessageDialog(null, "This is execution number " + index);
		//}
		
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
