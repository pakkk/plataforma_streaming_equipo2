package es.iesjandula.streaming.menus;

import java.util.Arrays;
import es.iesjandula.streaming.streaming.Film;
import es.iesjandula.streaming.streaming.Serie;

/**
 * -This class is responsible for high, low, modifications and searches of films or series
 * @author Pablo Elias
 */
public class MenuFilmSeries 
{
	/**This method is responsible for registering a film with the attributes that is passed by param
	 * This method returns the modified array
	 * @param movie the Film array
	 * @param title String title
	 * @param originalLanguage String oiriginal language
	 * @param adaptedLanguage String adapted language
	 * @param duration int with the duration
	 * @param views int with the views
	 * @return Film array (Film[])
	 */
	public Film[] addFilm(Film[] movie,String title,String originalLanguage,String[] adaptedLanguage,int duration, int views)
	{
		movie = Arrays.copyOf(movie, movie.length+1);
		movie[movie.length-1] = new Film (title,originalLanguage,adaptedLanguage,duration,views);
		return movie;
	}
	
	/**This method is responsible for registering a film with the attributes that is passed by param
	 *This method returns the modified array
	 *
	 * @param serie the Serie array
	 * @param title String title
	 * @param originalLanguage String oiriginal language
	 * @param adaptedLanguage String adapted language
	 * @param duration int with the duration
	 * @param views int with the views
	 * @return serie array (Serie[])
	 */
	public Serie[] addSerie(Serie[] serie,String title,String originalLanguage,String[] adaptedLanguage, int duration, int views)
	{
		serie = Arrays.copyOf(serie, serie.length+1);
		serie[serie.length-1] = new Serie (title,originalLanguage,adaptedLanguage,duration,views);
		return serie;
	}
	
