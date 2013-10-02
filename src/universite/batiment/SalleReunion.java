package universite.batiment;

import universite.annotations.MethodeToString;

public class SalleReunion extends Salle {

	private String nom;
	
	@MethodeToString(index = 1, titre = "Créer une salle de réunion.")
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
	
	@MethodeToString(index = 2, titre = "Connaitre le nom de la salle.")
	public String getNom() {
		return nom;
	}

	@MethodeToString(index = 3, titre = "Modifier le nom de la salle.")
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

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		s += "<nom>" + this.nom + "</nom>";
		s += "</" + className + ">";
		return s;
	}

}
