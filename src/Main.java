import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlMimeType;

import universite.administratif.Laboratoire;
import universite.administratif.Universite;
import universite.batiment.SalleTP;
import universite.personnel.ChargeRecherche;


public class Main {

	public static void main(String[] args) {
		
		
		
		Universite universite = XMLManager.importXML();
		
		try {
			XMLManager.exportToXML(universite);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
