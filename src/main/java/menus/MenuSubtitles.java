package menus;
import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Subtitles;

public class MenuSubtitles  {
    //The class makes a high, low, modifications and searches of subtitles in a movie or series

    //This method performs a discharge of subtitles in a series or film
    //This method is passed as a parameter an array of subtitles and their attributes
    //The modified array is returned
    public Subtitles [] addSubtitles(Subtitles [] newSubtitle, String language)
    {
        newSubtitle = Arrays.copyOf(newSubtitle,newSubtitle.length+1);
        newSubtitle[newSubtitle.length-1]= new Subtitles(language);
        return newSubtitle;
    }

    //This method removes subtitles in a series or film according to its attribute
    //This method is passed as a parameter an array of subtitles and their attributes
    //The modified array is returned
    public Subtitles [] removeSubtitles(Subtitles [] remove, String language)
    {
        for (int i = 0 ; i < remove.length ; i++)
        {
            if (language.equalsIgnoreCase((remove[i]).getLanguage()))
            {
                System.out.println("Idioma borrado " + remove[i]);
                System.arraycopy(remove, i+1, remove, i, remove.length-i-1);
                remove = Arrays.copyOf(remove, remove.length-1) ;
            }
        }
        return remove;
    }

    //This method makes a modification of subtitles in a series or film changing its old attribute for a new one
    //This method is passed as a parameter an array of subtitles and their attributes
    //The modified array is returned
    public Subtitles [] modifyLanguage(Subtitles [] modify, String language, String newLanguage)
    {
        for(int i = 0;i<modify.length;i++)
        {
            if(language.equalsIgnoreCase((modify[i]).getLanguage()))
            {
                System.out.println("Descripcion "+ language +" modificados por " + newLanguage);
                (modify[i]).setLanguage(newLanguage);
            }
        }
        return modify;
    }

    //This method performs a search for subtitles in a series or film according to its attribute
    //This method is passed as a parameter an array of subtitles and their attributes
    //In case the user is not found
    public void searchByLanguage(Subtitles[] search, String language)
    {
        boolean found = false;
        for(int i = 0;i<search.length;i++)
        {

            if(language.equalsIgnoreCase((search[i]).getLanguage()))
            {
                System.out.println(search[i]);
                found = true;
            }

        }
        if (found==false)
        {
            System.out.println("Su descripcion " + language + " no existe");
        }
    }
}