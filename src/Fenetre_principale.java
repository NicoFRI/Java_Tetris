import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Fenetre_principale extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	protected JTextField Score, Level, Nb_Ligne, FormeSuivante;
	GestionTetris gt;
	
	private static final long serialVersionUID = -8498480202498074223L;

	public Fenetre_principale(GestionTetris gt) {
		
		this.gt=gt;
		
		
		this.setTitle("Tetris");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		

		  //On crée nos différents conteneurs de couleur différente
	    JPanel cell1 = new JPanel();
	    cell1.setBackground(Color.YELLOW);
	    cell1.setPreferredSize(new Dimension(300, 100));
	    
	    JPanel cell2 = new JPanel();
	    cell2.setBackground(Color.RED);
	    cell2.setPreferredSize(new Dimension(300, 100));
	    cell2.add(new JLabel("Votre score"));
		Score = new JTextField(20);
		cell2.add(Score);
	    
	    JPanel cell3 = new JPanel();
	    cell3.setBackground(Color.BLUE);
	    cell3.setPreferredSize(new Dimension(300, 100));
	    cell3.add(new JLabel("Level"));
		Level = new JTextField(20);
		cell3.add(Level);
	    
	    JPanel cell4 = new JPanel();
	    cell4.setBackground(Color.RED);
	    cell4.setPreferredSize(new Dimension(300, 100));
	    cell4.add(new JLabel("Nb ligne"));
		Nb_Ligne = new JTextField(20);
		cell4.add(Nb_Ligne);
	    
	    JPanel cell5 = new JPanel();
	    cell5.setBackground(Color.BLUE);
	    cell5.setPreferredSize(new Dimension(300, 100));
	    cell5.add(new JLabel("Suivant"));
		FormeSuivante = new JTextField(20);
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
	    Tetris.add(cell1, gbc);
	    
	    
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
	    this.setVisible(true);    
	   
	}
	
	
	public void affichage_jeu(Graphics g) {
		Bloc[][] grille = this.gt.getgrille();
		
		for(int i=0;i<=21;i++) {
			for (int j=0; j<=11;j++) {
					
					g.drawRect(grille[i][j]); 
					
					 int j = 30*j ; grille.drawRect(s, x, y);
				
			}
		}
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}






