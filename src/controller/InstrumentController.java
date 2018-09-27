package controller;

import model.Instrument;
import javax.swing.JOptionPane;


public class InstrumentController
{
	//private declaration section
	private Instrument myInstrument; 
	//instrument built by my parameters as an example/default
	private Instrument userInstrument; 
	//instrument built by user input
	
	//constructors
	public InstrumentController()
	{
		myInstrument = new Instrument(4, "E", false, " violin"); 
		//put this constructor's parameters in the parenthesis
		userInstrument = new Instrument(); 
		//this constructor has no parameters
		//parameters later filled with user input
	}
	
	public void Start()
	{
		JOptionPane.showMessageDialog(null, myInstrument);
		LoopyLoop();
		//askUser();
		//JOptionPane.showMessageDialog(null, userInstrument);
	} //end of Start() method
	
	public void askUser()
	{
		String userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		//int numStrings = 0; //default value
		//if(validInt(userInput))
		//{
		//	numStrings = Integer.parseInt(userInput);
		//}
		//userInstrument.setNumStrings(numStrings);
		while(!validInt(userInput)) //every time the user does not type in an integer
		{
			userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		}
		userInstrument.setNumStrings(Integer.parseInt(userInput)); //if input is an integer set it to the new numStrings count
		if (userInstrument.getNumStrings() == 4) //if it has 4 strings
		{
			JOptionPane.showMessageDialog(null, "Your instrument has " + userInstrument.getNumStrings()
					+ " strings. \nIt probably belongs in a string orchestra!" );
		}
		else //if it doesn't have 4 strings
		{
			JOptionPane.showMessageDialog(null, "Your instrument has " + userInstrument.getNumStrings() 
					+ " strings. \nIt is not a typical string orchestra instrument.");
		}
		
		
		
		
		userInput = JOptionPane.showInputDialog(null, "Does your instrument have an end pin?"
				+ " (True/False)");
		boolean hasEndPin = false; //default value
		
		hasEndPin = Boolean.parseBoolean(userInput);
		userInstrument.setHasEndPin(hasEndPin);
		JOptionPane.showMessageDialog(null, "It is " + userInstrument.getHasEndPin() 
						+ " that your instrument has an end pin."); 
		
		
		
		
		
		//instrumentType depends on what highestStringPitch is 
		//and if it doesn't have 4 strings it defaults to unknown
		userInput = JOptionPane.showInputDialog(null, "What is the pitch name of your instrument's highest string?"
						+ "\n(Most likely A, E, or G)");
		String highestStringPitch = userInput;
		userInstrument.setHighestStringPitch(highestStringPitch);
		boolean isCelloOrBass = false; //default value
		isCelloOrBass = userInstrument.getHasEndPin();
		if (userInstrument.getNumStrings() != 4) //if it does not have 4 strings
		{
			userInstrument.setInstrumentType("n unknown"); //n so it reads "an unknown"
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
					+ userInstrument.getHighestStringPitch() + ". \nYour instrument is sure unusual!");
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
			userInstrument.setInstrumentType("n unknown"); //n so it reads "an unknown"
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
					+ userInstrument.getHighestStringPitch() + ". \nYour instrument is sure unusual!");
		}

	}//end of askUser() loop
	
	
	
	//test the code
	private void LoopyLoop()
	{
		for (int instrumentsMade = 1; instrumentsMade <= 4; instrumentsMade ++)
		{
			askUser();
			JOptionPane.showMessageDialog(null, userInstrument);
			if (instrumentsMade == 1)
			{
				JOptionPane.showMessageDialog(null, "You've now made " + instrumentsMade + " instrument.");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "You've now made " + instrumentsMade + " instruments.");
			}
		}
		
	} //end of LoopyLoop() method
	
	
	//validation  to call on when user needs to input an integer
	public boolean validInt (String maybeInt) 
	{
		boolean isValid = false; //default value
		try
		{
			Integer.parseInt(maybeInt); //try to parse the input into an integer
			isValid = true;
		}
		catch (NumberFormatException error) //if it can't parse it allows user to try again
		{
			JOptionPane.showMessageDialog(null, "You need to type in a whole number :)");
		}
		return isValid;
	}
	
}//end of InstrumentController class
