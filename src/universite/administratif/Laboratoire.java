package universite.administratif;

import java.util.ArrayList;

import universite.annotations.MethodeToString;
import universite.interfaces.XMLSerializer;
import universite.personnel.Chercheur;

public class Laboratoire implements Cloneable, XMLSerializer{

	private ArrayList<Chercheur> chercheurs;
	
	@MethodeToString(index = 1, titre = "Créer un laboratoire.")
	public Laboratoire(){
		this.chercheurs = new ArrayList<Chercheur>();
	}
	
	//@MethodeToString(index = 1, titre = "Créer un département.")
	public Laboratoire(ArrayList<Chercheur> _chercheurs){
		this.chercheurs = _chercheurs;
	}
	
	//@MethodeToString(index = 1, titre = "Créer un département.")
	public Laboratoire(Laboratoire _laboratoire){
		this.chercheurs = _laboratoire.chercheurs;
	}

	@MethodeToString(index = 2, titre = "Lister les chercheurs du laboratoire.")
	public ArrayList<Chercheur> getChercheurs() {
		return this.chercheurs;
	}

	public void setChercheurs(ArrayList<Chercheur> _chercheurs) {
		this.chercheurs = _chercheurs;
	}
	
	@MethodeToString(index = 3, titre = "Ajouter un chercheur au laboratoire.")
	public void ajouteChercheur(Chercheur _chercheur)
	{
		this.chercheurs.add(_chercheur);
	}
	
	@MethodeToString(index = 4, titre = "Supprimer un chercheur du laboratoire.")
	public void supprChercheur(Chercheur _chercheur){
		this.chercheurs.remove(_chercheur);
	}
	
	public Object clone()
	{
		return new Laboratoire(this);
	}

	@Override
	public String toString() {
		return super.toString() + " Laboratoire [chercheurs=" + chercheurs + "]";
	}

	@Override
	public String toXML() {
		String className = this.getClass().getSimpleName();
		String s = "<" + className + ">";
		
		for(Chercheur chercheur : this.chercheurs){
			s += chercheur.toXML();
		}
		
		s += "</" + className + ">";
		return s;
	}
	
}
