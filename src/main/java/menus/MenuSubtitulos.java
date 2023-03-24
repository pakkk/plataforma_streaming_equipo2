package menus;
import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Subtitulos;

public class MenuSubtitulos  {
    //La clase hace un alta, bajas, modificaciones y busquedas de subtitulos en una pelicula o serie

    //Este metodo realiza una alta de subtitulos en una serie o pelicula
    //Este metodo se le pasa como parametro un array de subtitulos y sus atributos
    //Se devuelve el array modificado
    public Subtitulos [] SubtitulosAlta(Subtitulos [] nuevo, String idioma)
    {
        nuevo = Arrays.copyOf(nuevo,nuevo.length+1);
        nuevo[nuevo.length-1]= new Subtitulos(idioma);
        return nuevo;
    }

    //Este metodo realiza una baja de subtitulos en una serie o pelicula segun su atributo
    //Este metodo se le pasa como parametro un array de subtitulos y sus atributos
    //Se devuelve el array modificado
    public Subtitulos [] SubtitulosBajas(Subtitulos [] baja, String idioma)
    {
        for (int i = 0 ; i < baja.length ; i++)
        {
            if (idioma.equalsIgnoreCase((baja[i]).getIdioma()))
            {
                System.out.println("Idioma borrado " + baja[i]);
                System.arraycopy(baja, i+1, baja, i, baja.length-i-1);
                baja = Arrays.copyOf(baja, baja.length-1) ;
            }
        }
        return baja;
    }

    //Este metodo realiza una modificacion de subtitulos en una serie o pelicula cambiando su atributo viejo por uno nuevo
    //Este metodo se le pasa como parametro un array de subtitulos y sus atributos
    //Se devuelve el array modificado
    public Subtitulos [] modificacionIdioma(Subtitulos [] modificacion, String idioma, String nuevoIdioma)
    {
        for(int i = 0;i<modificacion.length;i++)
        {
            if(idioma.equalsIgnoreCase((modificacion[i]).getIdioma()))
            {
                System.out.println("Descripcion "+ idioma +" modificados por " + nuevoIdioma);
                (modificacion[i]).setIdioma(nuevoIdioma);
            }
        }
        return modificacion;
    }

    //Este metodo realiza una busqueda de subtitulos en una serie o pelicula segun su atributo
    //Este metodo se le pasa como parametro un array de subtitulos y sus atributos
    //En caso de que no se encuentre se avisara al usuario
    public void busquedaPorIdioma(Subtitulos[] busqueda, String idioma)
    {
        boolean encontrado = false;
        for(int i = 0;i<busqueda.length;i++)
        {

            if(idioma.equalsIgnoreCase((busqueda[i]).getIdioma()))
            {
                System.out.println(busqueda[i]);
                encontrado = true;
            }

        }
        if (encontrado==false)
        {
            System.out.println("Su descripcion " + idioma + " no existe");
        }
    }
}