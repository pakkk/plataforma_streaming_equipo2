package es.iesjandula.streaming.stats;

import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.Film;
import es.iesjandula.streaming.streaming.Serie;

/**
 * @author Javi
 * This class takes care of counting the categories in the system.
 */
public class CategoryStats
{

    /**
     * This method counts how many categories there are in the series.
     * 
     * @param seriesCategory
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
     * @param filmCategory
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
     * @param seriesCategory
     * @param filmCategory
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
     * @param seriesCategory
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
     * @param filmsCategory
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
     * @param seriesCategory
     */
    public void showSeriesWithTwoOrMoreCategories(Serie[] seriesCategory)
    {
        for (Serie serie : seriesCategory)
        {
            Category[] categories = serie.getCategory();
            if (categories.length >= 2)
            {
                System.out.println(serie);
            }
        }
    }

    /**
     * This method shows the films that have 2 or more categories on them.
     * 
     * @param filmsCategory
     */
    public void showFilmsWithTwoOrMoreCategories(Film[] filmsCategory)
    {
        for (Film film : filmsCategory)
        {
            Category[] categories = film.getCategory();
            if (categories.length >= 2)
            {
                System.out.println(film);
            }
        }
    }
}