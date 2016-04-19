import java.awt.*;

public class Bloc {
	private int x , y;
	private Color couleur;

	public Bloc(int ex, int ey, Color coul){
		setY(ey);
		setX(ex);
		setCouleur(coul);
	}
	
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	

	
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	 	
}
