import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
	

		int m = 1000;
		int n = 3500;
		int o = 500;
		int p = 6000;
		
		//Sémaphore représentant le nombre de paniers disponibles.
		Semaphore paniers = new Semaphore(3, true);
		//Sémaphore représentant le nombre de cabines disponibles.
		Semaphore cabines = new Semaphore(4, true);
		
		Baigneur A = new Baigneur('A', m, n, o, p, paniers, cabines);
		Baigneur B = new Baigneur('B', m, n, o, p, paniers, cabines);
		Baigneur C = new Baigneur('C', m, n, o, p, paniers, cabines);
		Baigneur D = new Baigneur('D', m, n, o, p, paniers, cabines);
		Baigneur E = new Baigneur('E', m, n, o, p, paniers, cabines);
		Baigneur F = new Baigneur('F', m, n, o, p, paniers, cabines);


		A.start();
		B.start();
		C.start();
		D.start();
		E.start();
		F.start();


	} 

}
