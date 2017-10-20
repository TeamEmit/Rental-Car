
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
			String url = "jdbc:mysql://localhost/rental";
			con = DriverManager.getConnection(url, "root", "");
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
		try {
			Statement cmd = con.createStatement();
			String query = "SELECT * FROM utente WHERE email='" + email + "'";
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				
				sUtente[0] = res.getString("email");
				sUtente[1] = res.getString("nome");
				sUtente[2] = res.getString("cognome");
				sUtente[3] = res.getString("password");
				sUtente[4] = res.getString("carta_di_credito");
				
				
			}
			
			utente = new Utente(sUtente[0], sUtente[1], sUtente[2], sUtente[3], sUtente[4]);
			System.out.println(sUtente[0] + sUtente[1] + sUtente[2] + sUtente[3] + sUtente[4]);
			System.out.printf("Benvenuto %s %s", utente.getNome(), utente.getCognome());
			return utente;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	public Veicolo noleggio(String email) { 
		Veicolo v = new Veicolo();
		Statement cmd;
		try {
			cmd = con.createStatement();
			String query = "SELECT * FROM utente WHERE email='" + email + "'";
			ResultSet res = cmd.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return v;
		
	}
	
	
}
