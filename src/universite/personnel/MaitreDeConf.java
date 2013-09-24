package universite.personnel;

public class MaitreDeConf extends Personnel implements Enseignant, Chercheur{

	private int nbConf;

	public MaitreDeConf(){
		super();
		this.nbConf = 0;
	}
	
	public MaitreDeConf(int _nbConf)
	{
		super();
		this.nbConf = _nbConf;
	}
	
	public MaitreDeConf(MaitreDeConf _maitreDeConf)
	{
		super();
		this.nbConf = _maitreDeConf.nbConf;
	}
	
	public int getNbConf() {
		return nbConf;
	}

	public void setNbConf(int nbConf) {
		this.nbConf = nbConf;
	}
	
	public void ajouteConf()
	{
		this.nbConf+=1;
	}
	
	public Object clone()
	{
		return new MaitreDeConf(this);
	}

	@Override
	public String toString() {
		return super.toString() + " MaitreDeConf [nbConf=" + nbConf + "]";
	}

	@Override
	public void enseigner(String _matiere) {
		this.nbConf++;
	}

	@Override
	public boolean chercher(String _sujet) {
		return true;
	}
	
}
