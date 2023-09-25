package org.java.events;

import java.math.BigDecimal;

import org.java.events.abs.Evento;

public class Spettacolo extends Evento {
	
	private BigDecimal prezzo;

	public Spettacolo(String titolo, String data, int nPostiTot, String prezzo) throws Exception {
		super(titolo, data, nPostiTot);
		setPrezzo(prezzo);
	}
	
	@Override
	public String getPrezzoFormattato() {
		BigDecimal prezzoFormattato = getPrezzo().setScale(2);
		return "" + prezzoFormattato + "€";
	}
	
	@Override
	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) throws Exception {
		String errorMsg = "Prezzo inserito non valido.";
		BigDecimal prezzoFormattato = null;
		try {
			prezzoFormattato = new BigDecimal(prezzo);			
		} finally {
			if (prezzoFormattato.compareTo(BigDecimal.ZERO) > 0) this.prezzo = prezzoFormattato;
			else {
				throw new Exception(errorMsg);
			}
		}
	}
	
	@Override
	public String toString() {
		return getDataFormattata() + 
				" - " + getTitolo() + 
				" - " + getPrezzoFormattato();
	}

}

