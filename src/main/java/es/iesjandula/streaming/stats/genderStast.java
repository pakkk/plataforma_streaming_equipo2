package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.streaming.*;

public class genderStast{
	
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
