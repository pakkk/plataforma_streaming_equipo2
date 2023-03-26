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
    public void infoSeriesActors(Serie[] seriesActors)
    {
        Recommendation[] arrayRecommendation;
        RatingType rate; 
        for(int i = 0; i < seriesActors.length; i++)
        {
            arrayRecommendation = seriesActors[i].getRecommendation();
            for(int j = 0; j < arrayRecommendation.length; j++)
            {
                rate = arrayRecommendation[j].getRating();
                if(rate.equals(RatingType.NEGATIVE))
                {
                    System.out.println(seriesActors[i]);
                    break;
                }
            }
        }
    }
    //This method shows the films that have negative reviews
    public void infoFilmsActors(Film[] filmsActors)
    {
        Recommendation[] arrayRecommendation;
        RatingType rate; 
        for(int i = 0; i < filmsActors.length; i++)
        {
            arrayRecommendation = filmsActors[i].getRecommendation();
            for(int j = 0; j < arrayRecommendation.length; j++)
            {
                rate = arrayRecommendation[j].getRating();
                if(rate.equals(RatingType.NEGATIVE))
                {
                    System.out.println(filmsActors[i]);
                    break;
                }
            }
        }
    }
}
