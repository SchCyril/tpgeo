package tpgeo;

public class Ecrit implements Runnable {
	private String texte;
	private int nb;
	private int duration;

	public Ecrit(String texte, int nb, int duration) {
		super();
		this.texte = texte;
		this.nb = nb;
		this.duration = duration;
	}

	public void run() {
		for (int i = 0; i < nb; i++) {

			LOGGER.trace(texte);
			try {
				Thread.sleep(duration);

			} catch (InterruptedException e) {
				LOGGER.trace("InterruptedException : " + e.getMessage());

			}
		}
	}
}
