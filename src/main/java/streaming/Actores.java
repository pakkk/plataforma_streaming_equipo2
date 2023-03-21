package streaming;

public class Actores{
    
    private String nombre;
    private String apellidos;
    private Sexo s;
    private int edad;
    private String premios;

    public Actores(String nombre, String apellidos, Sexo s, int edad, String premios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.s = s;
        this.edad = edad;
        this.premios = premios;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    @Override
    public String toString() {
        return "actores{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + s + ", edad=" + edad + ", premios=" + premios + '}';
    }
     
}