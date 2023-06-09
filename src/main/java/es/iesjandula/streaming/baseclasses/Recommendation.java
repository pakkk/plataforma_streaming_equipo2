package es.iesjandula.streaming.baseclasses;

import es.iesjandula.streaming.enums.RatingType;

/**
 * -This class is responsible for loading recommendation data and storing it in an array
 * @author Adrian
 */
public class Recommendation
{

	/**Attribute RatingType rating: An enum attribute that defines the type of recommendation (Positive and negative) */
    private RatingType rating;

    /**Attribute String comment: An attribute that defines the recommendation comment, if not entered by default it is without comment*/
    private String comment;


    /**
     * Constructor that determines the values of rating and comment
     *
     * @param rating the RatingType
     * @param comment the string comment
     */
    public Recommendation(RatingType rating, String comment)
    {
        this.rating = rating;
        this.comment = comment;
        this.attributeCorrection();
    }

    // Getters and Setters

    /**
     *  Getter for rating that returns its value
     * @return returns the getRating
     */
    public RatingType getRating()
    {
        return this.rating;
    }

    /**
     *  Setter for rating that allows modifying its value
     * @param rating the RatingType
     */
    public void setRating(RatingType rating)
    {
        this.rating = rating;
    }

    /**
     *  Getter for comment that returns its value
     * @return returns the comment
     */
    public String getComment()
    {
        return this.comment;
    }

    /** Setter for comment that allows modifying its value
     *
     * @param comment the string with the comment
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     *  Private method to set the default value of the comment attribute
     */
    private void attributeCorrection()
    {
        if (this.comment.isEmpty()) 
        {
			this.comment = "Without comment";
		}
    }

    /**
     * toString that displays the values of rating and comment
     * @return returns String with the information
     */
    @Override
    public String toString()
    {
        return "Rating " + this.rating + " comment " + this.comment ;
    }
}