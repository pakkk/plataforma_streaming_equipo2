package streaming;

public class Serie extends Audiovisual{
	//This Class takes care of save data of audiovisual to load the data in one array 
	
	//Constructor
	//This constructor comes from the audiovisual class
	public Serie(String title, String OriginalLanguage,String AdaptedLanguage[], int duration, int views) 
	{
		super(title, OriginalLanguage,AdaptedLanguage, duration, views);
	}
	//Methods extends of audiovisual class, so no need to enter here
	
}
