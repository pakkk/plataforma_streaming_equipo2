package streaming;

import enums.Tipo;

public class Serie extends Audiovisual{

	public Serie(Tipo t, String titulo, String idiomaOriginal, int duracion) {
		super(t, titulo, idiomaOriginal, duracion);
		this.t = t.SERIE;
		// TODO Auto-generated constructor stub
	}

}
