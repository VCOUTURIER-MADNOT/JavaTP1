package universite.batiment;

import java.util.ArrayList;

public class Batiment implements Cloneable{

	private static int 		 currentId = 0;
	private int 			 id;
	private ArrayList<Salle> salles;
	
	public Batiment()
	{
		this.id = Batiment.currentId++;
		this.salles = new ArrayList<Salle>();
	}
	
	public Batiment(ArrayList<Salle> _salles)	{
		this.id = Batiment.currentId++;
		this.salles = (ArrayList<Salle>)_salles.clone();
	}

	public Batiment(Batiment _batiment)	{
		this.id = Batiment.currentId++;
		this.salles = (ArrayList<Salle>)_batiment.salles.clone();
	}

	public ArrayList<Salle> getSalles() {
		return (ArrayList<Salle>)this.salles.clone();
	}

	public void setSalles(ArrayList<Salle> _salles) {
		this.salles = (ArrayList<Salle>)_salles.clone();
	}

	public void ajoutSalle(Salle _salle){
		this.salles.add(_salle);
	}
	
	public void supprSalle(Salle _salle){
		this.salles.remove(_salle);
	}
	
	public void supprSalle(int _num){
		this.salles.remove(_num);
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Batiment [id=" + id + ", salles=" + salles + "]";
	}
	
	public Object clone() {
		return new Batiment(this);
	}
	
}
