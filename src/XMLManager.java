import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import universite.administratif.Universite;

public class XMLManager {
	
	public static void exportToXML(Universite _universite) throws IOException
	{
		PrintWriter xmlWriter;

	    xmlWriter =  new PrintWriter(new BufferedWriter
		   (new FileWriter("workspace.xml")));
	    
	    xmlWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    xmlWriter.println(_universite.toXML());
	    
	    xmlWriter.close();
	}
	
	public static void importXML()
	{
		
	}
}
