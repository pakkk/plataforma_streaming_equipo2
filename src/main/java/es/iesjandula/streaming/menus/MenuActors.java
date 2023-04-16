package es.iesjandula.streaming.menus;

import es.iesjandula.streaming.baseclasses.Actors;
import es.iesjandula.streaming.enums.Gender;

import java.util.Arrays;

/**
 * Class responsible for storing the methods for adding, removing, querying, and searching for Actors
 * @author alex
 */

public class MenuActors 
{
    /**
     * Takes an array of Actors objects, adds a new actor to the array and returns the updated array
     * @param other the array to add an actor
     * @param name  new actor's name
     * @param lastName new actor's last name
     * @param gender new actor's gender
     * @param age   new actor's name age
     * @param awards new actor's name awards
     * @return the array with the new actor
     */
    public Actors[] addActors(Actors[] other, String name, String lastName, Gender gender, int age, String awards) 
    {
        other = Arrays.copyOf(other, other.length + 1);
        other[other.length - 1] = new Actors(name, lastName, gender, age, awards);
        return other;
    }

    /**
     * Request an array of Actor objects and the name of the actor to be removed, remove an Actor from the Array and return the Array 
     * @param other the array with the actors
     * @param name  the name of the actor to delete
     * @return the array without the actor
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
     * @param other the array with the actors
     * @param lastName the last name of the actor to delete
     * @return the array without the actor
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
     * @param other the array with the actors
     * @param gender the gender of the actor to delete
     * @return the array without the actor
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
     * @param other the array with the actors
     * @param age the age of the actor to delete
     * @return the array without the actor
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
     * @param other the array with the actors
     * @param awards the awards of the actor to delete
     * @return the array without the actor
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
    * @param other the array with the actors
    * @param name the name of the actor to modify
    * @param newName the new name
    * @return the array with the actors
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
     * @param other the array with the actors
     * @param lastName the last name of the actor to modify
     * @param nuevoslastName the new last name
     * @return the array with the actors
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
     * @param other the array with the actors
     * @param gender the gender of the actor to modify
     * @param nuevoGender the new gender
     * @return the array with the actors
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
     * @param other the array with the actors
     * @param age the age of the actor to modify
     * @param newAge the new age
     * @return the array with the actors
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
     * @param other the array with the actors
     * @param awards the awards of the actor to modify
     * @param newAwards the new awards
     * @return the array with the actors
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
     * @param other the array with the actors
     * @param name the name to search
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
        }
        if(!found)
        {
            System.out.println("The name " + name + " has not been found.");
        }
    }

    /**
     * An Array of Actors objects and the last name of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other the array with the actors
     * @param lastName the last name to search
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
        }
        if(!found)
        {
            System.out.println("The lastName " + lastName + " has not been found.");
        }
    }

    /**
     * An Array of Actors objects and the gender of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other the array with the actors
     * @param gender the gender to search
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
        }
        if(!found)
        {
            System.out.println("The Gender " + gender + " has not been found.");
        }
    }

    /**
     * An Array of Actors objects and the age of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other the array with the actors
     * @param age the age to search
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
        }
        if(!found)
        {
            System.out.println("The age " + age + " has not been found.");
        }
    }

    /**
     * An Array of Actors objects and the awards of the actor to be searched, looking for objects Actors, the Array is returned
     * @param other the array with the actors
     * @param awards the awards to search
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
        }
        if(!found)
        {
            System.out.println("The award " + awards + " has not been found.");
        }
    }
}
