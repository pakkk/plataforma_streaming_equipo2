package clasesbase;

import java.util.Scanner;
import enums.TipoValoracion;
public class RecomendacionPeliculas {
	Scanner sc =  new Scanner (System.in);
   //Atributos
   private TipoValoracion valoracion;
   private String comentarios;
   //Constructor
    public RecomendacionPeliculas(TipoValoracion valoracion, String comentarios) {
        this.valoracion = valoracion;
        this.comentarios = comentarios;
        CorreccionAtributos();
    }
    //Getters y Setters
   
    public TipoValoracion getValoracion(){
    	return valoracion;
    }
    
    public void setValoracion(TipoValoracion valoracion) {
    	this.valoracion = valoracion;
    }
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    private void CorreccionAtributos()
    {
    	if(comentarios.isEmpty())
    		comentarios="Sin comentarios";
    }
    //toString
    @Override
    public String toString() {
        return "Valoracion " + valoracion+ " comentario " + comentarios ;
    }
}