import java.util.Scanner;

import universite.administratif.Departement;
import universite.administratif.Laboratoire;
import universite.administratif.UFR;
import universite.batiment.Batiment;
import universite.batiment.Bureau;
import universite.batiment.SalleReunion;
import universite.batiment.SalleTP;
import universite.personnel.ChargeRecherche;
import universite.personnel.Chercheur;
import universite.personnel.MaitreDeConf;
import universite.personnel.PRAG;
import universite.personnel.Professeur;


public class GUI {

	private static enum type {ChargeRecherche, MaitreDeConf, Professeur, PRAG};
	public static Scanner sc = new Scanner(System.in);
	
	private static int choixInt(int indexMax)
	{
		System.out.println("Choix :");
		int choix;
		while((choix = sc.nextInt()) < 0 || choix > indexMax);
		
		return choix;
	}
	
	private static String choixString()
	{
		System.out.println("Choix :");
		String s;
		while((s = sc.next()).isEmpty());
		
		return s;
	}
	
	private static boolean choixBool()
	{
		System.out.println("1 - Oui \t 0 - Non");
		String s;
		return choixInt(2)==0;
	}
	
	public static void menuPrincipal()
	{
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter UFR");
		System.out.println("2. Ajouter Laboratoire");
		System.out.println("3. Ajouter Département");
		System.out.println("4. Afficher université (très moche)");
		
		int res = choixInt(4);
		
		switch (res)
		{
		case 0:
			break;
		case 1:
			menuUFR();
			menuPrincipal();
			break;
		case 2:
			menuLaboratoire();
			menuPrincipal();
			break;
		case 3:
			menuDepartement();
			menuPrincipal();
			break;
		case 4:
			System.out.println(Main.universite);
			menuPrincipal();
			break;
		}
	}
	
	private static void menuLaboratoire() {
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter Chercheur");
		
		int res = choixInt(2);
		Laboratoire labo = new Laboratoire();
		
		switch(res)
		{
		case 0:
			break;
		case 1:
			ajoutChercheur(labo);
			menuLaboratoire();
			Main.universite.ajoutLaboratoire(labo);
			break;
		}
	}

	private static void menuDepartement() {
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter Enseignant");
		
		int res = choixInt(2);
		Departement dep = new Departement();
		
		switch(res)
		{
		case 0:
			break;
		case 1:
			ajoutEnseignant(dep);
			menuDepartement();
			Main.universite.ajoutDepartement(dep);
			break;
		}
	}
	
	public static void ajoutEnseignant(Departement _dep)
	{
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter Maitre de Conférence");
		System.out.println("2. Ajouter Professeur");
		System.out.println("3. Ajouter PRAG");
		
		int res = choixInt(4);
				
		switch(res)
		{
		case 0:
			break;
		case 1:
			menuEnseignant(_dep, type.MaitreDeConf);
			ajoutEnseignant(_dep);
			break;
		case 2:
			menuEnseignant(_dep, type.Professeur);
			ajoutEnseignant(_dep);
			break;
		case 3:
			menuEnseignant(_dep, type.PRAG);
			ajoutEnseignant(_dep);
			break;
		}
	}
	
	public static void ajoutChercheur(Laboratoire _labo)
	{
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter Maitre de Conférence");
		System.out.println("2. Ajouter Professeur");
		System.out.println("3. Ajouter Chargé de recherche");
		
		int res = choixInt(4);
				
		switch(res)
		{
		case 0:
			break;
		case 1:
			menuChercheur(_labo, type.MaitreDeConf);
			ajoutChercheur(_labo);
			break;
		case 2:
			menuChercheur(_labo, type.Professeur);
			ajoutChercheur(_labo);
			break;
		case 3:
			menuChercheur(_labo, type.ChargeRecherche);
			ajoutChercheur(_labo);
			break;
		}
	}
	
