package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax, int forcePotion) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = forcePotion;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return "Mon nom est " + nom;
	}

	public void parler(String texte) {
			System.out.println(prendreParole() +""+ texte +"");
		}
		

	private String prendreParole() {
		return "Le druide "+ nom + ": ";
	}
	
	public int preparerPotion() {
		Random valeur= new Random();
		return forcePotion = valeur.nextInt(effetPotionMin,effetPotionMax);
	}
	
	public void faireParler() {
		int force = preparerPotion();
		if (force > 7) {
			parler("J'ai preparé une super potion de force " + force);
		}
		else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + force);
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
		Druide Panoramix = new Druide("Panoramix",5,10,1);
		System.out.println(Panoramix.getNom());
		Panoramix.faireParler();
		
		Gaulois obelix = new Gaulois("Obelix", 8);
		Panoramix.booster(obelix);
	}
		

}
