import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import universite.administratif.Departement;
import universite.administratif.Laboratoire;
import universite.administratif.UFR;
import universite.administratif.Universite;
import universite.batiment.Batiment;
import universite.personnel.ChargeRecherche;
import universite.personnel.MaitreDeConf;
import universite.personnel.PRAG;
import universite.personnel.Professeur;

public class XMLManager {
	
	private static final String XML_FILE_NAME = "workspace.xml";

	public static void exportToXML(Universite _universite) throws IOException
	{
		PrintWriter xmlWriter;

	    xmlWriter =  new PrintWriter(new BufferedWriter(new FileWriter(XML_FILE_NAME)));
	    
	    xmlWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    xmlWriter.println(_universite.toXML());
	    
	    xmlWriter.close();
	}
	
	public static Universite importXML()
	{
		File file = XMLManager.openDocument(XML_FILE_NAME);
		Document document = XMLManager.parseDocument( file );
		Universite universite = XMLManager.instantiateObjects( document );
		return universite;
	}

	private static File openDocument(String xmlQualifiedName) {
		File file = null;
		try {
			file = new File( xmlQualifiedName );
		} catch ( RuntimeException e ) {
			e.printStackTrace();
			throw new RuntimeException("File seems to be unreachable.");
		}
		return file;
	}

	private static Document parseDocument(File file) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructeur = null;
		try {
			constructeur = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new RuntimeException("Parser is unable to be built.");
		}
		Document document = null;
		try {
			document = constructeur.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new RuntimeException("Parser is unable to parse file.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("File seems to be unreachable.");
		}
		return document;
	}

	private static Universite instantiateObjects(Document document) {
		Universite universite = new Universite();
		Node universiteNode = document.getFirstChild();
		NodeList composantes = universiteNode.getChildNodes();
		for( int i = 0 ; i < composantes.getLength() ; ++i ) {
			Node composante = composantes.item(i);
			XMLManager.appendComposante( universite, composante );
		}
		return universite;
	}

	private static void appendComposante(Universite universite, Node composante) {
		String composanteTypeName = composante.getNodeName();
		Composantes composanteType = XMLManager.Composantes.determineComposante(composanteTypeName);
		switch ( composanteType ) {
		case UFR:
			UFR ufr = new UFR();
			universite.ajoutUFR(ufr);
			XMLManager.appendToUFR( ufr, composante );
			break;
		case LABORATOIRE:
			Laboratoire labo = new Laboratoire();
			universite.ajoutLaboratoire(labo);
			XMLManager.appendToLabo( labo, composante );
			break;
		case DEPARTEMENT:
			Departement departement = new Departement();
			universite.ajoutDepartement(departement);
			XMLManager.appendToDepartement( departement, composante );
			break;
		}
	}

	private static enum Composantes {
		UFR			("UFR"),
		LABORATOIRE	("Laboratoire"),
		DEPARTEMENT	("Departement"),
		;
		String usualName;
		private Composantes( String usualName ) {
			this.usualName = usualName;
		}
		public static Composantes determineComposante( String nom ) {
			if ( nom == UFR.usualName ) return UFR ;
			if ( nom == LABORATOIRE.usualName) return LABORATOIRE;
			if ( nom == DEPARTEMENT.usualName) return DEPARTEMENT;
			else {
				return null;
			}
		}
	}
	
	private static void appendToUFR(UFR ufr, Node ufrNode) {
		NodeList ufrInnerElements = ufrNode.getChildNodes();
		for ( int i = 0 ; i < ufrInnerElements.getLength() ; ++i ) {
			String nodeName = ufrInnerElements.item(i).getNodeName();
			if ( nodeName == "Batiment" ) {
				Batiment batiment = new Batiment();
				ufr.ajoutBatiment(batiment);
			}
			if ( nodeName == "Departement" ) {
				Departement departement = new Departement();
				ufr.ajoutDepartement(departement);
			}
		}
	}

	private static void appendToLabo(Laboratoire labo, Node laboNode) {
		NodeList laboInnerElements = laboNode.getChildNodes();
		for ( int i = 0 ; i < laboInnerElements.getLength() ; ++i ) {
			String nodeName = laboInnerElements.item(i).getNodeName();
			if ( nodeName == "ChargeRecherche" ) {
				ChargeRecherche chargeRecherche = new ChargeRecherche();
				labo.ajouteChercheur(chargeRecherche);
			}
			if ( nodeName == "MaitreDeConf" ) {
				MaitreDeConf maitreDeConf = new MaitreDeConf();
				labo.ajouteChercheur(maitreDeConf);
			}
			if ( nodeName == "Professeur" ) {
				Professeur professeur = new Professeur();
				labo.ajouteChercheur(professeur);
			}
		}
	}

	private static void appendToDepartement(Departement departement, Node departementNode ) {
		NodeList departementInnerElements = departementNode.getChildNodes();
		for ( int i = 0 ; i < departementInnerElements.getLength() ; ++i ) {
			String nodeName = departementInnerElements.item(i).getNodeName();
			if ( nodeName == "PRAG" ) {
				PRAG prag = new PRAG();
				departement.ajoutEnseignant(prag);
			}
			if ( nodeName == "MaitreDeConf" ) {
				MaitreDeConf maitreDeConf = new MaitreDeConf();
				departement.ajoutEnseignant(maitreDeConf);
			}
			if ( nodeName == "Professeur" ) {
				Professeur professeur = new Professeur();
				departement.ajoutEnseignant(professeur);
			}
		}
	}

}
