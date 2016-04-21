public class Main {

	public static void main(String[] args) {
		GestionTetris gt = new GestionTetris(); //création du controleur
		Fenetre_principale f1 = new Fenetre_principale(gt); //création de la fenetre
        f1.pack(); 
        f1.setVisible(true); //affiche la fenetre
        
        try { 
        	  synchronized (f1) { //syncronise la fentre
        		  while (gt.isNotOver()) {//boucle tant que la partie n'est pas fini
        	   
        			  f1.affichage_jeu(); //lanc la MAJ de la fenetre (et du controleur)
        		
        			  f1.wait(50); //fait atendre la fenetre 50millisecondes
        		  }
        	  }
        	 } catch (InterruptedException ex) {
        	   
       }
        
        f1.affichage_jeu();
	}
}
