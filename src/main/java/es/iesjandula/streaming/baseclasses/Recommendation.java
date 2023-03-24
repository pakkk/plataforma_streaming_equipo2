package es.iesjandula.streaming.baseclasses;
import enums.TipoValoracion;

public class Recommendation {
    // This class is responsible for loading recommendation data and storing it in an array
    // Attributes
    // Attribute TipoValoracion valoracion: An enum attribute that defines the type of recommendation (Positive and negative)
    // Attribute String comment: An attribute that defines the recommendation comment, if not entered by default it is without comment
    private TipoValoracion rating;
    private String comment;
    // Constructor
    // Constructor that determines the values of rating and comment
    public Recommendation(TipoValoracion rating, String comment) 
    {
        this.rating = rating;
        this.comment = comment;
        attributeCorrection();
    }
    // Getters and Setters
    // Getter for rating that returns its value
    public TipoValoracion getRating() 
    {
        return this.rating;
    }
    // Setter for rating that allows modifying its value
    public void setRating(TipoValoracion rating) 
    {
        this.rating = rating;
    }
    // Getter for comment that returns its value
    public String getComment()
    {
        return this.comment;
    }
    // Setter for comment that allows modifying its value
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    // Private method to set the default value of the comment attribute
    private void attributeCorrection() 
    {
        if (this.comment.isEmpty())
            this.comment = "Without comment";
    }
    // toString that displays the values of rating and comment
    @Override
    public String toString() 
    {
        return "Rating " + this.rating + " comment " + this.comment ;
    }
}