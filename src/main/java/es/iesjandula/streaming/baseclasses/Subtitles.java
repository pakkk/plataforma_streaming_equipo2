package es.iesjandula.streaming.baseclasses;

public class Subtitles {
	/**This class is responsible for loading subtitle data and storing it in an array
	* Attributes
	*String language: attribute that defines the language of the subtitle
	**/
	private String language;
	
	// Constructor
	/**
	 *  Constructor that sets he value of the language attribute
	 * @param language
	 */
    public Subtitles(String language)
    {
        this.language = language;
    }
    
    // Getters
    /** Get method for the language attribute that returns its value
     * 
     * @return
     */
    public String getLanguage() 
    {
        return this.language;
    }
    
    // Setters
    /** Set method for the language attribute that allows to change its value
     * 
     * @param language
     */
    public void setLanguage(String language)
    {
        this.language = language;
    }
    
    /**
     * retun the atributes of the class
     */
    @Override
    public String toString()
    {
        return "Subtitles{" + "language=" + this.language + '}';
    }
}