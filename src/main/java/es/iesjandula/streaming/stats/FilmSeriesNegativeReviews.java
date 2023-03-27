/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesjandula.streaming.stats;
import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.baseclasses.Recommendation;
import es.iesjandula.streaming.enums.RatingType;
import java.util.Arrays;
/**
 *
 * @author alexc
 */
public class FilmSeriesNegativeReviews {
    //This method shows the series that have negative reviews
    public void infoSeriesNegativeReviews(Serie[] seriesNegativeReviews)
    {
        Recommendation[] arrayRecommendation;
        RatingType rate; 
        for(int i = 0; i < seriesNegativeReviews.length; i++)
        {
            arrayRecommendation = seriesNegativeReviews[i].getRecommendation();
            for(int j = 0; j < arrayRecommendation.length; j++)
            {
                rate = arrayRecommendation[j].getRating();
                if(rate.equals(RatingType.NEGATIVE))
                {
                    System.out.println(seriesNegativeReviews[i]);
                    break;
                }
            }
        }
    }
    //This method shows the films that have negative reviews
    public void infoFilmsNegativeReviews(Film[] filmsNegativeReviews)
    {
        Recommendation[] arrayRecommendation;
        RatingType rate; 
        for(int i = 0; i < filmsNegativeReviews.length; i++)
        {
            arrayRecommendation = filmsNegativeReviews[i].getRecommendation();
            for(int j = 0; j < arrayRecommendation.length; j++)
            {
                rate = arrayRecommendation[j].getRating();
                if(rate.equals(RatingType.NEGATIVE))
                {
                    System.out.println(filmsNegativeReviews[i]);
                    break;
                }
            }
        }
    }
}
