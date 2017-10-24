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

	// ArrayList<Veicolo> listaVeicolo = new ArrayList<>();
	GestioneDatabase gd = new GestioneDatabase();
	private Utente utente;
	Veicolo veicoloUtente;
	Scanner sc = new Scanner(System.in);
	Date oggi = new Date();

	public void noleggio(Utente utente) {
		this.utente = utente;
		System.out.printf("Benvenuto %s %s\n", utente.getNome(), utente.getCognome());
		veicoloUtente = gd.restituisciVeicoloNoleggiato(this.utente.getEmail());
		if (veicoloUtente != null) {
			System.out.printf("Il veicolo in suo possesso ha la targa: %s\n", veicoloUtente.getTarga());
		}
		System.out.println("Vuoi noleggiare? (1)\nVuoi restituire la macchina?(2)");
		int scelta = sc.nextInt();

		switch (scelta) {
		case 1:
			// accedi();
			break;
		case 2:
			restituisci();
			break;
		default:
			System.out.println("Scelta non corretta. Riprova.");
			noleggio(utente);
			break;
		}

	}

	public void restituisci() {
		/*
		 * if (listaVeicolo.size() > 1) {
		 * System.out.println("quale veicolo vuoi restituire?"); for (Veicolo v :
		 * listaVeicolo) { System.out.printf("La macchina con targa %s", v.getTarga());
		 * } scelta = sc.nextInt() - 1; } else { scelta = 0; }
		 * 
		 * veicoloUtente = listaVeicolo.get(0); veicoloUtente =
		 * gd.noleggioVeicolo(utente.getEmail());
		 */
		Date periodoInizio = veicoloUtente.getPeriodoInizio();
		long durataNoleggio = oggi.getTime() - periodoInizio.getTime();
		long durataNoleggioInGG = durataNoleggio / (1000 * 60 * 60 * 24);

		System.out.println(durataNoleggioInGG);
		System.out.println(veicoloUtente.getCostoGiornaliero());

		double costoTotale = veicoloUtente.getCostoGiornaliero() * durataNoleggioInGG;
		System.out.println("L'importo da pagare è: " + costoTotale + " euro.");
	}

}
