package menus;

import enums.Gender;
import es.iesjandula.streaming.baseclasses.Actors;

import java.util.Arrays;

/**
 *
 * @author alex
 */

//Class responsible for storing the methods for adding, removing, querying, and searching for Actors
public class MenuActors {
        /* 
        * Takes an array of Actors objects
        * Adds a new actor to the array
        * Returns the updated array
        */
	public Actors[] addActors(Actors[] other, String name, String lastName, Gender gender, int age, String awards) 
	{
	    other = Arrays.copyOf(other, other.length + 1);
	    other[other.length - 1] = new Actors(name, lastName, gender, age, awards);
	    return other;
	}

	/* Request an array of Actor objects and the name of the actor to be removed
	* Remove an Actor from the Array
	* Return the Array 
	*/
	public Actors[] removeActorsByName(Actors[] other, String name) 
	{
	    for(int i = 0; i < other.length; i++) 
	    {
	        if(name.equalsIgnoreCase(other[i].getName())) 
	        {   
	            System.out.println("Actors removed: " + other[i]);
	            System.arraycopy(other, i+1, other, i, other.length-i-1);
	            other = Arrays.copyOf(other, other.length-1) ;
	        }
	    }
	    return other;
	}

	/* Request an array of Actor objects and the last name of the actor to be removed
	* Remove an Actor from the Array
	* Return the Array 
	*/
	public Actors[] removeActorsBylastName(Actors[] other, String lastName) 
	{
	    for(int i = 0; i < other.length; i++) 
	    {
	        if(lastName.equalsIgnoreCase(other[i].getLastName())) 
	        {   
	            System.out.println("Actors removed: " + other[i]);
	            System.arraycopy(other, i+1, other, i, other.length-i-1);
	            other = Arrays.copyOf(other, other.length-1) ;
	        }
	    }
	    return other;
	}

	/* Request an array of Actor objects and the gender of the actor to be removed
	* Remove an Actor from the Array
	* Return the Array 
	*/
	public Actors[] removeActorsByGender(Actors[] other, Gender gender) 
	{
	    for(int i = 0; i < other.length; i++) 
	    {
	        if(gender.equals(other[i].getGender())) 
	        {   
	            System.out.println("Actors removed: " + other[i]);
	            System.arraycopy(other, i+1, other, i, other.length-i-1);
	            other = Arrays.copyOf(other, other.length-1) ;
	        }
	    }
	    return other;
	}

	/* Request an array of Actor objects and the age of the actor to be removed
	* Remove an Actor from the Array
	* Return the Array 
	*/
	public Actors[] removeActorsByAge(Actors[] other, int age) 
	{
	    for(int i = 0; i < other.length; i++) 
	    {
	        if(age == other[i].getAge())
	        {   
	            System.out.println("Actors removed: " + other[i]);
	            System.arraycopy(other, i+1, other, i, other.length-i-1);
	            other = Arrays.copyOf(other, other.length-1) ;
	        }
	    }
	    return other;
	}

