package org.java.events;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("******************************");
		System.out.println("Benvenuto nel gestore Eventi!");
		System.out.println("******************************\n");
		
		boolean isValidEvent = false;
		Evento event = null;
		
		while (!isValidEvent) {
			System.out.print("Inserisci il titolo dell'Evento: ");
			String titolo = sc.nextLine();
			System.out.print("Inserisci la data dell'Evento: ");
			String data = sc.nextLine();				;
			System.out.print("Inserisci i posti disponibili per l'Evento: ");
			int nPosti = Integer.valueOf(sc.nextLine());
			
			try {
				event = new Evento(titolo, data, nPosti);
				isValidEvent = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
		
		System.out.println("\n------------------------------");
		System.out.println("Quanti posti vorresti prenotare per questo evento? ");
		int nPrenotazioni = Integer.valueOf(sc.nextLine());
		
		System.out.println("\n------------------------------\n");
		
		for (int i = 0; i < nPrenotazioni; i++) {
			try {
				event.prenota();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
		
		System.out.println("\n------------------------------\n");
		
		System.out.println(event + "\n" +
							"Posti prenotati: " + event.getnPostiPrenotati() + "\n" + 
							"Posti disponibili: " + event.getPostiDisponibili());
		
		System.out.println("\n------------------------------\n");

		System.out.println("\n------------------------------");
		System.out.println("Quanti posti vorresti disdire per questo evento? ");
		int nDisdette = Integer.valueOf(sc.nextLine());
		
		System.out.println("\n------------------------------\n");
		
		for (int i = 0; i < nDisdette; i++) {
			try {
				event.disdici();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
		
		System.out.println("\n------------------------------\n");
		
		System.out.println(event + "\n" +
							"Posti prenotati: " + event.getnPostiPrenotati() + "\n" + 
							"Posti disponibili: " + event.getPostiDisponibili());
		
		System.out.println("\n------------------------------\n");

		sc.close();
		
		
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
		
		System.out.println("******************************");
		System.out.println("The End!");
		System.out.println("******************************\n");

	}

}
