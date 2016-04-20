import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

import javax.swing.*;

public class Fenetre_principale extends JFrame implements KeyListener{

	/**
	 * 
	 */
	protected JLabel Score, Level, Nb_Ligne, FormeSuivante ,  titre_score, titre_level, titre_nb_ligne, titre_forme_suiv;
	GestionTetris gt;
	private JPanelperso TetrisZone;
	private AffichagePan ScorePanel, LevelPanel, NbLignePanel ;
	private AffichagePcsSuivante PcsSuivante;
	
	int t;
	
	private static final long serialVersionUID = -8498480202498074223L;

	public Fenetre_principale(GestionTetris gt) {
		
		//Font font = new Font("Arial",Font.BOLD,12);
		this.gt=gt;
		this.addKeyListener(this);
		
		this.setTitle("Tetris");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		

		  //On crée nos différents conteneurs de couleur différente
		
		//Grille
	    this.TetrisZone = new JPanelperso(gt);
	    this.TetrisZone.setLayout(null);
	    this.TetrisZone.setBackground(new Color(255,255,255));
	    this.TetrisZone.setPreferredSize(new Dimension(300, 600));
	    
	     
	    //panel
	    ScorePanel = new AffichagePan("SCORE");
	    LevelPanel = new AffichagePan("LEVEL");
	    NbLignePanel = new AffichagePan("Nombre de Lignes");
		PcsSuivante = new AffichagePcsSuivante(gt.getPcsSuiv());
	    
	    JPanel Tetris = new JPanel();
	    Dimension dim = new Dimension(600,600);
		Tetris.setPreferredSize(dim);
	    Tetris.setMinimumSize(dim);
	    Tetris.setMaximumSize(dim);
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
	    Tetris.add(this.TetrisZone, gbc);
	    
	    
	    gbc.gridx = 1;
	    gbc.gridheight = 2;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(ScorePanel, gbc);
	    
	    
	    gbc.gridy = 2;
	    gbc.gridheight = 1;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    Tetris.add(LevelPanel, gbc);
	    
	    gbc.gridy = 3;
	    gbc.gridheight = 1;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(NbLignePanel, gbc);
	    
	    gbc.gridy = 4;
	    gbc.gridheight = 2;
	    //Celle-ci indique que la cellule se réplique de façon verticale
	    gbc.fill = GridBagConstraints.VERTICAL;
	    Tetris.add(PcsSuivante, gbc);
	    
	  //On ajoute le conteneur
	    this.setContentPane(Tetris);
	    this.TetrisZone.repaint();
	    this.setVisible(true);    
	    
	}
	

	public void affichage_jeu() {
		this.gt.calculator();
		this.TetrisZone.repaint();
		this.ScorePanel.UpdtatePan( this.gt.getScore());
		this.LevelPanel.UpdtatePan( this.gt.getLevel());
		this.NbLignePanel.UpdtatePan( this.gt.getNbLigne());
		this.PcsSuivante.UpdatePan(this.gt.PieceSuivante);
		
	}



	
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
		
	}
	
	  public void paint(Graphics g)
      {
			
		  	Bloc[][] grille = this.gt.getgrille();
			Color gray = new Color(80,80,80);
			for(int i=0;i<10;i++)
			{
				for (int j=4; j<24;j++) 
				{
						
					g.setColor(grille[i][j].getCouleur());
					g.fillRect(i*30, (j-4)*30, 30 ,30);
					g.setColor(gray);
					g.drawRect(i*30, (j-4)*30, 30 ,30);
				}
			
			}
   
      }

}



