import Medicine.Medicine;
import Medicine.MedicineComparator;
import Builders.AbstractMedicinesBuilder;
import Builders.MedicineBuilderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class MedicineTest {
    private static final Logger log = Logger.getLogger(MedicineTest.class.getName());

    @Test
    public void singleMedicineTest() {
        String type = "stax";
        AbstractMedicinesBuilder builder = MedicineBuilderFactory.createMedicineBuilder(type);
        builder.buildSetMedicines("src/main/java/Xml/medicines.xml");

        Set<Medicine> medicines = builder.getMedicines();

        Medicine medicine = new Medicine();
        medicine.setId("A2");
        medicine.setName("Magne-B6");
        medicine.setPharm("VitToHuman");
        medicine.setAnalogs("Magnemax");
        medicine.setGroup(Medicine.Group.VITAMIN);
        medicine.getVersion().setConsistence("Powder");
        medicine.getVersion().getCertificate().setNumber("7C2D");
        medicine.getVersion().getCertificate().setIssuanceDate(LocalDate.of(2020, 9, 19));
        medicine.getVersion().getCertificate().setExpirationDate(LocalDate.of(2023, 9, 19));
        medicine.getVersion().getCertificate().setOrganisation("BioNTech");
        medicine.getVersion().getPack().setType("Glass");
        medicine.getVersion().getPack().setQuantity(40);
        medicine.getVersion().getPack().setPrice(246.5f);
        medicine.getVersion().getDosage().setDose(1.5f);
        medicine.getVersion().getDosage().setRegularity(1);


        List<Medicine> medicineArray = new ArrayList<>(medicines);
        medicineArray.sort(new MedicineComparator());

        Medicine medicineToCompare = medicineArray.get(1);
        Assert.assertEquals(medicineToCompare, medicine);
        Assert.assertEquals(medicineToCompare.getId(), medicine.getId());
        Assert.assertEquals(medicineToCompare.getName(), medicine.getName());
        Assert.assertEquals(medicineToCompare.getGroup(), medicine.getGroup());
        Assert.assertEquals(medicineToCompare.getAnalogs(), medicine.getAnalogs());
        Assert.assertEquals(medicineToCompare.getPharm(), medicine.getPharm());
        Assert.assertEquals(medicineToCompare.getVersion(), medicine.getVersion());
    }

    @Test
    public void arrayTest() throws InterruptedException {
        String type = "stax";
        AbstractMedicinesBuilder builder = MedicineBuilderFactory.createMedicineBuilder(type);
        builder.buildSetMedicines("src/main/java/Xml/medicines.xml");

        Set<Medicine> medicines = builder.getMedicines();

        Medicine medicine = new Medicine();
        medicine.setId("A2");
        medicine.setName("Magne-B6");
        medicine.setPharm("VitToHuman");
        medicine.setAnalogs("Magnemax");
        medicine.setGroup(Medicine.Group.VITAMIN);
        medicine.getVersion().setConsistence("Powder");
        medicine.getVersion().getCertificate().setNumber("7C2D");
        medicine.getVersion().getCertificate().setIssuanceDate(LocalDate.of(2020, 9, 19));
        medicine.getVersion().getCertificate().setExpirationDate(LocalDate.of(2023, 9, 19));
        medicine.getVersion().getCertificate().setOrganisation("BioNTech");
        medicine.getVersion().getPack().setType("Glass");
        medicine.getVersion().getPack().setQuantity(40);
        medicine.getVersion().getPack().setPrice(246.5f);
        medicine.getVersion().getDosage().setDose(1.5f);
        medicine.getVersion().getDosage().setRegularity(1);

        Medicine anotherMedicine = new Medicine();
        anotherMedicine.setId("A1");
        anotherMedicine.setName("Penicillin");
        anotherMedicine.setPharm("Brovafarma");
        anotherMedicine.setAnalogs("none");
        anotherMedicine.setGroup(Medicine.Group.ANTIBIOTIC);
        anotherMedicine.getVersion().setConsistence("Pills");
        anotherMedicine.getVersion().getCertificate().setNumber("1A2B");
        anotherMedicine.getVersion().getCertificate().setIssuanceDate(LocalDate.of(2019, 7, 21));
        anotherMedicine.getVersion().getCertificate().setExpirationDate(LocalDate.of(2024, 7, 21));
        anotherMedicine.getVersion().getCertificate().setOrganisation("BigAndHealthy");
        anotherMedicine.getVersion().getPack().setType("Plastic");
        anotherMedicine.getVersion().getPack().setQuantity(24);
        anotherMedicine.getVersion().getPack().setPrice(109.5f);
        anotherMedicine.getVersion().getDosage().setDose(0.5f);
        anotherMedicine.getVersion().getDosage().setRegularity(2);


        List<Medicine> expectedMedicines = new ArrayList<>();
        expectedMedicines.add(anotherMedicine);
        expectedMedicines.add(medicine);

        List<Medicine> medicineArray = new ArrayList<>(medicines);
        medicineArray.sort(new MedicineComparator());

        Assert.assertEquals(medicineArray, expectedMedicines);
    }

    @Test
    public void objectTest(){
        Medicine medicine = new Medicine("Default");

        Medicine anotherMedicine = new Medicine("Default");

        Assert.assertEquals(medicine, anotherMedicine);
    }
}
