package universite.personnel;

import java.util.ArrayList;

public class Professeur extends Personnel implements Enseignant, Chercheur{

	private ArrayList<String> matieres;
	private boolean cherche;
	
	public Professeur() {
		super();
		this.matieres = new ArrayList<String>();
		this.cherche = false;
	}
	
	public Professeur(ArrayList<String> _matieres, boolean _cherche){
		super();
		this.matieres = _matieres;
		this.cherche = _cherche;
	}
	
	public Professeur(Professeur _p){
		super();
		this.matieres = (ArrayList<String>) _p.matieres.clone();
		this.cherche = _p.cherche;
	}
	
	public ArrayList<String> getMatieres() {
		return matieres;
	}

	public void setMatieres(ArrayList<String> _matieres) {
		this.matieres = _matieres;
	}

	public boolean isCherche() {
		return cherche;
	}

	public void setCherche(boolean cherche) {
		this.cherche = cherche;
	}

	public void supprMatiere(String _matiere)
	{
		this.matieres.remove(_matiere);
	}
	
	public void supprMatiere(int _index)
	{
		this.matieres.remove(_index);
	}
	
	public Object clone(){
		return new Professeur(this);
	}

	@Override
	public String toString() {
		return super.toString() + " Professeur [matieres=" + matieres + ", cherche=" + cherche
				+ "]";
	}

	@Override
	public void enseigner(String _matiere) {
		this.matieres.add(_matiere);
	}

	@Override
	public boolean chercher(String _sujet) {
		this.cherche = !_sujet.equals("");
		return true;
	}	
	

}