	/* Request an array of Actor objects and the awards of the actor to be removed
	* Remove an Actor from the Array
	* Return the Array 
	*/
	public Actors[] BajasActorsByAwards(Actors[] other, String awards)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(awards.equalsIgnoreCase(other[i].getAwards()))
            {   
                System.out.println("Actors removed: " + other[i]);
                System.arraycopy (other, i+1, other, i, other.length-i-1);
                other = Arrays.copyOf (other, other.length-1) ;
            }
        }
        return other;
    }
    
    /* An Array of Actors objects, the name of the actor to search for, and their substitution are requested
    * The selected Actors objects are modified
    * The Array is returned
    */
    public Actors[] ModifyActorsByName(Actors[] other, String name, String newName)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(name.equalsIgnoreCase(other[i].getName()))
            {   
                System.out.println("Old name: " + other[i]);
                other[i].setName(newName);
                System.out.println("New name: " + other[i]);
            }
        }
        return other;
    }
    
    /* An Array of Actors objects, the last name of the actor to search for, and their substitution are requested
    * The selected Actors objects are modified
    * The Array is returned
    */
    public Actors[] ModifyActorsByLastName(Actors[] other, String lastName, String nuevoslastName)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(lastName.equalsIgnoreCase(other[i].getLastName()))
            {   
                System.out.println("Old last name: " + other[i]);
                other[i].setLastName(nuevoslastName);
                System.out.println("New last name: " + other[i]);
            }
        }
        return other;
    }
    
    /* An Array of Actors objects, the gender of the actor to search for, and their substitution are requested
    * The selected Actors objects are modified
    * The Array is returned
    */
    public Actors[] ModifyActorsByGender(Actors[] other, Gender gender, Gender nuevoGender)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(gender.equals(other[i].getGender()))
            {   
                System.out.println("Old gender: " + other[i]);
                other[i].setGender(nuevoGender);
                System.out.println("New gender: " + other[i]);
            }
        }
        return other;
    }
    
    /* An Array of Actors objects, the age of the actor to search for, and their substitution are requested
    * The selected Actors objects are modified
    * The Array is returned
    */
    public Actors[] ModifyActorsByAge(Actors[] other, int age, int newAge)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(age == other[i].getAge())
            {   
                System.out.println("Old age: " + other[i]);
                other[i].setAge(newAge);
                System.out.println("New age: " + other[i]);
            }
        }
        return other;
    }
    
    /* An Array of Actors objects is requested,  the awards of the actor to be sought and his replacement
    * The selected Actors objects are modified
    * The Array is returned 
    */
    public Actors[] ModifyActorsByAwards(Actors[] other, String awards, String newAwards)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(awards.equalsIgnoreCase(other[i].getAwards()))
            {   
                System.out.println("Old awards: " + other[i]);
                other[i].setAwards(newAwards);
                System.out.println("New awards: " + other[i]);
            }
        }
        return other;
    }
    
    /* An Array of Actors objects and the name of the actor to be searched
    * Looking for objects Actors
    * The Array is returned
    */
    public void SearchActorsByName(Actors[] other, String name)
    {
        boolean found = false;
        for(int i = 0; i < other.length; i++)
        {
            if(name.equalsIgnoreCase(other[i].getName()))
            {   
                System.out.println("name found: " + other[i]);
                found = true;
            }
            
            if(found == false)
            {
                System.out.println("The name " + other[i] + " has not been found.");
            }
        }
    }
    
    /* An Array of Actors objects and the last name of the actor to be searched
    * Looking for objects Actors
    * The Array is returned
    */
    public void SearchActorsByLastName(Actors[] other, String lastName)
    {
        boolean found = false;
        for(int i = 0; i < other.length; i++)
        {
            if(lastName.equalsIgnoreCase(other[i].getLastName()))
            {   
                System.out.println("lastName found: " + other[i]);
                found = true;
            }
            
            if(found == false)
            {
                System.out.println("The lastName " + other[i] + " has not been found.");
            }
        }
    }
    
    /* An Array of Actors objects and the gender of the actor to be searched
    * Looking for objects Actors
    * The Array is returned
    */
    public void SearchActorsByGender(Actors[] other, Gender gender)
    {
        boolean found = false;
        for(int i = 0; i < other.length; i++)
        {
            if(gender.equals(other[i].getGender()))
            {   
                System.out.println("Gender found: " + other[i]);
                found = true;
            }
            
            if(found == false)
            {
                System.out.println("The Gender " + other[i] + " has not been found.");
            }
        }
    }
    
    /* An Array of Actors objects and the age of the actor to be searched
    * Looking for objects Actors
    * The Array is returned
    */
    public void SearchActorsByAge(Actors[] other, int age)
    {
        boolean found = false;
        for(int i = 0; i < other.length; i++)
        {
            if(age == other[i].getAge())
            {   
                System.out.println("Age found: " + other[i]);
                found = true;
            }
            
            if(found == false)
            {
                System.out.println("The age " + other[i] + " has not been found.");
            }
        }
    }
    
    /* An Array of Actors objects and the awards of the actor to be searched
    * Looking for objects Actors
    * The Array is returned
    */
    public void SearchActorsByawards(Actors[] other, String awards)
    {
        boolean found = false;
        for(int i = 0; i < other.length; i++)
        {
            if(awards.equalsIgnoreCase(other[i].getAwards()))
            {   
                System.out.println("Award found: " + other[i]);
                found = true;
            }
            
            if(found == false)
            {
                System.out.println("The award " + other[i] + " has not been found.");
            }
        }
    }
    
    
}
