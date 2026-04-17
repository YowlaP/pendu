package pendu;

public class Pendu {

	final static char[][] tabPendu = {
	        {' ', ' ', '_', '_', '_', ' '},
	        {' ', '|', '/', ' ', '|', ' '},
	        {' ', '|', ' ', ' ', 'O', ' '},
	        {' ', '|', ' ', '/', '|', '\\'}, 
	        {' ', '|', ' ', '/', ' ', '\\'},
	        {'_', '|', '_', ' ', ' ', ' '}
	    };

    final static int[][] tabLimite = {
        {0, 0, 3, 3, 3, 0},
        {0, 2, 4, 0, 5, 0},
        {0, 2, 0, 0, 6, 0},
        {0, 2, 0, 8, 7, 9},
        {0, 2, 0, 10, 0, 11},
        {1, 1, 1, 0, 0, 0}
    }; 
	
    private int nbErreurs;
    private String solution;
    private boolean[] trouve;
    
    public Pendu() {
    	
    	this.nbErreurs = 0;
    }
    
    public Pendu(String s) {
    	
    	this.nbErreurs = 0;
    	this.solution = s;
    	this.trouve = new boolean[solution.length()];
    	
    	for(int i = 0; i < solution.length(); i++) {
    		trouve[i] = false;
    	}
    }
    
    public void incrementerErreur() {
    	
    	this.nbErreurs ++;
    }
    
    public boolean aPerdu() {
    	
    	return nbErreurs >= 11;
    }
    
    public void dessinePendu() {
    	
    	for(int i = 0; i < 6; i++) {
    		for(int j = 0; j < 6; j++) {
    			System.out.print(tabPendu[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public char caractere(int i, int j) {
    	
    	if(tabLimite[i][j] > 0 && tabLimite[i][j] <= this.nbErreurs) {
    		return tabPendu[i][j];
    	}
    	return ' ';
    	
    }
    
    public void dessine() {
    	for(int i = 0; i < 6; i++) {
    		for(int j = 0; j < 6; j++) {
    			System.out.print(caractere(i, j));	
    		}
    		System.out.println("\n");
    	}
    }
    
    public void afficheSolution() {
    	
    	for (int i = 0; i < solution.length(); i++) {
    		System.out.print(solution.charAt(i) + " ");
			
		}
    	System.out.println();
    }
    
    public void affiche() {
    	for (int i = 0; i < solution.length(); i++) {
    		if(trouve[i]) {
    			System.out.print(solution.charAt(i) + " ");
    		}
    		System.out.print("_ ");
    	}
    	System.out.println();
    }
    
    public boolean choix1(char c) {
    	
    	boolean estTrouve = false;
    	for (int i = 0; i < solution.length(); i++) {
    		if(solution.charAt(i) == c) {
    			trouve[i] = true;
    			estTrouve = true;
    			
    		}
    	}
    	return estTrouve;
    }
    
    public boolean choix2(char c) {
    	
    	boolean estTrouve = false;
    	int i = solution.indexOf(c, 0);
    	while(i != -1) {
    		trouve[i] = true;
			estTrouve = true;
			i = solution.indexOf(c, i + 1);
			
    	}
    	return estTrouve;
    }
    
    public boolean aGagne() {
    	for (int i = 0; i < solution.length(); i++) {
    		if(!trouve[i]) {
    			return false;
    		}	
		}
    	return true;
    }
    
    
	
}
