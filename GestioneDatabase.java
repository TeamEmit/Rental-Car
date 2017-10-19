package rentalCar;
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
			String url = "jdbc:mysql://127.0.0.1/rent_a_car";
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
			String query = "SELECT email FROM rent_a_car WHERE email='" + email + "'";
			ResultSet res = cmd.executeQuery(query);
			if(res.next())
				giaRegistrato=true;
			res.close();
			cmd.close();
			return giaRegistrato;
			}
			catch (SQLException e) {
				e.printStackTrace();
				return giaRegistrato;
			}
	
	
	}
	
}
