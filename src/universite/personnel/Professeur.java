package universite.personnel;

public class Professeur extends Personnel implements Enseignant, Chercheur{

	private int nbHeures;
	
	public Professeur() {
		super();
		this.nbHeures = 0;
	}
	
	public Professeur(int _nbHeures){
		super();
		this.nbHeures = _nbHeures;
	}
	
	public Professeur(Professeur _p){
		super();
		this.nbHeures = _p.nbHeures;
	}

	public int getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}
	
	public Object clone(){
		return new Professeur(this);
	}

	@Override
	public String toString() {
		return super.toString() + " Professeur [nbHeures=" + nbHeures + "]";
	}

	@Override
	public void enseigner(String _matiere) {
		this.nbHeures += 10;
	}

	@Override
	public boolean chercher(String _sujet) {
		return true;
	}	
	

}
