package es.iesjandula.streaming.launcher;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.iesjandula.streaming.baseclasses.Actors;
import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.baseclasses.Directors;
import es.iesjandula.streaming.baseclasses.Recommendation;
import es.iesjandula.streaming.baseclasses.Subtitles;
import es.iesjandula.streaming.enums.Gender;
import es.iesjandula.streaming.enums.RatingType;
import es.iesjandula.streaming.menus.MenuActors;
import es.iesjandula.streaming.menus.MenuCategories;
import es.iesjandula.streaming.menus.MenuDirectors;
import es.iesjandula.streaming.menus.MenuFilmSeries;
import es.iesjandula.streaming.menus.MenuRecommendations;
import es.iesjandula.streaming.menus.MenuSubtitles;
import es.iesjandula.streaming.stats.ActorStats;
import es.iesjandula.streaming.stats.CategoryStats;
import es.iesjandula.streaming.stats.DirectorStats;
import es.iesjandula.streaming.stats.FilmSeriesNegativeReviews;
import es.iesjandula.streaming.stats.FilmSeriesPositiveReviews;
import es.iesjandula.streaming.stats.FilmsSerieStats;
import es.iesjandula.streaming.stats.GenderStast;
import es.iesjandula.streaming.stats.SubtitleStats;
import es.iesjandula.streaming.streaming.Film;
import es.iesjandula.streaming.streaming.Serie;

/**
 *
 * @author Pablo Elias
 * @author Javier
 * @author Alex
 *
 */
public class Launcher
{
	//This class is responsible of execute the menus and control the logic of the entire project

	/**
	 * NOTE:Class film and serie have arrays of actors,directors,categories,recommendations and subtitles so to save them
	 * the user must use menu methods
	 */

	/** Attribute Scanner scanner: Provide of Class Scanner and his use its only for write by keyboard*/
	private Scanner scanner = new Scanner(System.in);

	/** Attribute Film film[]: Array that save films that the user select*/
	private Film[] film = new Film[0];

	/** Attribute Serie serie[]: Array that save series that the user select*/
	private Serie[] serie = new Serie[0];

	/** Attribute actor*/
	private Actors[] actor;

	/** Attribute director*/
	private Directors[] director;

	/** Attribute category*/
    private Category[] category;

    /** Attribute recomentadion*/
    private Recommendation[] recommendation;

    /** Attribute subtitles*/
    private Subtitles[] subtitles;

	/*Attributes of films and serie*/

    /**Attribute String title: Title of the film or movie that the user choose  */
	private String title;

	/**Attribute String originalLanguage: Language with which the movie or serie it was created */
	private String originalLanguage;

	/**Attribute String adaptedLanguage []: Language with which the movie or serie its translated*/
	private String adaptedLanguage[] = new String [0];

	/**Attribute int duration: Duration of the movie or serie*/
	private int duration;

	/**Attribute int views: Views that the movie or serie have*/
	private int views;

	/**Attribute String newTitle: His use is only to modify the old title*/
	private String newTitle;

	/**Attribute String newOriginalLanguage: His use is only to modify the old originalLanguage*/
	private String newOriginalLanguage;

	/**Attribute String adaptedLanguage[]: His use is only to modify the old adaptedLanguage*/
	private String newAdaptedLanguage[] = new String [0];

	/**Attribute int newDuration: His use is only to modify the old duration*/
	private int newDuration;

	/**Attribute int newViews: His use is only to modify the old views*/
	private int newViews;


	/*Attributes of actors and directors*/

	/**Attribute String name: Name of the actor or director*/
	private String name;

	/**Attribute String lastName: Last name of the actor of director*/
	private String lastName;

	/**Attribute String awards: Awards that the actor or director has been wined*/
	private String awards;

	/**Attribute int age: Age of the actor or director*/
	private String description;

	/**Attribute Gender gender: Represent the gender of the actor of director*/
	private String comment;

	/**Attribute language*/
	private String language;

	/**Attribute age*/
	private int age;

	/**Attribute gender*/
	private Gender gender;

	/**Attribute newName*/
	private String newName;

	/**Attribute newLastName*/
	private String newLastName;

	/**Attribute newAwards*/
	private String newAwards;

	/**Attribute newDescription*/
	private String newDescription;

	/**Attribute newComment*/
	private String newComment;

	/**Attribute newLanguage*/
	private String newLanguage;

	/**Attribute newAge*/
	private int newAge;

	/**Attribute newGender*/
	private Gender newGender;

	/**Attribute rate*/
	private RatingType rate;

	/**Attribute newRate*/
    private RatingType newRate;

	//Menu instances
	//This instance controls the menu of actors
	private MenuActors menuAct = new MenuActors();

	//This instance controls the menu of directors
	private MenuDirectors menuDict = new MenuDirectors();

	//This instance controls the menu of categories
	private MenuCategories menuCat = new MenuCategories();

	//This instance controls the menu of recommendations
	private MenuRecommendations menuRec = new MenuRecommendations();

	//This instance controls the menu of Subtitles
	private MenuSubtitles menuSub = new MenuSubtitles();

	//This instance controls the menu of films and series
	private MenuFilmSeries menuFS = new MenuFilmSeries();

	//This instance controls the stats of series and films
	private FilmsSerieStats statsFS = new FilmsSerieStats ();

	//This instance controls the stats of the good films and series
	private FilmSeriesPositiveReviews goodFS = new FilmSeriesPositiveReviews();

	//This instance controls the stats of the bad films and series
	private FilmSeriesNegativeReviews badFS = new FilmSeriesNegativeReviews();

	//This instance controls the stats of the multi gender films and series
	private GenderStast genderFS = new GenderStast();

	//This instance controls the stats of the actors
	private ActorStats statsActor = new ActorStats();

	//This instance controls the stats of the directors
	private DirectorStats statDirector = new DirectorStats();

	//This instance controls the stats of the categories
	private CategoryStats statsCategory = new CategoryStats();

	//This instance controls the stats of the subtitles
	private SubtitleStats statsSubtitles = new SubtitleStats();

