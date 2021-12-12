package Builders;

import Medicine.Medicine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that builds the object using DOM parser.
 */
public class MedicinesDomBuilder extends MedicinesSaxBuilder {
    private Set<Medicine> medicines;
    private DocumentBuilder docBuilder;
    public MedicinesDomBuilder(){
        medicines = new HashSet<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void buildSetMedicines(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();

            NodeList medicinesList = root.getElementsByTagName("Medicine");
            for (int i = 0; i < medicinesList.getLength(); i++) {
                Element medicineElement = (Element) medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Medicine buildMedicine(Element medicineElement) {
        return new Medicine(medicineElement);
    }

    public static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
