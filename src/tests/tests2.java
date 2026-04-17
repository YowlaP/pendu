package tests;

import pendu.*;
import java.util.Scanner;

public class tests2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Pendu jeu = new Pendu("cahier");
		System.out.println("Le jeu commence..");
		while(!jeu.aPerdu() && !jeu.aGagne()) {
			jeu.dessine();
			jeu.affiche();
			
			System.out.print("Votre choix : "); 
            
            char c = input.next().charAt(0);
            if (!jeu.choix2(c)) {
                jeu.incrementerErreur();
            }
		}
		// Fin de partie : affichage final
        jeu.dessine();
        if (jeu.aGagne()) {
            jeu.affiche();
            System.out.println("Vous avez gagné !!!"); // [cite: 456]
        } else {
            System.out.println("Perdu !"); // [cite: 444]
            System.out.print("Solution : "); // [cite: 444]
            jeu.afficheSolution();
        }
        
        input.close();
	}

}
