package es.iesjandula.streaming.menus;

import java.util.Arrays;
import es.iesjandula.streaming.baseclasses.Directors;
import es.iesjandula.streaming.enums.Gender;

/**
 * Class responsible for storing the methods for adding, deleting, querying, and searching Directors
 * @author Javier
 */
public class MenuDirectors 
{
    /**
     * Request an array of Directors objects and their attributes
     * Add a Director to the array
     * @param newDirector array of directors
     * @param name name of the new director
     * @param lastName last name of the new director
     * @param gender gender of the new director
     * @param age age of the new director
     * @param awards awards of the new director
     * @return array of director
     */
    public Directors[] directorsAdd(Directors[] newDirector, String name, String lastName, Gender gender, int age, String awards) 
    {
        newDirector = Arrays.copyOf(newDirector, newDirector.length+1);
        newDirector[newDirector.length-1] = new Directors(name,lastName,gender,age,awards);
        return newDirector;
    }
    
    /**
     * Request an array of Directors objects and the name of the director to be removed
     * Delete the selected Director objects
     * @param name name of the director to delete
     * @param newDirector array of directors
     * @return the modified array
     */
    public Directors [] directorsDeleteByName(String name,Directors[] newDirector) 
    {
        for(int i=0;i<newDirector.length;i++) 
        {
            if(name.equalsIgnoreCase(newDirector[i].getName()))  
            {
                System.out.println("Attributes deleted: " + newDirector[i]);
                System.arraycopy(newDirector, i+1, newDirector, i, newDirector.length-i-1);
                newDirector = Arrays.copyOf(newDirector, newDirector.length-1) ;
            }
        }
        return newDirector;
    }
    
    /**
     * Request an array of Directors objects and the last name of the director to be removed
     * Delete the selected Director objects
     * @param lastName last name of the director to delete
     * @param newDirector array of directors
     * @return the modified array
     */
    public Directors [] directorsDeleteByLastName(String lastName,Directors[] newDirector) 
    {
        for(int i=0;i<newDirector.length;i++) 
        {
            if(lastName.equalsIgnoreCase(newDirector[i].getLastName()))  
            {
                System.out.println("Attributes deleted: " + newDirector[i]);
                System.arraycopy(newDirector, i+1, newDirector, i, newDirector.length-i-1);
                newDirector = Arrays.copyOf(newDirector, newDirector.length-1) ;
            }
        }
        return newDirector;
    }
    
    /**
     * Request an array of Directors objects and the gender of the director to be removed
     * Delete the selected Director objects
     * @param gender gender of the director to delete
     * @param newDirector array of directors
     * @return the modified array
     */
    public Directors [] directorsDeleteByGender(Gender gender,Directors[] newDirector) 
    {
        for(int i=0;i<newDirector.length;i++) 
        {
            if(gender.equals(newDirector[i].getGender()))  
            {
                System.out.println("Attributes deleted: " + newDirector[i]);
                System.arraycopy(newDirector, i+1, newDirector, i, newDirector.length-i-1);
                newDirector = Arrays.copyOf(newDirector, newDirector.length-1) ;
            }
        }
        return newDirector;
    }
    
    /**
     * Request an array of Directors objects and the age of the director to be removed
     * Delete the selected Director objects
     * Return the array
     *
     * @param age age of the director to delete
     * @param newDirector array of directors
     * @return the modified array
     */
    public Directors [] directorsDeleteByAge(int age,Directors[] newDirector) 
    {
        for(int i=0;i<newDirector.length;i++) 
        {
            if(age == newDirector[i].getAge())
            {
                System.out.println("Attributes deleted: " + newDirector[i]);
                System.arraycopy(newDirector, i+1, newDirector, i, newDirector.length-i-1);
                newDirector = Arrays.copyOf(newDirector, newDirector.length-1) ;
            }
        }
        return newDirector;
    }
    
    /**
     * Takes an array of Director objects and the name of the award the director has won.
     * Removes selected Director objects from the array and returns the updated array.
     *
     * @param awards awards of the director to delete
     * @param array array of directors
     * @return the modified array
     */
    public Directors[] directorsDeleteByAwards(String awards, Directors[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(awards.equalsIgnoreCase(array[i].getAwards()))
            {
                System.out.println("Attributes deleted " + array[i]);
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                array = Arrays.copyOf(array, array.length - 1);
            }
        }
        return array;
    }
    
