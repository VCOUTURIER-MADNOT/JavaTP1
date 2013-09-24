package universite.batiment;

public class SalleReunion extends Salle {

	private String nom;
	
	public SalleReunion() {
		super();
		this.nom = new String();
	}
	
	public SalleReunion(String _nom){
		super();
		this.nom = _nom;
	}
	
	public SalleReunion(SalleReunion _salle){
		super();
		this.nom = _salle.nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return super.toString() + " SalleReunion [nom=" + nom + "]";
	}
	
	public Object clone(){
		return new SalleReunion(this);
	}

}
