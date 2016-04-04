public class Main {

	public static void main(String[] args) {
		GestionTetris gt = new GestionTetris();
		Fenetre_principale f1 = new Fenetre_principale(gt);
        f1.pack();
        f1.setVisible(true);
        
	}
}
