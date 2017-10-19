import java.util.Scanner;

public class ControlloUtente {

	// Utente utente;
	Scanner sc = new Scanner(System.in);
	GestioneDatabase db;
	boolean emailEsistente = false;
	
	public void signInUp() {
		
		db = new GestioneDatabase();
		System.out.println("Sei già registrato?\nSeleziona 1 per eseguire l'accesso, \n 2 per la registrazione");
		int scelta = sc.nextInt();

		switch (scelta) {
		case 1:
			accedi();
			break;
		case 2:
			registrazione();
			break;
		default:
			System.out.println("Scelta non corretta. Riprova.");
			signInUp();
			break;
		}
	}

	public void registrazione() {
		boolean emailEsistente = false;
		
		System.out.println("Inserire nome");
		String nome = sc.nextLine();
		System.out.println("Inserire Cognome");
		String cognome = sc.nextLine();
		System.out.println("Inserire e-mail");
		String email = sc.nextLine();
		System.out.println("Inserire password (Massimo 8 caratteri)");
		String password = sc.nextLine();
		System.out.println("Inserire carta di credito");
		String cartaCredito = sc.nextLine();

		emailEsistente = db.controllaMail(email);

		if (emailEsistente) {
			System.out.println("Email già esistente, provare a fare l'accesso o cambia email.");
			signInUp();
		} else {
			db.inserisciUtente(email, nome, cognome, password, cartaCredito);
			System.out.println("Benvenuto....");
		}
	}
	
	public void accedi() {
		boolean emailEsistente = false;
		sc.nextLine();
		System.out.println("Inserire e-mail");
		String email = sc.nextLine();
		System.out.println("Inserire password (Massimo 8 caratteri)");
		String password = sc.nextLine();

		emailEsistente = db.controllaMail(email);

		if (emailEsistente) {
			System.out.println("Benvenuto");
			db.restituisciDatiUtente(email); // metodo da creare
		} else {
			System.out.println("Email o password errate, riprova o prova a fare la registrazione.");
			registrazione();
		}

	}
}
