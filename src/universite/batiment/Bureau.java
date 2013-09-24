package universite.batiment;

import java.util.ArrayList;

import universite.personnel.Personnel;

public class Bureau extends Salle {

	private ArrayList<Personnel> proprietaire;
	
	public Bureau() {
		super();
		this.proprietaire = new ArrayList<Personnel>();
	}
	
	public Bureau(ArrayList<Personnel> _p){
		super();
		this.proprietaire = (ArrayList<Personnel>)_p.clone();
	}
	
	public Bureau(Bureau _b){
		super();
		this.proprietaire = (ArrayList<Personnel>)_b.proprietaire.clone();
	}

	public ArrayList<Personnel> getProprietaire() {
		return (ArrayList<Personnel>)proprietaire.clone();
	}

	public void setProprietaire(ArrayList<Personnel> _p) {
		this.proprietaire = (ArrayList<Personnel>)_p.clone();
	}

	public void ajoutProprietaire(Personnel _p){
		this.proprietaire.add(_p);
	}
	
	public void supprProprietaire(Personnel _p){
		this.proprietaire.remove(_p);
	}
	
	public void supprProprietaire(int _num){
		this.proprietaire.remove(_num);
	}
	
	@Override
	public String toString() {
		return super.toString() + " Bureau [proprietaire=" + proprietaire + "]";
	}

	@Override
	public Object clone() {
		return new Bureau(this);
	}
}
