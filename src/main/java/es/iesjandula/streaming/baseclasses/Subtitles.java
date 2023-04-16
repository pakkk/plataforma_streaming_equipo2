package es.iesjandula.streaming.baseclasses;

/**
 * -This class is responsible for loading subtitle data and storing it in an array
 * @author Alejandro
 */
public class Subtitles
{
	/**Attribute language: attribute that defines the language of the subtitle*/
	private String language;

	/**
	 * Constructor that sets he value of the language attribute
	 * @param language the language String value
	 */
    public Subtitles(String language)
    {
        this.language = language;
    }

    // Getters
    /** Get method for the language attribute that returns its value
     *
     * @return returns String value with the language
     */
    public String getLanguage()
    {
        return this.language;
    }

    // Setters
    /** Set method for the language attribute that allows to change its value
     *
     * @param language the language String
     */
    public void setLanguage(String language)
    {
        this.language = language;
    }

    /**
     * toString return the attributes of the class
     * @return returns String with the information
     */
    @Override
    public String toString()
    {
        return "Subtitles{" + "language=" + this.language + '}';
    }
}