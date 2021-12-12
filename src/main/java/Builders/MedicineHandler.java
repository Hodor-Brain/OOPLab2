package Builders;

import Medicine.Medicine;
import Xml.MedicineXmlTag;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Class which contains methods to get a set of Medicines.
 */
public class MedicineHandler extends DefaultHandler {
    /**
     * Set of Medicines that is obtained from XML.
     */
    private Set<Medicine> medicines;
    /**
     * Medicine that is being obtaining now.
     */
    private Medicine current;
    /**
     * Medicine's XML tag in which we are now.
     */
    private MedicineXmlTag currentXmlTag;
    /**
     * Enum with all medicine's XML tags.
     */
    private EnumSet<MedicineXmlTag> withText;
    private static final String ELEMENT_MEDICINE = "Medicine";

    public MedicineHandler() {
        medicines = new HashSet<>();
        withText = EnumSet.range(MedicineXmlTag.ID, MedicineXmlTag.REGULARITY);
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_MEDICINE.equals(qName)) {
            current = new Medicine();
            current.setGroup(Medicine.Group.valueOf(attrs.getValue(0)));
        } else {
            MedicineXmlTag temp = MedicineXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_MEDICINE.equals(qName)) {
            medicines.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (current != null)
            current.setParameter(data, currentXmlTag);
        currentXmlTag = null;
    }
}
