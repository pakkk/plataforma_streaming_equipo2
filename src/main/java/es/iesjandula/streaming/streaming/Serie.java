package es.iesjandula.streaming.streaming;

/**
 * This Class takes care of save data of audiovisual to load the data in one array
 * @author Alejandro
 */

public class Serie extends Audiovisual
{
	
	/**
	 * Parametriced constructor.
	 * Constructor comes from the Audiovisual class
	 * @param title the title of the Audiovisual
	 * @param originalLanguage the original language of the Audiovisual
	 * @param adaptedLanguages the adapted languages of the Audiovisual
	 * @param duration the duration of the Audiovisual
	 * @param views the views of the Audiovisual
	 * */
		
	public Serie(String title, String originalLanguage,String[] adaptedLanguage, int duration, int views) 
	{
		super(title, originalLanguage,adaptedLanguage, duration, views);
	}
	
	/**Methods extends of audiovisual class, so no need to enter here*/
}
