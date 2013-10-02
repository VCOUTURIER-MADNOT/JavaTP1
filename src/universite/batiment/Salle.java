package universite.batiment;
import universite.interfaces.XMLSerializer;

public abstract class Salle implements Cloneable, XMLSerializer{
	
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
	
	public String toXML(){
		String s = "<id>" + this.id + "</id>";
		
		return s;
	}
	
	public abstract Object clone();
	
}
