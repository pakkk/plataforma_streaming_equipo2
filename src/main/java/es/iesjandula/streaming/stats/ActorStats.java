package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.baseclasses.Actors;
import java.util.Arrays;

/**
 * This class takes care of counting and displaying how many Actors there are in the films or series
 * 
 * @author Alejandro
 */
public class ActorStats
{

    /**
     * This method counts how many Actors there are in the series
     * @param seriesActors An array of `Serie` objects representing the series to count the actors
     */
    public void numActorsSeries(Serie[] seriesActors)
    {
        int sum = 0;
        Actors[] arrayActors;
        for (Serie serie : seriesActors)
        {
            arrayActors = serie.getActors();
            sum += arrayActors.length;
        }
        System.out.println("There are " + sum + " actors in the series.");
    }

    /**
     * This method counts how many Actors there are in the films
     * @param filmActors An array of `Film` objects representing the films to count the actors
     */
    public void numActorsFilms(Film[] filmActors)
    {
        int sum = 0;
        Actors[] arrayActors;
        for (Film film : filmActors)
        {
            arrayActors = film.getActors();
            sum += arrayActors.length;
        }
        System.out.println("There are " + sum + " actors in the films.");
    }

    /**
     * This method counts how many Actors there are in total
     * @param seriesActors An array of `Serie` objects representing the series to count the actors
     * @param filmActors An array of `Film` objects representing the films to count the actors
     */
    public void allActors(Serie[] seriesActors, Film[] filmActors)
    {
        int sum = 0;
        Actors[] arrayActors;
        for (Film film : filmActors)
        {
            arrayActors = film.getActors();
            sum += arrayActors.length;
        }
        for (Serie serie : seriesActors)
        {
            arrayActors = serie.getActors();
            sum += arrayActors.length;
        }
        System.out.println("There are " + sum + " actors in our system.");
    }

    /**
     * This method shows many the Actors of the series
     * @param seriesActors An array of Serie objects containing all the series whose actors should be displayed.
     */
    public void showActorsSeries(Serie[] seriesActors)
    {
        Actors[] arrayActors;
        for (Serie serie : seriesActors)
        {
            arrayActors = serie.getActors();
            System.out.println(Arrays.toString(arrayActors));
        }
    }

    /**
     * This method shows many the Actors of the films
     * @param filmsActors An array of Film objects containing all the movies whose actors should be displayed.
     */
    public void showActorsFilms(Film[] filmsActors)
    {
        Actors[] arrayActors;
        for (Film film : filmsActors)
        {
            arrayActors = film.getActors();
            System.out.println(Arrays.toString(arrayActors));
        }
    }

    /**
     * This method shows the series that have 2 or more actors working on them
     * @param seriesActors An array of Serie objects containing all the series that should be analyzed.
     */
    public void infoSeriesActors(Serie[] seriesActors)
    {
        Actors[] arrayActors;
        for (Serie serie : seriesActors)
        {
            arrayActors = serie.getActors();
            if (arrayActors.length >= 2)
            {
                System.out.println(serie);
            }
        }
    }

    /**
     * This method shows the films that have 2 or more actors working on them
     * @param filmsActors An array of Film objects containing all the movies that should be analyzed.
     */
    public void infoFilmsActors(Film[] filmsActors)
    {
        Actors[] arrayActors;
        for(Film film : filmsActors)
        {
            arrayActors = film.getActors();
            if(arrayActors.length >= 2)
            {
                System.out.println(film);
            }
        }
    }
}