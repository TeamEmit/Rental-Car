package rentalCar;

import java.util.Scanner;

public class ControlloUtente {

	//Utente utente;
	Scanner sc = new Scanner(System.in);
	public void signInUp() {
		
		System.out.println("Sei già registrato?\nSeleziona 1 per eseguire l'accesso, 2 per la registrazione");
		int scelta = sc.nextInt();
		
		switch (scelta) {
		case 1:
			//metodo per eseguire l'accesso
			break;
		case 2:
			//metodo per la registrazione
			break;
		default:
			System.out.println("scelta non contemplata");
			signInUp();
			break;
		}
		
		
	}
	public void registrazione() {
		String stringaDb = "prova";	//da sostituire con collegamento db
		
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
			//invia a db
			if (email.equals(stringaDb)) {
				
				System.out.println("Utente già esistente, provare a fare l'accesso");
				
				
			}
			
		}
		
	
	
}
