package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.*;

public class GenderStast{
	//This class takes care of show series and films that have many genders
	
	//This method show the series that have two or more genders
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
	//This method show the films that have two or more genders 
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
