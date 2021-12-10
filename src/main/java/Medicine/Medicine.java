package Medicine;

import Xml.MedicineXmlTag;

import java.time.LocalDate;
import java.util.Objects;

/** Represents a Medicine.
 * @author Ruslan Volchetskiy
 */

public class Medicine implements Comparable<Medicine>{
    /**
     * Represents Medicine's unique ID.
     */
    private String id;
    /**
     * Represents the name of Medicine.
     */
    private String name;
    /**
     * Represents the producer of the medicine.
     */
    private String pharm;
    /**
     * Represents the specific group of medication to which this medicine belongs.
     */
    private Group group;
    /**
     * All available analogs of this medicine.
     */
    private String analogs;
    /**
     * Full description of current medicine with all parameters.
     */
    private Version version = new Version();

    public Medicine() {
    }

    public Medicine(String def){
        this.id = "A1";
        this.name = "Default";
        this.pharm = "Default";
        this.group = Group.ANTIBIOTIC;
        this.analogs = "None";
        this.version = new Version(def);
    }

    /**
     * Creates a medicine with all specified parameters.
     * @param id Medicine's id.
     * @param name Medicine's name.
     * @param pharm Medicine's producer.
     * @param group Medicine's group of medication.
     * @param analogs Medicine's analogs.
     * @param version Medicine's full version.
     */
    public Medicine(String id, String name, String pharm, Group group, String analogs, Version version) {
        this.id = id;
        this.name = name;
        this.pharm = pharm;
        this.group = group;
        this.analogs = analogs;
        this.version = version;
    }

    /**
     * Gets Medicine's id.
     * @return A string containing medicine's id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets Medicine's name.
     * @return A string containing medicine's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Medicine's producer.
     * @return A string containing medicine's producer name.
     */
    public String getPharm() {
        return pharm;
    }

    /**
     * Gets Medicine's group.
     * @return An enum object representing medicine's group name.
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Gets Medicine's analogs.
     * @return A string containing medicine's all analogs.
     */
    public String getAnalogs() {
        return analogs;
    }

    /**
     * Gets Medicine's version.
     * @return A class containing medicine's full version.
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the Medicine's id.
     * @param id A string containing the medicine's id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets Medicine's name.
     * @param name A string containing the medicine's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets Medicine's producer.
     * @param pharm A string containing the medicine's producer name.
     */
    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    /**
     * Sets Medicine's group.
     * @param group An enum object representing the medicine's group name.
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Sets Medicine's analogs.
     * @param analogs A string containing the medicine's all analogs.
     */
    public void setAnalogs(String analogs) {
        this.analogs = analogs;
    }

    /**
     * Sets Medicine's version.
     * @param version A class containing full description about the medicine.
     */
    public void setVersion(Version version) {
        this.version = version;
    }

    /**
     * Inner class containing full info about the version of medicine.
     */
    public class Version{
        /**
         * Representing consistence of the medicine.
         */
        private String consistence;
        /**
         * Representing official certificate of medicine.
         */
        private Certificate certificate = new Certificate();
        /**
         * Representing info about package of medicine.
         */
        private Package pack = new Package();
        /**
         * Representing the recommended dosage for adult per day.
         */
        private Dosage dosage = new Dosage();

        public Version() {
        }

        public Version(String def){
            this.consistence = "Default";
            this.certificate = new Certificate(def);
            this.dosage = new Dosage(def);
            this.pack = new Package(def);
        }

        /**
         * Creates a version with specified parameters.
         * @param consistence Medicine's consistence.
         * @param certificate Official certificate.
         * @param pack Medicine's package.
         * @param dosage Recommended dosage.
         */
        public Version(String consistence, Certificate certificate, Package pack, Dosage dosage) {
            this.consistence = consistence;
            this.certificate = certificate;
            this.pack = pack;
            this.dosage = dosage;
        }

        /**
         * Gets medicine's consistence.
         * @return A string containing the consistence.
         */
        public String getConsistence() { return consistence; }

        /**
         * Gets official certificate.
         * @return A class containing the full info about certificate.
         */
        public Certificate getCertificate() {
            return certificate;
        }

        /**
         * Gets medicine's package.
         * @return A class containing the info about package.
         */
        public Package getPack() {
            return pack;
        }

        /**
         * Gets recommended dosage.
         * @return A class containing the recommended dosage.
         */
        public Dosage getDosage() {
            return dosage;
        }

        /**
         * Sets medicine's consistence.
         * @param consistence A String containing the consistence type.
         */
        public void setConsistence(String consistence) { this.consistence = consistence; }

        /**
         * Sets medicine's official certificate.
         * @param certificate A class containing the all info about certificate.
         */
        public void setCertificate(Certificate certificate) {
            this.certificate = certificate;
        }

        /**
         * Sets medicine's package.
         * @param pack A class containing package info.
         */
        public void setPack(Package pack) {
            this.pack = pack;
        }

