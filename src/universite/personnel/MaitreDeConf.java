package universite.personnel;

public class MaitreDeConf extends Personnel implements Enseignant, Chercheur, Cloneable {

	private String sujetConf;
	private int nbCours;

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
	
	public int getNbCours() {
		return nbCours;
	}

	public void setNbCours(int _nbCours) {
		this.nbCours = (_nbCours >= 0) ? _nbCours : 0;
	}
	
	public String getSujetConf() {
		return sujetConf;
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
	
}
