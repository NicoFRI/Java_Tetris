import java.awt.Color;


public class GestionTetris   {
	grille gr;
	Bloc[][] GrilleDynamique;
	Piece ActivePiece;
	Piece PieceSuivante;
	Boolean stop;
	
	public GestionTetris(){
		this.gr = new grille();
		this.ActivePiece = new Piece();
		this.PieceSuivante = new Piece();
		this.GrilleDynamique = this.gr.getgrille();
	
	}
	

	
	public Bloc[][] getgrille()
	{
		return this.GrilleDynamique;
	}
	
	public Piece getActivePiece()
	{
		return this.ActivePiece;
	}

	public void descendrePiece()
	{
		if(TestMouventPiece(0,1,false)){
			this.ActivePiece.modPosY(1);
			this.calculgrille();
		}else{
			this.FinDePiece();
		}

	}
	
	public void decalePieceGauche() {
		
		if(TestMouventPiece(-1,0,false)){
			this.ActivePiece.modPosX(-1);
			this.calculgrille();
		}
		
	}

	public void decalePieceDroit() {
		
		if(TestMouventPiece(1,0,false)){
			this.ActivePiece.modPosX(1);
			this.calculgrille();
		}
		
	}

	public void tournerPiece() {
		
		if(TestMouventPiece(0,0,true)){
			this.ActivePiece.rotateLeft();
			this.calculgrille();
		}
	}
	
	public void calculgrille()
	{
		// crée une nouvelle Grille
		this.GrilleDynamique = new Bloc [10][24];
		
		//copy la Grille dans la Grille Dynamique
	    for (int i=0;i<10;i++) {
	    	for (int j=0;j<24;j++) {
	    		this.GrilleDynamique[i][j] = this.gr.getgrille()[i][j];
	    	}
	    }
		
	    //recupere les infos de la piece active (juste pour rendre le code lisible)
		int Xpiece = this.ActivePiece.getPosX();
		int Ypiece = this.ActivePiece.getPosY();
		Color CouleurPiece = this.ActivePiece.getCouleur();
		Color CaseVide = new Color(80,80,80);
		int[][] GrillePiece = this.ActivePiece.getPiece();
		
		//place la piece dans la grille dynamique.
	    //pour les 4x4 de la matrice de la piece
		for (int i=0;i<4;i++) {
	    	for (int j=0;j<4;j++) {
	    		
	    		if (GrillePiece[i][j] == 1 && this.GrilleDynamique[i+Xpiece][j+Ypiece].getCouleur().getRGB() == CaseVide.getRGB())
	    		{	
	    			this.GrilleDynamique[i+Xpiece][j+Ypiece] = new Bloc(i+Xpiece,j+Ypiece-4,CouleurPiece);
	    		}
   		
	    	}
	    }
	}
	
	public boolean TestMouventPiece(int DeltaX, int DeltaY, boolean Rot)
	{
		boolean OkNok = true;
		
		
		int Xpiece = this.ActivePiece.getPosX()+DeltaX;
		int Ypiece = this.ActivePiece.getPosY()+DeltaY;
		Color CaseVide = new Color(80,80,80);
		int[][] GrillePiece = this.ActivePiece.getPiece();
		
		if (Rot == true)
		{
			this.ActivePiece.rotateLeft();
			GrillePiece = this.ActivePiece.getPiece();
			this.ActivePiece.rotateRight();

		}
		
	//place la piece dans la grille dynamique.
	    //pour les 4x4 de la matrice de la piece
		for (int i=0;i<4;i++) {
	    	for (int j=0;j<4;j++) {
	    		
	    		if (GrillePiece[i][j] == 1) { //si c'est un bloc de la piece
	    			
    			
	    			if ( i+Xpiece >=10 || i+Xpiece < 0 || j+Ypiece >=24 || j+Ypiece < 0) { //si il sort de la grille 
	    				
	    				OkNok = false;
	    				
	    			}else{ // si il esy dans la grille
	    			
	    				//si il rencontre un bloc vide.
	    			if (this.gr.getgrille()[i+Xpiece][j+Ypiece].getCouleur().getRGB() != CaseVide.getRGB()){
	    				
	    				OkNok = false;
	    			}
  						    			
	    			}
	    		}
	    	}
		}
		
		return OkNok;
	}
	
	
	private void FinDePiece() {
		
		Color CaseVide = new Color(80,80,80);
		Color BlocLigneComplet = new Color(250,250,250);
		int cpt = 0;
		boolean ligneComplete = false;
		
	    for (int j=4;j<24;j++) {
	    	cpt=0;
	    	for (int i=0;i<10;i++) {
	    		cpt=cpt+1;
	    		
	    		if (this.GrilleDynamique[i][j].getCouleur().getRGB() == CaseVide.getRGB()){
	    			cpt=0;
	    			break;
	    		}
	    		
	    		if (cpt == 10){
	    			ligneComplete=true;
	    			
	    	    	for (int l=0;l<10;l++) {
	    	    		this.GrilleDynamique[l][j].setCouleur(BlocLigneComplet);
   	    		
    	    		}			
	    		}
	    	}
	    }
	    

	    /*try{
	    	  Thread.sleep(500);
	    }catch(InterruptedException ex){
	    	  
	    }*/
	    
	    if (ligneComplete){
	    	cpt=0;
		    
	    	for (int i=0;i<10;i++) {
		    	
	    		for (int j=0;j<24;j++) {
		    		if (this.GrilleDynamique[i][j].getCouleur().getRGB() == BlocLigneComplet.getRGB()){
		    			cpt=cpt+1;
		    					    			
		    			for (int u=0;(j-u)>4;u++) {
		    				this.GrilleDynamique[i][j-u] = this.GrilleDynamique[i][j-u-1];
		    				
		    			}
		    				this.GrilleDynamique[i][0] = new Bloc(i, -4 , CaseVide);
		    			
		    		}
		    	}
		    }
	    }
	    
	    
		
		this.gr.setGrille(this.GrilleDynamique);
		this.ActivePiece = this.PieceSuivante;
		this.PieceSuivante = new Piece();
		
	}



	public Piece getPcsSuiv() {
		
		return this.PieceSuivante;
	}
	
	
	
	
	
	
	
}
