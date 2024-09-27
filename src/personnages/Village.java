package personnages;

public class Village {
	private static final int nbVillageoisMaximum=50;
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	

	public Village(String nom) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public Village(int nbVillageoisMaximum) {
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;		
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois-1];
	}
	
//	public void afficherVillageois() {
//		System.out.println("Dans le village du chef" + chef.getNom() + "vivent les légendaires gaulois : ");
//		for(int i = 0; i < nbVillageois;i++) {
//			System.out.println("-");
//		}
//	}
	
	public static void main(String[] args) {
		Village village1=new Village(30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//Index 30 out of bounds for length 30
		
		Chef Abraracourcix = new Chef("Abaracourcix", 6, village1);
		
		Gaulois astérix = new Gaulois("Asterix",8);
		village1.ajouterHabitant(astérix);
		
		Gaulois bob = new Gaulois("bob",8);
		village1.ajouterHabitant(bob);
		
//		Gaulois gaulois =  village.trouverHabitant(1);
//		System.out.println(gaulois);
//		null mais on le met a 0 il trouve le gaulois
		
//		village1.afficherVillageois();
		
	}
	
	
}
