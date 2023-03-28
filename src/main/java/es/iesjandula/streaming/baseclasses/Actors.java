package es.iesjandula.streaming.baseclasses;
import es.iesjandula.streaming.enums.Gender;

public class Actors{
	//This class is responsible for loading actor data and storing it in an array
    //Attributes 
    private String name;
    private String lastName;
    private Gender gender;
    private int age;
    private String awards;
    
    /**Constructor that defines the attributes of the actor
     * 
     * @param name
     * @param lastName
     * @param gender
     * @param age
     * @param awards
     */
    public Actors(String name, String lastName, Gender gender, int age, String awards) 
    {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.awards = awards;
        correctAttributes();
    }
    
    //Getters
    /**Getter that returns the actor's name
     * 
     * @return
     */
    public String getName() 
    {
        return this.name;
    }
    /**
     * Getter that returns the actor's last name
     * @return
     */
    public String getLastName() 
    {
        return this.lastName;
    }
    /**Getter that returns the actor's awards
     * 
     * @return
     */
    public String getAwards() 
    {
        return this.awards;
    }
    /**Getter that returns the actor's gender
     * 
     * @return
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
     * 
     */
    private void correctAttributes()
    {
    	while(name.isEmpty())
    	{
            this.name = "Unnamed";
    	}
    	while(lastName.isEmpty())
    	{
            this.lastName = "Unnamed";
    	}
    	while(age<0)
    	{
            this.age = 18;
    	}
    	if(awards.isEmpty())
    	{
            this.awards = "No awards";
    	}
    }
    
    /**toString that displays the values of the actor's attributes
     * 
     */
    @Override
    public String toString() 
    {
        return "Actor "+ this.name + " " + this.lastName +" aged "+ this.age +" has won " + this.awards;
    }

     
}