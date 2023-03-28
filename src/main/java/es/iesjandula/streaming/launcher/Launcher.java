package es.iesjandula.streaming.launcher;
import java.util.*;
import es.iesjandula.streaming.baseclasses.*;
import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.menus.*;
import es.iesjandula.streaming.enums.*;
import es.iesjandula.streaming.stats.*;
public class Launcher{
	//This class is responsible of execute the menus and control the logic of the entire project
	
	/**Attributes
	 *
	 * Attribute Scanner scanner: Provide of Class Scanner and his use its only for write by keyboard
	 * Attribute Film film[]: Array that save films that the user select
	 * Attribute Serie serie[]: Array that save series that the user select
	 * NOTE:Class film and serie have arrays of actors,directors,categories,recommendations and subtitles so to save them
	 * the user must use menu methods 
	 */
	private Scanner scanner = new Scanner(System.in);
	private Film film[] = new Film[0];
	private Serie serie[] = new Serie[0];
	private Actors actor[];
	private Directors director[];
        private Category category[];
        private Recommendation recommendation[];
	
	/**Attributes of films and serie
	 *
	 * String titles: Title of the film or movie that the user choose 
	 * String originalLanguage: Language with which the movie or serie it was created 
	 * String adaptedLanguage []: Language with which the movie or serie its translated
	 * int duration: Duration of the movie or serie
	 * int views: Views that the movie or serie have
	 * String newTitle: His use is only to modify the old title
	 * String newOriginalLanguage: His use is only to modify the old originalLanguage
	 * String adaptedLanguage[]: His use is only to modify the old adaptedLanguage
	 * int newDuration: His use is only to modify the old duration
	 * int newViews: His use is only to modify the old views
	 */
	private String title,originalLanguage;
	private String adaptedLanguage[] = new String [0];
	private int duration,views;
	private String newTitle,newOriginalLanguage;
	private String newAdaptedLanguage[] = new String [0];
	private int newDuration,newViews;
	
