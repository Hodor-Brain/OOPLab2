package Builders;

import Medicine.Medicine;
import Xml.MedicineXmlTag;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that builds the object using STAX parser.
 */
public class MedicinesStaxBuilder extends AbstractMedicinesBuilder {
    private Set<Medicine> medicines;
    private XMLInputFactory inputFactory;

    public MedicinesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        medicines = new HashSet<Medicine>();
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void buildSetMedicines(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(MedicineXmlTag.MEDICINE.getValue())) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Medicine buildMedicine(XMLStreamReader reader)
            throws XMLStreamException {
        Medicine medicine = new Medicine();
        medicine.setGroup(Medicine.Group.valueOf(reader.getAttributeValue(null, MedicineXmlTag.GROUP.getValue())));

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase())) {
                        case VERSION -> medicine.setVersion(getXMLVersion(reader));
                        default -> medicine.setParameter(getXMLText(reader), MedicineXmlTag.valueOf(name.toUpperCase()));
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.MEDICINE) {
                        return medicine;
                    }
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag <medicine>");
    }

    private Medicine.Version getXMLVersion(XMLStreamReader reader)
            throws XMLStreamException {
        Medicine medicine = new Medicine();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineXmlTag.valueOf(name.toUpperCase())) {
                        case CERTIFICATE -> medicine.getVersion().setCertificate(getXMLCertificate(reader));
                        case PACKAGE -> medicine.getVersion().setPack(getXMLPackage(reader));
                        case DOSAGE -> medicine.getVersion().setDosage(getXMLDosage(reader));
                        default -> medicine.setParameter(getXMLText(reader), MedicineXmlTag.valueOf(name.toUpperCase()));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.VERSION) {
                        return medicine.getVersion();
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <version>");
    }

    private Medicine.Version.Certificate getXMLCertificate(XMLStreamReader reader)
            throws XMLStreamException {
        Medicine medicine = new Medicine();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    medicine.setParameter(getXMLText(reader), MedicineXmlTag.valueOf(name.toUpperCase()));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.CERTIFICATE) {
                        return medicine.getVersion().getCertificate();
                    }
            }
        }
        throw new
                XMLStreamException("Unknown element in tag <certificate>");
    }

    private Medicine.Version.Package getXMLPackage(XMLStreamReader reader)
            throws XMLStreamException {
        Medicine medicine = new Medicine();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    medicine.setParameter(getXMLText(reader), MedicineXmlTag.valueOf(name.toUpperCase()));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.PACKAGE) {
                        return medicine.getVersion().getPack();
                    }
            }
        }
        throw new
                XMLStreamException("Unknown element in tag <package>");
    }

    private Medicine.Version.Dosage getXMLDosage(XMLStreamReader reader)
            throws XMLStreamException {
        Medicine medicine = new Medicine();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    medicine.setParameter(getXMLText(reader), MedicineXmlTag.valueOf(name.toUpperCase()));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.DOSAGE) {
                        return medicine.getVersion().getDosage();
                    }
            }
        }
        throw new
                XMLStreamException("Unknown element in tag <dosage>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
