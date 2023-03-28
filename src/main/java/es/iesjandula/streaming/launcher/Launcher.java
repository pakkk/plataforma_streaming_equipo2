package es.iesjandula.streaming.launcher;
import java.util.*;
import es.iesjandula.streaming.baseclasses.*;
import es.iesjandula.streaming.streaming.*;
import es.iesjandula.streaming.menus.*;
public class Launcher{
	//This class is responsible of execute the menus and control the logic of the entire project
	//Attributes
	/*
	 * Attribute Scanner scanner: Provide of Class Scanner and his use its only for write by keyboard
	 * Attribute Film film[]: Array that save films that the user select
	 * Attribute Serie serie[]: Array that save series that the user select
	 * NOTE:Class film and serie have arrays of actors,directors,categories,recommendations and subtitles so to save them
	 * the user must use menu methods 
	 */
	private Scanner scanner = new Scanner(System.in);
	private Film film[] = new Film[0];
	private Serie serie[] = new Serie[0];
	
	//Attributes of films and serie
	/*
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
		option = scanner.next();
		//Inside this loop there is a switch were the user can add a film or movie
		while(!endLoop)
		{
		//This swicth contains the attributes of the class films and serie, that used to add a film or serie	
			switch(option)
			{
				case "1":
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
					break;
				case "2":
					this.title = scanner.nextLine();
					//The user must introduce with the scanner the attributes of the series
					System.out.println("You choose add a new serie please introduce his title");
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
					//This try-catch it used if the user introduce a string data
					try
					{
						System.out.println("Enter a duration");
						duration = scanner.nextInt();
					}catch(InputMismatchException exception)
					{
						System.out.println("Error introducing duration");
						duration = 0;
					}
					//This try-catch have the same function of the last try-catch
					try
					{
						System.out.println("Enter a view");
						views = scanner.nextInt();
					}catch(InputMismatchException exception)
					{
						System.out.println("Error introducing views");
						views=0;
					}
					serie = menuFS.addSerie(serie, title, originalLanguage, adaptedLanguage, duration, views);
					break;
				default:
					System.out.println("Error introducing option");		
			}
			//When a film or serie it introduced the user can introduced another film or serie or can access to the next menu
			System.out.println("Want select again? (yes/no)");
			option = scanner.next();
			while(!option.equalsIgnoreCase("yes") && !option.equalsIgnoreCase("no"))
			{
				System.out.println("Error, select again (yes/no)");
				option=scanner.next();
			}
			if(option.equalsIgnoreCase("yes"))
			{
				System.out.println("Select one of this option \n"
						+ "1.-Add a new film \n"
						+ "2.-Add a new serie \n");
				option=scanner.next();
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
		option = scanner.next();
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
					option = scanner.next();
					while(!endMenu)
					{
						switch(option)
						{
						case "1":
							System.out.println("Choose which audiovisual do you want (serie\film)");
							option = scanner.next();
							if(option.equalsIgnoreCase("serie"))
							{
								this.title = scanner.nextLine();
								System.out.println("You choose add a new serie please introduce his title");
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
								//This try-catch it used if the user introduce a string data
								try
								{
									System.out.println("Enter a duration");
									duration = scanner.nextInt();
								}catch(InputMismatchException exception)
								{
									System.out.println("Error introducing duration");
									duration = 0;
								}
								//This try-catch have the same function of the last try-catch
								try
								{
									System.out.println("Enter a view");
									views = scanner.nextInt();
								}catch(InputMismatchException exception)
								{
									System.out.println("Error introducing views");
									views=0;
								}
								serie = menuFS.addSerie(serie, title, originalLanguage, adaptedLanguage, duration, views);
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
									serie = menuFS.SeriesDropByTitle(serie, title);
								}
								else if(option.equalsIgnoreCase("original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
								{
									originalLanguage = scanner.nextLine();
									System.out.println("Select the original language to search");
									originalLanguage = scanner.nextLine();
									serie = menuFS.SeriesDropByOriginalLanguage(serie, originalLanguage);
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
									serie = menuFS.SeriesDropByAdaptedLanguage(serie, adaptedLanguage);
									
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
										serie = menuFS.SeriesDownDuration(serie, duration);
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
										serie = menuFS.SeriesDownViewTimesView(serie, views);
											
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
									this.serie = menuFS.SeriesModificationForTitle(this.serie, this.title, this.newTitle);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
								{
									System.out.println("Select the original language to search");
									this.originalLanguage = this.scanner.next();
									System.out.println("Select the new original language");
									this.serie = this.menuFS.SeriesModificationByOriginalLanguage(this.serie, this.originalLanguage, this.newOriginalLanguage);
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
									this.serie = this.menuFS.SeriesModificationByAdaptedLanguage(this.serie, this.adaptedLanguage, this.adaptedLanguage);
								}
								else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
								{
									try
									{
										System.out.println("Select the duration to search");
										this.duration = this.scanner.nextInt(); 
										System.out.println("Select the new duration");
										this.duration = this.scanner.nextInt();
										this.serie = this.menuFS.SeriesModificationForDuration(this.serie, this.duration, this.newDuration); 
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
										this.views = this.scanner.nextInt();
										this.serie = this.menuFS.SeriesModificationForDuration(this.serie, this.views, this.views); 
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
									this.film = menuFS.MovieModificationForTitle(this.film, this.title, this.newTitle);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equalsIgnoreCase("2"))
								{
									System.out.println("Select the original language to search");
									this.originalLanguage = this.scanner.next();
									System.out.println("Select the new original language");
									this.film = this.menuFS.MovieModificationForOriginalLanguage(this.film, this.originalLanguage, this.newOriginalLanguage);
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
									this.film = this.menuFS.MovieModificationByAdaptedLanguage(this.film, this.adaptedLanguage, this.adaptedLanguage);
								}
								else if(option.equalsIgnoreCase("duration") || option.equalsIgnoreCase("4"))
								{
									try
									{
										System.out.println("Select the duration to search");
										this.duration = this.scanner.nextInt(); 
										System.out.println("Select the new duration");
										this.duration = this.scanner.nextInt();
										this.film = this.menuFS.MovieModificationForDuration(this.film, this.duration, this.newDuration); 
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
										this.views = this.scanner.nextInt();
										this.film = this.menuFS.FilmModificationTimesViewed(this.film, this.views, this.views); 
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
								    this.menuFS.FilmsSearchByTitle(this.film, this.title);
								}
								else if(option.equalsIgnoreCase("Original language") || option.equalsIgnoreCase("originalLanguage") || option.equals("2"))
								{
									System.out.println("Select a original language to search");
									this.originalLanguage = scanner.nextLine();
								    this.menuFS.FilmsSearchByOriginalLanguage(this.film, this.originalLanguage);
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
									this.menuFS.FilmsSearchByAdaptedLanguage(this.film, this.adaptedLanguage);
								}
								else if(option.equalsIgnoreCase("duration") || option.equals("4"))
								{
									try
									{
										System.out.println("Select a duration");
										this.duration = this.scanner.nextInt();
										this.menuFS.FilmsSearchByDuration(this.film, this.duration);
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
										this.menuFS.FilmsSearchByViews(this.film, this.views);
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
								break;
							case "2":
								System.out.println("You choose menu of directors, select one option: \n"
										+ "1.-Add a director \n"
										+ "2.-Delete a director \n"
										+ "3.-Modify a director \n"
										+ "4.-Search a director \n"
										+ "5.-Back");
								break;
							case "3":
								System.out.println("You choose menu of categories, select one option: \n"
										+ "1.-Add a categorie \n"
										+ "2.-Delete a categorie \n"
										+ "3.-Modify a categorie \n"
										+ "4.-Search a categorie \n"
										+ "5.-Back");
								
								break;
								
							case "4":
								System.out.println("You choose menu of recommendation, select one option: \n"
										+ "1.-Add a recommendation \n"
										+ "2.-Delete a recommendation \n"
										+ "3.-Modify a recommendation \n"
										+ "4.-Search a recommendation \n"
										+ "5.-Back");
								
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
						+ "3.-Exit");
				System.out.println("Select one of them");
				option = scanner.next();
			}
		}
		
		
		
	}
}