import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichagePan extends JPanel{


	private static final long serialVersionUID = -2047258612876503544L;
	protected JLabel ScoreLabel, titre_score; //declaration des Jpanel
	private String score; // Défini la chaine de score affiché
	
	//constructeur
	public AffichagePan(String Titre) {
		//FIx les propriété Graphique
	this.setLayout(null); 
    this.setBackground(new Color(20,20,20));
    this.setPreferredSize(new Dimension(300, 100));
    
    //label titre du Panneau
    titre_score = new JLabel(Titre);
    titre_score.setForeground(new Color(255,255,255));
    titre_score.setFont(new Font("Courrier New",Font.BOLD,25));
    titre_score.setHorizontalAlignment(JLabel.CENTER);
    this.add( titre_score);
    titre_score.setBounds(0, 15, 300, 30);
    
    //label contenant les information dynamaique
    ScoreLabel = new JLabel("00000000");
    ScoreLabel.setForeground(new Color(255,255,255));
    ScoreLabel.setFont(new Font("Courrier New",Font.BOLD,20));
    ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
	this.add(ScoreLabel);
	ScoreLabel.setBounds(0, 45, 300, 30);
	
	}
	
	//MAJ du label
	public void UpdtatePan(int S){
	
	//forge un chaine de charactere avec le score
	this.score = ("0000000" + S);	
	//tronque la chaine
	this.score = this.score.substring(this.score.length()-6, this.score.length());
	
	//redéfini la chaine
	ScoreLabel.setText(this.score);
	}

}
