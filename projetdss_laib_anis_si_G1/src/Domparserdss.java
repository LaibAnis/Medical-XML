import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Domparserdss {
    
    
    public static void main(String[] args) {
        
        String filePath = "src//dossiermedicaux.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            // parse xml file and load into document
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            // update Element value
            
            // cette fonction permet d'ajouter un neuveaux patient aux document xml users_updated.xml qui copie coller de documment xml originale
            addPatient(doc,"belkaid","mohammed","src//p2.jpeg","20","homme","19","mai","1990","bemoh19@gmail.com","algerie","oran","centre ville");
            
            // cette fonction permet d'ajouter un neuveaux IDM d'un medecin a un dossier  aux document xml users_updated.xml qui copie coller de documment xml originale
            addmedecintraitantpourpatient(doc,"p_1","m_7");
            
            // cette fonction permet d'afficher nom prenom image src de tout les medecins du documment xml originale
            getNomPrenomImgmedecins(doc);
            
            // cette fonction permet d'afficher nom prenom image src de tout les patients du documment xml originale
            getNomPrenomImgPatients(doc);
            
            // cette fonction permet de suprimmer un patient du document xml users_updated.xml qui copie coller de documment xml originale
            removepatient(doc, 7);
            
            // cette fonction permet de suprimmer un medecin du document xml users_updated.xml qui copie coller de documment xml originale
            removemedecin(doc, 5);
            // write the updated document to file or console
            writeXMLFile(doc);

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }
    
     private static void writeXMLFile(Document doc)
    throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src//users_updated.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML file updated successfully");
    }
     
     
     public static  void addPatient(Document doc,String nom,String prenom,String src,String age,String sexe,String jour,String mois,String annee,String email,String pays,String wilaya,String localitee){
         NodeList listpatient= doc.getElementsByTagName("listepatient");
         
         Element emp = (Element) listpatient.item(0);
         
         NodeList patients = emp.getElementsByTagName("patient");
         int nbpatient = patients.getLength();
         
         Element patientElement = doc.createElement("patient");
         patientElement.setAttribute("idp", "p_"+(nbpatient+1));
         patientElement.setAttribute("sexe", sexe);
         
         Element nomElement = doc.createElement("nom");
         nomElement.appendChild(doc.createTextNode(nom));
         
         Element prenomElement = doc.createElement("prenom");
         prenomElement.appendChild(doc.createTextNode(prenom));
         
         Element imgElement = doc.createElement("img");
         imgElement.setAttribute("src", src);
         
         Element jourElement = doc.createElement("jour");
         jourElement.appendChild(doc.createTextNode(jour));
         
         Element moisElement = doc.createElement("mois");
         moisElement.appendChild(doc.createTextNode(mois));
         
         Element anneeElement = doc.createElement("annee");
         anneeElement.appendChild(doc.createTextNode(annee));
         
         Element ageElement = doc.createElement("age");
         ageElement.appendChild(doc.createTextNode(age));
         
         Element emailElement = doc.createElement("email");
         emailElement.appendChild(doc.createTextNode(email));
         emailElement.setAttribute("type", "personel");
         
         Element paysElement = doc.createElement("pays");
         paysElement.appendChild(doc.createTextNode(pays));
         
         Element wilayaElement = doc.createElement("wilaya");
         wilayaElement.appendChild(doc.createTextNode(wilaya));
         
         Element localiteeElement = doc.createElement("localitee");
         localiteeElement.appendChild(doc.createTextNode(localitee));
         
         Element dateElement = doc.createElement("datedenaissance");
         dateElement.appendChild(jourElement);
         dateElement.appendChild(moisElement);
         dateElement.appendChild(anneeElement);
         
         Element adresseElement = doc.createElement("adresse");
         adresseElement.setAttribute("type", "privee");
         adresseElement.appendChild(paysElement);
         adresseElement.appendChild(wilayaElement);
         adresseElement.appendChild(localiteeElement);
         
         
         patientElement.appendChild(nomElement);
         patientElement.appendChild(prenomElement);
         patientElement.appendChild(imgElement);
         patientElement.appendChild(dateElement);
         patientElement.appendChild(ageElement);
         patientElement.appendChild(emailElement);
         patientElement.appendChild(adresseElement);
         
         emp.appendChild(patientElement);
     }
     
     
     public static void addmedecintraitantpourpatient(Document doc,String idp,String idm){
         NodeList dossierpatient= doc.getElementsByTagName("dossier");
         
         for(int i=0;i<dossierpatient.getLength();i++){
             Element dospatient=(Element) dossierpatient.item(i);
             NodeList patientcencernee=dospatient.getElementsByTagName("patientconcernee");
             Element em= (Element) patientcencernee.item(0);
             if(em.getAttribute("ref").equals(idp)){
                 NodeList medecintraitant=dospatient.getElementsByTagName("medecintraitant");
                 Element eme= (Element) medecintraitant.item(0);
                 String attrrefmed=eme.getAttribute("ref");
                 attrrefmed=attrrefmed.concat(" "+idm);
                 eme.setAttribute("ref",attrrefmed);
             }
         }
     }
     
     