	/**
	 * @param option the option selected
	 */
	private void addNewFilm()
	{
		String option = this.scanner.nextLine();
		//The user must to introduce with the scanner the attributes of the films
		System.out.println("You choose add a new film please introduce his title");
		this.title = this.scanner.nextLine();

		System.out.println("Introduce his original language");
		this.originalLanguage = this.scanner.next();

		System.out.println("Want to introduce adapted language? (yes/no)");
		option = this.scanner.next();

		while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
		{
			System.out.println("Error introducing adapted language introduce yes or no again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("yes"))
		{
			while(!option.equalsIgnoreCase("no"))
			{
				System.out.println("Introduce a new language");
				this.language = this.scanner.next();

				this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
				this.adaptedLanguage[this.adaptedLanguage.length-1] = this.language;

				System.out.println("Want to introduce a new language (no/any key)");
				option=this.scanner.next();
			}
		}
		//This try catch it used if the user enter a String data
		try
		{
			System.out.println("Enter a duration");
			this.duration = this.scanner.nextInt();
		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing duration");
			this.duration = 0;
		}
		//This try-catch do the same function of the last try-catch
		try
		{
			System.out.println("Enter a view");
			this.views = this.scanner.nextInt();
		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing views");
			this.views=0;
		}
		this.film = this.menuFS.addFilm(this.film, this.title, this.originalLanguage, this.adaptedLanguage, this.duration, this.views);
	}

	/**
	 * For add serie
	 */
	private void addNewSerie()
	{
		this.title = this.scanner.nextLine();
		//The user must introduce with the scanner the attributes of the series
		System.out.println("You choose add a new serie please introduce his title");
		this.title = this.scanner.nextLine();

		System.out.println("Introduce his original language");
		this.originalLanguage = this.scanner.next();

		System.out.println("Want to introduce adapted language? (yes/no)");
		String option = this.scanner.next();

		while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
		{
			System.out.println("Error introducing adapted language introduce yes or no again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("yes"))
		{
			while(!option.equalsIgnoreCase("no"))
			{
				System.out.println("Introduce a new language");
				this.language = this.scanner.next();

				this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
				this.adaptedLanguage[this.adaptedLanguage.length-1] = this.language;

				System.out.println("Want to introduce a new language (no/any key)");
				option=this.scanner.next();
			}
		}
		//This try-catch it used if the user introduce a string data
		try
		{
			System.out.println("Enter a duration");
			this.duration = this.scanner.nextInt();

		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing duration");
			this.duration = 0;
		}
		//This try-catch have the same function of the last try-catch
		try
		{
			System.out.println("Enter a view");
			this.views = this.scanner.nextInt();

		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing views");
			this.views=0;
		}
		this.serie = this.menuFS.addSerie(this.serie, this.title, this.originalLanguage, this.adaptedLanguage, this.duration, this.views);
	}

	/**
	 * @param endLoop the end of loop boolean
	 * @return return the boolean
	 */
	public boolean anotherSerie(boolean endLoop)
	{
		//When a film or serie it introduced the user can introduced another film or serie or can access to the next menu
		System.out.println("Want select again? (yes/no)");
		String option = this.scanner.next();

		while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
		{
			System.out.println("Error, select again (yes/no)");
			option=this.scanner.next();
		}
		if(option.equalsIgnoreCase("yes"))
		{
			System.out.println("""
				Select one of this option\s
				1.-Add a new film\s
				2.-Add a new serie\s
				""");
			option=this.scanner.next();
		}
		if(option.equalsIgnoreCase("no"))
		{
			endLoop = true;
		}
		return endLoop;
	}

	/**
	 * @return returns the string option
	 */
	public String controlMenu()
	{
		//In this menu the user can control films,series,actors,directors,subtitles,categories and recommendations
		System.out.println("""
			You have this options now:\s
			1.-Menu of films and serie\s
			2.-Menu of data of films and series\s
			3.-Menu of stats of the system\s
			4.-Exit""");
		System.out.println("Select one of them");

		return this.scanner.next();
	}

	/**
	 * The menu of film and series
	 */
	public void menuFilmSeries()
	{

		//In this case the user enter to a better menu that the last were he can delete,modify or search films and series
		boolean endMenu = false;

		System.out.println("""
			You enter in the series and film menu, select one option:
			1.-Add a new film or serie\s
			2.-Delete a serie or film by his attributes\s
			3.-Modify an attribute\s
			4.-Search a film or serie\s
			5.-Back""");
		String option = this.scanner.next();

		while(!endMenu)
		{
			switch(option)
			{
				case "1":
					{
						//----ADD NEW FILM OR SERIE----
						option = this.addNewFilmOrSerie();
						endMenu = true;
						break;
					}
				case "2":
					{
						//---DELETE SERIE OR FILM-----
						option = this.deleteSerieOrFilm();
						endMenu = true;
						break;
					}
				case "3":
					{
						//---MODIFY AN ATRIBUTE------
						option = this.modifyAnAttribute();
						endMenu = true;
						break;
					}
				case "4":
					{
						//---SEARCH A FILM OR SERIES----
						option = this.searchFilmOrSerie();
						endMenu = true;
						break;
					}
				case "5":
					{
						//----BACK-------
						endMenu = true;
						break;
					}
				default:
				{
					System.out.println("Error selecting option");
				}

				//---RETRY THE MENU FILM SERIES (PRINT)---
				option = this.retryMenuFilmSeriesPrint(endMenu, option);
			}
		}
	}

	/**
	 * @param endMenu the menu booelan
	 * @param option the option
	 * @return String with the info
	 */
	private String retryMenuFilmSeriesPrint(boolean endMenu, String option) {
		if(!endMenu)
		{
			System.out.println("""
				You enter in the series and film menu, select one option:
				1.-Add a new film or serie\s
				2.-Delete a serie or film by his attributes\s
				3.-Modify an attribute\s
				4.-Search a film or serie\s
				5.-Back""");
			option = this.scanner.next();
		}
		return option;
	}

	/**
	 * @return String with the info
	 */
	private String searchFilmOrSerie()
	{
		String option;
		System.out.println("Choose which audiovisual do you want (serie/film)");
		option=this.scanner.next();

		if(option.equalsIgnoreCase("serie"))
		{
			//---SEARCH SERIE BY ATTRIBUTES----
			option = this.searchSerieByAttributes();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---SEARCH FILM BY ATTRIBUTES----
			option = this.searchFilmByAttributes();
		}
		return option;
	}

	/**
	 * @return
	 */
	private String searchFilmByAttributes()
	{
		String option;
		System.out.println("""
			You choose search a film by one of his attribute, select one of then:\s
			1.-Title\s
			2.-Original language\s
			3.-Adapted language\s
			4.-Duration\s
			5.-Views""");
		option = this.scanner.next();

		if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
		{
			//------FILM BY TITLE-------
			this.filmByTitle();
		}
		else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
		{
			//----FILM - BY ORIGINAL LANGUAGE----
			this.filmByOrigLanguage();
		}
		else if (option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
		{
			//---FILM BY ADAPTED LANGUAGE---
			option = this.filmByAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equals("4"))
		{
			//----FILM BY DURATION------
			this.filmByDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equals("5"))
		{
			//---FILM--BY--VIEWS-------
			this.filmByViews();
		}
		return option;
	}

	/**
	 * Search film by views
	 */
	private void filmByViews()
	{
		try
		{
			System.out.println("Select a duration");
			this.duration = this.scanner.nextInt();
			this.menuFS.filmsSearchByViews(this.film, this.views);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing views");
		}
	}

	/**
	 * Search film by duration
	 */
	private void filmByDuration()
	{
		try
		{
			System.out.println("Select a duration");
			this.duration = this.scanner.nextInt();
			this.menuFS.filmsSearchByDuration(this.film, this.duration);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing duration");
		}
	}

	/**
	 * @return string with the information
	 */
	private String filmByAdaptedLanguage()
	{
		String option;
		System.out.println("Select a language");
		option = this.scanner.next();
		while(option.equalsIgnoreCase("exit"))
		{
			this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
			this.adaptedLanguage[this.adaptedLanguage.length-1] = option;
			System.out.println("Select another to add or \"exit\" to stop and modify");
			option = this.scanner.next();
		}
		this.menuFS.filmsSearchByAdaptedLanguage(this.film, this.adaptedLanguage);
		return option;
	}

	/**
	 *Search film by original language
	 */
	private void filmByOrigLanguage()
	{
		System.out.println("Select a original language to search");
		this.originalLanguage = this.scanner.nextLine();
		this.menuFS.filmsSearchByOriginalLanguage(this.film, this.originalLanguage);
	}

	/**
	 *Search film by title
	 */
	private void filmByTitle()
	{
		this.title = this.scanner.nextLine();
		System.out.println("Select a title to search");
		this.title = this.scanner.nextLine();
		this.menuFS.filmsSearchByTitle(this.film, this.title);
	}

	/**
	 * @return String with the information
	 */
	private String searchSerieByAttributes()
	{
		String option;
		System.out.println("""
			You choose search a serie by one of his attribute, select one of then:\s
			1.-Title\s
			2.-Original language\s
			3.-Adapted language\s
			4.-Duration\s
			5.-Views""");
		option = this.scanner.next();

		if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
		{
			//-----SERIE BY -- TITLE------
			this.searchSerieByTitle();
		}
		else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
		{
			//-----SERIE BY -- ORIGINAL LANGUAGE------
			this.searchSerieByOrigLanguage();
		}
		else if (option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
		{
			//-----SERIE BY -- ADAPTED LANGUAGE------
			option = this.searchSerieByAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equals("4"))
		{
			//-----SERIE BY -- DURATION------
			this.searchSerieByDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equals("5"))
		{
			//-----SERIE BY -- VIEWS------
			this.searchSerieByViews();
		}
		return option;
	}

	/**
	 *Search Serie by views
	 */
	private void searchSerieByViews() 
	{
		try
		{
			System.out.println("Select a duration");
			this.duration = this.scanner.nextInt();
			this.menuFS.searchSeriesByViews(this.serie, this.views);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing views");
		}
	}

	/**
	 *Search serie by duration
	 */
	private void searchSerieByDuration() 
	{
		try
		{
			System.out.println("Select a duration");
			this.duration = this.scanner.nextInt();
			this.menuFS.searchSeriesByDuration(this.serie, this.duration);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing duration");
		}
	}

	/**
	 * @return String with the information
	 */
	private String searchSerieByAdaptedLanguage() 
	{
		String option;
		System.out.println("Select a language");
		option = this.scanner.next();
		while(option.equalsIgnoreCase("exit"))
		{
			this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
			this.adaptedLanguage[this.adaptedLanguage.length-1] = option;
			System.out.println("Select another to add or \"exit\" to stop and modify");
			option = this.scanner.next();
		}
		this.menuFS.searchSeriesByAdaptedLanguage(this.serie, this.adaptedLanguage);
		return option;
	}

	/**
	 *Search serie by original language
	 */
	private void searchSerieByOrigLanguage() 
	{
		System.out.println("Select a original language to search");
		this.originalLanguage = this.scanner.nextLine();
		this.menuFS.searchSeriesByOriginalLanguage(this.serie, this.originalLanguage);
	}

	/**
	 *Search serie by title
	 */
	private void searchSerieByTitle()
	{
		this.title = this.scanner.nextLine();
		System.out.println("Select a title to search");
		this.title = this.scanner.nextLine();
		this.menuFS.searchSeriesByTitle(this.serie, this.title);
	}

	/**
	 * @return String with the information
	 */
	private String modifyAnAttribute() 
	{
		String option;
		System.out.println("Choose which audiovisual do you want (serie/film)");
		option = this.scanner.next();

		if(option.equalsIgnoreCase("serie"))
		{
			//---MODIFY A SERIE ATTRIBUTE---
			option = modifySerieAttribute();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---MODIFY A FILM ATTRIBUTE---
			option = modifyFilmAttribute();
		}
		return option;
	}

	/**
	 * @return String with the information
	 */
	private String modifyFilmAttribute() 
	{
		String option;
		option = this.scanner.nextLine();
		
		System.out.println("""
			You choose modify an attribute of a film, choose one of then:\s
			1.-Title\s
			2.-Original language\s
			3.-Adapted language\s
			4.-Duration\s
			5.-Views""");
	
		option = this.scanner.nextLine();
		
		if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
		{
			//------MODIFY FILM TITLE-------
			modifyFilmTitle();
		}
		else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
		{
			//------MODIFY FILM ORIGINAL LANGUAGE-------
			modifyFilmOriginalLanguage();
		}
		else if(option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equalsIgnoreCase("3"))
		{
			//------MODIFY FILM ADAPTED LANGUAGE-------
			option = modifyFilmAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
		{
			//------MODIFY FILM DURATION-------
			modifyFilmDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equalsIgnoreCase("5"))
		{
			//------MODIFY FILM VIEWS-------
			modifyFilmViews();
		} else {
			System.out.println("Error to select option");
		}
		return option;
	}

	/**
	 * Modify film views
	 */
	private void modifyFilmViews() 
	{
		try
		{
			System.out.println("Select the views to search");
			this.views = this.scanner.nextInt();
			System.out.println("Select the new views");
			this.newViews = this.scanner.nextInt();
			this.film = this.menuFS.filmModificationTimesViewed(this.film, this.views, this.newViews);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing views");
		}
	}

	/**
	 * Modify film duration
	 */
	private void modifyFilmDuration()
	{
		try
		{
			System.out.println("Select the duration to search");
			this.duration = this.scanner.nextInt();
			System.out.println("Select the new duration");
			this.newDuration = this.scanner.nextInt();
			this.film = this.menuFS.movieModificationForDuration(this.film, this.duration, this.newDuration);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing duration");
		}
	}

	/**
	 * @return String with the information
	 */
	private String modifyFilmAdaptedLanguage() 
	{
		String option;
		System.out.println("Select a new adaapted language");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("exit"))
		{
			this.newAdaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
			this.newAdaptedLanguage[this.adaptedLanguage.length-1] = option;
			System.out.println("Select another to add or \"exit\" to stop and modify");
			option = this.scanner.next();
		}
		this.film = this.menuFS.movieModificationByAdaptedLanguage(this.film, this.adaptedLanguage, this.adaptedLanguage);
		return option;
	}

	/**
	 * Modify original language film
	 */
	private void modifyFilmOriginalLanguage() 
	{
		System.out.println("Select the original language to search");
		this.originalLanguage = this.scanner.next();
		System.out.println("Select the new original language");
		this.film = this.menuFS.movieModificationForOriginalLanguage(this.film, this.originalLanguage, this.newOriginalLanguage);
	}

	/**
	 * Modify film title
	 */
	private void modifyFilmTitle()
	{
		this.title = this.scanner.nextLine();
		System.out.println("Select the title to search");
		this.title = this.scanner.nextLine();
		System.out.println("Select the new title");
		this.newTitle = this.scanner.nextLine();
		this.film = this.menuFS.movieModificationForTitle(this.film, this.title, this.newTitle);
	}

	/**
	 * @return String with the information
	 */
	private String modifySerieAttribute() 
	{
		String option;
		option = this.scanner.nextLine();
		System.out.println("""
			You choose modify an attribute of a serie, choose one of then:\s
			1.-Title\s
			2.-Original language\s
			3.-Adapted language\s
			4.-Duration\s
			5.-Views""");
		option = this.scanner.nextLine();
		if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
		{
			//----MODIFY SERIE TITLE----
			modifySerieTitle();
		}
		else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
		{
			//----MODIFY SERIE ORIGINAL LANGUAGE----
			modifySerieOriginalLanguage();
		}
		else if(option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equalsIgnoreCase("3"))
		{
			//----MODIFY SERIE ADAPTED LANGUAGE----
			option = modifySerieAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
		{
			//----MODIFY SERIE DURATION----
			modifySerieDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equalsIgnoreCase("5"))
		{
			//----MODIFY SERIE VIEWS----
			modifySerieViews();
		} else {
			System.out.println("Error to select option");
		}
		return option;
	}

	/**
	 * Modify serie views
	 */
	private void modifySerieViews() 
	{
		try
		{
			System.out.println("Select the views to search");
			this.views = this.scanner.nextInt();
			System.out.println("Select the new views");
			this.newViews = this.scanner.nextInt();
			this.serie = this.menuFS.seriesModificationForDuration(this.serie, this.views, this.newViews);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing views");
		}
	}

	/**
	 * Modify serie duration
	 */
	private void modifySerieDuration() 
	{
		try
		{
			System.out.println("Select the duration to search");
			this.duration = this.scanner.nextInt();
			System.out.println("Select the new duration");
			this.newDuration = this.scanner.nextInt();
			this.serie = this.menuFS.seriesModificationForDuration(this.serie, this.duration, this.newDuration);
		}catch(InputMismatchException e)
		{
			System.out.println("Error introducing duration");
		}
	}

	/**
	 * @return string with the information
	 */
	private String modifySerieAdaptedLanguage() 
	{
		String option;
		System.out.println("Select a new adaapted language");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("exit"))
		{
			this.newAdaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
			this.newAdaptedLanguage[this.adaptedLanguage.length-1] = option;
			System.out.println("Select another to add or \"exit\" to stop and modify");
			option = this.scanner.next();
		}
		this.serie = this.menuFS.seriesModificationByAdaptedLanguage(this.serie, this.adaptedLanguage, this.adaptedLanguage);
		return option;
	}

	/**
	 * Modify serie original language
	 */
	private void modifySerieOriginalLanguage() 
	{
		System.out.println("Select the original language to search");
		this.originalLanguage = this.scanner.next();
		System.out.println("Select the new original language");
		this.serie = this.menuFS.seriesModificationByOriginalLanguage(this.serie, this.originalLanguage, this.newOriginalLanguage);
	}

	/**
	 * Modify serie title
	 */
	private void modifySerieTitle() 
	{
		this.title = this.scanner.nextLine();
		System.out.println("Select the title to search");
		this.title = this.scanner.nextLine();
		System.out.println("Select the new title");
		this.newTitle = this.scanner.nextLine();
		this.serie = this.menuFS.seriesModificationForTitle(this.serie, this.title, this.newTitle);
	}

	/**
	 * @return string with the information
	 */
	private String deleteSerieOrFilm() 
	{
		String option;
		System.out.println("Choose which audiovisual do you want (serie/film)");
		option = this.scanner.next();
		if(option.equalsIgnoreCase("serie"))
		{
			//---DELETE SERIE----
			option = deleteSerie();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---DELETE FILM---
			option = deleteFilm();
		}
		return option;
	}

	/**
	 * @return string with information
	 */
	private String deleteFilm() 
	{
		String option;
		option = this.scanner.nextLine();
		System.out.println("""
			You choose delete a film by his attribute select one of then:\s
			1.-Title\s
			2.-Original language\s
			3.-Adapted language\s
			4.-Duration\s
			5.-Views""");
		option = this.scanner.nextLine();
		if(option.equalsIgnoreCase("title") || option.equals("1"))
		{
			//---DELETE FILM BY TITLE---
			deleteFilmByTitle();
		}
		else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
		{
			//---DELETE FILM BY ORIGINAL LANGUAGE---
			deleteFilmByOrigLanguage();
		}
		else if(option.equalsIgnoreCase("adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
		{
			//---DELETE FILM BY ADAPTED LANGUAGE---
			option = deleteFilmByAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equals("4"))
		{
			//---DELETE FILM BY DURATION---
			deleteFilmByDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equals("5"))
		{
			//---DELETE FILM BY VIEWS---
			deleteFilmByViews();

		} else {
			System.out.println("Error to introducing option");
		}
		return option;
	}

	/**
	 * Delete film by views
	 */
	private void deleteFilmByViews() 
	{
		try
		{
			System.out.println("Select the views to search");
			this.views = this.scanner.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("Error to introduce the views");
			this.views = -1;
		}
		if(this.views<0) {
			System.out.println("Error to delete the film");
		} else {
			this.film = this.menuFS.removeFilmByViews(this.film, this.views);
		}
	}

	/**
	 * Delete film by duration
	 */
	private void deleteFilmByDuration() 
	{
		try
		{
			System.out.println("Select the duration to search");
			this.duration = this.scanner.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("Error to introduce the duration");
			this.duration = -1;
		}
		if(this.duration==-1) {
			System.out.println("Error to delete the film");
		} else {
			this.film = this.menuFS.removeFilmByDuration(this.film, this.duration);
		}
	}

	/**
	 * @return String with the information
	 */
	private String deleteFilmByAdaptedLanguage() 
	{
		String option;
		this.adaptedLanguage = new String[0];
		System.out.println("Select the adapted language to search (can be may several)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("exit"))
		{
			this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
			this.adaptedLanguage[this.adaptedLanguage.length-1] = option;
			System.out.println("Select another to add or \"exit\" to stop and search");
			option = this.scanner.next();
		}
		this.film = this.menuFS.removeFilmByAdaptedLanguage(this.film, this.adaptedLanguage);
		return option;
	}

	/**
	 * Delete film by original language
	 */
	private void deleteFilmByOrigLanguage() 
	{
		this.originalLanguage = this.scanner.nextLine();
		System.out.println("Select the original language to search");
		this.originalLanguage = this.scanner.nextLine();
		this.film = this.menuFS.removeFilmByOriginalLanguage(this.film, this.originalLanguage);
	}

	/**
	 * Delete film by title
	 */
	private void deleteFilmByTitle() 
	{
		this.title = this.scanner.nextLine();
		System.out.println("Select the title to search");
		this.title = this.scanner.nextLine();
		this.film = this.menuFS.removeFilmByTitle(this.film, this.title);
	}

	/**
	 * @return string with the information
	 */
	private String deleteSerie() 
	{
		String option;
		option = this.scanner.nextLine();
		System.out.println("""
			You choose delete a serie by his attribute select one of then:\s
			1.-Title\s
			2.-Original language\s
			3.-Adapted language\s
			4.-Duration\s
			5.-Views""");
		option = this.scanner.nextLine();
		
		if(option.equalsIgnoreCase("title") || option.equals("1"))
		{
			//---DELETE SERIE BY TITLE---
			deleteSerieByTitle();
		}
		else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
		{
			//---DELETE SERIE BY ORIGINAL LANGUAGE---
			deleteSerieByOrigLanguage();
		}
		else if(option.equalsIgnoreCase("adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
		{
			//---DELETE SERIE BY ADAPTED LANGUAGE---
			option = deleteSerieByAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equals("4"))
		{

			//---DELETE SERIE BY DURATION---
			deleteSerieByDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equals("5"))
		{
			//---DELETE SERIE BY VIEWS---
			deleteSerieByViews();

		} else 
		{
			System.out.println("Error to introducing option");
		}
		return option;
	}

	/**
	 * 
	 * Delete serie by views
	 */
	private void deleteSerieByViews() 
	{
		System.out.println("Select the views to search");
		try
		{
			System.out.println("Enter a view");
			this.views = this.scanner.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("Error to introduce the views");
			this.views = -1;
		}
		if(this.views<0) {
			System.out.println("Error to delete the serie");
		} else {
			this.serie = this.menuFS.seriesDownViewTimesView(this.serie, this.views);
		}
	}

	/**
	 * Delete serie by duration
	 */
	private void deleteSerieByDuration() 
	{
		try
		{
			System.out.println("Enter a duration");
			this.duration = this.scanner.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("Error to introduce the duration");
			this.duration = -1;
		}
		if(this.duration==-1) {
			System.out.println("Error to delete the serie");
		} else {
			this.serie = this.menuFS.seriesDownDuration(this.serie, this.duration);
		}
	}

	/**
	 * @return String with the information
	 */
	private String deleteSerieByAdaptedLanguage() 
	{
		String option;
		this.adaptedLanguage = new String[0];
		System.out.println("Select the adapted language to search (can be may several)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("exit"))
		{
			this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
			this.adaptedLanguage[this.adaptedLanguage.length-1] = option;
			System.out.println("Select another to add or \"exit\" to stop and search");
			option = this.scanner.next();
		}
		this.serie = this.menuFS.seriesDropByAdaptedLanguage(this.serie, this.adaptedLanguage);
		return option;
	}

	/**
	 * Delete serie by original language
	 */
	private void deleteSerieByOrigLanguage() 
	{
		this.originalLanguage = this.scanner.nextLine();
		System.out.println("Select the original language to search");
		this.originalLanguage = this.scanner.nextLine();
		this.serie = this.menuFS.seriesDropByOriginalLanguage(this.serie, this.originalLanguage);
	}

	/**
	 * Delete serie by title
	 */
	private void deleteSerieByTitle() 
	{
		System.out.println("Select the title to search");
		this.title = this.scanner.nextLine();
		this.serie = this.menuFS.seriesDropByTitle(this.serie, this.title);
	}

	/**
	 * @return String with the information
	 */
	private String addNewFilmOrSerie() 
	{
		String option;
		System.out.println("Choose which audiovisual do you want (serie / film)");
		option = this.scanner.next();
		if(option.equalsIgnoreCase("serie"))
		{
			//---ADD NEW SERIE SELECTION----
			option = addNewSerieSelected();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---ADD NEW FILM SELECTION----
			option = addNewFilmSelected();
		} else {
			System.out.println("Error to selecting audiovisual");
		}
		return option;
	}

	/**
	 * @return String with the information
	 */
	private String addNewFilmSelected() 
	{
		String option;
		//The user must to introduce with the scanner the attributes of the films
		option = this.scanner.nextLine();
		System.out.println("You choose add a new film please introduce his title");
		this.title = this.scanner.nextLine();
		System.out.println("Introduce his original language");
		this.originalLanguage = this.scanner.next();
		System.out.println("Want to introduce adapted language? (yes/no)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
		{
			System.out.println("Error introducing adapted language introduce yes or no again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("yes"))
		{
			while(!option.equalsIgnoreCase("no"))
			{
				System.out.println("Introduce a new language");
				this.language = this.scanner.next();
				this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
				this.adaptedLanguage[this.adaptedLanguage.length-1] = this.language;
				System.out.println("Want to introduce a new language (no/any key)");
				option=this.scanner.next();
			}
		}
		//This try catch it used if the user enter a String data
		try
		{
			System.out.println("Enter a duration");
			this.duration = this.scanner.nextInt();
		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing duration");
			this.duration = 0;
		}
		//This try-catch do the same function of the last try-catch
		try
		{
			System.out.println("Enter a view");
			this.views = this.scanner.nextInt();
		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing views");
			this.views=0;
		}
		this.film = this.menuFS.addFilm(this.film, this.title, this.originalLanguage, this.adaptedLanguage, this.duration, this.views);
		return option;
	}

	/**
	 * @return string with the information
	 */
	private String addNewSerieSelected() 
	{
		String option;
		this.title = this.scanner.nextLine();
		System.out.println("You choose add a new serie please introduce his title");
		this.title = this.scanner.nextLine();
		System.out.println("Introduce his original language");
		this.originalLanguage = this.scanner.next();
		System.out.println("Want to introduce adapted language? (yes/no)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
		{
			System.out.println("Error introducing adapted language introduce yes or no again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("yes"))
		{
			while(!option.equalsIgnoreCase("no"))
			{
				System.out.println("Introduce a new language");
				this.language = this.scanner.next();
				this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
				this.adaptedLanguage[this.adaptedLanguage.length-1] = this.language;
				System.out.println("Want to introduce a new language (no/any key)");
				option=this.scanner.next();
			}
		}
		//This try-catch it used if the user introduce a string data
		try
		{
			System.out.println("Enter a duration");
			this.duration = this.scanner.nextInt();
		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing duration");
			this.duration = 0;
		}
		//This try-catch have the same function of the last try-catch
		try
		{
			System.out.println("Enter a view");
			this.views = this.scanner.nextInt();
		}catch(InputMismatchException exception)
		{
			System.out.println("Error introducing views");
			this.views=0;
		}
		this.serie = this.menuFS.addSerie(this.serie, this.title, this.originalLanguage, this.adaptedLanguage, this.duration, this.views);
		return option;
	}

	public void menuDataFilmSerie()
	{
		System.out.println("""
			You enter in the menu of data of films and series, choose a option\s
			1.-Menu of actors\s
			2.-Menu of directors\s
			3.-Menu of categories\s
			4.-Menu of recommendation\s
			5.-Menu of subtitles\s
			6.- Back""");
		String option = this.scanner.next();
		boolean endMenu = false;

		while(!endMenu)
		{
			switch(option)
			{
				case "1":
				{
					//----MENU OF ACTORS------
					option = this.menuDataActors();
					break;
				}
				case "2":
				{
					//----MENU OF DIRECTORS-------
					option = this.menuDataDirectors();
					break;
				}
				case "3":
				{
					//----MENU OF CATEGORIES-------
					option = menuDataCategories();
					break;
				}
                case "4":
                        System.out.println("""
							You choose menu of recommendation, select one option:\s
							1.-Add a recommendation\s
							2.-Delete a recommendation\s
							3.-Modify a recommendation\s
							4.-Search a recommendation\s
							5.-Back""");
                        option = this.scanner.next();
                        if(option.equals("1"))
                        {
                                System.out.println("Select a rating (bad/good)");
                                option = this.scanner.next();
                                while(!option.equalsIgnoreCase("good")&&!option.equalsIgnoreCase("bad"))
                                {
                                    System.out.println("Error selecting a rate, choose again (bad/good)");
                                    option = this.scanner.next();
                                }
                                if(option.equalsIgnoreCase("good"))
                                {
                                    this.rate = RatingType.POSITIVE;
                                }
                                else
                                {
                                    this.rate = RatingType.NEGATIVE;
                                }
                                this.comment = this.scanner.nextLine();
                                System.out.println("Select a comment ");
                                this.comment = this.scanner.nextLine();
                                System.out.println("Where do you save your recommendation (serie/film)");
                                option = this.scanner.next();
                                while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                {
                                        System.out.println("Error choose again (serie/film)");
                                        option = this.scanner.next();
                                }
                                if(option.equalsIgnoreCase("serie"))
                                {
                                        this.statsFS.countSeries(this.serie);
                                        this.title= this.scanner.nextLine();
                                        System.out.println("Select the title of your serie");
                                        this.title = this.scanner.nextLine();
                                        for(Serie serie:this.serie)
                                        {
                                                if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                {
                                                        this.recommendation = serie.getRecommendation();
                                                        this.recommendation = this.menuRec.addRecommendation(this.recommendation, this.rate, this.comment);
                                                        serie.setRecommendation(this.recommendation);
                                                }
                                        }
                                }
                                else
                                {
                                        this.statsFS.countFilms(this.film);
                                        this.title= this.scanner.nextLine();
                                        System.out.println("Select the title of your film");
                                        this.title = this.scanner.nextLine();
                                        for(Film film:this.film)
                                        {
                                                if(this.title.equalsIgnoreCase(film.getTitle()))
                                                {
                                                        this.recommendation = film.getRecommendation();
                                                        this.recommendation = this.menuRec.addRecommendation(this.recommendation, this.rate, this.comment);
                                                        film.setRecommendation(this.recommendation);
                                                }
                                        }
                                }

                        }
                        else if(option.equals("2"))
                        {
                                System.out.println("""
									You choose delete a recommendation by its attributes, choose one:\s
									1.-Rating\s
									2.-Comment\s
									""");
                                option = this.scanner.next();
                                if(option.equalsIgnoreCase("Rating") || option.equals("1"))
                                {
                                        System.out.println("Select a rating (bad/good)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("good")&&!option.equalsIgnoreCase("bad"))
                                        {
                                            System.out.println("Error selecting a rate, choose again (bad/good)");
                                            option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("good"))
                                        {
                                            this.rate = RatingType.POSITIVE;
                                        }
                                        else
                                        {
                                            this.rate = RatingType.NEGATIVE;
                                        }
                                        System.out.println("where do you remove the recommendation (serie/film)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                        {
                                                System.out.println("Error choose again (serie/film)");
                                                option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("serie"))
                                        {
                                                this.statsFS.countSeries(this.serie);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your serie");
                                                this.title = this.scanner.nextLine();
                                                for(Serie serie:this.serie)
                                                {
                                                        if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                        {
                                                            this.recommendation = serie.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationDeleteByRate(this.recommendation, this.rate);
                                                            serie.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                this.statsFS.countFilms(this.film);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your film");
                                                this.title = this.scanner.nextLine();
                                                for(Film film:this.film)
                                                {
                                                        if(this.title.equalsIgnoreCase(film.getTitle()))
                                                        {
                                                            this.recommendation = film.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationDeleteByRate(this.recommendation, this.rate);
                                                            film.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }

                                }
                                else if(option.equalsIgnoreCase("Comment") || option.equalsIgnoreCase("Comment") || option.equals("2"))
                                {
                                        this.comment = this.scanner.nextLine();
                                        System.out.println("Select the comment to search");
                                        this.comment = this.scanner.nextLine();
                                        System.out.println("were do you remove the description (serie/film)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                        {
                                                System.out.println("Error choose again (serie/film)");
                                                option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("serie"))
                                        {
                                                this.statsFS.countSeries(this.serie);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your serie");
                                                this.title = this.scanner.nextLine();
                                                for(Serie serie:this.serie)
                                                {
                                                        if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                        {
                                                            this.recommendation = serie.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationDeleteByComment(this.recommendation, this.comment);
                                                            serie.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                this.statsFS.countFilms(this.film);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your film");
                                                this.title = this.scanner.nextLine();
                                                for(Film film:this.film)
                                                {
                                                        if(this.title.equalsIgnoreCase(film.getTitle()))
                                                        {
                                                            this.recommendation = film.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationDeleteByComment(this.recommendation, this.comment);
                                                            film.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                }
                                else
                                {
                                        System.out.println("Error selecting option");
                                }
                        }
                        else if(option.equals("3"))
                        {
                                System.out.println("""
									You choose modify an attribute of a recommendation, choose one option:\s
									 \
									1.-Rating\s
									2.-Comment\s
									""");
                                option = this.scanner.next();
                                if(option.equalsIgnoreCase("Rating") || option.equals("1"))
                                {
                                        System.out.println("Select a rating to search (bad/good)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("good")&&!option.equalsIgnoreCase("bad"))
                                        {
                                            System.out.println("Error selecting a rate, choose again (bad/good)");
                                            option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("good"))
                                        {
                                            this.rate = RatingType.POSITIVE;
                                        }
                                        else
                                        {
                                            this.rate = RatingType.NEGATIVE;
                                        }
                                        System.out.println("Select a new rate (bad/good)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("good")&&!option.equalsIgnoreCase("bad"))
                                        {
                                            System.out.println("Error selecting a rate, choose again (bad/good)");
                                            option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("good"))
                                        {
                                            this.newRate = RatingType.POSITIVE;
                                        }
                                        else
                                        {
                                            this.newRate = RatingType.NEGATIVE;
                                        }
                                        System.out.println("Where do you modify the recommendation (serie/film)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                        {
                                                System.out.println("Error choose again (serie/film)");
                                                option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("serie"))
                                        {
                                                this.statsFS.countSeries(this.serie);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your serie");
                                                this.title = this.scanner.nextLine();
                                                for(Serie serie:this.serie)
                                                {
                                                        if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                        {
                                                            this.recommendation = serie.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationModifyByRate(this.recommendation, this.rate, this.newRate);
                                                            serie.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                this.statsFS.countFilms(this.film);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your film");
                                                this.title = this.scanner.nextLine();
                                                for(Film film:this.film)
                                                {
                                                        if(this.title.equalsIgnoreCase(film.getTitle()))
                                                        {
                                                            this.recommendation = film.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationModifyByRate(this.recommendation, this.rate, this.newRate);
                                                            film.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }

                                }
                                else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("Description") || option.equals("2"))
                                {
                                        this.comment = this.scanner.nextLine();
                                        System.out.println("Select the comment to search");
                                        this.comment = this.scanner.nextLine();
                                        System.out.println("Select the new comment");
                                        this.newComment = this.scanner.nextLine();
                                        System.out.println("were do you modify the category (serie/film)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                        {
                                                System.out.println("Error choose again (serie/film)");
                                                option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("serie"))
                                        {
                                                this.statsFS.countSeries(this.serie);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your serie");
                                                this.title = this.scanner.nextLine();
                                                for(Serie serie:this.serie)
                                                {
                                                        if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                        {
                                                            this.recommendation = serie.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationModifyByComment(this.recommendation, this.comment, this.newComment);
                                                            serie.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                this.statsFS.countFilms(this.film);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your film");
                                                this.title = this.scanner.nextLine();
                                                for(Film film:this.film)
                                                {
                                                        if(this.title.equalsIgnoreCase(film.getTitle()))
                                                        {
                                                            this.recommendation = film.getRecommendation();
                                                            this.recommendation = this.menuRec.recommendationModifyByComment(this.recommendation, this.comment, this.newComment);
                                                            film.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                }
                                else
                                {
                                        System.out.println("Error selecting option");
                                }
                        }
                        else if(option.equals("4"))
                        {
                                System.out.println("""
									You choose search a recommendation by his attributes, choose one:\s
									1.-Rating\s
									2.-Comment\s
									""");
                                option = this.scanner.next();
                                if(option.equalsIgnoreCase("Rating") || option.equals("1"))
                                {
                                        System.out.println("Select a rate to search (bad/good)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("good")&&!option.equalsIgnoreCase("bad"))
                                        {
                                            System.out.println("Error selecting a rate, choose again (bad/good)");
                                            option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("good"))
                                        {
                                            this.rate = RatingType.POSITIVE;
                                        }
                                        else
                                        {
                                            this.rate = RatingType.NEGATIVE;
                                        }
                                        System.out.println("where do you search the recommendation (serie/film)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                        {
                                                System.out.println("Error choose again (serie/film)");
                                                option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("serie"))
                                        {
                                                this.statsFS.countSeries(this.serie);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your serie");
                                                this.title = this.scanner.nextLine();
                                                for(Serie serie:this.serie)
                                                {
                                                        if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                        {
                                                            this.recommendation = serie.getRecommendation();
                                                            this.menuRec.recommendationSearchByRate(this.recommendation, this.rate);
                                                            serie.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                this.statsFS.countFilms(this.film);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your film");
                                                this.title = this.scanner.nextLine();
                                                for(Film film:this.film)
                                                {
                                                        if(this.title.equalsIgnoreCase(film.getTitle()))
                                                        {
                                                            this.recommendation = film.getRecommendation();
                                                            this.menuRec.recommendationSearchByRate(this.recommendation, this.rate);
                                                            film.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }

                                }
                                else if(option.equalsIgnoreCase("Comment") || option.equalsIgnoreCase("Comment") || option.equals("2"))
                                {
                                        this.comment = this.scanner.nextLine();
                                        System.out.println("Select the description to search");
                                        this.comment = this.scanner.nextLine();
                                        System.out.println("were do you search the category (serie/film)");
                                        option = this.scanner.next();
                                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                                        {
                                                System.out.println("Error choose again (serie/film)");
                                                option = this.scanner.next();
                                        }
                                        if(option.equalsIgnoreCase("serie"))
                                        {
                                                this.statsFS.countSeries(this.serie);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your serie");
                                                this.title = this.scanner.nextLine();
                                                for(Serie serie:this.serie)
                                                {
                                                        if(this.title.equalsIgnoreCase(serie.getTitle()))
                                                        {
                                                            this.recommendation = serie.getRecommendation();
                                                            this.menuRec.recommendationSearchByComment(this.recommendation, this.comment);
                                                            serie.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                this.statsFS.countFilms(this.film);
                                                this.title= this.scanner.nextLine();
                                                System.out.println("Select the title of your film");
                                                this.title = this.scanner.nextLine();
                                                for(Film film:this.film)
                                                {
                                                        if(this.title.equalsIgnoreCase(film.getTitle()))
                                                        {
                                                            this.recommendation = film.getRecommendation();
                                                            this.menuRec.recommendationSearchByComment(this.recommendation, this.comment);
                                                            film.setRecommendation(this.recommendation);
                                                        }
                                                }
                                        }
                                }
                                else
                                {
                                        System.out.println("Error selecting option");
                                }
                        }
                        break;

                case "5":
    				System.out.println("""
						You choose menu of subtitles, select one option:\s
						1.-Add a language\s
						2.-Delete a language\s
						3.-Modify a language\s
						4.-Search a language\s
						5.-Back""");
    				option = this.scanner.next();
                    if(option.equals("1"))
                    {
                        System.out.println("Select a language");
                        this.language = this.scanner.next();
                        System.out.println("Where do you save your language (serie/film)");
                        option = this.scanner.next();
                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                        {
                            System.out.println("Error choose again (serie/film)");
                            option = this.scanner.next();
                        }
                        if(option.equalsIgnoreCase("serie"))
                        {
                            this.statsFS.countSeries(this.serie);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your serie");
                            this.title = this.scanner.nextLine();
                            for(Serie serie:this.serie)
                                {
                                	if(this.title.equalsIgnoreCase(serie.getTitle()))
                                    {
                                        this.subtitles = serie.getSubtitles();
                                        this.subtitles = this.menuSub.addSubtitles(this.subtitles,this.language);
                                        serie.setSubtitles(this.subtitles);
                                    }
                                }
                        }
                        else
                        {
                            this.statsFS.countFilms(this.film);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your film");
                            this.title = this.scanner.nextLine();
                            for(Film film:this.film)
                            {
                                if(this.title.equalsIgnoreCase(film.getTitle()))
                                {
                                    this.subtitles = film.getSubtitles();
                                    this.subtitles = this.menuSub.addSubtitles(this.subtitles, this.language);
                                    film.setSubtitles(this.subtitles);
                                }
                    		}
                        }

                    }
                    else if(option.equals("2"))
                    {
                        System.out.println("You choose delete a subtitle by his language");
                        System.out.println("Select a language to search");
                        this.language = this.scanner.next();
                        System.out.println("where do you remove the language (serie/film)");
                        option = this.scanner.next();
                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                        {
                            System.out.println("Error choose again (serie/film)");
                            option = this.scanner.next();
                        }
                        if(option.equalsIgnoreCase("serie"))
                        {
                            this.statsFS.countSeries(this.serie);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your serie");
                            this.title = this.scanner.nextLine();
                            for(Serie serie:this.serie)
                            {
                                if(this.title.equalsIgnoreCase(serie.getTitle()))
                                {
                                    this.subtitles = serie.getSubtitles();
                                    this.subtitles = this.menuSub.removeSubtitles(this.subtitles, this.language);
                                    serie.setSubtitles(this.subtitles);
                                }
                            }
                        }
                        else
                        {
                            this.statsFS.countFilms(this.film);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your film");
                            this.title = this.scanner.nextLine();
                            for(Film film:this.film)
                            {
                                if(this.title.equalsIgnoreCase(film.getTitle()))
                                {
                                    this.subtitles = film.getSubtitles();
                                    this.subtitles = this.menuSub.removeSubtitles(this.subtitles, this.language);
                                    film.setSubtitles(this.subtitles);
                                }
                            }
                        }
                    }


                    else if(option.equals("3"))
                    {
                        System.out.println("You choose modify the subtitle by his language");
                        System.out.println("Select the language to search");
                        this.language = this.scanner.next();
                        System.out.println("Select the new language");
                        this.newLanguage = this.scanner.next();
                        System.out.println("Were do you modify the language (serie/film)");
                        option = this.scanner.next();
                        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                        {
                            System.out.println("Error choose again (serie/film)");
                            option = this.scanner.next();
                        }
                    	if(option.equalsIgnoreCase("serie"))
                		{
                            this.statsFS.countSeries(this.serie);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your serie");
                            this.title = this.scanner.nextLine();
                            for(Serie serie:this.serie)
                            {
                                if(this.title.equalsIgnoreCase(serie.getTitle()))
                                {
                                    this.subtitles = serie.getSubtitles();
                                    this.subtitles = this.menuSub.modifyLanguage(this.subtitles, this.language, this.newLanguage);
                                    serie.setSubtitles(this.subtitles);
                                }
                            }
                        }
                        else
                        {
                            this.statsFS.countFilms(this.film);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your film");
                            this.title = this.scanner.nextLine();
                            for(Film film:this.film)
                            {
                                if(this.title.equalsIgnoreCase(film.getTitle()))
                                {
                                    this.subtitles = film.getSubtitles();
                                    this.subtitles = this.menuSub.modifyLanguage(this.subtitles, this.language, this.newLanguage);
                                    film.setSubtitles(this.subtitles);
                                }
                            }
                        }


    				}

    		        else if(option.equals("4"))
    		        {
    		        	System.out.println("You choose search a subtitle by languaje") ;
    	                System.out.println("Select a language to search");
    	                this.language = this.scanner.next();
    	                System.out.println("where do you search the language (serie/film)");
    	                option = this.scanner.next();
    	                while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
                        {
                            System.out.println("Error choose again (serie/film)");
                            option = this.scanner.next();
                        }
                        if(option.equalsIgnoreCase("serie"))
                        {
                            this.statsFS.countSeries(this.serie);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your serie");
                            this.title = this.scanner.nextLine();
                            for(Serie serie:this.serie)
                			{
                                if(this.title.equalsIgnoreCase(serie.getTitle()))
                                {
                                    this.subtitles = serie.getSubtitles();
                                    this.menuSub.searchByLanguage(this.subtitles, this.language);
                                }
                            }
                        }
                        else
                        {
                            this.statsFS.countFilms(this.film);
                            this.title= this.scanner.nextLine();
                            System.out.println("Select the title of your film");
                            this.title = this.scanner.nextLine();
                            for(Film film:this.film)
                            {
                                if(this.title.equalsIgnoreCase(film.getTitle()))
                                {
                                    this.subtitles = film.getSubtitles();
                                    this.menuSub.searchByLanguage(this.subtitles, this.language);
                                }
                            }
                        }

                    }

                	else
                    {
                    	System.out.println("Error selecting option");
                    }

    				break;


				case "6":
					endMenu = true;
					break;
			}
			if(!endMenu)
			{
				System.out.println("""
					Select one option:\s
					1.-Menu of actors\s
					2.-Menu of directors\s
					3.-Menu of categories\s
					4.-Menu of recommendation\s
					5.-Menu of subtitles\s
					6.-Back""");
				option = this.scanner.next();
			}
		}
	}

	/**
	 * @return
	 */
	private String menuDataCategories() {
		String option;
		System.out.println("""
			You choose menu of categories, select one option:\s
			1.-Add a category\s
			2.-Delete a category\s
			3.-Modify a category\s
			4.-Search a category\s
			5.-Back""");
		option = this.scanner.next();
		if(option.equals("1"))
		{
		        this.name = this.scanner.nextLine();
		        System.out.println("Select a name");
		        this.name = this.scanner.nextLine();
		        System.out.println("Select a description");
		        this.description = this.scanner.nextLine();
		        System.out.println("Where do you save your category (serie/film)");
		        option = this.scanner.next();
		        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		        {
		                System.out.println("Error choose again (serie/film)");
		                option = this.scanner.next();
		        }
		        if(option.equalsIgnoreCase("serie"))
		        {
		            this.statsFS.countSeries(this.serie);
		            this.title= this.scanner.nextLine();
		            System.out.println("Select the title of your serie");
		            this.title = this.scanner.nextLine();
		            for(Serie serie:this.serie)
		            {
		                    if(this.title.equalsIgnoreCase(serie.getTitle()))
		                    {
		                        this.category = serie.getCategory();
		                        this.category = this.menuCat.addCategory(this.category, this.name, this.description);
		                        serie.setCategory(this.category);
		                    }
		            }
		        }
		        else
		        {
		                this.statsFS.countFilms(this.film);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your film");
		                this.title = this.scanner.nextLine();
		                for(Film film:this.film)
		                {
		                    if(this.title.equalsIgnoreCase(film.getTitle()))
		                    {
		                        this.category = film.getCategory();
		                        this.category = this.menuCat.addCategory(this.category, this.name, this.description);
		                        film.setCategory(this.category);
		                    }
		                }
		        }

		}
		else if(option.equals("2"))
		{
		    System.out.println("""
				You choose delete a Category by its attributes, choose one:\s
				1.-Name\s
				2.-Description\s
				""");
		    option = this.scanner.next();
		    if(option.equalsIgnoreCase("name") || option.equals("1"))
		    {
		            this.name = this.scanner.nextLine();
		            System.out.println("Select a name to search");
		            this.name = this.scanner.next();
		            System.out.println("where do you remove the category (serie/film)");
		            option = this.scanner.next();
		            while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		            {
		                System.out.println("Error choose again (serie/film)");
		                option = this.scanner.next();
		            }
		            if(option.equalsIgnoreCase("serie"))
		            {
		                this.statsFS.countSeries(this.serie);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your serie");
		                this.title = this.scanner.nextLine();
		                for(Serie serie:this.serie)
		                {
		                    if(this.title.equalsIgnoreCase(serie.getTitle()))
		                    {
		                        this.category = serie.getCategory();
		                        this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		                        serie.setCategory(this.category);
		                    }
		                }
		            }
		            else
		            {
		                this.statsFS.countFilms(this.film);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your film");
		                this.title = this.scanner.nextLine();
		                for(Film film:this.film)
		                {
		                    if(this.title.equalsIgnoreCase(film.getTitle()))
		                    {
		                        this.category = film.getCategory();
		                        this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		                        film.setCategory(this.category);
		                    }
		                }
		            }
		        }
		        else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("Description") || option.equals("2"))
		        {
		            this.description = this.scanner.nextLine();
		            System.out.println("Select the description to search");
		            this.description = this.scanner.nextLine();
		            System.out.println("were do you remove the description (serie/film)");
		            option = this.scanner.next();
		            while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		            {
		                System.out.println("Error choose again (serie/film)");
		                option = this.scanner.next();
		            }
		            if(option.equalsIgnoreCase("serie"))
		            {
		                this.statsFS.countSeries(this.serie);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your serie");
		                this.title = this.scanner.nextLine();
		                for(Serie serie:this.serie)
		                {
		                    if(this.title.equalsIgnoreCase(serie.getTitle()))
		                    {
		                        this.category = serie.getCategory();
		                        this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		                        serie.setCategory(this.category);
		                    }
		                }
		            }
		            else
		            {
		                this.statsFS.countFilms(this.film);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your film");
		                this.title = this.scanner.nextLine();
		                for(Film film:this.film)
		                {
		                    if(this.title.equalsIgnoreCase(film.getTitle()))
		                    {
		                        this.category = film.getCategory();
		                        this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		                        film.setCategory(this.category);
		                    }
		                }
		            }
		        }
		        else
		        {
		                System.out.println("Error selecting option");
		        }
		}
		else if(option.equals("3"))
		{
		    System.out.println("""
				You choose modify a attribute of a category, choose one option:\s
				 \
				1.-Name\s
				2.-Description\s
				""");
		    option = this.scanner.next();
		    if(option.equalsIgnoreCase("name") || option.equals("1"))
		    {
		            this.name = this.scanner.nextLine();
		            System.out.println("Select a name to search");
		            this.name = this.scanner.nextLine();
		            System.out.println("Select the new name");
		            this.newName = this.scanner.nextLine();
		            System.out.println("Were do you modify the category (serie/film)");
		            option = this.scanner.next();
		            while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		            {
		                System.out.println("Error choose again (serie/film)");
		                option = this.scanner.next();
		            }
		            if(option.equalsIgnoreCase("serie"))
		            {
		                    this.statsFS.countSeries(this.serie);
		                    this.title= this.scanner.nextLine();
		                    System.out.println("Select the title of your serie");
		                    this.title = this.scanner.nextLine();
		                    for(Serie serie:this.serie)
		                    {
		                        if(this.title.equalsIgnoreCase(serie.getTitle()))
		                        {
		                            this.category = serie.getCategory();
		                            this.category = this.menuCat.modifyCategoryByName(this.category, this.name, this.newName);
		                            serie.setCategory(this.category);
		                        }
		                    }
		            }
		            else
		            {
		                this.statsFS.countFilms(this.film);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your film");
		                this.title = this.scanner.nextLine();
		                for(Film film:this.film)
		                {
		                    if(this.title.equalsIgnoreCase(film.getTitle()))
		                    {
		                        this.category = film.getCategory();
		                        this.category = this.menuCat.modifyCategoryByName(this.category, this.name, this.newName);
		                        film.setCategory(this.category);
		                    }
		                }
		            }

		    }
		    else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("Description") || option.equals("2"))
		    {
		        this.description = this.scanner.nextLine();
		        System.out.println("Select the description to search");
		        this.description = this.scanner.nextLine();
		        System.out.println("Select the new description");
		        this.newDescription = this.scanner.nextLine();
		        System.out.println("were do you modify the category (serie/film)");
		        option = this.scanner.next();
		        while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		        {
		                System.out.println("Error choose again (serie/film)");
		                option = this.scanner.next();
		        }
		        if(option.equalsIgnoreCase("serie"))
		        {
		                this.statsFS.countSeries(this.serie);
		                this.title= this.scanner.nextLine();
		                System.out.println("Select the title of your serie");
		                this.title = this.scanner.nextLine();
		                for(Serie serie:this.serie)
		                {
		                        if(this.title.equalsIgnoreCase(serie.getTitle()))
		                        {
		                                this.category = serie.getCategory();
		                                this.category = this.menuCat.modifyCategoryByDescription(this.category, this.description, this.newDescription);
		                                serie.setCategory(this.category);
		                        }
		                }
		        }
		        else
		        {
		            this.statsFS.countFilms(this.film);
		            this.title= this.scanner.nextLine();
		            System.out.println("Select the title of your film");
		            this.title = this.scanner.nextLine();
		            for(Film film:this.film)
		            {
		                if(this.title.equalsIgnoreCase(film.getTitle()))
		                {
		                        this.category = film.getCategory();
		                        this.category = this.menuCat.modifyCategoryByDescription(this.category, this.description, this.newDescription);
		                        film.setCategory(this.category);
		                }
		            }
		        }
		    }
		    else
		    {
		            System.out.println("Error selecting option");
		    }
            }
            else if(option.equals("4"))
            {
		    System.out.println("""
				You choose search a category by his attributes, choose one:\s
				1.-Name\s
				2.-Description\s
				""");
		    option = this.scanner.next();
		    if(option.equalsIgnoreCase("name") || option.equals("1"))
		    {
		            this.name = this.scanner.nextLine();
		            System.out.println("Select a name to search");
		            this.name = this.scanner.next();
		            System.out.println("where do you search the category (serie/film)");
		            option = this.scanner.next();
		            while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		            {
		                    System.out.println("Error choose again (serie/film)");
		                    option = this.scanner.next();
		            }
		            if(option.equalsIgnoreCase("serie"))
		            {
		                    this.statsFS.countSeries(this.serie);
		                    this.title= this.scanner.nextLine();
		                    System.out.println("Select the title of your serie");
		                    this.title = this.scanner.nextLine();
		                    for(Serie serie:this.serie)
		                    {
		                            if(this.title.equalsIgnoreCase(serie.getTitle()))
		                            {
		                                this.category = serie.getCategory();
		                                this.menuCat.searchCategoryByName(this.category, this.name);
		                                serie.setCategory(this.category);
		                            }
		                    }
		            }
		            else
		            {
		                    this.statsFS.countFilms(this.film);
		                    this.title= this.scanner.nextLine();
		                    System.out.println("Select the title of your film");
		                    this.title = this.scanner.nextLine();
		                    for(Film film:this.film)
		                    {
		                            if(this.title.equalsIgnoreCase(film.getTitle()))
		                            {
		                                this.category = film.getCategory();
		                                this.menuCat.searchCategoryByName(this.category, this.name);
		                                film.setCategory(this.category);
		                            }
		                    }
		            }

		    }
		    else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("Description") || option.equals("2"))
		    {
		            this.lastName = this.scanner.nextLine();
		            System.out.println("Select the description to search");
		            this.lastName = this.scanner.nextLine();
		            System.out.println("were do you search the category (serie/film)");
		            option = this.scanner.next();
		            while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		            {
		                    System.out.println("Error choose again (serie/film)");
		                    option = this.scanner.next();
		            }
		            if(option.equalsIgnoreCase("serie"))
		            {
		                    this.statsFS.countSeries(this.serie);
		                    this.title= this.scanner.nextLine();
		                    System.out.println("Select the title of your serie");
		                    this.title = this.scanner.nextLine();
		                    for(Serie serie:this.serie)
		                    {
		                            if(this.title.equalsIgnoreCase(serie.getTitle()))
		                            {
		                                this.category = serie.getCategory();
		                                this.menuCat.searchCategoryByDescription(this.category, this.description);
		                                serie.setCategory(this.category);
		                            }
		                    }
		            }
		            else
		            {
		                    this.statsFS.countFilms(this.film);
		                    this.title= this.scanner.nextLine();
		                    System.out.println("Select the title of your film");
		                    this.title = this.scanner.nextLine();
		                    for(Film film:this.film)
		                    {
		                            if(this.title.equalsIgnoreCase(film.getTitle()))
		                            {
		                                this.category = film.getCategory();
		                                this.menuCat.searchCategoryByDescription(this.category, this.description);
		                                film.setCategory(this.category);
		                            }
		                    }
		            }
		    }
		    else
		    {
		            System.out.println("Error selecting option");
		    }
		}
		return option;
	}

	/**
	 * @return
	 */
	private String menuDataDirectors() {
		String option;
		System.out.println("""
			You choose menu of directors, select one option:\s
			1.-Add a director\s
			2.-Delete a director\s
			3.-Modify a director\s
			4.-Search a director\s
			5.-Back""");
		option = this.scanner.next();
		if(option.equals("1"))
		{
			this.name = this.scanner.nextLine();
			System.out.println("Select a name");
			this.name = this.scanner.nextLine();
			System.out.println("Select a last name");
			this.lastName = this.scanner.nextLine();
			System.out.println("Select one gender (MALE,FEMALE,OTHER)");
			option = this.scanner.next();
			while(!option.equalsIgnoreCase("MALE") && !option.equalsIgnoreCase("FEMALE") && !option.equalsIgnoreCase("OTHER"))
			{
				System.out.println("Error to selecting gender slect again (MALE,FEMALE,OTHER)");
				option = this.scanner.next();
			}
			if(option.equalsIgnoreCase("MALE"))
			{
				this.gender = Gender.MALE;
			}
			else if(option.equalsIgnoreCase("FEMALE"))
			{
				this.gender = Gender.FEMALE;
			}
			else
			{
				this.gender = Gender.OTHER;
			}
			try
			{
			System.out.println("Select a age");
			this.age = this.scanner.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Error selecting age");
				this.age = 0;
			}
			System.out.println("Select awards");
			this.awards  = this.scanner.next();
			System.out.println("Were do you save your director (serie/film)");
			option = this.scanner.next();
			while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
			{
				System.out.println("Error choose again (serie/film)");
				option = this.scanner.next();
			}
			if(option.equalsIgnoreCase("serie"))
			{
				this.statsFS.countSeries(this.serie);
				this.title= this.scanner.nextLine();
				System.out.println("Select the title of your serie");
				this.title = this.scanner.nextLine();
				for(Serie serie:this.serie)
				{
					if(this.title.equalsIgnoreCase(serie.getTitle()))
					{
						this.director = serie.getDirectors();
						this.director = this.menuDict.directorsAdd(this.director, this.name, this.lastName, this.gender, this.age, this.awards);
						serie.setDirectors(this.director);
					}
				}
			}
			else
			{
				this.statsFS.countFilms(this.film);
				this.title= this.scanner.nextLine();
				System.out.println("Select the title of your film");
				this.title = this.scanner.nextLine();
				for(Film film:this.film)
				{
					if(this.title.equalsIgnoreCase(film.getTitle()))
					{
						this.director = film.getDirectors();
						this.director = this.menuDict.directorsAdd(this.director, this.name, this.lastName, this.gender, this.age, this.awards);
						film.setDirectors(this.director);
					}
				}
			}

		}
		else if(option.equals("2"))
		{
			System.out.println("""
				You choose delete a director by his attributes, choose one:\s
				1.-Name\s
				2.-Last name\s
				3.-Gender\s
				4.-Age\s
				5.-Awards""");
			option = this.scanner.next();
			if(option.equalsIgnoreCase("name") || option.equals("1"))
			{
				this.name = this.scanner.nextLine();
				System.out.println("Select a name to search");
				this.name = this.scanner.next();
				System.out.println("were do you remove the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsDeleteByName(this.name, this.director);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsDeleteByName(this.name, this.director);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
			{
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the last name to search");
				this.lastName = this.scanner.nextLine();
				System.out.println("were do you remove the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsDeleteByLastName(this.lastName, this.director);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsDeleteByLastName(this.lastName, this.director);
							film.setDirectors(this.director);
						}
					}
				}
			}
			else if(option.equalsIgnoreCase("gender") || option.equals("3"))
			{
				System.out.println("Select the gender to search (MALE,FEMALE,OTHER");
				option = this.scanner.next();
				while(option.equalsIgnoreCase("MALE") && option.equalsIgnoreCase("FEMALE") && option.equalsIgnoreCase("OTHER"))
				{
					System.out.println("Error selecting gender, choose again (MALE,FEMALE,OTHER");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("MALE"))
				{
					this.gender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.gender = Gender.FEMALE;
				}
				else
				{
					this.gender = Gender.OTHER;
				}
				System.out.println("were do you remove the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsDeleteByGender(this.gender, this.director);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsDeleteByGender(this.gender, this.director);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("age") || option.equals("4"))
			{
				try
				{
					System.out.println("Select the age to search");
					this.age = this.scanner.nextInt();
				}catch(InputMismatchException e)
				{
					System.out.println("Error selecting age");
				}
				System.out.println("were do you remove the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsDeleteByAge(this.age, this.director);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsDeleteByAge(this.age, this.director);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
			{
				System.out.println("Select the awards to search");
				this.awards = this.scanner.next();
				System.out.println("were do you remove the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsDeleteByAwards(this.awards, this.director);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsDeleteByAwards(this.awards, this.director);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else
			{
				System.out.println("Error selecting option");
			}
		}
		else if(option.equals("3"))
		{
			System.out.println("""
				You choose modify a attribute of a director, choose one option:\s
				 \
				1.-Name\s
				2.-Last name\s
				3.-Gender\s
				4.-Age\s
				5.-Awards""");
			option = this.scanner.next();
			if(option.equalsIgnoreCase("name") || option.equals("1"))
			{
				this.name = this.scanner.nextLine();
				System.out.println("Select a name to search");
				this.name = this.scanner.nextLine();
				System.out.println("Select the new name");
				this.newName = this.scanner.nextLine();
				System.out.println("Were do you modify the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsModifyByName(this.director, this.name, this.newName);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsModifyByName(this.director, this.name, this.newName);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
			{
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the last name to search");
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the new last name");
				this.newLastName = this.scanner.nextLine();
				System.out.println("were do you modify the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsModifyByLastName(this.director, this.lastName, this.newLastName);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsModifyByLastName(this.director, this.lastName, this.newLastName);
							film.setDirectors(this.director);
						}
					}
				}
			}
			else if(option.equalsIgnoreCase("gender") || option.equals("3"))
			{
				System.out.println("Select the gender to search (MALE,FEMALE,OTHER");
				option = this.scanner.next();
				while(option.equalsIgnoreCase("MALE") && option.equalsIgnoreCase("FEMALE") && option.equalsIgnoreCase("OTHER"))
				{
					System.out.println("Error selecting gender, choose again (MALE,FEMALE,OTHER");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("MALE"))
				{
					this.gender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.gender = Gender.FEMALE;
				}
				else
				{
					this.gender = Gender.OTHER;
				}
				System.out.println("Select the new gender");
				option = this.scanner.next();
				if(option.equalsIgnoreCase("MALE"))
				{
					this.newGender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.newGender = Gender.FEMALE;
				}
				else
				{
					this.newGender = Gender.OTHER;
				}
				System.out.println("were do you modify the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsModifyByGender(this.director, this.gender, this.newGender);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsModifyByGender(this.director, this.gender, this.newGender);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("age") || option.equals("4"))
			{
				try
				{
					System.out.println("Select the age to search");
					this.age = this.scanner.nextInt();
					System.out.println("Select the new age");
					this.newAge = this.scanner.nextInt();
				}catch(InputMismatchException e)
				{
					System.out.println("Error selecting age");
				}
				System.out.println("were do you modify the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsModifyByAge(this.director, this.age, this.newAge);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsModifyByAge(this.director, this.age, this.newAge);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
			{
				System.out.println("Select the awards to search");
				this.awards = this.scanner.next();
				System.out.println("Select the new awards");
				this.newAwards = this.scanner.next();
				System.out.println("were do you modify the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.director = this.menuDict.directorsModifyByAward(this.director, this.awards, this.newAwards);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.director = this.menuDict.directorsModifyByAward(this.director, this.awards, this.newAwards);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else
			{
				System.out.println("Error selecting option");
			}
		}
		else if(option.equals("4"))
		{
			System.out.println("""
				You choose search a director by his attributes, choose one:\s
				1.-Name\s
				2.-Last name\s
				3.-Gender\s
				4.-Age\s
				5.-Awards""");
			option = this.scanner.next();
			if(option.equalsIgnoreCase("name") || option.equals("1"))
			{
				this.name = this.scanner.nextLine();
				System.out.println("Select a name to search");
				this.name = this.scanner.next();
				System.out.println("were do you search the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
						    this.menuDict.directorsSearchByName(this.director, this.name);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.menuDict.directorsSearchByName(this.director, this.name);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
			{
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the last name to search");
				this.lastName = this.scanner.nextLine();
				System.out.println("were do you search the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.menuDict.directorsSearchByLastName(this.director, this.lastName);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.menuDict.directorsSearchByLastName(this.director, this.lastName);
							film.setDirectors(this.director);
						}
					}
				}
			}
			else if(option.equalsIgnoreCase("gender") || option.equals("3"))
			{
				System.out.println("Select the gender to search (MALE,FEMALE,OTHER");
				option = this.scanner.next();
				while(option.equalsIgnoreCase("MALE") && option.equalsIgnoreCase("FEMALE") && option.equalsIgnoreCase("OTHER"))
				{
					System.out.println("Error selecting gender, choose again (MALE,FEMALE,OTHER");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("MALE"))
				{
					this.gender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.gender = Gender.FEMALE;
				}
				else
				{
					this.gender = Gender.OTHER;
				}
				System.out.println("were do you search the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.menuDict.directorsSearchByGender(this.director, this.gender);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.menuDict.directorsSearchByGender(this.director, this.gender);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("age") || option.equals("4"))
			{
				try
				{
					System.out.println("Select the age to search");
					this.age = this.scanner.nextInt();
				}catch(InputMismatchException e)
				{
					System.out.println("Error selecting age");
				}
				System.out.println("were do you search the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.menuDict.directorsSearchByAge(this.director, this.age);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
						    this.menuDict.directorsSearchByAge(this.director, this.age);
							film.setDirectors(this.director);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
			{
				System.out.println("Select the awards to search");
				this.awards = this.scanner.next();
				System.out.println("were do you search the director (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.director = serie.getDirectors();
							this.menuDict.directorsSearchByAwards(this.director, this.awards);
							serie.setDirectors(this.director);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.director = film.getDirectors();
							this.menuDict.directorsSearchByAwards(this.director, this.awards);
							film.setDirectors(this.director);
						}
					}
				}
			}
			else
			{
				System.out.println("Error selecting option");
			}
		}
		return option;
	}

	/**
	 * @return
	 */
	private String menuDataActors()
	{
		String option;
		System.out.println("""
			You choose menu of actors, select one option:\s
			1.-Add a actor\s
			2.-Delete a actor\s
			3.-Modify a actor\s
			4.-Search a actor\s
			5.-Back""");
		option = this.scanner.next();
		if(option.equals("1"))
		{
			this.name = this.scanner.nextLine();
			System.out.println("Select a name");
			this.name = this.scanner.nextLine();
			System.out.println("Select a last name");
			this.lastName = this.scanner.nextLine();
			System.out.println("Select one gender (MALE,FEMALE,OTHER)");
			option = this.scanner.next();
			while(!option.equalsIgnoreCase("MALE") && !option.equalsIgnoreCase("FEMALE") && !option.equalsIgnoreCase("OTHER"))
			{
				System.out.println("Error to selecting gender slect again (MALE,FEMALE,OTHER)");
				option = this.scanner.next();
			}
			if(option.equalsIgnoreCase("MALE"))
			{
				this.gender = Gender.MALE;
			}
			else if(option.equalsIgnoreCase("FEMALE"))
			{
				this.gender = Gender.FEMALE;
			}
			else
			{
				this.gender = Gender.OTHER;
			}
			try
			{
			System.out.println("Select a age");
			this.age = this.scanner.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("Error selecting age");
				this.age = 0;
			}
			System.out.println("Select awards");
			this.awards  = this.scanner.next();
			System.out.println("Were do you save your actor (serie/film)");
			option = this.scanner.next();
			while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
			{
				System.out.println("Error choose again (serie/film)");
				option = this.scanner.next();
			}
			if(option.equalsIgnoreCase("serie"))
			{
				this.statsFS.countSeries(this.serie);
				this.title= this.scanner.nextLine();
				System.out.println("Select the title of your serie");
				this.title = this.scanner.nextLine();
				for(Serie serie:this.serie)
				{
					if(this.title.equalsIgnoreCase(serie.getTitle()))
					{
						this.actor = serie.getActors();
						this.actor = this.menuAct.addActors(this.actor, this.name, this.lastName, this.gender, this.age, this.awards);
						serie.setActors(this.actor);
					}
				}
			}
			else
			{
				this.statsFS.countFilms(this.film);
				this.title= this.scanner.nextLine();
				System.out.println("Select the title of your film");
				this.title = this.scanner.nextLine();
				for(Film film:this.film)
				{
					if(this.title.equalsIgnoreCase(film.getTitle()))
					{
						this.actor = film.getActors();
						this.actor = this.menuAct.addActors(this.actor, this.name, this.lastName, this.gender, this.age, this.awards);
						film.setActors(this.actor);
					}
				}
			}

		}
		else if(option.equals("2"))
		{
			System.out.println("""
				You choose delete a actor by his attributes, choose one:\s
				1.-Name\s
				2.-Last name\s
				3.-Gender\s
				4.-Age\s
				5.-Awards""");
			option = this.scanner.next();
			if(option.equalsIgnoreCase("name") || option.equals("1"))
			{
				this.name = this.scanner.nextLine();
				System.out.println("Select a name to search");
				this.name = this.scanner.next();
				System.out.println("were do you remove the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.removeActorsByName(this.actor, this.name);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.removeActorsByName(this.actor, this.name);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
			{
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the last name to search");
				this.lastName = this.scanner.nextLine();
				System.out.println("were do you remove the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.removeActorsByLastName(this.actor, this.lastName);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.removeActorsByLastName(this.actor, this.lastName);
							film.setActors(this.actor);
						}
					}
				}
			}
			else if(option.equalsIgnoreCase("gender") || option.equals("3"))
			{
				System.out.println("Select the gender to search (MALE,FEMALE,OTHER");
				option = this.scanner.next();
				while(option.equalsIgnoreCase("MALE") && option.equalsIgnoreCase("FEMALE") && option.equalsIgnoreCase("OTHER"))
				{
					System.out.println("Error selecting gender, choose again (MALE,FEMALE,OTHER");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("MALE"))
				{
					this.gender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.gender = Gender.FEMALE;
				}
				else
				{
					this.gender = Gender.OTHER;
				}
				System.out.println("were do you remove the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.removeActorsByGender(this.actor, this.gender);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.removeActorsByGender(this.actor, this.gender);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("age") || option.equals("4"))
			{
				try
				{
					System.out.println("Select the age to search");
					this.age = this.scanner.nextInt();
				}catch(InputMismatchException e)
				{
					System.out.println("Error selecting age");
				}
				System.out.println("were do you remove the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.removeActorsByAge(this.actor, this.age);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.removeActorsByAge(this.actor, this.age);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
			{
				System.out.println("Select the awards to search");
				this.awards = this.scanner.next();
				System.out.println("were do you remove the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.removeActorsByAwards(this.actor, this.awards);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.removeActorsByAwards(this.actor, this.awards);
							film.setActors(this.actor);
						}
					}
				}

			}
			else
			{
				System.out.println("Error selecting option");
			}
		}
		else if(option.equals("3"))
		{
			System.out.println("""
				You choose modify a attribute of a actor, choose one option:\s
				 \
				1.-Name\s
				2.-Last name\s
				3.-Gender\s
				4.-Age\s
				5.-Awards""");
			option = this.scanner.next();
			if(option.equalsIgnoreCase("name") || option.equals("1"))
			{
				this.name = this.scanner.nextLine();
				System.out.println("Select a name to search");
				this.name = this.scanner.nextLine();
				System.out.println("Select the new name");
				this.newName = this.scanner.nextLine();
				System.out.println("Were do you modify the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.modifyActorsByName(this.actor, this.name, this.newName);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.modifyActorsByName(this.actor, this.name, this.newName);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
			{
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the last name to search");
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the new last name");
				this.newLastName = this.scanner.nextLine();
				System.out.println("were do you modify the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.modifyActorsByLastName(this.actor, this.lastName, this.newLastName);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.modifyActorsByLastName(this.actor, this.lastName, this.newLastName);
							film.setActors(this.actor);
						}
					}
				}
			}
			else if(option.equalsIgnoreCase("gender") || option.equals("3"))
			{
				System.out.println("Select the gender to search (MALE,FEMALE,OTHER");
				option = this.scanner.next();
				while(option.equalsIgnoreCase("MALE") && option.equalsIgnoreCase("FEMALE") && option.equalsIgnoreCase("OTHER"))
				{
					System.out.println("Error selecting gender, choose again (MALE,FEMALE,OTHER");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("MALE"))
				{
					this.gender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.gender = Gender.FEMALE;
				}
				else
				{
					this.gender = Gender.OTHER;
				}
				System.out.println("Select the new gender");
				option = this.scanner.next();
				if(option.equalsIgnoreCase("MALE"))
				{
					this.newGender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.newGender = Gender.FEMALE;
				}
				else
				{
					this.newGender = Gender.OTHER;
				}
				System.out.println("were do you modify the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.modifyActorsByGender(this.actor, this.gender, this.newGender);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.modifyActorsByGender(this.actor, this.gender, this.newGender);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("age") || option.equals("4"))
			{
				try
				{
					System.out.println("Select the age to search");
					this.age = this.scanner.nextInt();
					System.out.println("Select the new age");
					this.newAge = this.scanner.nextInt();
				}catch(InputMismatchException e)
				{
					System.out.println("Error selecting age");
				}
				System.out.println("were do you modify the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.modifyActorsByAge(this.actor, this.age, this.newAge);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.modifyActorsByAge(this.actor, this.age, this.newAge);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
			{
				System.out.println("Select the awards to search");
				this.awards = this.scanner.next();
				System.out.println("Select the new awards");
				this.newAwards = this.scanner.next();
				System.out.println("were do you modify the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.actor = this.menuAct.modifyActorsByAwards(this.actor, this.awards, this.newAwards);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.actor = this.menuAct.modifyActorsByAwards(this.actor, this.awards, this.newAwards);
							film.setActors(this.actor);
						}
					}
				}

			}
			else
			{
				System.out.println("Error selecting option");
			}
		}
		else if(option.equals("4"))
		{
			System.out.println("""
				You choose search a actor by his attributes, choose one:\s
				1.-Name\s
				2.-Last name\s
				3.-Gender\s
				4.-Age\s
				5.-Awards""");
			option = this.scanner.next();
			if(option.equalsIgnoreCase("name") || option.equals("1"))
			{
				this.name = this.scanner.nextLine();
				System.out.println("Select a name to search");
				this.name = this.scanner.next();
				System.out.println("were do you search the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
						    this.menuAct.searchActorsByName(this.actor, this.name);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.menuAct.searchActorsByName(this.actor, this.name);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
			{
				this.lastName = this.scanner.nextLine();
				System.out.println("Select the last name to search");
				this.lastName = this.scanner.nextLine();
				System.out.println("were do you search the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.menuAct.searchActorsByLastName(this.actor, this.lastName);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.menuAct.searchActorsByLastName(this.actor, this.lastName);
							film.setActors(this.actor);
						}
					}
				}
			}
			else if(option.equalsIgnoreCase("gender") || option.equals("3"))
			{
				System.out.println("Select the gender to search (MALE,FEMALE,OTHER");
				option = this.scanner.next();
				while(option.equalsIgnoreCase("MALE") && option.equalsIgnoreCase("FEMALE") && option.equalsIgnoreCase("OTHER"))
				{
					System.out.println("Error selecting gender, choose again (MALE,FEMALE,OTHER");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("MALE"))
				{
					this.gender = Gender.MALE;
				}
				else if(option.equalsIgnoreCase("FEMALE"))
				{
					this.gender = Gender.FEMALE;
				}
				else
				{
					this.gender = Gender.OTHER;
				}
				System.out.println("were do you search the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.menuAct.searchActorsByGender(this.actor, this.gender);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.menuAct.searchActorsByGender(this.actor, this.gender);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("age") || option.equals("4"))
			{
				try
				{
					System.out.println("Select the age to search");
					this.age = this.scanner.nextInt();
				}catch(InputMismatchException e)
				{
					System.out.println("Error selecting age");
				}
				System.out.println("were do you search the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.menuAct.searchActorsByAge(this.actor, this.age);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
						    this.menuAct.searchActorsByAge(this.actor, this.age);
							film.setActors(this.actor);
						}
					}
				}

			}
			else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
			{
				System.out.println("Select the awards to search");
				this.awards = this.scanner.next();
				System.out.println("were do you search the actor (serie/film)");
				option = this.scanner.next();
				while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
				{
					System.out.println("Error choose again (serie/film)");
					option = this.scanner.next();
				}
				if(option.equalsIgnoreCase("serie"))
				{
					this.statsFS.countSeries(this.serie);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your serie");
					this.title = this.scanner.nextLine();
					for(Serie serie:this.serie)
					{
						if(this.title.equalsIgnoreCase(serie.getTitle()))
						{
							this.actor = serie.getActors();
							this.menuAct.removeActorsByAwards(this.actor, this.awards);
							serie.setActors(this.actor);
						}
					}
				}
				else
				{
					this.statsFS.countFilms(this.film);
					this.title= this.scanner.nextLine();
					System.out.println("Select the title of your film");
					this.title = this.scanner.nextLine();
					for(Film film:this.film)
					{
						if(this.title.equalsIgnoreCase(film.getTitle()))
						{
							this.actor = film.getActors();
							this.menuAct.removeActorsByAwards(this.actor, this.awards);
							film.setActors(this.actor);
						}
					}
				}
			}
			else
			{
				System.out.println("Error selecting option");
			}
		}
		return option;
	}

	public void statsMenu()
	{
		System.out.println("""
			You choose menu of stats of the system, choose one option:
			1.-Stats of films and series\s
			2.-Stats of actors\s
			3.-Stats of directors\s
			4.-Stats of category\s
			5.-Stats of subttiles\s
			6.-Back""");
		String option = this.scanner.next();
		boolean endMenu = false;
		while(!endMenu)
		{
			switch(option)
			{
				case "1":
					System.out.println("""
						You choose stats of films and series, choose one option:\s
						1.-Show all films\s
						2.-Show all series\s
						3.-Show good films\s
						4.-Show bad films\s
						5.-Show good series\s
						6.-Show bad series\s
						7.-Show multi gender film\s
						8.-Show multi gender serie""");

					option = this.scanner.next();
					if(option.equals("1"))
					{
						System.out.println("Do you want see the number of films or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statsFS.numFilms(this.film);
						}
						else
						{
							this.statsFS.countFilms(this.film);
						}
					}
					else if(option.equals("2"))
					{
						System.out.println("Do you want see the number of series or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statsFS.numSeries(this.serie);
						}
						else
						{
							this.statsFS.countSeries(this.serie);
						}
					}
					else if(option.equals("3"))
					{
						this.goodFS.infoFilmsGoodRecommendation(this.film);
					}
					else if(option.equals("4"))
					{
						this.badFS.infoFilmsNegativeReviews(this.film);
					}
					else if(option.equals("5"))
					{
						this.goodFS.infoSeriesGoodRecommendation(this.serie);
					}
					else if(option.equals("6"))
					{
						this.badFS.infoSeriesNegativeReviews(this.serie);
					}
					else if(option.equals("7"))
					{
						this.genderFS.infoGenderFilm(this.film);
					}
					else if(option.equals("8"))
					{
						this.genderFS.infoGenderSerie(this.serie);
					}
					break;
				case  "2":
					System.out.println("""
						You choose stats of actors, choose one option\s
						1.-Show all actors\s
						2.-Show actors in films\s
						3.-Show actors in series\s
						4.-Show series that works 2 or more actors\s
						5.-Show films that works 2 or more actors""");
					option = this.scanner.next();
					if(option.equals("1"))
					{
						this.statsActor.allActors(this.serie, this.film);
					}
					else if(option.equals("2"))
					{
						System.out.println("Do you want see the number of series or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statsActor.numActorsFilms(this.film);
						}
						else
						{
							this.statsActor.showActorsFilms(this.film);
						}
					}
					else if(option.equals("3"))
					{
						System.out.println("Do you want see the number of series or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statsActor.numActorsSeries(this.serie);
						}
						else
						{
							this.statsActor.showActorsSeries(this.serie);
						}
					}
					else if(option.equals("4"))
					{
						this.statsActor.infoSeriesActors(this.serie);
					}
					else if(option.equals("5"))
					{
						this.statsActor.infoFilmsActors(this.film);
					}
					break;
				case "3":
					System.out.println("""
						You choose stats of directors, choose one option\s
						1.-Show all directors\s
						2.-Show directors in films\s
						3.-Show directors in series\s
						4.-Show series that works 2 or more directors\s
						5.-Show films that works 2 or more directors""");
					option = this.scanner.next();
					if(option.equals("1"))
					{
						this.statDirector.allDirectors(this.serie, this.film);
					}
					else if(option.equals("2"))
					{
						System.out.println("Do you want see the number of series or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statDirector.numDirectorsFilms(this.film);
						}
						else
						{
							this.statDirector.showDirectorsFilms(this.film);
						}
					}
					else if(option.equals("3"))
					{
						System.out.println("Do you want see the number of series or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statDirector.numDirectorsSeries(this.serie);
						}
						else
						{
							this.statDirector.showDirectorsSeries(this.serie);
						}
					}
					else if(option.equals("4"))
					{
						this.statDirector.infoSeriesDirectors(this.serie);
					}
					else if(option.equals("5"))
					{
						this.statDirector.infoFilmsDirectors(this.film);
					}
					break;
				case "4":
					System.out.println("""
						1.-Number of categories of films and series
						2.-Content of categories of films and series
						3.-Show all categories
						4.-Show the series with 2 or more categories
						5.-Show the films with 2 or more categories""");
					option = this.scanner.next();
					if(option.equals("1"))
					{
						System.out.println("Choose (series/films)");
						option = this.scanner.next();
						if(option.equalsIgnoreCase("series"))
						{
							this.statsCategory.countSeriesCategories(this.serie);
						}
						else
						{
							this.statsCategory.countFilmsCategories(this.film);
						}
					}
					else if(option.equals("1"))
					{
						System.out.println("Choose number of (series/films)");
						option = this.scanner.next();
						if(option.equalsIgnoreCase("series"))
						{
							this.statsCategory.countSeriesCategories(this.serie);
						}
						else
						{
							this.statsCategory.countFilmsCategories(this.film);
						}
					}
					else if(option.equals("2"))
					{
						System.out.println("Choose categories of (series/films)");
						option = this.scanner.next();
						if(option.equalsIgnoreCase("series"))
						{
							this.statsCategory.showSeriesCategories(this.serie);
						}
						else
						{
							this.statsCategory.showFilmCategories(this.film);
						}
					}
					else if(option.equals("3"))
					{
						this.statsCategory.countAllCategories(this.serie, this.film);
					}
					else if(option.equals("4"))
					{
						this.statsCategory.showSeriesWithTwoOrMoreCategories(this.serie);
					}
					else if(option.equals("5"))
					{
						this.statsCategory.showFilmsWithTwoOrMoreCategories(this.film);
					}
					break;
				case "5":
                    System.out.println("""
						You choose stats of subtitles from films and series, choose one option:\s
						1.-Show all subtitles from films\s
						2.-Show all subtitles from series\s
						3.-Show all subtitles\s
						4.-Show all films that contains 1 or more subtitles\s
						5.-Show all series that contains 1 or more subtitles\s
						""");
                    option = this.scanner.next();
					if(option.equals("1"))
					{
						System.out.println("Do you want see the number of subtitles or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statsSubtitles.countSubtitlesFilm(this.film);
						}
						else
						{
							this.statsSubtitles.showSubtitlesFilm(this.film);
						}
					}
                    else if(option.equals("2"))
                    {
						System.out.println("Do you want see the number of subtitles or the content (number/content)");
						option = this.scanner.next();
						while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
						{
							System.out.println("Error choosing a option, please choose again");
							option = this.scanner.next();
						}
						if(option.equalsIgnoreCase("number"))
						{
							this.statsSubtitles.countSubtitlesSerie(this.serie);
						}
						else
						{
							this.statsSubtitles.showSubtitlesSerie(this.serie);
						}
					}
                    else if(option.equals("3"))
                    {
                        this.statsSubtitles.countAllSubtitles(this.serie, this.film);
                    }
                    else if(option.equals("4"))
                    {
                        this.statsSubtitles.infoFilmSubtitles(this.film);
                    }
                    else if(option.equals("5"))
                    {
                        this.statsSubtitles.infoSerieSubtitles(this.serie);
                    }
					break;
				case "6":
					endMenu = true;
					break;
				default:
					System.out.println("Error selecting option");
			}
			if(!endMenu)
			{
				System.out.println("""
					Choose one option:
					1.-Stats of films and series\s
					2.-Stats of actors\s
					3.-Stats of directors\s
					4.-Stats of category\s
					5.-Stats of subtitles\s
					6.-Back""");
				option = this.scanner.next();
			}

		}
	}

	/**
	 * This method controls the operation of this program calling menu methods
	 * @param launcher the launcher object
	 */
	public void startStreaming(Launcher launcher)
	{
		//First menu were the user must to add a film or serie
		String option="";

		boolean endLoop=false;

		//--FIRST PRINT-------
		System.out.println("""
			Welcome to our streaming platform, in this moment you havent any film and serie register here\s
			so please choose one of this option:
			1.-Add a new film\s
			2.-Add a new serie""");
		option = this.scanner.next();

		//Inside this loop there is a switch were the user can add a film or movie
		while(!endLoop)
		{
		//This swicth contains the attributes of the class films and serie, that used to add a film or serie
			switch(option)
			{
				case "1":
				{
					//--------ADD NEW FILM---------------
					launcher.addNewFilm();
					break;
				}
				case "2":
				{
					//--------ADD NEW SERIE------------
					launcher.addNewSerie();
					break;
				}
				default:
				{
					System.out.println("Error introducing option");
				}
			}

			//-----ANOTHER SERIE--------
			endLoop=launcher.anotherSerie(endLoop);
		}

		endLoop = false;
		//-----THE MENU TO CONTROL SERIES FILMS MOVIES
		option=launcher.controlMenu();

		while(!endLoop)
		{
			switch(option)
			{
				case "1":
				{
					//----MENU OF FILM AND SERIES------
					launcher.menuFilmSeries();
					break;
				}
				case "2":
				{
					//----MENU OF DATA FILMS AND SERIES--------
					launcher.menuDataFilmSerie();
					break;
				}
				case "3":
				{
					//----STATS MENU-------
					launcher.statsMenu();
					break;
				}
				case "4":
				{
					//---EXIT--------
					endLoop = true;
					System.out.println("Thanks for use our application!");
					break;
				}
				default:
				{
					//------CASE DEFAULT------
					System.out.println("Error introducing option");
				}

			}
			if(!endLoop)
			{
				System.out.println("""
					You have this options:\s
					1.-Menu of films and serie\s
					2.-Menu of data of films and series\s
					3.-Menu of stats of the system\s
					4.-Exit""");
				System.out.println("Select one of them");
				option = this.scanner.next();
			}
		}



	}
}