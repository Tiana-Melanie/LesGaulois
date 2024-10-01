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
		assert isInvariantSatisfied() : "La force doit être positive";
		this.equipements = new Equipement[nbMaxEquipement];

	}

	public String getNom() {
		return nom;
	}

	private String prendreParole() {
		return "Le romain " + nom + " :";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

//	public void recevoirCoup(int forceCoup) {
//		//assert pour la Précondition
//		assert force >0 : "Précondition fausse ";
//		
//		int forceAvant = force;
//		force -= forceCoup;
//		
//		//assert pour la postcondition
//		assert force < forceAvant : "Post condition fausse";
//		
//		if (force >0) {
//			parler("Aie !");
//		}else {
//			parler("J'abandonne...");
//		}
//		
//	}

	// travail sur les invariant

	public boolean forceRomainPositive() {
		boolean forceRomain = true;
		if (force > 0) {
			return forceRomain;
		}
		return !(forceRomain);
	}

	public boolean isInvariantSatisfied() {
		return forceRomainPositive();
	}

	// utilisation des équipements

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est bien protégé !");
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
		default:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
			break;

		}
	}

	public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// précondition 
		assert force > 0; 
		int oldForce = force; 
		forceCoup = calculResistanceEquipement(forceCoup); 
		force -= forceCoup; 
//		 if (force > 0) { 
//			 parler("Aïe"); 
//		 }
//		 } else { 
//			 equipementEjecte = ejecterEquipement(); 
//			 parler("J'abandonne..."); 
//		 } 
		if(force == 0 ) {  
			parler("Aïe");
		}else { 
			equipementEjecte = ejecterEquipement(); 
			parler("J'abandonne..."); 
		} 
		// post condition la force a diminuée 
		assert force < oldForce; 
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
//		System.out.println(Equipement.BOUCLIER);
//		System.out.println(Equipement.CASQUE);
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.getNom());
		minus.parler("Je suis un romain");
		minus.recevoirCoup(3);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

	public int getForce() {
		return force;
	}
}
