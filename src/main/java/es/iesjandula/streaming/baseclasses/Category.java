package es.iesjandula.streaming.baseclasses;
public class Category {
    // This class is responsible for loading category data and storing it in an array
    // Attributes 
    /*
     * String attribute "name": defines the name of the category
     * String attribute "decription": defines the description of the category
     */
    private String name;
    private String decription;

    // Constructor
    // This constructor sets the values of the "name" and "decription" attributes
    public Category(String name, String decription) {
        this.name = name;
        this.decription = decription;
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
    public String getDecription() {
        return this.decription;
    }

    // Setter that allows modifying the value of the category description
    public void setDecription(String decription) {
        this.decription = decription;
    }

    // This method sets default values for attributes that are not provided
    private void fixAttributes() {
        if (name.isEmpty()) {
            this.name = "Unnamed";
        }
        if (decription.isEmpty()) {
            this.decription = "No description";
        }
    }

    // toString method that displays the values of the "name" and "decription" attributes
    @Override
    public String toString() {
        return "Category{" + " Name = " + this.name + "\n"
                + "Description = " + this.decription + '}';
    }
}