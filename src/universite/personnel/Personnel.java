package universite.personnel;

public abstract class Personnel {
	
	private static int currentId = 0;
	private int id;
	private String nom;
	private String prenom;
	
	public Personnel(){
		this.id = Personnel.currentId++;
		this.nom = new String();
		this.prenom = new String();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String _nom) {
		this.nom = _nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String _prenom) {
		this.prenom = _prenom;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Personnel [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}

	public abstract Object clone();
	
}
