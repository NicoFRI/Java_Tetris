
public class grille {
	public Bloc[][] grille;
	
	public grille(){
				 
		    grille = new Bloc [11][21];

		    for (int i=0;i<12;i++) {
		    	for (int j=0;j<21;j++) {
		   		grille [i][j]=new Bloc(i,j,0);
		    	}
		    }

		    for (int i=0;i<10;i++) {
		        grille [i][21]=new Bloc(i,21,1);
		    }

		    for (int j=0;j<11;j++) {
		    	grille [0][j]=new Bloc(0,j,1);
		    	grille [11][j]=new Bloc(11,j,1);
		    }	 
	}
	
	
	public Bloc[][] getgrille() {
		return grille;
	}
	
}
