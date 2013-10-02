import java.io.IOException;
import java.util.Scanner;

import universite.administratif.Laboratoire;
import universite.administratif.Universite;
import universite.batiment.SalleTP;
import universite.personnel.ChargeRecherche;


public class Main {

	public static void main(String[] args) {
		
		
		
		Universite universite = new Universite();
		
		Laboratoire l1 = new Laboratoire();
		Laboratoire l2 = new Laboratoire();
		
		universite.ajoutLaboratoire(l1);
		universite.ajoutLaboratoire(l2);
		
		
		ChargeRecherche c1 = new ChargeRecherche(0, "lel");
		
		l1.ajouteChercheur(c1);
		
		ChargeRecherche c2 = ((ChargeRecherche)c1.clone());
		c2.setAnciennete(10);
		l2.ajouteChercheur(c2);
		
		
		try {
			XMLManager.exportToXML(universite);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
