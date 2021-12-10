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
import java.time.LocalDate;
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
        // configuration
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // log
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
            // getting a list of <Medicine> child elements
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
        Medicine medicine = new Medicine();

        medicine.setGroup(Medicine.Group.valueOf(medicineElement.getAttribute("group")));
        medicine.setId(getElementTextContent(medicineElement, "id"));
        medicine.setName(getElementTextContent(medicineElement, "name"));
        medicine.setPharm(getElementTextContent(medicineElement, "pharm"));
        medicine.setAnalogs(getElementTextContent(medicineElement, "analogs"));

        Medicine.Version version = medicine.getVersion();
        Element versionElement =
                (Element) medicineElement.getElementsByTagName("version").item(0);

        version.setConsistence(getElementTextContent(versionElement, "consistence"));

        Medicine.Version.Certificate certificate = medicine.getVersion().getCertificate();
        Element certificateElement = (Element) versionElement.getElementsByTagName("certificate").item(0);

        certificate.setNumber(getElementTextContent(certificateElement, "number"));
        certificate.setIssuanceDate(LocalDate.parse(getElementTextContent(certificateElement, "issuanceDate")));
        certificate.setExpirationDate(LocalDate.parse(getElementTextContent(certificateElement, "expirationDate")));
        certificate.setOrganisation(getElementTextContent(certificateElement, "organisation"));

        Medicine.Version.Package pack = medicine.getVersion().getPack();
        Element packageElement = (Element) versionElement.getElementsByTagName("package").item(0);
        pack.setType(getElementTextContent(packageElement, "type"));
        pack.setPrice(Float.parseFloat(getElementTextContent(packageElement, "price")));
        pack.setQuantity(Integer.parseInt(getElementTextContent(packageElement, "quantity")));

        Medicine.Version.Dosage dosage = medicine.getVersion().getDosage();
        Element dosageElement = (Element) versionElement.getElementsByTagName("dosage").item(0);
        dosage.setDose(Float.parseFloat(getElementTextContent(dosageElement, "dose")));
        dosage.setRegularity(Integer.parseInt(getElementTextContent(dosageElement, "regularity")));

        return medicine;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
