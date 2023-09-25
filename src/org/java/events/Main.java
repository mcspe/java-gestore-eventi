package org.java.events;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("******************************");
		System.out.println("Benvenuto nel gestore Eventi!");
		System.out.println("******************************\n");
		
		
		
		/******** Milestone 2 ********/
//		boolean isValidEvent = false;
//		Evento event = null;
//		
//		while (!isValidEvent) {
//			System.out.print("Inserisci il titolo dell'Evento: ");
//			String titolo = sc.nextLine();
//			System.out.print("Inserisci la data dell'Evento: ");
//			String data = sc.nextLine();				;
//			System.out.print("Inserisci i posti disponibili per l'Evento: ");
//			int nPosti = Integer.valueOf(sc.nextLine());
//			
//			try {
//				event = new Evento(titolo, data, nPosti);
//				isValidEvent = true;
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//				continue;
//			}
//		}
//		
//		System.out.println("\n------------------------------");
//		System.out.println("Quanti posti vorresti prenotare per questo evento? ");
//		int nPrenotazioni = Integer.valueOf(sc.nextLine());
//		
//		System.out.println("\n------------------------------\n");
//		
//		for (int i = 0; i < nPrenotazioni; i++) {
//			try {
//				event.prenota();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//				break;
//			}
//		}
//		
//		System.out.println("\n------------------------------\n");
//		
//		System.out.println(event + "\n" +
//							"Posti prenotati: " + event.getnPostiPrenotati() + "\n" + 
//							"Posti disponibili: " + event.getPostiDisponibili());
//		
//		System.out.println("\n------------------------------\n");
//
//		System.out.println("\n------------------------------");
//		System.out.println("Quanti posti vorresti disdire per questo evento? ");
//		int nDisdette = Integer.valueOf(sc.nextLine());
//		
//		System.out.println("\n------------------------------\n");
//		
//		for (int i = 0; i < nDisdette; i++) {
//			try {
//				event.disdici();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//				break;
//			}
//		}
//		
//		System.out.println("\n------------------------------\n");
//		
//		System.out.println(event + "\n" +
//							"Posti prenotati: " + event.getnPostiPrenotati() + "\n" + 
//							"Posti disponibili: " + event.getPostiDisponibili());
//		
//		System.out.println("\n------------------------------\n");
//
		
		
		/***** Prova classe Concerto ******/
//		Concerto c = null;
//		
//		try {
//			c = new Concerto("conc", "1/10/23", 45, "15.15", "45.00");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println(c);
		
		/***** Milestone 5 ******/
		
		
		ProgrammEventi OctEvents = new ProgrammEventi("October Events");
		Random rnd = new Random();

		for (int i = 0; i < 15; i++) {
			int tipoEvento = rnd.nextInt(1, 3);
			switch (tipoEvento) {
			case 1:
				try {
					OctEvents.addEvento(new Concerto(("Concerto " + (i + 1)), (rnd.nextInt(1, 32) + "/10/23"), rnd.nextInt(20, 101), (String.format("%02d", rnd.nextInt(8, 24)) + "." + String.format("%02d", rnd.nextInt(1, 60))), ("" + rnd.nextInt(1, 201))));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					i--;
				}
				break;
			case 2:
				try {
					OctEvents.addEvento(new Spettacolo(("Spettacolo " + (i + 1)), (rnd.nextInt(1, 32) + "/10/23"), rnd.nextInt(20, 101), ("" + rnd.nextInt(1, 201))));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					i--;
				}
				break;
			}
			
		}
		
		System.out.println("\n------------------------------\n");
		System.out.println("Totale eventi in programma");
		System.out.println(OctEvents.getTotEventi());
		System.out.println("\n------------------------------\n");
		
		System.out.println("\n------------------------------\n");
		System.out.println("Totale eventi in programma");
		System.out.println(OctEvents);
		System.out.println("\n------------------------------\n");
		
		System.out.println("\n------------------------------\n");
		System.out.println("Eventi in data 2/10/23");
		System.out.println(OctEvents.getEventiInData("2/10/23"));
		System.out.println("\n------------------------------\n");
		
		System.out.println("\n------------------------------\n");
		System.out.println("Il prezzo medio dei concerti è di: ");
		System.out.println(OctEvents.mediaPrezzoConcerto());
		System.out.println("\n------------------------------\n");
		
		System.out.println("\n------------------------------\n");
		System.out.println("Il prezzo medio degli spettacoli è di: ");
		System.out.println(OctEvents.mediaPrezzoSpettacolo());
		System.out.println("\n------------------------------\n");
		
		System.out.println("\n------------------------------\n");
		System.out.println("Il prezzo medio degli eventi in generale è di: ");
		System.out.println(OctEvents.mediaPrezzoEvento());
		System.out.println("\n------------------------------\n");
		
		
		
		

		
		System.out.println("******************************");
		System.out.println("The End!");		
		System.out.println("******************************\n");
		sc.close();


	}

}
