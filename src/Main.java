import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Main {

	public static void main(String[] args) {
		
		AudioStream son = null;
		GestionTetris gt = new GestionTetris(); //création du controleur
		Fenetre_principale f1 = new Fenetre_principale(gt); //création de la fenetre
        f1.pack(); 
        f1.setVisible(true); //affiche la fenetre
       
        try {
			son=new AudioStream(new FileInputStream("file:/../tetris_tone_loop.wav"));
			AudioPlayer.player.start(son);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
  
        AudioPlayer.player.stop(son);
        

        
       }
        
        
}
