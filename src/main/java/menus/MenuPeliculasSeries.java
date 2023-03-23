package menus;
import java.util.Arrays;
import streaming.Serie;
import streaming.Pelicula;
public class MenuPeliculasSeries {
	//Esta clase se encarga de dar altas, bajas, modificaciones y busquedas de peliculas o series
	
	//Este metodo se encarga de dar de alta una pelicula con los atributos que se le pasa por parametro
	//Este metodo devuelve el array modificado
	public Pelicula [] PeliculaAlta(Pelicula nuevo[],String titulo,String idiomaOriginal, int duracion, int vecesVisto)
	{
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new Pelicula (titulo,idiomaOriginal,duracion,vecesVisto);
		return nuevo;
	}
	
	//Este metodo se encarga de dar de alta una pelicula con los atributos que se le pasa por parametro
	//Este metodo devuelve el array modificado
	public Serie [] SerieAlta(Serie nuevo[],String titulo,String idiomaOriginal, int duracion, int vecesVisto)
	{
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new Serie (titulo,idiomaOriginal,duracion,vecesVisto);
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una pelicula por su titulo
	//Este metodo devuelve el array modificado
	public Pelicula [] PeliculaBajaPorTitulo(Pelicula nuevo[],String titulo)
	{
		//Este for busca a la pelicula por su titulo y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(titulo.equalsIgnoreCase((nuevo[i]).getTitulo()))
			{
				System.out.println("Pelicula a borrar "+nuevo[i]);
					System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
					nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
					
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una pelicula por su idioma original
	//Este metodo devuelve el array modificado
	public Pelicula [] PeliculaBajaPorIdiomaOriginal(Pelicula nuevo[],String idiomaOriginal)
	{
		//Este for busca a la pelicula por su idioma original y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(idiomaOriginal.equalsIgnoreCase((nuevo[i]).getIdiomaOriginal()))
			{
				System.out.println("Pelicula a borrar "+nuevo[i]);
					System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
					nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
					
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una pelicula por su duracion
	//Este metodo devuelve el array modificado
	public Pelicula [] PeliculaBajaPorDuracion(Pelicula nuevo[],int duracion)
	{
		//Este for busca a la pelicula por su duracion y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(duracion==(nuevo[i]).getDuracion())
			{
				System.out.println("Pelicula a borrar "+nuevo[i]);
					System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
					nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
					
			}
		}
		return nuevo;
	}
	//Este metodo se encarga de dar de baja a una pelicula por las veces que se ha visto
	//Este metodo devuelve el array modificado
	public Pelicula [] PeliculaBajaPorVecesVisto(Pelicula nuevo[],int vecesVisto)
	{
		//Este for busca a la pelicula por las veces que se ha visto y la borra del array
		for(int i = 0;i<nuevo.length;i++)
		{
			if(vecesVisto==(nuevo[i]).getVecesVisto())
			{
				System.out.println("Pelicula a borrar "+nuevo[i]);
					System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
					nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
					
			}
		}
		return nuevo;
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
				nuevo[i].setIdiomaOriginal(nuevoIdiomaOriginal);;
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