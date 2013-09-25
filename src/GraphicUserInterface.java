import java.util.Scanner;

import universite.batiment.Bureau;
import universite.batiment.Salle;
import universite.batiment.SalleCours;
import universite.batiment.SalleReunion;
import universite.personnel.Personnel;


public class GraphicUserInterface {

	
	private static Scanner  sc   = new Scanner(System.in);
	private static String[] menu = new String[]{"Ajouter un batiment", "Ajouter une personne"};
	private static String[] typeSalle = new String[]{"Bureau", "Salle de cours", "Salle de réunion", "Salle de TP"};
	private static String[] typePersonnel = new String[]{"Charge de recherche", "Maitre de conférence", "PRAG", "Professeur"};
	
	private static int choix(){
		Integer selectionRetour = null;
		while(selectionRetour == null)
		{
			System.out.print("\nChoix: ");
			try {
				selectionRetour = sc.nextInt();
			}
			catch(Exception e){ sc.next(); }
		}
		
		return selectionRetour;
	}
	
	private static int selectionMenu()
	{		
		System.out.println("Programme de gestion d'une université.");
		for(int i=0; i < menu.length; i++){
			System.out.println(i+1 + ". " +menu[i]);
		}
		System.out.println("0. Quitter le programme");
		
		return choix();
	}
	
	private static int creationBatiment()
	{
		System.out.println("Combien de salle voulez-vous dans le batiment ?");
		int nbSalles = choix();
		
		for (int i = 0; i <= nbSalles; i++)
		{
			creationSalle();
		}
	}
	
	private static Salle creationSalle(){
		int typeSalle = selectionTypeSalle();
		Salle salle;
		switch(typeSalle){
		case 0:
			salle = creationBureau();
			break;
		case 1:
			salle = creationSalleCours();
			break;
		case 2:
			salle = creationSalleReunion();
			break;
		case 3:
			salle = creationSalleTP();
			break;
		default:
			break;
		}
		
		return salle;
		
	}
	
	private static Bureau creationBureau(){
		Bureau bureau = new Bureau();
		int nbPersonne = 0;
		System.out.println("Combien de personne travaillent dans ce bureau ?");
		while(nbPersonne == 0)
		{
			nbPersonne = choix();
		}
		for (int i = 0 ; i < nbPersonne; i++)
		{
			System.out.println("Qui travaille dans le bureau ?");
			bureau.ajoutProprietaire(creationPersonnel());
		}
		
		return bureau;
	}
	
	private static SalleCours creationSalleCours(){
		SalleCours salleCours = new SalleCours();
		int nbPersonne = 0;
		System.out.println("Combien de personnes peuvent être dans cette salle ?");
		while(nbPersonne == 0)
		{
			nbPersonne = choix();
		}
		
		salleCours.setNbPlaces(nbPersonne);
		return salleCours;	
	}
	
	private static Bureau creationBureau(){
		SalleReunion salle = new SalleReunion();
		System.out.println("Quel est le nom de la salle de réunion ?");
		salle.setNom(sc.next());
		
		return salle;
	}
	
	private static Personnel creationPersonnel(){
		int type = choixTypePersonnel();
		Personnel p;
		
		switch(type){
		case 0:
			p = creationChargeRecherche();
			break;
		case 1:
			p = creationMaitreConf();
			break;
		case 2:
			p = creationPrag();
			break;
		case 3:
			p = creationProfesseur();
			break;
		}
		
		System.out.println("Entrez le prenom de la personne :");
		p.setPrenom(sc.next());
		System.out.println("Entrez le nom de la personne :");
		p.setNom(sc.next());
		
		return p;
	}
	
	private static int choixTypePersonnel(){
		int choixType=-1;
		System.out.println("Quel est le type du personnel ?");
		for(int i=0; i < typePersonnel.length; i++){
			System.out.println(i+1 + ". " +typePersonnel[i]);
		}
		while (choixType <= 0 || choixType > typePersonnel.length-1){
			choixType = choix();
		}
		return choixType;
	}
	
	private static int selectionTypeSalle(){
		int choixType=-1;
		System.out.println("Quel sera le type de la salle ?");
		for(int i=0; i < typeSalle.length; i++){
			System.out.println(i+1 + ". " +typeSalle[i]);
		}
		
		while (choixType <= 0 || choixType > typeSalle.length-1){
			choixType = choix();
		}
		return choixType;
	}
	
	public static void run(){
		
		int selectionCourante = 0;
		
		while( (selectionCourante = selectionMenu()) != 0)
		{
			
		}
		
		
	}
	
	
}
