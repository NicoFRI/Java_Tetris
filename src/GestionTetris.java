
public class GestionTetris {
	grille gr;
	
	public GestionTetris(){
		this.gr = new grille();
			
	}
	
	public Bloc[][] getgrille()
	{
		return gr.getgrille();
	}
	
}