        /**
         * Sets medicine's dosage.
         * @param dosage A class containing recommended dosage info.
         */
        public void setDosage(Dosage dosage) {
            this.dosage = dosage;
        }

        /**
         * Inner class containing the full certificate description.
         */
        public class Certificate{
            /**
             * Certificate number.
             */
            private String number;
            /**
             * The certificate's date of issuance.
             */
            private LocalDate issuanceDate;
            /**
             * The certificate's expiration date.
             */
            private LocalDate expirationDate;
            /**
             * The name of the registering organisation.
             */
            private String organisation;

            public Certificate() {
            }

            public Certificate(String def){
                this.number = "AAAA";
                this.issuanceDate = LocalDate.of(2021, 1, 1);
                this.expirationDate = LocalDate.of(2021, 1, 1);
                this.organisation = "Default";
            }

            /**
             * Creates a certificate with specified parameters.
             * @param number Certificate's number.
             * @param issuanceDate Certificate's issuance date.
             * @param expirationDate Certificate's expiration date.
             * @param organisation Certificate's registering organisation.
             */
            public Certificate(String number, LocalDate issuanceDate, LocalDate expirationDate, String organisation) {
                this.number = number;
                this.issuanceDate = issuanceDate;
                this.expirationDate = expirationDate;
                this.organisation = organisation;
            }

            /**
             * Gets certificate's number.
             * @return A string containing certificate's number.
             */
            public String getNumber() {
                return number;
            }

            /**
             * Gets certificate's issuance date.
             * @return A LocalDate object containing the issuance date.
             */
            public LocalDate getIssuanceDate() {
                return issuanceDate;
            }

            /**
             * Gets certificate's expiration date.
             * @return A LocalDate object containing the expiration date.
             */
            public LocalDate getExpirationDate() {
                return expirationDate;
            }

            /**
             * Gets registering organisation.
             * @return A string containing the certificate's registering organisation.
             */
            public String getOrganisation() {
                return organisation;
            }

            /**
             * Sets a certificate's number.
             * @param number A string containing certificate's number.
             */
            public void setNumber(String number) {
                this.number = number;
            }

            /**
             * Sets a certificate's issuance date.
             * @param issuanceDate A LocalDate object containing issuance date.
             */
            public void setIssuanceDate(LocalDate issuanceDate) {
                this.issuanceDate = issuanceDate;
            }

            /**
             * Sets a certificate's expiration date.
             * @param expirationDate A LocalDate object containing expiration date.
             */
            public void setExpirationDate(LocalDate expirationDate) {
                this.expirationDate = expirationDate;
            }

            /**
             * Sets a certificate's registering organisation.
             * @param organisation A String containing the registering organisation.
             */
            public void setOrganisation(String organisation) {
                this.organisation = organisation;
            }

            public String toString(){
                final StringBuilder sb = new StringBuilder("\n\tCertificate:\n\t\tNumber: ");
                sb.append(number).append("\n\t\tDate of issuance: ").append(issuanceDate);
                sb.append("\n\t\tExpiration date: ").append(expirationDate).append("\n\t\tOrganisation: ");
                sb.append(organisation);
                return sb.toString();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }

                if (!(obj instanceof Certificate anotherCertificate)) {
                    return false;
                }

                return number.equals(anotherCertificate.number) && issuanceDate.equals(anotherCertificate.issuanceDate) && expirationDate.equals(anotherCertificate.expirationDate) && organisation.equals(anotherCertificate.organisation);
            }
        }

        /**
         * Inner class containing full info about medicine's package.
         */
        public class Package{
            /**
             * Type of package.
             */
            private String type;
            /**
             * Amount of drugs in a single pack.
             */
            private int quantity;
            /**
             * Price for a single pack.
             */
            private float price;

            public Package() {
            }

            public Package(String def){
                this.type = "Plastic";
                this.price = 100f;
                this.quantity = 10;
            }

            /**
             * Creates a package with a specified parameters.
             * @param type Package's type.
             * @param quantity Amount of drugs in package.
             * @param price Price for package.
             */
            public Package(String type, int quantity, float price) {
                this.type = type;
                this.quantity = quantity;
                this.price = price;
            }

            /**
             * Gets a type of package.
             * @return A string containing type of package.
             */
            public String getType() {
                return type;
            }

            /**
             * Gets a quantity of drugs.
             * @return An integer representing amount of drugs.
             */
            public int getQuantity() {
                return quantity;
            }

            /**
             * Gets a price of single package.
             * @return A float representing the price of package.
             */
            public float getPrice() {
                return price;
            }

            /**
             * Sets a type of package.
             * @param type A string containing the type of package.
             */
            public void setType(String type) {
                this.type = type;
            }

            /**
             * Sets a quantity of drugs in a single package.
             * @param quantity An integer representing a quantity of drugs in a single package.
             */
            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            /**
             * Sets a price for a package.
             * @param price A float representing a price of package.
             */
            public void setPrice(float price) {
                this.price = price;
            }

