package clasesbase;
import java.util.Scanner;
import enums.Sexo;

public class Directores {
	Scanner sc = new Scanner (System.in);
	//Atributos 
	private String nombre,apellido;
    private Sexo gender;
    private int edad;
    private String premios;
    //Constructor
    public Directores(String nombre, String apellido, Sexo gender, int edad, String premios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.gender = gender;
        this.edad = edad;
        this.premios = premios;
        CorreccionAtributos();
    }
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Sexo getSexo() {
        return gender;
    }

    public void setSexo(Sexo s) {
        this.gender = gender;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPremios() {
        return premios;
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
    	while(apellido.isEmpty())
    	{
    		System.out.println("Error apellido vacio vuelva a introducirlo");
    		apellido = sc.nextLine();
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
        return "Directores: " +
                "nombre= " + nombre + '\'' +
                ", apellido= " + apellido + '\'' +
                ", sexo= " + gender +
                ", edad= " + edad +
                ", premios= " + premios ;
    }
	

}