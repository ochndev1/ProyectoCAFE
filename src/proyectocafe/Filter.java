/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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

    public Filter(){
        
    }
    
    public Filter(Document doc, Slots in, Slots out) {
        
        this.doc = doc;
        this.in = in;
        this.out = out;       
        
        
//        XPath xpath = XPathFactory.newInstance().newXPath();
//        NodeList nodes = (NodeList)xpath.evaluate(condicionXPATH, doc.getDocumentElement(),XPathConstants.NODOSET);
//        for(int i = 0; i < nodes.getLength(); i++){
//            Element e = (Element) nodes.item(i);
//        }
    }
    
    public void Filtrar (Document doc, String condicion){
        Document Docfiltrado;
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Docfiltrado = dBuilder.newDocument();
            
            //Preparacion para crear el nuevo documento con los datos filtrados
            //Elemento raiz cafe_order
            Element rootElement = Docfiltrado.createElement("cafe_order");
            Docfiltrado.appendChild(rootElement);
            
            //Elemento order_id
            Element order_id = Docfiltrado.createElement("order_id");
            order_id.appendChild(Docfiltrado.createTextNode("2"));
            rootElement.appendChild(order_id);
            
            
            //Elemento drinks
            Element drinksElement = Docfiltrado.createElement("drinks");
            rootElement.appendChild(drinksElement);
            
            //Elemento drink
            Element drinkElement = Docfiltrado.createElement("drink");
            rootElement.appendChild(drinkElement);
            
            //Comprobacion
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(Docfiltrado);
            
            //Testing por fichero
            StreamResult Result = new StreamResult(new File("src/FicheroSalida/FicherodePrueba.xml"));
            transformer.transform(source, Result);
            
            
            //Carga los nodos del documento doc para recorrerlo
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("drink");
            
            System.out.println("----------------------------");
            
            //Recorremos la lista de nodo con la etiqueta drink del xml
            for (int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                
                //Borrar despues
                System.out.println("\nSiguiente elemento: ");
                System.out.println(nNode.getNodeName());
                //-------------------------------------
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

  
                    //Obtenemos el nodo name del xml
                    NodeList nameList = eElement.getElementsByTagName("name");
                    
                    Node node1 = nameList.item(0);
                    
                    if (node1.getNodeType() == node1.ELEMENT_NODE) {
                        Element bebida = (Element) node1;
                        System.out.print("Bebidas: ");
                        System.out.println(bebida.getTextContent());
                    }  
                    
                    //Obtenemos el nodo type del xml
                    NodeList typeList = eElement.getElementsByTagName("type");
                    
                    Node nodetype = typeList.item(0);
                    
                    if (nodetype.getNodeType() == nodetype.ELEMENT_NODE) {
                        Element bebida = (Element) nodetype;
                        System.out.print("Tipo: ");
                        System.out.println(bebida.getTextContent());
                    }                    

                }
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Slots getIn() {
        return in;
    }

    public void setIn(Slots in) {
        this.in = in;
    }

    public Slots getOut() {
        return out;
    }

    public void setOut(Slots out) {
        this.out = out;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
    
}