package streaming;

public class Directores {
	//Atributos 
	private String nombre,apellido;
    private Sexo s;
    private int edad;
    private String premios;
    //Constructor
    public Directores(String nombre, String apellido, Sexo s, int edad, String premios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.s = s;
        this.edad = edad;
        this.premios = premios;
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
        return s;
    }

    public void setSexo(Sexo s) {
        this.s = s;
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
    //toString
    @Override
    public String toString() {
        return "Directores: " +
                "nombre= " + nombre + '\'' +
                ", apellido= " + apellido + '\'' +
                ", sexo= " + s +
                ", edad= " + edad +
                ", premios= " + premios ;
    }
	

}