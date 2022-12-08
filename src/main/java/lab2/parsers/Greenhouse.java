package lab2.parsers;

import lab2.models.Flower;
import lab2.models.GrowingTips;
import lab2.models.VisualParameters;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Greenhouse {
    private ArrayList<Flower> flowers;
    public void loadFromFile(WorkWithXML xml){
        //flowers = new ArrayList<>();
        Element root = xml.loadRootFromXML();
        if (root.getTagName().equals("Greenhouse"))
        {
            NodeList listFlowers = root.getElementsByTagName("Flower");
            int countOfFlowers = listFlowers.getLength();
            Flower tmpFlower = null;
            for (int i = 0; i < countOfFlowers; i++)
            {
                Element flower = (Element) listFlowers.item(i);
                String flowerCode = flower.getAttribute("id");
                String flowerName = flower.getAttribute("name");
                String flowerOrigin = flower.getAttribute("origin");
                tmpFlower = new Flower(Integer.parseInt(flowerCode), flowerName, flowerOrigin);
                //flowers.add();

                NodeList soil = flower.getElementsByTagName("Soil");

                tmpFlower.setSoil(soil.item(0).getTextContent());

                //set visual parameters
                NodeList VP = flower.getElementsByTagName("VisualParameters");
                Element vp = (Element) VP.item(0);
                    String stemColor = vp.getElementsByTagName("stemColor").item(0).getTextContent();
                    String leafColor = vp.getElementsByTagName("leafColor").item(0).getTextContent();
                    String color = vp.getElementsByTagName("color").item(0).getTextContent();
                    tmpFlower.setVisual(new VisualParameters(stemColor, leafColor, color));

                //set growing tips
                NodeList GT = flower.getElementsByTagName("GrowingTips");
                Element gt = (Element) GT.item(0);
                String temperature = gt.getElementsByTagName("temperature").item(0).getTextContent();
                String is_lightingRequire = gt.getElementsByTagName("is_lightingRequire").item(0).getTextContent();
                String watering = gt.getElementsByTagName("watering").item(0).getTextContent();
                tmpFlower.setTips(new GrowingTips(Double.parseDouble(temperature),
                        Boolean.parseBoolean(is_lightingRequire),
                        Double.parseDouble(watering)));

                Node propagation = flower.getElementsByTagName("Propagation").item(0);
                tmpFlower.setPropagation(propagation.getTextContent());
                flowers.add(tmpFlower);
            }
        }
    }
    public Greenhouse(){
        flowers = new ArrayList<>();
    }
    public void printGreenhouse(){
        int countOfFlowers = flowers.size();
        Flower tmpFlower = null;
        String lessonType = "";
        for(int i = 0; i < countOfFlowers; i++)
        {
            tmpFlower = flowers.get(i);
            System.out.println("\n Id: " + tmpFlower.getId());
            System.out.println(" Name: "+ tmpFlower.getName() + "");
            System.out.println(" Origin: " + tmpFlower.getOrigin() + "");
            System.out.println(" Soil: " + tmpFlower.getSoil() + "");
            System.out.println(" VisualParameters: ");
            System.out.println("   stemColor = " + tmpFlower.getVisual().stemColor + "");
            System.out.println("   leafColor = " + tmpFlower.getVisual().leafColor + "");
            System.out.println("   color = " + tmpFlower.getVisual().color + "");
            System.out.println(" GrowingTips" +  ": ");
            System.out.println("   temperature = " + tmpFlower.getTips().temperature);
            System.out.println("   is_lightingRequire = " + tmpFlower.getTips().is_lightingRequire);
            System.out.println("   watering = " + tmpFlower.getTips().watering);
            System.out.println(" Propagation: " + tmpFlower.getPropagation() + "\n");
        }
    }
}