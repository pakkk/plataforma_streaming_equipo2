package es.iesjandula.streaming.stats;

import java.util.Arrays;
import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.Film;
import es.iesjandula.streaming.streaming.Serie;

/**
 * This class takes care of counting the categories in the system.
 * 
 * @author Javier
 */
public class CategoryStats
{
	/**Attribute CATEGORIES_COT*/
	private static final int CATEGORIES_COUNT=2;
	
    /**
     * This method counts how many categories there are in the series.
     * 
     * @param seriesCategory an array of Serie objects representing the series in the streaming system.
     */
    public void countSeriesCategories(Serie[] seriesCategory)
    {
        int sum = 0;
        for (Serie serie : seriesCategory)
        {
            Category[] categories = serie.getCategory();
            sum += categories.length;
        }
        System.out.println("There are " + sum + " categories in the series.");
    }

    /**
     * This method counts how many categories there are in the films.
     * 
     * @param filmCategory an array of Film objects representing the films in the streaming system.
     */
    public void countFilmsCategories(Film[] filmCategory)
    {
        int sum = 0;
        for (Film film : filmCategory)
        {
            Category[] categories = film.getCategory();
            sum += categories.length;
        }
        System.out.println("There are " + sum + " categories in the films.");
    }

    /**
     * This method counts how many categories there are in total.
     * 
     * @param seriesCategory an array of Serie objects representing the series in the streaming system.
     * @param filmCategory an array of Film objects representing the films in the streaming system.
     */
    public void countAllCategories(Serie[] seriesCategory, Film[] filmCategory)
    {
        int sum = 0;
        for (Film film : filmCategory)
        {
            Category[] categories = film.getCategory();
            sum += categories.length;
        }
        for (Serie serie : seriesCategory)
        {
            Category[] categories = serie.getCategory();
            sum += categories.length;
        }
        System.out.println("There are " + sum + " categories in our system.");
    }

    /**
     * This method shows the categories of the series.
     * 
     * @param seriesCategory an array of Serie objects representing the series in the streaming system.
     */
    public void showSeriesCategories(Serie[] seriesCategory)
    {
        for (Serie serie : seriesCategory)
        {
            Category[] categories = serie.getCategory();
            System.out.println(Arrays.toString(categories));
        }
    }

    /**
     * This method shows the categories of the films.
     * 
     * @param filmsCategory an array of Film objects representing the films in the streaming system.
     */
    public void showFilmCategories(Film[] filmsCategory)
    {
        for (Film film : filmsCategory)
        {
            Category[] categories = film.getCategory();
            System.out.println(Arrays.toString(categories));
        }
    }

    /**
     * This method shows the series that have 2 or more categories on them.
     * 
     * @param seriesCategory an array of Serie objects representing the series in the streaming system.
     */
    public void showSeriesWithTwoOrMoreCategories(Serie[] seriesCategory)
    {
        for (Serie serie : seriesCategory)
        {
            Category[] categories = serie.getCategory();
            if (categories.length >= CategoryStats.CATEGORIES_COUNT)
            {
                System.out.println(serie);
            }
        }
    }

    /**
     * This method shows the films that have 2 or more categories on them.
     * 
     * @param filmsCategory an array of Film objects representing the films in the streaming system.
     */
    public void showFilmsWithTwoOrMoreCategories(Film[] filmsCategory)
    {
        for (Film film : filmsCategory)
        {
            Category[] categories = film.getCategory();
            if (categories.length >= CategoryStats.CATEGORIES_COUNT)
            {
                System.out.println(film);
            }
        }
    }
}