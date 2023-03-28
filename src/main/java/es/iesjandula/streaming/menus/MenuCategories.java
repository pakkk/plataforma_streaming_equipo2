package es.iesjandula.streaming.menus;

import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Category;

public class MenuCategories
{
	
	// Class that stores methods for adding, deleting, querying and searching Categories

	public Category[] addCategory(Category[] categoryArray, String name, String description) 
	{
		/* 
		 * Takes an array of Category objects
		 * Adds a new category to the array
		 * Returns the updated array
		 */
		categoryArray = Arrays.copyOf(categoryArray, categoryArray.length+1);
		categoryArray[categoryArray.length-1] = new Category(name, description);

		return categoryArray;
	}

	public Category[] deleteCategoryByName(String name, Category[] categoryArray) 
	{
		/* 
		 * Takes an array of Category objects and the name of the category to delete
		 * Deletes the selected categories from the array
		 * Returns the updated array
		 */
		for(int i=0; i<categoryArray.length; i++) 
		{
			if(name.equalsIgnoreCase(categoryArray[i].getName()))  
			{
				System.out.println("Attributes deleted " + categoryArray[i]);
				System.arraycopy(categoryArray, i+1, categoryArray, i, categoryArray.length-i-1);
				categoryArray = Arrays.copyOf(categoryArray, categoryArray.length-1) ;

			}
		}

		return categoryArray;
	}

	public Category[] deleteCategoryByDescription(String description, Category[] categoryArray) 
	{
		/* 
		 * Takes an array of Category objects and the description of the category to delete
		 * Deletes the selected categories from the array
		 * Returns the updated array
		 */
		for(int i=0; i<categoryArray.length; i++)
		{
			if(description.equalsIgnoreCase(categoryArray[i].getDescription())) 
			{
				System.out.println("Attributes deleted " + categoryArray[i]);
				System.arraycopy(categoryArray, i+1, categoryArray, i, categoryArray.length-i-1);
				categoryArray = Arrays.copyOf(categoryArray, categoryArray.length-1) ;			
			}
		}

		return categoryArray;
	}

		
	public Category[] modifyCategoryByName(Category[] categoryArray, String name, String newName) 
	{
		/* 
		 * 
		 * Takes an array of Category objects, the name of the category to search for, and its replacement
		 * Replaces the selected categories in the array
		 * Returns the updated array
		 */
		for(int i = 0; i < categoryArray.length; i++) 
		{
			if(name.equalsIgnoreCase(categoryArray[i].getName())) 
			{
				System.out.println("Description "+ name +" modified to " + newName);
				categoryArray[i].setName(newName);
			}
		}		
		return categoryArray;
	}

	public Category[] modifyCategoryByDescription(Category[] categoryArray, String description, String newDescription) 
	{
		/* 
		 * Takes an array of Category objects, the description of the category to search for, and its replacement
		 * Replaces the selected categories in the array
		 * Returns the updated array
		 */
		for(int i = 0; i < categoryArray.length; i++) 
		{
			if(description.equalsIgnoreCase(categoryArray[i].getDescription())) 
			{
				System.out.println("Description "+ description +" modified to " + newDescription);
				categoryArray[i].setName(newDescription);
			}
		}		
		return categoryArray;
	}



	public void searchCategoryByName(Category[] categoryArray, String name) 
	{
		/*
		* Takes an array of Category objects and the name of the category to search for
		* Searches for the categories in the array
		* Displays the result on the screen
		*/
		boolean found = false;
		for(int i = 0; i < categoryArray.length; i++) 
		{
			if(name.equalsIgnoreCase(categoryArray[i].getName())) 
			{
					System.out.println(categoryArray[i]);
					found = true;
			}
		}
		if (!found) 
		{
			System.out.println("The name " + name + " does not exist");
		}
	}

	public void searchCategoryByDescription(Category[] categoryArray, String description) 
	{
		/*
		* Takes an array of Category objects and the description of the category to search for
		* Searches for the categories in the array
		* Displays the result on the screen
		*/
		boolean found = false;
			for(int i = 0; i < categoryArray.length; i++) 
			{
				if(description.equalsIgnoreCase(categoryArray[i].getDescription()))
				{
					System.out.println(categoryArray[i]);
					found = true;
				}
					
			}
		if (!found) 
		{
			System.out.println("The description " + description + " does not exist");
		}
	}
}

