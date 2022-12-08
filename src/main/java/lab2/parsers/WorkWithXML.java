package lab2.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class WorkWithXML {
    private String filenamePathXML;
    private String filenamePathXSD = "";

    public String getFilenamePathXML() {
        return filenamePathXML;
    }

    public String getFilenamePathXSD() {
        return filenamePathXSD;
    }

    public void setFilenamePathXML(String filenamePathXML) {
        this.filenamePathXML = filenamePathXML;
    }

    public void setFilenamePathXSD(String filenamePathXSD) {
        this.filenamePathXSD = filenamePathXSD;
    }

    public WorkWithXML(String filenamePathXML) {
        this.filenamePathXML = filenamePathXML;
    }

    public WorkWithXML(String filenamePathXML, String filenamePathXSD) {
        this.filenamePathXML = filenamePathXML;
        this.filenamePathXSD = filenamePathXSD;
        validationByXSD();
        System.out.println("XML file is validated successfully!");
    }

    public void validationByXSD() {
        // create schema factory
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // create schema from XSD file
        Schema s = null;
        try {
            s = sf.newSchema(new File(filenamePathXSD));
        } catch (SAXException exp) {
        }

        // create parser factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);

        // bind schema to the parser factory
        dbf.setSchema(s);

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
        }
        db.setErrorHandler(new CustomErrorHandler());

        Document doc = null;
        try {
            doc = db.parse(new File(filenamePathXML));
        } catch (SAXException saxException) {
        } catch (IOException ioException) {
        }
    }

    public Element loadRootFromXML() {
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = db.parse(new File(filenamePathXML));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.getDocumentElement();
    }
}
