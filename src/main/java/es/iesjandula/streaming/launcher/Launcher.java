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
 *-This class is responsible of execute the menus and control the logic of the entire project
 *
 * @author Pablo Elias
 * @author Javier
 * @author Alejandro
 *
 * @see NOTE: Class film and serie have arrays of actors,directors,categories,recommendations and subtitles so to save them
 * the user must use menu methods
 */
public class Launcher
{

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

	/**Attribute String adaptedLanguage[]: Language with which the movie or serie its translated*/
	private String[] adaptedLanguage = new String [0];

	/**Attribute int duration: Duration of the movie or serie*/
	private int duration;

	/**Attribute int views: Views that the movie or serie have*/
	private int views;

	/**Attribute String newTitle: His use is only to modify the old title*/
	private String newTitle;

	/**Attribute String newOriginalLanguage: His use is only to modify the old originalLanguage*/
	private String newOriginalLanguage;

	/**Attribute String adaptedLanguage[]: His use is only to modify the old adaptedLanguage*/
	private String[] newAdaptedLanguage = new String [0];

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
	

	/**Attribute newComment*/
	private String newComment;

	/**Attribute newAge*/
	private int newAge;

	/**Attribute newGender*/
	private Gender newGender;

	/**Attribute rate*/
	private RatingType rate;

	/**Attribute newRate*/
    private RatingType newRate;

	//Menu instances

	/** This instance controls the menu of actors */
	private MenuActors menuAct = new MenuActors();

	/** This instance controls the menu of directors*/
	private MenuDirectors menuDict = new MenuDirectors();

	/** This instance controls the menu of categories*/
	private MenuCategories menuCat = new MenuCategories();

	/** This instance controls the menu of recommendations*/
	private MenuRecommendations menuRec = new MenuRecommendations();

	/** This instance controls the menu of Subtitles*/
	private MenuSubtitles menuSub = new MenuSubtitles();

	/** This instance controls the menu of films and series*/
	private MenuFilmSeries menuFS = new MenuFilmSeries();

	/** This instance controls the stats of series and films*/
	private FilmsSerieStats statsFS = new FilmsSerieStats ();

	/** This instance controls the stats of the good films and series*/
	private FilmSeriesPositiveReviews goodFS = new FilmSeriesPositiveReviews();

	/** This instance controls the stats of the bad films and series*/
	private FilmSeriesNegativeReviews badFS = new FilmSeriesNegativeReviews();

	/** This instance controls the stats of the multi gender films and series*/
	private GenderStast genderFS = new GenderStast();

	/** This instance controls the stats of the actors*/
	private ActorStats statsActor = new ActorStats();

	/** This instance controls the stats of the directors*/
	private DirectorStats statDirector = new DirectorStats();

	/** This instance controls the stats of the categories*/
	private CategoryStats statsCategory = new CategoryStats();

	/** This instance controls the stats of the subtitles*/
	private SubtitleStats statsSubtitles = new SubtitleStats();

	/**
	 * Add new Films
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
	 * For add new series
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
	 * Another series selected
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
	 * The control menu
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

			}

			//---RETRY THE MENU FILM SERIES (PRINT)---
			option = this.retryMenuFilmSeriesPrint(endMenu, option);
		}
	}

	/**
	 * Rety the film and series menu
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
	 * search film or serie
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
	 * search film by attributes
	 * @return string with the information
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
	 * Film by adapted language
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
	 * search series by attributes
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
	 * search series by adapted language
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
	 * Modify attributes
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
			option = this.modifySerieAttribute();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---MODIFY A FILM ATTRIBUTE---
			option = this.modifyFilmAttribute();
		}
		return option;
	}

	/**
	 * modiy film by attribute
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
			this.modifyFilmTitle();
		}
		else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
		{
			//------MODIFY FILM ORIGINAL LANGUAGE-------
			this.modifyFilmOriginalLanguage();
		}
		else if(option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equalsIgnoreCase("3"))
		{
			//------MODIFY FILM ADAPTED LANGUAGE-------
			option = this.modifyFilmAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
		{
			//------MODIFY FILM DURATION-------
			this.modifyFilmDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equalsIgnoreCase("5"))
		{
			//------MODIFY FILM VIEWS-------
			this.modifyFilmViews();
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
	 * modify film by adapted language
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
	 * modify series attributes
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
			this.modifySerieTitle();
		}
		else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
		{
			//----MODIFY SERIE ORIGINAL LANGUAGE----
			this.modifySerieOriginalLanguage();
		}
		else if(option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equalsIgnoreCase("3"))
		{
			//----MODIFY SERIE ADAPTED LANGUAGE----
			option = this.modifySerieAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
		{
			//----MODIFY SERIE DURATION----
			this.modifySerieDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equalsIgnoreCase("5"))
		{
			//----MODIFY SERIE VIEWS----
			this.modifySerieViews();
		} else {
			System.out.println("Error to select option");
		}
		return option;
	}

	/**
	 * Modify series views
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
	 * modify series by adapted language
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
		System.out.println("Select the title to search");
		this.title = this.scanner.nextLine();
		System.out.println("Select the new title");
		this.newTitle = this.scanner.nextLine();
		this.serie = this.menuFS.seriesModificationForTitle(this.serie, this.title, this.newTitle);
	}

	/**
	 * delete serie or film
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
			option = this.deleteSerie();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---DELETE FILM---
			option = this.deleteFilm();
		}
		return option;
	}

	/**
	 * delete film
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
			this.deleteFilmByTitle();
		}
		else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
		{
			//---DELETE FILM BY ORIGINAL LANGUAGE---
			this.deleteFilmByOrigLanguage();
		}
		else if(option.equalsIgnoreCase("adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
		{
			//---DELETE FILM BY ADAPTED LANGUAGE---
			option = this.deleteFilmByAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equals("4"))
		{
			//---DELETE FILM BY DURATION---
			this.deleteFilmByDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equals("5"))
		{
			//---DELETE FILM BY VIEWS---
			this.deleteFilmByViews();

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
	 * Delete film by adapted language
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
	 * Delete series
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
			this.deleteSerieByTitle();
		}
		else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
		{
			//---DELETE SERIE BY ORIGINAL LANGUAGE---
			this.deleteSerieByOrigLanguage();
		}
		else if(option.equalsIgnoreCase("adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
		{
			//---DELETE SERIE BY ADAPTED LANGUAGE---
			option = this.deleteSerieByAdaptedLanguage();
		}
		else if(option.equalsIgnoreCase("duration") || option.equals("4"))
		{

			//---DELETE SERIE BY DURATION---
			this.deleteSerieByDuration();
		}
		else if(option.equalsIgnoreCase("views") || option.equals("5"))
		{
			//---DELETE SERIE BY VIEWS---
			this.deleteSerieByViews();

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
	 * Delete series by adapted language
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
	 * Delete series by original language
	 */
	private void deleteSerieByOrigLanguage()
	{
		this.originalLanguage = this.scanner.nextLine();
		System.out.println("Select the original language to search");
		this.originalLanguage = this.scanner.nextLine();
		this.serie = this.menuFS.seriesDropByOriginalLanguage(this.serie, this.originalLanguage);
	}

