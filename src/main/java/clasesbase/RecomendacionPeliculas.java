package clasesbase;

public class RecomendacionPeliculas {
   //Atributos
   private int valoracionesPositivas;
   private int valoracionesNegativas;
   private int vecesVista;
   private String comentarios;
   //Constructor
    public RecomendacionPeliculas(int valoracionesPositivas, int valoracionesNegativas, int vecesVista, String comentarios) {
        this.valoracionesPositivas = valoracionesPositivas;
        this.valoracionesNegativas = valoracionesNegativas;
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
    //toString
    @Override
    public String toString() {
        return "valoracionesPositivas = " + valoracionesPositivas + ", valoracionesNegativas = " + valoracionesNegativas + ", vecesVista = " + vecesVista + ", comentarios = '" + comentarios + '\'';
    }
}