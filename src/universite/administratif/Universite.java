package universite.administratif;

import java.util.ArrayList;

public class Universite implements Cloneable {

	private ArrayList<UFR> ufrs;
	private ArrayList<Laboratoire> laboratoires;
	private ArrayList<Departement> departements;
 	
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

	public ArrayList<UFR> getUfrs() {
		return this.ufrs;
	}

	public void setUfrs(ArrayList<UFR> _ufrs) {
		this.ufrs = _ufrs;
	}

	public ArrayList<Laboratoire> getLaboratoires() {
		return this.laboratoires;
	}

	public void setLaboratoires(ArrayList<Laboratoire> _laboratoires) {
		this.laboratoires = _laboratoires;
	}

	public ArrayList<Departement> getDepartements() {
		return this.departements;
	}
	
	public void setDepartements(ArrayList<Departement> _departements) {
		this.departements = _departements;
	}
	
	public void ajoutUFR(UFR _ufr){
		this.ufrs.add(_ufr);
	}
	
	public void ajoutLaboratoire(Laboratoire _laboratoire){
		this.laboratoires.add(_laboratoire);
	}
	
	public void ajoutDepartement(Departement _departement){
		this.departements.add(_departement);
	}
	
	public void supprUFR(UFR _ufr){
		this.ufrs.remove(_ufr);
	}
	
	public void supprLaboratoire(Laboratoire _laboratoire){
		this.laboratoires.remove(_laboratoire);
	}
	
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
	
	@Override
	public String toString() {
		return "Universite [ufrs=" + ufrs + ", laboratoires=" + laboratoires
				+ ", departements=" + departements + "]";
	}
	
}