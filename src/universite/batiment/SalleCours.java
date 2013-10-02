package universite.batiment;

import universite.administratif.Departement;
import universite.administratif.Laboratoire;
import universite.administratif.UFR;
import universite.annotations.MethodeToString;

public class SalleCours extends Salle {
	
	private int nbPlaces;

	@MethodeToString(index = 1, titre = "Créer une salle de cours.")
	public SalleCours()
	{
		super();
		this.nbPlaces = 0;
	}
	
	public SalleCours(int _nbPlaces)
	{
		super();
		this.nbPlaces = _nbPlaces;
	}
	
	public SalleCours(SalleCours _salleCours)
	{
		super();
		this.nbPlaces = _salleCours.nbPlaces;
	}
	
	@MethodeToString(index = 2, titre = "Connaitre le nombre de places disponibles dans cette salle.")
	public int getNbPlaces() {
		return nbPlaces;
	}

	@MethodeToString(index = 3, titre = "Modifier le nombre de places dans la salle.")
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = (nbPlaces > 0 ? nbPlaces : 0);
	}

	@Override
	public String toString() {
		return super.toString() + " SalleCours [nbPlaces=" + nbPlaces + "]";
	}

	@Override
	public Object clone() {
		return new SalleCours(this);
	}

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		s += "<nbPlaces>" + this.nbPlaces + "</nbPlaces>";
		s += "</" + className + ">";
		return s;
	}
	
	
	
}
