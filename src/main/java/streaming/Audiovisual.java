package streaming;
import java.util.Scanner;
import Interfaces.Subtitulos;
import clasesbase.Actores;
import clasesbase.Categorias;
import clasesbase.Directores;
import clasesbase.RecomendacionPeliculas;
import enums.Tipo;

public class Audiovisual{
	   Scanner sc = new Scanner (System.in);
	   //Atributos
	   protected Tipo t;
	   protected String titulo;
	   protected String idiomaOriginal;
	   protected String idiomaAdaptado [];
	   protected int duracion;
	   protected int vecesVisto;
	   protected Actores act [];
	   protected Directores dic [];
	   protected Categorias cat [];
	   protected String sub [];
	   protected RecomendacionPeliculas rec [];
	   
	   //Constructor 
	   public  Audiovisual (Tipo t,String titulo,String idiomaOriginal,int duracion,int vecesVisto)
	   {
		   this.t = t;
		   this.titulo = titulo;
		   this.idiomaOriginal = idiomaOriginal;
		   this.duracion = duracion;
		   this.vecesVisto = vecesVisto;
		   idiomaAdaptado = new String [0];
		   act = new Actores [0];
		   dic = new Directores [0];
		   cat = new Categorias[0];
		   rec = new RecomendacionPeliculas [0];
		   sub = Subtitulos.idiomas;
		   CorreccionAtributos();
	   }
	   
	   //Getters y Setters
	    public Tipo getT() {
	        return t;
	    }

	    public void setT(Tipo t) {
	        this.t = t;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getIdiomaOriginal() {
	        return idiomaOriginal;
	    }

	    public void setIdiomaOriginal(String idiomaOriginal) {
	        this.idiomaOriginal = idiomaOriginal;
	    }

	    public String[] getIdiomaAdaptado() {
	        return idiomaAdaptado;
	    }

	    public int getDuracion() {
	        return duracion;
	    }

	    public void setDuracion(int duracion) {
	        this.duracion = duracion;
	    }
	    public  int getVecesVisto() {
	    	return vecesVisto;
	    }
	    
	    public void setVecesVisto(int vecesVisto) {
	    	this.vecesVisto = vecesVisto;
	    }
		private void CorreccionAtributos()
		{
			while(titulo.isEmpty())
			{
				System.out.println("Error titulo vacio vuelve a introducirlo");
				titulo = sc.nextLine();
			}
			if(idiomaOriginal.isEmpty())
			{
				idiomaOriginal = "Ingles";
			}
		}
		@Override
		public String toString()
		{
			return "Audiovisual de tipo " + t +" con nombre "+titulo+" dura "+duracion+" minutos "+" su idioma original es "+idiomaOriginal + "veces visto " + vecesVisto;
		}
		}

