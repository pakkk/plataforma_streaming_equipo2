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
	//Este metodo se encarga de dar de baja a una serie por su titulo
	//Este metodo devuelve el array modificado
	public Serie [] SerieBajaPorTitulo(Serie nuevo[],String titulo)
	{
		//Este for busca a la serie por su titulo y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(titulo.equalsIgnoreCase((nuevo[i]).getTitulo()))
			{
				System.out.println("Serie a borrar "+nuevo[i]);
					System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
					nuevo = Arrays.copyOf(nuevo, nuevo.length-1);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una serie por su idioma original
	//Este metodo devuelve el array modificado
	public Serie [] SerieBajaPorIdiomaOriginal(Serie nuevo[],String idiomaOriginal)
	{
		//Este for busca a la serie por su idioma original y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(nuevo[i].getIdiomaOriginal()))
			{
				System.out.println("Serie a borrar "+nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una serie por su idioma adaptado
	//Este metodo devuelve el array modificado
	public Serie[] SerieBajaPorIdiomaAdaptado(Serie nuevo[],String idiomaAdaptado[])
	{
		//Este for busca a la serie por su idioma adaptado
		for(int i = 0;i<nuevo.length;i++)
		{
			System.out.println("Serie a borrar "+nuevo[i]);
			System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
			nuevo = Arrays.copyOf(nuevo, nuevo.length-1);
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una serie por su duracion
	//Este metodo devuelve el array modificado
	public Serie [] SerieBajaPorDuracion(Serie nuevo[],int duracion)
	{
		//Este for busca a la serie por su duracion y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(duracion==(nuevo[i]).getDuracion())
			{
				System.out.println("Serie a borrar "+nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una serie por su titulo
	//Este metodo devuelve el array modificado
	public Serie [] SerieBajaPorVecesVisto(Serie nuevo[],int vecesVisto)
	{
		//Este for busca a la serie por su titulo y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(vecesVisto==(nuevo[i]).getVecesVisto())
			{
				System.out.println("Serie a borrar "+nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo titulo de una pelicula por otro nuevo
	//Este metodo devuelve el array modificado 
	public Pelicula [] PeliculaModificacionPorTitulo(Pelicula nuevo[],String titulo,String nuevoTitulo)
	{
		//Este for busca el atributo titulo de una pelicula y lo modifica por el nuevo
		for(int i = 0;i<nuevo.length;i++)
		{
			if(titulo.equalsIgnoreCase(nuevo[i].getTitulo()))
			{
				System.out.println("Pelicula a modificar "+nuevo[i]);
				nuevo[i].setTitulo(nuevoTitulo);
				System.out.println("Pelicula modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo idioma original de una pelicula por otro nuevo
	//Este metodo devuelve el array modificado 
	public Pelicula [] PeliculaModificacionPorIdiomaOriginal(Pelicula nuevo[],String idiomaOriginal,String nuevoIdiomaOriginal)
	{
		//Este for busca el atributo idioma original de una pelicula y lo modifica por el nuevo
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(nuevo[i].getIdiomaOriginal()))
			{
				System.out.println("Pelicula a modificar "+nuevo[i]);
				nuevo[i].setIdiomaOriginal(nuevoIdiomaOriginal);
				System.out.println("Pelicula modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo idioma adaptado de una pelicula por otro nuevo
	//Este metodo devuelve  el array modificado
	public Pelicula [] PeliculaModificacionPorIdiomaAdaptado(Pelicula nuevo[],String idiomaAdaptado[],String nuevoIdiomaAdaptado[])
	{
		//Este for busca el atributo idioma original de una pelicula y lo modifica por el nuevo
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaAdaptado.equals(nuevo[i].getIdiomaAdaptado()))
			{
				System.out.println("Pelicula a modificar "+nuevo[i]);
				nuevo[i].setIdiomaAdaptado(nuevoIdiomaAdaptado);
				System.out.println("Pelicula modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo duracion de una pelicula por otro nuevo
	//Este metodo devuelve el array modificado 
	public Pelicula [] PeliculaModificacionPorDuracion(Pelicula nuevo[],int duracion,int nuevaDuracion)
	{
		//Este for busca el atributo duracion de una pelicula y lo modifica por el nuevo
		for(int i = 0;i<nuevo.length;i++)
		{
			if(duracion==(nuevo[i].getDuracion()))
			{
				System.out.println("Pelicula a modificar "+nuevo[i]);
				nuevo[i].setDuracion(nuevaDuracion);
				System.out.println("Pelicula modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo veces visto de una pelicula por otro nuevo
	//Este metodo devuelve el array modificado 
	public Pelicula [] PeliculaModificacionPorVecesVisto(Pelicula nuevo[],int vecesVisto,int nuevoVecesVisto)
	{
		//Este for busca el atributo veces visto de una pelicula y lo modifica por el nuevo
		for(int i = 0;i<nuevo.length;i++)
		{
			if(vecesVisto==(nuevo[i].getVecesVisto()))
			{
				System.out.println("Pelicula a modificar "+nuevo[i]);
				nuevo[i].setVecesVisto(nuevoVecesVisto);
				System.out.println("Pelicula modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo titulo de una serie por otro nuevo
	//Este metodo devuelve el array modificado
	public Serie [] SerieModificacionPorTitulo(Serie nuevo[],String titulo,String nuevoTitulo)
	{
		//Este for busca el atributo titulo de una serie y lo modifica por el nuevo 
		for(int i = 0;i<nuevo.length;i++)
		{
			if(titulo.equalsIgnoreCase(nuevo[i].getTitulo()))
			{
				System.out.println("Serie a modificar "+nuevo[i]);
				nuevo[i].setTitulo(nuevoTitulo);
				System.out.println("Serie modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo idioma original de una serie por otro nuevo
	//Este metodo devuelve el array modificado
	public Serie [] SerieModificacionPorIdiomaOriginal(Serie nuevo[],String idiomaOriginal,String nuevoIdiomaOriginal)
	{
		//Este for busca el atributo idioma original de una serie y lo modifica por el nuevo 
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(nuevo[i].getIdiomaOriginal()))
			{
				System.out.println("Serie a modificar "+nuevo[i]);
				nuevo[i].setIdiomaOriginal(nuevoIdiomaOriginal);
				System.out.println("Serie modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo idioma adaptado de una serie por otro nuevo
	//Este metodo devuelve el array modificado 
	public Serie[] SerieModificacionPorIdiomaAdaptado(Serie nuevo[],String idiomaAdaptado[],String nuevoIdiomaAdaptado[])
	{
		//Este for busca el atributo idioma adaptado de una serie y lo modifica por el nuevo
		for(int i=0;i<nuevo.length;i++)
		{
			if(idiomaAdaptado.equals(nuevo[i].getIdiomaAdaptado()))
			{
				System.out.println("Serie a modificar "+nuevo[i]);
				nuevo[i].setIdiomaAdaptado(nuevoIdiomaAdaptado);
				System.out.println("Serie modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo duracion de una serie por otro nuevo
	//Este metodo devuelve el array modificado
	public Serie [] SerieModificacionPorDuracion(Serie nuevo[],int duracion,int nuevaDuracion)
	{
		//Este for busca el atributo duracion de una serie y lo modifica por el nuevo 
		for(int i = 0;i<nuevo.length;i++)
		{
			if(duracion==nuevo[i].getDuracion())
			{
				System.out.println("Serie a modificar "+nuevo[i]);
				nuevo[i].setDuracion(nuevaDuracion);
				System.out.println("Serie modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de modificar un atributo veces visto de una serie por otro nuevo
	//Este metodo devuelve el array modificado
	public Serie [] SerieModificacionPorVecesVisto(Serie nuevo[],int vecesVisto,int nuevoVecesVisto)
	{
		//Este for busca el atributo veces visto de una serie y lo modifica por el nuevo 
		for(int i = 0;i<nuevo.length;i++)
		{
			if(vecesVisto==nuevo[i].getVecesVisto())
			{
				System.out.println("Serie a modificar "+nuevo[i]);
				nuevo[i].setVecesVisto(nuevoVecesVisto);
				System.out.println("Serie modificada "+nuevo[i]);
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su titulo y los muestra
	public void PeliculaBusquedaPorTitulo(Pelicula nuevo [],String titulo)
	{
		//Este for recorre el array y muestra las peliculas que conetngan el titulo introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(titulo.equalsIgnoreCase(nuevo[i].getTitulo()))
			{
				System.out.println("Pelicula encontrada "+nuevo[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("El titulo "+titulo+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su idioma original y los muestra
	public void PeliculaBusquedaPorIdiomaOriginal(Pelicula nuevo [],String idiomaOriginal)
	{
		//Este for recorre el array y muestra las peliculas que conetngan el idioma original introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(nuevo[i].getIdiomaOriginal()))
			{
				System.out.println("Pelicula encontrada "+nuevo[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("El idioma original "+idiomaOriginal+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su idioma adaptado y los muestra
	public void PeliculaBusquedaPorIdiomaAdaptado(Pelicula nuevo[],String idiomaAdaptado[])
	{
		//This for takes care of tour the array and show the movies that contain the adapted language introduced 
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaAdaptado.equals(nuevo[i].getIdiomaAdaptado()))
			{
				System.out.println("Pelicula encontrada "+nuevo[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("El idioma adaptado "+Arrays.toString(idiomaAdaptado)+" no ose encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas en funcion de su duracion y los muestra
	public void PeliculaBusquedaPorDuracion(Pelicula nuevo [],int duracion)
	{
		//Este for recorre el array y muestra las peliculas que conetngan la duracion introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(duracion==nuevo[i].getDuracion())
			{
				System.out.println("Pelicula encontrada "+nuevo[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("La duracion "+duracion+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las peliculas que contengan un numero de visitas y los muestra
	public void PeliculaBusquedaPorVecesVisto(Pelicula nuevo [],int vecesVisto)
	{
		//Este for recorre el array y muestra las peliculas que conetngan el numero de visitas introducido
		//En caso de que no lo encuentre se avisara al usuario
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(vecesVisto==nuevo[i].getVecesVisto())
			{
				System.out.println("Pelicula encontrada "+nuevo[i]);
				encontrado=true;
			}
		}
		if(encontrado==false)
			System.out.println("Las visitas "+vecesVisto+" no se encuentra en ninguna pelicula");
	}
	//Este metodo se encarga de buscar las series que contengan un titulo y las muestras
	public void SerieBusquedaPorTitulo(Serie nuevo [],String titulo)
	{
		//Este for recorre el array y muestra las series que contengan el titulo introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(titulo.equalsIgnoreCase(nuevo[i].getTitulo()))
			{
				System.out.println("Serie encontrada "+nuevo[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con titulo "+titulo+" no se ha encontrado");
	}
	//Este metodo se encarga de buscar las series que contengan un idioma original y las muestras
	public void SerieBusquedaPorIdiomaOriginal(Serie nuevo [],String idiomaOriginal)
	{
		//Este for recorre el array y muestra las series que contengan el idioma original introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase(nuevo[i].getIdiomaOriginal()))
			{
				System.out.println("Serie encontrada "+nuevo[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con idioma original "+idiomaOriginal+" no se ha encontrado");
	}
	//This method takes care of search the movies that contains the adapted language and show it
	public void SerieBusquedaPorIdiomaAdaptado(Serie nuevo[],String idiomaAdaptado[])
	{
		//This for takes care of tour the array and show the series that contains the adapted language introduced
		boolean encontrado = true;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaAdaptado.equals(nuevo[i].getIdiomaAdaptado()))
			{
				System.out.println("Serie encontrada "+nuevo[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con el idioma adaptado "+Arrays.toString(idiomaAdaptado)+" no se encuentra");
	}
	//Este metodo se encarga de buscar las series que contengan una duracion y las muestras
	public void SerieBusquedaPorDuracion(Serie nuevo [],int duracion)
	{
		//Este for recorre el array y muestra las series que contengan la duracion introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(duracion==nuevo[i].getDuracion())
			{
				System.out.println("Serie encontrada "+nuevo[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con duracion "+duracion+" no se ha encontrado");
	}
	//Este metodo se encarga de buscar las series que contengan un numero de visitas y las muestras
	public void SerieBusquedaPorVecesVisto(Serie nuevo [],int vecesVisto)
	{
		//Este for recorre el array y muestra las series que contengan un numero de visitas introducido
		//En caso de que no lo encuentre se avisara al usuario 
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
			if(vecesVisto==nuevo[i].getVecesVisto())
			{
				System.out.println("Serie encontrada "+nuevo[i]);
				encontrado = true;
			}
		}
		if(encontrado==false)
			System.out.println("La serie con visitas "+vecesVisto+" no se ha encontrado");
		}
						
}