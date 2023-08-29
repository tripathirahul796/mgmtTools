package Environment;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class EnvironmentObj {
    public EnvironmentObj()
    {

    }

    public void readConfig() {
        try {
            File file = new File("E:\\JavaProj\\ManagementTools\\config.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
