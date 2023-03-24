package es.iesjandula.streaming.baseclasses;
import enums.TipoValoracion;
public class Recomendacion {
	//Esta clase se encarga de cargar los datos de las recomendaciones para despues almacenarlas en un array
   //Atributos
   //Atributo TipoValoracion valoracion: Atributo de tipo enum que define el tipo de valoracion (Positiva y negativa)
   //Atributo String comentario: Atributo que define el comentario de la recomendacion si llegara a no introducirse por defecto es sin comentario
   private TipoValoracion valoracion;
   private String comentarios;
   //Constructor
   //Constructor que determina los valores de valoracion y comentarios
    public Recomendacion(TipoValoracion valoracion, String comentarios) 
    {
        this.valoracion = valoracion;
        this.comentarios = comentarios;
        CorreccionAtributos();
    }
    //Getters y Setters
    //Getter de valoracion que devuelve su valor
    public TipoValoracion getValoracion()
    {
    	return this.valoracion;
    }
    //Setter de valoracion que permite modificar su valor
    public void setValoracion(TipoValoracion valoracion)
    {
    	this.valoracion = valoracion;
    }
    //Getter de comentario que devuelve su valor
    public String getComentarios() 
    {
        return this.comentarios;
    }
    //Setter de comentario que permite modificar su valor
    public void setComentarios(String comentarios) 
    {
        this.comentarios = comentarios;
    }
    //Metodo privado para establecer el valor por defecto del atributo comentario
    private void CorreccionAtributos()
    {
    	if(comentarios.isEmpty())
    		comentarios="Sin comentarios";
    }
    //toString que muestra los valores de valoracion y comentarios
    @Override
    public String toString() 
    {
        return "Valoracion " + valoracion+ " comentario " + comentarios ;
    }
}