package clasesbase;
public class Categorias {
	//Esta clase se encarga de cargar los datos de las categorias para despues almacenarlo en un array
	//Atributos 
	/*
	 * Atributo String nombre: Atributo que define el nombre de la categoria
	 * Atributo String descripcion: Atributo que define la descripcion de la categoria
	 */
	private String nombre;
    private String descripcion;
    //Constructor
    //Este constructor determina los valores de los atributos nombre y descripcion
    public Categorias(String nombre, String descripcion) 
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        CorreccionAtributos();
    }
    //Getters y Setters
    //Getter que devuelve el valor del nombre de la categoria
    public String getNombre() 
    {
        return this.nombre;
    }
    //Setter que permite modificar el valor del nombre de la categoria
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    //Getter que devuelve el valor de la descripcion de la categoria
    public String getDescripcion() 
    {
        return this.descripcion;
    }
    //Setter que permite modificar el valor de la descripcion de la categoria
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    //Este metodo sirve para establecer por defecto los atributos que no se introduzcan
    private void CorreccionAtributos()
    {
    	if(nombre.isEmpty())
    	{
    		this.nombre = "Sin nombre";
    	}
    	if(descripcion.isEmpty())
    	{
    		descripcion = "Sin despcripcion";
    	}
    }
    //toString que muestra los valores de los atributos nombre y descripcion
    @Override
    public String toString() 
    {
        return "Categoria{" + " Nombre = " + nombre + "\n"
        		+  "Descripcion = " + descripcion + '}';
    }
    
    
}