	/**This method is responsible for removing a film for its title
	 *This method returns the modified array
	 * 
	 * @param movie Film array
	 * @param title String title
	 * @return Film[] the film array
	 */
	public Film[] removeFilmByTitle(Film[] movie,String title)
	{
		//This for searches for the film by its title and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(title.equalsIgnoreCase((movie[i]).getTitle()))
			{
				System.out.println("Deleted film: "+movie[i]);
				System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
				movie = Arrays.copyOf(movie, movie.length-1) ;
					
			}
		}
		return movie;
	}
	
	/**This method is responsible for removing a film for its original language
	 *This method returns the modified array
	 *
	 * @param movie the Film array
	 * @param originalLanguage String original language
	 * @return Film[] film array
	 */
	public Film[] removeFilmByOriginalLanguage(Film[] movie,String originalLanguage)
	{
		//This for searches the film for its original language and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase((movie[i]).getOriginalLanguage()))
			{
				System.out.println("Deleted film: "+movie[i]);
				System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
				movie = Arrays.copyOf(movie, movie.length-1);
					
			}
		}
		return movie;
	}
	
	/**This method is responsible for removing a film for its adapted language
	 *This method returns the modified array
	 * 
	 * @param movie the film array
	 * @param adaptedLanguage array of strings with adapted language
	 * @return Film[] the film array
	 */
	public Film[] removeFilmByAdaptedLanguage(Film[] movie,String[] adaptedLanguage)
	{
		//This for searches for the film by its adapted language and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(adaptedLanguage.equals(movie[i].getAdaptedLanguages()))
			{
				System.out.println("Deleted film: "+movie[i]);
				System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
				movie = Arrays.copyOf(movie, movie.length-1);
			}
		}
		return movie;
	}
	
	/**This method is responsible for removing a film for its duration
	 *This method returns the modified array
	 *
	 * @param movie the film array
	 * @param duration the int duration
	 * @return film array Film[]
	 */
	public Film[] removeFilmByDuration(Film[] movie,int duration)
	{
		//This for looks for the film for its duration and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(duration==(movie[i]).getDuration())
			{
				System.out.println("Deleted film: "+movie[i]);
                System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
                movie = Arrays.copyOf(movie, movie.length-1) ;
					
			}
		}
		return movie;
	}
	
	/**This method is responsible for removing a film for the times it has been seen
	 *This method returns the modified array
	 *
	 * @param movie the film array
	 * @param views the int with the view
	 * @return film array Film[]
	 */
	public Film[] removeFilmByViews(Film[] movie,int views)
	{
		//This for looks for the film by the times it has been seen and deletes it from the array
		for(int i = 0;i<movie.length;i++)
		{
			if(views==(movie[i]).getViews())
			{
				System.out.println("Deleted film: "+movie[i]);
                System.arraycopy(movie, i+1, movie, i, movie.length-i-1);
                movie = Arrays.copyOf(movie, movie.length-1) ;
					
			}
		}
		return movie;
	}
	
	/**This method is responsible of removing a serie by his title
	 *This method returns the modified array.
	 *
	 * @param other the Serie array
	 * @param title the String title
	 * @return serie array Serie[]
	 */
	public Serie[] seriesDropByTitle(Serie[] other,String title)
	{
		//This for finds the series by its title and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(title.equalsIgnoreCase((other[i]).getTitle()))
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	
	/**This method is responsible of removing a serie by his original language .
	 *This method returns the modified array.
	 *
	 * @param other the Serie array
	 * @param originalLanguage String with original language
	 * @return Serie array Serie[]
	 */
	public Serie[] seriesDropByOriginalLanguage(Serie[] other,String originalLanguage)
	{
		//This for searches the series by its original language and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage()))
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	
	/**This method is responsible of delete a serie an array by its adapted language.
	 *This method returns the modified array
	 * 
	 * @param other the Serie array
	 * @param adaptedLanguage String array with adapted lanugages
	 * @return serie array Serie[]
	 */
	public Serie[] seriesDropByAdaptedLanguage(Serie[] other,String[] adaptedLanguage)
	{
		//This for searches the series by its adapted language
		for(int i = 0;i<other.length;i++)
		{
			System.out.println("Series to delete "+other[i]);
			System.arraycopy(other, i+1, other, i, other.length-i-1);
			other = Arrays.copyOf(other, other.length-1);
		}
		return other;
	}
	
	/**This method is in charge of delete a serie for its duration.
	 *This method returns the modified array
	 *
	 * @param other the Serie array
	 * @param duration the int duration
	 * @return serie array Serie[]
	 */
	public Serie[] seriesDownDuration(Serie[] other,int duration)
	{
		//This for finds the series by its duration and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(duration==(other[i]).getDuration())
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	
	/**This method is responsible for  delete a serie  by its title.
	 *This method returns the modified array
	 *
	 * @param other Serie array
	 * @param timesViewed int times Viwed
	 * @return serie array Serie[]
	 */
	public Serie[] seriesDownViewTimesView(Serie[] other,int timesViewed)
	{
		//This for finds the series by its title and deletes it from the array
		for(int i = 0;i<other.length;i++)
		{
			if(timesViewed==(other[i]).getViews())
			{
				System.out.println("Series to delete "+other[i]);
				System.arraycopy(other, i+1, other, i, other.length-i-1);
				other = Arrays.copyOf(other, other.length-1);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying the title attribute of a movie by another one.
	 *This method returns the modified array. 
	 *
	 * @param other the Film array
	 * @param title the string title
	 * @param otherTitle the other title
	 * @return film array Film[]
	 */
	public Film[] movieModificationForTitle(Film[] other,String title,String otherTitle)
	{
		//This for looks for the title attribute of a movie and modifies it by the other one
		for(int i = 0;i<other.length;i++)
		{
			if(title.equalsIgnoreCase(other[i].getTitle()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setTitle(otherTitle);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying an original language attribute of a movie by another one other
	 *This method returns the modified array 
	 *
	 * @param other the Film array
	 * @param originalLanguage string original Language
	 * @param otherOriginalLanguage the other original language
	 * @return film array Film[]
	 */
	public Film[] movieModificationForOriginalLanguage(Film[] other,String originalLanguage,String otherOriginalLanguage)
	{
		//This for looks for the original language attribute of a movie and modifies it by the other one.
		for(int i = 0;i<other.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setOriginalLanguage(originalLanguage);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying an adapted language attribute of a movie by another one other
	 *This method returns the modified array
	 *
	 * @param other
	 * @param adaptedLanguage
	 * @param otherAdaptedLanguage
	 * @return film array Film[]
	 */
	public Film[] movieModificationByAdaptedLanguage(Film[] other,String[] adaptedLanguage,String[] otherAdaptedLanguage)
	{
		//This for looks for the original language attribute of a movie and modifies it by the other one.
		for(int i = 0;i<other.length;i++)
		{
			if(adaptedLanguage.equals(other[i].getAdaptedLanguages()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setAdaptedLanguages(otherAdaptedLanguage);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying a movie's duration attribute by another other
	 *This method returns the modified array
	 *
	 * @param other the Film array
	 * @param duration the int duration
	 * @param otherDuration the int other duration
	 * @return film array Film[]
	 */
	public Film[] movieModificationForDuration(Film[] other,int duration,int otherDuration)
	{
		//This for finds the duration attribute of a movie and modifies it by the other one
		for(int i = 0;i<other.length;i++)
		{
			if(duration==(other[i].getDuration()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setDuration(otherDuration);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying an attribute of a movie for another one.
	 *This method returns the modified array. 
	 *
	 * @param other the Film array
	 * @param timesViewed the int times viewed
	 * @param otherTimesViewed the int with other times viwed
	 * @return film array Film[]
	 */
	public Film[] filmModificationTimesViewed(Film[] other,int timesViewed,int otherTimesViewed)
	{
		//This for finds the times viewed attribute of a film and modifies it by other
		for(int i = 0;i<other.length;i++)
		{
			if(timesViewed==(other[i].getViews()))
			{
				System.out.println("Movie to modify "+other[i]);
				other[i].setViews(otherTimesViewed);
				System.out.println("Movie modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying a title attribute of a series by another other.
	 *This method returns the modified array
	 * 
	 * @param other the Serie array
	 * @param title the string title
	 * @param otherTitle the other string title
	 * @return serie array Serie[]
	 */
	public Serie[] seriesModificationForTitle(Serie[] other,String title,String otherTitle)
	{
		//This for looks for the attribute title of a series and modifies it by other 
		for(int i = 0;i<other.length;i++)
		{
			if(title.equalsIgnoreCase(other[i].getTitle()))
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setTitle(otherTitle);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is responsible for modifying an original language attribute of a series by another other.
	 *This method returns the modified array
	 *
	 * @param other the Serie array
	 * @param originalLanguage string original language
	 * @param otherOriginalLanguage the other string original language
	 * @return serie array Serie[]
	 */
	public Serie[] seriesModificationByOriginalLanguage(Serie[] other,String originalLanguage,String otherOriginalLanguage)
	{
		//This for looks for the original language attribute of a series and modifies it by the other one. 
		for(int i = 0;i<other.length;i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage()))
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setOriginalLanguage(otherOriginalLanguage);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying an adapted language attribute of a series by another one other
	 *This method returns the modified array 
	 *
	 * @param other the serie array
	 * @param adaptedLanguage the adapted languages array
	 * @param otherAdaptedLanguage other adapted languages array
	 * @return serie array Serie[]
	 */
	public Serie[] seriesModificationByAdaptedLanguage(Serie[] other,String[] adaptedLanguage,String[] otherAdaptedLanguage)
	{
		//This for looks for the adapted language attribute of a series and modifies it by other
		for(int i=0;i<other.length;i++)
		{
			if(adaptedLanguage.equals(other[i].getAdaptedLanguages()))
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setAdaptedLanguages(otherAdaptedLanguage);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying a duration attribute of an array by another one.
	 *This method returns the modified array.
	 *
	 * @param other the Serie array
	 * @param duration the int duration
	 * @param newDuration the other int duration
	 * @return serie array Serie[]
	 */
	public Serie[] seriesModificationForDuration(Serie[] other,int duration,int newDuration)
	{
		//This for finds the duration attribute of a series and modifies it by the other one 
		for(int i = 0;i<other.length;i++)
		{
			if(duration==other[i].getDuration())
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setDuration(newDuration);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	
	/**This method is in charge of modifying an attribute of a series by another one other
	 *This method returns the modified array
	 *
	 * @param other the Serie array
	 * @param timesViewed the int times viwed
	 * @param otherViewedTimes the other int times viwed
	 * @return serie array Serie[]
	 */
	public Serie[] seriesModificationForViewedTimes(Serie[] other,int timesViewed,int otherViewedTimes)
	{
		//This for looks for the times viewed attribute of a series and modifies it by other 
		for(int i = 0;i<other.length;i++)
		{
			if(timesViewed==other[i].getViews())
			{
				System.out.println("Series to modify "+other[i]);
				other[i].setViews(otherViewedTimes);
				System.out.println("Series modified "+other[i]);
			}
		}
		return other;
	}
	
	/**
	 * This method is responsible for searching for Films by their title and displaying them
	 * 
	 * @param other the Film array
	 * @param title the string title
	 */
	public void filmsSearchByTitle(Film[] other, String title) 
	{
	/** This for loop iterates over the array and displays the Films that contain the
	 * entered title. If it is not found, the user will be notified.
	 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(title.equalsIgnoreCase(other[i].getTitle())) 
			{
			System.out.println("Film found " + other[i]);
			found = true;
			}
		}
		if(!found)
		{
			System.out.println("The title " + title + " is not found in any Film");
		}
	}

	/**
	 * This method is responsible for searching for Films by their original language and displaying them
	 * @param other the Film array
	 * @param originalLanguage the orignal language string
	 */
	public void filmsSearchByOriginalLanguage(Film[] other, String originalLanguage) 
	{
		/**This for loop iterates over the array and displays the Films that contain the 
		 * entered original language. If it is not found, the user will be notified.
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++)
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage())) 
			{
				System.out.println("Film found " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The original language " + originalLanguage + " is not found in any Film");
		}
	}

	/**
	 * This method is responsible for searching for Films by their adapted language and displaying them
	 * @param other the Film array
	 * @param adaptedLanguage the string array with adapted languages
	 */
	public void filmsSearchByAdaptedLanguage(Film[] other, String[] adaptedLanguage) 
	{
		/** This for loop iterates over the array and displays the Films that contain the 
		 * entered adapted language. If it is not found, the user will be notified.
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(Arrays.equals(adaptedLanguage, other[i].getAdaptedLanguages())) 
			{
				System.out.println("Film found " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The adapted language " + Arrays.toString(adaptedLanguage) + " is not found in any Film");
		}
	}

	/**
	 * This method is responsible for searching for Films by their duration and displaying them
	 * @param other the Film array
	 * @param duration the int duration
	 */
	public void filmsSearchByDuration(Film[] other, int duration) 
	{
		/** This for loop iterates over the array and displays the Films that contain the 
		 * entered duration. If it is not found, the user will be notified.
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(duration == other[i].getDuration()) 
			{
				System.out.println("Film found " + other[i]);
				found = true;
			}
		}
		if(!found)	
		{
			System.out.println("The duration " + duration + " is not found in any Film");
		}
	}

	/**
	 * This method is responsible for searching for Films that contain a number of views and displaying them
	 * @param other the Film array
	 * @param views the int views
	 */
	public void filmsSearchByViews(Film[] other, int views) 
	{
		/**This for loop iterates over the array and displays the Films that contain the 
		 * entered number of views. If it is not found, the user will be notified.
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(views == other[i].getViews()) 
			{
				System.out.println("Film found " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The views " + views + " is not found in any Film");
		}
	}
		
	/**
	 * This method is responsible of search a serie by his title
	 * @param other the Serie array
	 * @param title the string title
	 */
	public void searchSeriesByTitle(Serie[] other, String title) 
	{
		/**This for loop iterates through the array and displays the series that contain the entered title
		 * If not found, the user will be notified
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(title.equalsIgnoreCase(other[i].getTitle())) 
			{
				System.out.println("Series found: " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The series with title " + title + " was not found.");
		}
	}

	/**
	 * This method takes care of searching for series that contain an original language and displays them
	 * @param other the Serie array
	 * @param originalLanguage the original language string
	 */
	public void searchSeriesByOriginalLanguage(Serie[] other, String originalLanguage) {
		/** This for loop iterates through the array and displays the series that contain the entered original language
		 * If not found, the user will be notified
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(originalLanguage.equalsIgnoreCase(other[i].getOriginalLanguage())) 
			{
				System.out.println("Series found: " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The series with original language " + originalLanguage + " was not found.");
		}
	}

	/**
	 * This method takes care of searching for series that contain an adapted language and displays them
	 * @param other the Serie array
	 * @param adaptedLanguage the arrat with the string for adapted languages
	 */
	public void searchSeriesByAdaptedLanguage(Serie[] other, String[] adaptedLanguage) 
	{
		//This for loop iterates through the array and displays the series that contain the entered adapted language
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(Arrays.equals(adaptedLanguage, other[i].getAdaptedLanguages())) 
			{
				System.out.println("Series found: " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The series with adapted language " + Arrays.toString(adaptedLanguage) + " was not found.");
		}
	}

	/**
	 * This method takes care of searching for series that contain a duration and displays them
	 * @param other the Serie array
	 * @param duration the duration int
	 */
	public void searchSeriesByDuration(Serie[] other, int duration) 
	{
		// This for loop iterates through the array and displays the series that contain the entered duration
		// If not found, the user will be notified
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(duration == other[i].getDuration()) 
			{
				System.out.println("Series found: " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The series with duration " + duration + " was not found.");
		}
	}

	/**
	 * This method takes care of searching for series that contain a number of views and displays them
	 * @param other the Serie array
	 * @param views the int with the views
	 */
	public void searchSeriesByViews(Serie[] other, int views) 
	{
		/**This for loop iterates through the array and displays the series that contain the entered number of views
		 * If not found, the user will be notified
		 */
		boolean found = false;
		for(int i = 0; i < other.length; i++) 
		{
			if(views == other[i].getViews()) 
			{
				System.out.println("Series found: " + other[i]);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("The series with " + views + " views was not found.");
		}
	}
						
}