package universite.batiment;

public abstract class Salle {
	
	private static int 		 currentId = 0;
	private int 			 id;
	
	public Salle()	{
		this.id = Salle.currentId++;
	}
	
	public int getId(){
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Salle [id=" + id + "]";
	}
	
	public abstract Object clone();
	
}
