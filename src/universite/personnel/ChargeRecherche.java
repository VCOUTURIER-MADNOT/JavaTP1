package universite.personnel;

public class ChargeRecherche extends Personnel implements Chercheur{

	private int anciennete;
	private String sujetRecherche;
	
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

	public String getSujetRecherche() {
		return this.sujetRecherche;
	}

	public void setSujetRecherche(String _sujetRecherche) {
		this.sujetRecherche = _sujetRecherche;
	}
	
	public int getAnciennete() {
		return anciennete;
	}

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
	
}
