package universite.administratif;

import java.util.ArrayList;

import universite.batiment.Batiment;

public class UFR implements Cloneable {

	private ArrayList<Batiment> batiments;
	private ArrayList<Departement> departements;
	
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

	public ArrayList<Batiment> getBatiments() {
		return this.batiments;
	}

	public void setBatiments(ArrayList<Batiment> _batiments) {
		this.batiments = _batiments;
	}

	public ArrayList<Departement> getDepartements() {
		return this.departements;
	}

	public void setDepartements(ArrayList<Departement> _departements) {
		this.departements = _departements;
	}
	
	public void ajoutBatiment(Batiment _batiment)
	{
		this.batiments.add(_batiment);
	}
	
	public void ajoutDepartement(Departement _departement)
	{
		this.departements.add(_departement);
	}
	
	public void supprBatiment(Batiment _batiment)
	{
		this.batiments.remove(_batiment);
	}
	
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
	
	
}
