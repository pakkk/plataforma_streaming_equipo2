package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.*;

/**
 * This class takes care of show series and films that have many genders
 * @author Eduardo
 */
public class GenderStast
{
	/**
	 * This method show the series that have two or more genders
	 * @param arraySerie the array serie
	 */
	public void infoGenderSerie(Serie[] arraySerie)
	{
		Category[] category;
		for(Serie serie: arraySerie)
		{
			category=serie.getCategory();
			if(category.length>=2)
			{
				System.out.println(serie);
			}
		}
	}
	/**
	 * This method show the films that have two or more genders 
	 * @param arrayFilm the array film
	 */
	public void infoGenderFilm(Film[] arrayFilm)
	{
		Category[] category;
		for(Film film: arrayFilm)
		{
			category=film.getCategory();
			if(category.length>=2)
			{
				System.out.println(film);
			}
		}
	}
}
