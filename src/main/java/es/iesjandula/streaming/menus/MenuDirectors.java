package es.iesjandula.streaming.menus;

import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Directors;
import es.iesjandula.streaming.enums.Gender;

public class MenuDirectors 
{
	
	// Class responsible for storing the methods for adding, deleting, querying, and searching Directors

	public Directors[] DirectorsAdd(Directors[] newDirector, String name, String lastName, Gender gender, int age, String awards) 
	{
	    /* Request an array of Directors objects and their attributes
	     * Add a Director to the array
	     * Return the array
	     */
	    newDirector = Arrays.copyOf(newDirector, newDirector.length+1);
	    newDirector[newDirector.length-1] = new Directors(name,lastName,gender,age,awards);
	    return newDirector;
	}

	public Directors [] DirectorsDeleteByName(String name,Directors[] newDirector) 
	{
	    /* Request an array of Directors objects and the name of the director to be removed
	     * Delete the selected Director objects
	     * Return the array
	     */
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

	public Directors [] DirectorsDeleteByLastName(String lastName,Directors[] newDirector) 
	{
	    /* Request an array of Directors objects and the last name of the director to be removed
	     * Delete the selected Director objects
	     * Return the array
	     */
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

	public Directors [] DirectorsDeleteByGender(Gender gender,Directors[] newDirector) 
	{
	    /* Request an array of Directors objects and the gender of the director to be removed
	     * Delete the selected Director objects
	     * Return the array
	     */
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

	public Directors [] DirectorsDeleteByAge(int age,Directors[] newDirector) 
	{
	    /* Request an array of Directors objects and the age of the director to be removed
	     * Delete the selected Director objects
	     * Return the array
	     */
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
   
	public Directors[] DirectorsDeleteByAwards(String awards, Directors[] array)
	{
	/* Takes an array of Director objects and the name of the award the director has won.
	* Removes selected Director objects from the array and returns the updated array.
	*/
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

	public Directors[] DirectorsModifyByName(Directors[] array, String name, String newName)
	{
	/* Takes an array of Director objects, the name of the Director to search for, and the new name to replace it with.
	* Modifies the selected Director objects and returns the updated array.
	*/
		for(int i = 0; i < array.length; i++)
		{
			if(name.equalsIgnoreCase(array[i].getName()))
			{
			System.out.println("Description " + name + " modified to " + newName);
			array[i].setName(newName);
			}
		}
		return array;
	}

	public Directors[] DirectorsModifyByLastName(Directors[] array, String LastName, String newLastName)
	{
	/* Takes an array of Director objects, the LastName of the Director to search for, and the new LastName to replace it with.
	* Modifies the selected Director objects and returns the updated array.
	*/
		for(int i = 0; i < array.length; i++)
		{
			if(LastName.equalsIgnoreCase(array[i].getLastName()))
			{
			System.out.println("Description " + LastName + " modified to " + newLastName);
			array[i].setLastName(newLastName);
			}
		}
		return array;
	}

	public Directors[] DirectorsModifyByGender(Directors[] array, Gender gender, Gender newGender)
	{
	/* Takes an array of Director objects, the gender of the Director to search for, and the new gender to replace it with.
	* Modifies the selected Director objects and returns the updated array.
	*/
		for(int i = 0; i < array.length; i++)
		{
			if(gender.equals(array[i].getGender()))
			{
			System.out.println("Description " + gender + " modified to " + newGender);
			array[i].setGender(newGender);
			}
		}
		return array;
		}

	public Directors[] DirectorsModifyByAge(Directors[] array, int age, int newAge)
	{
	/* Takes an array of Director objects, the age of the Director to search for, and the new age to replace it with.
	* Modifies the selected Director objects and returns the updated array.
	*/
		for(int i = 0; i < array.length; i++)
		{
			if(age == (array[i].getAge()))
			{
			System.out.println("Description " + age + " modified to " + newAge);
			array[i].setAge(newAge);
			}
		}
		return array;
	}

	public Directors[] DirectorsModifyByAward(Directors[] array, String awards, String newAward)
	{
	/* Takes an array of Directors objects, the award of the Director to be searched, and its replacement
	* Deletes the selected Director objects
	* Returns the array
	*/
		for(int i = 0; i < array.length; i++)
		{
			if(awards.equalsIgnoreCase(array[i].getAwards())) 
			{
			System.out.println("Description " + awards + " modified by " + newAward);
			array[i].setAwards(newAward);
			}
		}
		return array;
	}

	public void DirectorsSearchByName(Directors[] array, String name)
	{
	/* Takes an array of Directors objects and the name of the Director to be searched
	* Searches for the Director objects
	* Displays them on the screen
	*/
		boolean found = false;
		for(int i = 0; i < array.length; i++)
		{
			if(name.equalsIgnoreCase(array[i].getName()))
			{
				System.out.println(array[i]);
				found = true;
			}
		}
		if (found == false)
			System.out.println("The name " + name + " does not exist");

	}

	public void DirectorsSearchByLastName(Directors[] array, String lastName)
	{
	/* Takes an array of Directors objects and the last name of the Director to be searched
	* Searches for the Director objects
	* Displays them on the screen
	*/
		boolean found = false;
		for(int i = 0; i < array.length; i++)
		{
			if(lastName.equalsIgnoreCase(array[i].getLastName()))
			{
				System.out.println(array[i]);
				found = true;
			}
		}
		if (found == false)
			System.out.println("The name " + lastName + " does not exist");

	}

	public void DirectorsSearchByGender(Directors[] array, Gender gender)
	{
	/* Takes an array of Directors objects and the gender of the Director to be searched
	* Searches for the Director objects
	* Displays them on the screen
	*/
		boolean found = false;
		for(int i = 0; i < array.length; i++)
		{
			if(gender.equals(array[i].getGender()))
			{
				System.out.println(array[i]);
				found = true;
			}
		}
		if (found == false)
			System.out.println("The name " + gender + " does not exist");
	}

	public void DirectorsSearchByAge(Directors[] array, int age)
	{
	/* Takes an array of Directors objects and the age of the Director to be searched
	* Searches for the Director objects
	* Displays them on the screen
	*/
		boolean found = false;
		for(int i = 0; i < array.length; i++)
		{
			if(age == array[i].getAge())
			{
				System.out.println(array[i]);
				found = true;
			}
		}
		if (found == false)
			System.out.println("The age " + age + " does not exist");
	}
    public void DirectorsSearchByAwards(Directors[] array,String awards) 
    {
        /* An Array of Directors objects is requested and the awards of the Director to be fetched
         * Director objects are searched
         * Shown on screen
         */		
        boolean found = false;
        for(int i = 0;i<array.length;i++)
        {
            if(awards.equalsIgnoreCase( array[i].getAwards())) 
            {
                System.out.println(array[i]);
                found = true;
            }
        }		
        if (found==false) 
        	System.out.println("The award "+awards+" does not exist");
    }
		
}
