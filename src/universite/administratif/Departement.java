package universite.administratif;

import java.util.ArrayList;

import universite.annotations.MethodeToString;
import universite.interfaces.XMLSerializer;
import universite.personnel.Enseignant;

public class Departement implements XMLSerializer{

	private ArrayList<Enseignant> enseignants;
	
	@MethodeToString(index = 1, titre = "Créer un département.")
	public Departement()
	{
		this.enseignants = new ArrayList<Enseignant>();
	}
	
	//@MethodeToString(index = 1, titre = "Créer un département.")
	public Departement(ArrayList<Enseignant> _enseignants)
	{
		this.enseignants = _enseignants;
	}
	
	//@MethodeToString(index = 1, titre = "Créer un département.")
	public Departement(Departement _departement)
	{
		this.enseignants = _departement.enseignants;
	}

	@MethodeToString(index = 2, titre = "Lister les enseignants du département.")
	public ArrayList<Enseignant> getEnseignants() {
		return this.enseignants;
	}

	//@MethodeToString(index = 1, titre = "Créer un département.")
	public void setEnseignants(ArrayList<Enseignant> _enseignants) {
		this.enseignants = _enseignants;
	}
	
	@MethodeToString(index = 3, titre = "Ajouter un enseignant au département.")
	public void ajoutEnseignant(Enseignant _enseignant)
	{
		this.enseignants.add(_enseignant);
	}
	
	@MethodeToString(index = 4, titre = "Supprimer un enseignant du département.")
	public void supprEnseignant(Enseignant _enseignant)
	{
		this.enseignants.remove(_enseignant);
	}
	
	public Object clone()
	{
		return new Departement(this);
	}

	@Override
	public String toString() {
		return super.toString() + " Departement [enseignants=" + enseignants + "]";
	}

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		
		for(Enseignant enseignant: this.enseignants){
			s += enseignant.toXML();
		}
		
		s += "</" + className + ">";
		return s;
	}
	
	
}
