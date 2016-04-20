import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AffichagePcsSuivante extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3266476620462014388L;
	protected JLabel titre_forme_suiv;
	private Piece Pcs;
	private ZonePCS AffichePiece;
	
	public AffichagePcsSuivante(Piece Piec) {
	this.Pcs = Piec;
	this.setLayout(null);
	this.setBackground(new Color(20,20,20));
	this.setPreferredSize(new Dimension(300, 100));
  
	 titre_forme_suiv = new JLabel("Forme suivante");
	 titre_forme_suiv.setForeground(new Color(255,255,255));
	 titre_forme_suiv.setFont(new Font("Courrier New",Font.BOLD,25));
	 titre_forme_suiv.setHorizontalAlignment(JLabel.CENTER);
	 this.add( titre_forme_suiv);
	 titre_forme_suiv.setBounds(0, 15, 300, 30);
	 
	 AffichePiece = new ZonePCS(this.Pcs);
	 //AffichePiece.setForeground(new Color(255,255,255));
	 	 
	 this.add( AffichePiece);
	 AffichePiece.setBounds(60, 60, 180, 180);
	 AffichePiece.repaint();
	 
	}
	
	public void UpdatePan(Piece Piec){
		this.setPiece(Piec);
		AffichePiece.repaint();
	}
	
	public void setPiece(Piece Piec){
		this.Pcs = Piec; 
		this.AffichePiece.setPiece(Piec);
	}
	
}


class ZonePCS extends JPanel{
	
	private Piece Pcs;
	
	public ZonePCS(Piece Piec){
	this.setPiece(Piec);		
	}
	 
	public void setPiece(Piece Piec){
		this.Pcs = Piec; 
	}
	
	public void paint(Graphics g)
      {
			
		  	int[][] MatPcs = this.Pcs.getPiece();
		  	Color ColPcs = this.Pcs.getCouleur();
			Color gray = new Color(80,80,80);
			
			g.setColor(gray);
			g.fillRect(0,0, 30*6 ,30*6);
			
			for(int i=0;i<4;i++)
			{
				for (int j=0; j<4;j++) 
				{
					
					if (MatPcs[i][j] == 1){
					g.setColor(ColPcs);
					g.fillRect(30+i*30, 60+j*30, 30 ,30);
					g.setColor(gray);
					g.drawRect(30+i*30, 60+j*30, 30 ,30);
					}
				}
			
			}

      }
}