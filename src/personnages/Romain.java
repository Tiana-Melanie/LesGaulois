package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert IsInvariantSatisfied() : "La force doit être positive";
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
		//assert pour la Précondition
		assert force >0 : "Précondition fausse ";
		
		int forceAvant = force;
		force -= forceCoup;
		
		//assert pour la postcondition
		assert force < forceAvant : "Post condition fausse";
		
		if (force >0) {
			parler("Aie !");
		}else {
			parler("J'abandonne...");
		}
		
	}
	
	//travail sur les invariant et postcondition
	
	public boolean forceRomainPositive() {
		boolean forceRomain=true;
		if (force > 0) {
			return forceRomain;
		}
		return !(forceRomain);
	}
	
	public boolean IsInvariantSatisfied() {
		return forceRomainPositive();
	}
	
	
	
	public static void main(String[] args) {
		
		Romain Minus = new Romain("Minus", 6);
		System.out.println(Minus.getNom());
		Minus.parler("Je suis un romain");
		Minus.recevoirCoup(3);
		
	}
}
