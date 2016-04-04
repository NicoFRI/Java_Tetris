import java.awt.*;

public class Bloc  {
	private int x , y;
	private int couleur;

	public Bloc(int x, int y, int coul){
		setY(y);
		setX(x);
		setCouleur(coul);
	}
	
	
	public Rectangle getBloc() {
		 Rectangle Rect = new Rectangle(this.x*30, this.y*30, 30 ,30);
		return Rect;
	}
	
	
	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	 	
}
