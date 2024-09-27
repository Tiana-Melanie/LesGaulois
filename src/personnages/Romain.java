package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " :";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ "'"+ texte + "'");
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force >0) {
			parler("Aie");
		}else {
			parler("J'abandonne...");
		}
	}
	public static void main(String[] args) {
		
		Romain Minus = new Romain("Minus", 6);
		System.out.println(Minus.getNom());
		System.out.println(Minus.prendreParole());
		Minus.parler("Je suis un romain");
		Minus.recevoirCoup(8);
		
	}
}
