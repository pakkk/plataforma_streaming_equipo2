package es.iesjandula.streaming.baseclasses;

import es.iesjandula.streaming.enums.Gender;

/**
 * 
 * @author Eduardo
 *
 */
public class Actors
{
	//This class is responsible for loading actor data and storing it in an array
    //Attributes 
	
	/**Attribute name*/
    private String name;
    
    /**Attribute lastName*/
    private String lastName;
    
    /**Attribute gender*/
    private Gender gender;
    
    /**Attribute age*/
    private int age;
    
    /**Attribute awards*/
    private String awards;
    
    /**Constructor that defines the attributes of the actor
     * 
     * @param name the name of the actor
     * @param lastName the last name of the actor
     * @param gender the gender of the actor
     * @param age the age of the actor
     * @param awards the awards of the actor
     */
    public Actors(String name, String lastName, Gender gender, int age, String awards) 
    {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.awards = awards;
        this.correctAttributes();
    }
    
    //Getters
    /**Getter 
     * 
     * @return that returns the actor's name
     */
    public String getName() 
    {
        return this.name;
    }
    
    /**
     * Getter 
     * @return that returns the actor's last name
     */
    public String getLastName() 
    {
        return this.lastName;
    }
    
    /**Getter 
     * @return that returns the actor's awards
     */
    public String getAwards() 
    {
        return this.awards;
    }
    
    /**
     * Getter 
     * @return that returns the actor's gender
     */
    public Gender getGender() 
    {
    	return this.gender;
    }
    
    /**Getter that returns the actor's age
     * 
     * @return
     */
    public int getAge() 
    {
        return this.age;
    }
    
    //Setters
    /**
     * Setter that allows modifying the actor's name
     * @param name
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * Setter that allows modifying the actor's last name
     * @param lastName
     */
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    
    /**
     * Setter that allows modifying the actor's gender
     * @param gender
     */
    public void setGender(Gender gender) 
    {
        this.gender = gender;
    }
    
    /**
     * Setter that allows modifying the actor's age
     * @param age
     */
    public void setAge(int age) 
    {
        this.age = age;
    }
    
    /**Setter that allows modifying the actor's awards
     * 
     * @param awards
     */
    public void setAwards(String awards) 
    {
        this.awards = awards;
    }
    
    /**This method is used to set default attributes if they are not entered
     */
    private void correctAttributes()
    {
    	if(name.isEmpty())
    	{
            this.name = "Unnamed";
    	}
    	if(lastName.isEmpty())
    	{
            this.lastName = "Unnamed";
    	}
    	if(age<0)
    	{
            this.age = 18;
    	}
    	if(awards.isEmpty())
    	{
            this.awards = "No awards";
    	}
    }
    
    /**
     * @return that displays the values of the actor's attributes
     */
    @Override
    public String toString() 
    {
        return "Actor "+ this.name + " " + this.lastName +" gender " +this.gender+ " aged "+ this.age +" has won " + this.awards;
    }

     
}