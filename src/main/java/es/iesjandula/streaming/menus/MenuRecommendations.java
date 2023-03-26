package es.iesjandula.streaming.menus;

import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Recommendation;
import es.iesjandula.streaming.enums.RatingType;

public class MenuRecommendations {
	// Class that manages the methods for adding, deleting, querying, and searching Recommendations

	public Recommendation[] RecommendationPeliculasAltas(Recommendation array[], RatingType rate, String comment) 
	{
		// This method adds a recommendation for a movie or TV show, passing its attributes as parameters, and returns the modified array
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = new Recommendation(rate, comment);
		return array;
	}

	public Recommendation[] RecommendationDeleteByComment(Recommendation array[], String comment) 
	{
		// This method deletes a recommendation for a movie or TV show by searching for a specific comment and removing that recommendation
		// The method receives the comment that will delete the recommendation as a parameter, as well as the array of recommendations to modify, and returns the modified array
		// This for loop searches the array of recommendations for recommendations that contain the same comment to delete it
		for (int i = 0; i < array.length; i++) 
		{
			if (comment.equalsIgnoreCase(((Recommendation) array[i]).getComment())) 
			{
				System.out.println("Recommendation borrada " + array[i]);
				System.arraycopy(array, i + 1, array, i, array.length - i - 1);
				array = Arrays.copyOf(array, array.length - 1);
			}
		}
		return array;
	}

	public Recommendation[] RecommendationBajasPorrate(Recommendation array[], RatingType rate)
	{
		// This method deletes a recommendation for a movie or TV show by searching for a specific rating and removing that recommendation
		// The method receives the rating that will delete the recommendation as a parameter, as well as the array of recommendations to modify, and returns the modified array
		// This for loop searches the array of recommendations for recommendations that contain the same rating to delete it
		for (int i = 0; i < array.length; i++)
		{
			if (rate.equals(((Recommendation) array[i]).getRating())) 
			{
				System.out.println("Recommendation borrada " + array[i]);
				System.arraycopy(array, i + 1, array, i, array.length - i - 1);
				array = Arrays.copyOf(array, array.length - 1);
			}
		}
		return array;
	}

	public Recommendation[] RecommendationModificacionPorcomment(Recommendation array[], String comment, String arraycomment) 
	{
		//This method modify a comment for a recommendations for a movie or serie by searching for a specific rating and removing that recommendation
		//This loop iterates through the recommendations array and searches for recommendations that contain the old comment to replace it with the new one.
		for (int i = 0; i < array.length; i++) 
		{
			if (comment.equalsIgnoreCase(((Recommendation) array[i]).getComment())) 
			{
				System.out.println("Attribute to modify: " + array[i]);
				((Recommendation) array[i]).setComment(arraycomment);
				System.out.println("Attribute modified: " + array[i]);
			}
		}
		return array;
	}

	//This method is responsible for modifying the "rate" attribute to a new one. It takes as parameters the recommendations array, the old rating, and the new rating to replace it.
	//It returns the modified array.
	public Recommendation[] RecommendationesModificacionPorrate(Recommendation array[], RatingType rate, RatingType nuevarate) 
	{
		//This loop iterates through the recommendations array and searches for recommendations that contain the old rating to replace it with the new one.
		for (int i = 0; i < array.length; i++) 
		{
			if (rate.equals(((Recommendation) array[i]).getRating())) 
			{
				System.out.println("Attribute to modify: " + array[i]);
				((Recommendation) array[i]).setRating(nuevarate);
				System.out.println("Attribute modified: " + array[i]);
			}
		}
		return array;
	}

	//This method is responsible for searching for recommendations by their comments. It takes as parameters the recommendations array and the comment to search for.
	public void RecommendationesBusquedaPorcomment(Recommendation array[], String comment)
	{
		//This loop iterates through the recommendations array and searches for recommendations that contain the comment to search for. If it is not found, the user will be notified.
		boolean encontrado = false;
		for (int i = 0; i < array.length; i++)
		{
			if (comment.equalsIgnoreCase(((Recommendation) array[i]).getComment())) 
			{
				System.out.println("Recommendation found: " + array[i]);
				encontrado = true;
			}
			if (encontrado == true)
				System.out.println("The comment " + comment + " could not be found.");
		}
	}

	//This method is responsible for searching for recommendations by their rating. It takes as parameters the recommendations array and the rating to search for.
	public void RecommendationesBusquedaPorrate(Recommendation array[], RatingType rate) 
	{
		//This loop iterates through the recommendations array and searches for recommendations that contain the rating to search for. If it is not found, the user will be notified.
		boolean encontrado = false;
		for (int i = 0; i < array.length; i++)
		{
			if (rate.equals(array[i].getRating()))
			{
				System.out.println("Recommendation found " + array[i]);
				encontrado = true;
			}
			if (encontrado == true)
				System.out.println("The rating " + rate + " could not be found.");
		}
		
	}
}