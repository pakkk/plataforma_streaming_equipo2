package menus;

import clasesbase.Actors;
import enums.Gender;
import java.util.Arrays;

/**
 *
 * @author alex
 */

//Class responsible for storing the methods for adding, removing, querying, and searching for Actors
public class MenuActors {
   
	public Actors[] addActors(Actors[] other, String name, String lastName, Gender gender, int age, String awards) {
	    other = Arrays.copyOf(other, other.length + 1);
	    other[other.length - 1] = new Actors(name, lastName, gender, age, awards);
	    return other;
	}

	/* Request an array of Actor objects and the name of the actor to be removed
	* Remove an Actor from the Array
	* Return the Array 
	*/
	public Actors[] removeActorsByName(Actors[] other, String name) {
	    for(int i = 0; i < other.length; i++) {
	        if(name.equalsIgnoreCase(other[i].getName())) {   
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
	public Actors[] removeActorsBylastName(Actors[] other, String lastName) {
	    for(int i = 0; i < other.length; i++) {
	        if(lastName.equalsIgnoreCase(other[i].getLastName())) {   
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
	public Actors[] removeActorsByGender(Actors[] other, Gender gender) {
	    for(int i = 0; i < other.length; i++) {
	        if(gender.equals(other[i].getGender())) {   
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
	public Actors[] removeActorsByAge(Actors[] other, int age) {
	    for(int i = 0; i < other.length; i++) {
	        if(age == other[i].getAge()) {   
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
	public Actors[] BajasActorsByawards(Actors[] other, String awards)
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
    public Actors[] ModifyActorsByname(Actors[] other, String name, String newName)
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
    public Actors[] ModifyActorsBylastName(Actors[] other, String lastName, String nuevoslastName)
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
    public Actors[] ModifyActorsByGenero(Actors[] other, Gender gender, Gender nuevoGender)
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
    public Actors[] ModifyActorsByage(Actors[] other, int age, int newAge)
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
    
    /* Se pide un Array de objetos Actors,  los awards del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actors seleccionados
    * Se devuelve el Array 
    */
    public Actors[] ModifyActorsByAwards(Actors[] other, String awards, String newAwards)
    {
        for(int i = 0; i < other.length; i++)
        {
            if(awards.equalsIgnoreCase(other[i].getAwards()))
            {   
                System.out.println("awards antiguos: " + other[i]);
                other[i].setAwards(newAwards);
                System.out.println("awards nuevos: " + other[i]);
            }
        }
        return other;
    }
    
    /* Se pide un Array de objetos Actors y el name del actor que se va a buscar
    * Se buscan los objetos Actors
    * Se devuelve el Array 
    */
    public void SearchActorsByname(Actors[] other, String name)
    {
        boolean encontrado = false;
        for(int i = 0; i < other.length; i++)
        {
            if(name.equalsIgnoreCase(other[i].getName()))
            {   
                System.out.println("name encontrado: " + other[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El name " + other[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actors y los lastName del actor que se va a buscar
    * Se buscan los objetos Actors
    * Se devuelve el Array 
    */
    public void SearchActorsBylastName(Actors[] other, String lastName)
    {
        boolean encontrado = false;
        for(int i = 0; i < other.length; i++)
        {
            if(lastName.equalsIgnoreCase(other[i].getLastName()))
            {   
                System.out.println("lastName encontrados: " + other[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El apellido " + other[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actors y el genero del actor que se va a buscar
    * Se buscan los objetos Actors
    * Se devuelve el Array 
    */
    public void SearchActorsByGenero(Actors[] other, Gender gender)
    {
        boolean encontrado = false;
        for(int i = 0; i < other.length; i++)
        {
            if(gender.equals(other[i].getGender()))
            {   
                System.out.println("Genero encontrado: " + other[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El genero " + other[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actors y la age del actor que se va a buscar
    * Se buscan los objetos Actors
    * Se devuelve el Array 
    */
    public void SearchActorsByage(Actors[] other, int age)
    {
        boolean encontrado = false;
        for(int i = 0; i < other.length; i++)
        {
            if(age == other[i].getAge())
            {   
                System.out.println("age encontrada: " + other[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("La age " + other[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actors y ls awards del actor que se va a buscar
    * Se buscan los objetos Actors
    * Se devuelve el Array 
    */
    public void SearchActorsByawards(Actors[] other, String awards)
    {
        boolean encontrado = false;
        for(int i = 0; i < other.length; i++)
        {
            if(awards.equalsIgnoreCase(other[i].getAwards()))
            {   
                System.out.println("Premio encontrado: " + other[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El premio " + other[i] + " no se ha encontrado.");
            }
        }
    }
    
    
}
