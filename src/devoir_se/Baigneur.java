package devoir_se;

import java.util.concurrent.Semaphore;

public class Baigneur extends Thread {

	private char id;

	private int tempsCabineAvant; // M
	private int tempsBain; // N
	private int tempsCabineApres; // O
	private int tempsAttente; // P

	// Sémaphore représentant le nombre de paniers disponibles.
	Semaphore paniers;

	// Sémaphore représentant le nombre de cabines disponibles.
	Semaphore cabines;

	public Baigneur(char c, int m, int n, int o, int p, Semaphore paniers, Semaphore cabines) {
		id = c;
		tempsCabineAvant = m;
		tempsBain = n;
		tempsCabineApres = o;
		tempsAttente = p;
		this.paniers = paniers;
		this.cabines = cabines;
	}

	public void run() {
		
	    while(!isInterrupted()) {

			affichage("Arrive");
			
			obtenirPanier();
	
			utiliserCabine(tempsCabineAvant);
	
			prendreBain(tempsBain);
	
			utiliserCabine(tempsCabineApres);
	
			remettrePanier();
	
			attente(tempsAttente);
	    }

	}

	public void obtenirPanier() {
		try {

			affichage("Panier");
			// affichage("Demande un panier.");

			paniers.acquire();

			// affichage("Panier obtenu. ");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void remettrePanier() {

		// affichage("Remise du panier.");

		paniers.release();

	}

	public void prendreBain(int temps) {

		try {

			// affichage("Bain de " + temps + " unités de temps");

			affichage("Baigne");
			
			Baigneur.sleep(temps);

			// affichage("Bain terminé.");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void affichage(String s) {
		System.out.println("État du Baigneur " + this.id + " : " + s);
	}
	
	public void attente(int temps){
		try {
			Baigneur.sleep(temps);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void utiliserCabine(int temps) {

		try {

			// affichage("Demande de cabine.");

			affichage("Change");
			
			cabines.acquire();

			// affichage("Utilisation de la cabine de " + temps + " unités de
			// temps");

			Baigneur.sleep(temps);

			cabines.release();

			// affichage("Utilisation de la cabine terminée.");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}
