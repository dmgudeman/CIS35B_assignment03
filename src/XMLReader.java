
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The input functions of the program. The readXML method takes a text xml
 * file and returns a document of nodes.
 *
 * The GetNodes method makes the nodes available
 * Created by davidgudeman on 7/9/15.
 */

/**
 * Takes a string name of a xml text file can return a Nodelist
 */

public class XMLReader
{

    public Document doc;
    public String sfile;

    public XMLReader(String sfile) throws ParserConfigurationException, IOException, SAXException
    {
        this.sfile = sfile;
    }

    // takes in xml file parses it into nodes
    public Document ReadXML() throws ParserConfigurationException, IOException, SAXException
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(sfile);

            doc.getDocumentElement().normalize();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return doc;
    }

    // allow for retreval of the nodes
    public NodeList GetNodes(Document doc)
    {
        NodeList nList = doc.getElementsByTagName("command");
        for (int i = 0; i < nList.getLength(); i++)
        {
            Node child = nList.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;
            }
        }
        return nList;
    }


    public void showNodeList(NodeList nodeList)
    {
        int j = 0;
        try
        {
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node child = nodeList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element eElement = (Element) child;

                    System.out.println("Command number: " + i);
                    System.out.println("robot: " + eElement.getElementsByTagName("robot").item(0).getTextContent());
                    System.out.println("offon: " + eElement.getElementsByTagName("offon").item(0).getTextContent());
                    System.out.println("speed: " + eElement.getElementsByTagName("speed").item(0).getTextContent());
                    System.out.println("horizontal: " + eElement.getElementsByTagName("horizontal").item(0).getTextContent());
                    System.out.println("vertical: " + eElement.getElementsByTagName("vertical").item(0).getTextContent());
                    System.out.println("time: " + eElement.getElementsByTagName("time").item(0).getTextContent());
                    System.out.println("\n");
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void showArrayList(ArrayList<Node> list)

    {
        try
        {
            for (int i = 0; i < list.size(); i++)
            {
                Node child = list.get(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;

                    System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    System.out.println("Longitude : " + eElement.getElementsByTagName("Longitude").item(0).getTextContent());
                    System.out.println("City : " + eElement.getElementsByTagName("City").item(0).getTextContent());
                    System.out.println("State : " + eElement.getElementsByTagName("State").item(0).getTextContent());
                    System.out.println("\n");
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void showNode(NodeList nodeList, int index, String tagname)
    {
        try
        {
            Node child = nodeList.item(index);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;
                if (eElement.getElementsByTagName(tagname) != null)

                    System.out.println(tagname + " : " + eElement.getElementsByTagName(tagname).item(0).getTextContent());
            }

            System.out.println("------------*****************----------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}