            public String toString(){
                final StringBuilder sb = new StringBuilder("\n\tPackage:\n\t\tType: ");
                sb.append(type).append("\n\t\tQuantity: ").append(quantity);
                sb.append("\n\t\tPrice: ").append(price);
                return sb.toString();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }

                if (!(obj instanceof Package anotherPackage)) {
                    return false;
                }

                return type.equals(anotherPackage.type) && quantity == anotherPackage.quantity && price - anotherPackage.price < 1e-4;
            }
        }

        /**
         * Inner class containing the recommended dosage for adult per day.
         */
        public class Dosage{
            /**
             * Dose of medicine per single taking (in ml).
             */
            private float dose;
            /**
             * Recommended number of times to take medicine per day.
             */
            private int regularity;

            public Dosage() {
            }

            public Dosage(String def){
                this.dose = 1f;
                this.regularity = 1;
            }

            /**
             * Creates a dosage with a specified parameters.
             * @param dose Dose per single taking.
             * @param regularity Frequency of taking per day.
             */
            public Dosage(float dose, int regularity) {
                this.dose = dose;
                this.regularity = regularity;
            }

            /**
             * Gets a recommended dose per taking.
             * @return A float representing dose per taking.
             */
            public float getDose() {
                return dose;
            }

            /**
             * Gets a recommended regularity of taking medicines per day.
             * @return An integer representing times per day to take medicines.
             */
            public int getRegularity() {
                return regularity;
            }

            /**
             * Sets a dose per taking.
             * @param dose A float containing the dose per taking.
             */
            public void setDose(float dose) {
                this.dose = dose;
            }

            /**
             * Sets regularity of taking per day.
             * @param regularity An integer containing the number of taking medicines per day.
             */
            public void setRegularity(int regularity) {
                this.regularity = regularity;
            }

            public String toString(){
                final StringBuilder sb = new StringBuilder("\n\tDosage:\n\t\tDosage: ");
                sb.append(dose).append("\n\t\tRegularity: ").append(regularity);
                return sb.toString();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }

                if (!(obj instanceof Dosage anotherDosage)) {
                    return false;
                }

                return dose - anotherDosage.dose < 1e-4 && regularity == anotherDosage.regularity;
            }
        }

        public String toString(){
            final StringBuilder sb = new StringBuilder("\nVersion: ");
            sb.append("\n\tConsistence: ").append(consistence).append(certificate).append(pack).append(dosage);
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Version anotherVersion)) {
                return false;
            }

            return consistence.equals(anotherVersion.consistence) && certificate.equals(anotherVersion.certificate) && pack.equals(anotherVersion.pack) && dosage.equals(anotherVersion.dosage);
        }
    }

    @Override
    public int compareTo(Medicine o) {
        return id.compareTo(o.id);
    }

    public String toString(){
        final StringBuilder sb = new StringBuilder("\nId: ");
        sb.append(id).append("\nName: ");
        sb.append(name).append("\nPharm: ").append(pharm);
        sb.append("\nGroup: ").append(group);
        sb.append("\nAnalogs: ").append(analogs).append(version);
        sb.append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Medicine anotherMedicine)) {
            return false;
        }

        return id.equals(anotherMedicine.id) && name.equals(anotherMedicine.name) && group.equals(anotherMedicine.group) && pharm.equals(anotherMedicine.pharm) && analogs.equals(anotherMedicine.analogs) && version.equals(anotherMedicine.version);
    }

    /**
     * An enum representing all available types of groups for medicine.
     */
    public enum Group {
        ANTIBIOTIC,
        PAINKILLER,
        VITAMIN
    }

    /**
     * A method which initiates some medicine's field by given value and XML tag.
     * @param value A string containing the value of field.
     * @param currentXmlTag A XML tag representing a field to initiate.
     */
    public void initiateField(String value, MedicineXmlTag currentXmlTag){
        if(currentXmlTag!=null) {
            switch (currentXmlTag) {
                case ID -> setId(value);
                case NAME -> setName(value);
                case GROUP -> setGroup(Group.valueOf(value));
                case PHARM -> setPharm(value);
                case ANALOGS -> setAnalogs(value);
                case CONSISTENCE -> getVersion().setConsistence(value);
                case NUMBER -> getVersion().getCertificate().setNumber(value);
                case ISSUANCEDATE -> getVersion().getCertificate().setIssuanceDate(LocalDate.parse(value));
                case EXPIRATIONDATE -> getVersion().getCertificate().setExpirationDate(LocalDate.parse(value));
                case ORGANISATION -> getVersion().getCertificate().setOrganisation(value);
                case TYPE -> getVersion().getPack().setType(value);
                case QUANTITY -> getVersion().getPack().setQuantity(Integer.parseInt(value));
                case PRICE -> getVersion().getPack().setPrice(Float.parseFloat(value));
                case DOSE -> getVersion().getDosage().setDose(Float.parseFloat(value));
                case REGULARITY -> getVersion().getDosage().setRegularity(Integer.parseInt(value));
                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
    }
}
