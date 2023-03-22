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
        CorreccionAtributos();
    }
    //Getters y Setters
    public String getNombre() {
        return this.nombre;
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
    	while(this.nombre.isEmpty())
    	{
    		System.out.println("Error nombre vacio vuelve a introducirlo");
    		this.nombre = sc.nextLine();
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
