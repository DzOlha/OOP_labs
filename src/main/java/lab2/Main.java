package lab2;

import lab2.parsers.Greenhouse;
import lab2.parsers.WorkWithXML;

public class Main {
    public static void main(String[] args)
    {
        String filenamePathXML = "src/main/resources/lab2/plants.xml";
        String filenamePathXSD = "src/main/resources/lab2/plants.xsd";

        WorkWithXML xml = new WorkWithXML(filenamePathXML, filenamePathXSD);

        Greenhouse gh = new Greenhouse();

        gh.loadFromFile(xml);
        gh.printGreenhouse();
    }
}

