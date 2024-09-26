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
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ "'"+ texte + "'");
	}
	private String prendreParole() {
		return "Le romain " + nom + " :";
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
		Romain obelix = new Romain("obelix",3);
		System.out.println(obelix.getNom());
		System.out.println(obelix.prendreParole());
		obelix.parler("Je suis un romain");
		obelix.recevoirCoup(8);
		
	}
}
