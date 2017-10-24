
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
			PreparedStatement pst = con.prepareStatement("INSERT INTO utente VALUES (?, ?, ?, ?, ?)");
			pst.setString(1, email);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, password);
			pst.setString(5, cartadicredito);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean controllaMail(String email) {
		boolean giaRegistrato = false;
		try {
			Statement cmd = con.createStatement();
			String query = "SELECT email FROM utente WHERE email='" + email + "'"; // Check
			ResultSet res = cmd.executeQuery(query);
			if (res.next())
				giaRegistrato = true;
			res.close();
			cmd.close();
			return giaRegistrato;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public String controllaPass(String email) {
		String pass = "";
		try {
			Statement cmd = con.createStatement();
			String query = "SELECT password FROM utente WHERE email='" + email + "'"; // Check
			ResultSet res = cmd.executeQuery(query);
			if (res.next())
				pass = res.getString("password");
			res.close();
			cmd.close();
			return pass;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public Utente restituisciDatiUtente(String email) {
		Utente utente;
		String[] sUtente = new String[5];
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
			return utente;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Veicolo noleggioVeicolo(String email) {
		Veicolo v;
		Statement cmd;
		String marca = null, modello = null, targa = null, tipologia = null, colore = null;
		int costoGiornaliero = 0;
		Date data = null;
		try {
			cmd = con.createStatement();
			String query = "SELECT veicolo.colore, veicolo.Marca, veicolo.Modello, veicolo.Tipologia, veicolo.Targa, utente_veicolo.Periodo_di_Inizio, veicolo.costo_giornaliero "
					+ "FROM `utente` " + "INNER JOIN utente_veicolo " + "	ON utente.Email=utente_veicolo.Email "
					+ "INNER JOIN veicolo " + "    ON utente_veicolo.Targa=veicolo.Targa " + "WHERE utente.email = '"
					+ email + "'";
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {

				marca = res.getString("marca");
				modello = res.getString("modello");
				targa = res.getString("targa");
				tipologia = res.getString("tipologia");
				colore = res.getString("colore");
				data = res.getDate("Periodo_di_Inizio");
				costoGiornaliero = res.getInt("Costo_giornaliero");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (marca != null && modello != null && targa != null && tipologia != null && colore != null) {
			v = new Veicolo(marca, modello, targa, tipologia, colore);
			v.setPeriodoInizio(data);
			v.setCostoGiornaliero(costoGiornaliero);
			return v;
		} else
			return null;
	}

}
