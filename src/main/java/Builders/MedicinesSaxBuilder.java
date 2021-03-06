package Builders;

import Medicine.Medicine;
import Medicine.MedicineErrorHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Set;

/**
 * Class that builds the object using SAX parser.
 */
public class MedicinesSaxBuilder extends AbstractMedicinesBuilder {
    private Set<Medicine> medicines;
    private MedicineHandler handler;
    private XMLReader reader;

    public MedicinesSaxBuilder(){
        handler = new MedicineHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setErrorHandler(new MedicineErrorHandler());
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void buildSetMedicines(String filename) {
        try {
            reader.parse(filename);
            medicines = handler.getMedicines();
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
}
