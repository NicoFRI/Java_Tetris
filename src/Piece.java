
public class Piece {
	private int type; // N° entre 1 et 7
	private int[][] piece = new int[4][4];  // matrice de la piece
	private int posX; // position en X
	private int posY; // position en Y
	
	//constructeur
	public Piece(){
		this.initialise();
	}

	// intialise : génere un numero aléatoire en 1 et 7
	// affecte la matrice correndpodant au n° généré
	private void initialise(){
		
		this.type = (int) (Math.random()*6)+1;
		this.posX = 0;
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
		 	break;
		  	}
		  	case 4:
		  	{
		  		int[][] T = {
		  				{0,0,0,0}, 
		  				{0,1,0,0}, 
		  				{0,1,0,0}, 
		  				{0,1,1,0}
		  				};
		  		
			this.setPiece(T);	
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
			 break;
		  	}
		 }
		 
	}

	
	//défini le type de piece
	private void setPiece(int[][] piece) {
		this.piece = piece;
	}
	
	//tourne la piece de 90° sur la gauche
	public void rotateLeft(){
		int[][] mat = new int[4][4];
		for (int i = 0; i<4 ;i++)
			for (int j = 0; j<4 ;j++)
			{
				mat[3-j][i]=this.piece[i][j];
			}
		this.setPiece(mat);
	}

	//tourne la piece de 90° sur la droite
	public void rotateRight(){
		int[][] mat = new int[4][4];
		for (int i = 0; i<4 ;i++)
			for (int j = 0; j<4 ;j++)
			{
				mat[j][i]=this.piece[3-i][j];
			}
		this.setPiece(mat);
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void modPosY(int ModY) {
		this.posY = this.posY + ModY ;
	}
	
	public void modPosX(int ModX) {
		this.posX = this.posX + ModX ;
	}
	
	//renvoi la matrice de la piece
	public int[][] getPiece() {
		return piece;
	}

	
	// affiche la patrice de la piece dans la console.
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
}
