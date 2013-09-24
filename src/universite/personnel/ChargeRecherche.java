package universite.personnel;

public class ChargeRecherche extends Personnel implements Chercheur{

	private String sujetRecherche;
	
	public ChargeRecherche() {
		super();
		this.sujetRecherche = new String();
	}
	
	public ChargeRecherche(String _sujetRecherche)
	{
		super();
		this.sujetRecherche = _sujetRecherche;
	}
	
	public ChargeRecherche(ChargeRecherche _chargeRecherche)
	{
		super();
		this.sujetRecherche = _chargeRecherche.sujetRecherche;
	}

	public String getSujetRecherche() {
		return sujetRecherche;
	}

	public void setSujetRecherche(String sujetRecherche) {
		this.sujetRecherche = sujetRecherche;
	}
	
	public Object clone()
	{
		return new ChargeRecherche(this);
	}

	@Override
	public String toString() {
		return super.toString() + " ChargeRecherche [sujetRecherche=" + sujetRecherche + "]";
	}

	@Override
	public boolean chercher(String _sujet) {
		return false;
	}

	
}
