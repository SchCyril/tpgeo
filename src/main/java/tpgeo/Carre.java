package tpgeo;

public class Carre extends Rectangle {
	public Carre(Point point, int cote) {
		super(point, cote, cote);

		// TODO Auto-generated constructor stub
	}

	public Carre(Point point, int cote, Couleur col) {
		super(point, cote, cote, col);

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Carre [pointBasGauche=" + pointBasGauche + ", pointBasDroit=" + pointBasDroit + ", pointHautGauche="
				+ pointHautGauche + ", pointHautDroit=" + pointHautDroit + ", col=" + col + "]";
	}

	protected String getType() {
		return "CARRE";
	}

	//ajout d'un commentaire pour le test git ok ok ok 
	//blabla
	//again
	//coucou
}
