package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random valeur = new Random();

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
			System.out.println(prendreParole() +""+ texte +"");
		}
		

	private String prendreParole() {
		return "Le druide "+ nom + ": ";
	}
	
	public int preparerPotion() {
		forcePotion = this.valeur.nextInt(effetPotionMin,effetPotionMax);
		return forcePotion;
	}
	
	public void faireParler() {
		int force = preparerPotion();
		if (force > 7) {
			parler("J'ai preparé une super potion de force "+ force+".");
		}
		else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + force+".");
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obelix")) {
			parler("Non obélix! ... tu n'auras pas de potion magique!");
		}
		else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		System.out.println(panoramix.getNom());
		panoramix.faireParler();
		
		Gaulois obelix = new Gaulois("Obelix", 8);
		panoramix.booster(obelix);
	}
		

}