	/**Attributes of actors and directors
	 *
	 * String name: Name of the actor or director
	 * String lastName: Last name of the actor of director
	 * String awards: Awards that the actor or director has been wined
	 * int age: Age of the actor or director
	 * Gender gender: Represent the gender of the actor of director
	 *   
	 */
	private String name,lastName,awards,description, comment;
	private int age;
	private Gender gender;
	private String newName,newLastGame,newAwards,newDescription, newComment;
        private RatingType rate;
        private RatingType newRate;
	private int newAge;
	private Gender newGender;
	//Menu instance 
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
	
	
	//This method controls the operation of this program calling menu methods
	public void startStreaming()
	{
		//First menu were the user must to add a film or serie
		String option="";
		String language;
		boolean endLoop=false;
		System.out.println("Welcome to our streaming platform, in this moment you havent any film and serie register here \n"
				+ "so please choose one of this option:\n"
				+ "1.-Add a new film \n"
				+ "2.-Add a new serie");
		option = this.scanner.next();
		//Inside this loop there is a switch were the user can add a film or movie
		while(!endLoop)
		{
		//This swicth contains the attributes of the class films and serie, that used to add a film or serie	
			switch(option)
			{
				case "1":
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
							language = this.scanner.next();
							this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
							this.adaptedLanguage[this.adaptedLanguage.length-1] = language;
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
					break;
				case "2":
					this.title = this.scanner.nextLine();
					//The user must introduce with the scanner the attributes of the series
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
							language = this.scanner.next();
							this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
							this.adaptedLanguage[this.adaptedLanguage.length-1] = language;
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
					break;
				default:
					System.out.println("Error introducing option");		
			}
			//When a film or serie it introduced the user can introduced another film or serie or can access to the next menu
			System.out.println("Want select again? (yes/no)");
			option = this.scanner.next();
			while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
			{
				System.out.println("Error, select again (yes/no)");
				option=this.scanner.next();
			}
			if(option.equalsIgnoreCase("yes"))
			{
				System.out.println("Select one of this option \n"
						+ "1.-Add a new film \n"
						+ "2.-Add a new serie \n");
				option=this.scanner.next();
			}
			if(option.equalsIgnoreCase("no"))
				endLoop = true;
			
		}
		//In this menu the user can control films,series,actors,directors,subtitles,categories and recommendations
		endLoop = false;
		System.out.println("You have this options now: \n"
				+ "1.-Menu of films and serie \n"
				+ "2.-Menu of data of films and series \n"
				+ "3.-Exit");
		System.out.println("Select one of them");
		option = this.scanner.next();
		while(!endLoop)
		{
			switch(option)
			{
				case "1":
				//In this case the user enter to a better menu that the last were he can delete,modify or search films and series
					boolean endMenu = false;
					System.out.println("You enter in the series and film menu, select one option:\n"
							+ "1.-Add a new film or serie \n"
							+ "2.-Delete a serie or film by his attributes \n"
							+ "3.-Modify an attribute \n"
							+ "4.-Search a film or serie \n"
							+ "5.-Back");
					option = this.scanner.next();
					while(!endMenu)
					{
						switch(option)
						{
						case "1":
							System.out.println("Choose which audiovisual do you want (serie\film)");
							option = this.scanner.next();
							if(option.equalsIgnoreCase("serie"))
							{
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
										language = this.scanner.next();
										this.adaptedLanguage = Arrays.copyOf(this.adaptedLanguage, this.adaptedLanguage.length+1);
										this.adaptedLanguage[this.adaptedLanguage.length-1] = language;
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
							else if(option.equalsIgnoreCase("film"))
							{
								//The user must to introduce with the scanner the attributes of the films 
								option = scanner.nextLine();
								System.out.println("You choose add a new film please introduce his title");
								this.title = scanner.nextLine();
								System.out.println("Introduce his original language");
								this.originalLanguage = scanner.next();
								System.out.println("Want to introduce adapted language? (yes/no)");
								option = scanner.next();
								while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
								{
									System.out.println("Error introducing adapted language introduce yes or no again");
									option = scanner.next();
								}
								if(option.equalsIgnoreCase("yes"))
								{
									while(!option.equalsIgnoreCase("no"))
									{
										System.out.println("Introduce a new language");
										language = scanner.next();
										adaptedLanguage = Arrays.copyOf(adaptedLanguage, adaptedLanguage.length+1);
										adaptedLanguage[adaptedLanguage.length-1] = language;
										System.out.println("Want to introduce a new language (no/any key)");
										option=scanner.next();
									}
								}
								//This try catch it used if the user enter a String data
								try
								{
									System.out.println("Enter a duration");
									duration = scanner.nextInt();
								}catch(InputMismatchException exception)
								{
									System.out.println("Error introducing duration");
									duration = 0;
								}
								//This try-catch do the same function of the last try-catch
								try
								{
									System.out.println("Enter a view");
									views = scanner.nextInt();
								}catch(InputMismatchException exception)
								{
									System.out.println("Error introducing views");
									views=0;
								}
								film = menuFS.addFilm(film, title, originalLanguage, adaptedLanguage, duration, views);
							}else
								System.out.println("Error to selecting audiovisual");
							break;
						case "2":
							System.out.println("Choose which audiovisual do you want (serie/film)");
							option = scanner.next();
							if(option.equalsIgnoreCase("serie"))
							{
								option = scanner.nextLine();
								System.out.println("You choose delete a serie by his attribute select one of then: \n"
										+ "1.-Title \n"
										+ "2.-Original language \n"
										+ "3.-Adapted language \n"
										+ "4.-Duration \n"
										+ "5.-Views");
								option = scanner.nextLine();
								if(option.equalsIgnoreCase("title") || option.equals("1"))
								{
									System.out.println("Select the title to search");
									title = scanner.nextLine();
									serie = menuFS.seriesDropByTitle(serie, title);
								}
								else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
								{
									originalLanguage = scanner.nextLine();
									System.out.println("Select the original language to search");
									originalLanguage = scanner.nextLine();
									serie = menuFS.seriesDropByOriginalLanguage(serie, originalLanguage);
								}
								else if(option.equalsIgnoreCase("adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
								{
									adaptedLanguage = new String[0];
									System.out.println("Select the adapted language to search (can be may several)");
									option = scanner.next();
									while(!option.equalsIgnoreCase("exit"))
									{
										adaptedLanguage = Arrays.copyOf(adaptedLanguage, adaptedLanguage.length+1);
										adaptedLanguage[adaptedLanguage.length-1] = option;
										System.out.println("Select another to add or \"exit\" to stop and search");
										option = scanner.next();
									}
									serie = menuFS.seriesDropByAdaptedLanguage(serie, adaptedLanguage);
									
								}
								else if(option.equalsIgnoreCase("duration") || option.equals("4"))
								{
									
									try
									{
										System.out.println("Enter a duration");
										duration = scanner.nextInt();
									}catch(InputMismatchException e)
									{
										System.out.println("Error to introduce the duration");
										duration = -1;
									}
									if(duration==-1)
										System.out.println("Error to delete the serie");
									else
										serie = menuFS.seriesDownDuration(serie, duration);
								}
								else if(option.equalsIgnoreCase("views") || option.equals("5"))
								{
									System.out.println("Select the views to search");
									try
									{
										System.out.println("Enter a view");
										views = scanner.nextInt();
									}catch(InputMismatchException e)
									{
										System.out.println("Error to introduce the views");
										views = -1;
									}
									if(views<0)
										System.out.println("Error to delete the serie");
									else
										serie = menuFS.seriesDownViewTimesView(serie, views);
											
								}else
									System.out.println("Error to introducing option");
							}
							else if(option.equalsIgnoreCase("film"))
							{
								option = scanner.nextLine();
								System.out.println("You choose delete a film by his attribute select one of then: \n"
										+ "1.-Title \n"
										+ "2.-Original language \n"
										+ "3.-Adapted language \n"
										+ "4.-Duration \n"
										+ "5.-Views");
								option = scanner.nextLine();
								if(option.equalsIgnoreCase("title") || option.equals("1"))
								{
									title = scanner.nextLine();
									System.out.println("Select the title to search");
									title = scanner.nextLine();
									film = menuFS.removeFilmByTitle(film, title);
								}
								else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
								{
									originalLanguage = scanner.nextLine();
									System.out.println("Select the original language to search");
									originalLanguage = scanner.nextLine();
									film = menuFS.removeFilmByOriginalLanguage(film, originalLanguage);
								}
								else if(option.equalsIgnoreCase("adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
								{
									adaptedLanguage = new String[0];
									System.out.println("Select the adapted language to search (can be may several)");
									option = scanner.next();
									while(!option.equalsIgnoreCase("exit"))
									{
										adaptedLanguage = Arrays.copyOf(adaptedLanguage, adaptedLanguage.length+1);
										adaptedLanguage[adaptedLanguage.length-1] = option;
										System.out.println("Select another to add or \"exit\" to stop and search");
										option = scanner.next();
									}
									film = menuFS.removeFilmByAdaptedLanguage(film, adaptedLanguage);
								}
								else if(option.equalsIgnoreCase("duration") || option.equals("4"))
								{
									
									try
									{
										System.out.println("Select the duration to search");
										duration = scanner.nextInt();
									}catch(InputMismatchException e)
									{
										System.out.println("Error to introduce the duration");
										duration = -1;
									}
									if(duration==-1)
										System.out.println("Error to delete the film");
									else
										this.film = this.menuFS.removeFilmByDuration(this.film, this.duration);
								}
								else if(option.equalsIgnoreCase("views") || option.equals("5"))
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
									if(this.views<0)
										System.out.println("Error to delete the film");
									else
										this.film = menuFS.removeFilmByViews(this.film, this.views);
											
								}else
								
									System.out.println("Error to introducing option");
							}
							break;
						case "3":
							System.out.println("Choose which audiovisual do you want (serie/film)");
							option = this.scanner.next();
							
							if(option.equalsIgnoreCase("serie"))
							{
								option = scanner.nextLine();
								System.out.println("You choose modify an attribute of a serie, choose one of then: \n"
										+ "1.-Title \n"
										+ "2.-Original language \n"
										+ "3.-Adapted language \n"
										+ "4.-Duration \n"
										+ "5.-Views");
								option = this.scanner.nextLine();
								if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
								{
									this.title = this.scanner.nextLine();
									System.out.println("Select the title to search");
									this.title = this.scanner.nextLine();
									System.out.println("Select the new title");
									this.newTitle = this.scanner.nextLine();
									this.serie = menuFS.seriesModificationForTitle(this.serie, this.title, this.newTitle);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
								{
									System.out.println("Select the original language to search");
									this.originalLanguage = this.scanner.next();
									System.out.println("Select the new original language");
									this.serie = this.menuFS.seriesModificationByOriginalLanguage(this.serie, this.originalLanguage, this.newOriginalLanguage);
								}
								else if(option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equalsIgnoreCase("3"))
								{
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
								}
								else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
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
								else if(option.equalsIgnoreCase("views") || option.equalsIgnoreCase("5"))
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
								else
									System.out.println("Error to select option");
							}
							else if(option.equalsIgnoreCase("film"))
							{
								option = scanner.nextLine();
								System.out.println("You choose modify an attribute of a film, choose one of then: \n"
										+ "1.-Title \n"
										+ "2.-Original language \n"
										+ "3.-Adapted language \n"
										+ "4.-Duration \n"
										+ "5.-Views");
								option = this.scanner.nextLine();
								if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
								{
									this.title = this.scanner.nextLine();
									System.out.println("Select the title to search");
									this.title = this.scanner.nextLine();
									System.out.println("Select the new title");
									this.newTitle = this.scanner.nextLine();
									this.film = menuFS.movieModificationForTitle(this.film, this.title, this.newTitle);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
								{
									System.out.println("Select the original language to search");
									this.originalLanguage = this.scanner.next();
									System.out.println("Select the new original language");
									this.film = this.menuFS.movieModificationForOriginalLanguage(this.film, this.originalLanguage, this.newOriginalLanguage);
								}
								else if(option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equalsIgnoreCase("3"))
								{
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
								}
								else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
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
								else if(option.equalsIgnoreCase("views") || option.equalsIgnoreCase("5"))
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
								else
									System.out.println("Error to select option");
							}
							break;
						case "4":
							System.out.println("Choose which audiovisual do you want (serie/film)");
							option=this.scanner.next();
							if(option.equalsIgnoreCase("serie"))
							{
								System.out.println("You choose search a serie by one of his attribute, select one of then: \n"
										+ "1.-Title \n"
										+ "2.-Original language \n"
										+ "3.-Adapted language \n"
										+ "4.-Duration \n"
										+ "5.-Views");
								option = this.scanner.next();
								if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
								{
									this.title = scanner.nextLine();
									System.out.println("Select a title to search");
									this.title = scanner.nextLine();
								    this.menuFS.searchSeriesByTitle(this.serie, this.title);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
								{
									System.out.println("Select a original language to search");
									this.originalLanguage = scanner.nextLine();
								    this.menuFS.searchSeriesByOriginalLanguage(this.serie, this.originalLanguage);
								}
								else if (option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
								{
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
								}
								else if(option.equalsIgnoreCase("duration") || option.equals("4"))
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
								else if(option.equalsIgnoreCase("views") || option.equals("5"))
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
							}
							else if(option.equalsIgnoreCase("film"))
							{
								System.out.println("You choose search a film by one of his attribute, select one of then: \n"
										+ "1.-Title \n"
										+ "2.-Original language \n"
										+ "3.-Adapted language \n"
										+ "4.-Duration \n"
										+ "5.-Views");
								option = this.scanner.next();
								if(option.equalsIgnoreCase("title") || option.equalsIgnoreCase("1"))
								{
									this.title = scanner.nextLine();
									System.out.println("Select a title to search");
									this.title = scanner.nextLine();
								    this.menuFS.filmsSearchByTitle(this.film, this.title);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
								{
									System.out.println("Select a original language to search");
									this.originalLanguage = scanner.nextLine();
								    this.menuFS.filmsSearchByOriginalLanguage(this.film, this.originalLanguage);
								}
								else if (option.equalsIgnoreCase("Adapted language") || option.equalsIgnoreCase("adaptedLanguage") || option.equals("3"))
								{
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
								}
								else if(option.equalsIgnoreCase("duration") || option.equals("4"))
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
								else if(option.equalsIgnoreCase("views") || option.equals("5"))
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
							}
							break;
						case "5":
							endMenu = true;
						default:
							System.out.println("Error al seleccionar opcion");
						}
						if(!endMenu)
						{
							System.out.println("You enter in the series and film menu, select one option:\n"
									+ "1.-Add a new film or serie \n"
									+ "2.-Delete a serie or film by his attributes \n"
									+ "3.-Modify an attribute \n"
									+ "4.-Search a film or serie \n"
									+ "5.-Back");
							option = this.scanner.next();
						}
					}
					break;
				case "2":
					System.out.println("You enter in the menu of data of films and series, choose a option \n"
							+ "1.-Menu of actors \n"
							+ "2.-Menu of directors \n"
							+ "3.-Menu of categories \n"
							+ "4.-Menu of recommendation \n"
							+ "5.-Menu of subtitles \n"
							+ "6.- Back");
					option = this.scanner.next();
					endMenu = false;
					while(!endMenu)
					{
						switch(option)
						{
							case "1":
								System.out.println("You choose menu of actors, select one option: \n"
										+ "1.-Add a actor \n"
										+ "2.-Delete a actor \n"
										+ "3.-Modify a actor \n"
										+ "4.-Search a actor \n"
										+ "5.-Back");
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
									System.out.println("You choose delete a actor by his attributes, choose one: \n"
											+ "1.-Name \n"
											+ "2.-Last name \n"
											+ "3.-Gender \n"
											+ "4.-Age \n"
											+ "5.-Awards");
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
									System.out.println("You choose modify a attribute of a actor, choose one option: \n "
											+ "1.-Name \n"
											+ "2.-Last name \n"
											+ "3.-Gender \n"
											+ "4.-Age \n"
											+ "5.-Awards");
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
													this.actor = menuAct.modifyActorsByName(this.actor, this.name, this.newName);
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
													this.actor = menuAct.modifyActorsByName(this.actor, this.name, this.newName);
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
										this.lastName = this.scanner.nextLine();
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
													this.actor = this.menuAct.modifyActorsByLastName(this.actor, this.lastName, this.newLastGame);
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
													this.actor = this.menuAct.modifyActorsByLastName(this.actor, this.lastName, this.newLastGame);
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
										this.awards = this.scanner.next();
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
									System.out.println("You choose delete a actor by his attributes, choose one: \n"
											+ "1.-Name \n"
											+ "2.-Last name \n"
											+ "3.-Gender \n"
											+ "4.-Age \n"
											+ "5.-Awards");
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
								break;
							case "2":
								System.out.println("You choose menu of directors, select one option: \n"
										+ "1.-Add a director \n"
										+ "2.-Delete a director \n"
										+ "3.-Modify a director \n"
										+ "4.-Search a director \n"
										+ "5.-Back");
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
									System.out.println("You choose delete a director by his attributes, choose one: \n"
											+ "1.-Name \n"
											+ "2.-Last name \n"
											+ "3.-Gender \n"
											+ "4.-Age \n"
											+ "5.-Awards");
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
									System.out.println("You choose modify a attribute of a director, choose one option: \n "
											+ "1.-Name \n"
											+ "2.-Last name \n"
											+ "3.-Gender \n"
											+ "4.-Age \n"
											+ "5.-Awards");
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
													this.director = menuDict.directorsModifyByName(this.director, this.name, this.newName);
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
													this.director = menuDict.directorsModifyByName(this.director, this.name, this.newName);
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
										this.lastName = this.scanner.nextLine();
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
													this.director = this.menuDict.directorsModifyByLastName(this.director, this.lastName, this.newLastGame);
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
													this.director = this.menuDict.directorsModifyByLastName(this.director, this.lastName, this.newLastGame);
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
										this.awards = this.scanner.next();
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
									System.out.println("You choose delete a director by his attributes, choose one: \n"
											+ "1.-Name \n"
											+ "2.-Last name \n"
											+ "3.-Gender \n"
											+ "4.-Age \n"
											+ "5.-Awards");
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
								break;
								case "3":
								System.out.println("You choose menu of categories, select one option: \n"
										+ "1.-Add a category \n"
										+ "2.-Delete a category \n"
										+ "3.-Modify a category \n"
										+ "4.-Search a category \n"
										+ "5.-Back");
								option = this.scanner.next();
                                if(option.equals("1"))
                                {
                                        this.name = this.scanner.nextLine();
                                        System.out.println("Select a name");
                                        this.name = this.scanner.nextLine();
                                        System.out.println("Select a description");
                                        this.description = this.scanner.nextLine();
                                        option = this.scanner.next();
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
                                    System.out.println("You choose delete a Category by its attributes, choose one: \n"
                                                    + "1.-Name \n"
                                                    + "2.-Description \n");
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
                                    System.out.println("You choose modify a attribute of a category, choose one option: \n "
                                                    + "1.-Name \n"
                                                    + "2.-Description \n");
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
                                    System.out.println("You choose search a category by his attributes, choose one: \n"
                                                    + "1.-Name \n"
                                                    + "2.-Description \n");
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
								break;
								
                                                case "4":
                                                        System.out.println("You choose menu of recommendation, select one option: \n"
                                                                        + "1.-Add a recommendation \n"
                                                                        + "2.-Delete a recommendation \n"
                                                                        + "3.-Modify a recommendation \n"
                                                                        + "4.-Search a recommendation \n"
                                                                        + "5.-Back");
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
                                                                System.out.println("You choose delete a recommendation by its attributes, choose one: \n"
                                                                                + "1.-Rating \n"
                                                                                + "2.-Comment \n");
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
                                                                System.out.println("You choose modify an attribute of a category, choose one option: \n "
                                                                                + "1.-Rating \n"
                                                                                + "2.-Comment \n");
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
                                                                System.out.println("You choose search a recommendation by his attributes, choose one: \n"
                                                                                + "1.-Rating \n"
                                                                                + "2.-Comment \n");
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
								System.out.println("You choose menu of subtitles, select one option: \n"
										+ "1.-Add a subtitle \n"
										+ "2.-Delete a subtitle \n"
										+ "3.-Modify a subtitle \n"
										+ "4.-Seacrh a subtitle \n"
										+ "5.-Back");
								break;
						
							case "6":
								endMenu = true;
								break;
						}
						if(!endMenu)
						{
							System.out.println("Select one option: \n"
									+ "1.-Menu of actors \n"
									+ "2.-Menu of directors \n"
									+ "3.-Menu of categories \n"
									+ "4.-Menu of recommendation \n"
									+ "5.-Menu of subtitles \n"
									+ "6.-Back");
							option = this.scanner.next();
						}
					}
					break;
				case "3":
					System.out.println("You choose menu of stats of the system, choose one option:\n"
							+ "1.-Stats of films and series \n"
							+ "2.-Stats of actors \n"
							+ "3.-Stats of directors \n"
							+ "4.-Stats of category \n"
							+ "5.-Stats of subttiles \n"
							+ "6.-Back");
					option = this.scanner.next();
					endMenu = false;
					while(!endMenu)
					{
						switch(option)
						{
							case "1":
								System.out.println("You choose stats of films and series, choose one option: \n"
										+ "1.-Show all films \n"
										+ "2.-Show all series \n"
										+ "3.-Show good films \n"
										+ "4.-Show bad films \n"
										+ "5.-Show good series \n"
										+ "6.-Show bad series \n"
										+ "7.-Show multi gender film \n"
										+ "8.-Show multi gender serie");
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
										
							case "6":
								endMenu = true;
								break;
							default:
								System.out.println("Error selecting option");
						}
						if(!endMenu)
						{
							System.out.println("Choose one option:\n"
									+ "1.-Stats of films and series \n"
									+ "2.-Stats of actors \n"
									+ "3.-Stats of directors \n"
									+ "4.-Stats of category \n"
									+ "5.-Stats of subtitles \n"
									+ "6.-Back");
							option = this.scanner.next();
						}
							
					}
					break;
				case "4":
					System.out.println("Thanks for use our application!");
					endLoop=true;
					break;
				default:
					System.out.println("Error introducing option");
					
			}
			if(!endLoop)
			{
				System.out.println("You have this options: \n"
						+ "1.-Menu of films and serie \n"
						+ "2.-Menu of data of films and series \n"
						+ "3.-Menu of stats of the system \n"
						+ "4.-Exit");
				System.out.println("Select one of them");
				option = scanner.next();
			}
		}
		
		
		
	}
}
