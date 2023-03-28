package es.iesjandula.streaming.streaming;
import java.util.Arrays;


import es.iesjandula.streaming.baseclasses.*;
import es.iesjandula.streaming.baseclasses.Category;

import es.iesjandula.streaming.baseclasses.Directors;

import es.iesjandula.streaming.baseclasses.Subtitles;

	public class Audiovisual {
		//Parent class of Series and Movie that will contain all the data that will later be transmitted to those classes
	
		//Attributes
		/*
		 * Attribute String title: Defines the title of the audiovisual
		 * Attribute originalLanguage: Defines the original language of the audiovisual
		 * Attribute adaptedLanguages: Defines the adapted languages in which the audiovisual is available
		 * Attribute int duration: Defines how long the audiovisual lasts
		 * Attribute int views: Defines how many times the audiovisual has been watched
		 * Attribute Actors Actors[]: Array that stores objects of Actors
		 * Attribute Directors dir[]: Array that stores objects of directors
		 * Attribute categories category[]: Array that stores objects of categories
		 * Attribute Subtitles subtitles[]: Array that stores objects of Subtitles
		 * Attribute Recommendations rec[]: Array that stores objects of recommendations
		 */
		private String title;
		private String originalLanguage;
		private String adaptedLanguage[];
		private int duration;
		private int views;
		private Actors actors[] = new Actors [0];
		private Directors directors[] = new Directors [0];
		private Category category[] = new Category [0];
		private Subtitles subtitles[] = new Subtitles [0];
		private Recommendation recommendation[] = new Recommendation [0];
		
		//Constructor
		//Constructor that sets the values of the Audiovisual attributes
		public Audiovisual(String title, String originalLanguage, String adaptedLanguages[], int duration, int views) 
		{
			this.title = title;
			this.originalLanguage = originalLanguage;
			this.adaptedLanguage = adaptedLanguages;
			this.duration = duration;
			this.views = views;
			correctAttributes();
		}
		
		//Getters and Setters
		//Getter that returns the value of the audiovisual title
		public String getTitle() 
		{
			return this.title;
		}
		
		//Setter that allows modifying the value of the audiovisual title
		public void setTitle(String title) 
		{
			
			this.title = title;
		}
		
		//Getter that returns the value of the original language of the audiovisual
		public String getOriginalLanguage() 
		{
			return this.originalLanguage;
		}
		
		//Setter that allows modifying the value of the original language of the audiovisual
		public void setOriginalLanguage(String originalLanguage) 
		{
			this.originalLanguage = originalLanguage;
		}
		
		//Getter that returns the adapted languages array of the audiovisual
		public String[] getAdaptedLanguages() 
		{
			return this.adaptedLanguage;
		}
		
		//Setter that allows modifying the adapted languages array of the audiovisual
		public void setAdaptedLanguages(String adaptedLanguages[]) 
		{
			this.adaptedLanguage = adaptedLanguages;
		}
		
		//Getter that returns the value of the duration of the audiovisual
		public int getDuration() 
		{
			return this.duration;
		}
		
		//Setter that allows modifying the value of the duration of the audiovisual
		public void setDuration(int duration) 
		{
			this.duration = duration;
		}
		
		//Getter that returns the number of times the audiovisual has been watched
		public int getViews() 
		{
			return this.views;
		}
		
		//Setter that allows modifying the value of the times the audiovisual has been watched
		public void setViews(int views) 
		{
			this.views = views;
		}
		
		//Getter that returns the array of Actors
		public Actors[] getActors() 
		{
			return this.actors;
		}
		
		//Setter that allows modifying the array of Actors
		public void setActors(Actors Actors[]) 
		{
			this.actors = Actors;
		}
		
		//Getter that returns the array of directors
		public Directors[] getDirectors() 
		{
			return this.directors;
	    }
	    //Setter to modify the array of directors
	    public void setDirectors(Directors directors [])
	    {
	    	this.directors = directors;
	    }
	    //Getter returns the Category array
	    public Category [] getCategory ()
	    {
	    	return this.category;
	    }
	    //Setter to modify the Category array
	    public void setCategory(Category category [])
	    {
	    	this.category = category;
	    }
	    //Getter that returns the array of Subtitles
	    public Subtitles [] getSubtitles ()
	    {
	    	return this.subtitles;
	    }
	    //Setter to modify the subtitles array
	    public void setSubtitles(Subtitles subtitles [])
	    {
	    	this.subtitles = subtitles;
	    }
	    //Getter that returns the recommendation array
	    public Recommendation [] getRecommendation()
	    {
	    	return this.recommendation;
	    }
	    //Setter to modify the recommendation array
	    public void setRecommendation(Recommendation recommendation [])
	    {
	    	this.recommendation = recommendation;
	    }
	    //Default method to set attributes that have been left empty
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
		//To string to show the value of the Class attribute
		@Override
		public String toString()
		{
			return "name "+this.title+" lasts "+this.duration+" minutes "+" its original language is "+this.originalLanguage+ " adapted languages are " + Arrays.toString(this.adaptedLanguage) + " and has been seen " + this.views;
		}
	}