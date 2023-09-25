package org.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		setEventi();
	}

	public void addEvento(Evento e) {
		eventi.add(e);
	}
	
	public String getEventiInData(String data) {
		final StringBuilder EVENTIINDATA = new StringBuilder();
		final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/uu");
		LocalDate dataFormattata = LocalDate.parse(data, FORMATTER);
		eventi.stream().filter(e -> e.getData().equals(dataFormattata))
						.forEach(e -> {
							EVENTIINDATA.append(e.toString());
							EVENTIINDATA.append("\n");
						});
		return EVENTIINDATA.toString();
	}
	
	public int getTotEventi() {
		return eventi.size();
	}
	
	public void resetEventi() {
		eventi.clear();
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	private void setEventi() {
		eventi = new ArrayList<>();
	}

	@Override
	public String toString() {
		final StringBuilder STAMPAEVENTI = new StringBuilder();
		STAMPAEVENTI.append(getTitolo() + "\n");
		eventi.stream().forEach(e -> {
			STAMPAEVENTI.append(" - ");
			STAMPAEVENTI.append(e.toString());
			STAMPAEVENTI.append("\n");
		});			
		return STAMPAEVENTI.toString();
	}
}
