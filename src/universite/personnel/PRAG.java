package universite.personnel;

import universite.annotations.MethodeToString;

public class PRAG extends Personnel implements Enseignant{
	
	private int echelon;
	
	@MethodeToString(index = 1, titre = "Créer un professeur agregé (PRAG).")
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

	@MethodeToString(index = 2, titre = "Connaitre l'echelon du PRAG.")
	public int getEchelon() {
		return echelon;
	}

	@MethodeToString(index = 3, titre = "Modifier l'echelon du PRAG.")
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

	@Override
	public String toXML() {
		String className = this.getClass().toString();
		String s = "<" + className + ">";
		s += "<echelon>" + this.echelon + "</echelon>";
		s += "</" + className + ">";
		return s;
	}
	
	
}
