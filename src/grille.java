import java.awt.Color;

public class grille {
	private Bloc[][] grille;
	
	public grille(){
				 
		    this.grille = new Bloc [10][24]; //Grille = Tableau de Bloc de 10*24case

		    for (int i=0;i<10;i++) {
		    	for (int j=0;j<24;j++) {
		    	this.grille[i][j] = new Bloc(i,j-4,new Color(80,80,80)); //==> pour chaque case cré un bloc gris
		    	}
		    }

	}
	

	void setBloc(int i, int j, Bloc Bl) //permet de définir un bloc
	{
		 this.grille[i][j] = Bl;
	}
	
	
	public Bloc[][] getgrille() { //renvois la grille
		return this.grille;
	}
	
	public void setGrille(Bloc[][] gr) { //redéfini la grille
		this.grille = gr;
	} 
}
