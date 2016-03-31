
public class Piece {
	private int type;
	private int[][] piece = new int[4][4];
	private int posX;
	private int posY;
	
	public Piece(){
		initialise();
}

	private void initialise(){
		
		this.type = (int) (Math.random()*6)+1;
		 
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

	
	private void setPiece(int[][] piece) {
		this.piece = piece;
	}
	
	public void rotateLeft(){
		int[][] mat = new int[4][4];
		for (int i = 0; i<4 ;i++)
			for (int j = 0; j<4 ;j++)
			{
				mat[3-j][i]=this.piece[i][j];
			}
		this.setPiece(mat);
	}

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

	public int[][] getPiece() {
		return piece;
	}


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
