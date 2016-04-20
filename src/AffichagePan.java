import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichagePan extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2047258612876503544L;
	protected JLabel ScoreLabel, titre_score;
	private String score;
	
	public AffichagePan(String Titre) {
    this.setLayout(null);
    this.setBackground(new Color(20,20,20));
    this.setPreferredSize(new Dimension(300, 100));
    
    titre_score = new JLabel(Titre);
    titre_score.setForeground(new Color(255,255,255));
    titre_score.setFont(new Font("Courrier New",Font.BOLD,25));
    titre_score.setHorizontalAlignment(JLabel.CENTER);
    this.add( titre_score);
    titre_score.setBounds(0, 15, 300, 30);
    
    
    ScoreLabel = new JLabel("00000000");
    ScoreLabel.setForeground(new Color(255,255,255));
    ScoreLabel.setFont(new Font("Courrier New",Font.BOLD,20));
    ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
	this.add(ScoreLabel);
	ScoreLabel.setBounds(0, 45, 300, 30);
	
	}
	
	public void UpdtatePan(int S){
	this.score = ("0000000" + S);	
	this.score = this.score.substring(this.score.length()-6, this.score.length());
	ScoreLabel.setText(this.score);
	}

}
