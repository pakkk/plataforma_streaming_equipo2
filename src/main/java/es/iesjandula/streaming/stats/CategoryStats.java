package es.iesjandula.streaming.stats;

import java.util.Arrays;


import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.Film;
import es.iesjandula.streaming.streaming.Serie;

public class CategoryStats {
	// This class take care of count of categories there are.
	
	public void numCategorySeries(Serie[] seriesCategory)
    {
        int sum = 0;
        Category[] arrayCategories;
        for(int i = 0; i < seriesCategory.length; i++)
        {
        	arrayCategories = seriesCategory[i].getCategory();
            sum += arrayCategories.length;
        }
        
        System.out.println("There are "+ sum +" categories in the series.");
    }
    //This method counts how many categories there are in the films
    public void numCategoryFilms(Film[] filmCategory)
    {
        int sum = 0;
        Category[] arrayCategories;
        for(int i = 0; i < filmCategory.length; i++)
        {
            arrayCategories = filmCategory[i].getCategory();
            sum += arrayCategories.length;
        }
        
        System.out.println("There are "+ sum +" categories in the films.");
    }
    //This method counts how many categories there are in total
    public void allCategory(Serie[] seriesCategory, Film[] filmCategory)
    {
        int sum = 0;
        Category[] arrayCategory;
        for(int i = 0; i < filmCategory.length; i++)
        {
            arrayCategory = filmCategory[i].getCategory();
            sum += arrayCategory.length;
        }
        
        for(int i = 0; i < seriesCategory.length; i++)
        {
            arrayCategory = seriesCategory[i].getCategory();
            sum += arrayCategory.length;
        }
        
        System.out.println("There are "+ sum +" Category in our system.");
    }
    //This method shows many the Category of the series
    public void showCategorySeries(Serie[] seriesCategory)
    {
        Category[] arrayCategory;
        for(Serie serie:seriesCategory)
        {
            arrayCategory = serie.getCategory();
            System.out.println(Arrays.toString(arrayCategory));
        }
    }
    //This method shows the num of categories of the  films
    public void showCategoryFilms(Film[] filmsCategory)
    {
        Category[] arrayCategory;
        for(Film film:filmsCategory)
        {
            arrayCategory = film.getCategory();
            System.out.println(Arrays.toString(arrayCategory));
        }
    }
    //This method shows the series that have 2 or more Category on them
    public void infoSeriesCategory(Serie[] seriesCategory)
    {
        Category[] arrayCategory;
        for(Serie serie:seriesCategory)
        {
            arrayCategory = serie.getCategory();
            if(arrayCategory.length >= 2)
            {
                System.out.println(serie);
            }
        }
    }
    //This method shows the films that have 2 or more Category on them
    public void infoFilmsCategory(Film[] filmsCategory)
    {
        Category[] arrayCategory;
        for(Film film:filmsCategory)
        {
            arrayCategory = film.getCategory();
            if(arrayCategory.length >= 2)
            {
                System.out.println(film);
            }
        }
    }
}