public static void getNomPrenomImgmedecins(Document doc){
    NodeList medecins= doc.getElementsByTagName("medecin");
                          String podtitle=null;
                          String podaut=null;
                          int podid;
                          int userid;
                          String lastename;
                          String firstname;
                          String imgd;
                          for(int i=0;i<medecins.getLength();i++){
                              Element medecin=(Element) medecins.item(i);
                              String [] ee=medecin.getAttribute("idm").split("_");
                              System.out.println("Adminpodcast.getpodcasts()"+ee[1]);
                              podid=Integer.parseInt(ee[1]);
                              NodeList me= medecin.getElementsByTagName("informationpersonnel");
                              Element medec=(Element) me.item(0);
                              podtitle=medec.getElementsByTagName("nom").item(0).getTextContent();
                              System.out.println("Nom : "+podtitle);
                              podaut=medec.getElementsByTagName("prenom").item(0).getTextContent();
                              System.out.println("Prenom : "+podaut);
                              NodeList im= medec.getElementsByTagName("img");
                              Element ime=(Element) im.item(0);
                              imgd=ime.getAttribute("src");
                              System.out.println("image src : "+imgd);
                              
                              
                          }
    
    
    
    
}

 public static void getNomPrenomImgPatients(Document doc){
     String podtitle=null;
                          String podaut=null;
                          int podid;
                          int userid;
                          String lastename;
                          String firstname;
                          String imgd;

NodeList patients= doc.getElementsByTagName("patient");
          for(int i=0;i<patients.getLength();i++){
              Element patient=(Element) patients.item(i);
              String [] e=patient.getAttribute("idp").split("_");
              
              podid=Integer.parseInt(e[1]);
              
              
              podtitle=patient.getElementsByTagName("nom").item(0).getTextContent();
              System.out.println("Nom : "+podtitle);
              podaut=patient.getElementsByTagName("prenom").item(0).getTextContent();
              System.out.println("Prenom : "+podaut);
             NodeList im= patient.getElementsByTagName("img");
             Element ime=(Element) im.item(0);
              imgd=ime.getAttribute("src");
              System.out.println("image src : "+imgd);
              
             
          }
 }
 
 
 
 public static void removepatient(Document doc,int idp){
     doc.getDocumentElement().normalize();
                          NodeList nodes = doc.getElementsByTagName("patient");
                          
                          for (int i = 0; i < nodes.getLength(); i++) {
                              Element person = (Element)nodes.item(i);
                              // <name>
                              
                              if (Integer.parseInt(person.getAttribute("idp").split("_")[1])==idp) {
                                  person.getParentNode().removeChild(person);
                              }
                          }
 }
 
 
 public static void removemedecin(Document doc,int idm){
     
     doc.getDocumentElement().normalize();
                          NodeList nodes = doc.getElementsByTagName("medecin");
                          
                          for (int i = 0; i < nodes.getLength(); i++) {
                              Element person = (Element)nodes.item(i);
                              // <name>
                              
                              if (Integer.parseInt(person.getAttribute("idm").split("_")[1])==idm) {
                                  person.getParentNode().removeChild(person);
                              }
                          }
 }
}
