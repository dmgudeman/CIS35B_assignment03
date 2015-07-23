import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by davidgudeman on 7/22/15.
 */
public class Main
{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35B_assignment03/src/RobotData.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);
        xmlReader.showNodeList(nodeList);
       // ArrayList<Double[]> aList = xmlReader.getArrayList(nodeList);
    }
}
