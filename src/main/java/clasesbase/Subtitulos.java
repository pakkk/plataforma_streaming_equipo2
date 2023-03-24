package clasesbase;

public class Subtitulos {
	//Esta clase se encarga de cargar los datos de los subtitulos para despues almacenarlos en un array
	//Atributos
	//String idioma: Atributo que define en que idioma estara el subtitulo
	private String idioma;
	//Constructor 
	//Constructor que determina el valor de idioma
    public Subtitulos(String idioma)
    {
        this.idioma = idioma;
    }
    //Gettters
    //Get de idioma que devuelve el valor del atributo
    public String getIdioma() 
    {
        return this.idioma;
    }
    //Setters
    //Set de idioma que permite cambiar su valor
    public void setIdioma(String idioma)
    {
        this.idioma = idioma;
    }
    //ToString de idioma que muestra su valor
    @Override
    public String toString()
    {
        return "Subtitulos{" + "idiomas=" + this.idioma + '}';
    }

    
    
    
}
