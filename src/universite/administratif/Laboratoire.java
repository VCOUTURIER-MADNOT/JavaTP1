package universite.administratif;

import java.util.ArrayList;

import universite.personnel.Chercheur;

public class Laboratoire implements Cloneable {

	private ArrayList<Chercheur> chercheurs;
	
	public Laboratoire(){
		this.chercheurs = new ArrayList<Chercheur>();
	}
	
	public Laboratoire(ArrayList<Chercheur> _chercheurs){
		this.chercheurs = _chercheurs;
	}
	
	public Laboratoire(Laboratoire _laboratoire){
		this.chercheurs = _laboratoire.chercheurs;
	}

	public ArrayList<Chercheur> getChercheurs() {
		return this.chercheurs;
	}

	public void setChercheurs(ArrayList<Chercheur> _chercheurs) {
		this.chercheurs = _chercheurs;
	}
	
	public void ajouteChercheur(Chercheur _chercheur)
	{
		this.chercheurs.add(_chercheur);
	}
	
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
	
}
