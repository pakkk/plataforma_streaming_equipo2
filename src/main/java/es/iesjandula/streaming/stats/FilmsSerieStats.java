package es.iesjandula.streaming.stats;

import es.iesjandula.streaming.streaming.*;

/**
 * This class takes care of count how many series or films there are in our system
 * @author Pablo Ruiz
 */
public class FilmsSerieStats
{

	/**
	 * This method count how many series there are in our system
	 * @param array the array of series
	 */
	public void numSeries (Serie[] array)
	{
		//This method only need the length of the array of serie
		System.out.println("There are "+ array.length +" series in the system");
	}
	
	/**This method show the info of all series in our system
	 * 
	 * @param array the array of series
	 */
	public void countSeries(Serie[] array)
	{
		//This for show the info of all series in our system
		for(Serie serie : array)
		{
			System.out.println(serie);
		}
	}
	/**This method count how many films there are in our system
	 * 
	 * @param array the array of film
	 */
	public void numFilms (Film[] array)
	{
		System.out.println("There are "+ array.length +" films in the system");
	}
	/**This method show the info of all films in our system
	 * 
	 * @param array the array of film
	 */
	public void countFilms(Film[] array)
	{
		//This for show the info of all films in our system
		for(Film film : array)
		{
			System.out.println(film);
		}
	}
}
