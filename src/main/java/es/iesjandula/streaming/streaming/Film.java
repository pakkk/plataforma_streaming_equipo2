package es.iesjandula.streaming.streaming;

public class Film extends Audiovisual {
    /**Class that stores audiovisual data after loading it into an array*/

    /**
    * Builder
    * This builder comes from the Audiovisual class  
    */
    public Film(String title, String originalLanguage,String adaptedLanguage[], int duration, int views)
    {
        super(title, originalLanguage,adaptedLanguage, duration, views);

    }
    /**The methods are inherited from the Audiovisual class so it is not necessary to introduce them here*/	
}