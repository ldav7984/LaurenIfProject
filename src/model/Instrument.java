package model;

public class Instrument //model
{
	private int numStrings;
	private String highestStringPitch;
	private Boolean hasEndPin;
	private String instrumentType;
	
	
	/**
	 * Default constructor for an Instrument.
	 * Initializes all variables to valid but "bad" values.
	 * Used for later customization.
	 */
	public Instrument()
	{
		this.numStrings = 0;
		this.highestStringPitch = "a";
		this.hasEndPin = false;
		this.instrumentType = "violin";
		
	}
	
	/**
	 * Initializes an Instrument instance
	 * @param numStrings The number of strings the instrument has
	 * @param highestStringPitch  The note pitch of the highest string on the instrument
	 * @param hasEndPin  Does the instrument have an end pin or not
	 * @param instrumentType  What type of instrument is it (limited to string orchestra)
	 */
	public Instrument(int numStrings, String highestStringPitch, 
						Boolean hasEndPin, String instrumentType)
	{
		this.numStrings = numStrings;
		this.highestStringPitch = highestStringPitch;
		this.hasEndPin = hasEndPin;
		this.instrumentType = instrumentType;
	}

	public int getNumStrings() //getter
	{
		return numStrings;
	}
	
	public String getHighestStringPitch() //getter 
	{
		return highestStringPitch;
	}
	
	public boolean getHasEndPin() //getter
	{
		return hasEndPin;
	}
	
	public String getInstrumentType() //getter
	{
		return instrumentType;
	}
	
	public void setNumStrings(int numStrings) //setter
	{
		this.numStrings = numStrings;
	}
	
	public void setHighestStringPitch(String highestStringPitch) //setter
	{
		this.highestStringPitch = highestStringPitch;
	}
	
	public void setHasEndPin(boolean hasEndPin) //setter
	{
		this.hasEndPin = hasEndPin;
	}
	
	public void setInstrumentType(String instrumentType) //setter
	{
		this.instrumentType = instrumentType;
	}
	
	public String toString() //lets us print out information about any object
	{
		String description = "This instrument has " + numStrings + " strings. "
				+"The pitch of its highest string is " + highestStringPitch + ". "
				+ "It is " + hasEndPin + " that it has an end pin. "
				+ "It must be a " + instrumentType + ". ";
		return description;
	}
	
	
	
	
}
