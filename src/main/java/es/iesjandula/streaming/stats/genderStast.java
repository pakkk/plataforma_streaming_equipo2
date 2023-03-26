package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.*;

public class genderStast{
	//this class takes care of show series and films that have many genders
	
	//this method show the series that have two or more genders
	public void infoGenderSerie(Serie arraySerie[])
	{
		Category category[];
		for(Serie serie: arraySerie)
		{
			category=serie.getCategory();
			if(category.length>=2)
			{
				System.out.println(serie);
			}
		}
		
	}
	public void infoGenderFilm(Film arrayFilm[])
	{
		Category category[];
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
