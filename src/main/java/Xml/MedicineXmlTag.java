package Xml;

/**
 * Enum that contains all tags' and attributes' names in XML.
 */
public enum MedicineXmlTag {
    MEDICINES("Medicines"),
    MEDICINE("Medicine"),
    ID("id"),
    NAME("name"),
    PHARM("pharm"),
    GROUP("group"),
    ANALOGS("analogs"),
    CONSISTENCE("consistence"),
    NUMBER("number"),
    ISSUANCEDATE("issuanceDate"),
    EXPIRATIONDATE("expirationDate"),
    ORGANISATION("organisation"),
    TYPE("type"),
    QUANTITY("quantity"),
    PRICE("price"),
    DOSE("dose"),
    REGULARITY("regularity"),
    VERSION("version"),
    CERTIFICATE("certificate"),
    PACKAGE("package"),
    DOSAGE("dosage");
    private String value;
    MedicineXmlTag(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
