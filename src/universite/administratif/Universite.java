package universite.administratif;

import java.util.ArrayList;

import universite.annotations.MethodeToString;
import universite.interfaces.XMLSerializer;

public class Universite implements XMLSerializer{

	private ArrayList<UFR> ufrs;
	private ArrayList<Laboratoire> laboratoires;
	private ArrayList<Departement> departements;
 	
	@MethodeToString(index = 1, titre = "Cr�er une universit�.")
	public Universite()
	{
		this.ufrs = new ArrayList<UFR>();
		this.laboratoires = new ArrayList<Laboratoire>();
		this.departements = new ArrayList<Departement>();
	}

	public Universite(ArrayList<UFR> _ufrs, ArrayList<Laboratoire> _laboratoires, ArrayList<Departement> _departements) {
		this.ufrs = _ufrs;
		this.laboratoires = _laboratoires;
		this.departements = _departements;
	}
	
	public Universite(Universite _universite)
	{
		this.ufrs = _universite.ufrs;
		this.laboratoires = _universite.laboratoires;
		this.departements = _universite.departements;
	}

	@MethodeToString(index = 2, titre = "Lister les UFR de l'universit�.")
	public ArrayList<UFR> getUfrs() {
		return this.ufrs;
	}

	public void setUfrs(ArrayList<UFR> _ufrs) {
		this.ufrs = _ufrs;
	}

	@MethodeToString(index = 3, titre = "Lister les laboratoires de l'universit�.")
	public ArrayList<Laboratoire> getLaboratoires() {
		return this.laboratoires;
	}

	public void setLaboratoires(ArrayList<Laboratoire> _laboratoires) {
		this.laboratoires = _laboratoires;
	}

	@MethodeToString(index = 4, titre = "Lister les departements de l'universit�.")
	public ArrayList<Departement> getDepartements() {
		return this.departements;
	}
	
	public void setDepartements(ArrayList<Departement> _departements) {
		this.departements = _departements;
	}
	
	@MethodeToString(index = 5, titre = "Ajouter une UFR � l'universit�.")
	public void ajoutUFR(UFR _ufr){
		this.ufrs.add(_ufr);
	}
	
	@MethodeToString(index = 6, titre = "Ajouter un laboratoire � l'universit�.")
	public void ajoutLaboratoire(Laboratoire _laboratoire){
		this.laboratoires.add(_laboratoire);
	}
	
	@MethodeToString(index = 7, titre = "Ajotuer un d�partement � l'universit�.")
	public void ajoutDepartement(Departement _departement){
		this.departements.add(_departement);
	}
	
	@MethodeToString(index = 8, titre = "Supprimer une UFR de l'universit�.")
	public void supprUFR(UFR _ufr){
		this.ufrs.remove(_ufr);
	}
	
	@MethodeToString(index = 9, titre = "Supprimer un laboratoire de l'universit�.")
	public void supprLaboratoire(Laboratoire _laboratoire){
		this.laboratoires.remove(_laboratoire);
	}
	
	@MethodeToString(index = 10, titre = "Supprimer un d�partement de l'universit�.")
	public void supprDepartement(Departement _departement){
		this.departements.remove(_departement);
	}

	public void supprUFR(int _num){
		this.ufrs.remove(_num);
	}
	
	public void supprLaboratoire(int _num){
		this.laboratoires.remove(_num);
	}
	
	public void supprDepartement(int _num){
		this.departements.remove(_num);
	}
	
	public Object clone()
	{
		return new Universite(this);
	}
	
	public String toXML(){
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		for(UFR ufr : this.ufrs){
			s += ufr.toXML();
		}
		
		for(Laboratoire labo : this.laboratoires){
			s += labo.toXML();
		}
		
		for(Departement dep : this.departements){
			s += dep.toXML();
		}
		
		s += "</" + className + ">";
		return s;
	}
	
	@Override
	public String toString() {
		return "Universite [ufrs=" + ufrs + ", laboratoires=" + laboratoires
				+ ", departements=" + departements + "]";
	}
	
}