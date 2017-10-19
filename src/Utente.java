

public class Utente {
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String numCartaCredito;
	
	public Utente(String email, String nome, String cognome, String password, String numCartaCredito) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.numCartaCredito = numCartaCredito;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNumCartaCredito() {
		return numCartaCredito;
	}


	public void setNumCartaCredito(String numCartaCredito) {
		this.numCartaCredito = numCartaCredito;
	}
	
	
	

}
