package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class Scenario {
	
	

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Asterix", 8);
		
		Romain minus;
		minus = new Romain("Minus", 6);
		
		Gaulois obelix;
		obelix = new Gaulois("Obelix", 25);
		
		Druide panoramix ;
		panoramix = new Druide("Panoramix", 5,10,1);
		
		panoramix.parler("je vais aller préparer une petite potion ...");
		panoramix.faireParler();
		panoramix.booster(obelix);
		
		obelix.parler("Par Bélénos, ce n'est pas juste");
		
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(minus);
		
		
		
	}

}
