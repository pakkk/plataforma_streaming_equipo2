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
	 */
	private String title,originalLanguage;
	private String adaptedLanguage[] = new String [0];
	private int duration,views;
	
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
					//The user must introduce with the scanner the attributes of the series
					System.out.println("You choose add a new serie please introduce his title");
					this.title = scanner.next();
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
								System.out.println("You choose add a new serie please introduce his title");
								this.title = scanner.next();
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
									title = scanner.nextLine();
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
									System.out.println("Select the duration to search");
									try
									{
										
									}catch(InputMismatchException e)
									{
										System.out.println("Error to introduce the duration");
										duration = -1;
									}
									if(duration==-1)
										System.out.println("Error to delete the film");
									else
										film = menuFS.removeFilmByDuration(film, duration);
								}
								else if(option.equalsIgnoreCase("views") || option.equals("5"))
								{
									System.out.println("Select the views to search");
									try
									{
										
									}catch(InputMismatchException e)
									{
										System.out.println("Error to introduce the views");
										views = -1;
									}
									if(views<0)
										System.out.println("Error to delete the film");
									else
										film = menuFS.removeFilmByViews(film, views);
											
								}else
								
									System.out.println("Error to introducing option");
							}
						}
						System.out.println("You enter in the series and film menu, select one option:\n"
								+ "1.-Add a new film or serie \n"
								+ "2.-Delete a serie or film by his attributes \n"
								+ "3.-Modify an attribute \n"
								+ "4.-Search a film or serie \n"
								+ "5.-Back");
						option = scanner.next();
					}
					
					break;
				case "2":
					
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