	public static void menuChercheur(Laboratoire _lab, type _type)
	{
		System.out.println("Quel est le prénom de cette personne ?");
		String nom = choixString();
		
		System.out.println("Quel est le prénom de cette personne ?");
		String prenom = choixString();
		
		switch(_type)
		{
		case ChargeRecherche:
			ChargeRecherche ch = new ChargeRecherche();
			ch.setNom(nom);
			ch.setPrenom(prenom);
			
			System.out.println("Quel est l'ancienneté de cette personne ?");
			ch.setAnciennete(choixInt(100));
			
			System.out.println("Quel est le sujet de recherche actuel de cette personne ?");
			ch.setSujetRecherche(choixString());
			_lab.ajouteChercheur(ch);
			break;
		case MaitreDeConf:
			MaitreDeConf mc = new MaitreDeConf();
			mc.setNom(nom);
			mc.setPrenom(prenom);
			
			System.out.println("Combien de cours sont dispencé par cette personne ?");
			mc.setNbCours(choixInt(50));
			
			System.out.println("Quel est le sujet de la prochaine conférence de cette personne");
			mc.setSujetConf(choixString());
			
			_lab.ajouteChercheur(mc);
			break;
		case Professeur:
			Professeur p = new Professeur();
			p.setNom(nom);
			p.setPrenom(prenom);
			
			System.out.println("Quelle matière est enseignée par cette personne ?");
			p.enseigner(choixString());
			
			System.out.println("Le professeur mène-t-il une recherche actuellement ?");
			p.setCherche(choixBool());
			
			_lab.ajouteChercheur(p);
			break;
		}
	}

	public static void menuEnseignant(Departement _dep, type _type)
	{
		System.out.println("Quel est le prénom de cette personne ?");
		String nom = choixString();
		
		System.out.println("Quel est le prénom de cette personne ?");
		String prenom = choixString();
		
		switch(_type)
		{
		case MaitreDeConf:
			MaitreDeConf mc = new MaitreDeConf();
			mc.setNom(nom);
			mc.setPrenom(prenom);
			
			System.out.println("Combien de cours sont dispencé par cette personne ?");
			mc.setNbCours(choixInt(50));
			
			System.out.println("Quel est le sujet de la prochaine conférence de cette personne");
			mc.setSujetConf(choixString());
			
			_dep.ajoutEnseignant(mc);
			break;
		case Professeur:
			Professeur p = new Professeur();
			p.setNom(nom);
			p.setPrenom(prenom);
			
			System.out.println("Quelle matière est enseignée par cette personne ?");
			p.enseigner(choixString());
			
			System.out.println("Le professeur mène-t-il une recherche actuellement ?");
			p.setCherche(choixBool());
			
			_dep.ajoutEnseignant(p);
			break;
		case PRAG:
			PRAG prag = new PRAG();
			prag.setNom(nom);
			prag.setPrenom(prenom);
			
			System.out.println("Quel est l'échelon de cette personne ?");
			prag.setEchelon(choixInt(50));
			
			System.out.println("Quelle matière est enseignée par cette personne ?");
			prag.enseigner(choixString());
			
			_dep.ajoutEnseignant(prag);
			break;
		}
	}
		
	public static void menuUFR(){
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter batiment");
		System.out.println("2. Ajouter Departement");
		
		int res = choixInt(3);
		UFR ufr = new UFR();
		
		switch (res)
		{
		case 0:
			break;
		case 1:
			ufr.ajoutBatiment(new Batiment());
			menuUFR();
			Main.universite.ajoutUFR(ufr);
			break;
		case 2:
			ufr.ajoutDepartement(new Departement());
			menuUFR();
			Main.universite.ajoutUFR(ufr);
			break;
		}
		
		
	}
	
