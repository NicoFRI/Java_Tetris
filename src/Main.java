public class Main {

	public static void main(String[] args) {
		GestionTetris gt = new GestionTetris();
		Fenetre_principale f1 = new Fenetre_principale(gt);
        f1.pack();
        f1.setVisible(true);
        
        try {
        	  synchronized (f1) {
        	   while (true) {//Or any Loops
        	   
        		f1.affichage_jeu();
        		
        	   f1.wait(50);//Sample obj.wait(1000); 1 second sleep
        	   }
        	  }
        	 } catch (InterruptedException ex) {
        	   //SomeFishCatching
       }
        
	}
}