    /**
     * Takes an array of Director objects, the name of the Director to search for, and the new name to replace it with.
     * Modifies the selected Director objects and returns the updated array.
     *
     * @param array array of directors
     * @param name name to modify
     * @param newName the new name
     * @return the modified array
     */
    public Directors[] directorsModifyByName(Directors[] array, String name, String newName)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(name.equalsIgnoreCase(array[i].getName()))
            {
                System.out.println("Director to modify "+array[i]);
                array[i].setName(newName);
                System.out.println("Director modified "+array[i]);
            }
        }
        return array;
    }
    
    /**
     * Takes an array of Director objects, the LastName of the Director to search for, and the new LastName to replace it with.
     * Modifies the selected Director objects and returns the updated array.
     *
     * @param array array of directors
     * @param lastName new last name to modify
     * @param newLastName the new last name
     * @return the modified array
     */
    public Directors[] directorsModifyByLastName(Directors[] array, String lastName, String newLastName)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(lastName.equalsIgnoreCase(array[i].getLastName()))
            {
                System.out.println("Director to modify "+array[i]);
                array[i].setLastName(newLastName);
                System.out.println("Director modified "+array[i]);
            }
        }
        return array;
    }
    
    /**
     * Takes an array of Director objects, the gender of the Director to search for, and the new gender to replace it with.
     * Modifies the selected Director objects and returns the updated array.
     *
     * @param array array of directors
     * @param gender gender to modifi
     * @param newGender the new gender
     * @return the modified array
     */
    public Directors[] directorsModifyByGender(Directors[] array, Gender gender, Gender newGender)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(gender.equals(array[i].getGender()))
            {
                System.out.println("Director to modify "+array[i]);
                array[i].setGender(newGender);
                System.out.println("Director modified "+array[i]);
            }
        }
        return array;
    }
    
    /**
     * Takes an array of Director objects, the age of the Director to search for, and the new age to replace it with.
     * Modifies the selected Director objects and returns the updated array.
     * @param array array of directors
     * @param age age top modify
     * @param newAge the new age
     * @return the modified array
     */
    public Directors[] directorsModifyByAge(Directors[] array, int age, int newAge)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(age == (array[i].getAge()))
            {
                System.out.println("Director to modify "+array[i]);
                array[i].setAge(newAge);
                System.out.println("Director to modified "+array[i]);
            }
        }
        return array;
    }
    
    /**
     * Takes an array of Directors objects, the award of the Director to be searched, and its replacement
     * Deletes the selected Director objects
     * @param array array of directors
     * @param awards awards to modify
     * @param newAward the new awards
     * @return the modified array
     */
    public Directors[] directorsModifyByAward(Directors[] array, String awards, String newAward)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(awards.equalsIgnoreCase(array[i].getAwards())) 
            {
                System.out.println("Director to modify "+array[i]);
                array[i].setAwards(newAward);
                System.out.println("Director to modify "+array[i]);
            }
        }
        return array;
    }
    
    /**
     * Takes an array of Directors objects and the name of the Director to be searched
     * Searches for the Director objects
     * Displays them on the screen
     * @param array array of directors
     * @param name name to search
     */
    public void directorsSearchByName(Directors[] array, String name)
    {
        boolean found = false;
        for(int i = 0; i < array.length; i++)
        {
            if(name.equalsIgnoreCase(array[i].getName()))
            {
                System.out.println(array[i]);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("The name " + name + " does not exist");
        }
    }
    
    /**
     * Takes an array of Directors objects and the last name of the Director to be searched
     * Searches for the Director objects
     * Displays them on the screen
     * @param array array of directors
     * @param lastName last name to search
     */
    public void directorsSearchByLastName(Directors[] array, String lastName)
    {
        boolean found = false;
        for(int i = 0; i < array.length; i++)
        {
            if(lastName.equalsIgnoreCase(array[i].getLastName()))
            {
                System.out.println(array[i]);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("The name " + lastName + " does not exist");
        }
    }
    
    /**
     * Takes an array of Directors objects and the gender of the Director to be searched
     * Searches for the Director objects
     * Displays them on the screen
     * @param array array of directors
     * @param gender gender to search
     */
    public void directorsSearchByGender(Directors[] array, Gender gender)
    {
        boolean found = false;
        for(int i = 0; i < array.length; i++)
        {
            if(gender.equals(array[i].getGender()))
            {
                System.out.println(array[i]);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("The name " + gender + " does not exist");
        }
    }
    
    /**
     * Takes an array of Directors objects and the age of the Director to be searched
     * Searches for the Director objects
     * Displays them on the screen
     * @param array array of directors
     * @param age age to search
     */
    public void directorsSearchByAge(Directors[] array, int age)
    {
        boolean found = false;
        for(int i = 0; i < array.length; i++)
        {
            if(age == array[i].getAge())
            {
                System.out.println(array[i]);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("The age " + age + " does not exist");
        }
    }
    
    /**
     * An Array of Directors objects is requested and the awards of the Director to be fetched
     * Director objects are searched
     * Shown on screen
     * @param array array of directors
     * @param awards awards to search
     */
    public void directorsSearchByAwards(Directors[] array,String awards) 
    {
        boolean found = false;
        for(int i = 0;i<array.length;i++)
        {
            if(awards.equalsIgnoreCase( array[i].getAwards())) 
            {
                System.out.println(array[i]);
                found = true;
            }
        }		
        if (!found) 
        {
            System.out.println("The award "+awards+" does not exist");
        }
    }	
}
