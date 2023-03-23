package clasesbase;
import java.util.Scanner;
import enums.Sexo;

public class Actores{
	Scanner sc = new Scanner (System.in);
    //Atributos 
    private String nombre;
    private String apellidos;
    private Sexo gender;
    private int edad;
    private String premios;
    //Constructor 
    public Actores(String nombre, String apellidos, Sexo gender, int edad, String premios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.gender = gender;
        this.edad = edad;
        this.premios = premios;
        CorreccionAtributos();
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public String getPremios() {
        return premios;
    }
    
    public Sexo getGender() {
    	return gender;
    }
    
    public int getEdad() {
        return edad;
    }
    //Setters
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setGender(Sexo gender) {
        this.gender = gender;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public void setPremios(String premios) {
        this.premios = premios;
    }
    private void CorreccionAtributos()
    {
    	while(nombre.isEmpty())
    	{
    		System.out.println("Error nombre vacio vuelva a introducirlo");
    		nombre = sc.nextLine();
    	}
    	while(apellidos.isEmpty())
    	{
    		System.out.println("Error apellido vacio vuelva a introducirlo");
    		apellidos = sc.nextLine();
    	}
    	while(edad<0)
    	{
    		System.out.println("Error edad negativa introducida vuelve a introducirla");
    		edad = sc.nextInt();
    	}
    	if(premios.isEmpty())
    	{
    		premios = "Sin premios";
    	}
    }
    //toString
    @Override
    public String toString() {
        return "Actor "+ nombre + " " + apellidos +" de edad "+ edad +" ha ganado " + premios;
    }
     
}