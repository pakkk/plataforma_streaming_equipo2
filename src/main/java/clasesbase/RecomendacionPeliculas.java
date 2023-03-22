package clasesbase;

import java.util.Scanner;
public class RecomendacionPeliculas {
	Scanner sc =  new Scanner (System.in);
   //Atributos
   private int valoracionesPositivas;
   private int valoracionesNegativas;
   private int vecesVista;
   private String comentarios;
   //Constructor
    public RecomendacionPeliculas(int valoracionesPositivas, int valoracionesNegativas, int vecesVista, String comentarios) {
        this.valoracionesPositivas = valoracionesPositivas;
        valoracionPositivaErronea();
        this.valoracionesNegativas = valoracionesNegativas;
        valoracionNegativaErronea();
        this.vecesVista = vecesVista;
        this.comentarios = comentarios;
    }
    //Getters y Setters
    public int getValoracionesPositivas() {
        return valoracionesPositivas;
    }

    public void setValoracionesPositivas(int valoracionesPositivas) {
        this.valoracionesPositivas = valoracionesPositivas;
    }

    public int getValoracionesNegativas() {
        return valoracionesNegativas;
    }

    public void setValoracionesNegativas(int valoracionesNegativas) {
        this.valoracionesNegativas = valoracionesNegativas;
    }

    public int getVecesVista() {
        return vecesVista;
    }

    public void setVecesVista(int vecesVista) {
        this.vecesVista = vecesVista;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    //Metodos
    private void valoracionPositivaErronea()
    {
    	//Metodo para corregir la valoracion positiva en caso de que se introduzca mal
    	while(valoracionesPositivas<0 || valoracionesPositivas>5)
    	{
    		System.out.println("Error valoración positiva mal introducida introduzca del 0 al 5");
    		valoracionesPositivas = sc.nextInt();
    	}	
    }
    private void valoracionNegativaErronea()
    {
    	//Metodo para corregir la valoracion positiva en caso de que se introduzca mal
    	while(valoracionesNegativas<0 || valoracionesNegativas>5)
    	{
    		System.out.println("Error valoración positiva mal introducida introduzca del 0 al 5");
    		valoracionesNegativas = sc.nextInt();
    	}	
    }
    //toString
    @Override
    public String toString() {
        return "valoracionesPositivas = " + valoracionesPositivas + ", valoracionesNegativas = " + valoracionesNegativas + ", vecesVista = " + vecesVista + ", comentarios = '" + comentarios + '\'';
    }
}