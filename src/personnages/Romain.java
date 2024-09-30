package personnages;

public class Romain {
	private static int nbMaxEquipement = 2;
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert IsInvariantSatisfied() : "La force doit être positive";
		this.equipements= new Equipement[nbMaxEquipement];
		
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
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 : 
			System.out.println("Le soldat " + nom+ " est bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
                System.out.println("Le soldat " + nom + " possède déjà " + equipement + ".");
            } else {
                equipements[nbEquipement] = equipement;
                nbEquipement++;
                System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
            }
			break;
		default :
			equipements[nbEquipement]= equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
			break;
			
			
		
		}
	}
	
	
	
	public static void main(String[] args) {
//		System.out.println(Equipement.BOUCLIER);
//		System.out.println(Equipement.CASQUE);
		Romain Minus = new Romain("Minus", 6);
		System.out.println(Minus.getNom());
		Minus.parler("Je suis un romain");
		Minus.recevoirCoup(3);
		
		Minus.sEquiper(Equipement.CASQUE);
		Minus.sEquiper(Equipement.CASQUE);
		Minus.sEquiper(Equipement.BOUCLIER);
		Minus.sEquiper(Equipement.CASQUE);
		
	}
}
