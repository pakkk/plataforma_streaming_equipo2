package clasesbase;
import enums.Sexo;

public class Directores {
	//Esta clase se encarga de cargar los datos de los directores para despues almacenarlo en un array
	//Atributos 
	/*
	 * Atributo String nombre: Define el nombre del director
	 * Atributo String apellido:Define el apellido del dorector
	 * Atributo Sexo gender:Define el sexo del director
	 * Atributo int edad:Define la edad del director
	 * Atributo String premios:Define que tipo de premios ha ganado el director
	 */
	private String nombre,apellido;
    private Sexo gender;
    private int edad;
    private String premios;
    //Constructor
    //Este constructor se encarga de determinar los valores de nombre,apellido,gender,edad y premios
    public Directores(String nombre, String apellido, Sexo gender, int edad, String premios) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.gender = gender;
        this.edad = edad;
        this.premios = premios;
        CorreccionAtributos();
    }
    //Getters y Setters
    //Getter que devuelve el valor del nombre del director
    public String getNombre() 
    {
        return this.nombre;
    }
    //Setter que permite modificar el valor del nombre del director
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    //Getter que devuelve el valor del apellido del director
    public String getApellido()
    {
        return this.apellido;
    }
    //Setter que permite modificar el valor del apellido del director
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    //Getter que devuelve el valor del sexo del director
    public Sexo getGender()
    {
        return this.gender;
    }
    //Setter que permite modificar el valor del sexo del director
    public void setGender(Sexo gender)
    {
        this.gender = gender;
    }
    //Getter que devuelve el valor de la edad del director
    public int getEdad()
    {
        return this.edad;
    }
    //Setter que permite modificar el valor de la edad del director
    public void setEdad(int edad) 
    {
        this.edad = edad;
    }
    //Getter que devuelve el valor de los premios del director
    public String getPremios() 
    {
        return this.premios;
    }
    //Setter que permite modificar los premios del director
    public void setPremios(String premios)
    {
        this.premios = premios;
    }
    //Metodo para establecer los atributos por defecto en caso de que no se introduzcan
    private void CorreccionAtributos()
    {
    	if(nombre.isEmpty())
    	{
    		this.nombre = "Sin nombre";
    	}
    	if(apellido.isEmpty())
    	{
    		this.apellido = "Sin apellido";
    	}
    	if(edad<=0)
    	{
    		this.edad = 18; 
    	}
    	if(premios.isEmpty())
    	{
    		this.premios = "Sin premios";
    	}
    }
    //toString que muestra el valor de los atributos nombre,apellido,sexo,edad y premios
    @Override
    public String toString() 
    {
        return "Directores: " +
                "nombre= " + nombre + '\'' +
                ", apellido= " + apellido + '\'' +
                ", sexo= " + gender +
                ", edad= " + edad +
                ", premios= " + premios ;
    }
	

}