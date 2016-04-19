import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GestionTetris   {
	grille gr;
	Piece ActivePiece;
	Piece PieceSuivante;
	Boolean stop;
	
	public GestionTetris(){
		this.gr = new grille();
		this.ActivePiece = new Piece();
		this.PieceSuivante = new Piece();
		
	
	}
	
	public void descendrePiece()
	{
		this.ActivePiece.modPosY(-1);
	}
	
	public Bloc[][] getgrille()
	{
		return gr.getgrille();
	}
	
	public Piece getActivePiece()
	{
		return this.ActivePiece;
	}

	public void decalePieceGauche() {
		this.ActivePiece.modPosX(-1);
	}

	public void decalePieceDroit() {
		this.ActivePiece.modPosX(-1);
	}

	public void tournerPiece() {
		this.ActivePiece.rotateLeft();
	}
	
	public void calculgrille()
	{
		
		
	}
	
}
