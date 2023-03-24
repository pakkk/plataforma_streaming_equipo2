package menus;
import java.util.Arrays;
import streaming.Serie;
import streaming.Film;
public class MenuFilmSeries {
	//This class is responsible for high, low, modifications and searches of films or series
	
	//This method is responsible for registering a film with the attributes that is passed by parametro
	//This method returns the modified array
	public Film [] addFilm(Film movie[],String title,String originalLanguage,String adaptedLanguage[],int duration, int views)
	{
		movie = Arrays.copyOf(movie, movie.length+1);
		movie[movie.length-1] = new Film (title,originalLanguage,adaptedLanguage,duration,views);
		return movie;
	}
	
	//This method is responsible for registering a film with the attributes that is passed by parametro
	//This method returns the modified array
	public Serie [] addSerie(Serie serie[],String title,String originalLanguage,String adaptedLanguage[], int duration, int views)
	{
		serie = Arrays.copyOf(serie, serie.length+1);
		serie[serie.length-1] = new Serie (title,originalLanguage,adaptedLanguage,duration,views);
		return serie;
	}
	//This method is responsible for removing a film for its title
	//This method returns the modified array
	public Film [] removeFilmByTitle(Film movie[],String title)
	{
		//This for searches for the film by its title and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(title.equalsIgnoreCase((movie[i]).getTitle()))
			{
				System.out.println("Deleted film: "+movie[i]);
				System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
				movie = Arrays.copyOf(movie, movie.length-1) ;
					
			}
		}
		return movie;
	}
	//This method is responsible for removing a film for its original language
	//This method returns the modified array
	public Film [] removeFilmByOriginalLanguage(Film movie[],String originalLanguage)
	{
		//This for searches the film for its original language and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase((movie[i]).getOriginalLanguage()))
			{
				System.out.println("Deleted film: "+movie[i]);
				System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
				movie = Arrays.copyOf(movie, movie.length-1);
					
			}
		}
		return movie;
	}
	//This method is responsible for removing a film for its adapted language
	//This method returns the modified array
	public Film [] removeFilmByAdaptedLanguage(Film movie [],String adaptedLanguage [])
	{
		//This for searches for the film by its adapted language and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(adaptedLanguage.equals(movie[i].getAdaptedLanguages()))
			{
				System.out.println("Deleted film: "+movie[i]);
				System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
				movie = Arrays.copyOf(movie, movie.length-1);
			}
		}
		return movie;
	}
	//This method is responsible for removing a film for its duration
	//This method returns the modified array
	public Film [] removeFilmByDuration(Film movie[],int duration)
	{
		//This for looks for the film for its duration and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(duration==(movie[i]).getDuration())
			{
				System.out.println("Deleted film: "+movie[i]);
                                System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
                                movie = Arrays.copyOf(movie, movie.length-1) ;
					
			}
		}
		return movie;
	}
	//This method is responsible for removing a film for the times it has been seen
	//This method returns the modified array
	public Film [] removeFilmByViews(Film movie[],int views)
	{
		//This for looks for the film by the times it has been seen and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(views==(movie[i]).getViews())
			{
				System.out.println("Deleted film: "+movie[i]);
                                System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
                                movie = Arrays.copyOf(movie, movie.length-1) ;
					
			}
		}
		return movie;
	}
	//This method is in charge of deregistering a series by its title.
	//This method returns the modified array.
	public Serie [] SeriesDropByTitle(Serie other[],String title)
	{
		//This for finds the series by its title and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(title.equalsIgnoreCase((other[i]).getTitle()))
			{
				System.out.println("Series to delete "+other[i]);
					System.arraycopy(other, i+1, other, i, other.length-i-1);
					other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	//This method is responsible for deregistering an array by its original language.
	//This method returns the modified array.
	public Serie [] SeriesDropByOriginalLanguage(Serie other[],String originalLanguage)
	{
		//This for searches the series by its original language and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage()))
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	//This method is responsible for deregistering an array by its adapted language.
	//This method returns the modified array
	public Serie[] SeriesDropByAdaptedLanguage(Serie other[],String adaptedLanguage[])
	{
		//This for searches the series by its adapted language
		for(int i = 0;i<other.length;i++)
		{
			System.out.println("Series to delete "+other[i]);
			System.arraycopy(other, i+1, other, i, other.length-i-1);
			other = Arrays.copyOf(other, other.length-1);
		}
		return other;
	}
	//This method is in charge of deregistering a series for its duration.
	//This method returns the modified array
	public Serie [] SeriesDownDuration(Serie other[],int duration)
	{
		//This for finds the series by its duration and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(duration==(other[i]).getDuration())
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	//This method is responsible for deregistering an array by its title.
	//This method returns the modified array
	public Serie [] SeriesDownViewTimesView(Serie other[],int timesViewed)
	{
		//This for finds the series by its title and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(timesViewed==(other[i]).getViews())
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	//This method is in charge of modifying the title attribute of a movie by another one.
	//This method returns the modified array. 
	public Film [] MovieModificationForTitle(Film other[],String title,String otherTitle)
	{
		//This for looks for the title attribute of a movie and modifies it by the other one
		for(int i = 0;i<other.length;i++)
		{
			if(title.equalsIgnoreCase(other[i].getTitle()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setTitle(otherTitle);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying an original language attribute of a movie by another one other
	//This method returns the modified array 
	public Film [] MovieModificationForOriginalLanguage(Film other[],String originalLanguage,String otherOriginalLanguage)
	{
		//This for looks for the original language attribute of a movie and modifies it by the other one.
		for(int i = 0;i<other.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setOriginalLanguage(originalLanguage);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying an adapted language attribute of a movie by another one other
	//This method returns the modified array
	public Film [] MovieModificationByAdaptedLanguage(Film other[],String adaptedLanguage[],String otherAdaptedLanguage[])
	{
		//This for looks for the original language attribute of a movie and modifies it by the other one.
		for(int i = 0;i<other.length;i++)
		{
			if(adaptedLanguage.equals(other[i].getAdaptedLanguages()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setAdaptedLanguages(otherAdaptedLanguage);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying a movie's duration attribute by another other
	//This method returns the modified array 
	public Film [] MovieModificationForDuration(Film other[],int duration,int otherDuration)
	{
		//This for finds the duration attribute of a movie and modifies it by the other one
		for(int i = 0;i<other.length;i++)
		{
			if(duration==(other[i].getDuration()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setDuration(otherDuration);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying an attribute of a movie for another one.
	//This method returns the modified array. 
	public Film [] FilmModificationTimesViewed(Film other[],int timesViewed,int otherTimesViewed)
	{
		//This for finds the times viewed attribute of a film and modifies it by other
		for(int i = 0;i<other.length;i++)
		{
			if(timesViewed==(other[i].getViews()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setViews(otherTimesViewed);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying a title attribute of a series by another other.
	//This method returns the modified array
	public Serie [] SeriesModificationForTitle(Serie other[],String title,String otherTitle)
	{
		//This for looks for the attribute title of a series and modifies it by other 
		for(int i = 0;i<other.length;i++)
		{
			if(title.equalsIgnoreCase(other[i].getTitle()))
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setTitle(otherTitle);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	//This method is responsible for modifying an original language attribute of a series by another other.
	//This method returns the modified array
	public Serie [] SeriesModificationByOriginalLanguage(Serie other[],String originalLanguage,String otherOriginalLanguage)
	{
		//This for looks for the original language attribute of a series and modifies it by the other one. 
		for(int i = 0;i<other.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage()))
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setOriginalLanguage(otherOriginalLanguage);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying an adapted language attribute of a series by another one other
	//This method returns the modified array 
	public Serie[] SeriesModificationByAdaptedLanguage(Serie other[],String adaptedLanguage[],String otherAdaptedLanguage[])
	{
		//This for looks for the adapted language attribute of a series and modifies it by other
		for(int i=0;i<other.length;i++)
		{
			if(adaptedLanguage.equals(other[i].getAdaptedLanguages()))
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setAdaptedLanguages(otherAdaptedLanguage);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	//This method is in charge of modifying a duration attribute of an array by another one.
		//This method returns the modified array.
		public Serie [] SeriesModificationForDuration(Serie other[],int duration,int newDuration)
		{
			//This for finds the duration attribute of a series and modifies it by the other one 
			for(int i = 0;i<other.length;i++)
			{
				if(duration==other[i].getDuration())
				{
					System.out.println("Series to modify "+other[i]);
					other[i].setDuration(newDuration);
					System.out.println("Series modified "+other[i]);
				}
			}
			return other;
		}
		//This method is in charge of modifying an attribute of a series by another one other
		//This method returns the modified array
		public Serie [] SeriesModificationForViewedTimes(Serie other[],int timesViewed,int otherViewedTimes)
		{
			//This for looks for the times viewed attribute of a series and modifies it by other 
			for(int i = 0;i<other.length;i++)
			{
				if(timesViewed==other[i].getViews())
				{
					System.out.println("Series to modify "+other[i]);
					other[i].setViews(otherViewedTimes);
					System.out.println("Series modified "+other[i]);
				}
			}
			return other;
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su titulo y los muestra
	public void PeliculaBusquedaPorTitulo(Pelicula other [],String titulo)
	{
		//Este for recorre el array y muestra las peliculas que conetngan el titulo introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(titulo.equalsIgnoreCase(other[i].getTitulo()))
			{
				System.out.println("Pelicula encontrada "+other[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("El titulo "+titulo+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su idioma original y los muestra
	public void PeliculaBusquedaPorIdiomaOriginal(Pelicula other [],String idiomaOriginal)
	{
		//Este for recorre el array y muestra las peliculas que conetngan el idioma original introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(other[i].getIdiomaOriginal()))
			{
				System.out.println("Pelicula encontrada "+other[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("El idioma original "+idiomaOriginal+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su idioma adaptado y los muestra
	public void PeliculaBusquedaPorIdiomaAdaptado(Pelicula other[],String idiomaAdaptado[])
	{
		//This for takes care of tour the array and show the movies that contain the adapted language introduced 
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(idiomaAdaptado.equals(other[i].getIdiomaAdaptado()))
			{
				System.out.println("Pelicula encontrada "+other[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("El idioma adaptado "+Arrays.toString(idiomaAdaptado)+" no ose encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su duracion y los muestra
	public void PeliculaBusquedaPorDuracion(Pelicula other [],int duracion)
	{
		//Este for recorre el array y muestra las peliculas que conetngan la duracion introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(duracion==other[i].getDuracion())
			{
				System.out.println("Pelicula encontrada "+other[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("La duracion "+duracion+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas que contengan un numero de visitas y los muestra
	public void PeliculaBusquedaPorVecesVisto(Pelicula other [],int vecesVisto)
	{
		//Este for recorre el array y muestra las peliculas que conetngan el numero de visitas introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(vecesVisto==other[i].getVecesVisto())
			{
				System.out.println("Pelicula encontrada "+other[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("Las visitas "+vecesVisto+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las series que contengan un titulo y las muestras
	public void SerieBusquedaPorTitulo(Serie other [],String titulo)
	{
		//Este for recorre el array y muestra las series que contengan el titulo introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(titulo.equalsIgnoreCase(other[i].getTitulo()))
			{
				System.out.println("Serie encontrada "+other[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con titulo "+titulo+" no se ha encontrado");
	}
	//Este metodo se encarga de buscar las series que contengan un idioma original y las muestras
	public void SerieBusquedaPorIdiomaOriginal(Serie other [],String idiomaOriginal)
	{
		//Este for recorre el array y muestra las series que contengan el idioma original introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(other[i].getIdiomaOriginal()))
			{
				System.out.println("Serie encontrada "+other[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con idioma original "+idiomaOriginal+" no se ha encontrado");
	}
	//This method takes care of search the movies that contains the adapted language and show it
	public void SerieBusquedaPorIdiomaAdaptado(Serie other[],String idiomaAdaptado[])
	{
		//This for takes care of tour the array and show the series that contains the adapted language introduced
		boolean encontrado = true;
		for(int i = 0;i<other.length;i++)
		{
			if(idiomaAdaptado.equals(other[i].getIdiomaAdaptado()))
			{
				System.out.println("Serie encontrada "+other[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con el idioma adaptado "+Arrays.toString(idiomaAdaptado)+" no se encuentra");
	}
	//Este metodo se encarga de buscar las series que contengan una duracion y las muestras
	public void SerieBusquedaPorDuracion(Serie other [],int duracion)
	{
		//Este for recorre el array y muestra las series que contengan la duracion introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(duracion==other[i].getDuracion())
			{
				System.out.println("Serie encontrada "+other[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con duracion "+duracion+" no se ha encontrado");
	}
	//Este metodo se encarga de buscar las series que contengan un numero de visitas y las muestras
	public void SerieBusquedaPorVecesVisto(Serie other [],int vecesVisto)
	{
		//Este for recorre el array y muestra las series que contengan un numero de visitas introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<other.length;i++)
		{
			if(vecesVisto==other[i].getVecesVisto())
			{
				System.out.println("Serie encontrada "+other[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con visitas "+vecesVisto+" no se ha encontrado");
		}
						
}