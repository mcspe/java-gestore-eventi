package org.java.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.java.events.abs.Evento;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	private BigDecimal avg;
	
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
		if (eventi.stream().filter(e -> e.getData().equals(dataFormattata)).count() == 0) EVENTIINDATA.append("Nessun evento in programma per la data indicata");
		return EVENTIINDATA.toString();
	}
	
	public String mediaPrezzoConcerto() {
		List<Evento> concerti = eventi.stream().filter(e -> (e instanceof Concerto)).toList();
		return mediaPrezzo(concerti);
	}
	
	public String mediaPrezzoSpettacolo() {
		List<Evento> spettacoli = eventi.stream().filter(e -> (e instanceof Spettacolo)).toList();
		return mediaPrezzo(spettacoli);
	}
	
	public String mediaPrezzoEvento() {
		return mediaPrezzo(eventi);
	}
	
	public String mediaPrezzo(List<Evento> eventi) {
		setAvg(new BigDecimal(0));
		eventi.stream().forEach(e -> {
			setAvg(avg.add(e.getPrezzo()));
			System.out.println(avg);
		});
		setAvg(avg.divide(BigDecimal.valueOf(eventi.size())).setScale(2));
		System.out.println(avg);
		return "" + getAvg().setScale(2) + "€";
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
	
	private BigDecimal getAvg() {
		return avg;
	}
	
	private void setAvg(BigDecimal avg) {
		this.avg = avg;
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
