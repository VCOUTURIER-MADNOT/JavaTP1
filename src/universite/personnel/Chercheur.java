package universite.personnel;

import universite.interfaces.XMLSerializer;

public interface Chercheur extends XMLSerializer{
	boolean chercher(String _sujet);
}
