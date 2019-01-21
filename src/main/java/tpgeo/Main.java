package tpgeo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class Main {

	private static final String LOGGER = null;

	public static void main(String[] args) {

		DateTimeFormatter time = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
		LOGGER("Début du programme le " + time.format(LocalDateTime.now()));
		

		
		
	
		
		
		LOGGER("Fin du programme le " + time.format(LocalDateTime.of(2019, 12, 25, 12, 30)));
	      
	   }

	private static void LOGGER(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
