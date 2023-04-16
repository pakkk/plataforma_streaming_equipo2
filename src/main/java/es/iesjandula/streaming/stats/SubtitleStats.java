package es.iesjandula.streaming.stats;

import java.util.Arrays; 
import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.baseclasses.Subtitles;

/**
 * This class takes care of show information of the series and film that have several subtitles
 * @author Pablo
 */

public class SubtitleStats 
{
  
    /**
     * This method takes care of show how many subtitles there are in the series
     * @param arraySerie 
     */
	
    public void countSubtitlesSerie (Serie[] arraySerie)
    {
        int sum = 0;
        Subtitles[] subtitle;
        for(int i = 0;i<arraySerie.length;i++)
        {
            subtitle = arraySerie[i].getSubtitles();
            sum+=subtitle.length;
        }
        System.out.println("There are "+sum+" subtitles in the serie");
    }
    
    /**
     * This method takes care of show how many subtitles there are in the films
     * @param arrayFilm array with the films 
     */
    
    public void countSubtitlesFilm (Film[] arrayFilm)
    {
        int sum = 0;
        Subtitles[] subtitle;
        for(int i = 0;i<arrayFilm.length;i++)
        {
            subtitle = arrayFilm[i].getSubtitles();
            sum+=subtitle.length;
        }
        System.out.println("There are "+sum+" subtitles in the film");
    }
    
    /**
     * This method takes care of show how many subtitles there are in our systems
     * @param arraySerie array with the series
     * @param arrayFilm array with the films 
     */
    
    public void countAllSubtitles(Serie[] arraySerie,Film[] arrayFilm)
    {
        int sum = 0;
        Subtitles[] subtitle;
        for(int i = 0;i<arraySerie.length;i++)
        {
            subtitle = arraySerie[i].getSubtitles();
            sum+=subtitle.length;
        }

        for(int i = 0;i<arrayFilm.length;i++)
        {
            subtitle = arrayFilm[i].getSubtitles();
            sum+=subtitle.length;
        }
        System.out.println("There are "+sum+" subtitles in our systems");
    }
     
    /**
     * This method takes care of show how many subtitles there are in the serie
     * @param arraySerie array with the series
     */
    
    public void showSubtitlesSerie(Serie[] arraySerie)
    {
        Subtitles[] subtitle;
        for(Serie serie:arraySerie)
        {
            subtitle = serie.getSubtitles();
            System.out.println(Arrays.toString(subtitle));
        }
    }
 
    /**
     * This method takes care of show how many subtitles there are in the serie
     * @param arrayFilm array with the films 
     */
    
    public void showSubtitlesFilm(Film[] arrayFilm)
    {
	    Subtitles[] subtitle;
	    for(Film film:arrayFilm)
	    {
	        subtitle = film.getSubtitles();
	        System.out.println(Arrays.toString(subtitle));
	    }
    }
    
    /**
     * This method show the films that have 2 or more subtitles
     * @param arrayFilm array with the films
     */
    
    public void infoFilmSubtitles(Film[] arrayFilm)
    {
        Subtitles[] subtitle;
        for(Film film:arrayFilm)
        {
            subtitle = film.getSubtitles();
            if(subtitle.length>=2)
            {
            	System.out.println(film);
            }
        }
    }
    
    /**
     * This method show the films that have 2 or more subtitles
     * @param arraySerie array with the series
     */
    
    public void infoSerieSubtitles(Serie[] arraySerie)
    {
        Subtitles[] subtitle;
        for(Serie serie:arraySerie)
        {
            subtitle = serie.getSubtitles();
            if(subtitle.length>=2)
            {
                    System.out.println(serie);
            }
        }
    }
}
