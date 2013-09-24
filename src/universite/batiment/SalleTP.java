package universite.batiment;

public class SalleTP extends Salle {

	private int nbPostes;
	
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
	
	public int getNbPostes() {
		return this.nbPostes;
	}

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
	
}
