package menus;

import java.util.Arrays;

import enums.TipoValoracion;
import es.iesjandula.streaming.baseclasses.Recomendacion;

public class MenuRecomendaciones {
	// Class that manages the methods for adding, deleting, querying, and searching Recommendations
	// Attributes
	// Attribute Recomendacion rec[]: used for casting in methods that receive an array of objects
	private Recomendacion rec[] = new Recomendacion[0];

	// Methods
	public Object[] RecomendacionPeliculasAltas(Object nuevo[], TipoValoracion valoracion, String comentarios) {
		// This method adds a recommendation for a movie or TV show, passing its attributes as parameters, and returns the modified array
		nuevo = (Recomendacion[]) rec;
		nuevo = Arrays.copyOf(nuevo, nuevo.length + 1);
		nuevo[nuevo.length - 1] = new Recomendacion(valoracion, comentarios);
		return nuevo;
	}

	public Object[] RecomendacionBajasPorComentarios(Object nuevo[], String comentario) {
		// This method deletes a recommendation for a movie or TV show by searching for a specific comment and removing that recommendation
		// The method receives the comment that will delete the recommendation as a parameter, as well as the array of recommendations to modify, and returns the modified array
		nuevo = (Recomendacion[]) rec;
		// This for loop searches the array of recommendations for recommendations that contain the same comment to delete it
		for (int i = 0; i < nuevo.length; i++) {
			if (comentario.equalsIgnoreCase(((Recomendacion) nuevo[i]).getComentarios())) {
				System.out.println("Recomendacion borrada " + nuevo[i]);
				System.arraycopy(nuevo, i + 1, nuevo, i, nuevo.length - i - 1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length - 1);
			}
		}
		return nuevo;
	}

	public Object[] RecomendacionBajasPorValoracion(Object nuevo[], TipoValoracion valoracion) {
		// This method deletes a recommendation for a movie or TV show by searching for a specific rating and removing that recommendation
		// The method receives the rating that will delete the recommendation as a parameter, as well as the array of recommendations to modify, and returns the modified array
		nuevo = (Recomendacion[]) rec;
		// This for loop searches the array of recommendations for recommendations that contain the same rating to delete it
		for (int i = 0; i < nuevo.length; i++) {
			if (valoracion.equals(((Recomendacion) nuevo[i]).getValoracion())) {
				System.out.println("Recomendacion borrada " + nuevo[i]);
				System.arraycopy(nuevo, i + 1, nuevo, i, nuevo.length - i - 1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length - 1);
			}
		}
		return nuevo;
	}

	public Object[] RecomendacionModificacionPorComentario(Object nuevo[], String comentario, String nuevoComentario) {
		nuevo = (Recomendacion[]) rec;
//This loop iterates through the recommendations array and searches for recommendations that contain the old comment to replace it with the new one.
		for (int i = 0; i < nuevo.length; i++) {
			if (comentario.equalsIgnoreCase(((Recomendacion) nuevo[i]).getComentarios())) {
				System.out.println("Attribute to modify: " + nuevo[i]);
				((Recomendacion) nuevo[i]).setComentarios(nuevoComentario);
				System.out.println("Attribute modified: " + nuevo[i]);
			}
		}
		return nuevo;
	}

	//This method is responsible for modifying the "valoracion" attribute to a new one. It takes as parameters the recommendations array, the old rating, and the new rating to replace it.
//It returns the modified array.
	public Object[] RecomendacionesModificacionPorValoracion(Object nuevo[], TipoValoracion valoracion, TipoValoracion nuevaValoracion) {
		nuevo = (Recomendacion[]) rec;
//This loop iterates through the recommendations array and searches for recommendations that contain the old rating to replace it with the new one.
		for (int i = 0; i < nuevo.length; i++) {
			if (valoracion.equals(((Recomendacion) nuevo[i]).getValoracion())) {
				System.out.println("Attribute to modify: " + nuevo[i]);
				((Recomendacion) nuevo[i]).setValoracion(nuevaValoracion);
				System.out.println("Attribute modified: " + nuevo[i]);
			}
		}
		return nuevo;
	}

	//This method is responsible for searching for recommendations by their comments. It takes as parameters the recommendations array and the comment to search for.
	public void RecomendacionesBusquedaPorComentarios(Object nuevo[], String comentario) {
		nuevo = (Recomendacion[]) rec;
//This loop iterates through the recommendations array and searches for recommendations that contain the comment to search for. If it is not found, the user will be notified.
		boolean encontrado = false;
		for (int i = 0; i < nuevo.length; i++) {
			if (comentario.equalsIgnoreCase(((Recomendacion) nuevo[i]).getComentarios())) {
				System.out.println("Recommendation found: " + nuevo[i]);
				encontrado = true;
			}
			if (encontrado == true)
				System.out.println("The comment " + comentario + " could not be found.");
		}
	}

	//This method is responsible for searching for recommendations by their rating. It takes as parameters the recommendations array and the rating to search for.
	public void RecomendacionesBusquedaPorValoracion(Object nuevo[], TipoValoracion valoracion) {
		nuevo = (Recomendacion[]) rec;
//This loop iterates through the recommendations array and searches for recommendations that contain the rating to search for. If it is not found, the user will be notified.
		boolean encontrado = false;
		for (int i = 0; i < nuevo.length; i++) {
			if (valoracion.equals(((Recomendacion) nuevo[i]).getValoracion())) {
				System.out.println("Recommendation found " + nuevo[i]);
				encontrado = true;
			}
			if (encontrado == true)
				System.out.println("The rating " + valoracion + " could not be found.");
		}
	}
}
