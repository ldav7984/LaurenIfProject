package controller;

import java.util.Scanner;
import model.Instrument;
import javax.swing.JOptionPane;


public class InstrumentController
{

	//private declaration section
	private Instrument myInstrument;
	private Instrument userInstrument;
	private Scanner inputScanner;
	
	//make one constructor with zero parameters, one with at least one
	
	public InstrumentController()
	{
		myInstrument = new Instrument(); //put my parameters in here
		userInstrument = new Instrument();
		inputScanner = new Scanner(System.in);
	}
	
	public void Start()
	{
		JOptionPane.showMessageDialog(null, myInstrument);
		//all of the input and assignment things
		
		
		
		
		JOptionPane.showMessageDialog(null, userInstrument);
		inputScanner.close();
	}
	
	
	
	
	
	
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
