package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.baseclasses.Recommendation;
import es.iesjandula.streaming.enums.RatingType;

/**
 * This class shows the series and films with bad rating
 * 
 * @author Alejandro Cazalla
 */
public class FilmSeriesNegativeReviews
{

	/**
	 * This method shows the series that have negative reviews
	 * 
	 * @param seriesNegativeReviews an array of Serie objects containing the series to be analyzed for negative reviews
	 */
	public void infoSeriesNegativeReviews(Serie[] seriesNegativeReviews)
	{
		Recommendation[] arrayRecommendation;
		RatingType rate;
		for (int i = 0; i < seriesNegativeReviews.length; i++)
		{
			arrayRecommendation = seriesNegativeReviews[i].getRecommendation();
			for (int j = 0; j < arrayRecommendation.length; j++)
			{
				rate = arrayRecommendation[j].getRating();
				if (rate.equals(RatingType.NEGATIVE))
				{
					System.out.println(seriesNegativeReviews[i]);
					break;
				}
			}
		}
	}

	/**
	 * This method shows the films that have negative reviews
	 * 
	 * @param filmsNegativeReviews an array of Film objects containing the films to be analyzed for negative reviews
	 */
	public void infoFilmsNegativeReviews(Film[] filmsNegativeReviews)
	{
		Recommendation[] arrayRecommendation;
		RatingType rate;
		for (int i = 0; i < filmsNegativeReviews.length; i++)
		{
			arrayRecommendation = filmsNegativeReviews[i].getRecommendation();
			for (int j = 0; j < arrayRecommendation.length; j++)
			{
				rate = arrayRecommendation[j].getRating();
				if (rate.equals(RatingType.NEGATIVE))
				{
					System.out.println(filmsNegativeReviews[i]);
					break;
				}
			}
		}
	}
}