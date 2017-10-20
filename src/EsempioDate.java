import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class EsempioDate {

	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		
		//creo due ogg calendar, uno per il mese e l'altro per il giorno
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		Date sept25 = c.getTime(); // creo un ogg Date passandogli la data inserita
		Date oggi = new Date();  // per avere la data oggi, creo un ogg Date e richiamo 
								 // il metodo getTime()
		
		long diff = oggi.getTime() - sept25.getTime(); // diff in millisec
		long diffInGG = diff / (1000 * 60 * 60 * 24); // diff in giorni
		System.out.println(diffInGG);
	/////////////////////////////////////////////////////////	
		// prendo la data dal DataBase
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost/rental";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement st = con.createStatement();
			//Andiamo a prendere la data dalla tabella nel DataBase
			ResultSet rs = st.executeQuery("Select * from utente_veicolo where id_rent = 2");
			if (rs.next()) {
				Date pdi = rs.getDate("periodo_di_inizio"); //nome del campo
				diff = oggi.getTime() - pdi.getTime();
				diffInGG = diff / (1000 * 60 * 60 * 24);
				System.out.println(diffInGG);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
