package clasesbase;
import java.util.Scanner;
public class Categorias {
	Scanner sc = new Scanner (System.in);
	//Atributos 
	private String nombre;
    private String descripcion;
    //Constructor
    public Categorias(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private void CorreccionAtributos()
    {
    	while(nombre.isEmpty())
    	{
    		System.out.println("Error nombre vacio vuelve a introducirlo");
    		nombre = sc.nextLine();
    	}
    	if(descripcion.isEmpty())
    	{
    		descripcion = "Sin despcripcion";
    	}
    }
    //toString
    @Override
    public String toString() {
        return "Categoria{" + " Nombre = " + nombre + ""
        		+  "\nDescripcion = " + descripcion + '}';
    }
    
    
}
