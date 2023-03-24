package es.iesjandula.streaming.baseclasses;

public class Subtitles {
	// This class is responsible for loading subtitle data and storing it in an array
	// Attributes
	// String language: attribute that defines the language of the subtitle
	private String language;
	
	// Constructor
	// Constructor that sets the value of the language attribute
    public Subtitles(String language)
    {
        this.language = language;
    }
    
    // Getters
    // Get method for the language attribute that returns its value
    public String getLanguage() 
    {
        return this.language;
    }
    
    // Setters
    // Set method for the language attribute that allows to change its value
    public void setLanguage(String language)
    {
        this.language = language;
    }
    
    // ToString method for the language attribute that shows its value
    @Override
    public String toString()
    {
        return "Subtitles{" + "language=" + this.language + '}';
    }
}