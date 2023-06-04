import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.InputStream;  
import javax.xml.xquery.XQConnection;  
import javax.xml.xquery.XQDataSource;  
import javax.xml.xquery.XQException;  
import javax.xml.xquery.XQPreparedExpression;  
import javax.xml.xquery.XQResultSequence;  
import com.saxonica.xqj.SaxonXQDataSource;  
public class Xquerydss {  
   public static void main(String[] args){  
      try {  
          
          //cette requette permet de calculer le chifre d'affaire a partir du mantant des consultation pour chaque dossier
         execute("chifreaffaire.xqy");  
         
         // cette requette permet d'avoir les ID des dossier qui ont quellque traitement DOLIPRANE comme traitement ponctuelle
         execute("req2.xqy");
         
         // cette requette permet d'avoir  la date de creation minimale d'un  dossier dans le document xml
         execute("req3.xqy");
         
         // cette requette permet d'avoir les patient qui ont l'age maximum parmi les age des patient  du document xml
         execute("req4.xqy");
         
         // cette requette permet d'avoir des balise personaliser grace au constructeur direct  selon le type du lieux de travaille des medecins
         execute("req5.xqy");
         
         
         // cette requette permet grace au constructeur compté de creer un document xml avec l'element fichepatient qui contient le mantant moyen des consultation pour chaque patient
         execute("req6.xqy");
      }  
      catch (FileNotFoundException e) {  
         e.printStackTrace();  
      }        
      catch (XQException e) {  
         e.printStackTrace();  
      }  
   }  
   private static void execute(String name) throws FileNotFoundException, XQException{  
      InputStream inputStream = new FileInputStream(new File("src//"+name));  
      XQDataSource ds = new SaxonXQDataSource();  
      XQConnection conn = ds.getConnection();  
      XQPreparedExpression exp = conn.prepareExpression(inputStream);  
      XQResultSequence result = exp.executeQuery();  
       while (result.next()) {  
         System.out.println(result.getItemAsString(null));  
      }  
   }      
}  