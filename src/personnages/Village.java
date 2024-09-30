package personnages;

public class Village {
	private static final int nbVillageoisMaximum=50;
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
// au lieu de l'initialisé ailleurs on peut le mettre en haut comme ça on donne le nom et la taille max
//	public Village(int nbVillageoisMaximum) {
//		villageois = new Gaulois[nbVillageoisMaximum];
//	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if(nbVillageois<villageois.length){
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
		}
				
	}
	
	public Gaulois trouverHabitant(int numeroVillageois) {
		return villageois[numeroVillageois-1];
	}
	
	public void afficherVillageois() {
		if (chef != null) {
			System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
			for(int i = 0; i < nbVillageois;i++) {
				System.out.println("-"+ villageois[i].getNom());
			}
		}
		else {
			System.out.println("Le village n'a pas encore de chef");
		}
	}
	
	public static void main(String[] args) {
		Village village= new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(31);
		//Index 30 out of bounds for length 30
		
		Chef abraracourcix = new Chef("Abaracourcix", 6, village);
		
		Gaulois astérix = new Gaulois("Astérix",8);
		village.ajouterHabitant(astérix);
		
		Gaulois obélix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obélix);
		
		Gaulois gaulois =  village.trouverHabitant(1);
		System.out.println(gaulois);
		
		//null mais on le met a 0 il trouve le gaulois
		
		village.setChef(abraracourcix);
		village.afficherVillageois();
		
	}
	
	
}
