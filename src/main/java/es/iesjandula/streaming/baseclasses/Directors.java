package es.iesjandula.streaming.baseclasses;

import es.iesjandula.streaming.enums.Gender;

/**
 * -This class is responsible for loading the data of the directors and storing it in an array
 * @author Juan Alberto
 *
 */

public class Directors
{

	/** Attribute String name: Defines the name of the director */
	private String name;

	/** Attribute String lastName: Defines the last name of the director */
	private String lastName;

	/** Attribute Gender gender: Defines the gender of the director */
    private Gender gender;

	/** Attribute int age: Defines the age of the director */
    private int age;

	/** Attribute String awards: Defines the type of awards the director has won*/
    private String awards;

    /**
     * Constructor
     * This constructor is responsible for setting the values of name, lastName, gender, age, and awards
     * @param name the name of the director
     * @param lastName the last name of the director
     * @param gender the gender of the director
     * @param age the age of the director
     * @param awards the awards of the director
     */
    public Directors(String name, String lastName, Gender gender, int age, String awards)
    {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.awards = awards;
        this.correctAttributes();
    }

    //Getters and Setters

    /**Getter
     * @return that returns the value of the director's name
     */
    public String getName()
    {
        return this.name;
    }

    /**Setter that allows modifying the value of the director's name
     * @param name the name of the director
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**Getter
     *
     * @return that returns the value of the director's last name
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**Setter that allows modifying the value of the director's last name
     *
     * @param lastName the last name of the director
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**Getter
     *
     * @return that returns the value of the director's gender
     */
    public Gender getGender()
    {
        return this.gender;
    }

    /**
     * Setter that allows modifying the value of the director's gender
     * @param gender the gender of the director
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * Getter
     * @return that returns the value of the director's age
     */
    public int getAge()
    {
        return this.age;
    }

    /**Setter that allows modifying the value of the director's age
     *
     * @param age the age of the director
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**Getter
     *
     * @return that returns the value of the director's awards
     */
    public String getAwards()
    {
        return this.awards;
    }

    /**
     * Setter that allows modifying the director's awards
     * @param awards the awards of the director
     */
    public void setAwards(String awards)
    {
        this.awards = awards;
    }

    /**
     * Method to set default attributes in case they are not entered
     */
    private void correctAttributes()
    {
    	if(this.name.isEmpty())
    	{
    		this.name = "No name";
    	}
    	if(this.lastName.isEmpty())
    	{
    		this.lastName = "No last name";
    	}
    	if(this.age<=0)
    	{
    		this.age = 18;
    	}
    	if(this.awards.isEmpty())
    	{
    		this.awards = "No awards";
    	}
    }

	/**
	 * toString that displays the value of the attributes name, lastName, gender, age, and awards
	 * @return String with the information of the director
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