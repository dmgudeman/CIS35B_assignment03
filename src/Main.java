import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by davidgudeman on 7/22/15.
 */
public class Main
{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException
    {
       testRobotRun();
    }
    public static void testRobotRun() throws IOException, SAXException, ParserConfigurationException, InterruptedException
    {
        LinkedBlockingQueue<String[]> queue = new LinkedBlockingQueue<String[]>();

        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35B_assignment03/src/TestRobotData.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);
        ArrayList<String[]> aList = xmlReader.getArrayList(nodeList);

        System.out.println(queue.size() + "QUEUE SIZE");
        System.out.println(aList.size() + "ALIST SIZE");

        Producer producer = new Producer(queue, aList);
        new Consumer(producer.queue, aList);
    }
    public static void robotRun() throws IOException, SAXException, ParserConfigurationException, InterruptedException
    {
        LinkedBlockingQueue<String[]> queue = new LinkedBlockingQueue<String[]>();

        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35B_assignment03/src/RobotData.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);
        ArrayList<String[]> aList = xmlReader.getArrayList(nodeList);

        System.out.println(queue.size() + " QUEUE SIZE");
        System.out.println(aList.size() + " ALIST SIZE");

        Producer producer = new Producer(queue, aList);
        System.out.println(queue.size() + " QUEUE SIZE after new producer");
        System.out.println(aList.size() + " ALIST SIZE after new producer");

        new Consumer(producer.queue, aList);
    }
}
