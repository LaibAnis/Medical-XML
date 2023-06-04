
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author dell
 */
public class Admindossier extends javax.swing.JFrame {
    
    
    public class Login extends javax.swing.JDialog {
    
       private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labellogoo;
    private javax.swing.JPanel panellogoo;
    
    public Login(java.awt.Frame parent, boolean modal,int idm,int mp) throws SAXException, IOException, ParserConfigurationException {
        super(parent, modal);
        initComponents1();
        try {
            File xmlFile = new File("src//dossiermedicaux.xml");
            
            // Get DOM
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xml = db.parse(xmlFile);
            xml.getDocumentElement().normalize();
            
            // Get XPath
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            
            
            if(mp==1){
                String name = (String)xpath.evaluate(
                    "//medecin[@idm='m_"+idm+"']", xml,
                    XPathConstants.STRING);
            jTextArea1.append(name);
            }
            else{
                 String name = (String)xpath.evaluate(
                    "//patient[@idp='p_"+idm+"']", xml,
                    XPathConstants.STRING);
            jTextArea1.append(name);
            
            name = (String)xpath.evaluate(
                    "//dossier[//patientconcernee/@ref='p_"+idm+"']", xml,
                    XPathConstants.STRING);
            jTextArea1.append(name);
            
            }
            
         
            
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initComponents1() {

        panellogoo = new javax.swing.JPanel();
        labellogoo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panellogoo.setBackground(new java.awt.Color(233, 242, 245));
        panellogoo.setPreferredSize(new java.awt.Dimension(800, 101));
        panellogoo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panellogoo.add(labellogoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, 80));

        getContentPane().add(panellogoo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 440, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 440, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 700, 500));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }
    
    }
    
    
    
    String filePath = "src//users_updated.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

    /**
     * Creates new form Adminpodcast
     */
    
    
    public Admindossier() {
        initComponents();
        labellogo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/logodoc.png")).getImage().getScaledInstance(labellogo.getWidth(), labellogo.getHeight(), Image.SCALE_SMOOTH)));
        getmedecin();
        getpatient();
        panelPodcats.setVisible(true);
        panelComments.setVisible(false);

        
        
    }
    
    
    void creatcommentpanel(int podid,String podtitle,String podaut,String img){
        JPanel podcastpanel= new JPanel();
        JLabel labelimgpod = new JLabel();
        JLabel labeltitle = new JLabel();
        JLabel labelaut = new JLabel();
        JLabel deletlab = new JLabel();
        ImageIcon im;
        
        podcastpanel.setBackground(new java.awt.Color(255, 255, 255));

        labelimgpod.setPreferredSize(new java.awt.Dimension(38, 16));
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(188, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimgpod.setIcon(im);
        labelimgpod.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    new Login(null,true,podid,0).show();
                } catch (SAXException | IOException | ParserConfigurationException ex) {
                    Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        

        labeltitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);

        labelaut.setBackground(new java.awt.Color(255, 255, 255));
        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);

