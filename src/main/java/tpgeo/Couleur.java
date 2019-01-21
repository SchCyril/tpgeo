package tpgeo;
import java.util.concurrent.ThreadLocalRandom;

public enum Couleur {
	ROUGE('R'), VERT('V'), BLEU('B'), JAUNE('J'), NOIR('N');

	private char valeur;

	private Couleur(char valeur) {
		this.valeur = valeur;
	}

	public char getValeur() {
		return valeur;
	}

	public static Couleur getCouleurDefaut() {
		return Couleur.NOIR;
	}

	public static Couleur getRandomCol() {
		int randomCol = ThreadLocalRandom.current().nextInt(values().length);
		return values()[randomCol];
	}

}
