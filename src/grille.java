import java.awt.Color;

public class grille {
	public Bloc[][] grille;
	
	public grille(){
				 
		    grille = new Bloc [10][24];

		    for (int i=0;i<10;i++) {
		    	for (int j=0;j<24;j++) {
		    	System.out.println(i*j);	
		   		grille [i][j]=new Bloc(i,j-4,new Color((1+i)*(j+1),(1+i)*(j+1),(1+i)*(j+1)));
		    	}
		    }

	}
	
	
	public Bloc[][] getgrille() {
		return grille;
	}
	
}
