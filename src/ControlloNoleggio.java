import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ControlloNoleggio {

	ArrayList<Veicolo> listaVeicolo;
	GestioneDatabase gd = new GestioneDatabase();
	private Utente utente;
	Veicolo veicoloUtente;
	Scanner sc = new Scanner(System.in);
	Date oggi = new Date();

	public void controlloNoleggio(Utente utente) {
		this.utente = utente;
		int scelta = 0;
		System.out.printf("Benvenuto %s %s\n", utente.getNome(), utente.getCognome());
		veicoloUtente = gd.restituisciVeicoloNoleggiato(this.utente.getEmail());
		if (veicoloUtente != null) {
			System.out.printf("Il veicolo in suo possesso ha la targa: %s\n", veicoloUtente.getTarga());
			System.out.println("Per restituire la macchina premere 2");
			scelta = sc.nextInt();
		} else {
		System.out.println("Non hai macchine, vuoi noleggiarne una?\nPer continuare premi 1");
		scelta = sc.nextInt();
		}
		switch (scelta) {
		case 1:
			noleggia();
			break;
		case 2:
			restituisci();
			break;
		case 3:
			;
		default:
			System.out.println("Scelta non corretta. Riprova.");
			controlloNoleggio(utente);
			break;
		}

	}

	public void restituisci() {

		Date periodoInizio = veicoloUtente.getPeriodoInizio();
		long durataNoleggio = oggi.getTime() - periodoInizio.getTime();
		long durataNoleggioInGG = durataNoleggio / (1000 * 60 * 60 * 24);

		System.out.println(durataNoleggioInGG);

		double costoTotale = veicoloUtente.getCostoGiornaliero() * durataNoleggioInGG + 5;
		System.out.println("L'importo da pagare è: " + costoTotale + " euro.");
		gd.cancellaNoleggio(utente.getEmail());
		controlloNoleggio(utente);
	}

	public void noleggia() {
		listaVeicolo = new ArrayList<>();
		ArrayList<Veicolo> listaVeicoloFiltrata = new ArrayList<>();
		int counter = 1;
		listaVeicolo = gd.restituisciListaVeicoli();
		String auto = "";
		System.out.println(
				"Selezionare tipologia veicolo:\n1 Berlina\n2 Cabrio\n3 Fuoristrada\n4 Furgone\n5 Monovolume\n6 Station Wagon\n7 SUV\n8 Utilitaria\n");
		int scelta = sc.nextInt();

		switch (scelta) {
		case 1:
			auto = "Berlina";
			break;
		case 2:
			auto = "Cabrio";
			break;
		case 3:
			auto = "Fuoristrada";
			break;
		case 4:
			auto = "Furgone";
			break;
		case 5:
			auto = "Monovolume";
			break;
		case 6:
			auto = "Station Wagon";
			break;
		case 7:
			auto = "SUV";
			break;
		case 8:
			auto = "Utilitaria";
			break;
		default:

		}

		System.out.println("Selezionare il veicolo desiderato");
		for (Veicolo v : listaVeicolo) {
			if (auto.equalsIgnoreCase(v.getTipologia())) {
				System.out.printf("%d - %s %s %s %s %s\n", counter, v.getTarga(), v.getMarca(), v.getModello(),
						v.getTipologia(), v.getColore());
				counter++;
				listaVeicoloFiltrata.add(v);
			}
		}

		int vScelto = sc.nextInt()-1;
		
		gd.creaRecordNoleggio(utente.getEmail(), listaVeicoloFiltrata.get(vScelto).getTarga());
		System.out.println("Veicolo selezionato noleggiato\n\n");
		
		listaVeicoloFiltrata = null;
		listaVeicolo = null;
		controlloNoleggio(utente);
	}

}
