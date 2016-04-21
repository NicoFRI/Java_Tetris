import java.awt.Color;

public class Piece {
	private int type; // N� entre 1 et 7
	private int[][] piece = new int[4][4];  // matrice de la piece : 4 x 4
	private int posX; // position en X
	private int posY; // position en Y
	private Color couleur; //couleur de la piece
	
	//constructeur
	public Piece(){
		this.initialise();
	}

	// intialise : g�nere un numero al�atoire en 1 et 7
	// affecte la matrice correndpondant au n� g�n�r�
	// la matrice contient la "forme" de la piece
	// affecte la colleur correndpondant au N� g�n�r�
	private void initialise(){
		
		this.type = (int) (Math.random()*7)+1;
		this.posX = 3;
		this.posY = 0;
				
		 switch (this.type)
		 {
		  	case 1:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{0,1,1,1}, 
		  				{0,0,1,0}, 
		  				{0,0,0,0}
		  				};
		  		
		 	this.setPiece(T);
		 	this.setCouleur(new Color(160,0,240));
		 	break;
		  	}
		  	case 2:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{1,1,0,0}, 
		  				{0,1,1,0}, 
		  				{0,0,0,0}
		  				};
		  		
		  	this.setPiece(T);
		  	this.setCouleur(new Color(240,0,0));
		 	break;
		  	}
		  	case 3:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{0,1,0,0}, 
		  				{0,1,0,0}, 
		  				{0,1,1,0}
		  				};
		  		
		  	this.setPiece(T);
		  	this.setCouleur(new Color(0,240,0));
		 	break;
		  	}
		  	case 4:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{0,1,1,0}, 
		  				{0,1,0,0}, 
		  				{0,1,0,0}
		  				};
		  		
			this.setPiece(T);
			this.setCouleur(new Color(216,144,0));
			break;
		  	}
		  	case 5:
		  	{
		  		int[][] T = {
		  				{0,0,1,0}, 
		  				{0,0,1,0}, 
		  				{0,0,1,0}, 
		  				{0,0,1,0}
		  				};
		  		
			this.setPiece(T);
			this.setCouleur(new Color(0,240,240));
			break;
			}
		  	case 6:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{0,1,1,0}, 
		  				{0,1,1,0}, 
		  				{0,0,0,0}
		  				};
		  		
			 this.setPiece(T);
			 this.setCouleur(new Color(0,0,240));
			 break;
			}
		  	case 7:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{0,0,1,1}, 
		  				{0,1,1,0}, 
		  				{0,0,0,0}
		  				};
		  		
			  this.setPiece(T);	
			  this.setCouleur(new Color(109,170,240));
			 break;
		  	}
		 }
		 
	}

	
	//d�fini le type de piece
	private void setPiece(int[][] piece) {
		this.piece = piece;
	}
	
	//tourne la piece de 90� sur la gauche
	public void rotateLeft(){
		int[][] mat = new int[4][4];
		for (int i = 0; i<4 ;i++)
			for (int j = 0; j<4 ;j++)
			{
				mat[3-j][i]=this.piece[i][j];
			}
		this.setPiece(mat);
	}

	//tourne la piece de 90� sur la droite
	//n'est plus utilis�
	public void rotateRight(){
		int[][] mat = new int[4][4];
		for (int i = 0; i<4 ;i++)
			for (int j = 0; j<4 ;j++)
			{
				mat[j][i]=this.piece[3-i][j];
			}
		this.setPiece(mat);
	}
	
	//renvois la position en X
	public int getPosX() {
		return posX;
	}
	
	//d�fini la position en Y
	public void setPosX(int posX) {
		this.posX = posX;
	}

	//renvois la position en Y
	public int getPosY() {
		return posY;
	}
	
	//D�fini la position en Y
	public void setPosY(int posY) {
		this.posY = posY;
	}

	//modifie la position en Y
	public void modPosY(int ModY) {
		this.posY = this.posY + ModY ;
	}
	
	//modofie la position en X
	public void modPosX(int ModX) {
		this.posX = this.posX + ModX ;
	}
	
	//renvoi la matrice de la piece
	public int[][] getPiece() {
		return piece;
	}

	
	// affiche la patrice de la piece dans la console.
	// d�bugage n'est pas utile dans le programe.
	public void LogPieceDansConsole(){
		System.out.println("type :" + this.type);
		for (int i = 0; i<4 ;i++)
		{
			for (int j = 0; j<4 ;j++)
			{
				System.out.print(this.piece[i][j]);
			
			}
		System.out.println();
		}
	}

	//renois la couleur
	public Color getCouleur() {
		return couleur;
	}

	//defini la couleur
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
}
