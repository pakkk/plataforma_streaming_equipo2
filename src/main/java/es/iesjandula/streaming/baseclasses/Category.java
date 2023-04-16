package es.iesjandula.streaming.baseclasses;

/**
 * -This class is responsible for loading category data and storing it in an array
 * @author Javier
 *
 */
public class Category
{

	/**String attribute "name": defines the name of the category*/
    private String name;

    /**String attribute "decription": defines the description of the category*/
    private String description;

    /**Constructor
     * This constructor sets the values of the "name" and "description" attributes
     *
     * @param name the name of category
     * @param description the description of category
     */
    public Category(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.fixAttributes();
    }

    /*Getter and Setter*/

    /**Getter
     * @return that returns the value of the category name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Setter that allows modifying the value of the category name
     * @param name the name of the category
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter
     * @return that returns the value of the category description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Setter that allows modifying the value of the category description
     * @param return the description decription
     */
    public void setDescription(String decription)
    {
        this.description = decription;
    }

    /**
     * This method sets default values for attributes that are not provided
     */
    private void fixAttributes()
    {
        if (this.name.isEmpty())
        {
            this.name = "Unnamed";
        }
        if (this.description.isEmpty())
        {
            this.description = "No description";
        }
    }

    /**
     * toString method that displays the values of the "name" and "decription" attributes
     * @return return String with the information
     */
    @Override
    public String toString()
    {
        return "Category{" + " Name = " + this.name + "\n"
                + "Description = " + this.description + '}';
    }
}