package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.baseclasses.Recommendation;
import es.iesjandula.streaming.enums.RatingType;
import es.iesjandula.streaming.streaming.Film;
import es.iesjandula.streaming.streaming.Serie;

public class FilmSeriesPositiveReviews {
    //This method shows the series that have positive reviews
    public void infoSeriesGoodRecommendation(Serie[] seriesGoodRecommendation)
    {
        Recommendation[] arrayRecommendation;
        RatingType rate;
        for(int i = 0; i < seriesGoodRecommendation.length; i++)
        {
            arrayRecommendation = seriesGoodRecommendation[i].getRecommendation();
            for(int j = 0; j < arrayRecommendation.length; j++)
            {
                rate = arrayRecommendation[j].getRating();
                if(rate.equals(RatingType.POSITIVE))
                {
                    System.out.println(seriesGoodRecommendation[i]);
                    break;
                }
            }
        }
    }
    //This method shows the films that have positive reviews
    public void infoFilmsActors(Film[] filmsGoodRecommendation)
    {
        Recommendation[] arrayRecommendation;
        RatingType rate;
        for(int i = 0; i < filmsGoodRecommendation.length; i++)
        {
            arrayRecommendation = filmsGoodRecommendation[i].getRecommendation();
            for(int j = 0; j < arrayRecommendation.length; j++)
            {
                rate = arrayRecommendation[j].getRating();
                if(rate.equals(RatingType.POSITIVE))
                {
                    System.out.println(filmsGoodRecommendation[i]);
                    break;
                }
            }
        }
    }
}
