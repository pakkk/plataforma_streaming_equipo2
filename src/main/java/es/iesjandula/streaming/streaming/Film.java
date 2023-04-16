package es.iesjandula.streaming.streaming;

/**
 * Class that stores audiovisual data after loading it into an array
 * @author Alejandro
 */

public class Film extends Audiovisual
{
	
	/**
	 * Parametriced constructor
	 * Constructor comes from the Audiovisual class
	 * @param title the title of the Audiovisual
	 * @param originalLanguage the original language of the Audiovisual
	 * @param adaptedLanguages the adapted languages of the Audiovisual
	 * @param duration the duration of the Audiovisual
	 * @param views the views of the Audiovisual
	 * */
    	
    public Film(String title, String originalLanguage,String adaptedLanguage[], int duration, int views)
    {
        super(title, originalLanguage,adaptedLanguage, duration, views);
    }
    
    /**The methods are inherited from the Audiovisual class so it is not necessary to introduce them here*/	
}