import java.io.IOException;

import universite.administratif.Universite;


public class Main {

	public static Universite universite = new Universite();
	
	public static void main(String[] args) {
		
		Universite universite = XMLManager.importXML();
		
		try {
			XMLManager.exportToXML(universite);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
