import java.text.SimpleDateFormat;

public class Veicolo {
	
	private String marca;
	private String modello;
	private String targa;
	private String tipologia;
	private String colore;
	private SimpleDateFormat periodoInizio;
	
	
	public Veicolo(String marca, String modello, String targa, String tipologia, String colore) {
		
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.tipologia = tipologia;
		this.colore = colore;
		
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}


	public void setTarga(String targa) {
		this.targa = targa;
	}


	public String getTipologia() {
		return tipologia;
	}


	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}


	public String getColore() {
		return colore;
	}


	public void setColore(String colore) {
		this.colore = colore;
	}


	public SimpleDateFormat getPeriodoInizio() {
		return periodoInizio;
	}


	public void setPeriodoInizio(SimpleDateFormat periodoInizio) {
		this.periodoInizio = periodoInizio;
	}


	
	
	
	

}
