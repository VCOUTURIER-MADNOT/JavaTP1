package universite.batiment;

import java.util.ArrayList;

import universite.administratif.Departement;
import universite.administratif.Laboratoire;
import universite.administratif.UFR;
import universite.annotations.MethodeToString;
import universite.interfaces.XMLSerializer;

public class Batiment implements Cloneable, XMLSerializer{

	private static int 		 currentId = 0;
	private int 			 id;
	private ArrayList<Salle> salles;
	
	@MethodeToString(index = 1, titre = "Créer un batiment.")
	public Batiment()
	{
		this.id = Batiment.currentId++;
		this.salles = new ArrayList<Salle>();
	}
	
	public Batiment(ArrayList<Salle> _salles)	{
		this.id = Batiment.currentId++;
		this.salles = (ArrayList<Salle>)_salles.clone();
	}

	public Batiment(Batiment _batiment)	{
		this.id = Batiment.currentId++;
		this.salles = (ArrayList<Salle>)_batiment.salles.clone();
	}

	@MethodeToString(index = 2, titre = "Lister les salles du batiment.")
	public ArrayList<Salle> getSalles() {
		return (ArrayList<Salle>)this.salles.clone();
	}

	public void setSalles(ArrayList<Salle> _salles) {
		this.salles = (ArrayList<Salle>)_salles.clone();
	}

	@MethodeToString(index = 3, titre = "Ajouter une salle au batiment.")
	public void ajoutSalle(Salle _salle){
		this.salles.add(_salle);
	}
	
	@MethodeToString(index = 4, titre = "Supprimer une salle du batiment.")
	public void supprSalle(Salle _salle){
		this.salles.remove(_salle);
	}
	
	public void supprSalle(int _num){
		this.salles.remove(_num);
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Batiment [id=" + id + ", salles=" + salles + "]";
	}
	
	public Object clone() {
		return new Batiment(this);
	}

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		s += "<id>" + this.id + "</id>";
		for(Salle salle : this.salles){
			s += salle.toXML();
		}
		
		s += "</" + className + ">";
		return s;
	}
	
}
