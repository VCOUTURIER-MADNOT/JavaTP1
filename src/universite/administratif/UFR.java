package universite.administratif;

import java.util.ArrayList;

import universite.annotations.MethodeToString;
import universite.batiment.Batiment;
import universite.interfaces.XMLSerializer;

public class UFR implements Cloneable, XMLSerializer{

	private ArrayList<Batiment> batiments;
	private ArrayList<Departement> departements;
	
	@MethodeToString(index = 1, titre = "Créer une UFR.")
	public UFR(){
		this.batiments = new ArrayList<Batiment>();
		this.departements = new ArrayList<Departement>();
	}
	
	public UFR( ArrayList<Batiment> _batiments, ArrayList <Departement> _departements)
	{
		this.batiments = _batiments;
		this.departements = _departements;
	}
	
	public UFR(UFR _ufr)
	{
		this.batiments = _ufr.batiments;
		this.departements = _ufr.departements;
	}

	@MethodeToString(index = 2, titre = "Lister les batiments de l'UFR.")
	public ArrayList<Batiment> getBatiments() {
		return this.batiments;
	}

	public void setBatiments(ArrayList<Batiment> _batiments) {
		this.batiments = _batiments;
	}

	@MethodeToString(index = 3, titre = "Lister les départements de l'UFR.")
	public ArrayList<Departement> getDepartements() {
		return this.departements;
	}

	public void setDepartements(ArrayList<Departement> _departements) {
		this.departements = _departements;
	}
	
	@MethodeToString(index = 4, titre = "Ajouter un batiment à l'UFR.")
	public void ajoutBatiment(Batiment _batiment)
	{
		this.batiments.add(_batiment);
	}
	
	@MethodeToString(index = 5, titre = "Ajouter un departement à l'UFR.")
	public void ajoutDepartement(Departement _departement)
	{
		this.departements.add(_departement);
	}
	
	@MethodeToString(index = 1, titre = "Supprimer un batiment de l'UFR.")
	public void supprBatiment(Batiment _batiment)
	{
		this.batiments.remove(_batiment);
	}
	
	@MethodeToString(index = 1, titre = "Supprimer un département de l'UFR.")
	public void supprDepartement(Departement _departement)
	{
		this.departements.remove(_departement);
	}
	
	public Object clone()
	{
		return new UFR(this);
	}

	@Override
	public String toString() {
		return super.toString() + " UFR [batiments=" + batiments + ", departements=" + departements
				+ "]";
	}

	@Override
	public String toXML() {
		String className = this.getClass().getSimpleName();
		String s = "<" + className + ">";
		for(Batiment batiment : this.batiments){
			s += batiment.toXML();
		}
		
		for(Departement dep : this.departements){
			s += dep.toXML();
		}
		
		s += "</" + className + ">";
		return s;
	}
	
	
}
