package es.iesjandula.streaming.menus;

import es.iesjandula.streaming.baseclasses.Actors;
import es.iesjandula.streaming.enums.Gender;

import java.util.Arrays;

/**
 *
 * @author alex
 */

/**Class responsible for storing the methods for adding, removing, querying, and searching for Actors*/
public class MenuActors {
    /**
     * Takes an array of Actors objects, adds a new actor to the array and returns the updated array
     * @param other
     * @param name
     * @param lastName
     * @param gender
     * @param age
     * @param awards
     * @return 
     */
    public Actors[] addActors(Actors[] other, String name, String lastName, Gender gender, int age, String awards) 
    {
        other = Arrays.copyOf(other, other.length + 1);
        other[other.length - 1] = new Actors(name, lastName, gender, age, awards);
        return other;
    }

    /**
     * Request an array of Actor objects and the name of the actor to be removed, remove an Actor from the Array and return the Array 
     * @param other
     * @param name
     * @return 
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

    /**
     * Request an array of Actor objects and the last name of the actor to be removed, remove an Actor from the Array and return the Array
     * @param other
     * @param lastName
     * @return 
     */
    public Actors[] removeActorsByLastName(Actors[] other, String lastName) 
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

    /**
     * Request an array of Actor objects and the gender of the actor to be removed, remove an Actor from the Array and return the Array
     * @param other
     * @param gender
     * @return 
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

    /**
     * Request an array of Actor objects and the age of the actor to be removed, remove an Actor from the Array and return the Array
     * @param other
     * @param age
     * @return 
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

    /**
     * Request an array of Actor objects and the awards of the actor to be removed, remove an Actor from the Array and return the Array
     * @param other
     * @param awards
     * @return 
     */
    public Actors[] removeActorsByAwards(Actors[] other, String awards)
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

    /**
    * An Array of Actors objects, the name of the actor to search for, and their substitution are requested, the selected Actors objects are modified and the Array is returned 
    * @param other
    * @param name
    * @param newName
    * @return 
    */
    public Actors[] modifyActorsByName(Actors[] other, String name, String newName)
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
  
    /**
     * An Array of Actors objects, the last name of the actor to search for, and their substitution are requested, the selected Actors objects are modified and the Array is returned 
     * @param other
     * @param lastName
     * @param nuevoslastName
     * @return 
     */
    public Actors[] modifyActorsByLastName(Actors[] other, String lastName, String nuevoslastName)
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
    
    /**
     * An Array of Actors objects, the gender of the actor to search for, and their substitution are requested, the selected Actors objects are modified and the Array is returned 
     * @param other
     * @param gender
     * @param nuevoGender
     * @return 
     */
    public Actors[] modifyActorsByGender(Actors[] other, Gender gender, Gender nuevoGender)
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
    
    /**
     * An Array of Actors objects, the age of the actor to search for, and their substitution are requested, the selected Actors objects are modified and the Array is returned 
     * @param other
     * @param age
     * @param newAge
     * @return 
     */
    public Actors[] modifyActorsByAge(Actors[] other, int age, int newAge)
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

    /**
     * An Array of Actors objects, the awards of the actor to search for, and their substitution are requested, the selected Actors objects are modified and the Array is returned 
     * @param other
     * @param awards
     * @param newAwards
     * @return 
     */
    public Actors[] modifyActorsByAwards(Actors[] other, String awards, String newAwards)
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

    /**
     * An Array of Actors objects and the name of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other
     * @param name 
     */
    public void searchActorsByName(Actors[] other, String name)
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

    /**
     * An Array of Actors objects and the last name of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other
     * @param lastName 
     */
    public void searchActorsByLastName(Actors[] other, String lastName)
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

    /**
     * An Array of Actors objects and the gender of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other
     * @param gender 
     */
    public void searchActorsByGender(Actors[] other, Gender gender)
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

    /**
     * An Array of Actors objects and the age of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other
     * @param age 
     */
    public void searchActorsByAge(Actors[] other, int age)
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

    /**
     * An Array of Actors objects and the awards of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other
     * @param awards 
     */
    public void searchActorsByawards(Actors[] other, String awards)
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
