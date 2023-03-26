package es.iesjandula.streaming.stats;
import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.baseclasses.Directors;
import java.util.Arrays;
/**
 *
 * @author jjurval
 */
public class DirectorStats {
    //This class takes care of count and show how many Directors there are in the films or series
    
    //This method counts how many Directors there are in the series
    public void numActorsSeries(Serie[] seriesDirectors)
    {
        int sum = 0;
        Directors[] arrayDirectors;
        for(int i = 0; i < seriesDirectors.length; i++)
        {
        	arrayDirectors = seriesDirectors[i].getDirectors();
            sum += arrayDirectors.length;
        }
        
        System.out.println("There are "+ sum +" directors in the series.");
    }
    //This method counts how many Directors there are in the films
    public void numActorsFilms(Film[] filmDirectors)
    {
        int sum = 0;
        Directors[] arrayDirectors;
        for(int i = 0; i < filmDirectors.length; i++)
        {
        	arrayDirectors = filmDirectors[i].getDirectors();
            sum += arrayDirectors.length;
        }
        
        System.out.println("There are "+ sum +" actors in the films.");
    }
    //This method counts how many Directors there are in total
    public void allDirectors(Serie[] seriesDirectors, Film[] filmDirectors)
    {
        int sum = 0;
        Directors[] arrayDirectors;
        for(int i = 0; i < filmDirectors.length; i++)
        {
        	arrayDirectors = filmDirectors[i].getDirectors();
            sum += arrayDirectors.length;
        }
        
        for(int i = 0; i < seriesDirectors.length; i++)
        {
        	arrayDirectors = seriesDirectors[i].getDirectors();
            sum += arrayDirectors.length;
        }
        
        System.out.println("There are "+ sum +" directors in our system.");
    }
    //This method shows many the Directors of the series
    public void showDirectorsSeries(Serie[] seriesDirectors)
    {
        Directors[] arrayDirectors;
        for(Serie serie:seriesDirectors)
        {
        	arrayDirectors = serie.getDirectors();
            System.out.println(Arrays.toString(arrayDirectors));
        }
    }
    //This method shows many the Directors of the films
    public void showdirectorsFilms(Film[] filmsDirectors)
    {
        Directors[] arrayDirectors;
        for(Film film:filmsDirectors)
        {
        	arrayDirectors = film.getDirectors();
            System.out.println(Arrays.toString(arrayDirectors));
        }
    }
    //This method shows the series that have 2 or more directors working on them
    public void infoSeriesDirectors(Serie[] seriesDirectors)
    {
        Directors[] arrayDirectors;
        for(Serie serie:seriesDirectors)
        {
        	arrayDirectors = serie.getDirectors();
            if(arrayDirectors.length >= 2)
            {
                System.out.println(serie);
            }
        }
    }
    //This method shows the films that have 2 or more directors working on them
    public void infoFilmsDirectors(Film[] filmsDirectors)
    {
        Directors[] arrayDirectors;
        for(Film film:filmsDirectors)
        {
        	arrayDirectors = film.getDirectors();
            if(arrayDirectors.length >= 2)
            {
                System.out.println(film);
            }
        }
    }
}

