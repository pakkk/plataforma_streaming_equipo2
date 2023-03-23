package clasesbase;
import enums.Sexo;

public class Actores{
    //Atributos 
    private String nombre;
    private String apellidos;
    private Sexo gender;
    private int edad;
    private String premios;
    
    //Constructor que define los atributos del actor
    public Actores(String nombre, String apellidos, Sexo gender, int edad, String premios) 
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.gender = gender;
        this.edad = edad;
        this.premios = premios;
        CorreccionAtributos();
    }
    
    //Getters
    //Getter que devuelve el nombre del actor
    public String getNombre() 
    {
        return this.nombre;
    }
    //Getter que devuelve los apellidos del actor
    public String getApellidos() 
    {
        return this.apellidos;
    }
    //Getter que devuelve los premios del actor
    public String getPremios() 
    {
        return this.premios;
    }
    //Getter que devuelve el genero del actor
    public Sexo getGender() 
    {
    	return this.gender;
    }
    //Getter que devuelve la edad del actor
    public int getEdad() 
    {
        return this.edad;
    }
    
    //Setters
    //Setter que permite modificar el nombre del autor
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    //Setter que permite modificar los apellidos del autor
    public void setApellidos(String apellidos) 
    {
        this.apellidos = apellidos;
    }
    //Setter que permite modificar el genero del autor
    public void setGender(Sexo gender) 
    {
        this.gender = gender;
    }
    //Setter que permite modificar la edad del autor
    public void setEdad(int edad) 
    {
        this.edad = edad;
    }
    //Setter que permite modificar los premios del autor
    public void setPremios(String premios) 
    {
        this.premios = premios;
    }
    
    //Este metodo sirve para establecer los atributos por defecto en caso de que no sean introducidos
    private void CorreccionAtributos()
    {
    	while(nombre.isEmpty())
    	{
            this.nombre = "Sin nombre";
    	}
    	while(apellidos.isEmpty())
    	{
            this.apellidos = "Sin apellidos";
    	}
    	while(edad<0)
    	{
            this.edad = 18;
    	}
    	if(premios.isEmpty())
    	{
            this.premios = "Sin premios";
    	}
    }
    
    //toString que muestra los valores de los atributos del actor
    @Override
    public String toString() 
    {
        return "Actor "+ nombre + " " + apellidos +" de edad "+ edad +" ha ganado " + premios;
    }
     
}