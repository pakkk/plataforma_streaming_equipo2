package streaming;

public class Pelicula extends Audiovisual {
	//Clase que se encarga de almacenar los datos de audiovisual para despues cargarlo en un array
	
	//Constructor
	//Este constructor proviene de la clase Audiovisual 
	public Pelicula(String titulo, String idiomaOriginal,String idiomaAdaptado[], int duracion, int vecesVisto)
	{
		super(titulo, idiomaOriginal,idiomaAdaptado, duracion, vecesVisto);

	}
	//Los metodos vienen heredados de la clase Audiovisual por lo que no hace falta introducirlos aqui
	
	
}
