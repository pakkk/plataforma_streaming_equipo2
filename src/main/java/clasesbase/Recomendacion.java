package clasesbase;
import enums.TipoValoracion;

public class Recomendacion {
    // This class is responsible for loading recommendation data and storing it in an array.

    // Attributes
    // Attribute TipoValoracion valoracion: An enum attribute that defines the type of rating (Positive and negative)
    // Attribute String comentarios: An attribute that defines the comment of the recommendation. If it is not entered, by default it is without comment.
    private TipoValoracion valoracion;
    private String comentarios;

    // Constructor
    // Constructor that determines the values of valoracion and comentarios.
    public Recomendacion(TipoValoracion valoracion, String comentarios)
    {
        this.valoracion = valoracion;
        this.comentarios = comentarios;
        attributeCorrection();
    }

    // Getters and Setters
    // Getter of valoracion that returns its value.
    public TipoValoracion getValoracion()
    {
        return this.valoracion;
    }

    // Setter of valoracion that allows modifying its value.
    public void setValoracion(TipoValoracion valoracion)
    {
        this.valoracion = valoracion;
    }

    // Getter of comentarios that returns its value.
    public String getComentarios()
    {
        return this.comentarios;
    }

    // Setter of comentarios that allows modifying its value.
    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }

    // Private method to set the default value of the comentarios attribute.
    private void attributeCorrection()
    {
        if(comentarios.isEmpty())
            comentarios="Without comment";
    }

    // toString that shows the values of valoracion and comentarios.
    @Override
    public String toString()
    {
        return "Rating " + valoracion+ " comment " + comentarios ;
    }
}
