package universite.personnel;

import java.util.ArrayList;

import universite.annotations.MethodeToString;

public class Professeur extends Personnel implements Cloneable, Enseignant, Chercheur{

	private ArrayList<String> matieres;
	private boolean cherche;
	
	@MethodeToString(index = 1, titre = "Créer un professeur.")
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
	
	@MethodeToString(index = 2, titre = "Lister les matières enseignées par le professeur.")
	public ArrayList<String> getMatieres() {
		return matieres;
	}

	public void setMatieres(ArrayList<String> _matieres) {
		this.matieres = _matieres;
	}

	@MethodeToString(index = 3, titre = "Savoir si le professeur est entrain de réaliser une recherche.")
	public boolean isCherche() {
		return cherche;
	}

	@MethodeToString(index = 4, titre = "Modifier l'état de recherche du professeur.")
	public void setCherche(boolean cherche) {
		this.cherche = cherche;
	}

	@MethodeToString(index = 5, titre = "Supprimer une matière enseignée par le professeur.")
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

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		for (String matiere : this.matieres)
		{
			s += "<matiere>" + matiere + "</matiere>";
		}
		
		s += "<cherche>" + (this.cherche ? "oui" : "non") + "</cherche>";
		s += "</" + className + ">";
		return s;
	}	
	

}
