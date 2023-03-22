package streaming;

import enums.Tipo;

public class Pelicula extends Audiovisual {

	public Pelicula(Tipo t, String titulo, String idiomaOriginal, int duracion) {
		super(t, titulo, idiomaOriginal, duracion);
		this.t = Tipo.PELICULA; 
	}

}
