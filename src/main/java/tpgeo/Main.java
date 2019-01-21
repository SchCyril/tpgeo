package tpgeo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {

		DateTimeFormatter time = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
		LOGGER.trace("Début du programme le " + time.format(LocalDateTime.now()));
		
		
		Dessin dessin = new Dessin();
		LOGGER.trace(FigureUtil.genere(10));
		
		
		
	
		
		
		LOGGER.trace("Fin du programme le " + time.format(LocalDateTime.of(2019, 12, 25, 12, 30)));
	      
	   }
	
	
	

}
