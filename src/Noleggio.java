import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Noleggio {

	ArrayList<Veicolo> listaVeicolo = new ArrayList<>();
	Veicolo veicoloUtente;
	Scanner sc = new Scanner(System.in);
	Date oggi = new Date();
	
	public void noleggio(Utente utente) {

		System.out.println("Vuoi noleggiare? (1)\nVuoi restituire la macchina?(2)");

		int scelta = sc.nextInt();

		switch (scelta) {
		case 1:
			// accedi();
			break;
		case 2:
			// restituisci();
			break;
		default:
			System.out.println("Scelta non corretta. Riprova.");
			// signInUp();
			break;
		}

	}

	public void restituisci() {
		int scelta;
		
		if (listaVeicolo.size() > 1) {
			
			System.out.println("quale veicolo vuoi restituire?");
			for (Veicolo v:listaVeicolo) {
				System.out.printf("La macchina con targa %s", v.getTarga());
			}
				scelta = sc.nextInt() - 1;
		} else {
			scelta = 0;
		}
		
		veicoloUtente = listaVeicolo.get(scelta);
	
		
		
		
		
		
		
		
		
	}
	
}
