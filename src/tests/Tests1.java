package tests;

import pendu.*;

public class Tests1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pendu p1 = new Pendu();
		System.out.println("--- DESSIN COMPLET ---");
		p1.dessinePendu();
		
		System.out.println("\n--- ÉVOLUTION DU DESSIN ---");
		for (int i = 0; i <= 11; i++) {
            System.out.println("Nombre d'erreurs : " + i);
            p1.dessine();
            System.out.println("--------------------");
            
            if (!p1.aPerdu()) {
                p1.incrementerErreur();;
            }
        }
	}

}
