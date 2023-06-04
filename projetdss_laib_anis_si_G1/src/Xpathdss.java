import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Xpathdss {

	public static void main(String[] args) throws Exception
	{
		File xmlFile = new File("src//dossiermedicaux.xml");
		
		// Get DOM
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document xml = db.parse(xmlFile);
		xml.getDocumentElement().normalize();

		// Get XPath
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xpath = xpf.newXPath();

		// cette expression permet de selectioner les ID des medecin traitant du dossier aux position 1
		String name = (String)xpath.evaluate(
			"//dossier[position()=1]/medecintraitant/@ref", xml,
			XPathConstants.STRING);

		System.out.println("id des medecin traitant du dossier numero 1 : \n" + name);
                
                // cette expression permet de selectioner le nom des patient fumeur 
                 NodeList names = (NodeList)xpath.evaluate(
			"//patient[ancestor::listepatient/following-sibling::listdossier/dossier[modedevie/tabac/@consomation='oui']//patientconcernee/@ref=@idp]/nom", xml,
			XPathConstants.NODESET);
                 System.out.println("\n nom des patient fumeur");
                 printNodes(names);
                 
                 // cette expression permet de selectioner le nom des patient qui on plus que 2 consultation  
                  names = (NodeList)xpath.evaluate(
			"//patient[ancestor::listepatient/following-sibling::listdossier/dossier[count(listeconsultation/consultation)>2]//patientconcernee/@ref=@idp]/nom", xml,
			XPathConstants.NODESET);
                 System.out.println("\n nom des patient avec plus de 2 consulatation");
                 printNodes(names);
                 
                 
                 // cette expression permet de selectioner les ID des dossier qui n'ont pas d'antecedant familiaux  
                 names = (NodeList)xpath.evaluate(
			"//dossier[boolean(listantecedant/antecedantfamiliaux/antecedant)]/@idd", xml,
			XPathConstants.NODESET);
                 System.out.println("\n id des dossier qui ont des antecedants familiaux");
                 printNodes(names);
                 
                 // cette expression permet de selectioner les ID des dossier qui n'ont pas d'antecedant medicaux cancereu
                 names = (NodeList)xpath.evaluate(
			"//dossier[not(boolean(listantecedant/antecedantmedicaux/antecedant/nom[contains(text(),'cancer')]))]/@idd", xml,
			XPathConstants.NODESET);
                 System.out.println("\n id des dossier qui n'ont pas des antecedants medicaux cencereu");
                 printNodes(names);
                 
                 
                 // cette expression permet de recuperer le numero de telephone du medecin dont l'idm est m_1
		String numtel = (String)xpath.evaluate(
			"//listemedecin/medecin[@idm='m_1']/informationprofesionnel/numero[@categorie='mobile']"
			, xml,
			XPathConstants.STRING);
		System.out.println("Recuperer le numero de telephone du medecin dont l'idm est m_1: \n" + numtel+"\n");
		
		
		
		// cette expression permet de recupere le lieux de travaille de dr belkaid
		String lieux = (String)xpath.evaluate(
			"//lieuxdetravaille/lieux[nom='cabinet medicale de dr belkaid']/adresse/localitee"
			, xml,
			XPathConstants.STRING);
		System.out.println("recuperer le lieux de travaille de dr belkaid: \n" + lieux +"\n");
		
		
		
		// cette expression permet de recuperer la specialite du medecin dont l'idm est m_3
		String specialite = (String)xpath.evaluate(
			"//listemedecin/medecin[@idm='m_3']/informationprofesionnel/specialite"
			, xml,
			XPathConstants.STRING);
		System.out.println("recuperer la specialite du medecin dont l'idm est m_3: \n" + specialite+"\n");
		
		
		
		
		// cette expression permet de recupere la date de naissance au format jour-mois-ann�e du medecin dont l'idm est m_2
		String dateJMA = (String)xpath.evaluate(
			"concat(//listemedecin/medecin[@idm='m_2']/informationpersonnel/datedenaissance/jour, '-', //listemedecin/medecin[@idm='m_2']/informationpersonnel/datedenaissance/mois, '-', //listemedecin/medecin[@idm='m_2']/informationpersonnel/datedenaissance/annee)"
			, xml,
			XPathConstants.STRING);
		System.out.println("recupere la date de naissance au format jour-mois-ann�e du medecin dont l'idm est m_2: \n" + dateJMA);
		
		// cette expression permet de recuperer le pays, wilaya et localitee du patient dont l'idp est p_1
				String adresse = (String)xpath.evaluate(
					"concat(//patient/adresse/pays/text(), ' - ', //patient/adresse/wilaya/text(), ' - ', //patient/adresse/localitee/text())\r\n"
					, xml,
					XPathConstants.STRING);
				System.out.println("recuperer le pays, wilaya et localitee du patient dont l'idp est p_1 \n" + adresse);
		
                 
                 System.out.println("les information du medecin aux id m_5");
                 names = (NodeList)xpath.evaluate(
                    "//medecin[@idm='m_5']", xml,
                    XPathConstants.NODESET);
                 printNodes(names);
                 
                 System.out.println("les information du patinet aux id p_5");
                 names = (NodeList)xpath.evaluate(
                    "//patient[@idp='p_5']", xml,
                    XPathConstants.NODESET);
                 printNodes(names);

		/* find specific students name whose branch is IT
		NodeList nodes = (NodeList)xpath.evaluate(
			"/students/student[@branch = \"IT\"]/name", xml,
			XPathConstants.NODESET);

		System.out.println("\nStudents with branch IT:");
		printNodes(nodes);

		// find specific students
		// name whose age is less
		// than equal to 20
		nodes = (NodeList)xpath.evaluate(
			"/students/student[age <= 20]/name", xml,
			XPathConstants.NODESET);

		System.out.println(
			"\nStudents of age less than equal to 20:");
		printNodes(nodes);

		// First 4 students from XML document
		nodes = (NodeList)xpath.evaluate(
			"/students/student[position() < 5]/name", xml,
			XPathConstants.NODESET);

		System.out.println("\nFirst Four Students: ");
		printNodes(nodes);*/
	}
	
	// prints nodes
	public static void printNodes(NodeList nodes)
	{
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(
				(i + 1) + ". "
				+ nodes.item(i).getTextContent());
		}
	}
}
