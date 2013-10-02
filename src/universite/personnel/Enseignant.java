package universite.personnel;

import universite.interfaces.XMLSerializer;

public interface Enseignant extends XMLSerializer{
	void enseigner(String _matiere);
}
