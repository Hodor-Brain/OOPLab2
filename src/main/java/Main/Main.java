package Main;

import Builders.AbstractMedicinesBuilder;
import Builders.MedicineBuilderFactory;

public class Main {
    public static void main(String[] args) {
        String type = "sax";
        AbstractMedicinesBuilder builder = MedicineBuilderFactory.createMedicineBuilder(type);
        builder.buildSetMedicines("src/main/java/Xml/medicines.xml");
        System.out.println(builder.getMedicines());
    }
}
