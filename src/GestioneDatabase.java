
import java.sql.*;

public class GestioneDatabase {
	private static Connection con;
	
	public GestioneDatabase() {
	connettiDatabase();	
	}
	
	public static void connettiDatabase() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://172.16.99.208/rent";
			con = DriverManager.getConnection(url, "corsojava", "javapassword");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnettiDatabase() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserisciUtente(String email, String nome, String cognome, String password, String cartadicredito) {
	try {
	Statement cmd = con.createStatement();
	String update = "INSERT INTO utente VALUES (" + email + ", " + nome + ", " + cognome + ", " + password + ", " + cartadicredito + ")";
	cmd.executeUpdate(update);
	cmd.close();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	public boolean controllaMail (String email) {
		boolean giaRegistrato=false;
		try {
			Statement cmd = con.createStatement();
			String query = "SELECT email FROM utente WHERE email='" + email + "'"; //Check
			ResultSet res = cmd.executeQuery(query);
			if(res.next())
				giaRegistrato=true;
			res.close();
			cmd.close();
			return giaRegistrato;
			
			}
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	
	
	}
	public Utente restituisciDatiUtente(String email) {
		Utente utente;
		String [] sUtente = new String[5];
		int i = 0;
		try {
			Statement cmd = con.createStatement();
			String query = "SELECT * FROM utente WHERE email='" + email + "'";
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				
				sUtente[i] = res.getString(i);
				i++;	
				//email, nome, cognome, pass, carta
				
			}
			
			utente = new Utente(sUtente[0], sUtente[1], sUtente[2], sUtente[3], sUtente[4]);
			
			System.out.printf("Benvenuto %s %s", utente.getNome(), utente.getCognome());
			return utente;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
