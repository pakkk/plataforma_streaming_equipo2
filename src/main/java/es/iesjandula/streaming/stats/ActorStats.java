/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesjandula.streaming.stats;
import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.baseclasses.Actors;
import java.util.Arrays;
/**
 *
 * @author alexc
 */
public class ActorStats {
    //This class takes care of count and show how many Actors there are in the films or series
    
    //This method counts how many Actors there are in the series
    public void numActorsSeries(Serie[] seriesActors)
    {
        int sum = 0;
        Actors[] arrayActors;
        for(int i = 0; i < seriesActors.length; i++)
        {
            arrayActors = seriesActors[i].getActors();
            sum += arrayActors.length;
        }
        
        System.out.println("There are "+ sum +" actors in the series.");
    }
    //This method counts how many Actors there are in the films
    public void numActorsFilms(Film[] filmActors)
    {
        int sum = 0;
        Actors[] arrayActors;
        for(int i = 0; i < filmActors.length; i++)
        {
            arrayActors = filmActors[i].getActors();
            sum += arrayActors.length;
        }
        
        System.out.println("There are "+ sum +" actors in the films.");
    }
    //This method counts how many Actors there are in total
    public void allActors(Serie[] seriesActors, Film[] filmActors)
    {
        int sum = 0;
        Actors[] arrayActors;
        for(int i = 0; i < filmActors.length; i++)
        {
            arrayActors = filmActors[i].getActors();
            sum += arrayActors.length;
        }
        
        for(int i = 0; i < seriesActors.length; i++)
        {
            arrayActors = seriesActors[i].getActors();
            sum += arrayActors.length;
        }
        
        System.out.println("There are "+ sum +" actors in our system.");
    }
    //This method shows many the Actors of the series
    public void showActorsSeries(Serie[] seriesActors)
    {
        Actors[] arrayActors;
        for(Serie serie:seriesActors)
        {
            arrayActors = serie.getActors();
            System.out.println(Arrays.toString(arrayActors));
        }
    }
    //This method shows many the Actors of the films
    public void showActorsFilms(Film[] filmsActors)
    {
        Actors[] arrayActors;
        for(Film film:filmsActors)
        {
            arrayActors = film.getActors();
            System.out.println(Arrays.toString(arrayActors));
        }
    }
    //This method shows the series that have 2 or more actors working on them
    public void infoSeriesActors(Serie[] seriesActors)
    {
        Actors[] arrayActors;
        for(Serie serie:seriesActors)
        {
            arrayActors = serie.getActors();
            if(arrayActors.length >= 2)
            {
                System.out.println(serie);
            }
        }
    }
    //This method shows the films that have 2 or more actors working on them
    public void infoFilmsActors(Film[] filmsActors)
    {
        Actors[] arrayActors;
        for(Film film:filmsActors)
        {
            arrayActors = film.getActors();
            if(arrayActors.length >= 2)
            {
                System.out.println(film);
            }
        }
    }
}
