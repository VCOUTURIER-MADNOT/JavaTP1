package universite.personnel;

import universite.annotations.MethodeToString;

public class MaitreDeConf extends Personnel implements Cloneable, Enseignant, Chercheur{

	private String sujetConf;
	private int nbCours;

	@MethodeToString(index = 1, titre = "Créer un maitre de conférence.")
	public MaitreDeConf(){
		super();
		this.nbCours = 0;
		this.sujetConf = new String();
	}
	
	public MaitreDeConf(int _nbCours, String _sujetConf)
	{
		super();
		this.nbCours = _nbCours;
		this.sujetConf = _sujetConf;
		
	}
	
	public MaitreDeConf(MaitreDeConf _maitreDeConf)
	{
		super();
		this.nbCours = _maitreDeConf.nbCours;
		this.sujetConf = _maitreDeConf.sujetConf;
	}
	
	@MethodeToString(index = 2, titre = "Connaitre le nombre de cours que le maitre de conférence effectue.")
	public int getNbCours() {
		return nbCours;
	}

	@MethodeToString(index = 3, titre = "Modifier le nombre de cours que le maitre de conférence effectue.")
	public void setNbCours(int _nbCours) {
		this.nbCours = (_nbCours >= 0) ? _nbCours : 0;
	}
	
	@MethodeToString(index = 4, titre = "Connaitre le sujet de conférence du maitre de conférence.")
	public String getSujetConf() {
		return sujetConf;
	}
	
	@MethodeToString(index = 5, titre = "Modifier le sujet de conférence du maitre de conférence.")
	public void setSujetConf(String _sujetConf)
	{
		this.sujetConf = _sujetConf;
	}
	
	public Object clone()
	{
		return new MaitreDeConf(this);
	}

	@Override
	public String toString() {
		return super.toString() + " MaitreDeConf [sujetConf=" + sujetConf + ", nbCours=" + nbCours
				+ "]";
	}

	@Override
	public void enseigner(String _matiere) {
		this.nbCours++;
	}

	@Override
	public boolean chercher(String _sujet) {
		this.sujetConf = _sujet;
		return true;
	}

	@Override
	public String toXML() {
		String className = this.getClass().getSimpleName();
		String s = "<" + className + ">";
		s += super.toXML();
		s += "<sujetConf>" + this.sujetConf + "</sujetConf>";
		s += "<nbCours>" + this.nbCours + "</nbCours>";
		s += "</" + className + ">";
		return s;
	}
	
}
