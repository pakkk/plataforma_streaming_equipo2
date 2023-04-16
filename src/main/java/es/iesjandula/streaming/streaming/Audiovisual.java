package es.iesjandula.streaming.streaming;

import java.util.Arrays;
import es.iesjandula.streaming.baseclasses.*;
import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.baseclasses.Directors;
import es.iesjandula.streaming.baseclasses.Subtitles;

/**
 * -Parent class of Series and Movie that will contain all the data that will later be transmitted to those classes
 * @author Javier
 */
public class Audiovisual
{
	//Attributes

	/**Attribute String title: Defines the title of the audiovisual*/
	private String title;
	
	/**Attribute originalLanguage: Defines the original language of the audiovisual*/
	private String originalLanguage;
	
	/**Attribute adaptedLanguages: Defines the adapted languages in which the audiovisual is available*/
	private String[] adaptedLanguage;
	
	/**Attribute int duration: Defines how long the audiovisual lasts*/
	private int duration;
	
	/**Attribute int views: Defines how many times the audiovisual has been watched*/
	private int views;
	
	/**Attribute Actors[] actors: Array that stores objects of Actors*/
	private Actors[] actors = new Actors [0];
	
	/**Attribute Directors[] directors: Array that stores objects of directors*/
	private Directors[] directors = new Directors [0];
	
	/**Attribute Categories[] category: Array that stores objects of categories*/
	private Category[] category = new Category [0];
	
	/**Attribute Subtitles[] subtitles: Array that stores objects of Subtitles*/
	private Subtitles[] subtitles = new Subtitles [0];
	
	/**Attribute Recommendations[] recommendation: Array that stores objects of recommendations*/
	private Recommendation[] recommendation = new Recommendation [0];

	/**Constructor that sets the values of the Audiovisual attributes
	 *
	 * @param title the title of the Audiovisual
	 * @param originalLanguage the original language of the Audiovisual
	 * @param adaptedLanguages the adapted languages of the Audiovisual
	 * @param duration the duration of the Audiovisual
	 * @param views the views of the Audiovisual
	 */
	public Audiovisual(String title, String originalLanguage, String[] adaptedLanguages, int duration, int views)
	{
		this.title = title;
		this.originalLanguage = originalLanguage;
		this.adaptedLanguage = adaptedLanguages;
		this.duration = duration;
		this.views = views;
		this.correctAttributes();
	}
		
	//Getters and Setters

	/**
	 * Getter that returns the value of the audiovisual title
	 * @return the title
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * Setter that allows modifying the value of the audiovisual title
	 * @param title the title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Getter that returns the value of the original language of the audiovisual
	 * @return the original language
	 */
	public String getOriginalLanguage()
	{
		return this.originalLanguage;
	}

	/**
	 * Setter that allows modifying the value of the original language of the audiovisual
	 * @param originalLanguage the original language
	 */
	public void setOriginalLanguage(String originalLanguage)
	{
		this.originalLanguage = originalLanguage;
	}

	/**
	 * Getter that returns the adapted languages array of the audiovisual
	 * @return the adapted language
	 */
	public String[] getAdaptedLanguages()
	{
		return this.adaptedLanguage;
	}

	/**
	 * Setter that allows modifying the adapted languages array of the audiovisual
	 * @param adaptedLanguages the adapted language
	 */
	public void setAdaptedLanguages(String[] adaptedLanguages)
	{
		this.adaptedLanguage = adaptedLanguages;
	}

	/**
	 * Getter that returns the value of the duration of the audiovisual
	 * @return the duration
	 */
	public int getDuration()
	{
		return this.duration;
	}

	/**
	 * Setter that allows modifying the value of the duration of the audiovisual
	 * @param duration the duration
	 */
	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	/**
	 * Getter that returns the number of times the audiovisual has been watched
	 * @return the views
	 */
	public int getViews()
	{
		return this.views;
	}

	/**
	 * Setter that allows modifying the value of the times the audiovisual has been watched
	 * @param views the views
	 */
	public void setViews(int views)
	{
		this.views = views;
	}

	/**
	 * Getter that returns the array of Actors
	 * @return the actors
	 */
	public Actors[] getActors()
	{
		return this.actors;
	}

	/**
	 * Setter that allows modifying the array of Actors
	 * @param Actors the actors
	 */
	public void setActors(Actors[] actors)
	{
		this.actors = actors;
	}

	/**
	 * Getter that returns the array of directors
	 * @return the directors
	 */
	public Directors[] getDirectors()
	{
		return this.directors;
	}

	/**
	 * Setter to modify the array of directors
	 * @param directors the directors
	 */
	public void setDirectors(Directors[] directors)
	{
		this.directors = directors;
	}

	/**
	 * Getter returns the Category array
	 * @return the category
	 */
	public Category [] getCategory ()
	{
		return this.category;
	}

	/**
	 * Setter to modify the Category array
	 * @param category the category
	 */
	public void setCategory(Category[] category)
	{
		this.category = category;
	}

	/**
	 * Getter that returns the array of Subtitles
	 * @return the subtitles
	 */
	public Subtitles [] getSubtitles ()
	{
		return this.subtitles;
	}

	/**
	 * Setter to modify the subtitles array
	 * @param subtitles the subtitles
	 */
	public void setSubtitles(Subtitles[] subtitles)
	{
		this.subtitles = subtitles;
	}

	/**
	 * Getter that returns the recommendation array
	 * @return the recommendation
	 */
	public Recommendation [] getRecommendation()
	{
		return this.recommendation;
	}

	/**
	 * Setter to modify the recommendation array
	 * @param recommendation the recommendation
	 */
	public void setRecommendation(Recommendation[] recommendation)
	{
		this.recommendation = recommendation;
	}

	/**Default method to set attributes that have been left empty*/
	private void correctAttributes()
	{
		if(this.title.isEmpty())
		{
			this.title = "Untitled";
		}
		if(this.duration<=0)
		{
			this.duration = 60;
		}
		if(this.originalLanguage.isEmpty())
		{
			this.originalLanguage = "English";
		}
		if(this.views<0)
		{
			this.views = 0;
		}
	}

	/**
	 * To string to show the value of the Class attribute
	 * @return String with the information
	 */
	@Override
	public String toString()
	{
		return "name "+this.title+" lasts "+this.duration+" minutes "+" its original language is "+this.originalLanguage+ " adapted languages are " + Arrays.toString(this.adaptedLanguage) + " and has been seen " + this.views;
	}
}