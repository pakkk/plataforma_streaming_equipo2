package es.iesjandula.streaming.baseclasses;
public class Category {
    // This class is responsible for loading category data and storing it in an array
    // Attributes 
    /*
     * String attribute "name": defines the name of the category
     * String attribute "decription": defines the description of the category
     */
    private String name;
    private String description;

    // Constructor
    // This constructor sets the values of the "name" and "description" attributes
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        fixAttributes();
    }

    // Getters and Setters
    // Getter that returns the value of the category name
    public String getName() {
        return this.name;
    }

    // Setter that allows modifying the value of the category name
    public void setName(String name) {
        this.name = name;
    }

    // Getter that returns the value of the category description
    public String getDescription() {
        return this.description;
    }

    // Setter that allows modifying the value of the category description
    public void setDescription(String decription) {
        this.description = decription;
    }

    // This method sets default values for attributes that are not provided
    private void fixAttributes() {
        if (name.isEmpty()) {
            this.name = "Unnamed";
        }
        if (description.isEmpty()) {
            this.description = "No description";
        }
    }

    // toString method that displays the values of the "name" and "decription" attributes
    @Override
    public String toString() {
        return "Category{" + " Name = " + this.name + "\n"
                + "Description = " + this.description + '}';
    }
}