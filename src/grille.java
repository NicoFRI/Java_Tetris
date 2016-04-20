import java.awt.Color;

public class grille {
	private Bloc[][] grille;
	
	public grille(){
				 
		    this.grille = new Bloc [10][24];

		    for (int i=0;i<10;i++) {
		    	for (int j=0;j<24;j++) {
		    	this.grille[i][j] = new Bloc(i,j-4,new Color(80,80,80));
		    	}
		    }

	}
	

	void setBloc(int i, int j, Bloc Bl)
	{
		 this.grille[i][j] = Bl;
	}
	
	
	public Bloc[][] getgrille() {
		return this.grille;
	}
	
	public void setGrille(Bloc[][] gr) {
		this.grille = gr;
	}
}
