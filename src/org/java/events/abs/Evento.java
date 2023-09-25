package org.java.events.abs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Evento {
	
	private String titolo;
	private LocalDate data;
	private int nPostiTot;
	private int nPostiPrenotati;
	private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/uu");
	
	public Evento(String titolo, String data, int nPostiTot) throws Exception {
		setTitolo(titolo);
		setData(data);
		setnPostiTot(nPostiTot);
		setnPostiPrenotati(0);
	}
	
	public abstract String getPrezzoFormattato();
	
	public abstract BigDecimal getPrezzo();
	
	public void prenota() throws Exception {
		if ((LocalDate.now().isBefore(getData())) && getnPostiPrenotati() < getnPostiTot()) {
			int prenotati = getnPostiPrenotati();
			setnPostiPrenotati(++prenotati);
		} else {
			throw new Exception("Non è più possibie prenotare questo Evento.");
		}
	}

	public void disdici() throws Exception {
		if ((LocalDate.now().isAfter(getData())) || (getnPostiPrenotati() == 0)) {
			throw new Exception("Non è più possibie disdire questo Evento.");
		} else {
			int prenotati = getnPostiPrenotati();
			setnPostiPrenotati(--prenotati);
		}
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDataFormattata() {
		return data.format(FORMATTER);
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(String data) throws Exception {
		LocalDate dataFormattata = LocalDate.parse(data, FORMATTER);
		if (dataFormattata.isBefore(LocalDate.now())) throw new Exception("La data inserita risulta invalida, inserisci una data successiva a " + LocalDate.now());
		else this.data = dataFormattata;
	}

	public int getnPostiTot() {
		return nPostiTot;
	}

	private void setnPostiTot(int nPostiTot) throws Exception {
		if (nPostiTot > 0) this.nPostiTot = nPostiTot;
		else throw new Exception("Il numero di posti inserito risulta invalido. Inserisci un numero di posti maggiore di 0");
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	private void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}

	public int getPostiDisponibili() {
		return getnPostiTot() - getnPostiPrenotati();
	}
	
	@Override
	public String toString() {
		return getDataFormattata() + " - " + getTitolo();
	}
}
