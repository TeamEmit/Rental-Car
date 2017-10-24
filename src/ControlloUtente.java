import java.util.Scanner;

public class ControlloUtente {

	Scanner sc = new Scanner(System.in);
	ControlloNoleggio noleggio = new ControlloNoleggio();
	GestioneDatabase db;
	boolean emailEsistente = false;
	Utente utente;

	public void signInUp() {

		db = new GestioneDatabase();
		System.out.println("Sei già registrato?\nSeleziona:\n1 per eseguire l'accesso\n2 per la registrazione");
		int scelta = sc.nextInt();

		switch (scelta) {
		case 1:
			accedi();
			break;
		case 2:
			registrazione();
			break;
		case 3:
			utente = db.restituisciDatiUtente("cicciopasticcio@libero.it");
			noleggio.controlloNoleggio(utente);
			break;
		default:
			System.out.println("Scelta non corretta. Riprova.");
			signInUp();
			break;
		}
	}

	public void registrazione() {

		sc.nextLine();
		System.out.println("Inserire nome");
		String nome = sc.nextLine();
		System.out.println("Inserire Cognome");
		String cognome = sc.nextLine();
		System.out.println("Inserire e-mail");
		String email = sc.nextLine();
		System.out.println("Inserire password");
		String password = sc.nextLine();
		System.out.println("Inserire carta di credito");
		String cartaCredito = sc.nextLine();

		boolean emailEsistente = db.controllaMail(email);

		if (emailEsistente) {
			System.out.println("Email già esistente, provare a fare l'accesso o cambia email.");
			signInUp();
		} else {
			db.inserisciUtente(email, nome, cognome, password, cartaCredito);
			utente = new Utente(email, nome, cognome, password, cartaCredito);
			noleggio.controlloNoleggio(utente);

		}
	}

	public void accedi() {
		String passwordCheck = "";
		sc.nextLine();
		System.out.println("Inserire e-mail");
		String email = sc.nextLine();
		System.out.println("Inserire password");
		String password = sc.nextLine();

		passwordCheck = db.controllaPass(email);

		if (passwordCheck.equals(password)) {
			utente = db.restituisciDatiUtente(email);
			noleggio.controlloNoleggio(utente);

		} else {
			System.out.println("Email o password errate, riprova o prova a fare la registrazione.");
			signInUp();
		}

	}

}
