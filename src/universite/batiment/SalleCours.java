package universite.batiment;

public class SalleCours extends Salle {
	
	private int nbPlaces;

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
	
	public int getNbPlaces() {
		return nbPlaces;
	}

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
	
	
	
}
