package universite.personnel;

import universite.annotations.MethodeToString;

public class ChargeRecherche extends Personnel implements Cloneable, Chercheur{

	private int anciennete;
	private String sujetRecherche;
	
	@MethodeToString(index = 1, titre = "Créer un chargé de recherche.")
	public ChargeRecherche() {
		super();
		this.anciennete = 0;
		this.sujetRecherche = new String();
	}
	
	public ChargeRecherche(int _anciennete, String _sujetRecherche)
	{
		super();
		this.anciennete = _anciennete;
		this.sujetRecherche = _sujetRecherche;
	}
	
	public ChargeRecherche(ChargeRecherche _chargeRecherche)
	{
		super();
		this.anciennete = _chargeRecherche.anciennete;
		this.sujetRecherche = _chargeRecherche.sujetRecherche;
	}

	@MethodeToString(index = 2, titre = "Connaitre le sujet actuel de la recherche du personnel.")
	public String getSujetRecherche() {
		return this.sujetRecherche;
	}

	@MethodeToString(index = 3, titre = "Modifier le sujet actuel de la recherche du personnel.")
	public void setSujetRecherche(String _sujetRecherche) {
		this.sujetRecherche = _sujetRecherche;
	}
	
	@MethodeToString(index = 4, titre = "Connaitre l'ancienneté du chargé de recherche.")
	public int getAnciennete() {
		return anciennete;
	}

	@MethodeToString(index = 5, titre = "Modifier l'ancienneté du chargé de recherche.")
	public void setAnciennete(int _anciennete) {
		this.anciennete = (_anciennete >= 0) ? _anciennete : 0;
	}
	
	public Object clone()
	{
		return new ChargeRecherche(this);
	}


	@Override
	public String toString() {
		return super.toString() + " ChargeRecherche [anciennete=" + anciennete
				+ ", sujetRecherche=" + sujetRecherche + "]";
	}

	@Override
	public boolean chercher(String _sujet) {
		this.sujetRecherche = _sujet;
		return true;
	}

	@Override
	public String toXML() {
		String className = this.getClass().getSimpleName();
		String s = "<" + className + ">";
		s += "<anciennete>" + this.anciennete + "</anciennete>";
		s += "<sujetRecherche>" + this.sujetRecherche + "</sujetRecherche";
		s += "</" + className + ">";
		return s;
	}
	
}
