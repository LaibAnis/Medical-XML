/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
 
import java.util.*;
import java.io.*;


public class Saxparserdss {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        
        SAXParserFactory saxss = SAXParserFactory.newInstance();
        SAXParser saxsspars = saxss.newSAXParser();
        DefaultHandler handler = new DefaultHandler(){
            
            /* currentstate ne permet de savoir dans quele element nous somme a l'instant */
            
            String currentstate="";
            /* text ne permet de extraire le contenu textuelle d'un element */
            String text="";
            /* les variables suivant ne permmette de calculer les caracteristique d'obesite a partir de l'element imc du document xml */
            int maigre,normale,surpoids,Obesitemoderee,Obesitesevere,Obesitemassive=0;
            
            /* poidssum ne permet de faire la sommation des poids des patients pour calculer la moyen de la caracteristique poids de l'element poids du document xml  */
            double poidssu=0;
            int nbpatient;
            
            int medecintraitantsum=0;
            int nbfumeur=0;
            int nbfumeursevree=0;
            int nbfumeuraveccancer=0;
            int nbfumeursevreeaveccancer=0;
            int nbpatientaveccancer=0;
            int nbpatientquiprennedoliprane=0;
            boolean cancertrouvee=false;
            boolean antecedantmedicaux=false;
            boolean listetraitementponctuel=false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                
                currentstate=qName;
                text="";
                
                if(currentstate.equals("dossier")){
                    nbpatient++;
                }
                
                if(currentstate.equals("medecintraitant")){
                    
                    medecintraitantsum+=attributes.getValue(0).split(" ").length;
                }
                
                if(currentstate.equals("antecedantmedicaux")){
                    antecedantmedicaux=true;
                }
                 
                if(currentstate.equals("listetraitementponctuel")){
                    listetraitementponctuel=true;
                }
                
                if(currentstate.equals("tabac")){
                    if(attributes.getValue(0).equals("oui")){
                        nbfumeur++;
                        if(cancertrouvee){
                            nbfumeuraveccancer++;
                        }
                    }
                    else if(attributes.getValue(0).equals("sevree")){
                        nbfumeursevree++;
                        if(cancertrouvee){
                            nbfumeursevreeaveccancer++;
                        }
                    }
                }
                
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                 
                 text=text.concat(new String(ch, start, length));
            }
            
            

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                 
                 /* le if suivant ne permet de calculer les caracteristique d'obesite a partir de l'element imc du document xml */ 
                 if(currentstate.equals("imc")){
                    text=text.trim();
                    text=text.split("<")[0];
                 
                    double imc=Double.parseDouble(text);
                     if(imc<18.5){
                         maigre+=1;
                     }
                     else if(imc>=18.5 && imc<25){
                         normale+=1;
                     }
                      else if(imc>=25 && imc<30){
                         surpoids+=1;
                     }
                     else if(imc>=30 && imc<35){
                         Obesitemoderee+=1;
                     }
                     else if(imc>=35 && imc<40){
                         Obesitesevere+=1;
                     }
                     else if(imc>=40){
                         Obesitemassive+=1;
                     }

                }
                 /* le if suivant ne permet de calculer  la moyen de la caracteristique poids des patients de l'element poids du document xml */ 
                 else if(currentstate.equals("poids")){
                    text=text.trim();
                    text=text.split("<")[0];
                    
                    poidssu+=Double.parseDouble(text);
                 }
                 
                 else if(currentstate.equals("nom")){
                     if(antecedantmedicaux){
                         if(text.contains("cancer")){
                             cancertrouvee=true;
                             nbpatientaveccancer++;
                             
                         }
                         antecedantmedicaux=false;
                     }
                     else if(listetraitementponctuel){
                         if(text.contains("doliprane")){
                             nbpatientquiprennedoliprane++;
                         }
                         listetraitementponctuel=false;
                     }
                 }
                 
                 text="";
            }

            @Override
            public void endDocument() throws SAXException {
                 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                System.out.println("nombre de cas maigre = "+maigre+" \n nombre de cas normale = "+normale+"\n nombre de cas surpoids = "+surpoids+"\n nombre de cas obesitee moderee = "+Obesitemoderee+"\n nombre de cas obesitee severe = "+Obesitesevere+"\n nombre de cas obesitee massive = "+Obesitemassive+"\n");
                System.out.println("le poid moyen = "+poidssu/nbpatient);
                System.out.println("nombre de fumeur = "+nbfumeur);
                System.out.println("nombre de fumeur sevree (qui ont arreter de fumer) = "+nbfumeursevree);
                System.out.println("nombre de fumeur sevree qui ont un cancer = "+nbfumeursevreeaveccancer);
                System.out.println("nombre de fumeur qui ont a cancer = "+nbfumeuraveccancer);
                System.out.println("nombre de non fumeur = "+(nbpatient-(nbfumeur+nbfumeursevree)));
                System.out.println("nombre de patient qui ont un cancer = "+nbpatientaveccancer);
                System.out.println("nombre de patient qui prenne du doliprane = "+nbpatientquiprennedoliprane);
                System.out.println("nombre de patient =  "+nbpatient);
                System.out.println("moyen de medecin traitant par dossier = "+(medecintraitantsum/nbpatient));
            }
            
            
            
            
            
            
            
        };
        
        saxsspars.parse("src//dossiermedicaux.xml", handler);
        
    }
    
}