        deletlab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletlab.setForeground(new java.awt.Color(255, 0, 0));
        deletlab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deletlab.setText("Delete");
        deletlab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red));
        deletlab.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                  int rese=JOptionPane.showConfirmDialog(null, "Are you sure to delete this podcast ?", "Delting podcast", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(rese==JOptionPane.YES_OPTION){
                      try {
                          panelComments.removeAll();
                          panelComments.setVisible(false);
                          
                          dBuilder = dbFactory.newDocumentBuilder();
                          
                          // parse xml file and load into document
                          Document doc = dBuilder.parse(xmlFile);
                          
                          doc.getDocumentElement().normalize();
                          NodeList nodes = doc.getElementsByTagName("patient");
                          
                          for (int i = 0; i < nodes.getLength(); i++) {
                              Element person = (Element)nodes.item(i);
                              // <name>
                              
                              if (Integer.parseInt(person.getAttribute("idp").split("_")[1])==podid) {
                                  person.getParentNode().removeChild(person);
                              }
                          }
                          
                          doc.getDocumentElement().normalize();
                          TransformerFactory transformerFactory = TransformerFactory.newInstance();
                          Transformer transformer = transformerFactory.newTransformer();
                          DOMSource source = new DOMSource(doc);
                          StreamResult result = new StreamResult(new File("src//users_updated.xml"));
                          transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                          transformer.transform(source, result);
                          System.out.println("XML file updated successfully");
                          
                          NodeList medecins= doc.getElementsByTagName("patient");
                          String podtitle=null;
                          String podaut=null;
                          int podid;
                          int userid;
                          String lastename;
                          String firstname;
                          String imgd;
                          for(int i=0;i<medecins.getLength();i++){
              Element patient=(Element) medecins.item(i);
              String [] ee=patient.getAttribute("idp").split("_");
              System.out.println("Adminpodcast.getpodcasts()"+ee[1]);
              podid=Integer.parseInt(ee[1]);
              NodeList me= patient.getElementsByTagName("informationpersonnel");
              
              podtitle=patient.getElementsByTagName("nom").item(0).getTextContent();
              System.out.println("Adminpodcast.getpodcasts()"+podtitle);
              podaut=patient.getElementsByTagName("prenom").item(0).getTextContent();
             NodeList im= patient.getElementsByTagName("img");
             Element ime=(Element) im.item(0);
              imgd=ime.getAttribute("src");
              
              creatcommentpanel(podid, podtitle, podaut, imgd);
          }
                          
                          panelComments.setVisible(true);
                      } catch (TransformerConfigurationException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (ParserConfigurationException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (SAXException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (IOException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (TransformerException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent evt){
                deletlab.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deletlab.setBackground(Color.red);
                deletlab.setOpaque(true);
                deletlab.setForeground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                deletlab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                deletlab.setBackground(Color.white);
                deletlab.setOpaque(true);
                deletlab.setForeground(Color.red);
            }
        });

        javax.swing.GroupLayout podcastpanelLayout = new javax.swing.GroupLayout(podcastpanel);
        podcastpanel.setLayout(podcastpanelLayout);
        podcastpanelLayout.setHorizontalGroup(
            podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(podcastpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelimgpod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletlab, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        podcastpanelLayout.setVerticalGroup(
            podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(podcastpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelimgpod, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelaut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deletlab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelComments.add(podcastpanel);
    }
    
    
    void getpatient(){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String podtitle=null;
        String podaut=null;
        int podid;
        int userid;
        String lastename;
        String firstname;
        String imgd;
        
        
        
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            // parse xml file and load into document
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            
             NodeList medecins= doc.getElementsByTagName("patient");
          for(int i=0;i<medecins.getLength();i++){
              Element patient=(Element) medecins.item(i);
              String [] e=patient.getAttribute("idp").split("_");
              System.out.println("Adminpodcast.getpodcasts()"+e[1]);
              podid=Integer.parseInt(e[1]);
              NodeList me= patient.getElementsByTagName("informationpersonnel");
              
              podtitle=patient.getElementsByTagName("nom").item(0).getTextContent();
              System.out.println("Adminpodcast.getpodcasts()"+podtitle);
              podaut=patient.getElementsByTagName("prenom").item(0).getTextContent();
             NodeList im= patient.getElementsByTagName("img");
             Element ime=(Element) im.item(0);
              imgd=ime.getAttribute("src");
              
              creatcommentpanel(podid, podtitle, podaut, imgd);
          }

            // update Element value
            
            // add new element


        } catch (SAXException | ParserConfigurationException | IOException  e1) {
            e1.printStackTrace();
        }
    }
    
    
    
    
    void creatpanel(int podid,String podtitle,String podaut,String img){
        JPanel podcastpanel= new JPanel();
        JLabel labelimgpod = new JLabel();
        JLabel labeltitle = new JLabel();
        JLabel labelaut = new JLabel();
        JLabel deletlab = new JLabel();
        ImageIcon im;
        
        podcastpanel.setBackground(new java.awt.Color(255, 255, 255));
        

        labelimgpod.setPreferredSize(new java.awt.Dimension(38, 16));
        im=new ImageIcon(img);
        Image imagg= im.getImage();
        Image imagg2=imagg.getScaledInstance(188, 170, Image.SCALE_SMOOTH);
        im=new ImageIcon(imagg2);
        labelimgpod.setIcon(im);
        labelimgpod.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    new Login(null,true,podid,1).show();
                } catch (SAXException | IOException | ParserConfigurationException ex) {
                    Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        

        labeltitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        labeltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitle.setText(podtitle);

        labelaut.setBackground(new java.awt.Color(255, 255, 255));
        labelaut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        
        labelaut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelaut.setText(podaut);

        deletlab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletlab.setForeground(new java.awt.Color(255, 0, 0));
        deletlab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deletlab.setText("Delete");
        deletlab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red, java.awt.Color.red));
        deletlab.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                  int rese=JOptionPane.showConfirmDialog(null, "Are you sure to delete this podcast ?", "Delting podcast", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(rese==JOptionPane.YES_OPTION){
                      try {
                          panelPodcats.removeAll();
                          panelPodcats.setVisible(false);
                          
                          dBuilder = dbFactory.newDocumentBuilder();
                          
                          // parse xml file and load into document
                          Document doc = dBuilder.parse(xmlFile);
                          
                          doc.getDocumentElement().normalize();
                          NodeList nodes = doc.getElementsByTagName("medecin");
                          
                          for (int i = 0; i < nodes.getLength(); i++) {
                              Element person = (Element)nodes.item(i);
                              // <name>
                              
                              if (Integer.parseInt(person.getAttribute("idm").split("_")[1])==podid) {
                                  person.getParentNode().removeChild(person);
                              }
                          }
                          
                          doc.getDocumentElement().normalize();
                          TransformerFactory transformerFactory = TransformerFactory.newInstance();
                          Transformer transformer = transformerFactory.newTransformer();
                          DOMSource source = new DOMSource(doc);
                          StreamResult result = new StreamResult(new File("src//users_updated.xml"));
                          transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                          transformer.transform(source, result);
                          System.out.println("XML file updated successfully");
                          
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
                              System.out.println("Adminpodcast.getpodcasts()"+podtitle);
                              podaut=medec.getElementsByTagName("prenom").item(0).getTextContent();
                              NodeList im= medec.getElementsByTagName("img");
                              Element ime=(Element) im.item(0);
                              imgd=ime.getAttribute("src");
                              
                              creatpanel(podid, podtitle, podaut, imgd);
                          }
                          
                          panelPodcats.setVisible(true);
                      } catch (TransformerConfigurationException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (ParserConfigurationException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (SAXException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (IOException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (TransformerException ex) {
                          Logger.getLogger(Admindossier.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent evt){
                deletlab.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deletlab.setBackground(Color.red);
                deletlab.setOpaque(true);
                deletlab.setForeground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent evt){
                deletlab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                deletlab.setBackground(Color.white);
                deletlab.setOpaque(true);
                deletlab.setForeground(Color.red);
            }
        });

        javax.swing.GroupLayout podcastpanelLayout = new javax.swing.GroupLayout(podcastpanel);
        podcastpanel.setLayout(podcastpanelLayout);
        podcastpanelLayout.setHorizontalGroup(
            podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(podcastpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelaut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelimgpod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletlab, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        podcastpanelLayout.setVerticalGroup(
            podcastpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(podcastpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelimgpod, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelaut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deletlab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelPodcats.add(podcastpanel);
    }
        void getmedecin(){
        Connection cn; 
        PreparedStatement pr;
        ResultSet rs;
        ResultSet rs2;
        String podtitle=null;
        String podaut=null;
        int podid;
        int userid;
        String lastename;
        String firstname;
        String imgd;
        
        
        
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            // parse xml file and load into document
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            
             NodeList medecins= doc.getElementsByTagName("medecin");
          for(int i=0;i<medecins.getLength();i++){
              Element medecin=(Element) medecins.item(i);
              String [] e=medecin.getAttribute("idm").split("_");
              System.out.println("Adminpodcast.getpodcasts()"+e[1]);
              podid=Integer.parseInt(e[1]);
              NodeList me= medecin.getElementsByTagName("informationpersonnel");
              Element medec=(Element) me.item(0);
              podtitle=medec.getElementsByTagName("nom").item(0).getTextContent();
              System.out.println("Adminpodcast.getpodcasts()"+podtitle);
              podaut=medec.getElementsByTagName("prenom").item(0).getTextContent();
             NodeList im= medec.getElementsByTagName("img");
             Element ime=(Element) im.item(0);
              imgd=ime.getAttribute("src");
              
              creatpanel(podid, podtitle, podaut, imgd);
          }

            // update Element value
            
            // add new element


        } catch (SAXException | ParserConfigurationException | IOException  e1) {
            e1.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menubarpanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logopanel = new javax.swing.JPanel();
        labellogo = new javax.swing.JLabel();
        sidebarpanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelComments = new javax.swing.JLabel();
        labelPodcasts = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelPodcats = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelComments = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menubarpanel.setBackground(new java.awt.Color(233, 242, 245));
        menubarpanel.setPreferredSize(new java.awt.Dimension(185, 101));
        menubarpanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(233, 242, 245));
        jPanel4.setPreferredSize(new java.awt.Dimension(173, 102));

        jLabel2.setText("      ");
        jPanel4.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("admin    ");
        jPanel4.add(jLabel1);

        menubarpanel.add(jPanel4, java.awt.BorderLayout.LINE_END);

        logopanel.setBackground(new java.awt.Color(233, 242, 245));
        logopanel.setPreferredSize(new java.awt.Dimension(142, 101));
        logopanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labellogo.setPreferredSize(new java.awt.Dimension(80, 80));
        logopanel.add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        menubarpanel.add(logopanel, java.awt.BorderLayout.LINE_START);

        getContentPane().add(menubarpanel, java.awt.BorderLayout.PAGE_START);

        sidebarpanel.setBackground(new java.awt.Color(233, 242, 245));
        sidebarpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(233, 242, 245));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebarpanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 10, 40));

        jPanel7.setBackground(new java.awt.Color(123, 184, 241));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sidebarpanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 10, 40));

        labelComments.setBackground(new java.awt.Color(233, 242, 245));
        labelComments.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelComments.setText("Patients");
        labelComments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCommentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCommentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCommentsMouseExited(evt);
            }
        });
        sidebarpanel.add(labelComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 40));

        labelPodcasts.setBackground(new java.awt.Color(233, 242, 245));
        labelPodcasts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPodcasts.setText("     Medecins");
        labelPodcasts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPodcastsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelPodcastsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelPodcastsMouseExited(evt);
            }
        });
        sidebarpanel.add(labelPodcasts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, 40));

        getContentPane().add(sidebarpanel, java.awt.BorderLayout.LINE_START);

        jPanel9.setPreferredSize(new java.awt.Dimension(841, 413));
        jPanel9.setLayout(new java.awt.CardLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 1001));
        jScrollPane2.setViewportView(panelPodcats);

        panelPodcats.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelPodcats.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        jScrollPane2.setViewportView(panelPodcats);

        jPanel9.add(jScrollPane2, "card2");

        jScrollPane3.setPreferredSize(new java.awt.Dimension(100, 101));
        jScrollPane3.setViewportView(panelComments);

        panelComments.setBackground(new java.awt.Color(255, 255, 255));
        panelComments.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelComments.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane3.setViewportView(panelComments);

        jPanel9.add(jScrollPane3, "card3");

        getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelPodcastsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPodcastsMouseEntered
        // TODO add your handling code here:
        labelPodcasts.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelPodcasts.setBackground(Color.decode("#BEFFFF"));
        labelPodcasts.setOpaque(true);
    }//GEN-LAST:event_labelPodcastsMouseEntered

    private void labelPodcastsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPodcastsMouseExited
        // TODO add your handling code here:
        labelPodcasts.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         labelPodcasts.setBackground(Color.decode("#E9F2F5"));
         labelPodcasts.setOpaque(true);
    }//GEN-LAST:event_labelPodcastsMouseExited

    private void labelCommentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCommentsMouseEntered
        // TODO add your handling code here:
        labelComments.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelComments.setBackground(Color.decode("#BEFFFF"));
        labelComments.setOpaque(true);
    }//GEN-LAST:event_labelCommentsMouseEntered

    private void labelCommentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCommentsMouseExited
        // TODO add your handling code here:
        labelComments.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        labelComments.setBackground(Color.decode("#E9F2F5"));
        labelComments.setOpaque(true);
    }//GEN-LAST:event_labelCommentsMouseExited

    private void labelPodcastsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPodcastsMouseClicked
        // TODO add your handling code here:
        jPanel7.setBackground(Color.decode("#7BB8F1"));
        jPanel6.setBackground(Color.decode("#E9F2F5"));
        panelComments.setVisible(false);
        jScrollPane3.setVisible(false);
        jScrollPane2.setVisible(true);
        panelPodcats.setVisible(true);
    }//GEN-LAST:event_labelPodcastsMouseClicked

    private void labelCommentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCommentsMouseClicked
        // TODO add your handling code here:
        jPanel6.setBackground(Color.decode("#7BB8F1"));
        jPanel7.setBackground(Color.decode("#E9F2F5"));
        panelPodcats.setVisible(false);
        jScrollPane2.setVisible(false);
        jScrollPane3.setVisible(true);
        panelComments.setVisible(true);
    }//GEN-LAST:event_labelCommentsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admindossier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admindossier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admindossier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admindossier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admindossier().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelComments;
    private javax.swing.JLabel labelPodcasts;
    private javax.swing.JLabel labellogo;
    private javax.swing.JPanel logopanel;
    private javax.swing.JPanel menubarpanel;
    private javax.swing.JPanel panelComments;
    private javax.swing.JPanel panelPodcats;
    private javax.swing.JPanel sidebarpanel;
    // End of variables declaration//GEN-END:variables
}
