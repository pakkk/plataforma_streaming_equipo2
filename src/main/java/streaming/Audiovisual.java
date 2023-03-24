package streaming;
import java.util.Arrays;

import es.iesjandula.streaming.baseclasses.Actores;
import es.iesjandula.streaming.baseclasses.Category;
import es.iesjandula.streaming.baseclasses.Directores;
import es.iesjandula.streaming.baseclasses.Recomendacion;
import es.iesjandula.streaming.baseclasses.Subtitulos;
public class Audiovisual{
	//Clase padre de serie y pelicula que contendra todos los datos que mas tarde se trasmitiran a dichas clases
	   //Atributos
	   /*
	    * Atributo String titulo: Define el titulo del audiovisual
	    * Atributo idiomaOriginal: Define el idioma original en el que esta el audiovisual
	    * Atributo idiomaAdaptado: Define los idiomas adaptados en los que esta el audiovisual
	    * Atributo int duracion: Define cuanto dura el audiovisual
	    * Atributo int vecesVisto: Define cuantas veces se ha visto el audiovisual
	    * Atributo Actores act []: Array que almacena objetos de actores
	    * Atributo Directores dic []: Array que almacena objetos de directores
	    * Atributo Categorias cat []: Array que almacena objetos de categorias
	    * Atributo Subtitulos sub []: Array que almacena objetos de subtitulos
	    * Atributo Recomendacion rec []: Array que almacena objetos de recomendaciones 
	    */
	   private String titulo;
	   private String idiomaOriginal;
	   private String idiomaAdaptado [];
	   private int duracion;
	   private int vecesVisto;
	   private Actores act [];
	   private Directores dic [];
	   private Category cat [];
	   private Subtitulos sub [];
	   private Recomendacion rec [];
	   
	   //Constructor 
	   //Constructor que determina los valores de los atributos de audiovisual
	   public  Audiovisual (String titulo,String idiomaOriginal,String idiomaAdaptado [],int duracion,int vecesVisto)
	   {
		
		   this.titulo = titulo;
		   this.idiomaOriginal = idiomaOriginal;
		   this.idiomaAdaptado = idiomaAdaptado;
		   this.duracion = duracion;
		   this.vecesVisto = vecesVisto;
		   CorreccionAtributos();
	   }
	   
	   //Getters y Setters
	   //Getter que devuelve el valor del titulo del audiovisual
	    public String getTitulo()
	    {
	        return this.titulo;
	    }
	    //Setter que permite modificar el valor del titulo del audiovisual
	    public void setTitulo(String titulo)
	    {
	        this.titulo = titulo;
	    }
	    //Getter que devuelve el valor del isioma original del audiovisual
	    public String getIdiomaOriginal()
	    {
	        return this.idiomaOriginal;
	    }
	    //Setter que permite modificar el valor del idioma original del audiovisual
	    public void setIdiomaOriginal(String idiomaOriginal)
	    {
	        this.idiomaOriginal = idiomaOriginal;
	    }
	    //Getter que devuelve el Array del idioma adaptado del audiovisual
	    public String[] getIdiomaAdaptado()
	    {
	        return this.idiomaAdaptado;
	    }
	    //Setter que permite la modificacion del array idioma adaptado del audiovisual
	    public void setIdiomaAdaptado(String idiomaAdaptado[])
	    {
	    	this.idiomaAdaptado=idiomaAdaptado;
	    }
	    //Getter que devuelve el valor de la duracion del audiovisual
	    public int getDuracion() 
	    {
	        return this.duracion;
	    }
	    //Setter que permite modificar el valor de la duracion
	    public void setDuracion(int duracion)
	    {
	        this.duracion = duracion;
	    }
	    //Getter que devuelve la cantidad de veces que se ha devuelto el audiovisual
	    public  int getVecesVisto()
	    {
	    	return this.vecesVisto;
	    }
	    //Setter que permite modificar el valor de las veces que se ha visto el audiovisual
	    public void setVecesVisto(int vecesVisto)
	    {
	    	this.vecesVisto = vecesVisto;
	    }
	    //Getter que devuelve el array de actores
	    public Actores [] getActores()
	    {
	    	return this.act;
	    }
	    //Setter que permite modificar le array de actores
	    public void setActores (Actores act [])
	    {
	    	this.act = act;
	    }
	    //Getter que devuelve el array de directores
	    public Directores [] getDirectores()
	    {
	    	return this.dic;
	    }
	    //Setter que permite modificar el array de directores
	    public void setDirectores(Directores dic [])
	    {
	    	this.dic = dic;
	    }
	    //Getter que devuelve el array de categorias
	    public Category [] getCategorias ()
	    {
	    	return this.cat;
	    }
	    //Setter que permite modificar el array de categorias
	    public void setCategorias(Category cat [])
	    {
	    	this.cat = cat;
	    }
	    //Getter que devuelve el array de subtitulos
	    public Subtitulos [] getSubtitulos ()
	    {
	    	return this.sub;
	    }
	    //Setter que permite modificar el array de subtitulos
	    public void setSubtitulos(Subtitulos sub [])
	    {
	    	this.sub = sub;
	    }
	    //Getter que devuelve el array de recomendacion
	    public Recomendacion [] getRecomendacion()
	    {
	    	return this.rec;
	    }
	    //Setter que permite modificar el array de recomendacion
	    public void setRecomendacion(Recomendacion rec [])
	    {
	    	this.rec = rec;
	    }
	    //Metodo que establece por defecto los atributos que se han dejado vacios
		private void CorreccionAtributos()
		{
			if(titulo.isEmpty())
			{
				this.titulo = "Sin titulo";
			}
			if(duracion<=0)
			{
				this.duracion = 60;
			}
			if(idiomaOriginal.isEmpty())
			{
				idiomaOriginal = "Ingles";
			}
			if(vecesVisto<0)
			{
				this.vecesVisto = 0;
			}
		}
		@Override
		public String toString()
		{
			return "nombre "+titulo+" dura "+duracion+" minutos "+" su idioma original es "+idiomaOriginal+ "los idiomas adaptados son " + Arrays.toString(idiomaAdaptado) + "y se ha visto" + vecesVisto;
		}
		}

