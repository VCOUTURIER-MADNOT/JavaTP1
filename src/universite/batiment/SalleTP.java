package universite.batiment;

import universite.annotations.MethodeToString;

public class SalleTP extends Salle implements Cloneable {

	private int nbPostes;
	
	@MethodeToString(index = 1, titre = "Créer une salle de TP.")
	public SalleTP() {
		super();
		this.nbPostes = 0;
	}

	public SalleTP(int _nbPostes) {
		super();
		this.nbPostes = _nbPostes;
	}

	public SalleTP(SalleTP _salleTP)
	{
		super();
		this.nbPostes = _salleTP.nbPostes;
	}
	
	@MethodeToString(index = 2, titre = "Connaitre le nombre de postes disponibles dans la salle de TP.")
	public int getNbPostes() {
		return this.nbPostes;
	}

	@MethodeToString(index = 3, titre = "Modifier le nombre de postes disponible dans la salle de TP.")
	public void setNbPostes(int nbPostes) {
		this.nbPostes = nbPostes;
	}

	@Override
	public String toString() {
		return super.toString() + " SalleTP [nbPostes=" + nbPostes + "]";
	}
	
	public Object clone(){
		return new SalleTP(this);
	}

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		s += "<nbPostes>" + this.nbPostes + "</nbPostes>";
		s += "</" + className + ">";
		return s;
	}
	
}
