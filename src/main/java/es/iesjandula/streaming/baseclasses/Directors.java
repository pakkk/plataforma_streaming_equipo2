package es.iesjandula.streaming.baseclasses;
import es.iesjandula.streaming.enums.Gender;

public class Directors {
	//This class is responsible for loading the data of the directors and storing it in an array
	//Attributes 
	/*
	 * Attribute String name: Defines the name of the director
	 * Attribute String lastName: Defines the last name of the director
	 * Attribute Gender gender: Defines the gender of the director
	 * Attribute int age: Defines the age of the director
	 * Attribute String awards: Defines the type of awards the director has won
	 */
	private String name, lastName;
    private Gender gender;
    private int age;
    private String awards;
    //Constructor
    /**
     * This constructor is responsible for setting the values of name, lastName, gender, age, and awards
     * @param name
     * @param lastName
     * @param gender
     * @param age
     * @param awards
     */
    public Directors(String name, String lastName, Gender gender, int age, String awards) 
    {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.awards = awards;
        CorrectAttributes();
    }
    //Getters and Setters
    /**Getter that returns the value of the director's name
     * 
     * @return
     */
    public String getName() 
    {
        return this.name;
    }
    /**Setter that allows modifying the value of the director's name
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**Getter that returns the value of the director's last name
     * 
     * @return
     */
    public String getLastName()
    {
        return this.lastName;
    }
    /**Setter that allows modifying the value of the director's last name
     * 
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    /**Getter that returns the value of the director's gender
     * 
     * @return
     */
    public Gender getGender()
    {
        return this.gender;
    }
    /**
     * Setter that allows modifying the value of the director's gender
     * @param gender
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
    /**
     * Getter that returns the value of the director's age
     * @return
     */
    public int getAge()
    {
        return this.age;
    }
    /**Setter that allows modifying the value of the director's age
     * 
     * @param age
     */
    public void setAge(int age) 
    {
        this.age = age;
    }
    /**Getter that returns the value of the director's awards
     * 
     * @return
     */
    public String getAwards() 
    {
        return this.awards;
    }
    /**
     * Setter that allows modifying the director's awards
     * @param awards
     */
    public void setAwards(String awards)
    {
        this.awards = awards;
    }
    /**
     * Method to set default attributes in case they are not entered
     */
    private void CorrectAttributes()
    {
    	if(name.isEmpty())
    	{
    		this.name = "No name";
    	}
    	if(lastName.isEmpty())
    	{
    		this.lastName = "No last name";
    	}
    	if(age<=0)
    	{
    		this.age = 18; 
    	}
    	if(awards.isEmpty())
    	{
    		this.awards = "No awards";
    	}
    }
    /**
     * toString that displays the value of the attributes name, lastName, gender, age, and awards
     */
    @Override
    public String toString() 
    {
        return "Directors: " +
                "name= " + this.name + '\'' +
                ", lastName= " + this.lastName + '\'' +
                ", gender= " + this.gender +
                ", age= " + this.age +
                ", awards= " + this.awards ;
    }
	

}