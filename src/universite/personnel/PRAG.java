package universite.personnel;

public class PRAG extends Personnel implements Enseignant, Cloneable {
	
	private int echelon;
	
	public PRAG(){
		super();
		this.echelon = 0;
	}
	
	public PRAG(int _echelon){
		super();
		this.echelon = _echelon;
	}
	
	public PRAG(PRAG _prag){
		super();
		this.echelon = _prag.echelon;
	}

	public int getEchelon() {
		return echelon;
	}

	public void setEchelon(int echelon) {
		this.echelon = echelon;
	}

	public Object clone(){
		return new PRAG(this);
	}

	@Override
	public String toString() {
		return super.toString() + " PRAG [echelon=" + echelon + "]";
	}

	@Override
	public void enseigner(String _matiere) {
		this.echelon++;
	}
	
	
}