	/*
	private void menuDepartement(UFR ufr) {
		// TODO Auto-generated method stub
		
	}

	public void menuBatiment(UFR _ufr)
	{
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter bureau");
		System.out.println("2. Ajouter salle de cours");
		System.out.println("3. Ajouter salle de TP");
		System.out.println("4. Ajouter salle de réunion");
		
		int res = choixInt(5);
		Batiment batiment = new Batiment();
		switch(res)
		{
		case 0:
			break;
		case 1:
			menuBureau(batiment);
			menuBatiment(_ufr);
			_ufr.ajoutBatiment(batiment);
			break;
		case 2:
			menuSalleCours(batiment);
			menuBatiment(_ufr);
			_ufr.ajoutBatiment(batiment);
			break;
		case 3:
			menuSalleTP(batiment);
			menuBatiment(_ufr);
			_ufr.ajoutBatiment(batiment);
			break;
		case 4:
			menuSalleReunion(batiment);
			menuBatiment(_ufr);
			_ufr.ajoutBatiment(batiment);
			break;		
		}
	}
	
	private void menuSalleReunion(Batiment _batiment) {
		System.out.println("Quel est le nom de cette salle ?");
		
		SalleReunion s = new SalleReunion(choixString());
		
		_batiment.ajoutSalle(s);	
	}

	private void menuSalleTP(Batiment _batiment) {
		System.out.println("Combien de postes sont disponibles dans cette salle ?");
		
		SalleTP s = new SalleTP(choixInt(100));
		
		_batiment.ajoutSalle(s);
	}

	private void menuSalleCours(Batiment batiment) {
		// TODO Auto-generated method stub
		
	}

	public void menuBureau(Batiment _batiment)
	{
		System.out.println("0. Quitter");
		System.out.println("1. Ajouter Chargé de recherche");
		System.out.println("2. Ajouter Maitre de Conférence");
		System.out.println("3. Ajouter Enseignant");
		System.out.println("4. Ajouter PRAG");
		
		int res = choixInt(5);
		Bureau bureau = new Bureau();
		
		switch(res)
		{
		case 0:
			break;
		case 1:
			menuPersonne(bureau, type.ChargeRecherche);
			menuBureau(_batiment);
			_batiment.ajoutSalle(bureau);
			break;
		case 2:
			menuPersonne(bureau, type.MaitreDeConf);
			menuBureau(_batiment);
			_batiment.ajoutSalle(bureau);
			break;
		case 3:
			menuPersonne(bureau, type.Professeur);
			menuBureau(_batiment);
			_batiment.ajoutSalle(bureau);
			break;
		case 4:
			menuPersonne(bureau, type.PRAG);
			menuBureau(_batiment);
			_batiment.ajoutSalle(bureau);
			break;
		}
	}
	
	public void menuPersonne(Bureau _bureau, type _type)
	{
		System.out.println("Quel est le prénom de cette personne ?");
		String nom = choixString();
		
		System.out.println("Quel est le prénom de cette personne ?");
		String prenom = choixString();
		
		switch(_type)
		{
		case ChargeRecherche:
			ChargeRecherche ch = new ChargeRecherche();
			ch.setNom(nom);
			ch.setPrenom(prenom);
			
			System.out.println("Quel est l'ancienneté de cette personne ?");
			ch.setAnciennete(choixInt(100));
			
			System.out.println("Quel est le sujet de recherche actuel de cette personne ?");
			ch.setSujetRecherche(choixString());
			_bureau.ajoutProprietaire(ch);
			break;
		case MaitreDeConf:
			MaitreDeConf mc = new MaitreDeConf();
			mc.setNom(nom);
			mc.setPrenom(prenom);
			
			System.out.println("Combien de cours sont dispencé par cette personne ?");
			mc.setNbCours(choixInt(50));
			
			System.out.println("Quel est le sujet de la prochaine conférence de cette personne");
			mc.setSujetConf(choixString());
			
			_bureau.ajoutProprietaire(mc);
			break;
		case Professeur:
			Professeur p = new Professeur();
			p.setNom(nom);
			p.setPrenom(prenom);
			
			System.out.println("Quelle matière est enseignée par cette personne ?");
			p.enseigner(choixString());
			
			System.out.println("Le professeur mène-t-il une recherche actuellement ?");
			p.setCherche(choixBool());
			
			_bureau.ajoutProprietaire(p);
			break;
		case PRAG:
			PRAG prag = new PRAG();
			prag.setNom(nom);
			prag.setPrenom(prenom);
			
			System.out.println("Quel est l'échelon de cette personne ?");
			prag.setEchelon(choixInt(50));
			
			System.out.println("Quelle matière est enseignée par cette personne ?");
			prag.enseigner(choixString());
			
			_bureau.ajoutProprietaire(prag);
			break;
		}
	}
	*/
}