	/**
	 * Delete series by title
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
			option = this.addNewSerieSelected();
		}
		else if(option.equalsIgnoreCase("film"))
		{
			//---ADD NEW FILM SELECTION----
			option = this.addNewFilmSelected();
		} else {
			System.out.println("Error to selecting audiovisual");
		}
		return option;
	}

	/**
	 * Add new Film selection
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
	 * Add new series selected
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

	/**
	 * Menu data of films and series
	 */
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
					option = this.menuDataCategories();
					break;
				}
                case "4":
                {
                	//---MENU OF RECOMMENDATIONS---
                	option = this.menuOfRecommendations();
                	break;
                }
                case "5":
                {
                	//---MENU OF SUBTITLES---
    				option = this.menuOfSubtitles();
    				break;

                }
				case "6":
				{
					//---MENU EXIT---
					endMenu = true;
					break;
				}
				default:
				{
					System.out.println("Unknow option");
				}
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
	 * Menu of subtitles
	 * @return String with the info
	 */
	private String menuOfSubtitles()
	{
		String option;
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
			//---ADD SUBTITLE LANGUAGE---
		    option = this.addSubtitleLanguages();

		}
		else if(option.equals("2"))
		{
			//---DELETE SUBTITLE LANGUAGE---
		    option = this.deleteSubtitleLanguage();
		}
		else if(option.equals("3"))
		{
			//---MODIFY SUBTITLE LANGUAGE---
		    option = this.modifySubtitleLanguage();
		}
		else if(option.equals("4"))
		{
			//---SEARCH SUBTITLE LANGUAGE---
			option = this.searchSubtitleLanguage();

		}

		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Search subtitle language
	 * @return String whit information
	 */
	private String searchSubtitleLanguage()
	{
		String option;
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
		    for(Serie series:this.serie)
			{
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.subtitles = series.getSubtitles();
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
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.subtitles = films.getSubtitles();
		            this.menuSub.searchByLanguage(this.subtitles, this.language);
		        }
		    }
		}
		return option;
	}

	/**
	 * Modify subtitle language
	 * @return string with information
	 */
	private String modifySubtitleLanguage()
	{
		String newLanguage;
		String option;
		System.out.println("You choose modify the subtitle by his language");
		System.out.println("Select the language to search");
		this.language = this.scanner.next();

		System.out.println("Select the new language");
		newLanguage = this.scanner.next();

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

		    for(Serie series:this.serie)
		    {
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.subtitles = series.getSubtitles();
		            this.subtitles = this.menuSub.modifyLanguage(this.subtitles, this.language, newLanguage);
		            series.setSubtitles(this.subtitles);
		        }
		    }
		}
		else
		{
		    this.statsFS.countFilms(this.film);

		    this.title= this.scanner.nextLine();

		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();

		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.subtitles = films.getSubtitles();
		            this.subtitles = this.menuSub.modifyLanguage(this.subtitles, this.language, newLanguage);
		            films.setSubtitles(this.subtitles);
		        }
		    }
		}
		return option;
	}

	/**
	 * Delete subtitle language
	 * @return string with information
	 */
	private String deleteSubtitleLanguage()
	{
		String option;
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
		    for(Serie series:this.serie)
		    {
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.subtitles = series.getSubtitles();
		            this.subtitles = this.menuSub.removeSubtitles(this.subtitles, this.language);
		            series.setSubtitles(this.subtitles);
		        }
		    }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.subtitles = films.getSubtitles();
		            this.subtitles = this.menuSub.removeSubtitles(this.subtitles, this.language);
		            films.setSubtitles(this.subtitles);
		        }
		    }
		}
		return option;
	}

	/**
	 * Add subtitle language
	 * @return string with information
	 */
	private String addSubtitleLanguages()
	{
		String option;

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
		    for(Serie series:this.serie)
		        {
		        	if(this.title.equalsIgnoreCase(series.getTitle()))
		            {
		                this.subtitles = series.getSubtitles();
		                this.subtitles = this.menuSub.addSubtitles(this.subtitles,this.language);
		                series.setSubtitles(this.subtitles);
		            }
		        }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.subtitles = films.getSubtitles();
		            this.subtitles = this.menuSub.addSubtitles(this.subtitles, this.language);
		            films.setSubtitles(this.subtitles);
		        }
			}
		}
		return option;
	}

	/**
	 * Menu of recommendations
	 * @return String with the information
	 */
	private String menuOfRecommendations()
	{
		String option;
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
			//---ADD RECOMMENDATION---
			option = this.addRecommendation();

		}
		else if(option.equals("2"))
		{
		    //---DELETE RECOMMENDATION---
			option = this.deleteRecommendation();
		}
		else if(option.equals("3"))
		{
		    //---MODIFY RECOMMENDATION---
			option = this.modifyRecommendation();
		}
		else if(option.equals("4"))
		{
			//---SEARCH RECOMMENDATION---
			option = this.searchRecommendation();
		}
		return option;
	}

	/**
	 * Search recommendation
	 * @return String with the information
	 */
	private String searchRecommendation()
	{
		String option;
		System.out.println("""
			You choose search a recommendation by his attributes, choose one:\s
			1.-Rating\s
			2.-Comment\s
			""");
		option = this.scanner.next();
		if(option.equalsIgnoreCase("Rating") || option.equals("1"))
		{
			//---SEARCH RECOMMENDATION BY RATING---
			option = this.searchRecommendationByRating();

		}
		else if(option.equalsIgnoreCase("Comment") || option.equalsIgnoreCase("comment") || option.equals("2"))
		{
			//---SEARCH RECOMMENDATION BY COMMENT---
			option = this.searchRecommendationByComment();
		}
		else
		{
		    System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Search recommendation by comment
	 * @return string with the information
	 */
	private String searchRecommendationByComment()
	{
		String option;
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
		        for(Serie series:this.serie)
		        {
		                if(this.title.equalsIgnoreCase(series.getTitle()))
		                {
		                    this.recommendation = series.getRecommendation();
		                    this.menuRec.recommendationSearchByComment(this.recommendation, this.comment);
		                    series.setRecommendation(this.recommendation);
		                }
		        }
		}
		else
		{
		        this.statsFS.countFilms(this.film);
		        this.title= this.scanner.nextLine();
		        System.out.println("Select the title of your film");
		        this.title = this.scanner.nextLine();
		        for(Film films:this.film)
		        {
		                if(this.title.equalsIgnoreCase(films.getTitle()))
		                {
		                    this.recommendation = films.getRecommendation();
		                    this.menuRec.recommendationSearchByComment(this.recommendation, this.comment);
		                    films.setRecommendation(this.recommendation);
		                }
		        }
		}
		return option;
	}

	/**
	 * Search recommendation by Rating
	 * @return string with the information
	 */
	private String searchRecommendationByRating()
	{
		String option;
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
			//---SEARCH RECOMMENDATION ON SERIE---
		     this.searchRecommendationOnSerie();
		}
		else
		{
			//---SEARCH RECOMMENDATION ON FILM---
		     this.searchRecommendationOnFilm();
		}
		return option;
	}

	/**
	 *Search recommendation on film
	 */
	private void searchRecommendationOnFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();

		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();

		for(Film films:this.film)
		{
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.recommendation = films.getRecommendation();
		            this.menuRec.recommendationSearchByRate(this.recommendation, this.rate);
		            films.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 *Search recommendation on serie
	 */
	private void searchRecommendationOnSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();

		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();

		for(Serie series:this.serie)
		{
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.recommendation = series.getRecommendation();
		            this.menuRec.recommendationSearchByRate(this.recommendation, this.rate);
		            series.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 * Modify recommendation
	 * @return string with the information
	 */
	private String modifyRecommendation()
	{
		String option;
		System.out.println("""
			You choose modify an attribute of a recommendation, choose one option:\s
			 \
			1.-Rating\s
			2.-Comment\s
			""");
		option = this.scanner.next();

		if(option.equalsIgnoreCase("Rating") || option.equals("1"))
		{
			//---MODIFY RECOMMENDATION BY RATING---
			option = this.modifyRecommendationByRating();

		}
		else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("description") || option.equals("2"))
		{
			//---MODIFY RECOMMENDATION BY DESCRIPTION---
		    option = this.modifyRecommendationByDescription();
		}
		else
		{
		    System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Modify recommendation by description
	 * @return String with the information
	 */
	private String modifyRecommendationByDescription()
	{
		String option;
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
			//---MODIFI RECOMM BY DESCRIPTION SERIE---
			this.modifyRecommByDescSerie();
		}
		else
		{
			//---MODIFI RECOMM BY DESCRIPTION FILM---
		    this.modifyRecommByDescFilm();
		}
		return option;
	}

	/**
	 *Modify recommendation by description on film
	 */
	private void modifyRecommByDescFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.recommendation = films.getRecommendation();
		            this.recommendation = this.menuRec.recommendationModifyByComment(this.recommendation, this.comment, this.newComment);
		            films.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 *Modify recommendation by description on serie
	 */
	private void modifyRecommByDescSerie() {
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.recommendation = series.getRecommendation();
		            this.recommendation = this.menuRec.recommendationModifyByComment(this.recommendation, this.comment, this.newComment);
		            series.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 * Modify Recommendation by rating
	 * @return string with information
	 */
	private String modifyRecommendationByRating()
	{
		String option;
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
		        this.modifyRecommByRatingSerie();
		}
		else
		{
		        this.modifyRecommByRatingFilm();
		}
		return option;
	}

	/**
	 * Modify recommendation by rating film
	 */
	private void modifyRecommByRatingFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.recommendation = films.getRecommendation();
		            this.recommendation = this.menuRec.recommendationModifyByRate(this.recommendation, this.rate, this.newRate);
		            films.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 * Modify recommendation by rating Serie
	 */
	private void modifyRecommByRatingSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.recommendation = series.getRecommendation();
		            this.recommendation = this.menuRec.recommendationModifyByRate(this.recommendation, this.rate, this.newRate);
		            series.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 * Delete recommendation
	 * @return string with the information
	 */
	private String deleteRecommendation()
	{
		String option;
		System.out.println("""
			You choose delete a recommendation by its attributes, choose one:\s
			1.-Rating\s
			2.-Comment\s
			""");
		option = this.scanner.next();

		if(option.equalsIgnoreCase("Rating") || option.equals("1"))
		{
			//---DELETE RECOMENTATION BY RATING---
			option = this.deleteRecommendationByRating();

		}
		else if(option.equalsIgnoreCase("Comment") || option.equalsIgnoreCase("comment") || option.equals("2"))
		{
			//---DELETE RECOMENTATION BY COMMENT---
			option = this.deleteRecommendationByComment();
		}
		else
		{
		    System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Delete recommendation by comment
	 * @return String with the information
	 */
	private String deleteRecommendationByComment()
	{
		String option;
		//---SELECT THE COMMENT TO DELETE---
		option = this.selectCommentToDelete();

		while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		{
		    System.out.println("Error choose again (serie/film)");
		    option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("serie"))
		{
			//---DELETE RECOMMENDATION BY SERIE COMMENT---
		    this.deleteRecommendationSerieByComment();
		}
		else
		{
			//---DELETE RECOMMENDATION BY FILM COMMENT---
		    this.deleteRecommendationFilmByComment();
		}
		return option;
	}

	/**
	 * Delete recommendation by rating
	 * @return string with information
	 */
	private String deleteRecommendationByRating()
	{
		String option;
		//---SELECT THE RATING TO DELETE---
		this.selectRating();

		System.out.println("where do you remove the recommendation (serie/film)");
		option = this.scanner.next();

		while(!option.equalsIgnoreCase("film") && !option.equals("serie"))
		{
		    System.out.println("Error choose again (serie/film)");
		    option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("serie"))
		{
			//---DELETE RECOMMENDATION BY SERIE RATING---
		    this.deleteRecommendationSerieByRating();
		}
		else
		{
			//---DELETE RECOMMENDATION BY FILM RATING---
		    this.deleteRecommendationFilmByRating();
		}
		return option;
	}

	/**
	 * Select the comment to delete
	 * @return string with information
	 */
	private String selectCommentToDelete()
	{
		String option;
		this.comment = this.scanner.nextLine();
		System.out.println("Select the comment to search");
		this.comment = this.scanner.nextLine();
		System.out.println("were do you remove the description (serie/film)");
		option = this.scanner.next();
		return option;
	}

	/**
	 *Select the rating
	 */
	private void selectRating()
	{
		String option;
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
	}

	/**
	 *Delete recommendation from film by comment
	 */
	private void deleteRecommendationFilmByComment()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.recommendation = films.getRecommendation();
		            this.recommendation = this.menuRec.recommendationDeleteByComment(this.recommendation, this.comment);
		            films.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 *Delete recommendation from series by comment
	 */
	private void deleteRecommendationSerieByComment()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.recommendation = series.getRecommendation();
		            this.recommendation = this.menuRec.recommendationDeleteByComment(this.recommendation, this.comment);
		            series.setRecommendation(this.recommendation);
		        }
		}
	}

	/**
	 *Delete recommendation of film by rating
	 */
	private void deleteRecommendationFilmByRating()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
	        if(this.title.equalsIgnoreCase(films.getTitle()))
	        {
	            this.recommendation = films.getRecommendation();
	            this.recommendation = this.menuRec.recommendationDeleteByRate(this.recommendation, this.rate);
	            films.setRecommendation(this.recommendation);
	        }
		}
	}

	/**
	 * Delete recommendation from serie by rating
	 */
	private void deleteRecommendationSerieByRating()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
	        if(this.title.equalsIgnoreCase(series.getTitle()))
	        {
	            this.recommendation = series.getRecommendation();
	            this.recommendation = this.menuRec.recommendationDeleteByRate(this.recommendation, this.rate);
	            series.setRecommendation(this.recommendation);
	        }
		}
	}

	/**
	 * Add recommendation
	 * @return string with the information
	 */
	private String addRecommendation()
	{
		String option;

		//---SELECT THE RATING---
		this.selectRating();

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

	        for(Serie series:this.serie)
	        {
                if(this.title.equalsIgnoreCase(series.getTitle()))
                {
                    this.recommendation = series.getRecommendation();
                    this.recommendation = this.menuRec.addRecommendation(this.recommendation, this.rate, this.comment);
                    series.setRecommendation(this.recommendation);
                }
	        }
		}
		else
		{
	        this.statsFS.countFilms(this.film);
	        this.title= this.scanner.nextLine();
	        System.out.println("Select the title of your film");
	        this.title = this.scanner.nextLine();

	        for(Film films:this.film)
	        {
                if(this.title.equalsIgnoreCase(films.getTitle()))
                {
                        this.recommendation = films.getRecommendation();
                        this.recommendation = this.menuRec.addRecommendation(this.recommendation, this.rate, this.comment);
                        films.setRecommendation(this.recommendation);
                }
	        }
		}
		return option;
	}

	/**
	 * Menu of data categories
	 * @return string with the information
	 */
	private String menuDataCategories()
	{
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
			//--ADD CATEGORY---
	        option = this.addCategory();
		}
		else if(option.equals("2"))
		{
			//---DELETE CATEGORY---
		    option = this.deleteCategory();
		}
		else if(option.equals("3"))
		{
			//---MODIFY CATEGORY---
		    option = this.modifyCategory();
        }
        else if(option.equals("4"))
        {
        	//---SEARCH CATEGORY---
		    option = this.searchCategory();
		}
		return option;
	}

	/**
	 * Search category
	 * @return string with information
	 */
	private String searchCategory()
	{
		String option;
		System.out.println("""
			You choose search a category by his attributes, choose one:\s
			1.-Name\s
			2.-Description\s
			""");
		option = this.scanner.next();
		if(option.equalsIgnoreCase("name") || option.equals("1"))
		{
			//---SEARCH CATEGORY BY NAME---
	        option = this.searchCategoryByName();
		}
		else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("description") || option.equals("2"))
		{
			//---SEARCH CATEGORY BY DESCRIPTION---
			option = this.searchCategoryByDescription();
		}
		else
		{
		    System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Search category by description
	 * @return string with the information
	 */
	private String searchCategoryByDescription()
	{
		String option;
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
	        for(Serie series:this.serie)
	        {
                if(this.title.equalsIgnoreCase(series.getTitle()))
                {
                    this.category = series.getCategory();
                    this.menuCat.searchCategoryByDescription(this.category, this.description);
                    series.setCategory(this.category);
                }
	        }
		}
		else
		{
	        this.statsFS.countFilms(this.film);
	        this.title= this.scanner.nextLine();
	        System.out.println("Select the title of your film");
	        this.title = this.scanner.nextLine();
	        for(Film films:this.film)
	        {
                if(this.title.equalsIgnoreCase(films.getTitle()))
                {
                    this.category = films.getCategory();
                    this.menuCat.searchCategoryByDescription(this.category, this.description);
                    films.setCategory(this.category);
                }
	        }
		}
		return option;
	}

	/**
	 * Search category by name
	 * @return string with information
	 */
	private String searchCategoryByName()
	{
		String option;
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
	        for(Serie series:this.serie)
	        {
                if(this.title.equalsIgnoreCase(series.getTitle()))
                {
                    this.category = series.getCategory();
                    this.menuCat.searchCategoryByName(this.category, this.name);
                    series.setCategory(this.category);
                }
	        }
		}
		else
		{
	        this.statsFS.countFilms(this.film);
	        this.title= this.scanner.nextLine();
	        System.out.println("Select the title of your film");
	        this.title = this.scanner.nextLine();

	        for(Film films:this.film)
	        {
                if(this.title.equalsIgnoreCase(films.getTitle()))
                {
                    this.category = films.getCategory();
                    this.menuCat.searchCategoryByName(this.category, this.name);
                    films.setCategory(this.category);
                }
	        }
		}
		return option;
	}

	/**
	 * Modify category
	 * @return string with the infromation
	 */
	private String modifyCategory()
	{
		String option;
		System.out.println("""
			You choose modify a attribute of a category, choose one option:\s
			 \
			1.-Name\s
			2.-Description\s
			""");
		option = this.scanner.next();
		if(option.equalsIgnoreCase("name") || option.equals("1"))
		{
			//---MODIFY CATEGORY BY NAME---
			option = this.modifyCategoryByName();
		}
		else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("description") || option.equals("2"))
		{
			//---MODIFY CATEGORY BY DESCRIPTION---
		    option = this.modifyCategoryByDescription();
		}
		else
		{
		    System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Modify category by description
	 * @return string with the information
	 */
	private String modifyCategoryByDescription()
	{
		String newDescription;
		String option;
		this.description = this.scanner.nextLine();
		System.out.println("Select the description to search");
		this.description = this.scanner.nextLine();

		System.out.println("Select the new description");
		newDescription = this.scanner.nextLine();

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
		        for(Serie series:this.serie)
		        {
	                if(this.title.equalsIgnoreCase(series.getTitle()))
	                {
                        this.category = series.getCategory();
                        this.category = this.menuCat.modifyCategoryByDescription(this.category, this.description, newDescription);
                        series.setCategory(this.category);
	                }
		        }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
	                this.category = films.getCategory();
	                this.category = this.menuCat.modifyCategoryByDescription(this.category, this.description, newDescription);
	                films.setCategory(this.category);
		        }
		    }
		}
		return option;
	}

	/**
	 * Modify category by description
	 * @return String with the information
	 */
	private String modifyCategoryByName()
	{
		String option;
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
	        for(Serie series:this.serie)
	        {
	            if(this.title.equalsIgnoreCase(series.getTitle()))
	            {
	                this.category = series.getCategory();
	                this.category = this.menuCat.modifyCategoryByName(this.category, this.name, this.newName);
	                series.setCategory(this.category);
	            }
	        }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.category = films.getCategory();
		            this.category = this.menuCat.modifyCategoryByName(this.category, this.name, this.newName);
		            films.setCategory(this.category);
		        }
		    }
		}
		return option;
	}

	/**
	 * Delete category
	 * @return String with the information
	 */
	private String deleteCategory()
	{
		String option;
		System.out.println("""
			You choose delete a Category by its attributes, choose one:\s
			1.-Name\s
			2.-Description\s
			""");
		option = this.scanner.next();

		if(option.equalsIgnoreCase("name") || option.equals("1"))
		{
			//---DELETE CATEGORY BY NAME---
		    option = this.deleteCategoryByName();
		}
		else if(option.equalsIgnoreCase("Description") || option.equalsIgnoreCase("description") || option.equals("2"))
		{
		    option = this.deleteCategoryByDescription();
		}
		else
		{
	        System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Delete category by description
	 * @return string with the information
	 */
	private String deleteCategoryByDescription()
	{
		String option;
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
		    for(Serie series:this.serie)
		    {
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.category = series.getCategory();
		            this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		            series.setCategory(this.category);
		        }
		    }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.category = films.getCategory();
		            this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		            films.setCategory(this.category);
		        }
		    }
		}
		return option;
	}

	/**
	 * Delete category by name
	 * @return string with the information
	 */
	private String deleteCategoryByName()
	{
		String option;
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
		    for(Serie series:this.serie)
		    {
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.category = series.getCategory();
		            this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		            series.setCategory(this.category);
		        }
		    }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.category = films.getCategory();
		            this.category = this.menuCat.deleteCategoryByName(this.name, this.category);
		            films.setCategory(this.category);
		        }
		    }
		}
		return option;
	}

	/**
	 * Add category
	 * @return string with the information
	 */
	private String addCategory()
	{
		String option;
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
		    for(Serie series:this.serie)
		    {
		        if(this.title.equalsIgnoreCase(series.getTitle()))
		        {
		            this.category = series.getCategory();
		            this.category = this.menuCat.addCategory(this.category, this.name, this.description);
		            series.setCategory(this.category);
		        }
		    }
		}
		else
		{
		    this.statsFS.countFilms(this.film);
		    this.title= this.scanner.nextLine();
		    System.out.println("Select the title of your film");
		    this.title = this.scanner.nextLine();
		    for(Film films:this.film)
		    {
		        if(this.title.equalsIgnoreCase(films.getTitle()))
		        {
		            this.category = films.getCategory();
		            this.category = this.menuCat.addCategory(this.category, this.name, this.description);
		            films.setCategory(this.category);
		        }
		    }
		}
		return option;
	}

	/**
	 * Menu data of directors
	 * @return string with the information
	 */
	private String menuDataDirectors()
	{
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
			//--ADD-DIRECTOR---
			option = this.addDirector();

		}
		else if(option.equals("2"))
		{
			//---DELETE-DIRECTOR---
			option = this.deleteDirector();
		}
		else if(option.equals("3"))
		{
			//---MODIFY DIRECTOR---
			option = this.modifyDirector();
		}
		else if(option.equals("4"))
		{
			option = this.searchDirector();
		}
		return option;
	}

	/**
	 * Search director
	 * @return string with the information
	 */
	private String searchDirector()
	{
		String option;
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
			//---SEARCH DIRECTOR BY NAME---
			option = this.searchDirectorByName();
		}
		else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
		{
			//---SEARCH DIRECTOR BY LAST NAME---
			option = this.searchDirectorByLastName();
		}
		else if(option.equalsIgnoreCase("gender") || option.equals("3"))
		{
			//---SEARCH DIRECTOR BY GENDER---
			option = this.searchDirectorByGender();

		}
		else if(option.equalsIgnoreCase("age") || option.equals("4"))
		{
			//---SEARCH DIRECTOR BY AGE---
			option = this.searchDirectorByAge();

		}
		else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
		{
			//---SEARCH DIRECTOR BY AWARDS---
			option = this.searchDirectorByAwards();
		}
		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Search director by awards
	 * @return String with the information
	 */
	private String searchDirectorByAwards()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.menuDict.directorsSearchByAwards(this.director, this.awards);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.menuDict.directorsSearchByAwards(this.director, this.awards);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Search director by age
	 * @return string with the information
	 */
	private String searchDirectorByAge()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.menuDict.directorsSearchByAge(this.director, this.age);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
				    this.menuDict.directorsSearchByAge(this.director, this.age);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Search director by the information
	 * @return string with the information
	 */
	private String searchDirectorByGender()
	{
		String option;
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
			//---SEARCH DIRECTO BY GENDER ON SERIE---
			this.searchDirectorByGenderSerie();
		}
		else
		{
			//---SEARCH DIRECTOR BY GENDER ON FILM---
			this.searchDirectorByGenderFilm();
		}
		return option;
	}

	/**
	 * Search director by gender on films
	 */
	private void searchDirectorByGenderFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.director = films.getDirectors();
				this.menuDict.directorsSearchByGender(this.director, this.gender);
				films.setDirectors(this.director);
			}
		}
	}

	/**
	 * Search director by gender on Series
	 */
	private void searchDirectorByGenderSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.director = series.getDirectors();
				this.menuDict.directorsSearchByGender(this.director, this.gender);
				series.setDirectors(this.director);
			}
		}
	}

	/**
	 * Search director by Last Name
	 * @return String with the information
	 */
	private String searchDirectorByLastName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.menuDict.directorsSearchByLastName(this.director, this.lastName);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.menuDict.directorsSearchByLastName(this.director, this.lastName);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Search director by name
	 * @return string with the information
	 */
	private String searchDirectorByName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
				    this.menuDict.directorsSearchByName(this.director, this.name);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.menuDict.directorsSearchByName(this.director, this.name);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Modify director
	 * @return string with the information
	 */
	private String modifyDirector()
	{
		String option;
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
			option = this.modifyDirectorByName();

		}
		else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("lastName") || option.equals("2"))
		{
			option = this.modifyDirectorByLastName();
		}
		else if(option.equalsIgnoreCase("gender") || option.equals("3"))
		{
			option = this.modifyDirectorByGender();

		}
		else if(option.equalsIgnoreCase("age") || option.equals("4"))
		{
			option = this.modifyDirectorByAge();

		}
		else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
		{
			option = this.modifyDirectorByAwards();
		}
		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Modify director by awards
	 * @return string with the information
	 */
	private String modifyDirectorByAwards()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsModifyByAward(this.director, this.awards, this.newAwards);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your serie");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsModifyByAward(this.director, this.awards, this.newAwards);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Modify director by age
	 * @return string with the information
	 */
	private String modifyDirectorByAge()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsModifyByAge(this.director, this.age, this.newAge);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsModifyByAge(this.director, this.age, this.newAge);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Modify director by gender
	 * @return string with the information
	 */
	private String modifyDirectorByGender()
	{
		String option;
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
			//---MODIFY DIRECTOR GENDER ON SERIE---
			this.modifyDirectorByGenderSerie();
		}
		else
		{
			//---MODIFY DIRECTOR GENDER ON FILM---
			this.modifyDirectorByGenderFilm();
		}
		return option;
	}

	/**
	 * Modify Director by gender on films
	 */
	private void modifyDirectorByGenderFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.director = films.getDirectors();
				this.director = this.menuDict.directorsModifyByGender(this.director, this.gender, this.newGender);
				films.setDirectors(this.director);
			}
		}
	}

	/**
	 *  Modify Director by gender on series
	 */
	private void modifyDirectorByGenderSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.director = series.getDirectors();
				this.director = this.menuDict.directorsModifyByGender(this.director, this.gender, this.newGender);
				series.setDirectors(this.director);
			}
		}
	}

	/**
	 * Modify director by information
	 * @return string with the information
	 */
	private String modifyDirectorByLastName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsModifyByLastName(this.director, this.lastName, this.newLastName);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsModifyByLastName(this.director, this.lastName, this.newLastName);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Modify director by name
	 * @return string with the information
	 */
	private String modifyDirectorByName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsModifyByName(this.director, this.name, this.newName);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsModifyByName(this.director, this.name, this.newName);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Delete director
	 * @return string with the information
	 */
	private String deleteDirector()
	{
		String option;
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
			//---DELETE DIRECTOR BY NAME---
			option = this.deleteDirectorByName();

		}
		else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
		{
			//---DELETE DIRECTOR BY LAST NAME---
			option = this.deleteDirectorByLastName();
		}
		else if(option.equalsIgnoreCase("gender") || option.equals("3"))
		{
			//---DELETE DIRECTOR BY GENDER---
			option = this.deleteDirectorByGender();

		}
		else if(option.equalsIgnoreCase("age") || option.equals("4"))
		{
			//---DELETE DIRECTOR BY AGE---
			option = this.deleteDirectorByAge();

		}
		else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
		{
			//---DELETE DIRECTOR BY AWARDS---
			option = this.deleteDirectorByAwards();

		}
		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Delete director by awards
	 * @return string with the information
	 */
	private String deleteDirectorByAwards()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsDeleteByAwards(this.awards, this.director);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsDeleteByAwards(this.awards, this.director);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Delete director by age
	 * @return the string with the information
	 */
	private String deleteDirectorByAge()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsDeleteByAge(this.age, this.director);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsDeleteByAge(this.age, this.director);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Delete director by gender
	 * @return string with the information
	 */
	private String deleteDirectorByGender()
	{
		String option;
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
			//---DELETE DIRECTOR BY GENDER ON SERIES---
			this.deleteDirectorByGenderSerie();
		}
		else
		{
			//---DELETE DIRECTOR BY GENDER ON FILM---
			this.deleteDirectorByGenderFilm();
		}
		return option;
	}

	/**
	 *Delete director by gender on the film
	 */
	private void deleteDirectorByGenderFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.director = films.getDirectors();
				this.director = this.menuDict.directorsDeleteByGender(this.gender, this.director);
				films.setDirectors(this.director);
			}
		}
	}

	/**
	 *Delete director by gender on the serie
	 */
	private void deleteDirectorByGenderSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.director = series.getDirectors();
				this.director = this.menuDict.directorsDeleteByGender(this.gender, this.director);
				series.setDirectors(this.director);
			}
		}
	}

	/**
	 * Delete director by information
	 * @return string with the information
	 */
	private String deleteDirectorByLastName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsDeleteByLastName(this.lastName, this.director);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsDeleteByLastName(this.lastName, this.director);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Delete director by name
	 * @return string with the information
	 */
	private String deleteDirectorByName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.director = series.getDirectors();
					this.director = this.menuDict.directorsDeleteByName(this.name, this.director);
					series.setDirectors(this.director);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.director = films.getDirectors();
					this.director = this.menuDict.directorsDeleteByName(this.name, this.director);
					films.setDirectors(this.director);
				}
			}
		}
		return option;
	}

	/**
	 * Add director
	 * @return string with the information
	 */
	private String addDirector()
	{
		String option;
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
			//---ADD DIRECTOR ON SERIE---
			this.addDirectorSerie();
		}
		else
		{
			//---ADD DIRECTOR ON FILM---
			this.addDirectorFilm();
		}
		return option;
	}

	/**
	 * Add director to film
	 */
	private void addDirectorFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.director = films.getDirectors();
				this.director = this.menuDict.directorsAdd(this.director, this.name, this.lastName, this.gender, this.age, this.awards);
				films.setDirectors(this.director);
			}
		}
	}

	/**
	 * Add director to serie
	 */
	private void addDirectorSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.director = series.getDirectors();
				this.director = this.menuDict.directorsAdd(this.director, this.name, this.lastName, this.gender, this.age, this.awards);
				series.setDirectors(this.director);
			}
		}
	}

	/**
	 * Menu data of actors
	 * @return string with the information
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
			//---ADD ACTOR---
			option = this.addActor();

		}
		else if(option.equals("2"))
		{
			//---DELETE ACTOR---
			option = this.deleteActor();
		}
		else if(option.equals("3"))
		{
			//---MODIFY ACTOR---
			option = this.modifyActor();
		}
		else if(option.equals("4"))
		{
			//---SEARCH ACTOR---
			option = this.searchActor();
		}
		return option;
	}

	/**
	 * Search an actor
	 * @return string with the information
	 */
	private String searchActor()
	{
		String option;
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
			//---SEARCH DIRECTOR BY NAME---
			option = this.searchActorByName();

		}
		else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
		{
			//---SEARCH DIRECTOR BY LAST NAME---
			option = this.searchActorByLastName();
		}
		else if(option.equalsIgnoreCase("gender") || option.equals("3"))
		{
			//---SEARCH DIRECTOR BY GENDER---
			option = this.searchActorByGender();
		}
		else if(option.equalsIgnoreCase("age") || option.equals("4"))
		{
			//---SEARCH DIRECTOR BY AGE---
			option = this.searchActortorByAge();

		}
		else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
		{
			//---SEARCH DIRECTOR BY AWARDS---
			option = this.searchActorByAwards();
		}
		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Search an actor by awards
	 * @return string with the information
	 */
	private String searchActorByAwards()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.menuAct.removeActorsByAwards(this.actor, this.awards);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.menuAct.removeActorsByAwards(this.actor, this.awards);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Search an actor by age
	 * @return string with the string information
	 */
	private String searchActortorByAge()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.menuAct.searchActorsByAge(this.actor, this.age);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
				    this.menuAct.searchActorsByAge(this.actor, this.age);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Search an actor by gender
	 * @return string with the information
	 */
	private String searchActorByGender()
	{
		String option;
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
			//---SEARCH ACTOR BY GENDER ON SERIE---
			this.searchActorByGenderSerie();
		}
		else
		{
			//---SEARCH ACTOR BY GENDER ON FILM---
			this.searchActorByGenderFilm();
		}
		return option;
	}

	/**
	 *Search actors by gender on film
	 */
	private void searchActorByGenderFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.actor = films.getActors();
				this.menuAct.searchActorsByGender(this.actor, this.gender);
				films.setActors(this.actor);
			}
		}
	}

	/**
	 *Search actors by gender on Serie
	 */
	private void searchActorByGenderSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.actor = series.getActors();
				this.menuAct.searchActorsByGender(this.actor, this.gender);
				series.setActors(this.actor);
			}
		}
	}

	/**
	 * Search an actor by Last Name
	 * @return string with the information
	 */
	private String searchActorByLastName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.menuAct.searchActorsByLastName(this.actor, this.lastName);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.menuAct.searchActorsByLastName(this.actor, this.lastName);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Search an actor by Name
	 * @return string with information
	 */
	private String searchActorByName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
				    this.menuAct.searchActorsByName(this.actor, this.name);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.menuAct.searchActorsByName(this.actor, this.name);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Modify an actor
	 * @return string infromation
	 */
	private String modifyActor()
	{
		String option;
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
			//---MODIY ACTOR BY NAME---
			option = this.modifyActorByName();

		}
		else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
		{
			//---MODIY ACTOR BY LAST NAME---
			option = this.modifyActorByLastName();
		}
		else if(option.equalsIgnoreCase("gender") || option.equals("3"))
		{
			//---MODIY ACTOR BY GENDER---
			option = this.modifyActorByGender();
		}
		else if(option.equalsIgnoreCase("age") || option.equals("4"))
		{
			//---MODIY ACTOR BY AGE---
			option = this.modifyActorByAge();

		}
		else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
		{
			//---MODIY ACTOR BY AWARDS---
			option = this.modifyActorByAwards();
		}
		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Modify an actor by awards
	 * @return string with the information
	 */
	private String modifyActorByAwards()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.modifyActorsByAwards(this.actor, this.awards, this.newAwards);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your serie");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.modifyActorsByAwards(this.actor, this.awards, this.newAwards);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Modify an actor by age
	 * @return string with the information
	 */
	private String modifyActorByAge()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.modifyActorsByAge(this.actor, this.age, this.newAge);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.modifyActorsByAge(this.actor, this.age, this.newAge);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Modify an actor by gender
	 * @return string with the information
	 */
	private String modifyActorByGender()
	{
		String option;
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
			//---MODIFY ACTOR BY GENDER ON SERIES---
			this.modifyActorByGenderSerie();
		}
		else
		{
			//---MODIFY ACTOR BY GENDER ON FILM---
			this.modifyActorByGenderFilm();
		}
		return option;
	}

	/**
	 *Modify actor by gender on film
	 */
	private void modifyActorByGenderFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.actor = films.getActors();
				this.actor = this.menuAct.modifyActorsByGender(this.actor, this.gender, this.newGender);
				films.setActors(this.actor);
			}
		}
	}

	/**
	 *Modify actor by gender on series
	 */
	private void modifyActorByGenderSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.actor = series.getActors();
				this.actor = this.menuAct.modifyActorsByGender(this.actor, this.gender, this.newGender);
				series.setActors(this.actor);
			}
		}
	}

	/**
	 * Modify an actor by last name
	 * @return string with the information
	 */
	private String modifyActorByLastName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.modifyActorsByLastName(this.actor, this.lastName, this.newLastName);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.modifyActorsByLastName(this.actor, this.lastName, this.newLastName);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Modify an actor by Name
	 * @return string with the information
	 */
	private String modifyActorByName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.modifyActorsByName(this.actor, this.name, this.newName);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.modifyActorsByName(this.actor, this.name, this.newName);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Delete an actor
	 * @return string with the information
	 */
	private String deleteActor()
	{
		String option;
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
			//---DELETE ACTOR BY NAME---
			option = this.deleteActorByName();

		}
		else if(option.equalsIgnoreCase("Last name") || option.equalsIgnoreCase("LastName") || option.equals("2"))
		{
			//---DELETE ACTOR BY LAST NAME---
			option = this.deleteActorByLastName();
		}
		else if(option.equalsIgnoreCase("gender") || option.equals("3"))
		{
			//---DELETE ACTOR BY GENDER---
			option = this.deleteActorByGender();

		}
		else if(option.equalsIgnoreCase("age") || option.equals("4"))
		{
			//---DELETE ACTOR BY AGE---
			option = this.deleteActorByAge();

		}
		else if(option.equalsIgnoreCase("awards") || option.equalsIgnoreCase("5"))
		{
			//---DELETE ACTOR BY AWARDS---
			option = this.deleteActorByAwards();

		}
		else
		{
			System.out.println("Error selecting option");
		}
		return option;
	}

	/**
	 * Delete an actor by awards
	 * @return string with the information
	 */
	private String deleteActorByAwards()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.removeActorsByAwards(this.actor, this.awards);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.removeActorsByAwards(this.actor, this.awards);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Delete an actor by age
	 * @return string with  the information
	 */
	private String deleteActorByAge()
	{
		String option;

		try
		{
			System.out.println("Select the age to search");
			this.age = this.scanner.nextInt();
		}
		catch(InputMismatchException e)
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.removeActorsByAge(this.actor, this.age);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.removeActorsByAge(this.actor, this.age);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Delete an actor by gender
	 * @return string with the information
	 */
	private String deleteActorByGender()
	{
		String option;
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
			//---DELETE ACTOR BY GENDER ON SERIE---
			this.deleteActorByGenderSerie();
		}
		else
		{
			//---DELETE ACTOR BY GENDER ON FILM---
			this.deleteActorByGenderFilm();
		}
		return option;
	}

	/**
	 *Delete an actor by gender on film
	 */
	private void deleteActorByGenderFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.actor = films.getActors();
				this.actor = this.menuAct.removeActorsByGender(this.actor, this.gender);
				films.setActors(this.actor);
			}
		}
	}

	/**
	 *Delete an actor by gender on series
	 */
	private void deleteActorByGenderSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();
		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.actor = series.getActors();
				this.actor = this.menuAct.removeActorsByGender(this.actor, this.gender);
				series.setActors(this.actor);
			}
		}
	}

	/**
	 * Delete an actor by Last Name
	 * @return string with the information
	 */
	private String deleteActorByLastName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.removeActorsByLastName(this.actor, this.lastName);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();

			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.removeActorsByLastName(this.actor, this.lastName);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Delete an actor by name
	 * @return string with the information
	 */
	private String deleteActorByName()
	{
		String option;
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
			for(Serie series:this.serie)
			{
				if(this.title.equalsIgnoreCase(series.getTitle()))
				{
					this.actor = series.getActors();
					this.actor = this.menuAct.removeActorsByName(this.actor, this.name);
					series.setActors(this.actor);
				}
			}
		}
		else
		{
			this.statsFS.countFilms(this.film);
			this.title= this.scanner.nextLine();
			System.out.println("Select the title of your film");
			this.title = this.scanner.nextLine();
			for(Film films:this.film)
			{
				if(this.title.equalsIgnoreCase(films.getTitle()))
				{
					this.actor = films.getActors();
					this.actor = this.menuAct.removeActorsByName(this.actor, this.name);
					films.setActors(this.actor);
				}
			}
		}
		return option;
	}

	/**
	 * Add an actor
	 * @return string with the information
	 */
	private String addActor()
	{
		String option;
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
			//---ADD ACTOR ON SERIE---
			this.addActorSerie();
		}
		else
		{
			//--- ADD ACTOR ON FILM---
			this.addActorFilm();
		}
		return option;
	}

	/**
	 *Add actor on film
	 */
	private void addActorFilm()
	{
		this.statsFS.countFilms(this.film);
		this.title= this.scanner.nextLine();
		System.out.println("Select the title of your film");
		this.title = this.scanner.nextLine();
		for(Film films:this.film)
		{
			if(this.title.equalsIgnoreCase(films.getTitle()))
			{
				this.actor = films.getActors();
				this.actor = this.menuAct.addActors(this.actor, this.name, this.lastName, this.gender, this.age, this.awards);
				films.setActors(this.actor);
			}
		}
	}

	/**
	 *Add actor on series
	 */
	private void addActorSerie()
	{
		this.statsFS.countSeries(this.serie);
		this.title= this.scanner.nextLine();

		System.out.println("Select the title of your serie");
		this.title = this.scanner.nextLine();

		for(Serie series:this.serie)
		{
			if(this.title.equalsIgnoreCase(series.getTitle()))
			{
				this.actor = series.getActors();
				this.actor = this.menuAct.addActors(this.actor, this.name, this.lastName, this.gender, this.age, this.awards);
				series.setActors(this.actor);
			}
		}
	}

	/**
	 * Menu of stats
	 */
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
				{
					//---STATS OF FILM AND SERIES---
					option = this.statsFilmSeries();
					break;
				}
				case  "2":
				{
					//---STATS OF ACTORS---
					option = this.statsOfActors();
					break;
				}
				case "3":
				{
					//---STATS OF DIRECTORS---
					option = this.statsOfDirectors();
					break;
				}
				case "4":
				{
					//---STATS OF CATEGORIES---
					option = this.statsOfCategories();
					break;
				}
				case "5":
				{
					//---STATS OF SUBTITLES---
                    option = this.statsOfSubtitles();
					break;
				}
				case "6":
				{
					endMenu = true;
					break;
				}
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
	 * Stats of subtitles
	 * @return string with the information
	 */
	private String statsOfSubtitles()
	{
		String option;
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
			//---SHOW ALL SUBTITLES FILM---
			option = this.showAllSubtitlesFilm();
		}
		else if(option.equals("2"))
		{
			//---SHOW ALL SUBTITLES SERIE---
			option = this.showAllSubtitlesSerie();
		}
		else if(option.equals("3"))
		{
			//---SHOW ALL SUBTITLES---
		    this.statsSubtitles.countAllSubtitles(this.serie, this.film);
		}
		else if(option.equals("4"))
		{
			//---SHOW ALL SUBTITLES FILM---
		    this.statsSubtitles.infoFilmSubtitles(this.film);
		}
		else if(option.equals("5"))
		{
			//---SHOW ALL SUBTITLES SERIE---
		    this.statsSubtitles.infoSerieSubtitles(this.serie);
		}
		return option;
	}

	/**
	 * Show all subtitles from series
	 * @return string with the information
	 */
	private String showAllSubtitlesSerie()
	{
		String option;
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
		return option;
	}

	/**
	 * Show all subtitles from films
	 * @return string with the information
	 */
	private String showAllSubtitlesFilm()
	{
		String option;
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
		return option;
	}

	/**
	 * Stats from categories
	 * @return string with the information
	 */
	private String statsOfCategories()
	{
		String option;
		System.out.println("""
			1.-Number of categories of films and series
			2.-Content of categories of films and series
			3.-Show all categories
			4.-Show the series with 2 or more categories
			5.-Show the films with 2 or more categories""");
		option = this.scanner.next();
		if(option.equals("1"))
		{
			//---NUMBER OF CATEGORIES FILM AND SERIE---
			option = this.numberOfCategoriesFilmSerie();
		}
		else if(option.equals("2"))
		{
			//---CONTENT CATEGORIES FILM SERIES---
			option = this.contentOfCategoriesFilmSeries();
		}
		else if(option.equals("3"))
		{
			//--- SHOW ALL CATEGORIES---
			this.statsCategory.countAllCategories(this.serie, this.film);
		}
		else if(option.equals("4"))
		{
			//---SHOW THE SERIES WITH 2 OR MORE CATEGORIES---
			this.statsCategory.showSeriesWithTwoOrMoreCategories(this.serie);
		}
		else if(option.equals("5"))
		{
			//---SHOW THE FILMS WITH 2 OR MORE CATEGORIES---
			this.statsCategory.showFilmsWithTwoOrMoreCategories(this.film);
		}
		return option;
	}

	/**
	 * Content from categories on film and series
	 * @return string with the information
	 */
	private String contentOfCategoriesFilmSeries()
	{
		String option;
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
		return option;
	}

	/**
	 * Number of categories on film or series
	 * @return string with the information
	 */
	private String numberOfCategoriesFilmSerie()
	{
		String option;
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
		return option;
	}

	/**
	 * Stats of directors
	 * @return String with the information
	 */
	private String statsOfDirectors()
	{
		String option;
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
			//--SHOW ALL DIRECTORS---
			this.statDirector.countAllDirectors(this.serie, this.film);
		}
		else if(option.equals("2"))
		{
			//--SHOW ALL DIRECTORS ON FILM---
			option = this.showAllDirectorsOnFilm();
		}
		else if(option.equals("3"))
		{
			//--SHOW ALL DIRECTORS ON SERIE---
			option = this.showAllDirectorsOnSerie();
		}
		else if(option.equals("4"))
		{
			//--SHOW ALL DIRECTORS SERIES WITH 2 OR MORE WORKING---
			this.statDirector.infoSeriesDirectors(this.serie);
		}
		else if(option.equals("5"))
		{
			//--SHOW ALL DIRECTORS FILM WITH 2 OR MORE WORKING---
			this.statDirector.infoFilmsDirectors(this.film);
		}
		return option;
	}

	/**
	 * Show all directors on series
	 * @return string with the information
	 */
	private String showAllDirectorsOnSerie()
	{
		String option;
		System.out.println("Do you want see the number of series or the content (number/content)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
		{
			System.out.println("Error choosing a option, please choose again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("number"))
		{
			this.statDirector.countDirectorsSeries(this.serie);
		}
		else
		{
			this.statDirector.showDirectorsSeries(this.serie);
		}
		return option;
	}

	/**
	 * Show all directors on film
	 * @return string with the information
	 */
	private String showAllDirectorsOnFilm()
	{
		String option;
		System.out.println("Do you want see the number of series or the content (number/content)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
		{
			System.out.println("Error choosing a option, please choose again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("number"))
		{
			this.statDirector.countDirectorsFilms(this.film);
		}
		else
		{
			this.statDirector.showDirectorsFilms(this.film);
		}
		return option;
	}

	/**
	 * Stats of actors
	 * @return string with the information
	 */
	private String statsOfActors()
	{
		String option;
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
			//---SHOW ALL ACTORS---
			this.statsActor.countAllActors(this.serie, this.film);
		}
		else if(option.equals("2"))
		{
			//---SHOW ACTORS ON FILM---
			option = this.showActorsOnFilm();
		}
		else if(option.equals("3"))
		{
			//---SHOW ACTORS ON SERIE---
			option = this.showActorsOnSerie();
		}
		else if(option.equals("4"))
		{
			//---SHOW ACTORS SERIES WITH 2 OR MORE WORKING---
			this.statsActor.infoSeriesActors(this.serie);
		}
		else if(option.equals("5"))
		{
			//---SHOW ACTORS FILM WITH 2 OR MORE WORKING---
			this.statsActor.infoFilmsActors(this.film);
		}
		return option;
	}

	/**
	 * Show actors on series
	 * @return string with information
	 */
	private String showActorsOnSerie()
	{
		String option;
		System.out.println("Do you want see the number of series or the content (number/content)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
		{
			System.out.println("Error choosing a option, please choose again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("number"))
		{
			this.statsActor.countActorsSeries(this.serie);
		}
		else
		{
			this.statsActor.showActorsSeries(this.serie);
		}
		return option;
	}

	/**
	 * Show actors on films
	 * @return string with the information
	 */
	private String showActorsOnFilm()
	{
		String option;
		System.out.println("Do you want see the number of series or the content (number/content)");
		option = this.scanner.next();
		while(!option.equalsIgnoreCase("number") && !option.equalsIgnoreCase("content"))
		{
			System.out.println("Error choosing a option, please choose again");
			option = this.scanner.next();
		}
		if(option.equalsIgnoreCase("number"))
		{
			this.statsActor.countActorsFilms(this.film);
		}
		else
		{
			this.statsActor.showActorsFilms(this.film);
		}
		return option;
	}

	/**
	 * Stats of films and series
	 * @return string with the information
	 */
	private String statsFilmSeries()
	{
		String option;
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
			//---SHOW ALL FILM---
			option = this.showAllFilm();
		}
		else if(option.equals("2"))
		{
			//---SHOW ALL SERIE---
			option = this.showAllSerie();
		}
		else if(option.equals("3"))
		{
			//---SHOW GOOD FILMS---
			this.goodFS.infoFilmsGoodRecommendation(this.film);
		}
		else if(option.equals("4"))
		{
			//---SHOW BAD FILMS---
			this.badFS.infoFilmsNegativeReviews(this.film);
		}
		else if(option.equals("5"))
		{
			//---SHOW GOOD SERIES---
			this.goodFS.infoSeriesGoodRecommendation(this.serie);
		}
		else if(option.equals("6"))
		{
			//---SHOW BAD SEREIES---
			this.badFS.infoSeriesNegativeReviews(this.serie);
		}
		else if(option.equals("7"))
		{
			//---SHOW ALL MULTIGENDER FILMS---
			this.genderFS.infoGenderFilm(this.film);
		}
		else if(option.equals("8"))
		{
			//---SHOW ALL MULTIGENDER SERIES---
			this.genderFS.infoGenderSerie(this.serie);
		}
		return option;
	}

	/**
	 * Show all series
	 * @return String with the inforamtion
	 */
	private String showAllSerie()
	{
		String option;
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
		return option;
	}

	/**
	 * Show all films
	 * @return String with the inforamtion
	 */
	private String showAllFilm()
	{
		String option;
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
		return option;
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