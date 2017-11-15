/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author usuario
 */
public class ControladorXML {
    private String inputFile;

    public ControladorXML(String inputFile) {
        this.inputFile = inputFile;
    }
    
    public Document LeerXML(){
        Document doc;
        
        try {
            File inputFile = new File(this.inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(inputFile);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        
        
        return doc;
    }
    
    public void EscribirXML(Document doc) {
        
    }
}
