package it.antani.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codice;
	
	@Column
	private String descrizione;
	
	@Column
	private String scadenza;
	
	@Column
	private double valore;
	
	@Column(name = "percorso_file")
	private String dir;
	
	@Column(name = "dimensione")
	private String dimensioneFile;
	
	public Record(int codice, String descrizione, String scadenza, double valore, String dir, long dimensioneFile) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.scadenza = scadenza;
		this.valore = valore;
		this.dir = dir;
		setDimensioneFile(dimensioneFile);
	}

	public String getDimensioneFile() {
		return dimensioneFile;
	}

	public void setDimensioneFile(long dimensioneFile) {
		this.dimensioneFile = dimensioneFile + " byte";
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(double valore) {
		this.valore = valore;
	}
	
}
