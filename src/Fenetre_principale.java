import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

import javax.swing.*;

public class Fenetre_principale extends JFrame implements KeyListener{

	/**
	 * 
	 */
	protected JLabel Score, Level, Nb_Ligne, FormeSuivante;
	GestionTetris gt;
	private JPanelperso cell1;
	
	private static final long serialVersionUID = -8498480202498074223L;

	public Fenetre_principale(GestionTetris gt) {
		
		this.gt=gt;
		this.addKeyListener(this);
		
		this.setTitle("Tetris");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		

		  //On crée nos différents conteneurs de couleur différente
		
		//Grille
	    this.cell1 = new JPanelperso(gt);
	    this.cell1.setBackground(Color.YELLOW);
	    this.cell1.setPreferredSize(new Dimension(300, 600));
	    
	       
	    //panel Score
	    JPanel cell2 = new JPanel();
	    cell2.setBackground(Color.RED);
	    cell2.setPreferredSize(new Dimension(300, 100));
	    cell2.add(new JLabel("Votre score"));
		Score = new JLabel("00000000");
		cell2.add(Score);
	    
		//panel Level
	    JPanel cell3 = new JPanel();
	    cell3.setBackground(Color.BLUE);
	    cell3.setPreferredSize(new Dimension(300, 100));
	    cell3.add(new JLabel("Level"));
		Level = new JLabel("00000000");
		cell3.add(Level);
	    
		//panel nb ligne
	    JPanel cell4 = new JPanel();
	    cell4.setBackground(Color.RED);
	    cell4.setPreferredSize(new Dimension(300, 100));
	    cell4.add(new JLabel("Nb ligne"));
		Nb_Ligne = new JLabel("00000000");
		cell4.add(Nb_Ligne);
	    
		//panel piece suivante.
	    JPanel cell5 = new JPanel();
	    cell5.setBackground(Color.BLUE);
	    cell5.setPreferredSize(new Dimension(300, 100));
	    cell5.add(new JLabel("Suivant"));
		FormeSuivante = new JLabel("Suivant");
		cell5.add(FormeSuivante);
	    
	    JPanel Tetris = new JPanel();
		Tetris.setPreferredSize(new Dimension(600,600));
		Tetris.setBackground(Color.WHITE);
		
		//On définit le layout manager
	    Tetris.setLayout(new GridBagLayout());
	    
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    //On positionne la case de départ du composant
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    //La taille en hauteur et en largeur
	  
	    gbc.gridwidth = 1;
	    gbc.gridheight = 6;
	    
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(this.cell1, gbc);
	    
	    
	    gbc.gridx = 1;
	    gbc.gridheight = 2;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(cell2, gbc);
	    
	    
	    gbc.gridy = 2;
	    gbc.gridheight = 1;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    Tetris.add(cell3, gbc);
	    
	    gbc.gridy = 3;
	    gbc.gridheight = 1;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(cell4, gbc);
	    
	    gbc.gridy = 4;
	    gbc.gridheight = 2;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(cell5, gbc);
	    
	  //On ajoute le conteneur
	    this.setContentPane(Tetris);
	    this.cell1.repaint();
	    this.setVisible(true);    
	    
	}
	

	public void affichage_jeu() {

	}


	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
	
	@Override
	public void keyPressed(KeyEvent OhKAY) {
		if(OhKAY.getKeyCode()==37) { gt.decalePieceGauche();}//Gauche
		if(OhKAY.getKeyCode()==39) { gt.decalePieceDroit();}//Droit
		if(OhKAY.getKeyCode()==40) { gt.descendrePiece(); }//Bas
		if(OhKAY.getKeyCode()==38) { gt.tournerPiece(); }//Haut
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


class JPanelperso extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8957824491001155668L;
	
	GestionTetris gt;
	Piece ActivePiece;
	
	public JPanelperso(GestionTetris gt){
		this.gt = gt;
		Piece ActivePiece = this.gt.getActivePiece();
	}
	
	  public void paint(Graphics g)
      {
			
		  	Bloc[][] grille = this.gt.getgrille();
			
			for(int i=0;i<10;i++) 
			{
				for (int j=4; j<24;j++) 
				{
						
					g.setColor(grille[i][j].getCouleur());
					g.fillRect(grille[i][j].getX()*30, grille[i][j].getY()*30, 30 ,30);

				}
				
			}
      

      }
	
}



