package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.streaming.*;
import java.util.Arrays;

/**
 * @author jjurval
 */
public class DirectorStats
{
    /**This class takes care of count and show how many Directors there are in the films or series*/
    
	/**
	* This method counts how many Directors there are in the series
	* @param seriesDirectors An array of objects of type Series that contains information about TV series.
	*/
    public void numDirectorsSeries(Serie[] seriesDirectors)
    {
        int sum = 0;
        for(Serie serie: seriesDirectors)
        {
            sum += serie.getDirectors().length;
        }
        
        System.out.println("There are "+ sum +" directors in the series.");
    }

    /**
    * This method counts how many Directors there are in the films
    * @param filmDirectors An array of objects of type Film that contains information about movies.
    */
    public void numDirectorsFilms(Film[] filmDirectors)
    {
        int sum = 0;
        for(Film film: filmDirectors)
        {
            sum += film.getDirectors().length;
        }
        
        System.out.println("There are "+ sum +" actors in the films.");
    }

    /**
    * This method counts how many Directors there are in total
    * @param seriesDirectors An array of objects of type Series that contains information about TV series.
    * @param filmDirectors An array of objects of type Film that contains information about movies or TV series.
    */
    public void allDirectors(Serie[] seriesDirectors, Film[] filmDirectors)
    {
        int sum = 0;
        for(Film film: filmDirectors)
        {
            sum += film.getDirectors().length;
        }
        
        for(Serie serie: seriesDirectors)
        {
            sum += serie.getDirectors().length;
        }
        
        System.out.println("There are "+ sum +" directors in our system.");
    }

    /**
    * This method shows the Directors of the TV series
    * @param seriesDirectors An array of objects of type Series that contains information about TV series
    */
    public void showDirectorsSeries(Serie[] seriesDirectors)
    {
    	for(Serie serie: seriesDirectors)
        {
            System.out.println(Arrays.toString(serie.getDirectors()));
        }
    }
    
    /**
    * This method shows the Directors of the movies
    * @param filmsDirectors An array of objects of type Film that contains information about movies.
    */
    public void showDirectorsFilms(Film[] filmsDirectors)
    {
    	for(Film film: filmsDirectors)
        {
            System.out.println(Arrays.toString(film.getDirectors()));
        }
    }
    
    /**
    * This method shows the TV series that have 2 or more directors working on them
    * @param seriesDirectors An array of objects of type Series that contains information about TV series.
    */
    public void infoSeriesDirectors(Serie[] seriesDirectors)
    {
    	for(Serie serie: seriesDirectors)
        {
            if(serie.getDirectors().length >= 2)
            {
                System.out.println(serie);
            }
        }
    }
    
    /**
    * This method shows the movies that have 2 or more directors working on them
    * @param filmsDirectors An array of objects of type Film that contains information about movies.
    */
    public void infoFilmsDirectors(Film[] filmsDirectors)
    {
    	for(Film film: filmsDirectors)
        {
            if(film.getDirectors().length >= 2)
            {
                System.out.println(film);
            }
        }
    }
}