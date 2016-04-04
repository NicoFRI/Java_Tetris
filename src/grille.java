import java.awt.Color;

public class grille {
	public Bloc[][] grille;
	
	public grille(){
				 
		    grille = new Bloc [12][21];

		    for (int i=0;i<12;i++) {
		    	for (int j=0;j<21;j++) {
		   		grille [i][j]=new Bloc(i,j,new Color(i*21,j*12,i+j));
		    	}
		    }

		    for (int i=0;i<12;i++) {
		        grille [i][20]=new Bloc(i,20,new Color(100,100,100));
		    }

		    for (int j=0;j<21;j++) {
		    	grille [0][j]=new Bloc(0,j,new Color(100,100,100));
		    	grille [11][j]=new Bloc(11,j,new Color(100,100,100));
		    }	 
	}
	
	
	public Bloc[][] getgrille() {
		return grille;
	}
	
}
