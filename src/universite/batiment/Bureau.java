package universite.batiment;

import java.util.ArrayList;

import universite.administratif.Departement;
import universite.administratif.Laboratoire;
import universite.administratif.UFR;
import universite.annotations.MethodeToString;
import universite.interfaces.XMLSerializer;
import universite.personnel.Personnel;

public class Bureau extends Salle implements Cloneable {

	private ArrayList<Personnel> proprietaire;
	
	@MethodeToString(index = 1, titre = "Créer un bureau.")
	public Bureau() {
		super();
		this.proprietaire = new ArrayList<Personnel>();
	}
	
	public Bureau(ArrayList<Personnel> _p){
		super();
		this.proprietaire = (ArrayList<Personnel>)_p.clone();
	}
	
	public Bureau(Bureau _b){
		super();
		this.proprietaire = (ArrayList<Personnel>)_b.proprietaire.clone();
	}

	@MethodeToString(index = 2, titre = "Lister les personnels travaillant dans ce bureau.")
	public ArrayList<Personnel> getProprietaire() {
		return (ArrayList<Personnel>)proprietaire.clone();
	}

	public void setProprietaire(ArrayList<Personnel> _p) {
		this.proprietaire = (ArrayList<Personnel>)_p.clone();
	}

	@MethodeToString(index = 3, titre = "Ajouter une personne dans le bureau.")
	public void ajoutProprietaire(Personnel _p){
		this.proprietaire.add(_p);
	}
	
	@MethodeToString(index = 4, titre = "Supprimer une personne du bureau.")
	public void supprProprietaire(Personnel _p){
		this.proprietaire.remove(_p);
	}
	
	public void supprProprietaire(int _num){
		this.proprietaire.remove(_num);
	}
	
	@Override
	public String toString() {
		return super.toString() + " Bureau [proprietaire=" + proprietaire + "]";
	}

	@Override
	public Object clone() {
		return new Bureau(this);
	}

	@Override
	public String toXML() {
		String className = this.getClass().getSimpleName();
		String s = "<" + className + ">";
		s += super.toXML();
		for(Personnel personnel : this.proprietaire){
			s += personnel.toXML();
		}
		
		s += "</" + className + ">";
		return s;
	}
}
