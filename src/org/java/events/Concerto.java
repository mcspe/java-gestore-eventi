package org.java.events;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private BigDecimal prezzo;
	private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("H.mm");

	public Concerto(String titolo, String data, int nPostiTot, String ora, String prezzo) throws Exception {
		super(titolo, data, nPostiTot);
		setOra(ora);
		setPrezzo(prezzo);
	}

	public String getOraFormattata() {
		return ora.format(FORMATTER);
	}
	
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(String ora) throws Exception {
		LocalTime oraFormattata = LocalTime.parse(ora, FORMATTER);
		if (oraFormattata.isBefore(LocalTime.now())) throw new Exception("L'orario inseritoa risulta invalido, inserisci un orario successivo a " + LocalTime.now());
		else this.ora = oraFormattata;
	}

	public String getPrezzoFormattato() {
		BigDecimal prezzoFormattato = getPrezzo().setScale(2);
		return "" + prezzoFormattato + "€";
	}
	
	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) throws Exception {
		String errorMsg = "Prezzo inserito non valido.";
		BigDecimal prezzoFormattato = null;
		try {
			prezzoFormattato = new BigDecimal(prezzo);			
		} finally {
			if (prezzoFormattato.compareTo(BigDecimal.ZERO) > 0)	this.prezzo = prezzoFormattato;
			else {
				throw new Exception(errorMsg);
			}
		}
	}
	
	@Override
	public String toString() {
		return getDataFormattata() + " " + getOraFormattata() + 
				" - " + getTitolo() + 
				" - " + getPrezzoFormattato();
	}

}
