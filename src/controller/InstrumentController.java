package controller;

import model.Instrument; 
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class InstrumentController
{
	//private declaration section
	private Instrument myInstrument; 
	//instrument built by my parameters as an example/default
	private Instrument userInstrument; 
	//instrument built by user input
	
	/**
	 * Constructs two new instances of Instrument, 
	 * one with parameters in the parenthesis 
	 * and one with parameters input by the user.
	 */
	public InstrumentController() 
	{
		myInstrument = new Instrument(4, "E", false, " violin"); 
		//put this constructor's parameters in the parenthesis
		userInstrument = new Instrument(); 
		//this constructor has no parameters
		//parameters later filled with user input
	}
	
	/**
	 * Print myInstrument and calls on
	 * InstrumentLoop(), which calls on askUser()
	 */
	public void Start()
	{
		JOptionPane.showMessageDialog(null, myInstrument);
		InstrumentLoop();
		//lotsOfInstruments();
		//askUser();
		//JOptionPane.showMessageDialog(null, userInstrument);
	} //end of Start() method
	
	/**
	 * Sets parameter values for userInstruments based on user input.
	 */
	public void askUser() 
	{
		String userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		//int numStrings = 0; //default value
		//if(validInt(userInput))
		//{
		//	numStrings = Integer.parseInt(userInput);
		//}
		//userInstrument.setNumStrings(numStrings);
		
		
		//Every time the user does not type anything at all, 
		//types an invalid integer, or presses cancel, this loop is run
		while(userInput == null || !validInt(userInput) || userInput.equals("")) 
		{
			userInput = JOptionPane.showInputDialog(null, "How many strings does your instrument have?");
		}
		userInstrument.setNumStrings(Integer.parseInt(userInput)); 
		//if input is an integer set it to the new numStrings count
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
		isCelloOrBass = userInstrument.getHasEndPin(); //if it has an end pin then isCelloOrBass is true
		while (userInput == null || userInput.equals(""))  //as long as the user enters nothing or presses cancel
		{
			userInput = JOptionPane.showInputDialog(null, "Type in something and don't press cancel." 
					+ " \nWhat is the pitch name of your instrument's highest string?");
			highestStringPitch = userInput;
			userInstrument.setHighestStringPitch(highestStringPitch);
		}
		if (userInstrument.getNumStrings() != 4) //if it does not have 4 strings
		{
			userInstrument.setInstrumentType("n unknown"); //n so toString() prints "an unknown"
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
		else if (highestStringPitch.equalsIgnoreCase("E") && isCelloOrBass == false) //if the highest string is E and it is not a cello or bass
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
		else //if it's not any of those things above
		{
			userInstrument.setInstrumentType("n unknown"); //n so toString() prints "an unknown"
			JOptionPane.showMessageDialog(null, "Your instrument's highest string pitch is " 
					+ userInstrument.getHighestStringPitch() + ". \nYour instrument is sure unusual!");
		}
	}//end of askUser() method
	
	/**
	 * Keeps track of how many Instruments 
	 * have been made and tells the user.
	 */
	private void InstrumentLoop()
	{
		for (int instrumentsMade = 1; instrumentsMade <= 4; instrumentsMade ++)
		{
			askUser();
			JOptionPane.showMessageDialog(null, userInstrument);
			if (instrumentsMade == 1)
			{
				JOptionPane.showMessageDialog(null, "You've now made " 
									+ instrumentsMade + " instrument.");
			}
			else if (instrumentsMade == 4)
			{
				JOptionPane.showMessageDialog(null, "You've now made " 
									+ instrumentsMade + " instruments.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You've now made " 
						+ instrumentsMade + " instruments.");
			}
		}
	} //end of InstrumentLoop() method
	
	
	private void lotsOfInstruments()
	{
		//local variables are only visible in the method they are defined in!
		//They only have SCOPE to that method (this method)
		
	
		ArrayList<Instrument> myInstruments = new ArrayList<Instrument>();
		
		Instrument sampleInstrument = new Instrument();
		Instrument otherInstrument = new Instrument();
		
		//Can add something more than once - sampleInstrument was made once but added twice 
		//(example if you have 2 instruments - but not very helpful)
		myInstruments.add(sampleInstrument); //at 0
		myInstruments.add(sampleInstrument); //at 1
		myInstruments.add(otherInstrument);  //at 2
		myInstruments.add(3, otherInstrument);  //at 3
		myInstruments.remove(2); //2 has been removed, the rest slide down
		
		
		//standard forward loop - goes through list beginning to end
		//index starts at 0, .size tells how many things are, index goes up by 1 each time
		//If used to remove values you have to change index -=1
		for (int index = 0; index < myInstruments.size(); index += 1) 
		{
			//good for display, or minor changes
			//myInstrument.setNumInstruments(myInstruments.size());
			//JOptionPane.showMessageDialog(null, "There are " 
			//+ myInstrument.getNumInstruments() + " instruments.");
			JOptionPane.showMessageDialog(null, "This is instrument #" + index + ".");
			//myInstruments.setNumInstruments().get(index);
			
			//good to remove, replace, or change multiple values
			//Instrument currentInstrument = myInstruments.get(index);
			//JOptionPane.showMessageDialog(null, "This is instrument #" + index + ".");
			//currentInstrument.set
		}
		
		//standard backward loop - goes through list end to beginning
		//great for removing values!
		//for (int index = myInstruments.size() - 1; index >= 0; index -= 1)
		//{
			
		//}
		
		//for each loop
		//can't remove and can't replace - good for .get .set and printing
		for (Instrument current : myInstruments)
		{
			JOptionPane.showMessageDialog(null, "The instrument is a " + current.getInstrumentType() + ".");
		
		} //current variable no longer exists after this bracket 
		//it can't be removed or replaced (no =), only modified with methods
		
		
	} //end of lotsOfInstruments() method
	
	
	
	/**
	 * Tests if something is a valid integer
	 * @param maybeInt   String that could possibly be an integer
	 * @return isValid   Is it a valid integer
	 */
	public boolean validInt(String maybeInt) 
	{
		boolean isValid = false; //default value
		try
		{
			Integer.parseInt(maybeInt); //try to parse the input into an integer
			isValid = true;
		}
		catch (NumberFormatException error) //if it can't parse, it allows user to try again
		{
			JOptionPane.showMessageDialog(null, "You need to type in a whole number and don't press cancel :)");
		}
		return isValid;
	} //end of validInt()
	
}//end of InstrumentController class
