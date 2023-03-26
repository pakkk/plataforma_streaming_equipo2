package es.iesjandula.streaming.stats;
import es.iesjandula.streaming.streaming.*;
public class FilmsSerieStats {
	//This class takes care of count how many series or films there are in our system
	
	//This method count and show how many series and films there are in our system
	public void numSeries (Serie array[])
	{
		//This method only need the length of the array of serie
		System.out.println("There are "+ array.length +" series in the system");
	}
	
	//This method show the info of all series in our system
	public void countSeries(Serie array [])
	{
		//This for show the info of all series in our system
		for(Serie serie : array)
		{
			System.out.println(serie);
		}
	}
}
