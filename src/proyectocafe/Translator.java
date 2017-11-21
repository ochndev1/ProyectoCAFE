/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hannibal
 */
public class Translator extends Transformer {
    private ArrayList<Bebida> listBebida;
    
    public Translator(){
        
    }
    
    //Se le pasa un documento xml y devuelve un arraylist de bebidas
    public ArrayList<Bebida> traductor (Document doc) {
        
        //Carga los nodos del documento doc para recorrerlo
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("drink");

        //Inicializa el arraylist
        this.listBebida = new ArrayList(nList.getLength());
        
        System.out.println("----------------------------");

        //Recorremos la lista de nodo con la etiqueta drink del xml
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            //Creo el objeto bebida
            Bebida bebidas = new Bebida();

            //Borrar despues
            System.out.println("\nSiguiente elemento: ");
            System.out.println(nNode.getNodeName());
            //-------------------------------------

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                //Obtenemos el nodo name del xml
                NodeList nameList = eElement.getElementsByTagName("name");

                Node node1 = nameList.item(0);

                Element bebida = null;

                if (node1.getNodeType() == node1.ELEMENT_NODE) {
                    bebida = (Element) node1;
                    System.out.print("Bebidas: ");
                    System.out.println(bebida.getTextContent());
                    bebidas.nombre = bebida.getTextContent();
                }

                //Obtenemos el nodo type del xml
                NodeList typeList = eElement.getElementsByTagName("type");

                Node nodetype = typeList.item(0);

                if (nodetype.getNodeType() == nodetype.ELEMENT_NODE) {
                    Element bebidaTipo = (Element) nodetype;
                    System.out.print("Tipo: ");
                    System.out.println(bebidaTipo.getTextContent());
                    bebidas.tipo = bebidaTipo.getTextContent();
                }

            }
            this.listBebida.add(bebidas);
        }
        
        return this.listBebida;
    }
}
