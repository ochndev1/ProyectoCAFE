/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.*;

/**
 *
 * @author Hannibal
 */
public class Filter extends Router{
    
    private String condicion;
    private Slots in, out;
    private Document doc;

    public Filter(Document doc, Slots in, Slots out) {
        
        this.doc = doc;
        this.in = in;
        this.out = out;       
        
        
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList)xpath.evaluate(condicionXPATH, doc.getDocumentElement(),XPathConstants.NODOSET);
        for(int i = 0; i < nodes.getLength(); i++){
            Element e = (Element) nodes.item(i);
        }
    }
    
    public void Filtrar (String condicion){
        
    }
    
    
}