package universite.administratif;

import java.util.ArrayList;

import universite.personnel.Enseignant;

public class Departement {

	private ArrayList<Enseignant> enseignants;
	
	public Departement()
	{
		this.enseignants = new ArrayList<Enseignant>();
	}
	
	public Departement(ArrayList<Enseignant> _enseignants)
	{
		this.enseignants = _enseignants;
	}
	
	public Departement(Departement _departement)
	{
		this.enseignants = _departement.enseignants;
	}

	public ArrayList<Enseignant> getEnseignants() {
		return this.enseignants;
	}

	public void setEnseignants(ArrayList<Enseignant> _enseignants) {
		this.enseignants = _enseignants;
	}
	
	public void ajoutEnseignant(Enseignant _enseignant)
	{
		this.enseignants.add(_enseignant);
	}
	
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
	
	
}
